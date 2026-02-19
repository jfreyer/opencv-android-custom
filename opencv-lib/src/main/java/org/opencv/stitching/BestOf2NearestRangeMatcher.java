//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.stitching;

import org.opencv.stitching.BestOf2NearestMatcher;

// C++: class BestOf2NearestRangeMatcher

public class BestOf2NearestRangeMatcher extends BestOf2NearestMatcher {

    protected BestOf2NearestRangeMatcher(long addr) { super(addr); }

    // internal usage only
    public static BestOf2NearestRangeMatcher __fromPtr__(long addr) { return new BestOf2NearestRangeMatcher(addr); }

    //
    // C++:   cv::detail::BestOf2NearestRangeMatcher::BestOf2NearestRangeMatcher(int range_width = 5, bool try_use_gpu = false, float match_conf = 0.3f, int num_matches_thresh1 = 6, int num_matches_thresh2 = 6)
    //

    public BestOf2NearestRangeMatcher(int range_width, boolean try_use_gpu, float match_conf, int num_matches_thresh1, int num_matches_thresh2) {
        super(BestOf2NearestRangeMatcher_0(range_width, try_use_gpu, match_conf, num_matches_thresh1, num_matches_thresh2));
    }

    public BestOf2NearestRangeMatcher(int range_width, boolean try_use_gpu, float match_conf, int num_matches_thresh1) {
        super(BestOf2NearestRangeMatcher_1(range_width, try_use_gpu, match_conf, num_matches_thresh1));
    }

    public BestOf2NearestRangeMatcher(int range_width, boolean try_use_gpu, float match_conf) {
        super(BestOf2NearestRangeMatcher_2(range_width, try_use_gpu, match_conf));
    }

    public BestOf2NearestRangeMatcher(int range_width, boolean try_use_gpu) {
        super(BestOf2NearestRangeMatcher_3(range_width, try_use_gpu));
    }

    public BestOf2NearestRangeMatcher(int range_width) {
        super(BestOf2NearestRangeMatcher_4(range_width));
    }

    public BestOf2NearestRangeMatcher() {
        super(BestOf2NearestRangeMatcher_5());
    }


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // C++:   cv::detail::BestOf2NearestRangeMatcher::BestOf2NearestRangeMatcher(int range_width = 5, bool try_use_gpu = false, float match_conf = 0.3f, int num_matches_thresh1 = 6, int num_matches_thresh2 = 6)
    private static native long BestOf2NearestRangeMatcher_0(int range_width, boolean try_use_gpu, float match_conf, int num_matches_thresh1, int num_matches_thresh2);
    private static native long BestOf2NearestRangeMatcher_1(int range_width, boolean try_use_gpu, float match_conf, int num_matches_thresh1);
    private static native long BestOf2NearestRangeMatcher_2(int range_width, boolean try_use_gpu, float match_conf);
    private static native long BestOf2NearestRangeMatcher_3(int range_width, boolean try_use_gpu);
    private static native long BestOf2NearestRangeMatcher_4(int range_width);
    private static native long BestOf2NearestRangeMatcher_5();

    // native support for java finalize()
    private static native void delete(long nativeObj);

}
