//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.stitching;

import org.opencv.stitching.WarperCreator;

// C++: class TransverseMercatorWarper

public class TransverseMercatorWarper extends WarperCreator {

    protected TransverseMercatorWarper(long addr) { super(addr); }

    // internal usage only
    public static TransverseMercatorWarper __fromPtr__(long addr) { return new TransverseMercatorWarper(addr); }

    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // native support for java finalize()
    private static native void delete(long nativeObj);

}
