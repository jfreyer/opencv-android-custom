//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.stitching;

import org.opencv.stitching.WarperCreator;

// C++: class AffineWarper
/**
 * Affine warper factory class.
 *   SEE: detail::AffineWarper
 */
public class AffineWarper extends WarperCreator {

    protected AffineWarper(long addr) { super(addr); }

    // internal usage only
    public static AffineWarper __fromPtr__(long addr) { return new AffineWarper(addr); }

    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // native support for java finalize()
    private static native void delete(long nativeObj);

}
