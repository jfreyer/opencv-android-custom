//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.stitching;

import org.opencv.stitching.WarperCreator;

// C++: class PlaneWarper
/**
 * Plane warper factory class.
 *   SEE: detail::PlaneWarper
 */
public class PlaneWarper extends WarperCreator {

    protected PlaneWarper(long addr) { super(addr); }

    // internal usage only
    public static PlaneWarper __fromPtr__(long addr) { return new PlaneWarper(addr); }

    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // native support for java finalize()
    private static native void delete(long nativeObj);

}
