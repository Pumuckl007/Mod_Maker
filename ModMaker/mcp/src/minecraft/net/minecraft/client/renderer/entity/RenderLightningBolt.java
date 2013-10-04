package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderLightningBolt extends Render
{
    public void func_77028_a(EntityLightningBolt p_77028_1_, double p_77028_2_, double p_77028_4_, double p_77028_6_, float p_77028_8_, float p_77028_9_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
        double[] adouble = new double[8];
        double[] adouble1 = new double[8];
        double d3 = 0.0D;
        double d4 = 0.0D;
        Random random = new Random(p_77028_1_.field_70264_a);

        for (int i = 7; i >= 0; --i)
        {
            adouble[i] = d3;
            adouble1[i] = d4;
            d3 += (double)(random.nextInt(11) - 5);
            d4 += (double)(random.nextInt(11) - 5);
        }

        for (int j = 0; j < 4; ++j)
        {
            Random random1 = new Random(p_77028_1_.field_70264_a);

            for (int k = 0; k < 3; ++k)
            {
                int l = 7;
                int i1 = 0;

                if (k > 0)
                {
                    l = 7 - k;
                }

                if (k > 0)
                {
                    i1 = l - 2;
                }

                double d5 = adouble[l] - d3;
                double d6 = adouble1[l] - d4;

                for (int j1 = l; j1 >= i1; --j1)
                {
                    double d7 = d5;
                    double d8 = d6;

                    if (k == 0)
                    {
                        d5 += (double)(random1.nextInt(11) - 5);
                        d6 += (double)(random1.nextInt(11) - 5);
                    }
                    else
                    {
                        d5 += (double)(random1.nextInt(31) - 15);
                        d6 += (double)(random1.nextInt(31) - 15);
                    }

                    tessellator.func_78371_b(5);
                    float f2 = 0.5F;
                    tessellator.func_78369_a(0.9F * f2, 0.9F * f2, 1.0F * f2, 0.3F);
                    double d9 = 0.1D + (double)j * 0.2D;

                    if (k == 0)
                    {
                        d9 *= (double)j1 * 0.1D + 1.0D;
                    }

                    double d10 = 0.1D + (double)j * 0.2D;

                    if (k == 0)
                    {
                        d10 *= (double)(j1 - 1) * 0.1D + 1.0D;
                    }

                    for (int k1 = 0; k1 < 5; ++k1)
                    {
                        double d11 = p_77028_2_ + 0.5D - d9;
                        double d12 = p_77028_6_ + 0.5D - d9;

                        if (k1 == 1 || k1 == 2)
                        {
                            d11 += d9 * 2.0D;
                        }

                        if (k1 == 2 || k1 == 3)
                        {
                            d12 += d9 * 2.0D;
                        }

                        double d13 = p_77028_2_ + 0.5D - d10;
                        double d14 = p_77028_6_ + 0.5D - d10;

                        if (k1 == 1 || k1 == 2)
                        {
                            d13 += d10 * 2.0D;
                        }

                        if (k1 == 2 || k1 == 3)
                        {
                            d14 += d10 * 2.0D;
                        }

                        tessellator.func_78377_a(d13 + d5, p_77028_4_ + (double)(j1 * 16), d14 + d6);
                        tessellator.func_78377_a(d11 + d7, p_77028_4_ + (double)((j1 + 1) * 16), d12 + d8);
                    }

                    tessellator.func_78381_a();
                }
            }
        }

        GL11.glDisable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
    }

    protected ResourceLocation func_110805_a(EntityLightningBolt p_110805_1_)
    {
        return null;
    }

    protected ResourceLocation func_110775_a(Entity p_110775_1_)
    {
        return this.func_110805_a((EntityLightningBolt)p_110775_1_);
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.func_77028_a((EntityLightningBolt)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
