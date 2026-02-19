//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.stitching;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.stitching.Timelapser;

// C++: class Timelapser

public class Timelapser {

    protected final long nativeObj;
    protected Timelapser(long addr) { nativeObj = addr; }

    public long getNativeObjAddr() { return nativeObj; }

    // internal usage only
    public static Timelapser __fromPtr__(long addr) { return new Timelapser(addr); }

    // C++: enum <unnamed>
    public static final int
            AS_IS = 0,
            CROP = 1;


    //
    // C++: static Ptr_Timelapser cv::detail::Timelapser::createDefault(int type)
    //

    public static Timelapser createDefault(int type) {
        return Timelapser.__fromPtr__(createDefault_0(type));
    }


    //
    // C++:  void cv::detail::Timelapser::initialize(vector_Point corners, vector_Size sizes)
    //

    // Unknown type 'vector_Size' (I), skipping the function


    //
    // C++:  void cv::detail::Timelapser::process(Mat img, Mat mask, Point tl)
    //

    public void process(Mat img, Mat mask, Point tl) {
        process_0(nativeObj, img.nativeObj, mask.nativeObj, tl.x, tl.y);
    }


    //
    // C++:  UMat cv::detail::Timelapser::getDst()
    //

    // Return type 'UMat' is not supported, skipping the function


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // C++: static Ptr_Timelapser cv::detail::Timelapser::createDefault(int type)
    private static native long createDefault_0(int type);

    // C++:  void cv::detail::Timelapser::process(Mat img, Mat mask, Point tl)
    private static native void process_0(long nativeObj, long img_nativeObj, long mask_nativeObj, double tl_x, double tl_y);

    // native support for java finalize()
    private static native void delete(long nativeObj);

}
