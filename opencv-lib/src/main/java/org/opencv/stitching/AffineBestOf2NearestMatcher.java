//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.stitching;

import org.opencv.stitching.BestOf2NearestMatcher;

// C++: class AffineBestOf2NearestMatcher
/**
 * Features matcher similar to cv::detail::BestOf2NearestMatcher which
 * finds two best matches for each feature and leaves the best one only if the
 * ratio between descriptor distances is greater than the threshold match_conf.
 *
 * Unlike cv::detail::BestOf2NearestMatcher this matcher uses affine
 * transformation (affine transformation estimate will be placed in matches_info).
 *
 * SEE: cv::detail::FeaturesMatcher cv::detail::BestOf2NearestMatcher
 */
public class AffineBestOf2NearestMatcher extends BestOf2NearestMatcher {

    protected AffineBestOf2NearestMatcher(long addr) { super(addr); }

    // internal usage only
    public static AffineBestOf2NearestMatcher __fromPtr__(long addr) { return new AffineBestOf2NearestMatcher(addr); }

    //
    // C++:   cv::detail::AffineBestOf2NearestMatcher::AffineBestOf2NearestMatcher(bool full_affine = false, bool try_use_gpu = false, float match_conf = 0.3f, int num_matches_thresh1 = 6)
    //

    /**
     * Constructs a "best of 2 nearest" matcher that expects affine transformation
     *     between images
     *
     *     @param full_affine whether to use full affine transformation with 6 degress of freedom or reduced
     *     transformation with 4 degrees of freedom using only rotation, translation and uniform scaling
     *     @param try_use_gpu Should try to use GPU or not
     *     @param match_conf Match distances ration threshold
     *     @param num_matches_thresh1 Minimum number of matches required for the 2D affine transform
     *     estimation used in the inliers classification step
     *
     *     SEE: cv::estimateAffine2D cv::estimateAffinePartial2D
     */
    public AffineBestOf2NearestMatcher(boolean full_affine, boolean try_use_gpu, float match_conf, int num_matches_thresh1) {
        super(AffineBestOf2NearestMatcher_0(full_affine, try_use_gpu, match_conf, num_matches_thresh1));
    }

    /**
     * Constructs a "best of 2 nearest" matcher that expects affine transformation
     *     between images
     *
     *     @param full_affine whether to use full affine transformation with 6 degress of freedom or reduced
     *     transformation with 4 degrees of freedom using only rotation, translation and uniform scaling
     *     @param try_use_gpu Should try to use GPU or not
     *     @param match_conf Match distances ration threshold
     *     estimation used in the inliers classification step
     *
     *     SEE: cv::estimateAffine2D cv::estimateAffinePartial2D
     */
    public AffineBestOf2NearestMatcher(boolean full_affine, boolean try_use_gpu, float match_conf) {
        super(AffineBestOf2NearestMatcher_1(full_affine, try_use_gpu, match_conf));
    }

    /**
     * Constructs a "best of 2 nearest" matcher that expects affine transformation
     *     between images
     *
     *     @param full_affine whether to use full affine transformation with 6 degress of freedom or reduced
     *     transformation with 4 degrees of freedom using only rotation, translation and uniform scaling
     *     @param try_use_gpu Should try to use GPU or not
     *     estimation used in the inliers classification step
     *
     *     SEE: cv::estimateAffine2D cv::estimateAffinePartial2D
     */
    public AffineBestOf2NearestMatcher(boolean full_affine, boolean try_use_gpu) {
        super(AffineBestOf2NearestMatcher_2(full_affine, try_use_gpu));
    }

    /**
     * Constructs a "best of 2 nearest" matcher that expects affine transformation
     *     between images
     *
     *     @param full_affine whether to use full affine transformation with 6 degress of freedom or reduced
     *     transformation with 4 degrees of freedom using only rotation, translation and uniform scaling
     *     estimation used in the inliers classification step
     *
     *     SEE: cv::estimateAffine2D cv::estimateAffinePartial2D
     */
    public AffineBestOf2NearestMatcher(boolean full_affine) {
        super(AffineBestOf2NearestMatcher_3(full_affine));
    }

    /**
     * Constructs a "best of 2 nearest" matcher that expects affine transformation
     *     between images
     *
     *     transformation with 4 degrees of freedom using only rotation, translation and uniform scaling
     *     estimation used in the inliers classification step
     *
     *     SEE: cv::estimateAffine2D cv::estimateAffinePartial2D
     */
    public AffineBestOf2NearestMatcher() {
        super(AffineBestOf2NearestMatcher_4());
    }


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // C++:   cv::detail::AffineBestOf2NearestMatcher::AffineBestOf2NearestMatcher(bool full_affine = false, bool try_use_gpu = false, float match_conf = 0.3f, int num_matches_thresh1 = 6)
    private static native long AffineBestOf2NearestMatcher_0(boolean full_affine, boolean try_use_gpu, float match_conf, int num_matches_thresh1);
    private static native long AffineBestOf2NearestMatcher_1(boolean full_affine, boolean try_use_gpu, float match_conf);
    private static native long AffineBestOf2NearestMatcher_2(boolean full_affine, boolean try_use_gpu);
    private static native long AffineBestOf2NearestMatcher_3(boolean full_affine);
    private static native long AffineBestOf2NearestMatcher_4();

    // native support for java finalize()
    private static native void delete(long nativeObj);

}
