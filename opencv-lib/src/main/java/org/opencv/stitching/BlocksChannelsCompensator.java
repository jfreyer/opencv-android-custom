//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.stitching;

import org.opencv.stitching.BlocksCompensator;

// C++: class BlocksChannelsCompensator
/**
 * Exposure compensator which tries to remove exposure related artifacts by adjusting image block
 * on each channel.
 */
public class BlocksChannelsCompensator extends BlocksCompensator {

    protected BlocksChannelsCompensator(long addr) { super(addr); }

    // internal usage only
    public static BlocksChannelsCompensator __fromPtr__(long addr) { return new BlocksChannelsCompensator(addr); }

    //
    // C++:   cv::detail::BlocksChannelsCompensator::BlocksChannelsCompensator(int bl_width = 32, int bl_height = 32, int nr_feeds = 1)
    //

    public BlocksChannelsCompensator(int bl_width, int bl_height, int nr_feeds) {
        super(BlocksChannelsCompensator_0(bl_width, bl_height, nr_feeds));
    }

    public BlocksChannelsCompensator(int bl_width, int bl_height) {
        super(BlocksChannelsCompensator_1(bl_width, bl_height));
    }

    public BlocksChannelsCompensator(int bl_width) {
        super(BlocksChannelsCompensator_2(bl_width));
    }

    public BlocksChannelsCompensator() {
        super(BlocksChannelsCompensator_3());
    }


    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }



    // C++:   cv::detail::BlocksChannelsCompensator::BlocksChannelsCompensator(int bl_width = 32, int bl_height = 32, int nr_feeds = 1)
    private static native long BlocksChannelsCompensator_0(int bl_width, int bl_height, int nr_feeds);
    private static native long BlocksChannelsCompensator_1(int bl_width, int bl_height);
    private static native long BlocksChannelsCompensator_2(int bl_width);
    private static native long BlocksChannelsCompensator_3();

    // native support for java finalize()
    private static native void delete(long nativeObj);

}
