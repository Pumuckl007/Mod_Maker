package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderEnd;

public class BlockFire extends Block
{
    private int[] field_72258_a = new int[256];
    private int[] field_72257_b = new int[256];
    @SideOnly(Side.CLIENT)
    private Icon[] field_94439_c;

    protected BlockFire(int p_i2201_1_)
    {
        super(p_i2201_1_, Material.field_76250_n);
        this.func_71907_b(true);
    }

    public void func_71928_r_()
    {
        this.func_72253_a(Block.field_71988_x.field_71990_ca, 5, 20);
        this.func_72253_a(Block.field_72090_bN.field_71990_ca, 5, 20);
        this.func_72253_a(Block.field_72092_bO.field_71990_ca, 5, 20);
        this.func_72253_a(Block.field_72031_aZ.field_71990_ca, 5, 20);
        this.func_72253_a(Block.field_72063_at.field_71990_ca, 5, 20);
        this.func_72253_a(Block.field_72072_bX.field_71990_ca, 5, 20);
        this.func_72253_a(Block.field_72074_bW.field_71990_ca, 5, 20);
        this.func_72253_a(Block.field_72070_bY.field_71990_ca, 5, 20);
        this.func_72253_a(Block.field_71951_J.field_71990_ca, 5, 5);
        this.func_72253_a(Block.field_71952_K.field_71990_ca, 30, 60);
        this.func_72253_a(Block.field_72093_an.field_71990_ca, 30, 20);
        this.func_72253_a(Block.field_72091_am.field_71990_ca, 15, 100);
        this.func_72253_a(Block.field_71962_X.field_71990_ca, 60, 100);
        this.func_72253_a(Block.field_72101_ab.field_71990_ca, 30, 60);
        this.func_72253_a(Block.field_71998_bu.field_71990_ca, 15, 100);
        this.func_72253_a(Block.field_111034_cE.field_71990_ca, 5, 5);
        this.func_72253_a(Block.field_111038_cB.field_71990_ca, 60, 20);
    }

    private void func_72253_a(int p_72253_1_, int p_72253_2_, int p_72253_3_)
    {
        this.field_72258_a[p_72253_1_] = p_72253_2_;
        this.field_72257_b[p_72253_1_] = p_72253_3_;
    }

