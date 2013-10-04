package net.minecraft.client.renderer.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelSign;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class TileEntitySignRenderer extends TileEntitySpecialRenderer
{
    private static final ResourceLocation field_110638_a = new ResourceLocation("textures/entity/sign.png");
    private final ModelSign field_76910_a = new ModelSign();

    public void func_76909_a(TileEntitySign p_76909_1_, double p_76909_2_, double p_76909_4_, double p_76909_6_, float p_76909_8_)
    {
        Block block = p_76909_1_.func_70311_o();
        GL11.glPushMatrix();
        float f1 = 0.6666667F;
        float f2;

        if (block == Block.field_72053_aD)
        {
            GL11.glTranslatef((float)p_76909_2_ + 0.5F, (float)p_76909_4_ + 0.75F * f1, (float)p_76909_6_ + 0.5F);
            float f3 = (float)(p_76909_1_.func_70322_n() * 360) / 16.0F;
            GL11.glRotatef(-f3, 0.0F, 1.0F, 0.0F);
            this.field_76910_a.field_78165_b.field_78806_j = true;
        }
        else
        {
            int i = p_76909_1_.func_70322_n();
            f2 = 0.0F;

            if (i == 2)
            {
                f2 = 180.0F;
            }

            if (i == 4)
            {
                f2 = 90.0F;
            }

            if (i == 5)
            {
                f2 = -90.0F;
            }

            GL11.glTranslatef((float)p_76909_2_ + 0.5F, (float)p_76909_4_ + 0.75F * f1, (float)p_76909_6_ + 0.5F);
            GL11.glRotatef(-f2, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(0.0F, -0.3125F, -0.4375F);
            this.field_76910_a.field_78165_b.field_78806_j = false;
        }

        this.func_110628_a(field_110638_a);
        GL11.glPushMatrix();
        GL11.glScalef(f1, -f1, -f1);
        this.field_76910_a.func_78164_a();
        GL11.glPopMatrix();
        FontRenderer fontrenderer = this.func_76895_b();
        f2 = 0.016666668F * f1;
        GL11.glTranslatef(0.0F, 0.5F * f1, 0.07F * f1);
        GL11.glScalef(f2, -f2, f2);
        GL11.glNormal3f(0.0F, 0.0F, -1.0F * f2);
        GL11.glDepthMask(false);
        byte b0 = 0;

        for (int j = 0; j < p_76909_1_.field_70412_a.length; ++j)
        {
            String s = p_76909_1_.field_70412_a[j];

            if (j == p_76909_1_.field_70410_b)
            {
                s = "> " + s + " <";
                fontrenderer.func_78276_b(s, -fontrenderer.func_78256_a(s) / 2, j * 10 - p_76909_1_.field_70412_a.length * 5, b0);
            }
            else
            {
                fontrenderer.func_78276_b(s, -fontrenderer.func_78256_a(s) / 2, j * 10 - p_76909_1_.field_70412_a.length * 5, b0);
            }
        }

        GL11.glDepthMask(true);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glPopMatrix();
    }

    public void func_76894_a(TileEntity p_76894_1_, double p_76894_2_, double p_76894_4_, double p_76894_6_, float p_76894_8_)
    {
        this.func_76909_a((TileEntitySign)p_76894_1_, p_76894_2_, p_76894_4_, p_76894_6_, p_76894_8_);
    }
}
