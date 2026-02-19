//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.stitching;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.stitching.Blender;

// C++: class Blender
/**
 * Base class for all blenders.
 *
 * Simple blender which puts one image over another
 */
public class Blender {

    protected final long nativeObj;
    protected Blender(long addr) { nativeObj = addr; }

    public long getNativeObjAddr() { return nativeObj; }

    // internal usage only
    public static Blender __fromPtr__(long addr) { return new Blender(addr); }

    // C++: enum <unnamed>
    public static final int
            NO = 0,
            FEATHER = 1,
            MULTI_BAND = 2;


    //
    // C++: static Ptr_Blender cv::detail::Blender::createDefault(int type, bool try_gpu = false)
    //

    public static Blender createDefault(int type, boolean try_gpu) {
        return Blender.__fromPtr__(createDefault_0(type, try_gpu));
    }

    public static Blender createDefault(int type) {
        return Blender.__fromPtr__(createDefault_1(type));
    }


    //
    // C++:  void cv::detail::Blender::prepare(vector_Point corners, vector_Size sizes)
    //

    // Unknown type 'vector_Size' (I), skipping the function


    //
    // C++:  void cv::detail::Blender::prepare(Rect dst_roi)
    //

    public void prepare(Rect dst_roi) {
        prepare_0(nativeObj, dst_roi.x, dst_roi.y, dst_roi.width, dst_roi.height);
    }


    //
    // C++:  void cv::detail::Blender::feed(Mat img, Mat mask, Point tl)
    //

    /**
     * Processes the image.
     *
     *     @param img Source image
     *     @param mask Source image mask
     *     @param tl Source image top-left corners
     */
    public void feed(Mat img, Mat mask, Point tl) {
        feed_0(nativeObj, img.nativeObj, mask.nativeObj, tl.x, tl.y);
    }


    //
    // C++:  void cv::detail::Blender::blend(Mat& dst, Mat& dst_mask)
    //

    /**
     * Blends and returns the final pano.
     *
     *     @param dst Final pano
     *     @param dst_mask Final pano mask
     */
    public void blend(Mat dst, Mat dst_mask) {
        blend_0(nativeObj, dst.nativeObj, dst_mask.nativeObj);
    }


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // C++: static Ptr_Blender cv::detail::Blender::createDefault(int type, bool try_gpu = false)
    private static native long createDefault_0(int type, boolean try_gpu);
    private static native long createDefault_1(int type);

    // C++:  void cv::detail::Blender::prepare(Rect dst_roi)
    private static native void prepare_0(long nativeObj, int dst_roi_x, int dst_roi_y, int dst_roi_width, int dst_roi_height);

    // C++:  void cv::detail::Blender::feed(Mat img, Mat mask, Point tl)
    private static native void feed_0(long nativeObj, long img_nativeObj, long mask_nativeObj, double tl_x, double tl_y);

    // C++:  void cv::detail::Blender::blend(Mat& dst, Mat& dst_mask)
    private static native void blend_0(long nativeObj, long dst_nativeObj, long dst_mask_nativeObj);

    // native support for java finalize()
    private static native void delete(long nativeObj);

}
