//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.stitching;

import org.opencv.stitching.ProjectorBase;

// C++: class SphericalProjector
/**
 * Extracts rotation and translation matrices from matrix H representing
 *         affine transformation in homogeneous coordinates
 */
public class SphericalProjector extends ProjectorBase {

    protected SphericalProjector(long addr) { super(addr); }

    // internal usage only
    public static SphericalProjector __fromPtr__(long addr) { return new SphericalProjector(addr); }

    //
    // C++:  void cv::detail::SphericalProjector::mapForward(float x, float y, float u, float v)
    //

    public void mapForward(float x, float y, float u, float v) {
        mapForward_0(nativeObj, x, y, u, v);
    }


    //
    // C++:  void cv::detail::SphericalProjector::mapBackward(float u, float v, float x, float y)
    //

    public void mapBackward(float u, float v, float x, float y) {
        mapBackward_0(nativeObj, u, v, x, y);
    }


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // C++:  void cv::detail::SphericalProjector::mapForward(float x, float y, float u, float v)
    private static native void mapForward_0(long nativeObj, float x, float y, float u, float v);

    // C++:  void cv::detail::SphericalProjector::mapBackward(float u, float v, float x, float y)
    private static native void mapBackward_0(long nativeObj, float u, float v, float x, float y);

    // native support for java finalize()
    private static native void delete(long nativeObj);

}
