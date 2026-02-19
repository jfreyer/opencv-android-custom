//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.stitching;

import org.opencv.stitching.SeamFinder;

// C++: class PairwiseSeamFinder
/**
 * Base class for all pairwise seam estimators.
 */
public class PairwiseSeamFinder extends SeamFinder {

    protected PairwiseSeamFinder(long addr) { super(addr); }

    // internal usage only
    public static PairwiseSeamFinder __fromPtr__(long addr) { return new PairwiseSeamFinder(addr); }

    //
    // C++:  void cv::detail::PairwiseSeamFinder::find(vector_UMat src, vector_Point corners, vector_UMat& masks)
    //

    // Unknown type 'vector_UMat' (I), skipping the function


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // native support for java finalize()
    private static native void delete(long nativeObj);

}
