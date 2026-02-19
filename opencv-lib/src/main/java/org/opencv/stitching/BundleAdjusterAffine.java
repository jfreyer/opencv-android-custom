//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.stitching;

import org.opencv.stitching.BundleAdjusterBase;

// C++: class BundleAdjusterAffine
/**
 * Bundle adjuster that expects affine transformation
 * represented in homogeneous coordinates in R for each camera param. Implements
 * camera parameters refinement algorithm which minimizes sum of the reprojection
 * error squares
 *
 * It estimates all transformation parameters. Refinement mask is ignored.
 *
 * SEE: AffineBasedEstimator AffineBestOf2NearestMatcher BundleAdjusterAffinePartial
 */
public class BundleAdjusterAffine extends BundleAdjusterBase {

    protected BundleAdjusterAffine(long addr) { super(addr); }

    // internal usage only
    public static BundleAdjusterAffine __fromPtr__(long addr) { return new BundleAdjusterAffine(addr); }

    //
    // C++:   cv::detail::BundleAdjusterAffine::BundleAdjusterAffine()
    //

    public BundleAdjusterAffine() {
        super(BundleAdjusterAffine_0());
    }


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // C++:   cv::detail::BundleAdjusterAffine::BundleAdjusterAffine()
    private static native long BundleAdjusterAffine_0();

    // native support for java finalize()
    private static native void delete(long nativeObj);

}
