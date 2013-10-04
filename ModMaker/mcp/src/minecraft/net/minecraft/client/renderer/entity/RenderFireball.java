package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class RenderFireball extends Render
{
    private float field_77002_a;

    public RenderFireball(float p_i1254_1_)
    {
        this.field_77002_a = p_i1254_1_;
    }

    public void func_77001_a(EntityFireball p_77001_1_, double p_77001_2_, double p_77001_4_, double p_77001_6_, float p_77001_8_, float p_77001_9_)
    {
        GL11.glPushMatrix();
        this.func_110777_b(p_77001_1_);
        GL11.glTranslatef((float)p_77001_2_, (float)p_77001_4_, (float)p_77001_6_);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        float f2 = this.field_77002_a;
        GL11.glScalef(f2 / 1.0F, f2 / 1.0F, f2 / 1.0F);
        Icon icon = Item.field_77811_bE.func_77617_a(0);
        Tessellator tessellator = Tessellator.field_78398_a;
        float f3 = icon.func_94209_e();
        float f4 = icon.func_94212_f();
        float f5 = icon.func_94206_g();
        float f6 = icon.func_94210_h();
        float f7 = 1.0F;
        float f8 = 0.5F;
        float f9 = 0.25F;
        GL11.glRotatef(180.0F - this.field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-this.field_76990_c.field_78732_j, 1.0F, 0.0F, 0.0F);
        tessellator.func_78382_b();
        tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
        tessellator.func_78374_a((double)(0.0F - f8), (double)(0.0F - f9), 0.0D, (double)f3, (double)f6);
        tessellator.func_78374_a((double)(f7 - f8), (double)(0.0F - f9), 0.0D, (double)f4, (double)f6);
        tessellator.func_78374_a((double)(f7 - f8), (double)(1.0F - f9), 0.0D, (double)f4, (double)f5);
        tessellator.func_78374_a((double)(0.0F - f8), (double)(1.0F - f9), 0.0D, (double)f3, (double)f5);
        tessellator.func_78381_a();
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
    }

    protected ResourceLocation func_110790_a(EntityFireball p_110790_1_)
    {
        return TextureMap.field_110576_c;
    }

    protected ResourceLocation func_110775_a(Entity p_110775_1_)
    {
        return this.func_110790_a((EntityFireball)p_110775_1_);
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.func_77001_a((EntityFireball)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
