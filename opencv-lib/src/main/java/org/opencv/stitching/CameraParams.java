//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.stitching;

import org.opencv.core.Mat;

// C++: class CameraParams
/**
 * Describes camera parameters.
 *
 * <b>Note:</b> Translation is assumed to be zero during the whole stitching pipeline. :
 */
public class CameraParams {

    protected final long nativeObj;
    protected CameraParams(long addr) { nativeObj = addr; }

    public long getNativeObjAddr() { return nativeObj; }

    // internal usage only
    public static CameraParams __fromPtr__(long addr) { return new CameraParams(addr); }

    //
    // C++:  Mat cv::detail::CameraParams::K()
    //

    public Mat K() {
        return new Mat(K_0(nativeObj));
    }


    //
    // C++: double CameraParams::focal
    //

    public double get_focal() {
        return get_focal_0(nativeObj);
    }


    //
    // C++: void CameraParams::focal
    //

    public void set_focal(double focal) {
        set_focal_0(nativeObj, focal);
    }


    //
    // C++: double CameraParams::aspect
    //

    public double get_aspect() {
        return get_aspect_0(nativeObj);
    }


    //
    // C++: void CameraParams::aspect
    //

    public void set_aspect(double aspect) {
        set_aspect_0(nativeObj, aspect);
    }


    //
    // C++: double CameraParams::ppx
    //

    public double get_ppx() {
        return get_ppx_0(nativeObj);
    }


    //
    // C++: void CameraParams::ppx
    //

    public void set_ppx(double ppx) {
        set_ppx_0(nativeObj, ppx);
    }


    //
    // C++: double CameraParams::ppy
    //

    public double get_ppy() {
        return get_ppy_0(nativeObj);
    }


    //
    // C++: void CameraParams::ppy
    //

    public void set_ppy(double ppy) {
        set_ppy_0(nativeObj, ppy);
    }


    //
    // C++: Mat CameraParams::R
    //

    public Mat get_R() {
        return new Mat(get_R_0(nativeObj));
    }


    //
    // C++: void CameraParams::R
    //

    public void set_R(Mat R) {
        set_R_0(nativeObj, R.nativeObj);
    }


    //
    // C++: Mat CameraParams::t
    //

    public Mat get_t() {
        return new Mat(get_t_0(nativeObj));
    }


    //
    // C++: void CameraParams::t
    //

    public void set_t(Mat t) {
        set_t_0(nativeObj, t.nativeObj);
    }


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // C++:  Mat cv::detail::CameraParams::K()
    private static native long K_0(long nativeObj);

    // C++: double CameraParams::focal
    private static native double get_focal_0(long nativeObj);

    // C++: void CameraParams::focal
    private static native void set_focal_0(long nativeObj, double focal);

    // C++: double CameraParams::aspect
    private static native double get_aspect_0(long nativeObj);

    // C++: void CameraParams::aspect
    private static native void set_aspect_0(long nativeObj, double aspect);

    // C++: double CameraParams::ppx
    private static native double get_ppx_0(long nativeObj);

    // C++: void CameraParams::ppx
    private static native void set_ppx_0(long nativeObj, double ppx);

    // C++: double CameraParams::ppy
    private static native double get_ppy_0(long nativeObj);

    // C++: void CameraParams::ppy
    private static native void set_ppy_0(long nativeObj, double ppy);

    // C++: Mat CameraParams::R
    private static native long get_R_0(long nativeObj);

    // C++: void CameraParams::R
    private static native void set_R_0(long nativeObj, long R_nativeObj);

    // C++: Mat CameraParams::t
    private static native long get_t_0(long nativeObj);

    // C++: void CameraParams::t
    private static native void set_t_0(long nativeObj, long t_nativeObj);

    // native support for java finalize()
    private static native void delete(long nativeObj);

}
