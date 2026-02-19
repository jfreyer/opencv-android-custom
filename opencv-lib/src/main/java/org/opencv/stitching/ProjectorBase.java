//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.stitching;



// C++: class ProjectorBase
/**
 * Base class for warping logic implementation.
 */
public class ProjectorBase {

    protected final long nativeObj;
    protected ProjectorBase(long addr) { nativeObj = addr; }

    public long getNativeObjAddr() { return nativeObj; }

    // internal usage only
    public static ProjectorBase __fromPtr__(long addr) { return new ProjectorBase(addr); }

    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // native support for java finalize()
    private static native void delete(long nativeObj);

}
