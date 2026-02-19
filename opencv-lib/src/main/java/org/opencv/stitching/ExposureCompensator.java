//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.stitching;

import java.util.ArrayList;
import java.util.List;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.stitching.ExposureCompensator;
import org.opencv.utils.Converters;

// C++: class ExposureCompensator
/**
 * Base class for all exposure compensators.
 */
public class ExposureCompensator {

    protected final long nativeObj;
    protected ExposureCompensator(long addr) { nativeObj = addr; }

    public long getNativeObjAddr() { return nativeObj; }

    // internal usage only
    public static ExposureCompensator __fromPtr__(long addr) { return new ExposureCompensator(addr); }

    // C++: enum <unnamed>
    public static final int
            NO = 0,
            GAIN = 1,
            GAIN_BLOCKS = 2,
            CHANNELS = 3,
            CHANNELS_BLOCKS = 4;


    //
    // C++: static Ptr_ExposureCompensator cv::detail::ExposureCompensator::createDefault(int type)
    //

    public static ExposureCompensator createDefault(int type) {
        return ExposureCompensator.__fromPtr__(createDefault_0(type));
    }


    //
    // C++:  void cv::detail::ExposureCompensator::feed(vector_Point corners, vector_UMat images, vector_UMat masks)
    //

    // Unknown type 'vector_UMat' (I), skipping the function


    //
    // C++:  void cv::detail::ExposureCompensator::apply(int index, Point corner, Mat& image, Mat mask)
    //

    /**
     * Compensate exposure in the specified image.
     *
     *     @param index Image index
     *     @param corner Image top-left corner
     *     @param image Image to process
     *     @param mask Image mask
     */
    public void apply(int index, Point corner, Mat image, Mat mask) {
        apply_0(nativeObj, index, corner.x, corner.y, image.nativeObj, mask.nativeObj);
    }


    //
    // C++:  void cv::detail::ExposureCompensator::getMatGains(vector_Mat& arg1)
    //

    public void getMatGains(List<Mat> arg1) {
        Mat arg1_mat = new Mat();
        getMatGains_0(nativeObj, arg1_mat.nativeObj);
        Converters.Mat_to_vector_Mat(arg1_mat, arg1);
        arg1_mat.release();
    }


    //
    // C++:  void cv::detail::ExposureCompensator::setMatGains(vector_Mat arg1)
    //

    public void setMatGains(List<Mat> arg1) {
        Mat arg1_mat = Converters.vector_Mat_to_Mat(arg1);
        setMatGains_0(nativeObj, arg1_mat.nativeObj);
    }


    //
    // C++:  void cv::detail::ExposureCompensator::setUpdateGain(bool b)
    //

    public void setUpdateGain(boolean b) {
        setUpdateGain_0(nativeObj, b);
    }


    //
    // C++:  bool cv::detail::ExposureCompensator::getUpdateGain()
    //

    public boolean getUpdateGain() {
        return getUpdateGain_0(nativeObj);
    }


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // C++: static Ptr_ExposureCompensator cv::detail::ExposureCompensator::createDefault(int type)
    private static native long createDefault_0(int type);

    // C++:  void cv::detail::ExposureCompensator::apply(int index, Point corner, Mat& image, Mat mask)
    private static native void apply_0(long nativeObj, int index, double corner_x, double corner_y, long image_nativeObj, long mask_nativeObj);

    // C++:  void cv::detail::ExposureCompensator::getMatGains(vector_Mat& arg1)
    private static native void getMatGains_0(long nativeObj, long arg1_mat_nativeObj);

    // C++:  void cv::detail::ExposureCompensator::setMatGains(vector_Mat arg1)
    private static native void setMatGains_0(long nativeObj, long arg1_mat_nativeObj);

    // C++:  void cv::detail::ExposureCompensator::setUpdateGain(bool b)
    private static native void setUpdateGain_0(long nativeObj, boolean b);

    // C++:  bool cv::detail::ExposureCompensator::getUpdateGain()
    private static native boolean getUpdateGain_0(long nativeObj);

    // native support for java finalize()
    private static native void delete(long nativeObj);

}
