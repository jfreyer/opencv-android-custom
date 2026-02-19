//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.stitching;

import org.opencv.stitching.BundleAdjusterBase;

// C++: class BundleAdjusterAffinePartial
/**
 * Bundle adjuster that expects affine transformation with 4 DOF
 * represented in homogeneous coordinates in R for each camera param. Implements
 * camera parameters refinement algorithm which minimizes sum of the reprojection
 * error squares
 *
 * It estimates all transformation parameters. Refinement mask is ignored.
 *
 * SEE: AffineBasedEstimator AffineBestOf2NearestMatcher BundleAdjusterAffine
 */
public class BundleAdjusterAffinePartial extends BundleAdjusterBase {

    protected BundleAdjusterAffinePartial(long addr) { super(addr); }

    // internal usage only
    public static BundleAdjusterAffinePartial __fromPtr__(long addr) { return new BundleAdjusterAffinePartial(addr); }

    //
    // C++:   cv::detail::BundleAdjusterAffinePartial::BundleAdjusterAffinePartial()
    //

    public BundleAdjusterAffinePartial() {
        super(BundleAdjusterAffinePartial_0());
    }


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // C++:   cv::detail::BundleAdjusterAffinePartial::BundleAdjusterAffinePartial()
    private static native long BundleAdjusterAffinePartial_0();

    // native support for java finalize()
    private static native void delete(long nativeObj);

}
