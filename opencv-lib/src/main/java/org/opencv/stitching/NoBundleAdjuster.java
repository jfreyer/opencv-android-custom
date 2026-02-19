//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.stitching;

import org.opencv.stitching.BundleAdjusterBase;

// C++: class NoBundleAdjuster
/**
 * Stub bundle adjuster that does nothing.
 */
public class NoBundleAdjuster extends BundleAdjusterBase {

    protected NoBundleAdjuster(long addr) { super(addr); }

    // internal usage only
    public static NoBundleAdjuster __fromPtr__(long addr) { return new NoBundleAdjuster(addr); }

    //
    // C++:   cv::detail::NoBundleAdjuster::NoBundleAdjuster()
    //

    public NoBundleAdjuster() {
        super(NoBundleAdjuster_0());
    }


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // C++:   cv::detail::NoBundleAdjuster::NoBundleAdjuster()
    private static native long NoBundleAdjuster_0();

    // native support for java finalize()
    private static native void delete(long nativeObj);

}
