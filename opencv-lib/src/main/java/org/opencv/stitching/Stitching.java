//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.stitching;

import java.util.ArrayList;
import java.util.List;
import org.opencv.core.Mat;
import org.opencv.core.MatOfInt;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Size;
import org.opencv.features2d.Feature2D;
import org.opencv.stitching.ImageFeatures;
import org.opencv.stitching.MatchesInfo;
import org.opencv.utils.Converters;

// C++: class Stitching

public class Stitching {

    // C++: enum CostType (cv.detail.GraphCutSeamFinderBase.CostType)
    public static final int
            GraphCutSeamFinderBase_COST_COLOR = 0,
            GraphCutSeamFinderBase_COST_COLOR_GRAD = 1;


    // C++: enum WaveCorrectKind (cv.detail.WaveCorrectKind)
    public static final int
            WAVE_CORRECT_HORIZ = 0,
            WAVE_CORRECT_VERT = 1,
            WAVE_CORRECT_AUTO = 2;


    //
    // C++:  void cv::detail::focalsFromHomography(Mat H, double f0, double f1, bool f0_ok, bool f1_ok)
    //

    /**
     * Tries to estimate focal lengths from the given homography under the assumption that the camera
     * undergoes rotations around its centre only.
     *
     * @param H Homography.
     * @param f0 Estimated focal length along X axis.
     * @param f1 Estimated focal length along Y axis.
     * @param f0_ok True, if f0 was estimated successfully, false otherwise.
     * @param f1_ok True, if f1 was estimated successfully, false otherwise.
     *
     * See "Construction of Panoramic Image Mosaics with Global and Local Alignment"
     * by Heung-Yeung Shum and Richard Szeliski.
     */
    public static void focalsFromHomography(Mat H, double f0, double f1, boolean f0_ok, boolean f1_ok) {
        focalsFromHomography_0(H.nativeObj, f0, f1, f0_ok, f1_ok);
    }


    //
    // C++:  bool cv::detail::calibrateRotatingCamera(vector_Mat Hs, Mat& K)
    //

    /**
     * Estimates focal lengths for each given camera.
     *
     * @param Hs automatically generated
     * @param K automatically generated
     * @return automatically generated
     */
    public static boolean calibrateRotatingCamera(List<Mat> Hs, Mat K) {
        Mat Hs_mat = Converters.vector_Mat_to_Mat(Hs);
        return calibrateRotatingCamera_0(Hs_mat.nativeObj, K.nativeObj);
    }


    //
    // C++:  void cv::detail::normalizeUsingWeightMap(Mat weight, Mat& src)
    //

    public static void normalizeUsingWeightMap(Mat weight, Mat src) {
        normalizeUsingWeightMap_0(weight.nativeObj, src.nativeObj);
    }


    //
    // C++:  void cv::detail::createWeightMap(Mat mask, float sharpness, Mat& weight)
    //

    public static void createWeightMap(Mat mask, float sharpness, Mat weight) {
        createWeightMap_0(mask.nativeObj, sharpness, weight.nativeObj);
    }


    //
    // C++:  void cv::detail::createLaplacePyr(Mat img, int num_levels, vector_UMat& pyr)
    //

    // Unknown type 'vector_UMat' (IO), skipping the function


    //
    // C++:  void cv::detail::createLaplacePyrGpu(Mat img, int num_levels, vector_UMat& pyr)
    //

    // Unknown type 'vector_UMat' (IO), skipping the function


    //
    // C++:  void cv::detail::restoreImageFromLaplacePyr(vector_UMat& pyr)
    //

    // Unknown type 'vector_UMat' (IO), skipping the function


    //
    // C++:  void cv::detail::restoreImageFromLaplacePyrGpu(vector_UMat& pyr)
    //

    // Unknown type 'vector_UMat' (IO), skipping the function


    //
    // C++:  bool cv::detail::overlapRoi(Point tl1, Point tl2, Size sz1, Size sz2, Rect roi)
    //

    public static boolean overlapRoi(Point tl1, Point tl2, Size sz1, Size sz2, Rect roi) {
        return overlapRoi_0(tl1.x, tl1.y, tl2.x, tl2.y, sz1.width, sz1.height, sz2.width, sz2.height, roi.x, roi.y, roi.width, roi.height);
    }


    //
    // C++:  Rect cv::detail::resultRoi(vector_Point corners, vector_UMat images)
    //

    // Unknown type 'vector_UMat' (I), skipping the function


    //
    // C++:  Rect cv::detail::resultRoi(vector_Point corners, vector_Size sizes)
    //

    // Unknown type 'vector_Size' (I), skipping the function


    //
    // C++:  Rect cv::detail::resultRoiIntersection(vector_Point corners, vector_Size sizes)
    //

    // Unknown type 'vector_Size' (I), skipping the function


    //
    // C++:  Point cv::detail::resultTl(vector_Point corners)
    //

    public static Point resultTl(MatOfPoint corners) {
        Mat corners_mat = corners;
        return new Point(resultTl_0(corners_mat.nativeObj));
    }


    //
    // C++:  void cv::detail::selectRandomSubset(int count, int size, vector_int subset)
    //

    public static void selectRandomSubset(int count, int size, MatOfInt subset) {
        Mat subset_mat = subset;
        selectRandomSubset_0(count, size, subset_mat.nativeObj);
    }


    //
    // C++:  int cv::detail::stitchingLogLevel()
    //

