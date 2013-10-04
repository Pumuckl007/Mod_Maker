package net.minecraft.client.renderer.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class TileEntityBeaconRenderer extends TileEntitySpecialRenderer
{
    private static final ResourceLocation field_110629_a = new ResourceLocation("textures/entity/beacon_beam.png");

    public void func_82398_a(TileEntityBeacon p_82398_1_, double p_82398_2_, double p_82398_4_, double p_82398_6_, float p_82398_8_)
    {
        float f1 = p_82398_1_.func_82125_v_();

        if (f1 > 0.0F)
        {
            Tessellator tessellator = Tessellator.field_78398_a;
            this.func_110628_a(field_110629_a);
            GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, 10497.0F);
            GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, 10497.0F);
            GL11.glDisable(GL11.GL_LIGHTING);
            GL11.glDisable(GL11.GL_CULL_FACE);
            GL11.glDisable(GL11.GL_BLEND);
            GL11.glDepthMask(true);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
            float f2 = (float)p_82398_1_.func_70314_l().func_82737_E() + p_82398_8_;
            float f3 = -f2 * 0.2F - (float)MathHelper.func_76141_d(-f2 * 0.1F);
            byte b0 = 1;
            double d3 = (double)f2 * 0.025D * (1.0D - (double)(b0 & 1) * 2.5D);
            tessellator.func_78382_b();
            tessellator.func_78370_a(255, 255, 255, 32);
            double d4 = (double)b0 * 0.2D;
            double d5 = 0.5D + Math.cos(d3 + 2.356194490192345D) * d4;
            double d6 = 0.5D + Math.sin(d3 + 2.356194490192345D) * d4;
            double d7 = 0.5D + Math.cos(d3 + (Math.PI / 4D)) * d4;
            double d8 = 0.5D + Math.sin(d3 + (Math.PI / 4D)) * d4;
            double d9 = 0.5D + Math.cos(d3 + 3.9269908169872414D) * d4;
            double d10 = 0.5D + Math.sin(d3 + 3.9269908169872414D) * d4;
            double d11 = 0.5D + Math.cos(d3 + 5.497787143782138D) * d4;
            double d12 = 0.5D + Math.sin(d3 + 5.497787143782138D) * d4;
            double d13 = (double)(256.0F * f1);
            double d14 = 0.0D;
            double d15 = 1.0D;
            double d16 = (double)(-1.0F + f3);
            double d17 = (double)(256.0F * f1) * (0.5D / d4) + d16;
            tessellator.func_78374_a(p_82398_2_ + d5, p_82398_4_ + d13, p_82398_6_ + d6, d15, d17);
            tessellator.func_78374_a(p_82398_2_ + d5, p_82398_4_, p_82398_6_ + d6, d15, d16);
            tessellator.func_78374_a(p_82398_2_ + d7, p_82398_4_, p_82398_6_ + d8, d14, d16);
            tessellator.func_78374_a(p_82398_2_ + d7, p_82398_4_ + d13, p_82398_6_ + d8, d14, d17);
            tessellator.func_78374_a(p_82398_2_ + d11, p_82398_4_ + d13, p_82398_6_ + d12, d15, d17);
            tessellator.func_78374_a(p_82398_2_ + d11, p_82398_4_, p_82398_6_ + d12, d15, d16);
            tessellator.func_78374_a(p_82398_2_ + d9, p_82398_4_, p_82398_6_ + d10, d14, d16);
            tessellator.func_78374_a(p_82398_2_ + d9, p_82398_4_ + d13, p_82398_6_ + d10, d14, d17);
            tessellator.func_78374_a(p_82398_2_ + d7, p_82398_4_ + d13, p_82398_6_ + d8, d15, d17);
            tessellator.func_78374_a(p_82398_2_ + d7, p_82398_4_, p_82398_6_ + d8, d15, d16);
            tessellator.func_78374_a(p_82398_2_ + d11, p_82398_4_, p_82398_6_ + d12, d14, d16);
            tessellator.func_78374_a(p_82398_2_ + d11, p_82398_4_ + d13, p_82398_6_ + d12, d14, d17);
            tessellator.func_78374_a(p_82398_2_ + d9, p_82398_4_ + d13, p_82398_6_ + d10, d15, d17);
            tessellator.func_78374_a(p_82398_2_ + d9, p_82398_4_, p_82398_6_ + d10, d15, d16);
            tessellator.func_78374_a(p_82398_2_ + d5, p_82398_4_, p_82398_6_ + d6, d14, d16);
            tessellator.func_78374_a(p_82398_2_ + d5, p_82398_4_ + d13, p_82398_6_ + d6, d14, d17);
            tessellator.func_78381_a();
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            GL11.glDepthMask(false);
            tessellator.func_78382_b();
            tessellator.func_78370_a(255, 255, 255, 32);
            double d18 = 0.2D;
            double d19 = 0.2D;
            double d20 = 0.8D;
            double d21 = 0.2D;
            double d22 = 0.2D;
            double d23 = 0.8D;
            double d24 = 0.8D;
            double d25 = 0.8D;
            double d26 = (double)(256.0F * f1);
            double d27 = 0.0D;
            double d28 = 1.0D;
            double d29 = (double)(-1.0F + f3);
            double d30 = (double)(256.0F * f1) + d29;
            tessellator.func_78374_a(p_82398_2_ + d18, p_82398_4_ + d26, p_82398_6_ + d19, d28, d30);
            tessellator.func_78374_a(p_82398_2_ + d18, p_82398_4_, p_82398_6_ + d19, d28, d29);
            tessellator.func_78374_a(p_82398_2_ + d20, p_82398_4_, p_82398_6_ + d21, d27, d29);
            tessellator.func_78374_a(p_82398_2_ + d20, p_82398_4_ + d26, p_82398_6_ + d21, d27, d30);
            tessellator.func_78374_a(p_82398_2_ + d24, p_82398_4_ + d26, p_82398_6_ + d25, d28, d30);
            tessellator.func_78374_a(p_82398_2_ + d24, p_82398_4_, p_82398_6_ + d25, d28, d29);
            tessellator.func_78374_a(p_82398_2_ + d22, p_82398_4_, p_82398_6_ + d23, d27, d29);
            tessellator.func_78374_a(p_82398_2_ + d22, p_82398_4_ + d26, p_82398_6_ + d23, d27, d30);
            tessellator.func_78374_a(p_82398_2_ + d20, p_82398_4_ + d26, p_82398_6_ + d21, d28, d30);
            tessellator.func_78374_a(p_82398_2_ + d20, p_82398_4_, p_82398_6_ + d21, d28, d29);
            tessellator.func_78374_a(p_82398_2_ + d24, p_82398_4_, p_82398_6_ + d25, d27, d29);
            tessellator.func_78374_a(p_82398_2_ + d24, p_82398_4_ + d26, p_82398_6_ + d25, d27, d30);
            tessellator.func_78374_a(p_82398_2_ + d22, p_82398_4_ + d26, p_82398_6_ + d23, d28, d30);
            tessellator.func_78374_a(p_82398_2_ + d22, p_82398_4_, p_82398_6_ + d23, d28, d29);
            tessellator.func_78374_a(p_82398_2_ + d18, p_82398_4_, p_82398_6_ + d19, d27, d29);
            tessellator.func_78374_a(p_82398_2_ + d18, p_82398_4_ + d26, p_82398_6_ + d19, d27, d30);
            tessellator.func_78381_a();
            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glEnable(GL11.GL_TEXTURE_2D);
            GL11.glDepthMask(true);
        }
    }

    public void func_76894_a(TileEntity p_76894_1_, double p_76894_2_, double p_76894_4_, double p_76894_6_, float p_76894_8_)
    {
        this.func_82398_a((TileEntityBeacon)p_76894_1_, p_76894_2_, p_76894_4_, p_76894_6_, p_76894_8_);
    }
}
