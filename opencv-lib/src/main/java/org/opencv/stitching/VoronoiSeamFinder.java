//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.stitching;

import org.opencv.stitching.PairwiseSeamFinder;

// C++: class VoronoiSeamFinder
/**
 * Voronoi diagram-based seam estimator.
 */
public class VoronoiSeamFinder extends PairwiseSeamFinder {

    protected VoronoiSeamFinder(long addr) { super(addr); }

    // internal usage only
    public static VoronoiSeamFinder __fromPtr__(long addr) { return new VoronoiSeamFinder(addr); }

    //
    // C++:  void cv::detail::VoronoiSeamFinder::find(vector_UMat src, vector_Point corners, vector_UMat& masks)
    //

    // Unknown type 'vector_UMat' (I), skipping the function


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // native support for java finalize()
    private static native void delete(long nativeObj);

}