    public static int stitchingLogLevel() {
        return stitchingLogLevel_0();
    }


    //
    // C++:  void cv::detail::computeImageFeatures(Ptr_Feature2D featuresFinder, vector_Mat images, vector_ImageFeatures& features, vector_Mat masks = vector_Mat())
    //

    // Unknown type 'vector_ImageFeatures' (O), skipping the function


    //
    // C++:  void cv::detail::computeImageFeatures(Ptr_Feature2D featuresFinder, Mat image, ImageFeatures& features, Mat mask = Mat())
    //

    /**
     * @brief
     *
     * @param featuresFinder
     * @param image
     * @param features
     * @param mask
     */
    public static void computeImageFeatures2(Feature2D featuresFinder, Mat image, ImageFeatures features, Mat mask) {
        computeImageFeatures2_0(featuresFinder.getNativeObjAddr(), image.nativeObj, features.nativeObj, mask.nativeObj);
    }

    /**
     * @brief
     *
     * @param featuresFinder
     * @param image
     * @param features
     */
    public static void computeImageFeatures2(Feature2D featuresFinder, Mat image, ImageFeatures features) {
        computeImageFeatures2_1(featuresFinder.getNativeObjAddr(), image.nativeObj, features.nativeObj);
    }


    //
    // C++:  void cv::detail::FeaturesMatcher::operator ()(ImageFeatures features1, ImageFeatures features2, MatchesInfo& matches_info)
    //

    /**
     *
     *     @param features1 First image features
     *     @param features2 Second image features
     *     @param matches_info Found matches
     */
    public static void apply(ImageFeatures features1, ImageFeatures features2, MatchesInfo matches_info) {
        apply_0(features1.nativeObj, features2.nativeObj, matches_info.nativeObj);
    }


    //
    // C++:  void cv::detail::FeaturesMatcher::operator ()(vector_ImageFeatures features, vector_MatchesInfo& pairwise_matches, UMat mask = cv::UMat())
    //

    // Unknown type 'vector_ImageFeatures' (I), skipping the function


    //
    // C++:  bool cv::detail::Estimator::operator ()(vector_ImageFeatures features, vector_MatchesInfo pairwise_matches, vector_CameraParams& cameras)
    //

    // Unknown type 'vector_ImageFeatures' (I), skipping the function


    //
    // C++:  void cv::detail::waveCorrect(vector_Mat& rmats, WaveCorrectKind kind)
    //

    // Unknown type 'WaveCorrectKind' (I), skipping the function


    //
    // C++:  String cv::detail::matchesGraphAsString(vector_String paths, vector_MatchesInfo pairwise_matches, float conf_threshold)
    //

    // Unknown type 'vector_MatchesInfo' (I), skipping the function


    //
    // C++:  vector_int cv::detail::leaveBiggestComponent(vector_ImageFeatures features, vector_MatchesInfo pairwise_matches, float conf_threshold)
    //

    // Unknown type 'vector_ImageFeatures' (I), skipping the function




    // C++:  void cv::detail::focalsFromHomography(Mat H, double f0, double f1, bool f0_ok, bool f1_ok)
    private static native void focalsFromHomography_0(long H_nativeObj, double f0, double f1, boolean f0_ok, boolean f1_ok);

    // C++:  bool cv::detail::calibrateRotatingCamera(vector_Mat Hs, Mat& K)
    private static native boolean calibrateRotatingCamera_0(long Hs_mat_nativeObj, long K_nativeObj);

    // C++:  void cv::detail::normalizeUsingWeightMap(Mat weight, Mat& src)
    private static native void normalizeUsingWeightMap_0(long weight_nativeObj, long src_nativeObj);

    // C++:  void cv::detail::createWeightMap(Mat mask, float sharpness, Mat& weight)
    private static native void createWeightMap_0(long mask_nativeObj, float sharpness, long weight_nativeObj);

    // C++:  bool cv::detail::overlapRoi(Point tl1, Point tl2, Size sz1, Size sz2, Rect roi)
    private static native boolean overlapRoi_0(double tl1_x, double tl1_y, double tl2_x, double tl2_y, double sz1_width, double sz1_height, double sz2_width, double sz2_height, int roi_x, int roi_y, int roi_width, int roi_height);

    // C++:  Point cv::detail::resultTl(vector_Point corners)
    private static native double[] resultTl_0(long corners_mat_nativeObj);

    // C++:  void cv::detail::selectRandomSubset(int count, int size, vector_int subset)
    private static native void selectRandomSubset_0(int count, int size, long subset_mat_nativeObj);

    // C++:  int cv::detail::stitchingLogLevel()
    private static native int stitchingLogLevel_0();

    // C++:  void cv::detail::computeImageFeatures(Ptr_Feature2D featuresFinder, Mat image, ImageFeatures& features, Mat mask = Mat())
    private static native void computeImageFeatures2_0(long featuresFinder_nativeObj, long image_nativeObj, long features_nativeObj, long mask_nativeObj);
    private static native void computeImageFeatures2_1(long featuresFinder_nativeObj, long image_nativeObj, long features_nativeObj);

    // C++:  void cv::detail::FeaturesMatcher::operator ()(ImageFeatures features1, ImageFeatures features2, MatchesInfo& matches_info)
    private static native void apply_0(long features1_nativeObj, long features2_nativeObj, long matches_info_nativeObj);

}
