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

// C++: class NoExposureCompensator
/**
 * Stub exposure compensator which does nothing.
 */
public class NoExposureCompensator extends ExposureCompensator {

    protected NoExposureCompensator(long addr) { super(addr); }

    // internal usage only
    public static NoExposureCompensator __fromPtr__(long addr) { return new NoExposureCompensator(addr); }

    //
    // C++:  void cv::detail::NoExposureCompensator::apply(int arg1, Point arg2, Mat& arg3, Mat arg4)
    //

    public void apply(int arg1, Point arg2, Mat arg3, Mat arg4) {
        apply_0(nativeObj, arg1, arg2.x, arg2.y, arg3.nativeObj, arg4.nativeObj);
    }


    //
    // C++:  void cv::detail::NoExposureCompensator::getMatGains(vector_Mat& umv)
    //

    public void getMatGains(List<Mat> umv) {
        Mat umv_mat = new Mat();
        getMatGains_0(nativeObj, umv_mat.nativeObj);
        Converters.Mat_to_vector_Mat(umv_mat, umv);
        umv_mat.release();
    }


    //
    // C++:  void cv::detail::NoExposureCompensator::setMatGains(vector_Mat umv)
    //

    public void setMatGains(List<Mat> umv) {
        Mat umv_mat = Converters.vector_Mat_to_Mat(umv);
        setMatGains_0(nativeObj, umv_mat.nativeObj);
    }


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // C++:  void cv::detail::NoExposureCompensator::apply(int arg1, Point arg2, Mat& arg3, Mat arg4)
    private static native void apply_0(long nativeObj, int arg1, double arg2_x, double arg2_y, long arg3_nativeObj, long arg4_nativeObj);

    // C++:  void cv::detail::NoExposureCompensator::getMatGains(vector_Mat& umv)
    private static native void getMatGains_0(long nativeObj, long umv_mat_nativeObj);

    // C++:  void cv::detail::NoExposureCompensator::setMatGains(vector_Mat umv)
    private static native void setMatGains_0(long nativeObj, long umv_mat_nativeObj);

    // native support for java finalize()
    private static native void delete(long nativeObj);

}
