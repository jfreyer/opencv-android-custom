//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.stitching;

import org.opencv.core.Mat;
import org.opencv.core.TermCriteria;
import org.opencv.stitching.Estimator;

// C++: class BundleAdjusterBase
/**
 * Base class for all camera parameters refinement methods.
 */
public class BundleAdjusterBase extends Estimator {

    protected BundleAdjusterBase(long addr) { super(addr); }

    // internal usage only
    public static BundleAdjusterBase __fromPtr__(long addr) { return new BundleAdjusterBase(addr); }

    //
    // C++:  Mat cv::detail::BundleAdjusterBase::refinementMask()
    //

    public Mat refinementMask() {
        return new Mat(refinementMask_0(nativeObj));
    }


    //
    // C++:  void cv::detail::BundleAdjusterBase::setRefinementMask(Mat mask)
    //

    public void setRefinementMask(Mat mask) {
        setRefinementMask_0(nativeObj, mask.nativeObj);
    }


    //
    // C++:  double cv::detail::BundleAdjusterBase::confThresh()
    //

    public double confThresh() {
        return confThresh_0(nativeObj);
    }


    //
    // C++:  void cv::detail::BundleAdjusterBase::setConfThresh(double conf_thresh)
    //

    public void setConfThresh(double conf_thresh) {
        setConfThresh_0(nativeObj, conf_thresh);
    }


    //
    // C++:  TermCriteria cv::detail::BundleAdjusterBase::termCriteria()
    //

    public TermCriteria termCriteria() {
        return new TermCriteria(termCriteria_0(nativeObj));
    }


    //
    // C++:  void cv::detail::BundleAdjusterBase::setTermCriteria(TermCriteria term_criteria)
    //

    public void setTermCriteria(TermCriteria term_criteria) {
        setTermCriteria_0(nativeObj, term_criteria.type, term_criteria.maxCount, term_criteria.epsilon);
    }


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // C++:  Mat cv::detail::BundleAdjusterBase::refinementMask()
    private static native long refinementMask_0(long nativeObj);

    // C++:  void cv::detail::BundleAdjusterBase::setRefinementMask(Mat mask)
    private static native void setRefinementMask_0(long nativeObj, long mask_nativeObj);

    // C++:  double cv::detail::BundleAdjusterBase::confThresh()
    private static native double confThresh_0(long nativeObj);

    // C++:  void cv::detail::BundleAdjusterBase::setConfThresh(double conf_thresh)
    private static native void setConfThresh_0(long nativeObj, double conf_thresh);

    // C++:  TermCriteria cv::detail::BundleAdjusterBase::termCriteria()
    private static native double[] termCriteria_0(long nativeObj);

    // C++:  void cv::detail::BundleAdjusterBase::setTermCriteria(TermCriteria term_criteria)
    private static native void setTermCriteria_0(long nativeObj, int term_criteria_type, int term_criteria_maxCount, double term_criteria_epsilon);

    // native support for java finalize()
    private static native void delete(long nativeObj);

}
