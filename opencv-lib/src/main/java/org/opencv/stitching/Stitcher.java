//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.stitching;

import org.opencv.features2d.Feature2D;
import org.opencv.stitching.Stitcher;
import org.opencv.stitching.WarperCreator;

// C++: class Stitcher
/**
 * High level image stitcher.
 *
 * It's possible to use this class without being aware of the entire stitching pipeline. However, to
 * be able to achieve higher stitching stability and quality of the final images at least being
 * familiar with the theory is recommended.
 *
 * <b>Note:</b>
 * <ul>
 *   <li>
 *    A basic example on image stitching can be found at
 *     opencv_source_code/samples/cpp/stitching.cpp
 *   </li>
 *   <li>
 *    A basic example on image stitching in Python can be found at
 *     opencv_source_code/samples/python/stitching.py
 *   </li>
 *   <li>
 *    A detailed example on image stitching can be found at
 *     opencv_source_code/samples/cpp/stitching_detailed.cpp
 *   </li>
 * </ul>
 */
public class Stitcher {

    protected final long nativeObj;
    protected Stitcher(long addr) { nativeObj = addr; }

    public long getNativeObjAddr() { return nativeObj; }

    // internal usage only
    public static Stitcher __fromPtr__(long addr) { return new Stitcher(addr); }

    // C++: enum Mode (cv.Stitcher.Mode)
    public static final int
            PANORAMA = 0,
            SCANS = 1;


    // C++: enum Status (cv.Stitcher.Status)
    public static final int
            OK = 0,
            ERR_NEED_MORE_IMGS = 1,
            ERR_HOMOGRAPHY_EST_FAIL = 2,
            ERR_CAMERA_PARAMS_ADJUST_FAIL = 3;


    //
    // C++: static Ptr_Stitcher cv::Stitcher::create(Mode mode = Stitcher::PANORAMA)
    //

    /**
     * Creates a Stitcher configured in one of the stitching modes.
     *
     *     to stitch and their transformation. Default parameters will be chosen for operation in given
     *     scenario.
     *     @return Stitcher class instance.
     */
    public static Stitcher create() {
        return Stitcher.__fromPtr__(create_0());
    }


    //
    // C++:  double cv::Stitcher::registrationResol()
    //

    public double registrationResol() {
        return registrationResol_0(nativeObj);
    }


    //
    // C++:  void cv::Stitcher::setRegistrationResol(double resol_mpx)
    //

    public void setRegistrationResol(double resol_mpx) {
        setRegistrationResol_0(nativeObj, resol_mpx);
    }


    //
    // C++:  double cv::Stitcher::seamEstimationResol()
    //

    public double seamEstimationResol() {
        return seamEstimationResol_0(nativeObj);
    }


    //
    // C++:  void cv::Stitcher::setSeamEstimationResol(double resol_mpx)
    //

    public void setSeamEstimationResol(double resol_mpx) {
        setSeamEstimationResol_0(nativeObj, resol_mpx);
    }


    //
    // C++:  double cv::Stitcher::compositingResol()
    //

    public double compositingResol() {
        return compositingResol_0(nativeObj);
    }


    //
    // C++:  void cv::Stitcher::setCompositingResol(double resol_mpx)
    //

    public void setCompositingResol(double resol_mpx) {
        setCompositingResol_0(nativeObj, resol_mpx);
    }


    //
    // C++:  double cv::Stitcher::panoConfidenceThresh()
    //

    public double panoConfidenceThresh() {
        return panoConfidenceThresh_0(nativeObj);
    }


    //
    // C++:  void cv::Stitcher::setPanoConfidenceThresh(double conf_thresh)
    //

    public void setPanoConfidenceThresh(double conf_thresh) {
        setPanoConfidenceThresh_0(nativeObj, conf_thresh);
    }


    //
    // C++:  bool cv::Stitcher::waveCorrection()
    //

    public boolean waveCorrection() {
        return waveCorrection_0(nativeObj);
    }


    //
    // C++:  void cv::Stitcher::setWaveCorrection(bool flag)
    //

    public void setWaveCorrection(boolean flag) {
        setWaveCorrection_0(nativeObj, flag);
    }


