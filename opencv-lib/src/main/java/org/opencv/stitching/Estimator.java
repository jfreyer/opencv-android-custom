//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.stitching;



// C++: class Estimator
/**
 * Rotation estimator base class.
 *
 * It takes features of all images, pairwise matches between all images and estimates rotations of all
 * cameras.
 *
 * <b>Note:</b> The coordinate system origin is implementation-dependent, but you can always normalize the
 * rotations in respect to the first camera, for instance. :
 */
public class Estimator {

    protected final long nativeObj;
    protected Estimator(long addr) { nativeObj = addr; }

    public long getNativeObjAddr() { return nativeObj; }

    // internal usage only
    public static Estimator __fromPtr__(long addr) { return new Estimator(addr); }

    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // native support for java finalize()
    private static native void delete(long nativeObj);

}
