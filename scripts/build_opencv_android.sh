#!/usr/bin/env bash
#
# build_opencv_android.sh
#
# Builds OpenCV 4.10.0 for Android with:
#   - PATCHED Java bindings for full stitching detail pipeline
#   - 16KB page size alignment (Android 15/16 compliance)
#   - SIFT, imread/imwrite, full stitching pipeline
#
# Supported ABIs: arm64-v8a, armeabi-v7a, x86, x86_64
#
# Usage:
#   ./build_opencv_android.sh                      # all 4 ABIs
#   ./build_opencv_android.sh arm64-v8a             # single ABI
#   ANDROID_NDK=/path/to/ndk ./build_opencv_android.sh  # custom NDK
#
set -euo pipefail

# ──────────────────────────────────────────────────────────────────────────────
# Configuration
# ──────────────────────────────────────────────────────────────────────────────
OPENCV_VERSION="4.10.0"
NDK_VERSION="r28b"
ANDROID_API_LEVEL=24

OS_NAME="$(uname -s)"
case "$OS_NAME" in
    Linux*)  HOST_OS="linux"  ;;
    Darwin*) HOST_OS="darwin" ;;
    *)       echo "Unsupported OS: $OS_NAME"; exit 1 ;;
esac

NDK_URL="https://dl.google.com/android/repository/android-ndk-${NDK_VERSION}-${HOST_OS}.zip"

if command -v nproc &>/dev/null; then
    PARALLEL_JOBS=$(nproc)
else
    PARALLEL_JOBS=$(sysctl -n hw.ncpu 2>/dev/null || echo 4)
fi

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(dirname "$SCRIPT_DIR")"
WORK_DIR="${SCRIPT_DIR}/work"
OPENCV_SRC="${WORK_DIR}/opencv-${OPENCV_VERSION}"
NDK_DIR="${WORK_DIR}/android-ndk-${NDK_VERSION}"

LIB_MODULE="${PROJECT_ROOT}/opencv-lib"
JNILIBS_DIR="${LIB_MODULE}/src/main/jniLibs"
JAVA_SRC_DIR="${LIB_MODULE}/src/main/java"

