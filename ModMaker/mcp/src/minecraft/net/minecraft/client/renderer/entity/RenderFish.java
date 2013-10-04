package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class RenderFish extends Render
{
    private static final ResourceLocation field_110792_a = new ResourceLocation("textures/particle/particles.png");

    public void func_77000_a(EntityFishHook p_77000_1_, double p_77000_2_, double p_77000_4_, double p_77000_6_, float p_77000_8_, float p_77000_9_)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)p_77000_2_, (float)p_77000_4_, (float)p_77000_6_);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glScalef(0.5F, 0.5F, 0.5F);
        this.func_110777_b(p_77000_1_);
        Tessellator tessellator = Tessellator.field_78398_a;
        byte b0 = 1;
        byte b1 = 2;
        float f2 = (float)(b0 * 8 + 0) / 128.0F;
        float f3 = (float)(b0 * 8 + 8) / 128.0F;
        float f4 = (float)(b1 * 8 + 0) / 128.0F;
        float f5 = (float)(b1 * 8 + 8) / 128.0F;
        float f6 = 1.0F;
        float f7 = 0.5F;
        float f8 = 0.5F;
        GL11.glRotatef(180.0F - this.field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-this.field_76990_c.field_78732_j, 1.0F, 0.0F, 0.0F);
        tessellator.func_78382_b();
        tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
        tessellator.func_78374_a((double)(0.0F - f7), (double)(0.0F - f8), 0.0D, (double)f2, (double)f5);
        tessellator.func_78374_a((double)(f6 - f7), (double)(0.0F - f8), 0.0D, (double)f3, (double)f5);
        tessellator.func_78374_a((double)(f6 - f7), (double)(1.0F - f8), 0.0D, (double)f3, (double)f4);
        tessellator.func_78374_a((double)(0.0F - f7), (double)(1.0F - f8), 0.0D, (double)f2, (double)f4);
        tessellator.func_78381_a();
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();

        if (p_77000_1_.field_70204_b != null)
        {
            float f9 = p_77000_1_.field_70204_b.func_70678_g(p_77000_9_);
            float f10 = MathHelper.func_76126_a(MathHelper.func_76129_c(f9) * (float)Math.PI);
            Vec3 vec3 = p_77000_1_.field_70170_p.func_82732_R().func_72345_a(-0.5D, 0.03D, 0.8D);
            vec3.func_72440_a(-(p_77000_1_.field_70204_b.field_70127_C + (p_77000_1_.field_70204_b.field_70125_A - p_77000_1_.field_70204_b.field_70127_C) * p_77000_9_) * (float)Math.PI / 180.0F);
            vec3.func_72442_b(-(p_77000_1_.field_70204_b.field_70126_B + (p_77000_1_.field_70204_b.field_70177_z - p_77000_1_.field_70204_b.field_70126_B) * p_77000_9_) * (float)Math.PI / 180.0F);
            vec3.func_72442_b(f10 * 0.5F);
            vec3.func_72440_a(-f10 * 0.7F);
            double d3 = p_77000_1_.field_70204_b.field_70169_q + (p_77000_1_.field_70204_b.field_70165_t - p_77000_1_.field_70204_b.field_70169_q) * (double)p_77000_9_ + vec3.field_72450_a;
            double d4 = p_77000_1_.field_70204_b.field_70167_r + (p_77000_1_.field_70204_b.field_70163_u - p_77000_1_.field_70204_b.field_70167_r) * (double)p_77000_9_ + vec3.field_72448_b;
            double d5 = p_77000_1_.field_70204_b.field_70166_s + (p_77000_1_.field_70204_b.field_70161_v - p_77000_1_.field_70204_b.field_70166_s) * (double)p_77000_9_ + vec3.field_72449_c;
            double d6 = p_77000_1_.field_70204_b == Minecraft.func_71410_x().field_71439_g ? 0.0D : (double)p_77000_1_.field_70204_b.func_70047_e();

            if (this.field_76990_c.field_78733_k.field_74320_O > 0 || p_77000_1_.field_70204_b != Minecraft.func_71410_x().field_71439_g)
            {
                float f11 = (p_77000_1_.field_70204_b.field_70760_ar + (p_77000_1_.field_70204_b.field_70761_aq - p_77000_1_.field_70204_b.field_70760_ar) * p_77000_9_) * (float)Math.PI / 180.0F;
                double d7 = (double)MathHelper.func_76126_a(f11);
                double d8 = (double)MathHelper.func_76134_b(f11);
                d3 = p_77000_1_.field_70204_b.field_70169_q + (p_77000_1_.field_70204_b.field_70165_t - p_77000_1_.field_70204_b.field_70169_q) * (double)p_77000_9_ - d8 * 0.35D - d7 * 0.85D;
                d4 = p_77000_1_.field_70204_b.field_70167_r + d6 + (p_77000_1_.field_70204_b.field_70163_u - p_77000_1_.field_70204_b.field_70167_r) * (double)p_77000_9_ - 0.45D;
                d5 = p_77000_1_.field_70204_b.field_70166_s + (p_77000_1_.field_70204_b.field_70161_v - p_77000_1_.field_70204_b.field_70166_s) * (double)p_77000_9_ - d7 * 0.35D + d8 * 0.85D;
            }

            double d9 = p_77000_1_.field_70169_q + (p_77000_1_.field_70165_t - p_77000_1_.field_70169_q) * (double)p_77000_9_;
            double d10 = p_77000_1_.field_70167_r + (p_77000_1_.field_70163_u - p_77000_1_.field_70167_r) * (double)p_77000_9_ + 0.25D;
            double d11 = p_77000_1_.field_70166_s + (p_77000_1_.field_70161_v - p_77000_1_.field_70166_s) * (double)p_77000_9_;
            double d12 = (double)((float)(d3 - d9));
            double d13 = (double)((float)(d4 - d10));
            double d14 = (double)((float)(d5 - d11));
            GL11.glDisable(GL11.GL_TEXTURE_2D);
            GL11.glDisable(GL11.GL_LIGHTING);
            tessellator.func_78371_b(3);
            tessellator.func_78378_d(0);
            byte b2 = 16;

            for (int i = 0; i <= b2; ++i)
            {
                float f12 = (float)i / (float)b2;
                tessellator.func_78377_a(p_77000_2_ + d12 * (double)f12, p_77000_4_ + d13 * (double)(f12 * f12 + f12) * 0.5D + 0.25D, p_77000_6_ + d14 * (double)f12);
            }

            tessellator.func_78381_a();
            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glEnable(GL11.GL_TEXTURE_2D);
        }
    }

    protected ResourceLocation func_110791_a(EntityFishHook p_110791_1_)
    {
        return field_110792_a;
    }

    protected ResourceLocation func_110775_a(Entity p_110775_1_)
    {
        return this.func_110791_a((EntityFishHook)p_110775_1_);
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.func_77000_a((EntityFishHook)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