    //
    // C++:  InterpolationFlags cv::Stitcher::interpolationFlags()
    //

    public int interpolationFlags() {
        return interpolationFlags_0(nativeObj);
    }


    //
    // C++:  void cv::Stitcher::setInterpolationFlags(InterpolationFlags interp_flags)
    //

    public void setInterpolationFlags(int interp_flags) {
        setInterpolationFlags_0(nativeObj, interp_flags);
    }


    //
    // C++:  detail_WaveCorrectKind cv::Stitcher::waveCorrectKind()
    //

    public int waveCorrectKind() {
        return waveCorrectKind_0(nativeObj);
    }


    //
    // C++:  void cv::Stitcher::setWaveCorrectKind(detail_WaveCorrectKind kind)
    //

    public void setWaveCorrectKind(int kind) {
        setWaveCorrectKind_0(nativeObj, kind);
    }


    //
    // C++:  Ptr_Feature2D cv::Stitcher::featuresFinder()
    //

    public Feature2D featuresFinder() {
        return Feature2D.__fromPtr__(featuresFinder_0(nativeObj));
    }


    //
    // C++:  void cv::Stitcher::setFeaturesFinder(Ptr_Feature2D features_finder)
    //

    public void setFeaturesFinder(Feature2D features_finder) {
        setFeaturesFinder_0(nativeObj, features_finder.getNativeObjAddr());
    }


    //
    // C++:  Ptr_detail_FeaturesMatcher cv::Stitcher::featuresMatcher()
    //

    // Return type 'Ptr_detail_FeaturesMatcher' is not supported, skipping the function


    //
    // C++:  void cv::Stitcher::setFeaturesMatcher(Ptr_detail_FeaturesMatcher features_matcher)
    //

    // Unknown type 'Ptr_detail_FeaturesMatcher' (I), skipping the function


    //
    // C++:  Ptr_detail_BundleAdjusterBase cv::Stitcher::bundleAdjuster()
    //

    // Return type 'Ptr_detail_BundleAdjusterBase' is not supported, skipping the function


    //
    // C++:  void cv::Stitcher::setBundleAdjuster(Ptr_detail_BundleAdjusterBase bundle_adjuster)
    //

    // Unknown type 'Ptr_detail_BundleAdjusterBase' (I), skipping the function


    //
    // C++:  Ptr_detail_Estimator cv::Stitcher::estimator()
    //

    // Return type 'Ptr_detail_Estimator' is not supported, skipping the function


    //
    // C++:  void cv::Stitcher::setEstimator(Ptr_detail_Estimator estimator)
    //

    // Unknown type 'Ptr_detail_Estimator' (I), skipping the function


    //
    // C++:  Ptr_WarperCreator cv::Stitcher::warper()
    //

    public WarperCreator warper() {
        return WarperCreator.__fromPtr__(warper_0(nativeObj));
    }


    //
    // C++:  void cv::Stitcher::setWarper(Ptr_WarperCreator creator)
    //

    public void setWarper(WarperCreator creator) {
        setWarper_0(nativeObj, creator.getNativeObjAddr());
    }


    //
    // C++:  Ptr_detail_ExposureCompensator cv::Stitcher::exposureCompensator()
    //

    // Return type 'Ptr_detail_ExposureCompensator' is not supported, skipping the function


    //
    // C++:  void cv::Stitcher::setExposureCompensator(Ptr_detail_ExposureCompensator exposure_comp)
    //

    // Unknown type 'Ptr_detail_ExposureCompensator' (I), skipping the function


    //
    // C++:  Ptr_detail_SeamFinder cv::Stitcher::seamFinder()
    //

    // Return type 'Ptr_detail_SeamFinder' is not supported, skipping the function


    //
    // C++:  void cv::Stitcher::setSeamFinder(Ptr_detail_SeamFinder seam_finder)
    //

    // Unknown type 'Ptr_detail_SeamFinder' (I), skipping the function


    //
    // C++:  Ptr_detail_Blender cv::Stitcher::blender()
    //

    // Return type 'Ptr_detail_Blender' is not supported, skipping the function


    //
    // C++:  void cv::Stitcher::setBlender(Ptr_detail_Blender b)
    //

