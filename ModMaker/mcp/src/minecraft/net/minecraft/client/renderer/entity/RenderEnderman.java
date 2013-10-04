package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelEnderman;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class RenderEnderman extends RenderLiving
{
    private static final ResourceLocation field_110840_a = new ResourceLocation("textures/entity/enderman/enderman_eyes.png");
    private static final ResourceLocation field_110839_f = new ResourceLocation("textures/entity/enderman/enderman.png");
    private ModelEnderman field_77078_a;
    private Random field_77077_b = new Random();

    public RenderEnderman()
    {
        super(new ModelEnderman(), 0.5F);
        this.field_77078_a = (ModelEnderman)super.field_77045_g;
        this.func_77042_a(this.field_77078_a);
    }

    public void func_77075_a(EntityEnderman p_77075_1_, double p_77075_2_, double p_77075_4_, double p_77075_6_, float p_77075_8_, float p_77075_9_)
    {
        this.field_77078_a.field_78126_a = p_77075_1_.func_70822_p() > 0;
        this.field_77078_a.field_78125_b = p_77075_1_.func_70823_r();

        if (p_77075_1_.func_70823_r())
        {
            double d3 = 0.02D;
            p_77075_2_ += this.field_77077_b.nextGaussian() * d3;
            p_77075_6_ += this.field_77077_b.nextGaussian() * d3;
        }

        super.func_77031_a(p_77075_1_, p_77075_2_, p_77075_4_, p_77075_6_, p_77075_8_, p_77075_9_);
    }

    protected ResourceLocation func_110838_a(EntityEnderman p_110838_1_)
    {
        return field_110839_f;
    }

    protected void func_77076_a(EntityEnderman p_77076_1_, float p_77076_2_)
    {
        super.func_77029_c(p_77076_1_, p_77076_2_);

        if (p_77076_1_.func_70822_p() > 0)
        {
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
            GL11.glPushMatrix();
            float f1 = 0.5F;
            GL11.glTranslatef(0.0F, 0.6875F, -0.75F);
            f1 *= 1.0F;
            GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
            GL11.glScalef(-f1, -f1, f1);
            int i = p_77076_1_.func_70070_b(p_77076_2_);
            int j = i % 65536;
            int k = i / 65536;
            OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, (float)j / 1.0F, (float)k / 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.func_110776_a(TextureMap.field_110575_b);
            this.field_76988_d.func_78600_a(Block.field_71973_m[p_77076_1_.func_70822_p()], p_77076_1_.func_70824_q(), 1.0F);
            GL11.glPopMatrix();
            GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        }
    }

    protected int func_77074_a(EntityEnderman p_77074_1_, int p_77074_2_, float p_77074_3_)
    {
        if (p_77074_2_ != 0)
        {
            return -1;
        }
        else
        {
            this.func_110776_a(field_110840_a);
            float f1 = 1.0F;
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glDisable(GL11.GL_ALPHA_TEST);
            GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
            GL11.glDisable(GL11.GL_LIGHTING);

            if (p_77074_1_.func_82150_aj())
            {
                GL11.glDepthMask(false);
            }
            else
            {
                GL11.glDepthMask(true);
            }

            char c0 = 61680;
            int j = c0 % 65536;
            int k = c0 / 65536;
            OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, (float)j / 1.0F, (float)k / 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, f1);
            return 1;
        }
    }

    public void func_77031_a(EntityLiving p_77031_1_, double p_77031_2_, double p_77031_4_, double p_77031_6_, float p_77031_8_, float p_77031_9_)
    {
        this.func_77075_a((EntityEnderman)p_77031_1_, p_77031_2_, p_77031_4_, p_77031_6_, p_77031_8_, p_77031_9_);
    }

    protected int func_77032_a(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_)
    {
        return this.func_77074_a((EntityEnderman)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    protected void func_77029_c(EntityLivingBase p_77029_1_, float p_77029_2_)
    {
        this.func_77076_a((EntityEnderman)p_77029_1_, p_77029_2_);
    }

    public void func_77101_a(EntityLivingBase p_77101_1_, double p_77101_2_, double p_77101_4_, double p_77101_6_, float p_77101_8_, float p_77101_9_)
    {
        this.func_77075_a((EntityEnderman)p_77101_1_, p_77101_2_, p_77101_4_, p_77101_6_, p_77101_8_, p_77101_9_);
    }

    protected ResourceLocation func_110775_a(Entity p_110775_1_)
    {
        return this.func_110838_a((EntityEnderman)p_110775_1_);
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.func_77075_a((EntityEnderman)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
