//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.stitching;

import org.opencv.stitching.Timelapser;

// C++: class TimelapserCrop

public class TimelapserCrop extends Timelapser {

    protected TimelapserCrop(long addr) { super(addr); }

    // internal usage only
    public static TimelapserCrop __fromPtr__(long addr) { return new TimelapserCrop(addr); }

    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // native support for java finalize()
    private static native void delete(long nativeObj);

}
