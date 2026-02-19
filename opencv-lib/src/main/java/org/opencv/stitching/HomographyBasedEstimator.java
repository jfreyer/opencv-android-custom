//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.stitching;

import org.opencv.stitching.Estimator;

// C++: class HomographyBasedEstimator
/**
 * Homography based rotation estimator.
 */
public class HomographyBasedEstimator extends Estimator {

    protected HomographyBasedEstimator(long addr) { super(addr); }

    // internal usage only
    public static HomographyBasedEstimator __fromPtr__(long addr) { return new HomographyBasedEstimator(addr); }

    //
    // C++:   cv::detail::HomographyBasedEstimator::HomographyBasedEstimator(bool is_focals_estimated = false)
    //

    public HomographyBasedEstimator(boolean is_focals_estimated) {
        super(HomographyBasedEstimator_0(is_focals_estimated));
    }

    public HomographyBasedEstimator() {
        super(HomographyBasedEstimator_1());
    }


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // C++:   cv::detail::HomographyBasedEstimator::HomographyBasedEstimator(bool is_focals_estimated = false)
    private static native long HomographyBasedEstimator_0(boolean is_focals_estimated);
    private static native long HomographyBasedEstimator_1();

    // native support for java finalize()
    private static native void delete(long nativeObj);

}
