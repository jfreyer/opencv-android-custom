//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.stitching;

import org.opencv.stitching.BestOf2NearestMatcher;
import org.opencv.stitching.FeaturesMatcher;

// C++: class BestOf2NearestMatcher
/**
 * Features matcher which finds two best matches for each feature and leaves the best one only if the
 * ratio between descriptor distances is greater than the threshold match_conf
 *
 * SEE: detail::FeaturesMatcher
 */
public class BestOf2NearestMatcher extends FeaturesMatcher {

    protected BestOf2NearestMatcher(long addr) { super(addr); }

    // internal usage only
    public static BestOf2NearestMatcher __fromPtr__(long addr) { return new BestOf2NearestMatcher(addr); }

    //
    // C++:   cv::detail::BestOf2NearestMatcher::BestOf2NearestMatcher(bool try_use_gpu = false, float match_conf = 0.3f, int num_matches_thresh1 = 6, int num_matches_thresh2 = 6, double matches_confindece_thresh = 3.)
    //

    /**
     * Constructs a "best of 2 nearest" matcher.
     *
     *     @param try_use_gpu Should try to use GPU or not
     *     @param match_conf Match distances ration threshold
     *     @param num_matches_thresh1 Minimum number of matches required for the 2D projective transform
     *     estimation used in the inliers classification step
     *     @param num_matches_thresh2 Minimum number of matches required for the 2D projective transform
     *     re-estimation on inliers
     *     @param matches_confindece_thresh Matching confidence threshold to take the match into account.
     *     The threshold was determined experimentally and set to 3 by default.
     */
    public BestOf2NearestMatcher(boolean try_use_gpu, float match_conf, int num_matches_thresh1, int num_matches_thresh2, double matches_confindece_thresh) {
        super(BestOf2NearestMatcher_0(try_use_gpu, match_conf, num_matches_thresh1, num_matches_thresh2, matches_confindece_thresh));
    }

    /**
     * Constructs a "best of 2 nearest" matcher.
     *
     *     @param try_use_gpu Should try to use GPU or not
     *     @param match_conf Match distances ration threshold
     *     @param num_matches_thresh1 Minimum number of matches required for the 2D projective transform
     *     estimation used in the inliers classification step
     *     @param num_matches_thresh2 Minimum number of matches required for the 2D projective transform
     *     re-estimation on inliers
     *     The threshold was determined experimentally and set to 3 by default.
     */
    public BestOf2NearestMatcher(boolean try_use_gpu, float match_conf, int num_matches_thresh1, int num_matches_thresh2) {
        super(BestOf2NearestMatcher_1(try_use_gpu, match_conf, num_matches_thresh1, num_matches_thresh2));
    }

    /**
     * Constructs a "best of 2 nearest" matcher.
     *
     *     @param try_use_gpu Should try to use GPU or not
     *     @param match_conf Match distances ration threshold
     *     @param num_matches_thresh1 Minimum number of matches required for the 2D projective transform
     *     estimation used in the inliers classification step
     *     re-estimation on inliers
     *     The threshold was determined experimentally and set to 3 by default.
     */
    public BestOf2NearestMatcher(boolean try_use_gpu, float match_conf, int num_matches_thresh1) {
        super(BestOf2NearestMatcher_2(try_use_gpu, match_conf, num_matches_thresh1));
    }

    /**
     * Constructs a "best of 2 nearest" matcher.
     *
     *     @param try_use_gpu Should try to use GPU or not
     *     @param match_conf Match distances ration threshold
     *     estimation used in the inliers classification step
     *     re-estimation on inliers
     *     The threshold was determined experimentally and set to 3 by default.
     */
    public BestOf2NearestMatcher(boolean try_use_gpu, float match_conf) {
        super(BestOf2NearestMatcher_3(try_use_gpu, match_conf));
    }

    /**
     * Constructs a "best of 2 nearest" matcher.
     *
     *     @param try_use_gpu Should try to use GPU or not
     *     estimation used in the inliers classification step
     *     re-estimation on inliers
     *     The threshold was determined experimentally and set to 3 by default.
     */
    public BestOf2NearestMatcher(boolean try_use_gpu) {
        super(BestOf2NearestMatcher_4(try_use_gpu));
    }

