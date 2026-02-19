//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.stitching;

import java.util.ArrayList;
import java.util.List;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Size;
import org.opencv.stitching.ExposureCompensator;
import org.opencv.utils.Converters;

// C++: class BlocksCompensator
/**
 * Exposure compensator which tries to remove exposure related artifacts by adjusting image blocks.
 */
public class BlocksCompensator extends ExposureCompensator {

    protected BlocksCompensator(long addr) { super(addr); }

    // internal usage only
    public static BlocksCompensator __fromPtr__(long addr) { return new BlocksCompensator(addr); }

    //
    // C++:  void cv::detail::BlocksCompensator::apply(int index, Point corner, Mat& image, Mat mask)
    //

    public void apply(int index, Point corner, Mat image, Mat mask) {
        apply_0(nativeObj, index, corner.x, corner.y, image.nativeObj, mask.nativeObj);
    }


    //
    // C++:  void cv::detail::BlocksCompensator::getMatGains(vector_Mat& umv)
    //

    public void getMatGains(List<Mat> umv) {
        Mat umv_mat = new Mat();
        getMatGains_0(nativeObj, umv_mat.nativeObj);
        Converters.Mat_to_vector_Mat(umv_mat, umv);
        umv_mat.release();
    }


    //
    // C++:  void cv::detail::BlocksCompensator::setMatGains(vector_Mat umv)
    //

    public void setMatGains(List<Mat> umv) {
        Mat umv_mat = Converters.vector_Mat_to_Mat(umv);
        setMatGains_0(nativeObj, umv_mat.nativeObj);
    }


    //
    // C++:  void cv::detail::BlocksCompensator::setNrFeeds(int nr_feeds)
    //

    public void setNrFeeds(int nr_feeds) {
        setNrFeeds_0(nativeObj, nr_feeds);
    }


    //
    // C++:  int cv::detail::BlocksCompensator::getNrFeeds()
    //

    public int getNrFeeds() {
        return getNrFeeds_0(nativeObj);
    }


    //
    // C++:  void cv::detail::BlocksCompensator::setSimilarityThreshold(double similarity_threshold)
    //

    public void setSimilarityThreshold(double similarity_threshold) {
        setSimilarityThreshold_0(nativeObj, similarity_threshold);
    }


    //
    // C++:  double cv::detail::BlocksCompensator::getSimilarityThreshold()
    //

    public double getSimilarityThreshold() {
        return getSimilarityThreshold_0(nativeObj);
    }


    //
    // C++:  void cv::detail::BlocksCompensator::setBlockSize(int width, int height)
    //

    public void setBlockSize(int width, int height) {
        setBlockSize_0(nativeObj, width, height);
    }


    //
    // C++:  void cv::detail::BlocksCompensator::setBlockSize(Size size)
    //

    public void setBlockSize(Size size) {
        setBlockSize_1(nativeObj, size.width, size.height);
    }


    //
    // C++:  Size cv::detail::BlocksCompensator::getBlockSize()
    //

    public Size getBlockSize() {
        return new Size(getBlockSize_0(nativeObj));
    }


    //
    // C++:  void cv::detail::BlocksCompensator::setNrGainsFilteringIterations(int nr_iterations)
    //

    public void setNrGainsFilteringIterations(int nr_iterations) {
        setNrGainsFilteringIterations_0(nativeObj, nr_iterations);
    }


    //
    // C++:  int cv::detail::BlocksCompensator::getNrGainsFilteringIterations()
    //

    public int getNrGainsFilteringIterations() {
        return getNrGainsFilteringIterations_0(nativeObj);
    }


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // C++:  void cv::detail::BlocksCompensator::apply(int index, Point corner, Mat& image, Mat mask)
    private static native void apply_0(long nativeObj, int index, double corner_x, double corner_y, long image_nativeObj, long mask_nativeObj);

    // C++:  void cv::detail::BlocksCompensator::getMatGains(vector_Mat& umv)
    private static native void getMatGains_0(long nativeObj, long umv_mat_nativeObj);

    // C++:  void cv::detail::BlocksCompensator::setMatGains(vector_Mat umv)
    private static native void setMatGains_0(long nativeObj, long umv_mat_nativeObj);

    // C++:  void cv::detail::BlocksCompensator::setNrFeeds(int nr_feeds)
    private static native void setNrFeeds_0(long nativeObj, int nr_feeds);

    // C++:  int cv::detail::BlocksCompensator::getNrFeeds()
    private static native int getNrFeeds_0(long nativeObj);

    // C++:  void cv::detail::BlocksCompensator::setSimilarityThreshold(double similarity_threshold)
    private static native void setSimilarityThreshold_0(long nativeObj, double similarity_threshold);

    // C++:  double cv::detail::BlocksCompensator::getSimilarityThreshold()
    private static native double getSimilarityThreshold_0(long nativeObj);

    // C++:  void cv::detail::BlocksCompensator::setBlockSize(int width, int height)
    private static native void setBlockSize_0(long nativeObj, int width, int height);

    // C++:  void cv::detail::BlocksCompensator::setBlockSize(Size size)
    private static native void setBlockSize_1(long nativeObj, double size_width, double size_height);

    // C++:  Size cv::detail::BlocksCompensator::getBlockSize()
    private static native double[] getBlockSize_0(long nativeObj);

    // C++:  void cv::detail::BlocksCompensator::setNrGainsFilteringIterations(int nr_iterations)
    private static native void setNrGainsFilteringIterations_0(long nativeObj, int nr_iterations);

    // C++:  int cv::detail::BlocksCompensator::getNrGainsFilteringIterations()
    private static native int getNrGainsFilteringIterations_0(long nativeObj);

    // native support for java finalize()
    private static native void delete(long nativeObj);

}
