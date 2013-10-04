package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderPlayer extends RendererLivingEntity
{
    private static final ResourceLocation field_110826_a = new ResourceLocation("textures/entity/steve.png");
    private ModelBiped field_77109_a;
    private ModelBiped field_77108_b;
    private ModelBiped field_77111_i;

    public RenderPlayer()
    {
        super(new ModelBiped(0.0F), 0.5F);
        this.field_77109_a = (ModelBiped)this.field_77045_g;
        this.field_77108_b = new ModelBiped(1.0F);
        this.field_77111_i = new ModelBiped(0.5F);
    }

    protected int func_77107_a(AbstractClientPlayer p_77107_1_, int p_77107_2_, float p_77107_3_)
    {
        ItemStack itemstack = p_77107_1_.field_71071_by.func_70440_f(3 - p_77107_2_);

        if (itemstack != null)
        {
            Item item = itemstack.func_77973_b();

            if (item instanceof ItemArmor)
            {
                ItemArmor itemarmor = (ItemArmor)item;
                this.func_110776_a(RenderBiped.func_110857_a(itemarmor, p_77107_2_));
                ModelBiped modelbiped = p_77107_2_ == 2 ? this.field_77111_i : this.field_77108_b;
                modelbiped.field_78116_c.field_78806_j = p_77107_2_ == 0;
                modelbiped.field_78114_d.field_78806_j = p_77107_2_ == 0;
                modelbiped.field_78115_e.field_78806_j = p_77107_2_ == 1 || p_77107_2_ == 2;
                modelbiped.field_78112_f.field_78806_j = p_77107_2_ == 1;
                modelbiped.field_78113_g.field_78806_j = p_77107_2_ == 1;
                modelbiped.field_78123_h.field_78806_j = p_77107_2_ == 2 || p_77107_2_ == 3;
                modelbiped.field_78124_i.field_78806_j = p_77107_2_ == 2 || p_77107_2_ == 3;
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

    protected void func_130220_b(AbstractClientPlayer p_130220_1_, int p_130220_2_, float p_130220_3_)
    {
        ItemStack itemstack = p_130220_1_.field_71071_by.func_70440_f(3 - p_130220_2_);

        if (itemstack != null)
        {
            Item item = itemstack.func_77973_b();

            if (item instanceof ItemArmor)
            {
                this.func_110776_a(RenderBiped.func_110858_a((ItemArmor)item, p_130220_2_, "overlay"));
                float f1 = 1.0F;
                GL11.glColor3f(f1, f1, f1);
            }
        }
    }

    public void func_130009_a(AbstractClientPlayer p_130009_1_, double p_130009_2_, double p_130009_4_, double p_130009_6_, float p_130009_8_, float p_130009_9_)
    {
        float f2 = 1.0F;
        GL11.glColor3f(f2, f2, f2);
        ItemStack itemstack = p_130009_1_.field_71071_by.func_70448_g();
        this.field_77108_b.field_78120_m = this.field_77111_i.field_78120_m = this.field_77109_a.field_78120_m = itemstack != null ? 1 : 0;

        if (itemstack != null && p_130009_1_.func_71052_bv() > 0)
        {
            EnumAction enumaction = itemstack.func_77975_n();

            if (enumaction == EnumAction.block)
            {
                this.field_77108_b.field_78120_m = this.field_77111_i.field_78120_m = this.field_77109_a.field_78120_m = 3;
            }
            else if (enumaction == EnumAction.bow)
            {
                this.field_77108_b.field_78118_o = this.field_77111_i.field_78118_o = this.field_77109_a.field_78118_o = true;
            }
        }

        this.field_77108_b.field_78117_n = this.field_77111_i.field_78117_n = this.field_77109_a.field_78117_n = p_130009_1_.func_70093_af();
        double d3 = p_130009_4_ - (double)p_130009_1_.field_70129_M;

        if (p_130009_1_.func_70093_af() && !(p_130009_1_ instanceof EntityPlayerSP))
        {
            d3 -= 0.125D;
        }

        super.func_130000_a(p_130009_1_, p_130009_2_, d3, p_130009_6_, p_130009_8_, p_130009_9_);
        this.field_77108_b.field_78118_o = this.field_77111_i.field_78118_o = this.field_77109_a.field_78118_o = false;
        this.field_77108_b.field_78117_n = this.field_77111_i.field_78117_n = this.field_77109_a.field_78117_n = false;
        this.field_77108_b.field_78120_m = this.field_77111_i.field_78120_m = this.field_77109_a.field_78120_m = 0;
    }

    protected ResourceLocation func_110817_a(AbstractClientPlayer p_110817_1_)
    {
        return p_110817_1_.func_110306_p();
    }

    protected void func_77100_a(AbstractClientPlayer p_77100_1_, float p_77100_2_)
    {
        float f1 = 1.0F;
        GL11.glColor3f(f1, f1, f1);
        super.func_77029_c(p_77100_1_, p_77100_2_);
        super.func_85093_e(p_77100_1_, p_77100_2_);
        ItemStack itemstack = p_77100_1_.field_71071_by.func_70440_f(3);

        if (itemstack != null)
        {
            GL11.glPushMatrix();
            this.field_77109_a.field_78116_c.func_78794_c(0.0625F);
            float f2;

            if (itemstack.func_77973_b().field_77779_bT < 256)
            {
                if (RenderBlocks.func_78597_b(Block.field_71973_m[itemstack.field_77993_c].func_71857_b()))
                {
                    f2 = 0.625F;
                    GL11.glTranslatef(0.0F, -0.25F, 0.0F);
                    GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
                    GL11.glScalef(f2, -f2, -f2);
                }

                this.field_76990_c.field_78721_f.func_78443_a(p_77100_1_, itemstack, 0);
            }
            else if (itemstack.func_77973_b().field_77779_bT == Item.field_82799_bQ.field_77779_bT)
            {
                f2 = 1.0625F;
                GL11.glScalef(f2, -f2, -f2);
                String s = "";

                if (itemstack.func_77942_o() && itemstack.func_77978_p().func_74764_b("SkullOwner"))
                {
                    s = itemstack.func_77978_p().func_74779_i("SkullOwner");
                }

                TileEntitySkullRenderer.field_82397_a.func_82393_a(-0.5F, 0.0F, -0.5F, 1, 180.0F, itemstack.func_77960_j(), s);
            }

            GL11.glPopMatrix();
        }

        if (p_77100_1_.func_70005_c_().equals("deadmau5") && p_77100_1_.func_110309_l().func_110557_a())
        {
            this.func_110776_a(p_77100_1_.func_110306_p());

            for (int i = 0; i < 2; ++i)
            {
                float f3 = p_77100_1_.field_70126_B + (p_77100_1_.field_70177_z - p_77100_1_.field_70126_B) * p_77100_2_ - (p_77100_1_.field_70760_ar + (p_77100_1_.field_70761_aq - p_77100_1_.field_70760_ar) * p_77100_2_);
                float f4 = p_77100_1_.field_70127_C + (p_77100_1_.field_70125_A - p_77100_1_.field_70127_C) * p_77100_2_;
                GL11.glPushMatrix();
                GL11.glRotatef(f3, 0.0F, 1.0F, 0.0F);
                GL11.glRotatef(f4, 1.0F, 0.0F, 0.0F);
                GL11.glTranslatef(0.375F * (float)(i * 2 - 1), 0.0F, 0.0F);
                GL11.glTranslatef(0.0F, -0.375F, 0.0F);
                GL11.glRotatef(-f4, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(-f3, 0.0F, 1.0F, 0.0F);
                float f5 = 1.3333334F;
                GL11.glScalef(f5, f5, f5);
                this.field_77109_a.func_78110_b(0.0625F);
                GL11.glPopMatrix();
            }
        }

        boolean flag = p_77100_1_.func_110310_o().func_110557_a();
        boolean flag1 = !p_77100_1_.func_82150_aj();
        boolean flag2 = !p_77100_1_.func_82238_cc();
        float f6;

        if (flag && flag1 && flag2)
        {
            this.func_110776_a(p_77100_1_.func_110303_q());
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, 0.0F, 0.125F);
            double d0 = p_77100_1_.field_71091_bM + (p_77100_1_.field_71094_bP - p_77100_1_.field_71091_bM) * (double)p_77100_2_ - (p_77100_1_.field_70169_q + (p_77100_1_.field_70165_t - p_77100_1_.field_70169_q) * (double)p_77100_2_);
            double d1 = p_77100_1_.field_71096_bN + (p_77100_1_.field_71095_bQ - p_77100_1_.field_71096_bN) * (double)p_77100_2_ - (p_77100_1_.field_70167_r + (p_77100_1_.field_70163_u - p_77100_1_.field_70167_r) * (double)p_77100_2_);
            double d2 = p_77100_1_.field_71097_bO + (p_77100_1_.field_71085_bR - p_77100_1_.field_71097_bO) * (double)p_77100_2_ - (p_77100_1_.field_70166_s + (p_77100_1_.field_70161_v - p_77100_1_.field_70166_s) * (double)p_77100_2_);
            f6 = p_77100_1_.field_70760_ar + (p_77100_1_.field_70761_aq - p_77100_1_.field_70760_ar) * p_77100_2_;
            double d3 = (double)MathHelper.func_76126_a(f6 * (float)Math.PI / 180.0F);
            double d4 = (double)(-MathHelper.func_76134_b(f6 * (float)Math.PI / 180.0F));
            float f7 = (float)d1 * 10.0F;

            if (f7 < -6.0F)
            {
                f7 = -6.0F;
            }

            if (f7 > 32.0F)
            {
                f7 = 32.0F;
            }

            float f8 = (float)(d0 * d3 + d2 * d4) * 100.0F;
            float f9 = (float)(d0 * d4 - d2 * d3) * 100.0F;

            if (f8 < 0.0F)
            {
                f8 = 0.0F;
            }

            float f10 = p_77100_1_.field_71107_bF + (p_77100_1_.field_71109_bG - p_77100_1_.field_71107_bF) * p_77100_2_;
            f7 += MathHelper.func_76126_a((p_77100_1_.field_70141_P + (p_77100_1_.field_70140_Q - p_77100_1_.field_70141_P) * p_77100_2_) * 6.0F) * 32.0F * f10;

            if (p_77100_1_.func_70093_af())
            {
                f7 += 25.0F;
            }

            GL11.glRotatef(6.0F + f8 / 2.0F + f7, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(f9 / 2.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(-f9 / 2.0F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
            this.field_77109_a.func_78111_c(0.0625F);
            GL11.glPopMatrix();
        }

        ItemStack itemstack1 = p_77100_1_.field_71071_by.func_70448_g();

        if (itemstack1 != null)
        {
            GL11.glPushMatrix();
            this.field_77109_a.field_78112_f.func_78794_c(0.0625F);
            GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);

            if (p_77100_1_.field_71104_cf != null)
            {
                itemstack1 = new ItemStack(Item.field_77669_D);
            }

            EnumAction enumaction = null;

            if (p_77100_1_.func_71052_bv() > 0)
            {
                enumaction = itemstack1.func_77975_n();
            }

            float f11;

            if (itemstack1.field_77993_c < 256 && RenderBlocks.func_78597_b(Block.field_71973_m[itemstack1.field_77993_c].func_71857_b()))
            {
                f11 = 0.5F;
                GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
                f11 *= 0.75F;
                GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
                GL11.glScalef(-f11, -f11, f11);
            }
            else if (itemstack1.field_77993_c == Item.field_77707_k.field_77779_bT)
            {
                f11 = 0.625F;
                GL11.glTranslatef(0.0F, 0.125F, 0.3125F);
                GL11.glRotatef(-20.0F, 0.0F, 1.0F, 0.0F);
                GL11.glScalef(f11, -f11, f11);
                GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
            }
            else if (Item.field_77698_e[itemstack1.field_77993_c].func_77662_d())
            {
                f11 = 0.625F;

                if (Item.field_77698_e[itemstack1.field_77993_c].func_77629_n_())
                {
                    GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
                    GL11.glTranslatef(0.0F, -0.125F, 0.0F);
                }

                if (p_77100_1_.func_71052_bv() > 0 && enumaction == EnumAction.block)
                {
                    GL11.glTranslatef(0.05F, 0.0F, -0.1F);
                    GL11.glRotatef(-50.0F, 0.0F, 1.0F, 0.0F);
                    GL11.glRotatef(-10.0F, 1.0F, 0.0F, 0.0F);
                    GL11.glRotatef(-60.0F, 0.0F, 0.0F, 1.0F);
                }

                GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
                GL11.glScalef(f11, -f11, f11);
                GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
            }
            else
            {
                f11 = 0.375F;
                GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
                GL11.glScalef(f11, f11, f11);
                GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F);
                GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
            }

            float f12;
            float f13;
            int j;

            if (itemstack1.func_77973_b().func_77623_v())
            {
                for (j = 0; j <= 1; ++j)
                {
                    int k = itemstack1.func_77973_b().func_82790_a(itemstack1, j);
                    f13 = (float)(k >> 16 & 255) / 255.0F;
                    f12 = (float)(k >> 8 & 255) / 255.0F;
                    f6 = (float)(k & 255) / 255.0F;
                    GL11.glColor4f(f13, f12, f6, 1.0F);
                    this.field_76990_c.field_78721_f.func_78443_a(p_77100_1_, itemstack1, j);
                }
            }
            else
            {
                j = itemstack1.func_77973_b().func_82790_a(itemstack1, 0);
                float f14 = (float)(j >> 16 & 255) / 255.0F;
                f13 = (float)(j >> 8 & 255) / 255.0F;
                f12 = (float)(j & 255) / 255.0F;
                GL11.glColor4f(f14, f13, f12, 1.0F);
                this.field_76990_c.field_78721_f.func_78443_a(p_77100_1_, itemstack1, 0);
            }

            GL11.glPopMatrix();
        }
    }

    protected void func_77104_b(AbstractClientPlayer p_77104_1_, float p_77104_2_)
    {
        float f1 = 0.9375F;
        GL11.glScalef(f1, f1, f1);
    }

    protected void func_96450_a(AbstractClientPlayer p_96450_1_, double p_96450_2_, double p_96450_4_, double p_96450_6_, String p_96450_8_, float p_96450_9_, double p_96450_10_)
    {
        if (p_96450_10_ < 100.0D)
        {
            Scoreboard scoreboard = p_96450_1_.func_96123_co();
            ScoreObjective scoreobjective = scoreboard.func_96539_a(2);

            if (scoreobjective != null)
            {
                Score score = scoreboard.func_96529_a(p_96450_1_.func_70023_ak(), scoreobjective);

                if (p_96450_1_.func_70608_bn())
                {
                    this.func_77038_a(p_96450_1_, score.func_96652_c() + " " + scoreobjective.func_96678_d(), p_96450_2_, p_96450_4_ - 1.5D, p_96450_6_, 64);
                }
                else
                {
                    this.func_77038_a(p_96450_1_, score.func_96652_c() + " " + scoreobjective.func_96678_d(), p_96450_2_, p_96450_4_, p_96450_6_, 64);
                }

                p_96450_4_ += (double)((float)this.func_76983_a().field_78288_b * 1.15F * p_96450_9_);
            }
        }

        super.func_96449_a(p_96450_1_, p_96450_2_, p_96450_4_, p_96450_6_, p_96450_8_, p_96450_9_, p_96450_10_);
    }

    public void func_82441_a(EntityPlayer p_82441_1_)
    {
        float f = 1.0F;
        GL11.glColor3f(f, f, f);
        this.field_77109_a.field_78095_p = 0.0F;
        this.field_77109_a.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, p_82441_1_);
        this.field_77109_a.field_78112_f.func_78785_a(0.0625F);
    }

    protected void func_77105_b(AbstractClientPlayer p_77105_1_, double p_77105_2_, double p_77105_4_, double p_77105_6_)
    {
        if (p_77105_1_.func_70089_S() && p_77105_1_.func_70608_bn())
        {
            super.func_77039_a(p_77105_1_, p_77105_2_ + (double)p_77105_1_.field_71079_bU, p_77105_4_ + (double)p_77105_1_.field_71082_cx, p_77105_6_ + (double)p_77105_1_.field_71089_bV);
        }
        else
        {
            super.func_77039_a(p_77105_1_, p_77105_2_, p_77105_4_, p_77105_6_);
        }
    }

    protected void func_77102_a(AbstractClientPlayer p_77102_1_, float p_77102_2_, float p_77102_3_, float p_77102_4_)
    {
        if (p_77102_1_.func_70089_S() && p_77102_1_.func_70608_bn())
        {
            GL11.glRotatef(p_77102_1_.func_71051_bG(), 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(this.func_77037_a(p_77102_1_), 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(270.0F, 0.0F, 1.0F, 0.0F);
        }
        else
        {
            super.func_77043_a(p_77102_1_, p_77102_2_, p_77102_3_, p_77102_4_);
        }
    }

    protected void func_96449_a(EntityLivingBase p_96449_1_, double p_96449_2_, double p_96449_4_, double p_96449_6_, String p_96449_8_, float p_96449_9_, double p_96449_10_)
    {
        this.func_96450_a((AbstractClientPlayer)p_96449_1_, p_96449_2_, p_96449_4_, p_96449_6_, p_96449_8_, p_96449_9_, p_96449_10_);
    }

    protected void func_77041_b(EntityLivingBase p_77041_1_, float p_77041_2_)
    {
        this.func_77104_b((AbstractClientPlayer)p_77041_1_, p_77041_2_);
    }

    protected void func_82408_c(EntityLivingBase p_82408_1_, int p_82408_2_, float p_82408_3_)
    {
        this.func_130220_b((AbstractClientPlayer)p_82408_1_, p_82408_2_, p_82408_3_);
    }

    protected int func_77032_a(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_)
    {
        return this.func_77107_a((AbstractClientPlayer)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    protected void func_77029_c(EntityLivingBase p_77029_1_, float p_77029_2_)
    {
        this.func_77100_a((AbstractClientPlayer)p_77029_1_, p_77029_2_);
    }

    protected void func_77043_a(EntityLivingBase p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_)
    {
        this.func_77102_a((AbstractClientPlayer)p_77043_1_, p_77043_2_, p_77043_3_, p_77043_4_);
    }

    protected void func_77039_a(EntityLivingBase p_77039_1_, double p_77039_2_, double p_77039_4_, double p_77039_6_)
    {
        this.func_77105_b((AbstractClientPlayer)p_77039_1_, p_77039_2_, p_77039_4_, p_77039_6_);
    }

    public void func_130000_a(EntityLivingBase p_130000_1_, double p_130000_2_, double p_130000_4_, double p_130000_6_, float p_130000_8_, float p_130000_9_)
    {
        this.func_130009_a((AbstractClientPlayer)p_130000_1_, p_130000_2_, p_130000_4_, p_130000_6_, p_130000_8_, p_130000_9_);
    }

    protected ResourceLocation func_110775_a(Entity p_110775_1_)
    {
        return this.func_110817_a((AbstractClientPlayer)p_110775_1_);
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.func_130009_a((AbstractClientPlayer)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