    /**
     * Constructs a "best of 2 nearest" matcher.
     *
     *     estimation used in the inliers classification step
     *     re-estimation on inliers
     *     The threshold was determined experimentally and set to 3 by default.
     */
    public BestOf2NearestMatcher() {
        super(BestOf2NearestMatcher_5());
    }


    //
    // C++:  void cv::detail::BestOf2NearestMatcher::collectGarbage()
    //

    public void collectGarbage() {
        collectGarbage_0(nativeObj);
    }


    //
    // C++: static Ptr_BestOf2NearestMatcher cv::detail::BestOf2NearestMatcher::create(bool try_use_gpu = false, float match_conf = 0.3f, int num_matches_thresh1 = 6, int num_matches_thresh2 = 6, double matches_confindece_thresh = 3.)
    //

    public static BestOf2NearestMatcher create(boolean try_use_gpu, float match_conf, int num_matches_thresh1, int num_matches_thresh2, double matches_confindece_thresh) {
        return BestOf2NearestMatcher.__fromPtr__(create_0(try_use_gpu, match_conf, num_matches_thresh1, num_matches_thresh2, matches_confindece_thresh));
    }

    public static BestOf2NearestMatcher create(boolean try_use_gpu, float match_conf, int num_matches_thresh1, int num_matches_thresh2) {
        return BestOf2NearestMatcher.__fromPtr__(create_1(try_use_gpu, match_conf, num_matches_thresh1, num_matches_thresh2));
    }

    public static BestOf2NearestMatcher create(boolean try_use_gpu, float match_conf, int num_matches_thresh1) {
        return BestOf2NearestMatcher.__fromPtr__(create_2(try_use_gpu, match_conf, num_matches_thresh1));
    }

    public static BestOf2NearestMatcher create(boolean try_use_gpu, float match_conf) {
        return BestOf2NearestMatcher.__fromPtr__(create_3(try_use_gpu, match_conf));
    }

    public static BestOf2NearestMatcher create(boolean try_use_gpu) {
        return BestOf2NearestMatcher.__fromPtr__(create_4(try_use_gpu));
    }

    public static BestOf2NearestMatcher create() {
        return BestOf2NearestMatcher.__fromPtr__(create_5());
    }


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // C++:   cv::detail::BestOf2NearestMatcher::BestOf2NearestMatcher(bool try_use_gpu = false, float match_conf = 0.3f, int num_matches_thresh1 = 6, int num_matches_thresh2 = 6, double matches_confindece_thresh = 3.)
    private static native long BestOf2NearestMatcher_0(boolean try_use_gpu, float match_conf, int num_matches_thresh1, int num_matches_thresh2, double matches_confindece_thresh);
    private static native long BestOf2NearestMatcher_1(boolean try_use_gpu, float match_conf, int num_matches_thresh1, int num_matches_thresh2);
    private static native long BestOf2NearestMatcher_2(boolean try_use_gpu, float match_conf, int num_matches_thresh1);
    private static native long BestOf2NearestMatcher_3(boolean try_use_gpu, float match_conf);
    private static native long BestOf2NearestMatcher_4(boolean try_use_gpu);
    private static native long BestOf2NearestMatcher_5();

    // C++:  void cv::detail::BestOf2NearestMatcher::collectGarbage()
    private static native void collectGarbage_0(long nativeObj);

    // C++: static Ptr_BestOf2NearestMatcher cv::detail::BestOf2NearestMatcher::create(bool try_use_gpu = false, float match_conf = 0.3f, int num_matches_thresh1 = 6, int num_matches_thresh2 = 6, double matches_confindece_thresh = 3.)
    private static native long create_0(boolean try_use_gpu, float match_conf, int num_matches_thresh1, int num_matches_thresh2, double matches_confindece_thresh);
    private static native long create_1(boolean try_use_gpu, float match_conf, int num_matches_thresh1, int num_matches_thresh2);
    private static native long create_2(boolean try_use_gpu, float match_conf, int num_matches_thresh1);
    private static native long create_3(boolean try_use_gpu, float match_conf);
    private static native long create_4(boolean try_use_gpu);
    private static native long create_5();

    // native support for java finalize()
    private static native void delete(long nativeObj);

}
