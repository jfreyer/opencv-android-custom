//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.stitching;

import java.util.ArrayList;
import java.util.List;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.stitching.BlocksCompensator;
import org.opencv.utils.Converters;

// C++: class BlocksGainCompensator
/**
 * Exposure compensator which tries to remove exposure related artifacts by adjusting image block
 * intensities, see CITE: UES01 for details.
 */
public class BlocksGainCompensator extends BlocksCompensator {

    protected BlocksGainCompensator(long addr) { super(addr); }

    // internal usage only
    public static BlocksGainCompensator __fromPtr__(long addr) { return new BlocksGainCompensator(addr); }

    //
    // C++:   cv::detail::BlocksGainCompensator::BlocksGainCompensator(int bl_width = 32, int bl_height = 32)
    //

    public BlocksGainCompensator(int bl_width, int bl_height) {
        super(BlocksGainCompensator_0(bl_width, bl_height));
    }

    public BlocksGainCompensator(int bl_width) {
        super(BlocksGainCompensator_1(bl_width));
    }

    public BlocksGainCompensator() {
        super(BlocksGainCompensator_2());
    }


    //
    // C++:   cv::detail::BlocksGainCompensator::BlocksGainCompensator(int bl_width, int bl_height, int nr_feeds)
    //

    public BlocksGainCompensator(int bl_width, int bl_height, int nr_feeds) {
        super(BlocksGainCompensator_3(bl_width, bl_height, nr_feeds));
    }


    //
    // C++:  void cv::detail::BlocksGainCompensator::apply(int index, Point corner, Mat& image, Mat mask)
    //

    public void apply(int index, Point corner, Mat image, Mat mask) {
        apply_0(nativeObj, index, corner.x, corner.y, image.nativeObj, mask.nativeObj);
    }


    //
    // C++:  void cv::detail::BlocksGainCompensator::getMatGains(vector_Mat& umv)
    //

    public void getMatGains(List<Mat> umv) {
        Mat umv_mat = new Mat();
        getMatGains_0(nativeObj, umv_mat.nativeObj);
        Converters.Mat_to_vector_Mat(umv_mat, umv);
        umv_mat.release();
    }


    //
    // C++:  void cv::detail::BlocksGainCompensator::setMatGains(vector_Mat umv)
    //

    public void setMatGains(List<Mat> umv) {
        Mat umv_mat = Converters.vector_Mat_to_Mat(umv);
        setMatGains_0(nativeObj, umv_mat.nativeObj);
    }


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // C++:   cv::detail::BlocksGainCompensator::BlocksGainCompensator(int bl_width = 32, int bl_height = 32)
    private static native long BlocksGainCompensator_0(int bl_width, int bl_height);
    private static native long BlocksGainCompensator_1(int bl_width);
    private static native long BlocksGainCompensator_2();

    // C++:   cv::detail::BlocksGainCompensator::BlocksGainCompensator(int bl_width, int bl_height, int nr_feeds)
    private static native long BlocksGainCompensator_3(int bl_width, int bl_height, int nr_feeds);

    // C++:  void cv::detail::BlocksGainCompensator::apply(int index, Point corner, Mat& image, Mat mask)
    private static native void apply_0(long nativeObj, int index, double corner_x, double corner_y, long image_nativeObj, long mask_nativeObj);

    // C++:  void cv::detail::BlocksGainCompensator::getMatGains(vector_Mat& umv)
    private static native void getMatGains_0(long nativeObj, long umv_mat_nativeObj);

    // C++:  void cv::detail::BlocksGainCompensator::setMatGains(vector_Mat umv)
    private static native void setMatGains_0(long nativeObj, long umv_mat_nativeObj);

    // native support for java finalize()
    private static native void delete(long nativeObj);

}
