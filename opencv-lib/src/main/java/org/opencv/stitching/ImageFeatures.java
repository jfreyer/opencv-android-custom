//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.stitching;

import java.util.ArrayList;
import java.util.List;
import org.opencv.core.Mat;
import org.opencv.core.MatOfKeyPoint;
import org.opencv.core.Size;
import org.opencv.utils.Converters;

// C++: class ImageFeatures
/**
 * Structure containing image keypoints and descriptors.
 */
public class ImageFeatures {

    protected final long nativeObj;
    protected ImageFeatures(long addr) { nativeObj = addr; }

    public long getNativeObjAddr() { return nativeObj; }

    // internal usage only
    public static ImageFeatures __fromPtr__(long addr) { return new ImageFeatures(addr); }

    //
    // C++:  vector_KeyPoint cv::detail::ImageFeatures::getKeypoints()
    //

    public MatOfKeyPoint getKeypoints() {
        return MatOfKeyPoint.fromNativeAddr(getKeypoints_0(nativeObj));
    }


    //
    // C++: int ImageFeatures::img_idx
    //

    public int get_img_idx() {
        return get_img_idx_0(nativeObj);
    }


    //
    // C++: void ImageFeatures::img_idx
    //

    public void set_img_idx(int img_idx) {
        set_img_idx_0(nativeObj, img_idx);
    }


    //
    // C++: Size ImageFeatures::img_size
    //

    public Size get_img_size() {
        return new Size(get_img_size_0(nativeObj));
    }


    //
    // C++: void ImageFeatures::img_size
    //

    public void set_img_size(Size img_size) {
        set_img_size_0(nativeObj, img_size.width, img_size.height);
    }


    //
    // C++: vector_KeyPoint ImageFeatures::keypoints
    //

    public MatOfKeyPoint get_keypoints() {
        return MatOfKeyPoint.fromNativeAddr(get_keypoints_0(nativeObj));
    }


    //
    // C++: void ImageFeatures::keypoints
    //

    public void set_keypoints(MatOfKeyPoint keypoints) {
        Mat keypoints_mat = keypoints;
        set_keypoints_0(nativeObj, keypoints_mat.nativeObj);
    }


    //
    // C++: UMat ImageFeatures::descriptors
    //

    // Return type 'UMat' is not supported, skipping the function


    //
    // C++: void ImageFeatures::descriptors
    //

    // Unknown type 'UMat' (I), skipping the function


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // C++:  vector_KeyPoint cv::detail::ImageFeatures::getKeypoints()
    private static native long getKeypoints_0(long nativeObj);

    // C++: int ImageFeatures::img_idx
    private static native int get_img_idx_0(long nativeObj);

    // C++: void ImageFeatures::img_idx
    private static native void set_img_idx_0(long nativeObj, int img_idx);

    // C++: Size ImageFeatures::img_size
    private static native double[] get_img_size_0(long nativeObj);

    // C++: void ImageFeatures::img_size
    private static native void set_img_size_0(long nativeObj, double img_size_width, double img_size_height);

    // C++: vector_KeyPoint ImageFeatures::keypoints
    private static native long get_keypoints_0(long nativeObj);

    // C++: void ImageFeatures::keypoints
    private static native void set_keypoints_0(long nativeObj, long keypoints_mat_nativeObj);

    // native support for java finalize()
    private static native void delete(long nativeObj);

}
