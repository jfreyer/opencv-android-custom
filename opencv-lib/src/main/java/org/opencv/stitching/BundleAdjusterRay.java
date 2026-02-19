//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.stitching;

import org.opencv.stitching.BundleAdjusterBase;

// C++: class BundleAdjusterRay
/**
 * Implementation of the camera parameters refinement algorithm which minimizes sum of the distances
 * between the rays passing through the camera center and a feature. :
 *
 * It can estimate focal length. It ignores the refinement mask for now.
 */
public class BundleAdjusterRay extends BundleAdjusterBase {

    protected BundleAdjusterRay(long addr) { super(addr); }

    // internal usage only
    public static BundleAdjusterRay __fromPtr__(long addr) { return new BundleAdjusterRay(addr); }

    //
    // C++:   cv::detail::BundleAdjusterRay::BundleAdjusterRay()
    //

    public BundleAdjusterRay() {
        super(BundleAdjusterRay_0());
    }


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // C++:   cv::detail::BundleAdjusterRay::BundleAdjusterRay()
    private static native long BundleAdjusterRay_0();

    // native support for java finalize()
    private static native void delete(long nativeObj);

}
