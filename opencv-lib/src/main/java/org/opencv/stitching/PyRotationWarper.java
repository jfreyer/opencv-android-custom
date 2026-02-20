//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.stitching;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Size;

// C++: class PyRotationWarper

public class PyRotationWarper {

    protected final long nativeObj;
    protected PyRotationWarper(long addr) { nativeObj = addr; }

    public long getNativeObjAddr() { return nativeObj; }

    // internal usage only
    public static PyRotationWarper __fromPtr__(long addr) { return new PyRotationWarper(addr); }

    //
    // C++:   cv::PyRotationWarper::PyRotationWarper(String type, float scale)
    //

    public PyRotationWarper(String type, float scale) {
        nativeObj = PyRotationWarper_0(type, scale);
    }


    //
    // C++:   cv::PyRotationWarper::PyRotationWarper()
    //

    public PyRotationWarper() {
        nativeObj = PyRotationWarper_1();
    }


    //
    // C++:  Point2f cv::PyRotationWarper::warpPoint(Point2f pt, Mat K, Mat R)
    //

    /**
     * Projects the image point.
     *
     *         @param pt Source point
     *         @param K Camera intrinsic parameters
     *         @param R Camera rotation matrix
     *         @return Projected point
     */
    public Point warpPoint(Point pt, Mat K, Mat R) {
        return new Point(warpPoint_0(nativeObj, pt.x, pt.y, K.nativeObj, R.nativeObj));
    }


    //
    // C++:  Point2f cv::PyRotationWarper::warpPointBackward(Point2f pt, Mat K, Mat R)
    //

    /**
     * Projects the image point backward.
     *
     *         @param pt Projected point
     *         @param K Camera intrinsic parameters
     *         @param R Camera rotation matrix
     *         @return Backward-projected point
     */
    public Point warpPointBackward(Point pt, Mat K, Mat R) {
        return new Point(warpPointBackward_0(nativeObj, pt.x, pt.y, K.nativeObj, R.nativeObj));
    }


    //
    // C++:  Point2f cv::PyRotationWarper::warpPointBackward(Point2f pt, Mat K, Mat R)
    //

    public Point warpPointBackward(Point pt, Mat K, Mat R) {
        return new Point(warpPointBackward_1(nativeObj, pt.x, pt.y, K.nativeObj, R.nativeObj));
    }


    //
    // C++:  Rect cv::PyRotationWarper::buildMaps(Size src_size, Mat K, Mat R, Mat& xmap, Mat& ymap)
    //

    /**
     * Builds the projection maps according to the given camera data.
     *
     *         @param src_size Source image size
     *         @param K Camera intrinsic parameters
     *         @param R Camera rotation matrix
     *         @param xmap Projection map for the x axis
     *         @param ymap Projection map for the y axis
     *         @return Projected image minimum bounding box
     */
    public Rect buildMaps(Size src_size, Mat K, Mat R, Mat xmap, Mat ymap) {
        return new Rect(buildMaps_0(nativeObj, src_size.width, src_size.height, K.nativeObj, R.nativeObj, xmap.nativeObj, ymap.nativeObj));
    }


    //
    // C++:  Point cv::PyRotationWarper::warp(Mat src, Mat K, Mat R, int interp_mode, int border_mode, Mat& dst)
    //

    /**
     * Projects the image.
     *
     *         @param src Source image
     *         @param K Camera intrinsic parameters
     *         @param R Camera rotation matrix
     *         @param interp_mode Interpolation mode
     *         @param border_mode Border extrapolation mode
     *         @param dst Projected image
     *         @return Project image top-left corner
     */
    public Point warp(Mat src, Mat K, Mat R, int interp_mode, int border_mode, Mat dst) {
        return new Point(warp_0(nativeObj, src.nativeObj, K.nativeObj, R.nativeObj, interp_mode, border_mode, dst.nativeObj));
    }


    //
    // C++:  void cv::PyRotationWarper::warpBackward(Mat src, Mat K, Mat R, int interp_mode, int border_mode, Size dst_size, Mat& dst)
    //

