//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.stitching;

import org.opencv.stitching.SeamFinder;

// C++: class NoSeamFinder
/**
 * Stub seam estimator which does nothing.
 */
public class NoSeamFinder extends SeamFinder {

    protected NoSeamFinder(long addr) { super(addr); }

    // internal usage only
    public static NoSeamFinder __fromPtr__(long addr) { return new NoSeamFinder(addr); }

    //
    // C++:  void cv::detail::NoSeamFinder::find(vector_UMat arg1, vector_Point arg2, vector_UMat& arg3)
    //

    // Unknown type 'vector_UMat' (I), skipping the function


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // native support for java finalize()
    private static native void delete(long nativeObj);

}
