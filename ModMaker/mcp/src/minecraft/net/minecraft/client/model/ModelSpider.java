package net.minecraft.client.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

@SideOnly(Side.CLIENT)
public class ModelSpider extends ModelBase
{
    public ModelRenderer field_78209_a;
    public ModelRenderer field_78207_b;
    public ModelRenderer field_78208_c;
    public ModelRenderer field_78205_d;
    public ModelRenderer field_78206_e;
    public ModelRenderer field_78203_f;
    public ModelRenderer field_78204_g;
    public ModelRenderer field_78212_h;
    public ModelRenderer field_78213_i;
    public ModelRenderer field_78210_j;
    public ModelRenderer field_78211_k;

    public ModelSpider()
    {
        float f = 0.0F;
        byte b0 = 15;
        this.field_78209_a = new ModelRenderer(this, 32, 4);
        this.field_78209_a.func_78790_a(-4.0F, -4.0F, -8.0F, 8, 8, 8, f);
        this.field_78209_a.func_78793_a(0.0F, (float)b0, -3.0F);
        this.field_78207_b = new ModelRenderer(this, 0, 0);
        this.field_78207_b.func_78790_a(-3.0F, -3.0F, -3.0F, 6, 6, 6, f);
        this.field_78207_b.func_78793_a(0.0F, (float)b0, 0.0F);
        this.field_78208_c = new ModelRenderer(this, 0, 12);
        this.field_78208_c.func_78790_a(-5.0F, -4.0F, -6.0F, 10, 8, 12, f);
        this.field_78208_c.func_78793_a(0.0F, (float)b0, 9.0F);
        this.field_78205_d = new ModelRenderer(this, 18, 0);
        this.field_78205_d.func_78790_a(-15.0F, -1.0F, -1.0F, 16, 2, 2, f);
        this.field_78205_d.func_78793_a(-4.0F, (float)b0, 2.0F);
        this.field_78206_e = new ModelRenderer(this, 18, 0);
        this.field_78206_e.func_78790_a(-1.0F, -1.0F, -1.0F, 16, 2, 2, f);
        this.field_78206_e.func_78793_a(4.0F, (float)b0, 2.0F);
        this.field_78203_f = new ModelRenderer(this, 18, 0);
        this.field_78203_f.func_78790_a(-15.0F, -1.0F, -1.0F, 16, 2, 2, f);
        this.field_78203_f.func_78793_a(-4.0F, (float)b0, 1.0F);
        this.field_78204_g = new ModelRenderer(this, 18, 0);
        this.field_78204_g.func_78790_a(-1.0F, -1.0F, -1.0F, 16, 2, 2, f);
        this.field_78204_g.func_78793_a(4.0F, (float)b0, 1.0F);
        this.field_78212_h = new ModelRenderer(this, 18, 0);
        this.field_78212_h.func_78790_a(-15.0F, -1.0F, -1.0F, 16, 2, 2, f);
        this.field_78212_h.func_78793_a(-4.0F, (float)b0, 0.0F);
        this.field_78213_i = new ModelRenderer(this, 18, 0);
        this.field_78213_i.func_78790_a(-1.0F, -1.0F, -1.0F, 16, 2, 2, f);
        this.field_78213_i.func_78793_a(4.0F, (float)b0, 0.0F);
        this.field_78210_j = new ModelRenderer(this, 18, 0);
        this.field_78210_j.func_78790_a(-15.0F, -1.0F, -1.0F, 16, 2, 2, f);
        this.field_78210_j.func_78793_a(-4.0F, (float)b0, -1.0F);
        this.field_78211_k = new ModelRenderer(this, 18, 0);
        this.field_78211_k.func_78790_a(-1.0F, -1.0F, -1.0F, 16, 2, 2, f);
        this.field_78211_k.func_78793_a(4.0F, (float)b0, -1.0F);
    }

