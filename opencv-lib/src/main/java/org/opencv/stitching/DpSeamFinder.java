//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.stitching;

import org.opencv.stitching.SeamFinder;

// C++: class DpSeamFinder

public class DpSeamFinder extends SeamFinder {

    protected DpSeamFinder(long addr) { super(addr); }

    // internal usage only
    public static DpSeamFinder __fromPtr__(long addr) { return new DpSeamFinder(addr); }

    // C++: enum CostFunction (cv.detail.DpSeamFinder.CostFunction)
    public static final int
            COLOR = 0,
            COLOR_GRAD = 1;


    //
    // C++:   cv::detail::DpSeamFinder::DpSeamFinder(String costFunc)
    //

    public DpSeamFinder(String costFunc) {
        super(DpSeamFinder_0(costFunc));
    }


    //
    // C++:  void cv::detail::DpSeamFinder::setCostFunction(String val)
    //

    public void setCostFunction(String val) {
        setCostFunction_0(nativeObj, val);
    }


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // C++:   cv::detail::DpSeamFinder::DpSeamFinder(String costFunc)
    private static native long DpSeamFinder_0(String costFunc);

    // C++:  void cv::detail::DpSeamFinder::setCostFunction(String val)
    private static native void setCostFunction_0(long nativeObj, String val);

    // native support for java finalize()
    private static native void delete(long nativeObj);

}
