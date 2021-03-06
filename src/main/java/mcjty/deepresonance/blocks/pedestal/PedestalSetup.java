package mcjty.deepresonance.blocks.pedestal;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PedestalSetup {
    public static PedestalBlock pedestalBlock;

    public static void setupBlocks() {
        pedestalBlock = new PedestalBlock();
    }

    @SideOnly(Side.CLIENT)
    public static void setupModels() {
        pedestalBlock.initModel();
    }
}
