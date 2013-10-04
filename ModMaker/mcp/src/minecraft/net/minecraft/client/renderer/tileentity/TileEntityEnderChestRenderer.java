package net.minecraft.client.renderer.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelChest;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityEnderChest;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class TileEntityEnderChestRenderer extends TileEntitySpecialRenderer
{
    private static final ResourceLocation field_110637_a = new ResourceLocation("textures/entity/chest/ender.png");
    private ModelChest field_76900_a = new ModelChest();

    public void func_76899_a(TileEntityEnderChest p_76899_1_, double p_76899_2_, double p_76899_4_, double p_76899_6_, float p_76899_8_)
    {
        int i = 0;

        if (p_76899_1_.func_70309_m())
        {
            i = p_76899_1_.func_70322_n();
        }

        this.func_110628_a(field_110637_a);
        GL11.glPushMatrix();
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glTranslatef((float)p_76899_2_, (float)p_76899_4_ + 1.0F, (float)p_76899_6_ + 1.0F);
        GL11.glScalef(1.0F, -1.0F, -1.0F);
        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
        short short1 = 0;

        if (i == 2)
        {
            short1 = 180;
        }

        if (i == 3)
        {
            short1 = 0;
        }

        if (i == 4)
        {
            short1 = 90;
        }

        if (i == 5)
        {
            short1 = -90;
        }

        GL11.glRotatef((float)short1, 0.0F, 1.0F, 0.0F);
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        float f1 = p_76899_1_.field_70368_b + (p_76899_1_.field_70370_a - p_76899_1_.field_70368_b) * p_76899_8_;
        f1 = 1.0F - f1;
        f1 = 1.0F - f1 * f1 * f1;
        this.field_76900_a.field_78234_a.field_78795_f = -(f1 * (float)Math.PI / 2.0F);
        this.field_76900_a.func_78231_a();
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    public void func_76894_a(TileEntity p_76894_1_, double p_76894_2_, double p_76894_4_, double p_76894_6_, float p_76894_8_)
    {
        this.func_76899_a((TileEntityEnderChest)p_76894_1_, p_76894_2_, p_76894_4_, p_76894_6_, p_76894_8_);
    }
}
