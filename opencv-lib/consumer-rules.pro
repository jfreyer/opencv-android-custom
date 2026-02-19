# OpenCV Android - keep all public API classes
-keep class org.opencv.** { *; }
-keep class org.opencv.core.** { *; }
-keep class org.opencv.imgproc.** { *; }
-keep class org.opencv.imgcodecs.** { *; }
-keep class org.opencv.features2d.** { *; }
-keep class org.opencv.calib3d.** { *; }
-keep class org.opencv.stitching.** { *; }

# Keep native methods
-keepclasseswithmembers class * {
    native <methods>;
}
