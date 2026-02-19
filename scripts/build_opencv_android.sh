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
NDK_URL="https://dl.google.com/android/repository/android-ndk-${NDK_VERSION}-linux.zip"
ANDROID_API_LEVEL=24
PARALLEL_JOBS=$(nproc)

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(dirname "$SCRIPT_DIR")"
WORK_DIR="${SCRIPT_DIR}/work"
OPENCV_SRC="${WORK_DIR}/opencv-${OPENCV_VERSION}"
NDK_DIR="${WORK_DIR}/android-ndk-${NDK_VERSION}"

# Where to place built artifacts inside the Android library module
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

check_deps() {
    local missing=()
    for cmd in cmake ninja git unzip python3 java ant; do
        command -v "$cmd" &>/dev/null || missing+=("$cmd")
    done
    if [ ${#missing[@]} -gt 0 ]; then
        err "Missing required tools: ${missing[*]}
  sudo apt-get install -y cmake ninja-build git unzip python3 default-jdk ant"
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
    NDK_ZIP="${WORK_DIR}/android-ndk-${NDK_VERSION}-linux.zip"
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
# Step 4: PATCH — Expose stitching detail classes to Java/JNI bindings
# ──────────────────────────────────────────────────────────────────────────────
log "Applying Java binding patches..."

STITCH_HPP="$OPENCV_SRC/modules/stitching/include/opencv2/stitching.hpp"
WARPERS_HPP="$OPENCV_SRC/modules/stitching/include/opencv2/stitching/warpers.hpp"

[ -f "${STITCH_HPP}.orig" ] || cp "$STITCH_HPP" "${STITCH_HPP}.orig"
[ -f "${WARPERS_HPP}.orig" ] || cp "$WARPERS_HPP" "${WARPERS_HPP}.orig"
cp "${STITCH_HPP}.orig" "$STITCH_HPP"
cp "${WARPERS_HPP}.orig" "$WARPERS_HPP"

patch_method() {
    local file="$1" old="$2" new="$3"
    grep -qF "$old" "$file" && sed -i "s|${old}|${new}|g" "$file"
}

# ── 4a: stitching.hpp — CV_WRAP on Stitcher setters + const getters ──

patch_method "$STITCH_HPP" \
    "    detail::WaveCorrectKind waveCorrectKind() const" \
    "    CV_WRAP detail::WaveCorrectKind waveCorrectKind() const"
patch_method "$STITCH_HPP" \
    "    void setWaveCorrectKind(detail::WaveCorrectKind kind)" \
    "    CV_WRAP void setWaveCorrectKind(detail::WaveCorrectKind kind)"

# Only wrap const getters (not non-const) to avoid Java duplicate methods
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
    sed -i "s|^${old}|${new}|" "$WARPERS_HPP"
done

log "Patches applied. Verifying..."
echo "  Setters with CV_WRAP: $(grep -c 'CV_WRAP.*void set' "$STITCH_HPP")"
echo "  CV_EXPORTS_W warper classes: $(grep -c 'class CV_EXPORTS_W.*: public WarperCreator' "$WARPERS_HPP")"

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
        -DBUILD_ANDROID_PROJECTS=ON \
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

    cmake --build "$BUILD_DIR" --config Release -j "$PARALLEL_JOBS" \
        2>&1 | tee "${BUILD_DIR}/build.log"

    cmake --install "$BUILD_DIR" --config Release \
        2>&1 | tee "${BUILD_DIR}/install.log"

    # ── Copy artifacts into the Android library module ──
    ABI_OUT="${JNILIBS_DIR}/${ABI}"
    mkdir -p "$ABI_OUT"

    # Fat shared lib
    find "$INSTALL_DIR" -name "libopencv_java4*.so" -exec cp {} "$ABI_OUT/" \;

    # c++_shared runtime
    CPP_SHARED=$(find "${NDK_DIR}" -name "libc++_shared.so" -path "*/${ABI}/*" | head -1)
    [ -n "$CPP_SHARED" ] && cp "$CPP_SHARED" "$ABI_OUT/"

    log "✓ ${ABI}: $(ls "$ABI_OUT")"
done

# ── Copy generated Java sources (identical across ABIs, use first) ──
FIRST_BUILD="${WORK_DIR}/build-${ABIS[0]}"
JAVA_GEN="${FIRST_BUILD}/modules/java_bindings_generator/gen/java"

if [ -d "$JAVA_GEN" ]; then
    log "Copying generated Java bindings..."
    rm -rf "${JAVA_SRC_DIR}/org"
    cp -r "$JAVA_GEN"/* "$JAVA_SRC_DIR/" 2>/dev/null || true

    # Also check for java sources in the android build output
    find "$FIRST_BUILD" -path "*/src/org/opencv" -type d | head -1 | while read d; do
        cp -rn "$(dirname "$d")/org" "$JAVA_SRC_DIR/" 2>/dev/null || true
    done

    JAVA_COUNT=$(find "$JAVA_SRC_DIR" -name "*.java" 2>/dev/null | wc -l)
    log "Copied $JAVA_COUNT Java source files"
else
    warn "No generated Java sources found — check build logs"
fi

# ── Verify 16KB alignment ──
log "Verifying 16KB page size alignment..."
ALIGNMENT_OK=true
for so in $(find "$JNILIBS_DIR" -name "*.so"); do
    ALIGN=$(readelf -l "$so" 2>/dev/null | grep -i "LOAD" | head -1 | awk '{print $NF}' | sed 's/0x//')
    if [ -n "$ALIGN" ]; then
        ALIGN_DEC=$((16#$ALIGN))
        if [ "$ALIGN_DEC" -ge 16384 ]; then
            echo "  ✓ $(basename "$so") ($(dirname "$so" | xargs basename)): ${ALIGN_DEC} bytes"
        else
            warn "  ✗ $(basename "$so") ($(dirname "$so" | xargs basename)): ${ALIGN_DEC} bytes — NOT 16KB aligned!"
            ALIGNMENT_OK=false
        fi
    fi
done
$ALIGNMENT_OK && log "All .so files are 16KB aligned ✓" || warn "Some .so files are NOT 16KB aligned!"

# ──────────────────────────────────────────────────────────────────────────────
# Done
# ──────────────────────────────────────────────────────────────────────────────
log "Build complete!"
echo ""
echo "Artifacts placed in:"
echo "  Native libs: ${JNILIBS_DIR}/"
echo "  Java sources: ${JAVA_SRC_DIR}/"
echo ""
echo "Next: commit and tag a release, JitPack will build the AAR automatically."