if [ $# -gt 0 ]; then
    ABIS=("$@")
else
    ABIS=("arm64-v8a" "armeabi-v7a" "x86" "x86_64")
fi

# ──────────────────────────────────────────────────────────────────────────────
# Helpers
# ──────────────────────────────────────────────────────────────────────────────
log()  { echo -e "\n\033[1;32m>>> $*\033[0m"; }
warn() { echo -e "\n\033[1;33m!!! $*\033[0m"; }
err()  { echo -e "\n\033[1;31mERR $*\033[0m" >&2; exit 1; }

sed_i() {
    if [ "$HOST_OS" = "darwin" ]; then
        sed -i '' "$@"
    else
        sed -i "$@"
    fi
}

check_deps() {
    local missing=()
    for cmd in cmake ninja git unzip python3 java ant; do
        command -v "$cmd" &>/dev/null || missing+=("$cmd")
    done
    if [ ${#missing[@]} -gt 0 ]; then
        if [ "$HOST_OS" = "darwin" ]; then
            err "Missing required tools: ${missing[*]}
  brew install cmake ninja git python3 ant
  # JDK: brew install openjdk@17"
        else
            err "Missing required tools: ${missing[*]}
  sudo apt-get install -y cmake ninja-build git unzip python3 default-jdk ant"
        fi
    fi
}

# ──────────────────────────────────────────────────────────────────────────────
# Step 1: Dependencies
# ──────────────────────────────────────────────────────────────────────────────
log "Checking host dependencies..."
check_deps
mkdir -p "$WORK_DIR"

# ──────────────────────────────────────────────────────────────────────────────
# Step 2: Android NDK
# ──────────────────────────────────────────────────────────────────────────────
if [ -n "${ANDROID_NDK:-}" ] && [ -d "$ANDROID_NDK" ]; then
    NDK_DIR="$ANDROID_NDK"
    log "Using NDK from ANDROID_NDK env: $NDK_DIR"
elif [ ! -d "$NDK_DIR" ]; then
    log "Downloading Android NDK ${NDK_VERSION}..."
    NDK_ZIP="${WORK_DIR}/android-ndk-${NDK_VERSION}-${HOST_OS}.zip"
    [ -f "$NDK_ZIP" ] || wget -q --show-progress -O "$NDK_ZIP" "$NDK_URL"
    log "Extracting NDK..."
    unzip -q "$NDK_ZIP" -d "$WORK_DIR"
    rm -f "$NDK_ZIP"
fi

[ -f "${NDK_DIR}/build/cmake/android.toolchain.cmake" ] || \
    err "NDK toolchain not found at ${NDK_DIR}/build/cmake/android.toolchain.cmake"

# ──────────────────────────────────────────────────────────────────────────────
# Step 3: OpenCV Source
# ──────────────────────────────────────────────────────────────────────────────
if [ ! -d "$OPENCV_SRC" ]; then
    log "Cloning OpenCV ${OPENCV_VERSION}..."
    git clone --depth 1 --branch "${OPENCV_VERSION}" \
        https://github.com/opencv/opencv.git "$OPENCV_SRC"
fi

# ──────────────────────────────────────────────────────────────────────────────
# Step 4: PATCH source files
# ──────────────────────────────────────────────────────────────────────────────
log "Applying source patches..."

STITCH_HPP="$OPENCV_SRC/modules/stitching/include/opencv2/stitching.hpp"
WARPERS_HPP="$OPENCV_SRC/modules/stitching/include/opencv2/stitching/warpers.hpp"
SEAM_FINDERS_HPP="$OPENCV_SRC/modules/stitching/include/opencv2/stitching/detail/seam_finders.hpp"
STITCHING_CMAKE="$OPENCV_SRC/modules/stitching/CMakeLists.txt"
ANDROID_SDK_CMAKE="$OPENCV_SRC/modules/java/android_sdk/CMakeLists.txt"
GEN_JAVA="$OPENCV_SRC/modules/java/generator/gen_java.py"

# Restore originals if they exist, then re-patch (idempotent)
for f in "$STITCH_HPP" "$WARPERS_HPP" "$SEAM_FINDERS_HPP" "$STITCHING_CMAKE" "$ANDROID_SDK_CMAKE" "$GEN_JAVA"; do
    [ -f "${f}.orig" ] || cp "$f" "${f}.orig"
    cp "${f}.orig" "$f"
done

patch_method() {
    local file="$1" old="$2" new="$3"
    grep -qF "$old" "$file" && sed_i "s|${old}|${new}|g" "$file"
}

# ── 4a: stitching.hpp — CV_WRAP on Stitcher setters + const getters ──
patch_method "$STITCH_HPP" \
    "    detail::WaveCorrectKind waveCorrectKind() const" \
    "    CV_WRAP detail::WaveCorrectKind waveCorrectKind() const"
patch_method "$STITCH_HPP" \
    "    void setWaveCorrectKind(detail::WaveCorrectKind kind)" \
    "    CV_WRAP void setWaveCorrectKind(detail::WaveCorrectKind kind)"

for pair in \
    "Ptr<Feature2D> featuresFinder() const|void setFeaturesFinder(Ptr<Feature2D>" \
    "Ptr<detail::FeaturesMatcher> featuresMatcher() const|void setFeaturesMatcher(Ptr<detail::FeaturesMatcher>" \
    "const Ptr<detail::BundleAdjusterBase> bundleAdjuster() const|void setBundleAdjuster(Ptr<detail::BundleAdjusterBase>" \
    "const Ptr<detail::Estimator> estimator() const|void setEstimator(Ptr<detail::Estimator>" \
    "const Ptr<WarperCreator> warper() const|void setWarper(Ptr<WarperCreator>" \
    "const Ptr<detail::ExposureCompensator> exposureCompensator() const|void setExposureCompensator(Ptr<detail::ExposureCompensator>" \
    "const Ptr<detail::SeamFinder> seamFinder() const|void setSeamFinder(Ptr<detail::SeamFinder>" \
    "const Ptr<detail::Blender> blender() const|void setBlender(Ptr<detail::Blender>"
do
    getter="${pair%%|*}"
    setter="${pair##*|}"
    patch_method "$STITCH_HPP" "    $getter" "    CV_WRAP $getter"
    patch_method "$STITCH_HPP" "    $setter" "    CV_WRAP $setter"
done

# ── 4b: warpers.hpp — CV_EXPORTS_W on concrete WarperCreator subclasses ──
for warper_class in \
    "class CV_EXPORTS  PlaneWarper : public WarperCreator|class CV_EXPORTS_W PlaneWarper : public WarperCreator" \
    "class CV_EXPORTS  AffineWarper : public WarperCreator|class CV_EXPORTS_W AffineWarper : public WarperCreator" \
    "class CV_EXPORTS CylindricalWarper: public WarperCreator|class CV_EXPORTS_W CylindricalWarper: public WarperCreator" \
    "class CV_EXPORTS SphericalWarper: public WarperCreator|class CV_EXPORTS_W SphericalWarper: public WarperCreator" \
    "class CV_EXPORTS FisheyeWarper : public WarperCreator|class CV_EXPORTS_W FisheyeWarper : public WarperCreator" \
    "class CV_EXPORTS StereographicWarper: public WarperCreator|class CV_EXPORTS_W StereographicWarper: public WarperCreator" \
    "class CV_EXPORTS MercatorWarper: public WarperCreator|class CV_EXPORTS_W MercatorWarper: public WarperCreator" \
    "class CV_EXPORTS TransverseMercatorWarper: public WarperCreator|class CV_EXPORTS_W TransverseMercatorWarper: public WarperCreator"
do
    old="${warper_class%%|*}"
    new="${warper_class##*|}"
    sed_i "s|^${old}|${new}|" "$WARPERS_HPP"
done

# ── 4c: Tell CMake to wrap stitching module for Java ──
sed_i 's/WRAP python)/WRAP python java)/' "$STITCHING_CMAKE"

# ── 4f: Add CV_WRAP constructors to VoronoiSeamFinder and SphericalWarper ──
SEAM_FINDERS_HPP="$OPENCV_SRC/modules/stitching/include/opencv2/stitching/detail/seam_finders.hpp"
[ -f "${SEAM_FINDERS_HPP}.orig" ] || cp "$SEAM_FINDERS_HPP" "${SEAM_FINDERS_HPP}.orig"
cp "${SEAM_FINDERS_HPP}.orig" "$SEAM_FINDERS_HPP"

python3 - "$SEAM_FINDERS_HPP" "$WARPERS_HPP" <<'PYEOF'
import sys
seam_path, warpers_path = sys.argv[1], sys.argv[2]

# VoronoiSeamFinder — insert CV_WRAP constructor after opening brace of class body
c = open(seam_path).read()
c = c.replace(
    'class CV_EXPORTS_W VoronoiSeamFinder : public PairwiseSeamFinder\n{',
    'class CV_EXPORTS_W VoronoiSeamFinder : public PairwiseSeamFinder\n{\npublic:\n    CV_WRAP VoronoiSeamFinder() {}'
)
# If no opening brace on next line, just inject after class declaration
if 'CV_WRAP VoronoiSeamFinder' not in c:
    c = c.replace(
        'class CV_EXPORTS_W VoronoiSeamFinder : public PairwiseSeamFinder',
        'class CV_EXPORTS_W VoronoiSeamFinder : public PairwiseSeamFinder\n{\npublic:\n    CV_WRAP VoronoiSeamFinder() {}'
    )
open(seam_path, 'w').write(c)
print('  Patched VoronoiSeamFinder constructor')

# SphericalWarper — class body already exists, just add CV_WRAP constructor
c = open(warpers_path).read()
if 'CV_WRAP SphericalWarper()' not in c:
    c = c.replace(
        'class CV_EXPORTS_W SphericalWarper: public WarperCreator\n{',
        'class CV_EXPORTS_W SphericalWarper: public WarperCreator\n{\npublic:\n    CV_WRAP SphericalWarper() {}'
    )
    if 'CV_WRAP SphericalWarper()' not in c:
        # Try without newline before brace
        c = c.replace(
            'class CV_EXPORTS_W SphericalWarper: public WarperCreator\n{\npublic:',
            'class CV_EXPORTS_W SphericalWarper: public WarperCreator\n{\npublic:\n    CV_WRAP SphericalWarper() {}'
        )
open(warpers_path, 'w').write(c)
print('  Patched SphericalWarper constructor')
PYEOF

# ── 4d: Fix android_sdk CMakeLists.txt broken /opencv paths ──
python3 - "$ANDROID_SDK_CMAKE" <<'PYEOF'
import sys, re
path = sys.argv[1]
c = open(path).read()

c = c.replace('${ANDROID_BUILD_BASE_DIR}/opencv',       '${OpenCV_BINARY_DIR}/android_sdk')
c = c.replace('"${ANDROID_BUILD_BASE_DIR}"',            '"${OpenCV_BINARY_DIR}/android_sdk"')
c = c.replace('${ANDROID_TMP_INSTALL_BASE_DIR}/opencv', '${OpenCV_BINARY_DIR}/android_sdk')

c = re.sub(
    r'(add_custom_command\([^)]*COMMENT "Building OpenCV Android library project"[^)]*\))',
    r'''add_custom_command(
  OUTPUT "${OPENCV_DEPHELPER}/${the_module}_android"
  COMMAND ${CMAKE_COMMAND} -E touch "${OPENCV_DEPHELPER}/${the_module}_android"
  COMMENT "Skipping OpenCV internal Gradle build (not needed)"
)''',
    c, flags=re.DOTALL
)

open(path, 'w').write(c)
print('  Patched android_sdk CMakeLists.txt')
PYEOF

# ── 4e: Patch gen_java.py — add Ptr_detail_* type aliases + Status mapping ──
python3 - "$GEN_JAVA" <<'PYEOF'
import sys
path = sys.argv[1]
c = open(path).read()

alias_code = '''
# ── Patch: Ptr_detail_* aliases for stitching detail classes ──
# The generator registers Ptr_FeaturesMatcher etc. but Stitcher.hpp uses
# Ptr_detail_FeaturesMatcher. Add aliases so both keys resolve correctly.
_detail_aliases = [
    ("FeaturesMatcher",     "org.opencv.stitching.FeaturesMatcher"),
    ("BundleAdjusterBase",  "org.opencv.stitching.BundleAdjusterBase"),
    ("Estimator",           "org.opencv.stitching.Estimator"),
    ("ExposureCompensator", "org.opencv.stitching.ExposureCompensator"),
    ("SeamFinder",          "org.opencv.stitching.SeamFinder"),
    ("Blender",             "org.opencv.stitching.Blender"),
]
for _cls, _imp in _detail_aliases:
    _entry = {
        "j_type":   _cls,
        "jn_type":  "long",
        "jn_args":  (("__int64", ".getNativeObjAddr()"),),
        "jni_name": "*((cv::Ptr<cv::detail::"+_cls+">*)%(n)s_nativeObj)",
        "jni_type": "jlong",
        "suffix":   "J",
        "j_import": _imp,
    }
    type_dict.setdefault("Ptr_detail_" + _cls, {}).update(_entry)
    type_dict.setdefault("Ptr_" + _cls, {}).update(_entry)

# Map Stitcher::Status -> int so stitch()/estimateTransform()/composePanorama() get generated
type_dict.setdefault("Status", {}).update({
    "cast_from": "int",
    "cast_to":   "cv::Stitcher::Status",
    "j_type":    "int",
    "jn_type":   "int",
    "jni_type":  "jint",
    "suffix":    "I"
})
# ── End patch ──
'''

c = c.replace("namespaces_dict = {}", alias_code + "\nnamespaces_dict = {}")
open(path, 'w').write(c)
print('  Patched gen_java.py (Ptr_detail_* aliases + Status mapping)')
PYEOF

log "Source patches applied."
echo "  CV_WRAP setters:        $(grep -c 'CV_WRAP.*void set' "$STITCH_HPP")"
echo "  CV_EXPORTS_W warpers:   $(grep -c 'class CV_EXPORTS_W.*: public WarperCreator' "$WARPERS_HPP")"
echo "  Stitching WRAP java:    $(grep -c 'WRAP python java' "$STITCHING_CMAKE")"
echo "  android_sdk bad paths:  $(grep -c 'ANDROID_BUILD_BASE_DIR\|ANDROID_TMP_INSTALL_BASE_DIR' "$ANDROID_SDK_CMAKE" || true)"
echo "  gen_java.py patched:    $(grep -c 'Ptr_detail_' "$GEN_JAVA")"

# ──────────────────────────────────────────────────────────────────────────────
# Step 5: Build for each ABI
# ──────────────────────────────────────────────────────────────────────────────
OPENCV_MODULES="core,imgproc,imgcodecs,features2d,flann,calib3d,stitching,java"

for ABI in "${ABIS[@]}"; do
    log "Building OpenCV for ABI: ${ABI}"

    BUILD_DIR="${WORK_DIR}/build-${ABI}"
    INSTALL_DIR="${WORK_DIR}/install-${ABI}"
    rm -rf "$BUILD_DIR"
    mkdir -p "$BUILD_DIR"

    # ── Stage 1: CMake configure ──
    cmake -S "$OPENCV_SRC" -B "$BUILD_DIR" -G Ninja \
        -DCMAKE_TOOLCHAIN_FILE="${NDK_DIR}/build/cmake/android.toolchain.cmake" \
        -DANDROID_ABI="${ABI}" \
        -DANDROID_NATIVE_API_LEVEL="${ANDROID_API_LEVEL}" \
        -DANDROID_STL=c++_shared \
        -DCMAKE_BUILD_TYPE=Release \
        -DCMAKE_INSTALL_PREFIX="$INSTALL_DIR" \
        \
        -DANDROID_SUPPORT_FLEXIBLE_PAGE_SIZES=ON \
        \
        -DBUILD_LIST="${OPENCV_MODULES}" \
        \
        -DBUILD_SHARED_LIBS=OFF \
        -DBUILD_ANDROID_PROJECTS=OFF \
        -DBUILD_ANDROID_EXAMPLES=OFF \
        -DBUILD_DOCS=OFF \
        -DBUILD_TESTS=OFF \
        -DBUILD_PERF_TESTS=OFF \
        -DBUILD_EXAMPLES=OFF \
        -DBUILD_opencv_apps=OFF \
        \
        -DBUILD_FAT_JAVA_LIB=ON \
        -DBUILD_JAVA=ON \
        \
        -DANT_EXECUTABLE="$(which ant)" \
        -DWITH_OPENCL=OFF \
        -DWITH_IPP=OFF \
        -DWITH_TBB=OFF \
        -DWITH_OPENMP=ON \
        -DWITH_PTHREADS_PF=ON \
        \
        -DOPENCV_ENABLE_NONFREE=ON \
        \
        -DBUILD_ZLIB=ON \
        -DBUILD_PNG=ON \
        -DBUILD_JPEG=ON \
        -DBUILD_WEBP=ON \
        -DBUILD_TIFF=ON \
        -DBUILD_OPENJPEG=ON \
        \
        2>&1 | tee "${BUILD_DIR}/cmake_configure.log"

    # ── Stage 2: Generate Java bindings only (produces stitching.inl.hpp) ──
    log "Generating Java bindings for ${ABI}..."
    cmake --build "$BUILD_DIR" --target gen_opencv_java_source -j "$PARALLEL_JOBS" \
        2>&1 | tee "${BUILD_DIR}/build_gen.log" || true

    # ── Stage 3: Patch the generated stitching.inl.hpp ──
    # Fixes known broken auto-generated JNI wrappers (non-const ref params,
    # abstract operator()). Does NOT remove any classes.
    # Fix documented in: https://github.com/opencv/opencv/issues/18947
    STITCH_INL="${BUILD_DIR}/modules/java_bindings_generator/gen/cpp/stitching.inl.hpp"
    if [ -f "$STITCH_INL" ]; then
        log "Patching generated stitching.inl.hpp..."
        python3 - "$STITCH_INL" <<'PYEOF'
import sys, re
path = sys.argv[1]
content = open(path).read()

# Fix 1: generated typedefs use detail_X instead of detail::X
for cls in ['FeaturesMatcher', 'BundleAdjusterBase', 'Estimator',
            'ExposureCompensator', 'SeamFinder', 'Blender']:
    content = content.replace(
        f'typedef Ptr<detail_{cls}> Ptr_detail_{cls}',
        f'typedef Ptr<cv::detail::{cls}> Ptr_detail_{cls}'
    )

# Fix 2: Add create(int mode) JNI function if not already present
if 'Java_org_opencv_stitching_Stitcher_create_11' not in content:
    create_jni = '''
JNIEXPORT jlong JNICALL Java_org_opencv_stitching_Stitcher_create_11
  (JNIEnv* env, jclass , jint mode)
{
    
    jlong _retval_ = 0;
    try {
        typedef Ptr<cv::Stitcher> Ptr_Stitcher;
        Ptr_Stitcher _ptr_ = cv::Stitcher::create( (cv::Stitcher::Mode)mode );
        _retval_ = (jlong)(new Ptr_Stitcher(_ptr_));
    } catch(const std::exception &e) {
        throwJavaException(env, &e, "cv::Stitcher::create");
    } catch (...) {
        throwJavaException(env, 0, "cv::Stitcher::create");
    }
    return _retval_;
}
'''
    # Insert after the existing create_0 function
    content = re.sub(
        r'(JNIEXPORT jlong JNICALL Java_org_opencv_stitching_Stitcher_create_10.*?^})',
        r'\1\n' + create_jni,
        content, flags=re.DOTALL | re.MULTILINE
    )

# Fix 3: comment out broken JNI call sites
lines = content.splitlines(keepends=True)
out = []
for line in lines:
    stripped = line.lstrip()
    if (stripped.startswith('me->mapForward(') or
        stripped.startswith('me->mapBackward(') or
        stripped.startswith('(*me)->mapForward(') or
        stripped.startswith('(*me)->mapBackward(') or
        stripped.startswith('cv::detail::FeaturesMatcher::operator ()') or
        stripped.startswith('cv::detail::focalsFromHomography(')):
        indent = line[:len(line) - len(line.lstrip())]
        line = indent + '// ' + stripped
    out.append(line)

open(path, 'w').writelines(out)
print('  stitching.inl.hpp patched (typedef namespaces + create(mode) + broken JNI calls)')
PYEOF
    else
        warn "stitching.inl.hpp not found after gen_opencv_java_source — build may fail"
    fi

    # ── Stage 4: Full build ──
    log "Compiling for ${ABI}..."
    cmake --build "$BUILD_DIR" --config Release -j "$PARALLEL_JOBS" \
        2>&1 | tee "${BUILD_DIR}/build.log"

    cmake --install "$BUILD_DIR" --config Release \
        2>&1 | tee "${BUILD_DIR}/install.log"

    # ── Copy artifacts ──
    ABI_OUT="${JNILIBS_DIR}/${ABI}"
    mkdir -p "$ABI_OUT"

    find "$INSTALL_DIR" -name "libopencv_java4*.so" -exec cp {} "$ABI_OUT/" \;

    CPP_SHARED=$(find "${NDK_DIR}" -name "libc++_shared.so" -path "*/${ABI}/*" | head -1)
    [ -n "$CPP_SHARED" ] && cp "$CPP_SHARED" "$ABI_OUT/"

    log "✓ ${ABI}: $(ls "$ABI_OUT")"
done

# ──────────────────────────────────────────────────────────────────────────────
# Step 6: Copy generated Java sources
# ──────────────────────────────────────────────────────────────────────────────
FIRST_BUILD="${WORK_DIR}/build-${ABIS[0]}"
JAVA_GEN="${FIRST_BUILD}/modules/java_bindings_generator/gen/java"
JAVA_GEN_ANDROID="${FIRST_BUILD}/modules/java_bindings_generator/gen/android/java"

if [ -d "$JAVA_GEN" ]; then
    log "Copying generated Java bindings..."
    rm -rf "${JAVA_SRC_DIR}/org"
    cp -r "$JAVA_GEN"/* "$JAVA_SRC_DIR/" 2>/dev/null || true

    # ── Copy Android-specific sources (includes Utils.java with matToBitmap) ──
    if [ -d "$JAVA_GEN_ANDROID" ]; then
        cp -r "$JAVA_GEN_ANDROID"/* "$JAVA_SRC_DIR/" 2>/dev/null || true
        log "Copied Android-specific Java sources (Utils.java etc.)"
    else
        warn "Android Java sources not found at $JAVA_GEN_ANDROID"
    fi

    # ── Patch ORIG_RESOL into Stitcher.java (skipped by generator as constexpr double) ──
    STITCHER_JAVA="${JAVA_SRC_DIR}/org/opencv/stitching/Stitcher.java"
    if [ -f "$STITCHER_JAVA" ]; then
        python3 - "$STITCHER_JAVA" <<'PYEOF'
import sys
path = sys.argv[1]
c = open(path).read()

# Patch 1: Add ORIG_RESOL constant
if 'ORIG_RESOL' not in c:
    c = c.replace(
        '            ERR_CAMERA_PARAMS_ADJUST_FAIL = 3;',
        '            ERR_CAMERA_PARAMS_ADJUST_FAIL = 3;\n\n\n    // C++: static double cv::Stitcher::ORIG_RESOL\n    /** Corresponds to ORIG_RESOL (-1.0) — preserve original resolution */\n    public static final double ORIG_RESOL = -1.0;'
    )
    print('  Patched ORIG_RESOL into Stitcher.java')

# Patch 2: Add create(int mode) overload calling the existing create_11 JNI function
if 'create(int mode)' not in c:
    c = c.replace(
        '    public static Stitcher create() {\n        return Stitcher.__fromPtr__(create_0());\n    }',
        '    public static Stitcher create() {\n        return Stitcher.__fromPtr__(create_0());\n    }\n\n    public static Stitcher create(int mode) {\n        return Stitcher.__fromPtr__(create_11(mode));\n    }'
    )
    c = c.replace(
        '    private static native long create_0();',
        '    private static native long create_0();\n    private static native long create_11(int mode);'
    )
    print('  Patched create(int mode) into Stitcher.java')

open(path, 'w').write(c)
PYEOF
    fi

    JAVA_COUNT=$(find "$JAVA_SRC_DIR" -name "*.java" 2>/dev/null | wc -l)
    log "Copied $JAVA_COUNT Java source files"

    # Verify key stitching classes
    for cls in Stitcher SphericalWarper MultiBandBlender BestOf2NearestMatcher BestOf2NearestRangeMatcher VoronoiSeamFinder BlocksGainCompensator BundleAdjusterRay; do
        if find "$JAVA_SRC_DIR" -name "${cls}.java" | grep -q .; then
            echo "  ✓ ${cls}.java"
        else
            warn "  ✗ ${cls}.java NOT FOUND"
        fi
    done

    # Verify key Stitcher methods
    STITCHER_JAVA="${JAVA_SRC_DIR}/org/opencv/stitching/Stitcher.java"
    if [ -f "$STITCHER_JAVA" ]; then
        for method in setFeaturesMatcher setBundleAdjuster setSeamFinder setBlender setExposureCompensator setWarper stitch ORIG_RESOL; do
            if grep -q "$method" "$STITCHER_JAVA"; then
                echo "  ✓ Stitcher.$method"
            else
                warn "  ✗ Stitcher.$method NOT FOUND"
            fi
        done
    fi

    # Verify Utils.java (matToBitmap/bitmapToMat)
    if find "$JAVA_SRC_DIR" -name "Utils.java" | grep -q .; then
        echo "  ✓ Utils.java (matToBitmap/bitmapToMat)"
    else
        warn "  ✗ Utils.java NOT FOUND"
    fi
else
    warn "No generated Java sources found — check build logs"
fi

# ──────────────────────────────────────────────────────────────────────────────
# Step 7: Verify 16KB alignment
# ──────────────────────────────────────────────────────────────────────────────
log "Verifying 16KB page size alignment..."
READELF=""
if command -v readelf &>/dev/null; then
    READELF="readelf"
elif [ -d "$NDK_DIR" ]; then
    READELF=$(find "$NDK_DIR" -name "llvm-readelf" -type f | head -1)
fi

if [ -n "$READELF" ]; then
    ALIGNMENT_OK=true
    for so in $(find "$JNILIBS_DIR" -name "*.so"); do
        ALIGN=$("$READELF" -l "$so" 2>/dev/null | grep -i "LOAD" | head -1 | awk '{print $NF}' | sed 's/0x//')
        if [ -n "$ALIGN" ]; then
            ALIGN_DEC=$((16#$ALIGN))
            if [ "$ALIGN_DEC" -ge 16384 ]; then
                echo "  ✓ $(basename "$so") ($(dirname "$so" | xargs basename)): ${ALIGN_DEC} bytes"
            else
                warn "  ✗ $(basename "$so"): ${ALIGN_DEC} bytes — NOT 16KB aligned!"
                ALIGNMENT_OK=false
            fi
        fi
    done
    $ALIGNMENT_OK && log "All .so files are 16KB aligned ✓" || warn "Some .so files are NOT 16KB aligned!"
else
    warn "readelf/llvm-readelf not found — skipping alignment check."
    warn "Verify manually: llvm-readelf -l <file>.so | grep LOAD"
fi

# ──────────────────────────────────────────────────────────────────────────────
# Done
# ──────────────────────────────────────────────────────────────────────────────
log "Build complete!"
echo ""
echo "Artifacts placed in:"
echo "  Native libs:  ${JNILIBS_DIR}/"
echo "  Java sources: ${JAVA_SRC_DIR}/"
echo ""
echo "Next: commit and tag a release, JitPack will build the AAR automatically."