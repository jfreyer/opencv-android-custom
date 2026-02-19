//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.stitching;

import org.opencv.stitching.WarperCreator;

// C++: class CylindricalWarper
/**
 * Cylindrical warper factory class.
 * SEE: detail::CylindricalWarper
 */
public class CylindricalWarper extends WarperCreator {

    protected CylindricalWarper(long addr) { super(addr); }

    // internal usage only
    public static CylindricalWarper __fromPtr__(long addr) { return new CylindricalWarper(addr); }

    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // native support for java finalize()
    private static native void delete(long nativeObj);

}
