//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.stitching;

import org.opencv.stitching.WarperCreator;

// C++: class FisheyeWarper

public class FisheyeWarper extends WarperCreator {

    protected FisheyeWarper(long addr) { super(addr); }

    // internal usage only
    public static FisheyeWarper __fromPtr__(long addr) { return new FisheyeWarper(addr); }

    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // native support for java finalize()
    private static native void delete(long nativeObj);

}
