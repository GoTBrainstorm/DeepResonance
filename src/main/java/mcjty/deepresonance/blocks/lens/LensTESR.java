package mcjty.deepresonance.blocks.lens;

import mcjty.deepresonance.DeepResonance;
import mcjty.lib.varia.OrientationTools;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class LensTESR extends TileEntitySpecialRenderer {
    //IModelCustom model = AdvancedModelLoader.loadModel(new ResourceLocation(DeepResonance.MODID, "obj/lens.obj"));
    ResourceLocation blockTexture = new ResourceLocation(DeepResonance.MODID, "textures/blocks/lens.png");

    @Override
    public void render(TileEntity tileEntity, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        GL11.glPushAttrib(GL11.GL_CURRENT_BIT | GL11.GL_DEPTH_BUFFER_BIT | GL11.GL_ENABLE_BIT | GL11.GL_LIGHTING_BIT | GL11.GL_TEXTURE_BIT);

        bindTexture(blockTexture);

        GL11.glPushMatrix();

        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
//        GL11.glDepthMask(false);
//        GL11.glEnable(GL11.GL_DEPTH_TEST);

        GL11.glTranslatef((float) x + 0.5F, (float) y + 0.0F, (float) z + 0.5F);
        EnumFacing direction = OrientationTools.getOrientationHoriz(Minecraft.getMinecraft().world.getBlockState(tileEntity.getPos()));
        switch (direction) {
            case DOWN:
            case UP:
                break;
            case NORTH:
                break;
            case SOUTH:
                GL11.glRotatef(180, 0, 1, 0);
                break;
            case WEST:
                GL11.glRotatef(90, 0, 1, 0);
                break;
            case EAST:
                GL11.glRotatef(270, 0, 1, 0);
                break;
        }

       // model.renderAll();
        GL11.glPopMatrix();

        GL11.glPopAttrib();
    }
}
