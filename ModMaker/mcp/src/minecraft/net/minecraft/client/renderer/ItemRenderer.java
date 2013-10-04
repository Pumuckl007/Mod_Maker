package net.minecraft.client.renderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.MapItemRenderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.MapData;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class ItemRenderer
{
    private static final ResourceLocation field_110930_b = new ResourceLocation("textures/misc/enchanted_item_glint.png");
    private static final ResourceLocation field_110931_c = new ResourceLocation("textures/map/map_background.png");
    private static final ResourceLocation field_110929_d = new ResourceLocation("textures/misc/underwater.png");
    private Minecraft field_78455_a;
    private ItemStack field_78453_b;
    private float field_78454_c;
    private float field_78451_d;
    private RenderBlocks field_78452_e = new RenderBlocks();
    public final MapItemRenderer field_78449_f;
    private int field_78450_g = -1;

    public ItemRenderer(Minecraft p_i1247_1_)
    {
        this.field_78455_a = p_i1247_1_;
        this.field_78449_f = new MapItemRenderer(p_i1247_1_.field_71474_y, p_i1247_1_.func_110434_K());
    }

    public void func_78443_a(EntityLivingBase p_78443_1_, ItemStack p_78443_2_, int p_78443_3_)
    {
        GL11.glPushMatrix();
        TextureManager texturemanager = this.field_78455_a.func_110434_K();

        if (p_78443_2_.func_94608_d() == 0 && p_78443_2_.field_77993_c < Block.field_71973_m.length && Block.field_71973_m[p_78443_2_.field_77993_c] != null && RenderBlocks.func_78597_b(Block.field_71973_m[p_78443_2_.field_77993_c].func_71857_b()))
        {
            texturemanager.func_110577_a(texturemanager.func_130087_a(0));
            this.field_78452_e.func_78600_a(Block.field_71973_m[p_78443_2_.field_77993_c], p_78443_2_.func_77960_j(), 1.0F);
        }
        else
        {
            Icon icon = p_78443_1_.func_70620_b(p_78443_2_, p_78443_3_);

            if (icon == null)
            {
                GL11.glPopMatrix();
                return;
            }

            texturemanager.func_110577_a(texturemanager.func_130087_a(p_78443_2_.func_94608_d()));
            Tessellator tessellator = Tessellator.field_78398_a;
            float f = icon.func_94209_e();
            float f1 = icon.func_94212_f();
            float f2 = icon.func_94206_g();
            float f3 = icon.func_94210_h();
            float f4 = 0.0F;
            float f5 = 0.3F;
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
            GL11.glTranslatef(-f4, -f5, 0.0F);
            float f6 = 1.5F;
            GL11.glScalef(f6, f6, f6);
            GL11.glRotatef(50.0F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(335.0F, 0.0F, 0.0F, 1.0F);
            GL11.glTranslatef(-0.9375F, -0.0625F, 0.0F);
            func_78439_a(tessellator, f1, f2, f, f3, icon.func_94211_a(), icon.func_94216_b(), 0.0625F);

            if (p_78443_2_.func_77962_s() && p_78443_3_ == 0)
            {
                GL11.glDepthFunc(GL11.GL_EQUAL);
                GL11.glDisable(GL11.GL_LIGHTING);
                texturemanager.func_110577_a(field_110930_b);
                GL11.glEnable(GL11.GL_BLEND);
                GL11.glBlendFunc(GL11.GL_SRC_COLOR, GL11.GL_ONE);
                float f7 = 0.76F;
                GL11.glColor4f(0.5F * f7, 0.25F * f7, 0.8F * f7, 1.0F);
                GL11.glMatrixMode(GL11.GL_TEXTURE);
                GL11.glPushMatrix();
                float f8 = 0.125F;
                GL11.glScalef(f8, f8, f8);
                float f9 = (float)(Minecraft.func_71386_F() % 3000L) / 3000.0F * 8.0F;
                GL11.glTranslatef(f9, 0.0F, 0.0F);
                GL11.glRotatef(-50.0F, 0.0F, 0.0F, 1.0F);
                func_78439_a(tessellator, 0.0F, 0.0F, 1.0F, 1.0F, 256, 256, 0.0625F);
                GL11.glPopMatrix();
                GL11.glPushMatrix();
                GL11.glScalef(f8, f8, f8);
                f9 = (float)(Minecraft.func_71386_F() % 4873L) / 4873.0F * 8.0F;
                GL11.glTranslatef(-f9, 0.0F, 0.0F);
                GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
                func_78439_a(tessellator, 0.0F, 0.0F, 1.0F, 1.0F, 256, 256, 0.0625F);
                GL11.glPopMatrix();
                GL11.glMatrixMode(GL11.GL_MODELVIEW);
                GL11.glDisable(GL11.GL_BLEND);
                GL11.glEnable(GL11.GL_LIGHTING);
                GL11.glDepthFunc(GL11.GL_LEQUAL);
            }

            GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        }

        GL11.glPopMatrix();
    }

    public static void func_78439_a(Tessellator p_78439_0_, float p_78439_1_, float p_78439_2_, float p_78439_3_, float p_78439_4_, int p_78439_5_, int p_78439_6_, float p_78439_7_)
    {
        p_78439_0_.func_78382_b();
        p_78439_0_.func_78375_b(0.0F, 0.0F, 1.0F);
        p_78439_0_.func_78374_a(0.0D, 0.0D, 0.0D, (double)p_78439_1_, (double)p_78439_4_);
        p_78439_0_.func_78374_a(1.0D, 0.0D, 0.0D, (double)p_78439_3_, (double)p_78439_4_);
        p_78439_0_.func_78374_a(1.0D, 1.0D, 0.0D, (double)p_78439_3_, (double)p_78439_2_);
        p_78439_0_.func_78374_a(0.0D, 1.0D, 0.0D, (double)p_78439_1_, (double)p_78439_2_);
        p_78439_0_.func_78381_a();
        p_78439_0_.func_78382_b();
        p_78439_0_.func_78375_b(0.0F, 0.0F, -1.0F);
        p_78439_0_.func_78374_a(0.0D, 1.0D, (double)(0.0F - p_78439_7_), (double)p_78439_1_, (double)p_78439_2_);
        p_78439_0_.func_78374_a(1.0D, 1.0D, (double)(0.0F - p_78439_7_), (double)p_78439_3_, (double)p_78439_2_);
        p_78439_0_.func_78374_a(1.0D, 0.0D, (double)(0.0F - p_78439_7_), (double)p_78439_3_, (double)p_78439_4_);
        p_78439_0_.func_78374_a(0.0D, 0.0D, (double)(0.0F - p_78439_7_), (double)p_78439_1_, (double)p_78439_4_);
        p_78439_0_.func_78381_a();
        float f5 = 0.5F * (p_78439_1_ - p_78439_3_) / (float)p_78439_5_;
        float f6 = 0.5F * (p_78439_4_ - p_78439_2_) / (float)p_78439_6_;
        p_78439_0_.func_78382_b();
        p_78439_0_.func_78375_b(-1.0F, 0.0F, 0.0F);
        int k;
        float f7;
        float f8;

        for (k = 0; k < p_78439_5_; ++k)
        {
            f7 = (float)k / (float)p_78439_5_;
            f8 = p_78439_1_ + (p_78439_3_ - p_78439_1_) * f7 - f5;
            p_78439_0_.func_78374_a((double)f7, 0.0D, (double)(0.0F - p_78439_7_), (double)f8, (double)p_78439_4_);
            p_78439_0_.func_78374_a((double)f7, 0.0D, 0.0D, (double)f8, (double)p_78439_4_);
            p_78439_0_.func_78374_a((double)f7, 1.0D, 0.0D, (double)f8, (double)p_78439_2_);
            p_78439_0_.func_78374_a((double)f7, 1.0D, (double)(0.0F - p_78439_7_), (double)f8, (double)p_78439_2_);
        }

        p_78439_0_.func_78381_a();
        p_78439_0_.func_78382_b();
        p_78439_0_.func_78375_b(1.0F, 0.0F, 0.0F);
        float f9;

        for (k = 0; k < p_78439_5_; ++k)
        {
            f7 = (float)k / (float)p_78439_5_;
            f8 = p_78439_1_ + (p_78439_3_ - p_78439_1_) * f7 - f5;
            f9 = f7 + 1.0F / (float)p_78439_5_;
            p_78439_0_.func_78374_a((double)f9, 1.0D, (double)(0.0F - p_78439_7_), (double)f8, (double)p_78439_2_);
            p_78439_0_.func_78374_a((double)f9, 1.0D, 0.0D, (double)f8, (double)p_78439_2_);
            p_78439_0_.func_78374_a((double)f9, 0.0D, 0.0D, (double)f8, (double)p_78439_4_);
            p_78439_0_.func_78374_a((double)f9, 0.0D, (double)(0.0F - p_78439_7_), (double)f8, (double)p_78439_4_);
        }

        p_78439_0_.func_78381_a();
        p_78439_0_.func_78382_b();
        p_78439_0_.func_78375_b(0.0F, 1.0F, 0.0F);

        for (k = 0; k < p_78439_6_; ++k)
        {
            f7 = (float)k / (float)p_78439_6_;
            f8 = p_78439_4_ + (p_78439_2_ - p_78439_4_) * f7 - f6;
            f9 = f7 + 1.0F / (float)p_78439_6_;
            p_78439_0_.func_78374_a(0.0D, (double)f9, 0.0D, (double)p_78439_1_, (double)f8);
            p_78439_0_.func_78374_a(1.0D, (double)f9, 0.0D, (double)p_78439_3_, (double)f8);
            p_78439_0_.func_78374_a(1.0D, (double)f9, (double)(0.0F - p_78439_7_), (double)p_78439_3_, (double)f8);
            p_78439_0_.func_78374_a(0.0D, (double)f9, (double)(0.0F - p_78439_7_), (double)p_78439_1_, (double)f8);
        }

        p_78439_0_.func_78381_a();
        p_78439_0_.func_78382_b();
        p_78439_0_.func_78375_b(0.0F, -1.0F, 0.0F);

        for (k = 0; k < p_78439_6_; ++k)
        {
            f7 = (float)k / (float)p_78439_6_;
            f8 = p_78439_4_ + (p_78439_2_ - p_78439_4_) * f7 - f6;
            p_78439_0_.func_78374_a(1.0D, (double)f7, 0.0D, (double)p_78439_3_, (double)f8);
            p_78439_0_.func_78374_a(0.0D, (double)f7, 0.0D, (double)p_78439_1_, (double)f8);
            p_78439_0_.func_78374_a(0.0D, (double)f7, (double)(0.0F - p_78439_7_), (double)p_78439_1_, (double)f8);
            p_78439_0_.func_78374_a(1.0D, (double)f7, (double)(0.0F - p_78439_7_), (double)p_78439_3_, (double)f8);
        }

        p_78439_0_.func_78381_a();
    }

    public void func_78440_a(float p_78440_1_)
    {
        float f1 = this.field_78451_d + (this.field_78454_c - this.field_78451_d) * p_78440_1_;
        EntityClientPlayerMP entityclientplayermp = this.field_78455_a.field_71439_g;
        float f2 = entityclientplayermp.field_70127_C + (entityclientplayermp.field_70125_A - entityclientplayermp.field_70127_C) * p_78440_1_;
        GL11.glPushMatrix();
        GL11.glRotatef(f2, 1.0F, 0.0F, 0.0F);
        GL11.glRotatef(entityclientplayermp.field_70126_B + (entityclientplayermp.field_70177_z - entityclientplayermp.field_70126_B) * p_78440_1_, 0.0F, 1.0F, 0.0F);
        RenderHelper.func_74519_b();
        GL11.glPopMatrix();
        EntityPlayerSP entityplayersp = (EntityPlayerSP)entityclientplayermp;
        float f3 = entityplayersp.field_71164_i + (entityplayersp.field_71155_g - entityplayersp.field_71164_i) * p_78440_1_;
        float f4 = entityplayersp.field_71163_h + (entityplayersp.field_71154_f - entityplayersp.field_71163_h) * p_78440_1_;
        GL11.glRotatef((entityclientplayermp.field_70125_A - f3) * 0.1F, 1.0F, 0.0F, 0.0F);
        GL11.glRotatef((entityclientplayermp.field_70177_z - f4) * 0.1F, 0.0F, 1.0F, 0.0F);
        ItemStack itemstack = this.field_78453_b;
        float f5 = this.field_78455_a.field_71441_e.func_72801_o(MathHelper.func_76128_c(entityclientplayermp.field_70165_t), MathHelper.func_76128_c(entityclientplayermp.field_70163_u), MathHelper.func_76128_c(entityclientplayermp.field_70161_v));
        f5 = 1.0F;
        int i = this.field_78455_a.field_71441_e.func_72802_i(MathHelper.func_76128_c(entityclientplayermp.field_70165_t), MathHelper.func_76128_c(entityclientplayermp.field_70163_u), MathHelper.func_76128_c(entityclientplayermp.field_70161_v), 0);
        int j = i % 65536;
        int k = i / 65536;
        OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, (float)j / 1.0F, (float)k / 1.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        float f6;
        float f7;
        float f8;

        if (itemstack != null)
        {
            i = Item.field_77698_e[itemstack.field_77993_c].func_82790_a(itemstack, 0);
            f7 = (float)(i >> 16 & 255) / 255.0F;
            f8 = (float)(i >> 8 & 255) / 255.0F;
            f6 = (float)(i & 255) / 255.0F;
            GL11.glColor4f(f5 * f7, f5 * f8, f5 * f6, 1.0F);
        }
        else
        {
            GL11.glColor4f(f5, f5, f5, 1.0F);
        }

        float f9;
        float f10;
        float f11;
        float f12;
        Render render;
        RenderPlayer renderplayer;

        if (itemstack != null && itemstack.field_77993_c == Item.field_77744_bd.field_77779_bT)
        {
            GL11.glPushMatrix();
            f12 = 0.8F;
            f7 = entityclientplayermp.func_70678_g(p_78440_1_);
            f8 = MathHelper.func_76126_a(f7 * (float)Math.PI);
            f6 = MathHelper.func_76126_a(MathHelper.func_76129_c(f7) * (float)Math.PI);
            GL11.glTranslatef(-f6 * 0.4F, MathHelper.func_76126_a(MathHelper.func_76129_c(f7) * (float)Math.PI * 2.0F) * 0.2F, -f8 * 0.2F);
            f7 = 1.0F - f2 / 45.0F + 0.1F;

            if (f7 < 0.0F)
            {
                f7 = 0.0F;
            }

            if (f7 > 1.0F)
            {
                f7 = 1.0F;
            }

            f7 = -MathHelper.func_76134_b(f7 * (float)Math.PI) * 0.5F + 0.5F;
            GL11.glTranslatef(0.0F, 0.0F * f12 - (1.0F - f1) * 1.2F - f7 * 0.5F + 0.04F, -0.9F * f12);
            GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(f7 * -85.0F, 0.0F, 0.0F, 1.0F);
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
            this.field_78455_a.func_110434_K().func_110577_a(entityclientplayermp.func_110306_p());

            for (k = 0; k < 2; ++k)
            {
                int l = k * 2 - 1;
                GL11.glPushMatrix();
                GL11.glTranslatef(-0.0F, -0.6F, 1.1F * (float)l);
                GL11.glRotatef((float)(-45 * l), 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(-90.0F, 0.0F, 0.0F, 1.0F);
                GL11.glRotatef(59.0F, 0.0F, 0.0F, 1.0F);
                GL11.glRotatef((float)(-65 * l), 0.0F, 1.0F, 0.0F);
                render = RenderManager.field_78727_a.func_78713_a(this.field_78455_a.field_71439_g);
                renderplayer = (RenderPlayer)render;
                f11 = 1.0F;
                GL11.glScalef(f11, f11, f11);
                renderplayer.func_82441_a(this.field_78455_a.field_71439_g);
                GL11.glPopMatrix();
            }

            f8 = entityclientplayermp.func_70678_g(p_78440_1_);
            f6 = MathHelper.func_76126_a(f8 * f8 * (float)Math.PI);
            f9 = MathHelper.func_76126_a(MathHelper.func_76129_c(f8) * (float)Math.PI);
            GL11.glRotatef(-f6 * 20.0F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(-f9 * 20.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(-f9 * 80.0F, 1.0F, 0.0F, 0.0F);
            f10 = 0.38F;
            GL11.glScalef(f10, f10, f10);
            GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
            GL11.glTranslatef(-1.0F, -1.0F, 0.0F);
            f11 = 0.015625F;
            GL11.glScalef(f11, f11, f11);
            this.field_78455_a.func_110434_K().func_110577_a(field_110931_c);
            Tessellator tessellator = Tessellator.field_78398_a;
            GL11.glNormal3f(0.0F, 0.0F, -1.0F);
            tessellator.func_78382_b();
            byte b0 = 7;
            tessellator.func_78374_a((double)(0 - b0), (double)(128 + b0), 0.0D, 0.0D, 1.0D);
            tessellator.func_78374_a((double)(128 + b0), (double)(128 + b0), 0.0D, 1.0D, 1.0D);
            tessellator.func_78374_a((double)(128 + b0), (double)(0 - b0), 0.0D, 1.0D, 0.0D);
            tessellator.func_78374_a((double)(0 - b0), (double)(0 - b0), 0.0D, 0.0D, 0.0D);
            tessellator.func_78381_a();
            MapData mapdata = Item.field_77744_bd.func_77873_a(itemstack, this.field_78455_a.field_71441_e);

            if (mapdata != null)
            {
                this.field_78449_f.func_78319_a(this.field_78455_a.field_71439_g, this.field_78455_a.func_110434_K(), mapdata);
            }

            GL11.glPopMatrix();
        }
        else if (itemstack != null)
        {
            GL11.glPushMatrix();
            f12 = 0.8F;

            if (entityclientplayermp.func_71052_bv() > 0)
            {
                EnumAction enumaction = itemstack.func_77975_n();

                if (enumaction == EnumAction.eat || enumaction == EnumAction.drink)
                {
                    f8 = (float)entityclientplayermp.func_71052_bv() - p_78440_1_ + 1.0F;
                    f6 = 1.0F - f8 / (float)itemstack.func_77988_m();
                    f9 = 1.0F - f6;
                    f9 = f9 * f9 * f9;
                    f9 = f9 * f9 * f9;
                    f9 = f9 * f9 * f9;
                    f10 = 1.0F - f9;
                    GL11.glTranslatef(0.0F, MathHelper.func_76135_e(MathHelper.func_76134_b(f8 / 4.0F * (float)Math.PI) * 0.1F) * (float)((double)f6 > 0.2D ? 1 : 0), 0.0F);
                    GL11.glTranslatef(f10 * 0.6F, -f10 * 0.5F, 0.0F);
                    GL11.glRotatef(f10 * 90.0F, 0.0F, 1.0F, 0.0F);
                    GL11.glRotatef(f10 * 10.0F, 1.0F, 0.0F, 0.0F);
                    GL11.glRotatef(f10 * 30.0F, 0.0F, 0.0F, 1.0F);
                }
            }
            else
            {
                f7 = entityclientplayermp.func_70678_g(p_78440_1_);
                f8 = MathHelper.func_76126_a(f7 * (float)Math.PI);
                f6 = MathHelper.func_76126_a(MathHelper.func_76129_c(f7) * (float)Math.PI);
                GL11.glTranslatef(-f6 * 0.4F, MathHelper.func_76126_a(MathHelper.func_76129_c(f7) * (float)Math.PI * 2.0F) * 0.2F, -f8 * 0.2F);
            }

            GL11.glTranslatef(0.7F * f12, -0.65F * f12 - (1.0F - f1) * 0.6F, -0.9F * f12);
            GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
            f7 = entityclientplayermp.func_70678_g(p_78440_1_);
            f8 = MathHelper.func_76126_a(f7 * f7 * (float)Math.PI);
            f6 = MathHelper.func_76126_a(MathHelper.func_76129_c(f7) * (float)Math.PI);
            GL11.glRotatef(-f8 * 20.0F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(-f6 * 20.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(-f6 * 80.0F, 1.0F, 0.0F, 0.0F);
            f9 = 0.4F;
            GL11.glScalef(f9, f9, f9);
            float f13;
            float f14;

            if (entityclientplayermp.func_71052_bv() > 0)
            {
                EnumAction enumaction1 = itemstack.func_77975_n();

                if (enumaction1 == EnumAction.block)
                {
                    GL11.glTranslatef(-0.5F, 0.2F, 0.0F);
                    GL11.glRotatef(30.0F, 0.0F, 1.0F, 0.0F);
                    GL11.glRotatef(-80.0F, 1.0F, 0.0F, 0.0F);
                    GL11.glRotatef(60.0F, 0.0F, 1.0F, 0.0F);
                }
                else if (enumaction1 == EnumAction.bow)
                {
                    GL11.glRotatef(-18.0F, 0.0F, 0.0F, 1.0F);
                    GL11.glRotatef(-12.0F, 0.0F, 1.0F, 0.0F);
                    GL11.glRotatef(-8.0F, 1.0F, 0.0F, 0.0F);
                    GL11.glTranslatef(-0.9F, 0.2F, 0.0F);
                    f11 = (float)itemstack.func_77988_m() - ((float)entityclientplayermp.func_71052_bv() - p_78440_1_ + 1.0F);
                    f13 = f11 / 20.0F;
                    f13 = (f13 * f13 + f13 * 2.0F) / 3.0F;

                    if (f13 > 1.0F)
                    {
                        f13 = 1.0F;
                    }

                    if (f13 > 0.1F)
                    {
                        GL11.glTranslatef(0.0F, MathHelper.func_76126_a((f11 - 0.1F) * 1.3F) * 0.01F * (f13 - 0.1F), 0.0F);
                    }

                    GL11.glTranslatef(0.0F, 0.0F, f13 * 0.1F);
                    GL11.glRotatef(-335.0F, 0.0F, 0.0F, 1.0F);
                    GL11.glRotatef(-50.0F, 0.0F, 1.0F, 0.0F);
                    GL11.glTranslatef(0.0F, 0.5F, 0.0F);
                    f14 = 1.0F + f13 * 0.2F;
                    GL11.glScalef(1.0F, 1.0F, f14);
                    GL11.glTranslatef(0.0F, -0.5F, 0.0F);
                    GL11.glRotatef(50.0F, 0.0F, 1.0F, 0.0F);
                    GL11.glRotatef(335.0F, 0.0F, 0.0F, 1.0F);
                }
            }

            if (itemstack.func_77973_b().func_77629_n_())
            {
                GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
            }

            if (itemstack.func_77973_b().func_77623_v())
            {
                this.func_78443_a(entityclientplayermp, itemstack, 0);
                int i1 = Item.field_77698_e[itemstack.field_77993_c].func_82790_a(itemstack, 1);
                f11 = (float)(i1 >> 16 & 255) / 255.0F;
                f13 = (float)(i1 >> 8 & 255) / 255.0F;
                f14 = (float)(i1 & 255) / 255.0F;
                GL11.glColor4f(f5 * f11, f5 * f13, f5 * f14, 1.0F);
                this.func_78443_a(entityclientplayermp, itemstack, 1);
            }
            else
            {
                this.func_78443_a(entityclientplayermp, itemstack, 0);
            }

            GL11.glPopMatrix();
        }
        else if (!entityclientplayermp.func_82150_aj())
        {
            GL11.glPushMatrix();
            f12 = 0.8F;
            f7 = entityclientplayermp.func_70678_g(p_78440_1_);
            f8 = MathHelper.func_76126_a(f7 * (float)Math.PI);
            f6 = MathHelper.func_76126_a(MathHelper.func_76129_c(f7) * (float)Math.PI);
            GL11.glTranslatef(-f6 * 0.3F, MathHelper.func_76126_a(MathHelper.func_76129_c(f7) * (float)Math.PI * 2.0F) * 0.4F, -f8 * 0.4F);
            GL11.glTranslatef(0.8F * f12, -0.75F * f12 - (1.0F - f1) * 0.6F, -0.9F * f12);
            GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
            f7 = entityclientplayermp.func_70678_g(p_78440_1_);
            f8 = MathHelper.func_76126_a(f7 * f7 * (float)Math.PI);
            f6 = MathHelper.func_76126_a(MathHelper.func_76129_c(f7) * (float)Math.PI);
            GL11.glRotatef(f6 * 70.0F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(-f8 * 20.0F, 0.0F, 0.0F, 1.0F);
            this.field_78455_a.func_110434_K().func_110577_a(entityclientplayermp.func_110306_p());
            GL11.glTranslatef(-1.0F, 3.6F, 3.5F);
            GL11.glRotatef(120.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(200.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
            GL11.glScalef(1.0F, 1.0F, 1.0F);
            GL11.glTranslatef(5.6F, 0.0F, 0.0F);
            render = RenderManager.field_78727_a.func_78713_a(this.field_78455_a.field_71439_g);
            renderplayer = (RenderPlayer)render;
            f11 = 1.0F;
            GL11.glScalef(f11, f11, f11);
            renderplayer.func_82441_a(this.field_78455_a.field_71439_g);
            GL11.glPopMatrix();
        }

        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        RenderHelper.func_74518_a();
    }

    public void func_78447_b(float p_78447_1_)
    {
        GL11.glDisable(GL11.GL_ALPHA_TEST);

        if (this.field_78455_a.field_71439_g.func_70027_ad())
        {
            this.func_78442_d(p_78447_1_);
        }

        if (this.field_78455_a.field_71439_g.func_70094_T())
        {
            int i = MathHelper.func_76128_c(this.field_78455_a.field_71439_g.field_70165_t);
            int j = MathHelper.func_76128_c(this.field_78455_a.field_71439_g.field_70163_u);
            int k = MathHelper.func_76128_c(this.field_78455_a.field_71439_g.field_70161_v);
            int l = this.field_78455_a.field_71441_e.func_72798_a(i, j, k);

            if (this.field_78455_a.field_71441_e.func_72809_s(i, j, k))
            {
                this.func_78446_a(p_78447_1_, Block.field_71973_m[l].func_71851_a(2));
            }
            else
            {
                for (int i1 = 0; i1 < 8; ++i1)
                {
                    float f1 = ((float)((i1 >> 0) % 2) - 0.5F) * this.field_78455_a.field_71439_g.field_70130_N * 0.9F;
                    float f2 = ((float)((i1 >> 1) % 2) - 0.5F) * this.field_78455_a.field_71439_g.field_70131_O * 0.2F;
                    float f3 = ((float)((i1 >> 2) % 2) - 0.5F) * this.field_78455_a.field_71439_g.field_70130_N * 0.9F;
                    int j1 = MathHelper.func_76141_d((float)i + f1);
                    int k1 = MathHelper.func_76141_d((float)j + f2);
                    int l1 = MathHelper.func_76141_d((float)k + f3);

                    if (this.field_78455_a.field_71441_e.func_72809_s(j1, k1, l1))
                    {
                        l = this.field_78455_a.field_71441_e.func_72798_a(j1, k1, l1);
                    }
                }
            }

            if (Block.field_71973_m[l] != null)
            {
                this.func_78446_a(p_78447_1_, Block.field_71973_m[l].func_71851_a(2));
            }
        }

        if (this.field_78455_a.field_71439_g.func_70055_a(Material.field_76244_g))
        {
            this.func_78448_c(p_78447_1_);
        }

        GL11.glEnable(GL11.GL_ALPHA_TEST);
    }

    private void func_78446_a(float p_78446_1_, Icon p_78446_2_)
    {
        this.field_78455_a.func_110434_K().func_110577_a(TextureMap.field_110575_b);
        Tessellator tessellator = Tessellator.field_78398_a;
        float f1 = 0.1F;
        GL11.glColor4f(f1, f1, f1, 0.5F);
        GL11.glPushMatrix();
        float f2 = -1.0F;
        float f3 = 1.0F;
        float f4 = -1.0F;
        float f5 = 1.0F;
        float f6 = -0.5F;
        float f7 = p_78446_2_.func_94209_e();
        float f8 = p_78446_2_.func_94212_f();
        float f9 = p_78446_2_.func_94206_g();
        float f10 = p_78446_2_.func_94210_h();
        tessellator.func_78382_b();
        tessellator.func_78374_a((double)f2, (double)f4, (double)f6, (double)f8, (double)f10);
        tessellator.func_78374_a((double)f3, (double)f4, (double)f6, (double)f7, (double)f10);
        tessellator.func_78374_a((double)f3, (double)f5, (double)f6, (double)f7, (double)f9);
        tessellator.func_78374_a((double)f2, (double)f5, (double)f6, (double)f8, (double)f9);
        tessellator.func_78381_a();
        GL11.glPopMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    private void func_78448_c(float p_78448_1_)
    {
        this.field_78455_a.func_110434_K().func_110577_a(field_110929_d);
        Tessellator tessellator = Tessellator.field_78398_a;
        float f1 = this.field_78455_a.field_71439_g.func_70013_c(p_78448_1_);
        GL11.glColor4f(f1, f1, f1, 0.5F);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glPushMatrix();
        float f2 = 4.0F;
        float f3 = -1.0F;
        float f4 = 1.0F;
        float f5 = -1.0F;
        float f6 = 1.0F;
        float f7 = -0.5F;
        float f8 = -this.field_78455_a.field_71439_g.field_70177_z / 64.0F;
        float f9 = this.field_78455_a.field_71439_g.field_70125_A / 64.0F;
        tessellator.func_78382_b();
        tessellator.func_78374_a((double)f3, (double)f5, (double)f7, (double)(f2 + f8), (double)(f2 + f9));
        tessellator.func_78374_a((double)f4, (double)f5, (double)f7, (double)(0.0F + f8), (double)(f2 + f9));
        tessellator.func_78374_a((double)f4, (double)f6, (double)f7, (double)(0.0F + f8), (double)(0.0F + f9));
        tessellator.func_78374_a((double)f3, (double)f6, (double)f7, (double)(f2 + f8), (double)(0.0F + f9));
        tessellator.func_78381_a();
        GL11.glPopMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(GL11.GL_BLEND);
    }

    private void func_78442_d(float p_78442_1_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.9F);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        float f1 = 1.0F;

        for (int i = 0; i < 2; ++i)
        {
            GL11.glPushMatrix();
            Icon icon = Block.field_72067_ar.func_94438_c(1);
            this.field_78455_a.func_110434_K().func_110577_a(TextureMap.field_110575_b);
            float f2 = icon.func_94209_e();
            float f3 = icon.func_94212_f();
            float f4 = icon.func_94206_g();
            float f5 = icon.func_94210_h();
            float f6 = (0.0F - f1) / 2.0F;
            float f7 = f6 + f1;
            float f8 = 0.0F - f1 / 2.0F;
            float f9 = f8 + f1;
            float f10 = -0.5F;
            GL11.glTranslatef((float)(-(i * 2 - 1)) * 0.24F, -0.3F, 0.0F);
            GL11.glRotatef((float)(i * 2 - 1) * 10.0F, 0.0F, 1.0F, 0.0F);
            tessellator.func_78382_b();
            tessellator.func_78374_a((double)f6, (double)f8, (double)f10, (double)f3, (double)f5);
            tessellator.func_78374_a((double)f7, (double)f8, (double)f10, (double)f2, (double)f5);
            tessellator.func_78374_a((double)f7, (double)f9, (double)f10, (double)f2, (double)f4);
            tessellator.func_78374_a((double)f6, (double)f9, (double)f10, (double)f3, (double)f4);
            tessellator.func_78381_a();
            GL11.glPopMatrix();
        }

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(GL11.GL_BLEND);
    }

    public void func_78441_a()
    {
        this.field_78451_d = this.field_78454_c;
        EntityClientPlayerMP entityclientplayermp = this.field_78455_a.field_71439_g;
        ItemStack itemstack = entityclientplayermp.field_71071_by.func_70448_g();
        boolean flag = this.field_78450_g == entityclientplayermp.field_71071_by.field_70461_c && itemstack == this.field_78453_b;

        if (this.field_78453_b == null && itemstack == null)
        {
            flag = true;
        }

        if (itemstack != null && this.field_78453_b != null && itemstack != this.field_78453_b && itemstack.field_77993_c == this.field_78453_b.field_77993_c && itemstack.func_77960_j() == this.field_78453_b.func_77960_j())
        {
            this.field_78453_b = itemstack;
            flag = true;
        }

        float f = 0.4F;
        float f1 = flag ? 1.0F : 0.0F;
        float f2 = f1 - this.field_78454_c;

        if (f2 < -f)
        {
            f2 = -f;
        }

        if (f2 > f)
        {
            f2 = f;
        }

        this.field_78454_c += f2;

        if (this.field_78454_c < 0.1F)
        {
            this.field_78453_b = itemstack;
            this.field_78450_g = entityclientplayermp.field_71071_by.field_70461_c;
        }
    }

    public void func_78444_b()
    {
        this.field_78454_c = 0.0F;
    }

    public void func_78445_c()
    {
        this.field_78454_c = 0.0F;
    }
}
