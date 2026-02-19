//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.stitching;

import org.opencv.stitching.BundleAdjusterBase;

// C++: class BundleAdjusterReproj
/**
 * Implementation of the camera parameters refinement algorithm which minimizes sum of the reprojection
 * error squares
 *
 * It can estimate focal length, aspect ratio, principal point.
 * You can affect only on them via the refinement mask.
 */
public class BundleAdjusterReproj extends BundleAdjusterBase {

    protected BundleAdjusterReproj(long addr) { super(addr); }

    // internal usage only
    public static BundleAdjusterReproj __fromPtr__(long addr) { return new BundleAdjusterReproj(addr); }

    //
    // C++:   cv::detail::BundleAdjusterReproj::BundleAdjusterReproj()
    //

    public BundleAdjusterReproj() {
        super(BundleAdjusterReproj_0());
    }


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // C++:   cv::detail::BundleAdjusterReproj::BundleAdjusterReproj()
    private static native long BundleAdjusterReproj_0();

    // native support for java finalize()
    private static native void delete(long nativeObj);

}
