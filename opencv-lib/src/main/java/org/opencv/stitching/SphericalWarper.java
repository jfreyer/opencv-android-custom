//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.stitching;

import org.opencv.stitching.WarperCreator;

// C++: class SphericalWarper
/**
 * Spherical warper factory class
 */
public class SphericalWarper extends WarperCreator {

    protected SphericalWarper(long addr) { super(addr); }

    // internal usage only
    public static SphericalWarper __fromPtr__(long addr) { return new SphericalWarper(addr); }

    //
    // C++:   cv::SphericalWarper::SphericalWarper()
    //

    public SphericalWarper() {
        super(SphericalWarper_0());
    }


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // C++:   cv::SphericalWarper::SphericalWarper()
    private static native long SphericalWarper_0();

    // native support for java finalize()
    private static native void delete(long nativeObj);

}
