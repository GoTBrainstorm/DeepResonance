package mcjty.deepresonance.blocks.ore;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mcjty.deepresonance.DeepResonance;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class DenseGlassBlock extends Block {
    private IIcon icon;

    public DenseGlassBlock() {
        super(Material.glass);
        setHardness(3.0f);
        setResistance(500.0f);
        setStepSound(soundTypeGlass);
        setHarvestLevel("pickaxe", 2);
        setBlockName("denseGlass");
        setCreativeTab(DeepResonance.tabDeepResonance);
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        icon = iconRegister.registerIcon(DeepResonance.MODID + ":denseglass");
    }

    @Override
    public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side) {
        return icon;
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return icon;
    }

    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 0;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }
}