    public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_)
    {
        this.func_78087_a(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, p_78088_1_);
        this.field_78209_a.func_78785_a(p_78088_7_);
        this.field_78207_b.func_78785_a(p_78088_7_);
        this.field_78208_c.func_78785_a(p_78088_7_);
        this.field_78205_d.func_78785_a(p_78088_7_);
        this.field_78206_e.func_78785_a(p_78088_7_);
        this.field_78203_f.func_78785_a(p_78088_7_);
        this.field_78204_g.func_78785_a(p_78088_7_);
        this.field_78212_h.func_78785_a(p_78088_7_);
        this.field_78213_i.func_78785_a(p_78088_7_);
        this.field_78210_j.func_78785_a(p_78088_7_);
        this.field_78211_k.func_78785_a(p_78088_7_);
    }

    public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_)
    {
        this.field_78209_a.field_78796_g = p_78087_4_ / (180F / (float)Math.PI);
        this.field_78209_a.field_78795_f = p_78087_5_ / (180F / (float)Math.PI);
        float f6 = ((float)Math.PI / 4F);
        this.field_78205_d.field_78808_h = -f6;
        this.field_78206_e.field_78808_h = f6;
        this.field_78203_f.field_78808_h = -f6 * 0.74F;
        this.field_78204_g.field_78808_h = f6 * 0.74F;
        this.field_78212_h.field_78808_h = -f6 * 0.74F;
        this.field_78213_i.field_78808_h = f6 * 0.74F;
        this.field_78210_j.field_78808_h = -f6;
        this.field_78211_k.field_78808_h = f6;
        float f7 = -0.0F;
        float f8 = 0.3926991F;
        this.field_78205_d.field_78796_g = f8 * 2.0F + f7;
        this.field_78206_e.field_78796_g = -f8 * 2.0F - f7;
        this.field_78203_f.field_78796_g = f8 * 1.0F + f7;
        this.field_78204_g.field_78796_g = -f8 * 1.0F - f7;
        this.field_78212_h.field_78796_g = -f8 * 1.0F + f7;
        this.field_78213_i.field_78796_g = f8 * 1.0F - f7;
        this.field_78210_j.field_78796_g = -f8 * 2.0F + f7;
        this.field_78211_k.field_78796_g = f8 * 2.0F - f7;
        float f9 = -(MathHelper.func_76134_b(p_78087_1_ * 0.6662F * 2.0F + 0.0F) * 0.4F) * p_78087_2_;
        float f10 = -(MathHelper.func_76134_b(p_78087_1_ * 0.6662F * 2.0F + (float)Math.PI) * 0.4F) * p_78087_2_;
        float f11 = -(MathHelper.func_76134_b(p_78087_1_ * 0.6662F * 2.0F + ((float)Math.PI / 2F)) * 0.4F) * p_78087_2_;
        float f12 = -(MathHelper.func_76134_b(p_78087_1_ * 0.6662F * 2.0F + ((float)Math.PI * 3F / 2F)) * 0.4F) * p_78087_2_;
        float f13 = Math.abs(MathHelper.func_76126_a(p_78087_1_ * 0.6662F + 0.0F) * 0.4F) * p_78087_2_;
        float f14 = Math.abs(MathHelper.func_76126_a(p_78087_1_ * 0.6662F + (float)Math.PI) * 0.4F) * p_78087_2_;
        float f15 = Math.abs(MathHelper.func_76126_a(p_78087_1_ * 0.6662F + ((float)Math.PI / 2F)) * 0.4F) * p_78087_2_;
        float f16 = Math.abs(MathHelper.func_76126_a(p_78087_1_ * 0.6662F + ((float)Math.PI * 3F / 2F)) * 0.4F) * p_78087_2_;
        this.field_78205_d.field_78796_g += f9;
        this.field_78206_e.field_78796_g += -f9;
        this.field_78203_f.field_78796_g += f10;
        this.field_78204_g.field_78796_g += -f10;
        this.field_78212_h.field_78796_g += f11;
        this.field_78213_i.field_78796_g += -f11;
        this.field_78210_j.field_78796_g += f12;
        this.field_78211_k.field_78796_g += -f12;
        this.field_78205_d.field_78808_h += f13;
        this.field_78206_e.field_78808_h += -f13;
        this.field_78203_f.field_78808_h += f14;
        this.field_78204_g.field_78808_h += -f14;
        this.field_78212_h.field_78808_h += f15;
        this.field_78213_i.field_78808_h += -f15;
        this.field_78210_j.field_78808_h += f16;
        this.field_78211_k.field_78808_h += -f16;
    }
}