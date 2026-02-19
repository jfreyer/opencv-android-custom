//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.stitching;

import org.opencv.stitching.WarperCreator;

// C++: class StereographicWarper

public class StereographicWarper extends WarperCreator {

    protected StereographicWarper(long addr) { super(addr); }

    // internal usage only
    public static StereographicWarper __fromPtr__(long addr) { return new StereographicWarper(addr); }

    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // native support for java finalize()
    private static native void delete(long nativeObj);

}
