package net.minecraft.client.renderer.entity;

import com.google.common.collect.Maps;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderBiped extends RenderLiving
{
    protected ModelBiped field_77071_a;
    protected float field_77070_b;
    protected ModelBiped field_82423_g;
    protected ModelBiped field_82425_h;
    private static final Map field_110859_k = Maps.newHashMap();
    public static String[] field_82424_k = new String[] {"leather", "chainmail", "iron", "diamond", "gold"};

    public RenderBiped(ModelBiped p_i1257_1_, float p_i1257_2_)
    {
        this(p_i1257_1_, p_i1257_2_, 1.0F);
    }

    public RenderBiped(ModelBiped p_i1258_1_, float p_i1258_2_, float p_i1258_3_)
    {
        super(p_i1258_1_, p_i1258_2_);
        this.field_77071_a = p_i1258_1_;
        this.field_77070_b = p_i1258_3_;
        this.func_82421_b();
    }

    protected void func_82421_b()
    {
        this.field_82423_g = new ModelBiped(1.0F);
        this.field_82425_h = new ModelBiped(0.5F);
    }

    public static ResourceLocation func_110857_a(ItemArmor p_110857_0_, int p_110857_1_)
    {
        return func_110858_a(p_110857_0_, p_110857_1_, (String)null);
    }

    public static ResourceLocation func_110858_a(ItemArmor p_110858_0_, int p_110858_1_, String p_110858_2_)
    {
        String s1 = String.format("textures/models/armor/%s_layer_%d%s.png", new Object[] {field_82424_k[p_110858_0_.field_77880_c], Integer.valueOf(p_110858_1_ == 2 ? 2 : 1), p_110858_2_ == null ? "" : String.format("_%s", new Object[]{p_110858_2_})});
        ResourceLocation resourcelocation = (ResourceLocation)field_110859_k.get(s1);

        if (resourcelocation == null)
        {
            resourcelocation = new ResourceLocation(s1);
            field_110859_k.put(s1, resourcelocation);
        }

        return resourcelocation;
    }

    protected int func_130006_a(EntityLiving p_130006_1_, int p_130006_2_, float p_130006_3_)
    {
        ItemStack itemstack = p_130006_1_.func_130225_q(3 - p_130006_2_);

        if (itemstack != null)
        {
            Item item = itemstack.func_77973_b();

            if (item instanceof ItemArmor)
            {
                ItemArmor itemarmor = (ItemArmor)item;
                this.func_110776_a(func_110857_a(itemarmor, p_130006_2_));
                ModelBiped modelbiped = p_130006_2_ == 2 ? this.field_82425_h : this.field_82423_g;
                modelbiped.field_78116_c.field_78806_j = p_130006_2_ == 0;
                modelbiped.field_78114_d.field_78806_j = p_130006_2_ == 0;
                modelbiped.field_78115_e.field_78806_j = p_130006_2_ == 1 || p_130006_2_ == 2;
                modelbiped.field_78112_f.field_78806_j = p_130006_2_ == 1;
                modelbiped.field_78113_g.field_78806_j = p_130006_2_ == 1;
                modelbiped.field_78123_h.field_78806_j = p_130006_2_ == 2 || p_130006_2_ == 3;
                modelbiped.field_78124_i.field_78806_j = p_130006_2_ == 2 || p_130006_2_ == 3;
                this.func_77042_a(modelbiped);
                modelbiped.field_78095_p = this.field_77045_g.field_78095_p;
                modelbiped.field_78093_q = this.field_77045_g.field_78093_q;
                modelbiped.field_78091_s = this.field_77045_g.field_78091_s;
                float f1 = 1.0F;

                if (itemarmor.func_82812_d() == EnumArmorMaterial.CLOTH)
                {
                    int j = itemarmor.func_82814_b(itemstack);
                    float f2 = (float)(j >> 16 & 255) / 255.0F;
                    float f3 = (float)(j >> 8 & 255) / 255.0F;
                    float f4 = (float)(j & 255) / 255.0F;
                    GL11.glColor3f(f1 * f2, f1 * f3, f1 * f4);

                    if (itemstack.func_77948_v())
                    {
                        return 31;
                    }

                    return 16;
                }

                GL11.glColor3f(f1, f1, f1);

                if (itemstack.func_77948_v())
                {
                    return 15;
                }

                return 1;
            }
        }

        return -1;
    }

    protected void func_130013_c(EntityLiving p_130013_1_, int p_130013_2_, float p_130013_3_)
    {
        ItemStack itemstack = p_130013_1_.func_130225_q(3 - p_130013_2_);

        if (itemstack != null)
        {
            Item item = itemstack.func_77973_b();

            if (item instanceof ItemArmor)
            {
                this.func_110776_a(func_110858_a((ItemArmor)item, p_130013_2_, "overlay"));
                float f1 = 1.0F;
                GL11.glColor3f(f1, f1, f1);
            }
        }
    }

    public void func_77031_a(EntityLiving p_77031_1_, double p_77031_2_, double p_77031_4_, double p_77031_6_, float p_77031_8_, float p_77031_9_)
    {
        float f2 = 1.0F;
        GL11.glColor3f(f2, f2, f2);
        ItemStack itemstack = p_77031_1_.func_70694_bm();
        this.func_82420_a(p_77031_1_, itemstack);
        double d3 = p_77031_4_ - (double)p_77031_1_.field_70129_M;

        if (p_77031_1_.func_70093_af())
        {
            d3 -= 0.125D;
        }

        super.func_77031_a(p_77031_1_, p_77031_2_, d3, p_77031_6_, p_77031_8_, p_77031_9_);
        this.field_82423_g.field_78118_o = this.field_82425_h.field_78118_o = this.field_77071_a.field_78118_o = false;
        this.field_82423_g.field_78117_n = this.field_82425_h.field_78117_n = this.field_77071_a.field_78117_n = false;
        this.field_82423_g.field_78120_m = this.field_82425_h.field_78120_m = this.field_77071_a.field_78120_m = 0;
    }

    protected ResourceLocation func_110856_a(EntityLiving p_110856_1_)
    {
        return null;
    }

    protected void func_82420_a(EntityLiving p_82420_1_, ItemStack p_82420_2_)
    {
        this.field_82423_g.field_78120_m = this.field_82425_h.field_78120_m = this.field_77071_a.field_78120_m = p_82420_2_ != null ? 1 : 0;
        this.field_82423_g.field_78117_n = this.field_82425_h.field_78117_n = this.field_77071_a.field_78117_n = p_82420_1_.func_70093_af();
    }

    protected void func_130005_c(EntityLiving p_130005_1_, float p_130005_2_)
    {
        float f1 = 1.0F;
        GL11.glColor3f(f1, f1, f1);
        super.func_77029_c(p_130005_1_, p_130005_2_);
        ItemStack itemstack = p_130005_1_.func_70694_bm();
        ItemStack itemstack1 = p_130005_1_.func_130225_q(3);
        float f2;

        if (itemstack1 != null)
        {
            GL11.glPushMatrix();
            this.field_77071_a.field_78116_c.func_78794_c(0.0625F);

            if (itemstack1.func_77973_b().field_77779_bT < 256)
            {
                if (RenderBlocks.func_78597_b(Block.field_71973_m[itemstack1.field_77993_c].func_71857_b()))
                {
                    f2 = 0.625F;
                    GL11.glTranslatef(0.0F, -0.25F, 0.0F);
                    GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
                    GL11.glScalef(f2, -f2, -f2);
                }

                this.field_76990_c.field_78721_f.func_78443_a(p_130005_1_, itemstack1, 0);
            }
            else if (itemstack1.func_77973_b().field_77779_bT == Item.field_82799_bQ.field_77779_bT)
            {
                f2 = 1.0625F;
                GL11.glScalef(f2, -f2, -f2);
                String s = "";

                if (itemstack1.func_77942_o() && itemstack1.func_77978_p().func_74764_b("SkullOwner"))
                {
                    s = itemstack1.func_77978_p().func_74779_i("SkullOwner");
                }

                TileEntitySkullRenderer.field_82397_a.func_82393_a(-0.5F, 0.0F, -0.5F, 1, 180.0F, itemstack1.func_77960_j(), s);
            }

            GL11.glPopMatrix();
        }

        if (itemstack != null)
        {
            GL11.glPushMatrix();

            if (this.field_77045_g.field_78091_s)
            {
                f2 = 0.5F;
                GL11.glTranslatef(0.0F, 0.625F, 0.0F);
                GL11.glRotatef(-20.0F, -1.0F, 0.0F, 0.0F);
                GL11.glScalef(f2, f2, f2);
            }

            this.field_77071_a.field_78112_f.func_78794_c(0.0625F);
            GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);

            if (itemstack.field_77993_c < 256 && RenderBlocks.func_78597_b(Block.field_71973_m[itemstack.field_77993_c].func_71857_b()))
            {
                f2 = 0.5F;
                GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
                f2 *= 0.75F;
                GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
                GL11.glScalef(-f2, -f2, f2);
            }
            else if (itemstack.field_77993_c == Item.field_77707_k.field_77779_bT)
            {
                f2 = 0.625F;
                GL11.glTranslatef(0.0F, 0.125F, 0.3125F);
                GL11.glRotatef(-20.0F, 0.0F, 1.0F, 0.0F);
                GL11.glScalef(f2, -f2, f2);
                GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
            }
            else if (Item.field_77698_e[itemstack.field_77993_c].func_77662_d())
            {
                f2 = 0.625F;

                if (Item.field_77698_e[itemstack.field_77993_c].func_77629_n_())
                {
                    GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
                    GL11.glTranslatef(0.0F, -0.125F, 0.0F);
                }

                this.func_82422_c();
                GL11.glScalef(f2, -f2, f2);
                GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
            }
            else
            {
                f2 = 0.375F;
                GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
                GL11.glScalef(f2, f2, f2);
                GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F);
                GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
            }

            this.field_76990_c.field_78721_f.func_78443_a(p_130005_1_, itemstack, 0);

            if (itemstack.func_77973_b().func_77623_v())
            {
                this.field_76990_c.field_78721_f.func_78443_a(p_130005_1_, itemstack, 1);
            }

            GL11.glPopMatrix();
        }
    }

    protected void func_82422_c()
    {
        GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
    }

    protected void func_82439_b(EntityLivingBase p_82439_1_, int p_82439_2_, float p_82439_3_)
    {
        this.func_130013_c((EntityLiving)p_82439_1_, p_82439_2_, p_82439_3_);
    }

    protected int func_77032_a(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_)
    {
        return this.func_130006_a((EntityLiving)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    protected void func_77029_c(EntityLivingBase p_77029_1_, float p_77029_2_)
    {
        this.func_130005_c((EntityLiving)p_77029_1_, p_77029_2_);
    }

    public void func_77101_a(EntityLivingBase p_77101_1_, double p_77101_2_, double p_77101_4_, double p_77101_6_, float p_77101_8_, float p_77101_9_)
    {
        this.func_77031_a((EntityLiving)p_77101_1_, p_77101_2_, p_77101_4_, p_77101_6_, p_77101_8_, p_77101_9_);
    }

    protected ResourceLocation func_110775_a(Entity p_110775_1_)
    {
        return this.func_110856_a((EntityLiving)p_110775_1_);
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.func_77031_a((EntityLiving)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