    public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int p_71872_4_)
    {
        return null;
    }

    public boolean func_71926_d()
    {
        return false;
    }

    public boolean func_71886_c()
    {
        return false;
    }

    public int func_71857_b()
    {
        return 3;
    }

    public int func_71925_a(Random p_71925_1_)
    {
        return 0;
    }

    public int func_71859_p_(World p_71859_1_)
    {
        return 30;
    }

    public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_)
    {
        if (p_71847_1_.func_82736_K().func_82766_b("doFireTick"))
        {
            boolean flag = p_71847_1_.func_72798_a(p_71847_2_, p_71847_3_ - 1, p_71847_4_) == Block.field_72012_bb.field_71990_ca;

            if (p_71847_1_.field_73011_w instanceof WorldProviderEnd && p_71847_1_.func_72798_a(p_71847_2_, p_71847_3_ - 1, p_71847_4_) == Block.field_71986_z.field_71990_ca)
            {
                flag = true;
            }

            if (!this.func_71930_b(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_))
            {
                p_71847_1_.func_94571_i(p_71847_2_, p_71847_3_, p_71847_4_);
            }

            if (!flag && p_71847_1_.func_72896_J() && (p_71847_1_.func_72951_B(p_71847_2_, p_71847_3_, p_71847_4_) || p_71847_1_.func_72951_B(p_71847_2_ - 1, p_71847_3_, p_71847_4_) || p_71847_1_.func_72951_B(p_71847_2_ + 1, p_71847_3_, p_71847_4_) || p_71847_1_.func_72951_B(p_71847_2_, p_71847_3_, p_71847_4_ - 1) || p_71847_1_.func_72951_B(p_71847_2_, p_71847_3_, p_71847_4_ + 1)))
            {
                p_71847_1_.func_94571_i(p_71847_2_, p_71847_3_, p_71847_4_);
            }
            else
            {
                int l = p_71847_1_.func_72805_g(p_71847_2_, p_71847_3_, p_71847_4_);

                if (l < 15)
                {
                    p_71847_1_.func_72921_c(p_71847_2_, p_71847_3_, p_71847_4_, l + p_71847_5_.nextInt(3) / 2, 4);
                }

                p_71847_1_.func_72836_a(p_71847_2_, p_71847_3_, p_71847_4_, this.field_71990_ca, this.func_71859_p_(p_71847_1_) + p_71847_5_.nextInt(10));

                if (!flag && !this.func_72251_l(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_))
                {
                    if (!p_71847_1_.func_72797_t(p_71847_2_, p_71847_3_ - 1, p_71847_4_) || l > 3)
                    {
                        p_71847_1_.func_94571_i(p_71847_2_, p_71847_3_, p_71847_4_);
                    }
                }
                else if (!flag && !this.func_72256_d(p_71847_1_, p_71847_2_, p_71847_3_ - 1, p_71847_4_) && l == 15 && p_71847_5_.nextInt(4) == 0)
                {
                    p_71847_1_.func_94571_i(p_71847_2_, p_71847_3_, p_71847_4_);
                }
                else
                {
                    boolean flag1 = p_71847_1_.func_72958_C(p_71847_2_, p_71847_3_, p_71847_4_);
                    byte b0 = 0;

                    if (flag1)
                    {
                        b0 = -50;
                    }

                    this.func_72255_a(p_71847_1_, p_71847_2_ + 1, p_71847_3_, p_71847_4_, 300 + b0, p_71847_5_, l);
                    this.func_72255_a(p_71847_1_, p_71847_2_ - 1, p_71847_3_, p_71847_4_, 300 + b0, p_71847_5_, l);
                    this.func_72255_a(p_71847_1_, p_71847_2_, p_71847_3_ - 1, p_71847_4_, 250 + b0, p_71847_5_, l);
                    this.func_72255_a(p_71847_1_, p_71847_2_, p_71847_3_ + 1, p_71847_4_, 250 + b0, p_71847_5_, l);
                    this.func_72255_a(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_ - 1, 300 + b0, p_71847_5_, l);
                    this.func_72255_a(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_ + 1, 300 + b0, p_71847_5_, l);

                    for (int i1 = p_71847_2_ - 1; i1 <= p_71847_2_ + 1; ++i1)
                    {
                        for (int j1 = p_71847_4_ - 1; j1 <= p_71847_4_ + 1; ++j1)
                        {
                            for (int k1 = p_71847_3_ - 1; k1 <= p_71847_3_ + 4; ++k1)
                            {
                                if (i1 != p_71847_2_ || k1 != p_71847_3_ || j1 != p_71847_4_)
                                {
                                    int l1 = 100;

                                    if (k1 > p_71847_3_ + 1)
                                    {
                                        l1 += (k1 - (p_71847_3_ + 1)) * 100;
                                    }

                                    int i2 = this.func_72254_n(p_71847_1_, i1, k1, j1);

                                    if (i2 > 0)
                                    {
                                        int j2 = (i2 + 40 + p_71847_1_.field_73013_u * 7) / (l + 30);

                                        if (flag1)
                                        {
                                            j2 /= 2;
                                        }

                                        if (j2 > 0 && p_71847_5_.nextInt(l1) <= j2 && (!p_71847_1_.func_72896_J() || !p_71847_1_.func_72951_B(i1, k1, j1)) && !p_71847_1_.func_72951_B(i1 - 1, k1, p_71847_4_) && !p_71847_1_.func_72951_B(i1 + 1, k1, j1) && !p_71847_1_.func_72951_B(i1, k1, j1 - 1) && !p_71847_1_.func_72951_B(i1, k1, j1 + 1))
                                        {
                                            int k2 = l + p_71847_5_.nextInt(5) / 4;

                                            if (k2 > 15)
                                            {
                                                k2 = 15;
                                            }

                                            p_71847_1_.func_72832_d(i1, k1, j1, this.field_71990_ca, k2, 3);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean func_82506_l()
    {
        return false;
    }

    private void func_72255_a(World p_72255_1_, int p_72255_2_, int p_72255_3_, int p_72255_4_, int p_72255_5_, Random p_72255_6_, int p_72255_7_)
    {
        int j1 = this.field_72257_b[p_72255_1_.func_72798_a(p_72255_2_, p_72255_3_, p_72255_4_)];

        if (p_72255_6_.nextInt(p_72255_5_) < j1)
        {
            boolean flag = p_72255_1_.func_72798_a(p_72255_2_, p_72255_3_, p_72255_4_) == Block.field_72091_am.field_71990_ca;

            if (p_72255_6_.nextInt(p_72255_7_ + 10) < 5 && !p_72255_1_.func_72951_B(p_72255_2_, p_72255_3_, p_72255_4_))
            {
                int k1 = p_72255_7_ + p_72255_6_.nextInt(5) / 4;

                if (k1 > 15)
                {
                    k1 = 15;
                }

                p_72255_1_.func_72832_d(p_72255_2_, p_72255_3_, p_72255_4_, this.field_71990_ca, k1, 3);
            }
            else
            {
                p_72255_1_.func_94571_i(p_72255_2_, p_72255_3_, p_72255_4_);
            }

            if (flag)
            {
                Block.field_72091_am.func_71898_d(p_72255_1_, p_72255_2_, p_72255_3_, p_72255_4_, 1);
            }
        }
    }

    private boolean func_72251_l(World p_72251_1_, int p_72251_2_, int p_72251_3_, int p_72251_4_)
    {
        return this.func_72256_d(p_72251_1_, p_72251_2_ + 1, p_72251_3_, p_72251_4_) ? true : (this.func_72256_d(p_72251_1_, p_72251_2_ - 1, p_72251_3_, p_72251_4_) ? true : (this.func_72256_d(p_72251_1_, p_72251_2_, p_72251_3_ - 1, p_72251_4_) ? true : (this.func_72256_d(p_72251_1_, p_72251_2_, p_72251_3_ + 1, p_72251_4_) ? true : (this.func_72256_d(p_72251_1_, p_72251_2_, p_72251_3_, p_72251_4_ - 1) ? true : this.func_72256_d(p_72251_1_, p_72251_2_, p_72251_3_, p_72251_4_ + 1)))));
    }

    private int func_72254_n(World p_72254_1_, int p_72254_2_, int p_72254_3_, int p_72254_4_)
    {
        byte b0 = 0;

        if (!p_72254_1_.func_72799_c(p_72254_2_, p_72254_3_, p_72254_4_))
        {
            return 0;
        }
        else
        {
            int l = this.func_72252_e(p_72254_1_, p_72254_2_ + 1, p_72254_3_, p_72254_4_, b0);
            l = this.func_72252_e(p_72254_1_, p_72254_2_ - 1, p_72254_3_, p_72254_4_, l);
            l = this.func_72252_e(p_72254_1_, p_72254_2_, p_72254_3_ - 1, p_72254_4_, l);
            l = this.func_72252_e(p_72254_1_, p_72254_2_, p_72254_3_ + 1, p_72254_4_, l);
            l = this.func_72252_e(p_72254_1_, p_72254_2_, p_72254_3_, p_72254_4_ - 1, l);
            l = this.func_72252_e(p_72254_1_, p_72254_2_, p_72254_3_, p_72254_4_ + 1, l);
            return l;
        }
    }

    public boolean func_71935_l()
    {
        return false;
    }

    public boolean func_72256_d(IBlockAccess p_72256_1_, int p_72256_2_, int p_72256_3_, int p_72256_4_)
    {
        return this.field_72258_a[p_72256_1_.func_72798_a(p_72256_2_, p_72256_3_, p_72256_4_)] > 0;
    }

    public int func_72252_e(World p_72252_1_, int p_72252_2_, int p_72252_3_, int p_72252_4_, int p_72252_5_)
    {
        int i1 = this.field_72258_a[p_72252_1_.func_72798_a(p_72252_2_, p_72252_3_, p_72252_4_)];
        return i1 > p_72252_5_ ? i1 : p_72252_5_;
    }

    public boolean func_71930_b(World p_71930_1_, int p_71930_2_, int p_71930_3_, int p_71930_4_)
    {
        return p_71930_1_.func_72797_t(p_71930_2_, p_71930_3_ - 1, p_71930_4_) || this.func_72251_l(p_71930_1_, p_71930_2_, p_71930_3_, p_71930_4_);
    }

    public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_)
    {
        if (!p_71863_1_.func_72797_t(p_71863_2_, p_71863_3_ - 1, p_71863_4_) && !this.func_72251_l(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_))
        {
            p_71863_1_.func_94571_i(p_71863_2_, p_71863_3_, p_71863_4_);
        }
    }

    public void func_71861_g(World p_71861_1_, int p_71861_2_, int p_71861_3_, int p_71861_4_)
    {
        if (p_71861_1_.field_73011_w.field_76574_g > 0 || p_71861_1_.func_72798_a(p_71861_2_, p_71861_3_ - 1, p_71861_4_) != Block.field_72089_ap.field_71990_ca || !Block.field_72015_be.func_72246_i_(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_))
        {
            if (!p_71861_1_.func_72797_t(p_71861_2_, p_71861_3_ - 1, p_71861_4_) && !this.func_72251_l(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_))
            {
                p_71861_1_.func_94571_i(p_71861_2_, p_71861_3_, p_71861_4_);
            }
            else
            {
                p_71861_1_.func_72836_a(p_71861_2_, p_71861_3_, p_71861_4_, this.field_71990_ca, this.func_71859_p_(p_71861_1_) + p_71861_1_.field_73012_v.nextInt(10));
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public void func_71862_a(World p_71862_1_, int p_71862_2_, int p_71862_3_, int p_71862_4_, Random p_71862_5_)
    {
        if (p_71862_5_.nextInt(24) == 0)
        {
            p_71862_1_.func_72980_b((double)((float)p_71862_2_ + 0.5F), (double)((float)p_71862_3_ + 0.5F), (double)((float)p_71862_4_ + 0.5F), "fire.fire", 1.0F + p_71862_5_.nextFloat(), p_71862_5_.nextFloat() * 0.7F + 0.3F, false);
        }

        int l;
        float f;
        float f1;
        float f2;

        if (!p_71862_1_.func_72797_t(p_71862_2_, p_71862_3_ - 1, p_71862_4_) && !Block.field_72067_ar.func_72256_d(p_71862_1_, p_71862_2_, p_71862_3_ - 1, p_71862_4_))
        {
            if (Block.field_72067_ar.func_72256_d(p_71862_1_, p_71862_2_ - 1, p_71862_3_, p_71862_4_))
            {
                for (l = 0; l < 2; ++l)
                {
                    f = (float)p_71862_2_ + p_71862_5_.nextFloat() * 0.1F;
                    f1 = (float)p_71862_3_ + p_71862_5_.nextFloat();
                    f2 = (float)p_71862_4_ + p_71862_5_.nextFloat();
                    p_71862_1_.func_72869_a("largesmoke", (double)f, (double)f1, (double)f2, 0.0D, 0.0D, 0.0D);
                }
            }

            if (Block.field_72067_ar.func_72256_d(p_71862_1_, p_71862_2_ + 1, p_71862_3_, p_71862_4_))
            {
                for (l = 0; l < 2; ++l)
                {
                    f = (float)(p_71862_2_ + 1) - p_71862_5_.nextFloat() * 0.1F;
                    f1 = (float)p_71862_3_ + p_71862_5_.nextFloat();
                    f2 = (float)p_71862_4_ + p_71862_5_.nextFloat();
                    p_71862_1_.func_72869_a("largesmoke", (double)f, (double)f1, (double)f2, 0.0D, 0.0D, 0.0D);
                }
            }

            if (Block.field_72067_ar.func_72256_d(p_71862_1_, p_71862_2_, p_71862_3_, p_71862_4_ - 1))
            {
                for (l = 0; l < 2; ++l)
                {
                    f = (float)p_71862_2_ + p_71862_5_.nextFloat();
                    f1 = (float)p_71862_3_ + p_71862_5_.nextFloat();
                    f2 = (float)p_71862_4_ + p_71862_5_.nextFloat() * 0.1F;
                    p_71862_1_.func_72869_a("largesmoke", (double)f, (double)f1, (double)f2, 0.0D, 0.0D, 0.0D);
                }
            }

            if (Block.field_72067_ar.func_72256_d(p_71862_1_, p_71862_2_, p_71862_3_, p_71862_4_ + 1))
            {
                for (l = 0; l < 2; ++l)
                {
                    f = (float)p_71862_2_ + p_71862_5_.nextFloat();
                    f1 = (float)p_71862_3_ + p_71862_5_.nextFloat();
                    f2 = (float)(p_71862_4_ + 1) - p_71862_5_.nextFloat() * 0.1F;
                    p_71862_1_.func_72869_a("largesmoke", (double)f, (double)f1, (double)f2, 0.0D, 0.0D, 0.0D);
                }
            }

            if (Block.field_72067_ar.func_72256_d(p_71862_1_, p_71862_2_, p_71862_3_ + 1, p_71862_4_))
            {
                for (l = 0; l < 2; ++l)
                {
                    f = (float)p_71862_2_ + p_71862_5_.nextFloat();
                    f1 = (float)(p_71862_3_ + 1) - p_71862_5_.nextFloat() * 0.1F;
                    f2 = (float)p_71862_4_ + p_71862_5_.nextFloat();
                    p_71862_1_.func_72869_a("largesmoke", (double)f, (double)f1, (double)f2, 0.0D, 0.0D, 0.0D);
                }
            }
        }
        else
        {
            for (l = 0; l < 3; ++l)
            {
                f = (float)p_71862_2_ + p_71862_5_.nextFloat();
                f1 = (float)p_71862_3_ + p_71862_5_.nextFloat() * 0.5F + 0.5F;
                f2 = (float)p_71862_4_ + p_71862_5_.nextFloat();
                p_71862_1_.func_72869_a("largesmoke", (double)f, (double)f1, (double)f2, 0.0D, 0.0D, 0.0D);
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public void func_94332_a(IconRegister p_94332_1_)
    {
        this.field_94439_c = new Icon[] {p_94332_1_.func_94245_a(this.func_111023_E() + "_layer_0"), p_94332_1_.func_94245_a(this.func_111023_E() + "_layer_1")};
    }

    @SideOnly(Side.CLIENT)
    public Icon func_94438_c(int p_94438_1_)
    {
        return this.field_94439_c[p_94438_1_];
    }

    @SideOnly(Side.CLIENT)
    public Icon func_71858_a(int p_71858_1_, int p_71858_2_)
    {
        return this.field_94439_c[0];
    }
}