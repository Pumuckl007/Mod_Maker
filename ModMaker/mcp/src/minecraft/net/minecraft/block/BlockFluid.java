package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BlockFluid extends Block
{
    @SideOnly(Side.CLIENT)
    protected Icon[] field_94425_a;

    protected BlockFluid(int p_i2220_1_, Material p_i2220_2_)
    {
        super(p_i2220_1_, p_i2220_2_);
        float f = 0.0F;
        float f1 = 0.0F;
        this.func_71905_a(0.0F + f1, 0.0F + f, 0.0F + f1, 1.0F + f1, 1.0F + f, 1.0F + f1);
        this.func_71907_b(true);
    }

    public boolean func_71918_c(IBlockAccess p_71918_1_, int p_71918_2_, int p_71918_3_, int p_71918_4_)
    {
        return this.field_72018_cp != Material.field_76256_h;
    }

    @SideOnly(Side.CLIENT)
    public int func_71933_m()
    {
        return 16777215;
    }

    @SideOnly(Side.CLIENT)
    public int func_71920_b(IBlockAccess p_71920_1_, int p_71920_2_, int p_71920_3_, int p_71920_4_)
    {
        if (this.field_72018_cp != Material.field_76244_g)
        {
            return 16777215;
        }
        else
        {
            int l = 0;
            int i1 = 0;
            int j1 = 0;

            for (int k1 = -1; k1 <= 1; ++k1)
            {
                for (int l1 = -1; l1 <= 1; ++l1)
                {
                    int i2 = p_71920_1_.func_72807_a(p_71920_2_ + l1, p_71920_4_ + k1).field_76759_H;
                    l += (i2 & 16711680) >> 16;
                    i1 += (i2 & 65280) >> 8;
                    j1 += i2 & 255;
                }
            }

            return (l / 9 & 255) << 16 | (i1 / 9 & 255) << 8 | j1 / 9 & 255;
        }
    }

    public static float func_72199_d(int p_72199_0_)
    {
        if (p_72199_0_ >= 8)
        {
            p_72199_0_ = 0;
        }

        return (float)(p_72199_0_ + 1) / 9.0F;
    }

    @SideOnly(Side.CLIENT)
    public Icon func_71858_a(int p_71858_1_, int p_71858_2_)
    {
        return p_71858_1_ != 0 && p_71858_1_ != 1 ? this.field_94425_a[1] : this.field_94425_a[0];
    }

    protected int func_72198_f_(World p_72198_1_, int p_72198_2_, int p_72198_3_, int p_72198_4_)
    {
        return p_72198_1_.func_72803_f(p_72198_2_, p_72198_3_, p_72198_4_) == this.field_72018_cp ? p_72198_1_.func_72805_g(p_72198_2_, p_72198_3_, p_72198_4_) : -1;
    }

    protected int func_72203_d(IBlockAccess p_72203_1_, int p_72203_2_, int p_72203_3_, int p_72203_4_)
    {
        if (p_72203_1_.func_72803_f(p_72203_2_, p_72203_3_, p_72203_4_) != this.field_72018_cp)
        {
            return -1;
        }
        else
        {
            int l = p_72203_1_.func_72805_g(p_72203_2_, p_72203_3_, p_72203_4_);

            if (l >= 8)
            {
                l = 0;
            }

            return l;
        }
    }

    public boolean func_71886_c()
    {
        return false;
    }

    public boolean func_71926_d()
    {
        return false;
    }

    public boolean func_71913_a(int p_71913_1_, boolean p_71913_2_)
    {
        return p_71913_2_ && p_71913_1_ == 0;
    }

    public boolean func_71924_d(IBlockAccess p_71924_1_, int p_71924_2_, int p_71924_3_, int p_71924_4_, int p_71924_5_)
    {
        Material material = p_71924_1_.func_72803_f(p_71924_2_, p_71924_3_, p_71924_4_);
        return material == this.field_72018_cp ? false : (p_71924_5_ == 1 ? true : (material == Material.field_76260_u ? false : super.func_71924_d(p_71924_1_, p_71924_2_, p_71924_3_, p_71924_4_, p_71924_5_)));
    }

    @SideOnly(Side.CLIENT)
    public boolean func_71877_c(IBlockAccess p_71877_1_, int p_71877_2_, int p_71877_3_, int p_71877_4_, int p_71877_5_)
    {
        Material material = p_71877_1_.func_72803_f(p_71877_2_, p_71877_3_, p_71877_4_);
        return material == this.field_72018_cp ? false : (p_71877_5_ == 1 ? true : (material == Material.field_76260_u ? false : super.func_71877_c(p_71877_1_, p_71877_2_, p_71877_3_, p_71877_4_, p_71877_5_)));
    }

    public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int p_71872_4_)
    {
        return null;
    }

    public int func_71857_b()
    {
        return 4;
    }

    public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_)
    {
        return 0;
    }

    public int func_71925_a(Random p_71925_1_)
    {
        return 0;
    }

    private Vec3 func_72202_i(IBlockAccess p_72202_1_, int p_72202_2_, int p_72202_3_, int p_72202_4_)
    {
        Vec3 vec3 = p_72202_1_.func_82732_R().func_72345_a(0.0D, 0.0D, 0.0D);
        int l = this.func_72203_d(p_72202_1_, p_72202_2_, p_72202_3_, p_72202_4_);

        for (int i1 = 0; i1 < 4; ++i1)
        {
            int j1 = p_72202_2_;
            int k1 = p_72202_4_;

            if (i1 == 0)
            {
                j1 = p_72202_2_ - 1;
            }

            if (i1 == 1)
            {
                k1 = p_72202_4_ - 1;
            }

            if (i1 == 2)
            {
                ++j1;
            }

            if (i1 == 3)
            {
                ++k1;
            }

            int l1 = this.func_72203_d(p_72202_1_, j1, p_72202_3_, k1);
            int i2;

            if (l1 < 0)
            {
                if (!p_72202_1_.func_72803_f(j1, p_72202_3_, k1).func_76230_c())
                {
                    l1 = this.func_72203_d(p_72202_1_, j1, p_72202_3_ - 1, k1);

                    if (l1 >= 0)
                    {
                        i2 = l1 - (l - 8);
                        vec3 = vec3.func_72441_c((double)((j1 - p_72202_2_) * i2), (double)((p_72202_3_ - p_72202_3_) * i2), (double)((k1 - p_72202_4_) * i2));
                    }
                }
            }
            else if (l1 >= 0)
            {
                i2 = l1 - l;
                vec3 = vec3.func_72441_c((double)((j1 - p_72202_2_) * i2), (double)((p_72202_3_ - p_72202_3_) * i2), (double)((k1 - p_72202_4_) * i2));
            }
        }

        if (p_72202_1_.func_72805_g(p_72202_2_, p_72202_3_, p_72202_4_) >= 8)
        {
            boolean flag = false;

            if (flag || this.func_71924_d(p_72202_1_, p_72202_2_, p_72202_3_, p_72202_4_ - 1, 2))
            {
                flag = true;
            }

            if (flag || this.func_71924_d(p_72202_1_, p_72202_2_, p_72202_3_, p_72202_4_ + 1, 3))
            {
                flag = true;
            }

            if (flag || this.func_71924_d(p_72202_1_, p_72202_2_ - 1, p_72202_3_, p_72202_4_, 4))
            {
                flag = true;
            }

            if (flag || this.func_71924_d(p_72202_1_, p_72202_2_ + 1, p_72202_3_, p_72202_4_, 5))
            {
                flag = true;
            }

            if (flag || this.func_71924_d(p_72202_1_, p_72202_2_, p_72202_3_ + 1, p_72202_4_ - 1, 2))
            {
                flag = true;
            }

            if (flag || this.func_71924_d(p_72202_1_, p_72202_2_, p_72202_3_ + 1, p_72202_4_ + 1, 3))
            {
                flag = true;
            }

            if (flag || this.func_71924_d(p_72202_1_, p_72202_2_ - 1, p_72202_3_ + 1, p_72202_4_, 4))
            {
                flag = true;
            }

            if (flag || this.func_71924_d(p_72202_1_, p_72202_2_ + 1, p_72202_3_ + 1, p_72202_4_, 5))
            {
                flag = true;
            }

            if (flag)
            {
                vec3 = vec3.func_72432_b().func_72441_c(0.0D, -6.0D, 0.0D);
            }
        }

        vec3 = vec3.func_72432_b();
        return vec3;
    }

    public void func_71901_a(World p_71901_1_, int p_71901_2_, int p_71901_3_, int p_71901_4_, Entity p_71901_5_, Vec3 p_71901_6_)
    {
        Vec3 vec31 = this.func_72202_i(p_71901_1_, p_71901_2_, p_71901_3_, p_71901_4_);
        p_71901_6_.field_72450_a += vec31.field_72450_a;
        p_71901_6_.field_72448_b += vec31.field_72448_b;
        p_71901_6_.field_72449_c += vec31.field_72449_c;
    }

    public int func_71859_p_(World p_71859_1_)
    {
        return this.field_72018_cp == Material.field_76244_g ? 5 : (this.field_72018_cp == Material.field_76256_h ? (p_71859_1_.field_73011_w.field_76576_e ? 10 : 30) : 0);
    }

    public void func_71861_g(World p_71861_1_, int p_71861_2_, int p_71861_3_, int p_71861_4_)
    {
        this.func_72200_l(p_71861_1_, p_71861_2_, p_71861_3_, p_71861_4_);
    }

    public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_)
    {
        this.func_72200_l(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_);
    }

    @SideOnly(Side.CLIENT)
    public int func_71874_e(IBlockAccess p_71874_1_, int p_71874_2_, int p_71874_3_, int p_71874_4_)
    {
        int l = p_71874_1_.func_72802_i(p_71874_2_, p_71874_3_, p_71874_4_, 0);
        int i1 = p_71874_1_.func_72802_i(p_71874_2_, p_71874_3_ + 1, p_71874_4_, 0);
        int j1 = l & 255;
        int k1 = i1 & 255;
        int l1 = l >> 16 & 255;
        int i2 = i1 >> 16 & 255;
        return (j1 > k1 ? j1 : k1) | (l1 > i2 ? l1 : i2) << 16;
    }

    @SideOnly(Side.CLIENT)
    public float func_71870_f(IBlockAccess p_71870_1_, int p_71870_2_, int p_71870_3_, int p_71870_4_)
    {
        float f = p_71870_1_.func_72801_o(p_71870_2_, p_71870_3_, p_71870_4_);
        float f1 = p_71870_1_.func_72801_o(p_71870_2_, p_71870_3_ + 1, p_71870_4_);
        return f > f1 ? f : f1;
    }

    @SideOnly(Side.CLIENT)
    public int func_71856_s_()
    {
        return this.field_72018_cp == Material.field_76244_g ? 1 : 0;
    }

    @SideOnly(Side.CLIENT)
    public void func_71862_a(World p_71862_1_, int p_71862_2_, int p_71862_3_, int p_71862_4_, Random p_71862_5_)
    {
        int l;

        if (this.field_72018_cp == Material.field_76244_g)
        {
            if (p_71862_5_.nextInt(10) == 0)
            {
                l = p_71862_1_.func_72805_g(p_71862_2_, p_71862_3_, p_71862_4_);

                if (l <= 0 || l >= 8)
                {
                    p_71862_1_.func_72869_a("suspended", (double)((float)p_71862_2_ + p_71862_5_.nextFloat()), (double)((float)p_71862_3_ + p_71862_5_.nextFloat()), (double)((float)p_71862_4_ + p_71862_5_.nextFloat()), 0.0D, 0.0D, 0.0D);
                }
            }

            for (l = 0; l < 0; ++l)
            {
                int i1 = p_71862_5_.nextInt(4);
                int j1 = p_71862_2_;
                int k1 = p_71862_4_;

                if (i1 == 0)
                {
                    j1 = p_71862_2_ - 1;
                }

                if (i1 == 1)
                {
                    ++j1;
                }

                if (i1 == 2)
                {
                    k1 = p_71862_4_ - 1;
                }

                if (i1 == 3)
                {
                    ++k1;
                }

                if (p_71862_1_.func_72803_f(j1, p_71862_3_, k1) == Material.field_76249_a && (p_71862_1_.func_72803_f(j1, p_71862_3_ - 1, k1).func_76230_c() || p_71862_1_.func_72803_f(j1, p_71862_3_ - 1, k1).func_76224_d()))
                {
                    float f = 0.0625F;
                    double d0 = (double)((float)p_71862_2_ + p_71862_5_.nextFloat());
                    double d1 = (double)((float)p_71862_3_ + p_71862_5_.nextFloat());
                    double d2 = (double)((float)p_71862_4_ + p_71862_5_.nextFloat());

                    if (i1 == 0)
                    {
                        d0 = (double)((float)p_71862_2_ - f);
                    }

                    if (i1 == 1)
                    {
                        d0 = (double)((float)(p_71862_2_ + 1) + f);
                    }

                    if (i1 == 2)
                    {
                        d2 = (double)((float)p_71862_4_ - f);
                    }

                    if (i1 == 3)
                    {
                        d2 = (double)((float)(p_71862_4_ + 1) + f);
                    }

                    double d3 = 0.0D;
                    double d4 = 0.0D;

                    if (i1 == 0)
                    {
                        d3 = (double)(-f);
                    }

                    if (i1 == 1)
                    {
                        d3 = (double)f;
                    }

                    if (i1 == 2)
                    {
                        d4 = (double)(-f);
                    }

                    if (i1 == 3)
                    {
                        d4 = (double)f;
                    }

                    p_71862_1_.func_72869_a("splash", d0, d1, d2, d3, 0.0D, d4);
                }
            }
        }

        if (this.field_72018_cp == Material.field_76244_g && p_71862_5_.nextInt(64) == 0)
        {
            l = p_71862_1_.func_72805_g(p_71862_2_, p_71862_3_, p_71862_4_);

            if (l > 0 && l < 8)
            {
                p_71862_1_.func_72980_b((double)((float)p_71862_2_ + 0.5F), (double)((float)p_71862_3_ + 0.5F), (double)((float)p_71862_4_ + 0.5F), "liquid.water", p_71862_5_.nextFloat() * 0.25F + 0.75F, p_71862_5_.nextFloat() * 1.0F + 0.5F, false);
            }
        }

        double d5;
        double d6;
        double d7;

        if (this.field_72018_cp == Material.field_76256_h && p_71862_1_.func_72803_f(p_71862_2_, p_71862_3_ + 1, p_71862_4_) == Material.field_76249_a && !p_71862_1_.func_72804_r(p_71862_2_, p_71862_3_ + 1, p_71862_4_))
        {
            if (p_71862_5_.nextInt(100) == 0)
            {
                d5 = (double)((float)p_71862_2_ + p_71862_5_.nextFloat());
                d7 = (double)p_71862_3_ + this.field_72022_cl;
                d6 = (double)((float)p_71862_4_ + p_71862_5_.nextFloat());
                p_71862_1_.func_72869_a("lava", d5, d7, d6, 0.0D, 0.0D, 0.0D);
                p_71862_1_.func_72980_b(d5, d7, d6, "liquid.lavapop", 0.2F + p_71862_5_.nextFloat() * 0.2F, 0.9F + p_71862_5_.nextFloat() * 0.15F, false);
            }

            if (p_71862_5_.nextInt(200) == 0)
            {
                p_71862_1_.func_72980_b((double)p_71862_2_, (double)p_71862_3_, (double)p_71862_4_, "liquid.lava", 0.2F + p_71862_5_.nextFloat() * 0.2F, 0.9F + p_71862_5_.nextFloat() * 0.15F, false);
            }
        }

        if (p_71862_5_.nextInt(10) == 0 && p_71862_1_.func_72797_t(p_71862_2_, p_71862_3_ - 1, p_71862_4_) && !p_71862_1_.func_72803_f(p_71862_2_, p_71862_3_ - 2, p_71862_4_).func_76230_c())
        {
            d5 = (double)((float)p_71862_2_ + p_71862_5_.nextFloat());
            d7 = (double)p_71862_3_ - 1.05D;
            d6 = (double)((float)p_71862_4_ + p_71862_5_.nextFloat());

            if (this.field_72018_cp == Material.field_76244_g)
            {
                p_71862_1_.func_72869_a("dripWater", d5, d7, d6, 0.0D, 0.0D, 0.0D);
            }
            else
            {
                p_71862_1_.func_72869_a("dripLava", d5, d7, d6, 0.0D, 0.0D, 0.0D);
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public static double func_72204_a(IBlockAccess p_72204_0_, int p_72204_1_, int p_72204_2_, int p_72204_3_, Material p_72204_4_)
    {
        Vec3 vec3 = null;

        if (p_72204_4_ == Material.field_76244_g)
        {
            vec3 = Block.field_71942_A.func_72202_i(p_72204_0_, p_72204_1_, p_72204_2_, p_72204_3_);
        }

        if (p_72204_4_ == Material.field_76256_h)
        {
            vec3 = Block.field_71944_C.func_72202_i(p_72204_0_, p_72204_1_, p_72204_2_, p_72204_3_);
        }

        return vec3.field_72450_a == 0.0D && vec3.field_72449_c == 0.0D ? -1000.0D : Math.atan2(vec3.field_72449_c, vec3.field_72450_a) - (Math.PI / 2D);
    }

    private void func_72200_l(World p_72200_1_, int p_72200_2_, int p_72200_3_, int p_72200_4_)
    {
        if (p_72200_1_.func_72798_a(p_72200_2_, p_72200_3_, p_72200_4_) == this.field_71990_ca)
        {
            if (this.field_72018_cp == Material.field_76256_h)
            {
                boolean flag = false;

                if (flag || p_72200_1_.func_72803_f(p_72200_2_, p_72200_3_, p_72200_4_ - 1) == Material.field_76244_g)
                {
                    flag = true;
                }

                if (flag || p_72200_1_.func_72803_f(p_72200_2_, p_72200_3_, p_72200_4_ + 1) == Material.field_76244_g)
                {
                    flag = true;
                }

                if (flag || p_72200_1_.func_72803_f(p_72200_2_ - 1, p_72200_3_, p_72200_4_) == Material.field_76244_g)
                {
                    flag = true;
                }

                if (flag || p_72200_1_.func_72803_f(p_72200_2_ + 1, p_72200_3_, p_72200_4_) == Material.field_76244_g)
                {
                    flag = true;
                }

                if (flag || p_72200_1_.func_72803_f(p_72200_2_, p_72200_3_ + 1, p_72200_4_) == Material.field_76244_g)
                {
                    flag = true;
                }

                if (flag)
                {
                    int l = p_72200_1_.func_72805_g(p_72200_2_, p_72200_3_, p_72200_4_);

                    if (l == 0)
                    {
                        p_72200_1_.func_94575_c(p_72200_2_, p_72200_3_, p_72200_4_, Block.field_72089_ap.field_71990_ca);
                    }
                    else if (l <= 4)
                    {
                        p_72200_1_.func_94575_c(p_72200_2_, p_72200_3_, p_72200_4_, Block.field_71978_w.field_71990_ca);
                    }

                    this.func_72201_j(p_72200_1_, p_72200_2_, p_72200_3_, p_72200_4_);
                }
            }
        }
    }

    protected void func_72201_j(World p_72201_1_, int p_72201_2_, int p_72201_3_, int p_72201_4_)
    {
        p_72201_1_.func_72908_a((double)((float)p_72201_2_ + 0.5F), (double)((float)p_72201_3_ + 0.5F), (double)((float)p_72201_4_ + 0.5F), "random.fizz", 0.5F, 2.6F + (p_72201_1_.field_73012_v.nextFloat() - p_72201_1_.field_73012_v.nextFloat()) * 0.8F);

        for (int l = 0; l < 8; ++l)
        {
            p_72201_1_.func_72869_a("largesmoke", (double)p_72201_2_ + Math.random(), (double)p_72201_3_ + 1.2D, (double)p_72201_4_ + Math.random(), 0.0D, 0.0D, 0.0D);
        }
    }

    @SideOnly(Side.CLIENT)
    public void func_94332_a(IconRegister p_94332_1_)
    {
        if (this.field_72018_cp == Material.field_76256_h)
        {
            this.field_94425_a = new Icon[] {p_94332_1_.func_94245_a("lava_still"), p_94332_1_.func_94245_a("lava_flow")};
        }
        else
        {
            this.field_94425_a = new Icon[] {p_94332_1_.func_94245_a("water_still"), p_94332_1_.func_94245_a("water_flow")};
        }
    }

    @SideOnly(Side.CLIENT)
    public static Icon func_94424_b(String p_94424_0_)
    {
        return p_94424_0_ == "water_still" ? Block.field_71942_A.field_94425_a[0] : (p_94424_0_ == "water_flow" ? Block.field_71942_A.field_94425_a[1] : (p_94424_0_ == "lava_still" ? Block.field_71944_C.field_94425_a[0] : (p_94424_0_ == "lava_flow" ? Block.field_71944_C.field_94425_a[1] : null)));
    }
}
