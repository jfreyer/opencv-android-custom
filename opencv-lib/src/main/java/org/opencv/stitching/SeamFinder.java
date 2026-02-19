//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.stitching;

import org.opencv.stitching.SeamFinder;

// C++: class SeamFinder
/**
 * Base class for a seam estimator.
 */
public class SeamFinder {

    protected final long nativeObj;
    protected SeamFinder(long addr) { nativeObj = addr; }

    public long getNativeObjAddr() { return nativeObj; }

    // internal usage only
    public static SeamFinder __fromPtr__(long addr) { return new SeamFinder(addr); }

    // C++: enum <unnamed>
    public static final int
            NO = 0,
            VORONOI_SEAM = 1,
            DP_SEAM = 2;


    //
    // C++:  void cv::detail::SeamFinder::find(vector_UMat src, vector_Point corners, vector_UMat& masks)
    //

    // Unknown type 'vector_UMat' (I), skipping the function


    //
    // C++: static Ptr_SeamFinder cv::detail::SeamFinder::createDefault(int type)
    //

    public static SeamFinder createDefault(int type) {
        return SeamFinder.__fromPtr__(createDefault_0(type));
    }


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // C++: static Ptr_SeamFinder cv::detail::SeamFinder::createDefault(int type)
    private static native long createDefault_0(int type);

    // native support for java finalize()
    private static native void delete(long nativeObj);

}
