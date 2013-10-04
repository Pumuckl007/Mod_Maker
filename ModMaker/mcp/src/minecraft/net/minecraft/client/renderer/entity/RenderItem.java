package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class RenderItem extends Render
{
    private static final ResourceLocation field_110798_h = new ResourceLocation("textures/misc/enchanted_item_glint.png");
    private RenderBlocks field_77022_g = new RenderBlocks();
    private Random field_77025_h = new Random();
    public boolean field_77024_a = true;
    public float field_77023_b;
    public static boolean field_82407_g;

    public RenderItem()
    {
        this.field_76989_e = 0.15F;
        this.field_76987_f = 0.75F;
    }

    public void func_77014_a(EntityItem p_77014_1_, double p_77014_2_, double p_77014_4_, double p_77014_6_, float p_77014_8_, float p_77014_9_)
    {
        this.func_110777_b(p_77014_1_);
        this.field_77025_h.setSeed(187L);
        ItemStack itemstack = p_77014_1_.func_92059_d();

        if (itemstack.func_77973_b() != null)
        {
            GL11.glPushMatrix();
            float f2 = MathHelper.func_76126_a(((float)p_77014_1_.field_70292_b + p_77014_9_) / 10.0F + p_77014_1_.field_70290_d) * 0.1F + 0.1F;
            float f3 = (((float)p_77014_1_.field_70292_b + p_77014_9_) / 20.0F + p_77014_1_.field_70290_d) * (180F / (float)Math.PI);
            byte b0 = 1;

            if (p_77014_1_.func_92059_d().field_77994_a > 1)
            {
                b0 = 2;
            }

            if (p_77014_1_.func_92059_d().field_77994_a > 5)
            {
                b0 = 3;
            }

            if (p_77014_1_.func_92059_d().field_77994_a > 20)
            {
                b0 = 4;
            }

            if (p_77014_1_.func_92059_d().field_77994_a > 40)
            {
                b0 = 5;
            }

            GL11.glTranslatef((float)p_77014_2_, (float)p_77014_4_ + f2, (float)p_77014_6_);
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
            float f4;
            float f5;
            float f6;
            int i;

            if (itemstack.func_94608_d() == 0 && itemstack.field_77993_c < Block.field_71973_m.length && Block.field_71973_m[itemstack.field_77993_c] != null && RenderBlocks.func_78597_b(Block.field_71973_m[itemstack.field_77993_c].func_71857_b()))
            {
                Block block = Block.field_71973_m[itemstack.field_77993_c];
                GL11.glRotatef(f3, 0.0F, 1.0F, 0.0F);

                if (field_82407_g)
                {
                    GL11.glScalef(1.25F, 1.25F, 1.25F);
                    GL11.glTranslatef(0.0F, 0.05F, 0.0F);
                    GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
                }

                float f7 = 0.25F;
                int j = block.func_71857_b();

                if (j == 1 || j == 19 || j == 12 || j == 2)
                {
                    f7 = 0.5F;
                }

                GL11.glScalef(f7, f7, f7);

                for (i = 0; i < b0; ++i)
                {
                    GL11.glPushMatrix();

                    if (i > 0)
                    {
                        f5 = (this.field_77025_h.nextFloat() * 2.0F - 1.0F) * 0.2F / f7;
                        f4 = (this.field_77025_h.nextFloat() * 2.0F - 1.0F) * 0.2F / f7;
                        f6 = (this.field_77025_h.nextFloat() * 2.0F - 1.0F) * 0.2F / f7;
                        GL11.glTranslatef(f5, f4, f6);
                    }

                    f5 = 1.0F;
                    this.field_77022_g.func_78600_a(block, itemstack.func_77960_j(), f5);
                    GL11.glPopMatrix();
                }
            }
            else
            {
                float f8;

                if (itemstack.func_94608_d() == 1 && itemstack.func_77973_b().func_77623_v())
                {
                    if (field_82407_g)
                    {
                        GL11.glScalef(0.5128205F, 0.5128205F, 0.5128205F);
                        GL11.glTranslatef(0.0F, -0.05F, 0.0F);
                    }
                    else
                    {
                        GL11.glScalef(0.5F, 0.5F, 0.5F);
                    }

                    for (int k = 0; k <= 1; ++k)
                    {
                        this.field_77025_h.setSeed(187L);
                        Icon icon = itemstack.func_77973_b().func_77618_c(itemstack.func_77960_j(), k);
                        f8 = 1.0F;

                        if (this.field_77024_a)
                        {
                            i = Item.field_77698_e[itemstack.field_77993_c].func_82790_a(itemstack, k);
                            f5 = (float)(i >> 16 & 255) / 255.0F;
                            f4 = (float)(i >> 8 & 255) / 255.0F;
                            f6 = (float)(i & 255) / 255.0F;
                            GL11.glColor4f(f5 * f8, f4 * f8, f6 * f8, 1.0F);
                            this.func_77020_a(p_77014_1_, icon, b0, p_77014_9_, f5 * f8, f4 * f8, f6 * f8);
                        }
                        else
                        {
                            this.func_77020_a(p_77014_1_, icon, b0, p_77014_9_, 1.0F, 1.0F, 1.0F);
                        }
                    }
                }
                else
                {
                    if (field_82407_g)
                    {
                        GL11.glScalef(0.5128205F, 0.5128205F, 0.5128205F);
                        GL11.glTranslatef(0.0F, -0.05F, 0.0F);
                    }
                    else
                    {
                        GL11.glScalef(0.5F, 0.5F, 0.5F);
                    }

                    Icon icon1 = itemstack.func_77954_c();

                    if (this.field_77024_a)
                    {
                        int l = Item.field_77698_e[itemstack.field_77993_c].func_82790_a(itemstack, 0);
                        f8 = (float)(l >> 16 & 255) / 255.0F;
                        float f9 = (float)(l >> 8 & 255) / 255.0F;
                        f5 = (float)(l & 255) / 255.0F;
                        f4 = 1.0F;
                        this.func_77020_a(p_77014_1_, icon1, b0, p_77014_9_, f8 * f4, f9 * f4, f5 * f4);
                    }
                    else
                    {
                        this.func_77020_a(p_77014_1_, icon1, b0, p_77014_9_, 1.0F, 1.0F, 1.0F);
                    }
                }
            }

            GL11.glDisable(GL12.GL_RESCALE_NORMAL);
            GL11.glPopMatrix();
        }
    }

    protected ResourceLocation func_110796_a(EntityItem p_110796_1_)
    {
        return this.field_76990_c.field_78724_e.func_130087_a(p_110796_1_.func_92059_d().func_94608_d());
    }

    private void func_77020_a(EntityItem p_77020_1_, Icon p_77020_2_, int p_77020_3_, float p_77020_4_, float p_77020_5_, float p_77020_6_, float p_77020_7_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;

        if (p_77020_2_ == null)
        {
            TextureManager texturemanager = Minecraft.func_71410_x().func_110434_K();
            ResourceLocation resourcelocation = texturemanager.func_130087_a(p_77020_1_.func_92059_d().func_94608_d());
            p_77020_2_ = ((TextureMap)texturemanager.func_110581_b(resourcelocation)).func_110572_b("missingno");
        }

        float f4 = ((Icon)p_77020_2_).func_94209_e();
        float f5 = ((Icon)p_77020_2_).func_94212_f();
        float f6 = ((Icon)p_77020_2_).func_94206_g();
        float f7 = ((Icon)p_77020_2_).func_94210_h();
        float f8 = 1.0F;
        float f9 = 0.5F;
        float f10 = 0.25F;
        float f11;

        if (this.field_76990_c.field_78733_k.field_74347_j)
        {
            GL11.glPushMatrix();

            if (field_82407_g)
            {
                GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
            }
            else
            {
                GL11.glRotatef((((float)p_77020_1_.field_70292_b + p_77020_4_) / 20.0F + p_77020_1_.field_70290_d) * (180F / (float)Math.PI), 0.0F, 1.0F, 0.0F);
            }

            float f12 = 0.0625F;
            f11 = 0.021875F;
            ItemStack itemstack = p_77020_1_.func_92059_d();
            int j = itemstack.field_77994_a;
            byte b0;

            if (j < 2)
            {
                b0 = 1;
            }
            else if (j < 16)
            {
                b0 = 2;
            }
            else if (j < 32)
            {
                b0 = 3;
            }
            else
            {
                b0 = 4;
            }

            GL11.glTranslatef(-f9, -f10, -((f12 + f11) * (float)b0 / 2.0F));

            for (int k = 0; k < b0; ++k)
            {
                GL11.glTranslatef(0.0F, 0.0F, f12 + f11);

                if (itemstack.func_94608_d() == 0 && Block.field_71973_m[itemstack.field_77993_c] != null)
                {
                    this.func_110776_a(TextureMap.field_110575_b);
                }
                else
                {
                    this.func_110776_a(TextureMap.field_110576_c);
                }

                GL11.glColor4f(p_77020_5_, p_77020_6_, p_77020_7_, 1.0F);
                ItemRenderer.func_78439_a(tessellator, f5, f6, f4, f7, ((Icon)p_77020_2_).func_94211_a(), ((Icon)p_77020_2_).func_94216_b(), f12);

                if (itemstack.func_77962_s())
                {
                    GL11.glDepthFunc(GL11.GL_EQUAL);
                    GL11.glDisable(GL11.GL_LIGHTING);
                    this.field_76990_c.field_78724_e.func_110577_a(field_110798_h);
                    GL11.glEnable(GL11.GL_BLEND);
                    GL11.glBlendFunc(GL11.GL_SRC_COLOR, GL11.GL_ONE);
                    float f13 = 0.76F;
                    GL11.glColor4f(0.5F * f13, 0.25F * f13, 0.8F * f13, 1.0F);
                    GL11.glMatrixMode(GL11.GL_TEXTURE);
                    GL11.glPushMatrix();
                    float f14 = 0.125F;
                    GL11.glScalef(f14, f14, f14);
                    float f15 = (float)(Minecraft.func_71386_F() % 3000L) / 3000.0F * 8.0F;
                    GL11.glTranslatef(f15, 0.0F, 0.0F);
                    GL11.glRotatef(-50.0F, 0.0F, 0.0F, 1.0F);
                    ItemRenderer.func_78439_a(tessellator, 0.0F, 0.0F, 1.0F, 1.0F, 255, 255, f12);
                    GL11.glPopMatrix();
                    GL11.glPushMatrix();
                    GL11.glScalef(f14, f14, f14);
                    f15 = (float)(Minecraft.func_71386_F() % 4873L) / 4873.0F * 8.0F;
                    GL11.glTranslatef(-f15, 0.0F, 0.0F);
                    GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
                    ItemRenderer.func_78439_a(tessellator, 0.0F, 0.0F, 1.0F, 1.0F, 255, 255, f12);
                    GL11.glPopMatrix();
                    GL11.glMatrixMode(GL11.GL_MODELVIEW);
                    GL11.glDisable(GL11.GL_BLEND);
                    GL11.glEnable(GL11.GL_LIGHTING);
                    GL11.glDepthFunc(GL11.GL_LEQUAL);
                }
            }

            GL11.glPopMatrix();
        }
        else
        {
            for (int l = 0; l < p_77020_3_; ++l)
            {
                GL11.glPushMatrix();

                if (l > 0)
                {
                    f11 = (this.field_77025_h.nextFloat() * 2.0F - 1.0F) * 0.3F;
                    float f16 = (this.field_77025_h.nextFloat() * 2.0F - 1.0F) * 0.3F;
                    float f17 = (this.field_77025_h.nextFloat() * 2.0F - 1.0F) * 0.3F;
                    GL11.glTranslatef(f11, f16, f17);
                }

                if (!field_82407_g)
                {
                    GL11.glRotatef(180.0F - this.field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
                }

                GL11.glColor4f(p_77020_5_, p_77020_6_, p_77020_7_, 1.0F);
                tessellator.func_78382_b();
                tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
                tessellator.func_78374_a((double)(0.0F - f9), (double)(0.0F - f10), 0.0D, (double)f4, (double)f7);
                tessellator.func_78374_a((double)(f8 - f9), (double)(0.0F - f10), 0.0D, (double)f5, (double)f7);
                tessellator.func_78374_a((double)(f8 - f9), (double)(1.0F - f10), 0.0D, (double)f5, (double)f6);
                tessellator.func_78374_a((double)(0.0F - f9), (double)(1.0F - f10), 0.0D, (double)f4, (double)f6);
                tessellator.func_78381_a();
                GL11.glPopMatrix();
            }
        }
    }

    public void func_77015_a(FontRenderer p_77015_1_, TextureManager p_77015_2_, ItemStack p_77015_3_, int p_77015_4_, int p_77015_5_)
    {
        int k = p_77015_3_.field_77993_c;
        int l = p_77015_3_.func_77960_j();
        Object object = p_77015_3_.func_77954_c();
        float f;
        int i1;
        float f1;
        float f2;

        if (p_77015_3_.func_94608_d() == 0 && RenderBlocks.func_78597_b(Block.field_71973_m[k].func_71857_b()))
        {
            p_77015_2_.func_110577_a(TextureMap.field_110575_b);
            Block block = Block.field_71973_m[k];
            GL11.glPushMatrix();
            GL11.glTranslatef((float)(p_77015_4_ - 2), (float)(p_77015_5_ + 3), -3.0F + this.field_77023_b);
            GL11.glScalef(10.0F, 10.0F, 10.0F);
            GL11.glTranslatef(1.0F, 0.5F, 1.0F);
            GL11.glScalef(1.0F, 1.0F, -1.0F);
            GL11.glRotatef(210.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
            i1 = Item.field_77698_e[k].func_82790_a(p_77015_3_, 0);
            f = (float)(i1 >> 16 & 255) / 255.0F;
            f1 = (float)(i1 >> 8 & 255) / 255.0F;
            f2 = (float)(i1 & 255) / 255.0F;

            if (this.field_77024_a)
            {
                GL11.glColor4f(f, f1, f2, 1.0F);
            }

            GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
            this.field_77022_g.field_78668_c = this.field_77024_a;
            this.field_77022_g.func_78600_a(block, l, 1.0F);
            this.field_77022_g.field_78668_c = true;
            GL11.glPopMatrix();
        }
        else if (Item.field_77698_e[k].func_77623_v())
        {
            GL11.glDisable(GL11.GL_LIGHTING);
            p_77015_2_.func_110577_a(TextureMap.field_110576_c);

            for (int j1 = 0; j1 <= 1; ++j1)
            {
                Icon icon = Item.field_77698_e[k].func_77618_c(l, j1);
                int k1 = Item.field_77698_e[k].func_82790_a(p_77015_3_, j1);
                f1 = (float)(k1 >> 16 & 255) / 255.0F;
                f2 = (float)(k1 >> 8 & 255) / 255.0F;
                float f3 = (float)(k1 & 255) / 255.0F;

                if (this.field_77024_a)
                {
                    GL11.glColor4f(f1, f2, f3, 1.0F);
                }

                this.func_94149_a(p_77015_4_, p_77015_5_, icon, 16, 16);
            }

            GL11.glEnable(GL11.GL_LIGHTING);
        }
        else
        {
            GL11.glDisable(GL11.GL_LIGHTING);
            ResourceLocation resourcelocation = p_77015_2_.func_130087_a(p_77015_3_.func_94608_d());
            p_77015_2_.func_110577_a(resourcelocation);

            if (object == null)
            {
                object = ((TextureMap)Minecraft.func_71410_x().func_110434_K().func_110581_b(resourcelocation)).func_110572_b("missingno");
            }

            i1 = Item.field_77698_e[k].func_82790_a(p_77015_3_, 0);
            f = (float)(i1 >> 16 & 255) / 255.0F;
            f1 = (float)(i1 >> 8 & 255) / 255.0F;
            f2 = (float)(i1 & 255) / 255.0F;

            if (this.field_77024_a)
            {
                GL11.glColor4f(f, f1, f2, 1.0F);
            }

            this.func_94149_a(p_77015_4_, p_77015_5_, (Icon)object, 16, 16);
            GL11.glEnable(GL11.GL_LIGHTING);
        }

        GL11.glEnable(GL11.GL_CULL_FACE);
    }

    public void func_82406_b(FontRenderer p_82406_1_, TextureManager p_82406_2_, ItemStack p_82406_3_, int p_82406_4_, int p_82406_5_)
    {
        if (p_82406_3_ != null)
        {
            this.func_77015_a(p_82406_1_, p_82406_2_, p_82406_3_, p_82406_4_, p_82406_5_);

            if (p_82406_3_.func_77962_s())
            {
                GL11.glDepthFunc(GL11.GL_GREATER);
                GL11.glDisable(GL11.GL_LIGHTING);
                GL11.glDepthMask(false);
                p_82406_2_.func_110577_a(field_110798_h);
                this.field_77023_b -= 50.0F;
                GL11.glEnable(GL11.GL_BLEND);
                GL11.glBlendFunc(GL11.GL_DST_COLOR, GL11.GL_DST_COLOR);
                GL11.glColor4f(0.5F, 0.25F, 0.8F, 1.0F);
                this.func_77018_a(p_82406_4_ * 431278612 + p_82406_5_ * 32178161, p_82406_4_ - 2, p_82406_5_ - 2, 20, 20);
                GL11.glDisable(GL11.GL_BLEND);
                GL11.glDepthMask(true);
                this.field_77023_b += 50.0F;
                GL11.glEnable(GL11.GL_LIGHTING);
                GL11.glDepthFunc(GL11.GL_LEQUAL);
            }
        }
    }

    private void func_77018_a(int p_77018_1_, int p_77018_2_, int p_77018_3_, int p_77018_4_, int p_77018_5_)
    {
        for (int j1 = 0; j1 < 2; ++j1)
        {
            if (j1 == 0)
            {
                GL11.glBlendFunc(GL11.GL_SRC_COLOR, GL11.GL_ONE);
            }

            if (j1 == 1)
            {
                GL11.glBlendFunc(GL11.GL_SRC_COLOR, GL11.GL_ONE);
            }

            float f = 0.00390625F;
            float f1 = 0.00390625F;
            float f2 = (float)(Minecraft.func_71386_F() % (long)(3000 + j1 * 1873)) / (3000.0F + (float)(j1 * 1873)) * 256.0F;
            float f3 = 0.0F;
            Tessellator tessellator = Tessellator.field_78398_a;
            float f4 = 4.0F;

            if (j1 == 1)
            {
                f4 = -1.0F;
            }

            tessellator.func_78382_b();
            tessellator.func_78374_a((double)(p_77018_2_ + 0), (double)(p_77018_3_ + p_77018_5_), (double)this.field_77023_b, (double)((f2 + (float)p_77018_5_ * f4) * f), (double)((f3 + (float)p_77018_5_) * f1));
            tessellator.func_78374_a((double)(p_77018_2_ + p_77018_4_), (double)(p_77018_3_ + p_77018_5_), (double)this.field_77023_b, (double)((f2 + (float)p_77018_4_ + (float)p_77018_5_ * f4) * f), (double)((f3 + (float)p_77018_5_) * f1));
            tessellator.func_78374_a((double)(p_77018_2_ + p_77018_4_), (double)(p_77018_3_ + 0), (double)this.field_77023_b, (double)((f2 + (float)p_77018_4_) * f), (double)((f3 + 0.0F) * f1));
            tessellator.func_78374_a((double)(p_77018_2_ + 0), (double)(p_77018_3_ + 0), (double)this.field_77023_b, (double)((f2 + 0.0F) * f), (double)((f3 + 0.0F) * f1));
            tessellator.func_78381_a();
        }
    }

    public void func_77021_b(FontRenderer p_77021_1_, TextureManager p_77021_2_, ItemStack p_77021_3_, int p_77021_4_, int p_77021_5_)
    {
        this.func_94148_a(p_77021_1_, p_77021_2_, p_77021_3_, p_77021_4_, p_77021_5_, (String)null);
    }

    public void func_94148_a(FontRenderer p_94148_1_, TextureManager p_94148_2_, ItemStack p_94148_3_, int p_94148_4_, int p_94148_5_, String p_94148_6_)
    {
        if (p_94148_3_ != null)
        {
            if (p_94148_3_.field_77994_a > 1 || p_94148_6_ != null)
            {
                String s1 = p_94148_6_ == null ? String.valueOf(p_94148_3_.field_77994_a) : p_94148_6_;
                GL11.glDisable(GL11.GL_LIGHTING);
                GL11.glDisable(GL11.GL_DEPTH_TEST);
                p_94148_1_.func_78261_a(s1, p_94148_4_ + 19 - 2 - p_94148_1_.func_78256_a(s1), p_94148_5_ + 6 + 3, 16777215);
                GL11.glEnable(GL11.GL_LIGHTING);
                GL11.glEnable(GL11.GL_DEPTH_TEST);
            }

            if (p_94148_3_.func_77951_h())
            {
                int k = (int)Math.round(13.0D - (double)p_94148_3_.func_77952_i() * 13.0D / (double)p_94148_3_.func_77958_k());
                int l = (int)Math.round(255.0D - (double)p_94148_3_.func_77952_i() * 255.0D / (double)p_94148_3_.func_77958_k());
                GL11.glDisable(GL11.GL_LIGHTING);
                GL11.glDisable(GL11.GL_DEPTH_TEST);
                GL11.glDisable(GL11.GL_TEXTURE_2D);
                Tessellator tessellator = Tessellator.field_78398_a;
                int i1 = 255 - l << 16 | l << 8;
                int j1 = (255 - l) / 4 << 16 | 16128;
                this.func_77017_a(tessellator, p_94148_4_ + 2, p_94148_5_ + 13, 13, 2, 0);
                this.func_77017_a(tessellator, p_94148_4_ + 2, p_94148_5_ + 13, 12, 1, j1);
                this.func_77017_a(tessellator, p_94148_4_ + 2, p_94148_5_ + 13, k, 1, i1);
                GL11.glEnable(GL11.GL_TEXTURE_2D);
                GL11.glEnable(GL11.GL_LIGHTING);
                GL11.glEnable(GL11.GL_DEPTH_TEST);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            }
        }
    }

    private void func_77017_a(Tessellator p_77017_1_, int p_77017_2_, int p_77017_3_, int p_77017_4_, int p_77017_5_, int p_77017_6_)
    {
        p_77017_1_.func_78382_b();
        p_77017_1_.func_78378_d(p_77017_6_);
        p_77017_1_.func_78377_a((double)(p_77017_2_ + 0), (double)(p_77017_3_ + 0), 0.0D);
        p_77017_1_.func_78377_a((double)(p_77017_2_ + 0), (double)(p_77017_3_ + p_77017_5_), 0.0D);
        p_77017_1_.func_78377_a((double)(p_77017_2_ + p_77017_4_), (double)(p_77017_3_ + p_77017_5_), 0.0D);
        p_77017_1_.func_78377_a((double)(p_77017_2_ + p_77017_4_), (double)(p_77017_3_ + 0), 0.0D);
        p_77017_1_.func_78381_a();
    }

    public void func_94149_a(int p_94149_1_, int p_94149_2_, Icon p_94149_3_, int p_94149_4_, int p_94149_5_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78382_b();
        tessellator.func_78374_a((double)(p_94149_1_ + 0), (double)(p_94149_2_ + p_94149_5_), (double)this.field_77023_b, (double)p_94149_3_.func_94209_e(), (double)p_94149_3_.func_94210_h());
        tessellator.func_78374_a((double)(p_94149_1_ + p_94149_4_), (double)(p_94149_2_ + p_94149_5_), (double)this.field_77023_b, (double)p_94149_3_.func_94212_f(), (double)p_94149_3_.func_94210_h());
        tessellator.func_78374_a((double)(p_94149_1_ + p_94149_4_), (double)(p_94149_2_ + 0), (double)this.field_77023_b, (double)p_94149_3_.func_94212_f(), (double)p_94149_3_.func_94206_g());
        tessellator.func_78374_a((double)(p_94149_1_ + 0), (double)(p_94149_2_ + 0), (double)this.field_77023_b, (double)p_94149_3_.func_94209_e(), (double)p_94149_3_.func_94206_g());
        tessellator.func_78381_a();
    }

    protected ResourceLocation func_110775_a(Entity p_110775_1_)
    {
        return this.func_110796_a((EntityItem)p_110775_1_);
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.func_77014_a((EntityItem)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
