//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.stitching;

import org.opencv.stitching.Estimator;

// C++: class AffineBasedEstimator
/**
 * Affine transformation based estimator.
 *
 * This estimator uses pairwise transformations estimated by matcher to estimate
 * final transformation for each camera.
 *
 * SEE: cv::detail::HomographyBasedEstimator
 */
public class AffineBasedEstimator extends Estimator {

    protected AffineBasedEstimator(long addr) { super(addr); }

    // internal usage only
    public static AffineBasedEstimator __fromPtr__(long addr) { return new AffineBasedEstimator(addr); }

    //
    // C++:   cv::detail::AffineBasedEstimator::AffineBasedEstimator()
    //

    public AffineBasedEstimator() {
        super(AffineBasedEstimator_0());
    }


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // C++:   cv::detail::AffineBasedEstimator::AffineBasedEstimator()
    private static native long AffineBasedEstimator_0();

    // native support for java finalize()
    private static native void delete(long nativeObj);

}