    /**
     * Projects the image backward.
     *
     *         @param src Projected image
     *         @param K Camera intrinsic parameters
     *         @param R Camera rotation matrix
     *         @param interp_mode Interpolation mode
     *         @param border_mode Border extrapolation mode
     *         @param dst_size Backward-projected image size
     *         @param dst Backward-projected image
     */
    public void warpBackward(Mat src, Mat K, Mat R, int interp_mode, int border_mode, Size dst_size, Mat dst) {
        warpBackward_0(nativeObj, src.nativeObj, K.nativeObj, R.nativeObj, interp_mode, border_mode, dst_size.width, dst_size.height, dst.nativeObj);
    }


    //
    // C++:  Rect cv::PyRotationWarper::warpRoi(Size src_size, Mat K, Mat R)
    //

    /**
     * @param src_size Source image bounding box
     *         @param K Camera intrinsic parameters
     *         @param R Camera rotation matrix
     *         @return Projected image minimum bounding box
     */
    public Rect warpRoi(Size src_size, Mat K, Mat R) {
        return new Rect(warpRoi_0(nativeObj, src_size.width, src_size.height, K.nativeObj, R.nativeObj));
    }


    //
    // C++:  float cv::PyRotationWarper::getScale()
    //

    public float getScale() {
        return getScale_0(nativeObj);
    }


    //
    // C++:  void cv::PyRotationWarper::setScale(float arg1)
    //

    public void setScale(float arg1) {
        setScale_0(nativeObj, arg1);
    }


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // C++:   cv::PyRotationWarper::PyRotationWarper(String type, float scale)
    private static native long PyRotationWarper_0(String type, float scale);

    // C++:   cv::PyRotationWarper::PyRotationWarper()
    private static native long PyRotationWarper_1();

    // C++:  Point2f cv::PyRotationWarper::warpPoint(Point2f pt, Mat K, Mat R)
    private static native double[] warpPoint_0(long nativeObj, double pt_x, double pt_y, long K_nativeObj, long R_nativeObj);

    // C++:  Point2f cv::PyRotationWarper::warpPointBackward(Point2f pt, Mat K, Mat R)
    private static native double[] warpPointBackward_0(long nativeObj, double pt_x, double pt_y, long K_nativeObj, long R_nativeObj);

    // C++:  Point2f cv::PyRotationWarper::warpPointBackward(Point2f pt, Mat K, Mat R)
    private static native double[] warpPointBackward_1(long nativeObj, double pt_x, double pt_y, long K_nativeObj, long R_nativeObj);

    // C++:  Rect cv::PyRotationWarper::buildMaps(Size src_size, Mat K, Mat R, Mat& xmap, Mat& ymap)
    private static native double[] buildMaps_0(long nativeObj, double src_size_width, double src_size_height, long K_nativeObj, long R_nativeObj, long xmap_nativeObj, long ymap_nativeObj);

    // C++:  Point cv::PyRotationWarper::warp(Mat src, Mat K, Mat R, int interp_mode, int border_mode, Mat& dst)
    private static native double[] warp_0(long nativeObj, long src_nativeObj, long K_nativeObj, long R_nativeObj, int interp_mode, int border_mode, long dst_nativeObj);

    // C++:  void cv::PyRotationWarper::warpBackward(Mat src, Mat K, Mat R, int interp_mode, int border_mode, Size dst_size, Mat& dst)
    private static native void warpBackward_0(long nativeObj, long src_nativeObj, long K_nativeObj, long R_nativeObj, int interp_mode, int border_mode, double dst_size_width, double dst_size_height, long dst_nativeObj);

    // C++:  Rect cv::PyRotationWarper::warpRoi(Size src_size, Mat K, Mat R)
    private static native double[] warpRoi_0(long nativeObj, double src_size_width, double src_size_height, long K_nativeObj, long R_nativeObj);

    // C++:  float cv::PyRotationWarper::getScale()
    private static native float getScale_0(long nativeObj);

    // C++:  void cv::PyRotationWarper::setScale(float arg1)
    private static native void setScale_0(long nativeObj, float arg1);

    // native support for java finalize()
    private static native void delete(long nativeObj);

}
