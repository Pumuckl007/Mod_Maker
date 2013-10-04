package net.minecraft.client.renderer.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureCompass;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.MapData;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderItemFrame extends Render
{
    private static final ResourceLocation field_110789_a = new ResourceLocation("textures/map/map_background.png");
    private final RenderBlocks field_82405_a = new RenderBlocks();
    private Icon field_94147_f;

    public void func_94143_a(IconRegister p_94143_1_)
    {
        this.field_94147_f = p_94143_1_.func_94245_a("itemframe_background");
    }

    public void func_82404_a(EntityItemFrame p_82404_1_, double p_82404_2_, double p_82404_4_, double p_82404_6_, float p_82404_8_, float p_82404_9_)
    {
        GL11.glPushMatrix();
        float f2 = (float)(p_82404_1_.field_70165_t - p_82404_2_) - 0.5F;
        float f3 = (float)(p_82404_1_.field_70163_u - p_82404_4_) - 0.5F;
        float f4 = (float)(p_82404_1_.field_70161_v - p_82404_6_) - 0.5F;
        int i = p_82404_1_.field_70523_b + Direction.field_71583_a[p_82404_1_.field_82332_a];
        int j = p_82404_1_.field_70524_c;
        int k = p_82404_1_.field_70521_d + Direction.field_71581_b[p_82404_1_.field_82332_a];
        GL11.glTranslatef((float)i - f2, (float)j - f3, (float)k - f4);
        this.func_82403_a(p_82404_1_);
        this.func_82402_b(p_82404_1_);
        GL11.glPopMatrix();
    }

    protected ResourceLocation func_110788_a(EntityItemFrame p_110788_1_)
    {
        return null;
    }

    private void func_82403_a(EntityItemFrame p_82403_1_)
    {
        GL11.glPushMatrix();
        GL11.glRotatef(p_82403_1_.field_70177_z, 0.0F, 1.0F, 0.0F);
        this.field_76990_c.field_78724_e.func_110577_a(TextureMap.field_110575_b);
        Block block = Block.field_71988_x;
        float f = 0.0625F;
        float f1 = 0.75F;
        float f2 = f1 / 2.0F;
        GL11.glPushMatrix();
        this.field_82405_a.func_83019_b(0.0D, (double)(0.5F - f2 + 0.0625F), (double)(0.5F - f2 + 0.0625F), (double)(f * 0.5F), (double)(0.5F + f2 - 0.0625F), (double)(0.5F + f2 - 0.0625F));
        this.field_82405_a.func_82774_a(this.field_94147_f);
        this.field_82405_a.func_78600_a(block, 0, 1.0F);
        this.field_82405_a.func_78595_a();
        this.field_82405_a.func_83017_b();
        GL11.glPopMatrix();
        this.field_82405_a.func_82774_a(Block.field_71988_x.func_71858_a(1, 2));
        GL11.glPushMatrix();
        this.field_82405_a.func_83019_b(0.0D, (double)(0.5F - f2), (double)(0.5F - f2), (double)(f + 1.0E-4F), (double)(f + 0.5F - f2), (double)(0.5F + f2));
        this.field_82405_a.func_78600_a(block, 0, 1.0F);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        this.field_82405_a.func_83019_b(0.0D, (double)(0.5F + f2 - f), (double)(0.5F - f2), (double)(f + 1.0E-4F), (double)(0.5F + f2), (double)(0.5F + f2));
        this.field_82405_a.func_78600_a(block, 0, 1.0F);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        this.field_82405_a.func_83019_b(0.0D, (double)(0.5F - f2), (double)(0.5F - f2), (double)f, (double)(0.5F + f2), (double)(f + 0.5F - f2));
        this.field_82405_a.func_78600_a(block, 0, 1.0F);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        this.field_82405_a.func_83019_b(0.0D, (double)(0.5F - f2), (double)(0.5F + f2 - f), (double)f, (double)(0.5F + f2), (double)(0.5F + f2));
        this.field_82405_a.func_78600_a(block, 0, 1.0F);
        GL11.glPopMatrix();
        this.field_82405_a.func_83017_b();
        this.field_82405_a.func_78595_a();
        GL11.glPopMatrix();
    }

    private void func_82402_b(EntityItemFrame p_82402_1_)
    {
        ItemStack itemstack = p_82402_1_.func_82335_i();

        if (itemstack != null)
        {
            EntityItem entityitem = new EntityItem(p_82402_1_.field_70170_p, 0.0D, 0.0D, 0.0D, itemstack);
            entityitem.func_92059_d().field_77994_a = 1;
            entityitem.field_70290_d = 0.0F;
            GL11.glPushMatrix();
            GL11.glTranslatef(-0.453125F * (float)Direction.field_71583_a[p_82402_1_.field_82332_a], -0.18F, -0.453125F * (float)Direction.field_71581_b[p_82402_1_.field_82332_a]);
            GL11.glRotatef(180.0F + p_82402_1_.field_70177_z, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef((float)(-90 * p_82402_1_.func_82333_j()), 0.0F, 0.0F, 1.0F);

            switch (p_82402_1_.func_82333_j())
            {
                case 1:
                    GL11.glTranslatef(-0.16F, -0.16F, 0.0F);
                    break;
                case 2:
                    GL11.glTranslatef(0.0F, -0.32F, 0.0F);
                    break;
                case 3:
                    GL11.glTranslatef(0.16F, -0.16F, 0.0F);
            }

            if (entityitem.func_92059_d().func_77973_b() == Item.field_77744_bd)
            {
                this.field_76990_c.field_78724_e.func_110577_a(field_110789_a);
                Tessellator tessellator = Tessellator.field_78398_a;
                GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
                GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
                GL11.glScalef(0.00390625F, 0.00390625F, 0.00390625F);
                GL11.glTranslatef(-65.0F, -107.0F, -3.0F);
                GL11.glNormal3f(0.0F, 0.0F, -1.0F);
                tessellator.func_78382_b();
                byte b0 = 7;
                tessellator.func_78374_a((double)(0 - b0), (double)(128 + b0), 0.0D, 0.0D, 1.0D);
                tessellator.func_78374_a((double)(128 + b0), (double)(128 + b0), 0.0D, 1.0D, 1.0D);
                tessellator.func_78374_a((double)(128 + b0), (double)(0 - b0), 0.0D, 1.0D, 0.0D);
                tessellator.func_78374_a((double)(0 - b0), (double)(0 - b0), 0.0D, 0.0D, 0.0D);
                tessellator.func_78381_a();
                MapData mapdata = Item.field_77744_bd.func_77873_a(entityitem.func_92059_d(), p_82402_1_.field_70170_p);
                GL11.glTranslatef(0.0F, 0.0F, -1.0F);

                if (mapdata != null)
                {
                    this.field_76990_c.field_78721_f.field_78449_f.func_78319_a((EntityPlayer)null, this.field_76990_c.field_78724_e, mapdata);
                }
            }
            else
            {
                if (entityitem.func_92059_d().func_77973_b() == Item.field_77750_aQ)
                {
                    TextureManager texturemanager = Minecraft.func_71410_x().func_110434_K();
                    texturemanager.func_110577_a(TextureMap.field_110576_c);
                    TextureAtlasSprite textureatlassprite = ((TextureMap)texturemanager.func_110581_b(TextureMap.field_110576_c)).func_110572_b(Item.field_77750_aQ.func_77650_f(entityitem.func_92059_d()).func_94215_i());

                    if (textureatlassprite instanceof TextureCompass)
                    {
                        TextureCompass texturecompass = (TextureCompass)textureatlassprite;
                        double d0 = texturecompass.field_94244_i;
                        double d1 = texturecompass.field_94242_j;
                        texturecompass.field_94244_i = 0.0D;
                        texturecompass.field_94242_j = 0.0D;
                        texturecompass.func_94241_a(p_82402_1_.field_70170_p, p_82402_1_.field_70165_t, p_82402_1_.field_70161_v, (double)MathHelper.func_76142_g((float)(180 + p_82402_1_.field_82332_a * 90)), false, true);
                        texturecompass.field_94244_i = d0;
                        texturecompass.field_94242_j = d1;
                    }
                }

                RenderItem.field_82407_g = true;
                RenderManager.field_78727_a.func_78719_a(entityitem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
                RenderItem.field_82407_g = false;

                if (entityitem.func_92059_d().func_77973_b() == Item.field_77750_aQ)
                {
                    TextureAtlasSprite textureatlassprite1 = ((TextureMap)Minecraft.func_71410_x().func_110434_K().func_110581_b(TextureMap.field_110576_c)).func_110572_b(Item.field_77750_aQ.func_77650_f(entityitem.func_92059_d()).func_94215_i());

                    if (textureatlassprite1.func_110970_k() > 0)
                    {
                        textureatlassprite1.func_94219_l();
                    }
                }
            }

            GL11.glPopMatrix();
        }
    }

    protected ResourceLocation func_110775_a(Entity p_110775_1_)
    {
        return this.func_110788_a((EntityItemFrame)p_110775_1_);
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.func_82404_a((EntityItemFrame)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
