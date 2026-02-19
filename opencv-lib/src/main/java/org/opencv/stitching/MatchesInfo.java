//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.stitching;

import java.util.ArrayList;
import java.util.List;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfDMatch;
import org.opencv.utils.Converters;

// C++: class MatchesInfo
/**
 * Structure containing information about matches between two images.
 *
 * It's assumed that there is a transformation between those images. Transformation may be
 * homography or affine transformation based on selected matcher.
 *
 * SEE: detail::FeaturesMatcher
 */
public class MatchesInfo {

    protected final long nativeObj;
    protected MatchesInfo(long addr) { nativeObj = addr; }

    public long getNativeObjAddr() { return nativeObj; }

    // internal usage only
    public static MatchesInfo __fromPtr__(long addr) { return new MatchesInfo(addr); }

    //
    // C++:  vector_DMatch cv::detail::MatchesInfo::getMatches()
    //

    public MatOfDMatch getMatches() {
        return MatOfDMatch.fromNativeAddr(getMatches_0(nativeObj));
    }


    //
    // C++:  vector_uchar cv::detail::MatchesInfo::getInliers()
    //

    public MatOfByte getInliers() {
        return MatOfByte.fromNativeAddr(getInliers_0(nativeObj));
    }


    //
    // C++: int MatchesInfo::src_img_idx
    //

    public int get_src_img_idx() {
        return get_src_img_idx_0(nativeObj);
    }


    //
    // C++: void MatchesInfo::src_img_idx
    //

    public void set_src_img_idx(int src_img_idx) {
        set_src_img_idx_0(nativeObj, src_img_idx);
    }


    //
    // C++: int MatchesInfo::dst_img_idx
    //

    public int get_dst_img_idx() {
        return get_dst_img_idx_0(nativeObj);
    }


    //
    // C++: void MatchesInfo::dst_img_idx
    //

    public void set_dst_img_idx(int dst_img_idx) {
        set_dst_img_idx_0(nativeObj, dst_img_idx);
    }


    //
    // C++: vector_DMatch MatchesInfo::matches
    //

    public MatOfDMatch get_matches() {
        return MatOfDMatch.fromNativeAddr(get_matches_0(nativeObj));
    }


    //
    // C++: void MatchesInfo::matches
    //

    public void set_matches(MatOfDMatch matches) {
        Mat matches_mat = matches;
        set_matches_0(nativeObj, matches_mat.nativeObj);
    }


    //
    // C++: vector_uchar MatchesInfo::inliers_mask
    //

    public MatOfByte get_inliers_mask() {
        return MatOfByte.fromNativeAddr(get_inliers_mask_0(nativeObj));
    }


    //
    // C++: void MatchesInfo::inliers_mask
    //

    public void set_inliers_mask(MatOfByte inliers_mask) {
        Mat inliers_mask_mat = inliers_mask;
        set_inliers_mask_0(nativeObj, inliers_mask_mat.nativeObj);
    }


    //
    // C++: int MatchesInfo::num_inliers
    //

    public int get_num_inliers() {
        return get_num_inliers_0(nativeObj);
    }


    //
    // C++: void MatchesInfo::num_inliers
    //

    public void set_num_inliers(int num_inliers) {
        set_num_inliers_0(nativeObj, num_inliers);
    }


    //
    // C++: Mat MatchesInfo::H
    //

    public Mat get_H() {
        return new Mat(get_H_0(nativeObj));
    }


    //
    // C++: void MatchesInfo::H
    //

    public void set_H(Mat H) {
        set_H_0(nativeObj, H.nativeObj);
    }


    //
    // C++: double MatchesInfo::confidence
    //

    public double get_confidence() {
        return get_confidence_0(nativeObj);
    }


    //
    // C++: void MatchesInfo::confidence
    //

    public void set_confidence(double confidence) {
        set_confidence_0(nativeObj, confidence);
    }


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // C++:  vector_DMatch cv::detail::MatchesInfo::getMatches()
    private static native long getMatches_0(long nativeObj);

    // C++:  vector_uchar cv::detail::MatchesInfo::getInliers()
    private static native long getInliers_0(long nativeObj);

    // C++: int MatchesInfo::src_img_idx
    private static native int get_src_img_idx_0(long nativeObj);

    // C++: void MatchesInfo::src_img_idx
    private static native void set_src_img_idx_0(long nativeObj, int src_img_idx);

    // C++: int MatchesInfo::dst_img_idx
    private static native int get_dst_img_idx_0(long nativeObj);

    // C++: void MatchesInfo::dst_img_idx
    private static native void set_dst_img_idx_0(long nativeObj, int dst_img_idx);

    // C++: vector_DMatch MatchesInfo::matches
    private static native long get_matches_0(long nativeObj);

    // C++: void MatchesInfo::matches
    private static native void set_matches_0(long nativeObj, long matches_mat_nativeObj);

    // C++: vector_uchar MatchesInfo::inliers_mask
    private static native long get_inliers_mask_0(long nativeObj);

    // C++: void MatchesInfo::inliers_mask
    private static native void set_inliers_mask_0(long nativeObj, long inliers_mask_mat_nativeObj);

    // C++: int MatchesInfo::num_inliers
    private static native int get_num_inliers_0(long nativeObj);

    // C++: void MatchesInfo::num_inliers
    private static native void set_num_inliers_0(long nativeObj, int num_inliers);

    // C++: Mat MatchesInfo::H
    private static native long get_H_0(long nativeObj);

    // C++: void MatchesInfo::H
    private static native void set_H_0(long nativeObj, long H_nativeObj);

    // C++: double MatchesInfo::confidence
    private static native double get_confidence_0(long nativeObj);

    // C++: void MatchesInfo::confidence
    private static native void set_confidence_0(long nativeObj, double confidence);

    // native support for java finalize()
    private static native void delete(long nativeObj);

}
