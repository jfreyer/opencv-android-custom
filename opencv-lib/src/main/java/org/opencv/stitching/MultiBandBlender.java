//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.stitching;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.stitching.Blender;

// C++: class MultiBandBlender
/**
 * Blender which uses multi-band blending algorithm (see CITE: BA83).
 */
public class MultiBandBlender extends Blender {

    protected MultiBandBlender(long addr) { super(addr); }

    // internal usage only
    public static MultiBandBlender __fromPtr__(long addr) { return new MultiBandBlender(addr); }

    //
    // C++:   cv::detail::MultiBandBlender::MultiBandBlender(int try_gpu = false, int num_bands = 5, int weight_type = CV_32F)
    //

    public MultiBandBlender(int try_gpu, int num_bands, int weight_type) {
        super(MultiBandBlender_0(try_gpu, num_bands, weight_type));
    }

    public MultiBandBlender(int try_gpu, int num_bands) {
        super(MultiBandBlender_1(try_gpu, num_bands));
    }

    public MultiBandBlender(int try_gpu) {
        super(MultiBandBlender_2(try_gpu));
    }

    public MultiBandBlender() {
        super(MultiBandBlender_3());
    }


    //
    // C++:  int cv::detail::MultiBandBlender::numBands()
    //

    public int numBands() {
        return numBands_0(nativeObj);
    }


    //
    // C++:  void cv::detail::MultiBandBlender::setNumBands(int val)
    //

    public void setNumBands(int val) {
        setNumBands_0(nativeObj, val);
    }


    //
    // C++:  void cv::detail::MultiBandBlender::prepare(Rect dst_roi)
    //

    public void prepare(Rect dst_roi) {
        prepare_0(nativeObj, dst_roi.x, dst_roi.y, dst_roi.width, dst_roi.height);
    }


    //
    // C++:  void cv::detail::MultiBandBlender::feed(Mat img, Mat mask, Point tl)
    //

    public void feed(Mat img, Mat mask, Point tl) {
        feed_0(nativeObj, img.nativeObj, mask.nativeObj, tl.x, tl.y);
    }


    //
    // C++:  void cv::detail::MultiBandBlender::blend(Mat& dst, Mat& dst_mask)
    //

    public void blend(Mat dst, Mat dst_mask) {
        blend_0(nativeObj, dst.nativeObj, dst_mask.nativeObj);
    }


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // C++:   cv::detail::MultiBandBlender::MultiBandBlender(int try_gpu = false, int num_bands = 5, int weight_type = CV_32F)
    private static native long MultiBandBlender_0(int try_gpu, int num_bands, int weight_type);
    private static native long MultiBandBlender_1(int try_gpu, int num_bands);
    private static native long MultiBandBlender_2(int try_gpu);
    private static native long MultiBandBlender_3();

    // C++:  int cv::detail::MultiBandBlender::numBands()
    private static native int numBands_0(long nativeObj);

    // C++:  void cv::detail::MultiBandBlender::setNumBands(int val)
    private static native void setNumBands_0(long nativeObj, int val);

    // C++:  void cv::detail::MultiBandBlender::prepare(Rect dst_roi)
    private static native void prepare_0(long nativeObj, int dst_roi_x, int dst_roi_y, int dst_roi_width, int dst_roi_height);

    // C++:  void cv::detail::MultiBandBlender::feed(Mat img, Mat mask, Point tl)
    private static native void feed_0(long nativeObj, long img_nativeObj, long mask_nativeObj, double tl_x, double tl_y);

    // C++:  void cv::detail::MultiBandBlender::blend(Mat& dst, Mat& dst_mask)
    private static native void blend_0(long nativeObj, long dst_nativeObj, long dst_mask_nativeObj);

    // native support for java finalize()
    private static native void delete(long nativeObj);

}
