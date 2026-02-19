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

// C++: class GainCompensator
/**
 * Exposure compensator which tries to remove exposure related artifacts by adjusting image
 * intensities, see CITE: BL07 and CITE: WJ10 for details.
 */
public class GainCompensator extends ExposureCompensator {

    protected GainCompensator(long addr) { super(addr); }

    // internal usage only
    public static GainCompensator __fromPtr__(long addr) { return new GainCompensator(addr); }

    //
    // C++:   cv::detail::GainCompensator::GainCompensator()
    //

    public GainCompensator() {
        super(GainCompensator_0());
    }


    //
    // C++:   cv::detail::GainCompensator::GainCompensator(int nr_feeds)
    //

    public GainCompensator(int nr_feeds) {
        super(GainCompensator_1(nr_feeds));
    }


    //
    // C++:  void cv::detail::GainCompensator::apply(int index, Point corner, Mat& image, Mat mask)
    //

    public void apply(int index, Point corner, Mat image, Mat mask) {
        apply_0(nativeObj, index, corner.x, corner.y, image.nativeObj, mask.nativeObj);
    }


    //
    // C++:  void cv::detail::GainCompensator::getMatGains(vector_Mat& umv)
    //

    public void getMatGains(List<Mat> umv) {
        Mat umv_mat = new Mat();
        getMatGains_0(nativeObj, umv_mat.nativeObj);
        Converters.Mat_to_vector_Mat(umv_mat, umv);
        umv_mat.release();
    }


    //
    // C++:  void cv::detail::GainCompensator::setMatGains(vector_Mat umv)
    //

    public void setMatGains(List<Mat> umv) {
        Mat umv_mat = Converters.vector_Mat_to_Mat(umv);
        setMatGains_0(nativeObj, umv_mat.nativeObj);
    }


    //
    // C++:  void cv::detail::GainCompensator::setNrFeeds(int nr_feeds)
    //

    public void setNrFeeds(int nr_feeds) {
        setNrFeeds_0(nativeObj, nr_feeds);
    }


    //
    // C++:  int cv::detail::GainCompensator::getNrFeeds()
    //

    public int getNrFeeds() {
        return getNrFeeds_0(nativeObj);
    }


    //
    // C++:  void cv::detail::GainCompensator::setSimilarityThreshold(double similarity_threshold)
    //

    public void setSimilarityThreshold(double similarity_threshold) {
        setSimilarityThreshold_0(nativeObj, similarity_threshold);
    }


    //
    // C++:  double cv::detail::GainCompensator::getSimilarityThreshold()
    //

    public double getSimilarityThreshold() {
        return getSimilarityThreshold_0(nativeObj);
    }


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // C++:   cv::detail::GainCompensator::GainCompensator()
    private static native long GainCompensator_0();

    // C++:   cv::detail::GainCompensator::GainCompensator(int nr_feeds)
    private static native long GainCompensator_1(int nr_feeds);

    // C++:  void cv::detail::GainCompensator::apply(int index, Point corner, Mat& image, Mat mask)
    private static native void apply_0(long nativeObj, int index, double corner_x, double corner_y, long image_nativeObj, long mask_nativeObj);

    // C++:  void cv::detail::GainCompensator::getMatGains(vector_Mat& umv)
    private static native void getMatGains_0(long nativeObj, long umv_mat_nativeObj);

    // C++:  void cv::detail::GainCompensator::setMatGains(vector_Mat umv)
    private static native void setMatGains_0(long nativeObj, long umv_mat_nativeObj);

    // C++:  void cv::detail::GainCompensator::setNrFeeds(int nr_feeds)
    private static native void setNrFeeds_0(long nativeObj, int nr_feeds);

    // C++:  int cv::detail::GainCompensator::getNrFeeds()
    private static native int getNrFeeds_0(long nativeObj);

    // C++:  void cv::detail::GainCompensator::setSimilarityThreshold(double similarity_threshold)
    private static native void setSimilarityThreshold_0(long nativeObj, double similarity_threshold);

    // C++:  double cv::detail::GainCompensator::getSimilarityThreshold()
    private static native double getSimilarityThreshold_0(long nativeObj);

    // native support for java finalize()
    private static native void delete(long nativeObj);

}
