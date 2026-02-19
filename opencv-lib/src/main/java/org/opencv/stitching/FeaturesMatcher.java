//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.stitching;



// C++: class FeaturesMatcher
/**
 * Feature matchers base class.
 */
public class FeaturesMatcher {

    protected final long nativeObj;
    protected FeaturesMatcher(long addr) { nativeObj = addr; }

    public long getNativeObjAddr() { return nativeObj; }

    // internal usage only
    public static FeaturesMatcher __fromPtr__(long addr) { return new FeaturesMatcher(addr); }

    //
    // C++:  bool cv::detail::FeaturesMatcher::isThreadSafe()
    //

    /**
     * @return True, if it's possible to use the same matcher instance in parallel, false otherwise
     */
    public boolean isThreadSafe() {
        return isThreadSafe_0(nativeObj);
    }


    //
    // C++:  void cv::detail::FeaturesMatcher::collectGarbage()
    //

    /**
     * Frees unused memory allocated before if there is any.
     */
    public void collectGarbage() {
        collectGarbage_0(nativeObj);
    }


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // C++:  bool cv::detail::FeaturesMatcher::isThreadSafe()
    private static native boolean isThreadSafe_0(long nativeObj);

    // C++:  void cv::detail::FeaturesMatcher::collectGarbage()
    private static native void collectGarbage_0(long nativeObj);

    // native support for java finalize()
    private static native void delete(long nativeObj);

}
