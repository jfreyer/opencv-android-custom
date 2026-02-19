//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.stitching;



// C++: class WarperCreator
/**
 * Image warper factories base class.
 */
public class WarperCreator {

    protected final long nativeObj;
    protected WarperCreator(long addr) { nativeObj = addr; }

    public long getNativeObjAddr() { return nativeObj; }

    // internal usage only
    public static WarperCreator __fromPtr__(long addr) { return new WarperCreator(addr); }

    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // native support for java finalize()
    private static native void delete(long nativeObj);

}
