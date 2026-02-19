//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.stitching;



// C++: class GraphCutSeamFinder
/**
 * Minimum graph cut-based seam estimator. See details in CITE: V03 .
 */
public class GraphCutSeamFinder extends Base {

    protected GraphCutSeamFinder(long addr) { super(addr); }

    // internal usage only
    public static GraphCutSeamFinder __fromPtr__(long addr) { return new GraphCutSeamFinder(addr); }

    //
    // C++:   cv::detail::GraphCutSeamFinder::GraphCutSeamFinder(String cost_type, float terminal_cost = 10000.f, float bad_region_penalty = 1000.f)
    //

    public GraphCutSeamFinder(String cost_type, float terminal_cost, float bad_region_penalty) {
        super(GraphCutSeamFinder_0(cost_type, terminal_cost, bad_region_penalty));
    }

    public GraphCutSeamFinder(String cost_type, float terminal_cost) {
        super(GraphCutSeamFinder_1(cost_type, terminal_cost));
    }

    public GraphCutSeamFinder(String cost_type) {
        super(GraphCutSeamFinder_2(cost_type));
    }


    //
    // C++:  void cv::detail::GraphCutSeamFinder::find(vector_UMat src, vector_Point corners, vector_UMat& masks)
    //

    // Unknown type 'vector_UMat' (I), skipping the function


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // C++:   cv::detail::GraphCutSeamFinder::GraphCutSeamFinder(String cost_type, float terminal_cost = 10000.f, float bad_region_penalty = 1000.f)
    private static native long GraphCutSeamFinder_0(String cost_type, float terminal_cost, float bad_region_penalty);
    private static native long GraphCutSeamFinder_1(String cost_type, float terminal_cost);
    private static native long GraphCutSeamFinder_2(String cost_type);

    // native support for java finalize()
    private static native void delete(long nativeObj);

}