    // Unknown type 'Ptr_detail_Blender' (I), skipping the function


    //
    // C++:  Status cv::Stitcher::estimateTransform(vector_Mat images, vector_Mat masks = vector_Mat())
    //

    // Return type 'Status' is not supported, skipping the function


    //
    // C++:  Status cv::Stitcher::composePanorama(Mat& pano)
    //

    // Return type 'Status' is not supported, skipping the function


    //
    // C++:  Status cv::Stitcher::composePanorama(vector_Mat images, Mat& pano)
    //

    // Return type 'Status' is not supported, skipping the function


    //
    // C++:  Status cv::Stitcher::stitch(vector_Mat images, Mat& pano)
    //

    // Return type 'Status' is not supported, skipping the function


    //
    // C++:  Status cv::Stitcher::stitch(vector_Mat images, vector_Mat masks, Mat& pano)
    //

    // Return type 'Status' is not supported, skipping the function


    //
    // C++:  double cv::Stitcher::workScale()
    //

    public double workScale() {
        return workScale_0(nativeObj);
    }


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // C++: static Ptr_Stitcher cv::Stitcher::create(Mode mode = Stitcher::PANORAMA)
    private static native long create_0();

    // C++:  double cv::Stitcher::registrationResol()
    private static native double registrationResol_0(long nativeObj);

    // C++:  void cv::Stitcher::setRegistrationResol(double resol_mpx)
    private static native void setRegistrationResol_0(long nativeObj, double resol_mpx);

    // C++:  double cv::Stitcher::seamEstimationResol()
    private static native double seamEstimationResol_0(long nativeObj);

    // C++:  void cv::Stitcher::setSeamEstimationResol(double resol_mpx)
    private static native void setSeamEstimationResol_0(long nativeObj, double resol_mpx);

    // C++:  double cv::Stitcher::compositingResol()
    private static native double compositingResol_0(long nativeObj);

    // C++:  void cv::Stitcher::setCompositingResol(double resol_mpx)
    private static native void setCompositingResol_0(long nativeObj, double resol_mpx);

    // C++:  double cv::Stitcher::panoConfidenceThresh()
    private static native double panoConfidenceThresh_0(long nativeObj);

    // C++:  void cv::Stitcher::setPanoConfidenceThresh(double conf_thresh)
    private static native void setPanoConfidenceThresh_0(long nativeObj, double conf_thresh);

    // C++:  bool cv::Stitcher::waveCorrection()
    private static native boolean waveCorrection_0(long nativeObj);

    // C++:  void cv::Stitcher::setWaveCorrection(bool flag)
    private static native void setWaveCorrection_0(long nativeObj, boolean flag);

    // C++:  InterpolationFlags cv::Stitcher::interpolationFlags()
    private static native int interpolationFlags_0(long nativeObj);

    // C++:  void cv::Stitcher::setInterpolationFlags(InterpolationFlags interp_flags)
    private static native void setInterpolationFlags_0(long nativeObj, int interp_flags);

    // C++:  detail_WaveCorrectKind cv::Stitcher::waveCorrectKind()
    private static native int waveCorrectKind_0(long nativeObj);

    // C++:  void cv::Stitcher::setWaveCorrectKind(detail_WaveCorrectKind kind)
    private static native void setWaveCorrectKind_0(long nativeObj, int kind);

    // C++:  Ptr_Feature2D cv::Stitcher::featuresFinder()
    private static native long featuresFinder_0(long nativeObj);

    // C++:  void cv::Stitcher::setFeaturesFinder(Ptr_Feature2D features_finder)
    private static native void setFeaturesFinder_0(long nativeObj, long features_finder_nativeObj);

    // C++:  Ptr_WarperCreator cv::Stitcher::warper()
    private static native long warper_0(long nativeObj);

    // C++:  void cv::Stitcher::setWarper(Ptr_WarperCreator creator)
    private static native void setWarper_0(long nativeObj, long creator_nativeObj);

    // C++:  double cv::Stitcher::workScale()
    private static native double workScale_0(long nativeObj);

    // native support for java finalize()
    private static native void delete(long nativeObj);

}
