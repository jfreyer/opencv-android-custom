//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.stitching;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.stitching.Blender;

// C++: class FeatherBlender
/**
 * Simple blender which mixes images at its borders.
 */
public class FeatherBlender extends Blender {

    protected FeatherBlender(long addr) { super(addr); }

    // internal usage only
    public static FeatherBlender __fromPtr__(long addr) { return new FeatherBlender(addr); }

    //
    // C++:   cv::detail::FeatherBlender::FeatherBlender(float sharpness = 0.02f)
    //

    public FeatherBlender(float sharpness) {
        super(FeatherBlender_0(sharpness));
    }

    public FeatherBlender() {
        super(FeatherBlender_1());
    }


    //
    // C++:  float cv::detail::FeatherBlender::sharpness()
    //

    public float sharpness() {
        return sharpness_0(nativeObj);
    }


    //
    // C++:  void cv::detail::FeatherBlender::setSharpness(float val)
    //

    public void setSharpness(float val) {
        setSharpness_0(nativeObj, val);
    }


    //
    // C++:  void cv::detail::FeatherBlender::prepare(Rect dst_roi)
    //

    public void prepare(Rect dst_roi) {
        prepare_0(nativeObj, dst_roi.x, dst_roi.y, dst_roi.width, dst_roi.height);
    }


    //
    // C++:  void cv::detail::FeatherBlender::feed(Mat img, Mat mask, Point tl)
    //

    public void feed(Mat img, Mat mask, Point tl) {
        feed_0(nativeObj, img.nativeObj, mask.nativeObj, tl.x, tl.y);
    }


    //
    // C++:  void cv::detail::FeatherBlender::blend(Mat& dst, Mat& dst_mask)
    //

    public void blend(Mat dst, Mat dst_mask) {
        blend_0(nativeObj, dst.nativeObj, dst_mask.nativeObj);
    }


    //
    // C++:  Rect cv::detail::FeatherBlender::createWeightMaps(vector_UMat masks, vector_Point corners, vector_UMat& weight_maps)
    //

    // Unknown type 'vector_UMat' (I), skipping the function


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // C++:   cv::detail::FeatherBlender::FeatherBlender(float sharpness = 0.02f)
    private static native long FeatherBlender_0(float sharpness);
    private static native long FeatherBlender_1();

    // C++:  float cv::detail::FeatherBlender::sharpness()
    private static native float sharpness_0(long nativeObj);

    // C++:  void cv::detail::FeatherBlender::setSharpness(float val)
    private static native void setSharpness_0(long nativeObj, float val);

    // C++:  void cv::detail::FeatherBlender::prepare(Rect dst_roi)
    private static native void prepare_0(long nativeObj, int dst_roi_x, int dst_roi_y, int dst_roi_width, int dst_roi_height);

    // C++:  void cv::detail::FeatherBlender::feed(Mat img, Mat mask, Point tl)
    private static native void feed_0(long nativeObj, long img_nativeObj, long mask_nativeObj, double tl_x, double tl_y);

    // C++:  void cv::detail::FeatherBlender::blend(Mat& dst, Mat& dst_mask)
    private static native void blend_0(long nativeObj, long dst_nativeObj, long dst_mask_nativeObj);

    // native support for java finalize()
    private static native void delete(long nativeObj);

}
