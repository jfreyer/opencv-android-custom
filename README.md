# OpenCV Android — Patched Java Bindings

[![](https://jitpack.io/v/YOUR_USERNAME/opencv-android.svg)](https://jitpack.io/#YOUR_USERNAME/opencv-android)

OpenCV 4.10.0 for Android, published as an AAR via JitPack with:

- **Full stitching detail pipeline** exposed to Java (stock OpenCV hides the setters)
- **SIFT** feature detection
- **imread/imwrite** (JPEG, PNG, WebP, TIFF)
- **16KB page size alignment** (Android 15/16 compliant)
- **4 ABIs**: arm64-v8a, armeabi-v7a, x86, x86_64

## Usage (consumers)

### 1. Add JitPack repository

```gradle
// settings.gradle
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```

### 2. Add dependency

```gradle
// app/build.gradle
dependencies {
    implementation 'com.github.YOUR_USERNAME:opencv-android:4.10.0-1'
}
```

### 3. Load native library

```java
// In your Application class or Activity
static {
    System.loadLibrary("opencv_java4");
}
```

### 4. Use it

```java
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.features2d.SIFT;
import org.opencv.stitching.Stitcher;

// Read images
Mat img1 = Imgcodecs.imread(path1);
Mat img2 = Imgcodecs.imread(path2);

// Configure stitcher with full control over the pipeline
Stitcher stitcher = Stitcher.create(Stitcher.PANORAMA);
stitcher.setFeaturesFinder(SIFT.create());
stitcher.setFeaturesMatcher(new BestOf2NearestRangeMatcher(5, false, 0.3f, 6, 6));
stitcher.setBundleAdjuster(new BundleAdjusterRay());
stitcher.setSeamFinder(new VoronoiSeamFinder());
stitcher.setExposureCompensator(new BlocksGainCompensator(32, 32));
stitcher.setBlender(new MultiBandBlender());
stitcher.setWarper(new SphericalWarper());

// Stitch
Mat pano = new Mat();
int status = stitcher.stitch(Arrays.asList(img1, img2), pano);
```

---

## Building (maintainers)

### Option A: GitHub Actions (recommended)

1. Go to **Actions → Build OpenCV Android → Run workflow**
2. Optionally check "Create a GitHub release" and set a tag like `4.10.0-1`
3. The workflow builds all 4 ABIs, commits the artifacts, and optionally creates a release
4. JitPack automatically picks up the release tag

### Option B: Local build

**Prerequisites:**
```bash
sudo apt-get install -y cmake ninja-build git unzip python3 default-jdk ant
```

**Build:**
```bash
# Uses NDK r28b (auto-downloaded), or set your own:
# export ANDROID_NDK=/path/to/your/ndk

chmod +x scripts/build_opencv_android.sh
scripts/build_opencv_android.sh
```

This places the built `.so` files into `opencv-lib/src/main/jniLibs/` and the
generated Java sources into `opencv-lib/src/main/java/`.

**Publish:**
```bash
git add opencv-lib/src/main/
git commit -m "build: OpenCV 4.10.0 native libs + Java bindings"
git tag 4.10.0-1
git push origin main --tags
```

JitPack will build the AAR automatically when someone requests the tag.

---

## What's patched vs stock OpenCV

### Stitcher setters (not exposed in stock Java bindings)

| Method | Stock | Patched |
|---|---|---|
| `setFeaturesFinder()` | ❌ C++ only | ✅ Java |
| `setFeaturesMatcher()` | ❌ | ✅ |
| `setBundleAdjuster()` | ❌ | ✅ |
| `setEstimator()` | ❌ | ✅ |
| `setWarper()` | ❌ | ✅ |
| `setExposureCompensator()` | ❌ | ✅ |
| `setSeamFinder()` | ❌ | ✅ |
| `setBlender()` | ❌ | ✅ |

### Concrete WarperCreators (not instantiable from stock Java)

SphericalWarper, PlaneWarper, CylindricalWarper, AffineWarper,
FisheyeWarper, StereographicWarper, MercatorWarper, TransverseMercatorWarper

### Already available in stock OpenCV (no patch needed)

Stitcher.create/stitch, BestOf2NearestRangeMatcher, BundleAdjusterRay,
VoronoiSeamFinder, MultiBandBlender, BlocksGainCompensator, SIFT, etc.

---

## Migrating from ByteDeco

| ByteDeco | This library |
|---|---|
| `org.bytedeco.opencv.opencv_core.Mat` | `org.opencv.core.Mat` |
| `org.bytedeco.opencv.opencv_stitching.Stitcher` | `org.opencv.stitching.Stitcher` |
| `org.bytedeco.opencv.opencv_stitching.BestOf2NearestRangeMatcher` | `org.opencv.stitching.BestOf2NearestRangeMatcher` |
| `Loader.load(opencv_java.class)` | `System.loadLibrary("opencv_java4")` |

## Modules included

core, imgproc, imgcodecs, features2d, flann, calib3d, stitching

## License

OpenCV is released under Apache 2.0. The patches in this repository are also Apache 2.0.
