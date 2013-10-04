package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockStem extends BlockFlower
{
    private final Block field_72267_a;
    @SideOnly(Side.CLIENT)
    private Icon field_94369_b;

    protected BlockStem(int p_i2260_1_, Block p_i2260_2_)
    {
        super(p_i2260_1_);
        this.field_72267_a = p_i2260_2_;
        this.func_71907_b(true);
        float f = 0.125F;
        this.func_71905_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
        this.func_71849_a((CreativeTabs)null);
    }

    protected boolean func_72263_d_(int p_72263_1_)
    {
        return p_72263_1_ == Block.field_72050_aA.field_71990_ca;
    }

    public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_)
    {
        super.func_71847_b(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_, p_71847_5_);

        if (p_71847_1_.func_72957_l(p_71847_2_, p_71847_3_ + 1, p_71847_4_) >= 9)
        {
            float f = this.func_72266_n(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_);

            if (p_71847_5_.nextInt((int)(25.0F / f) + 1) == 0)
            {
                int l = p_71847_1_.func_72805_g(p_71847_2_, p_71847_3_, p_71847_4_);

                if (l < 7)
                {
                    ++l;
                    p_71847_1_.func_72921_c(p_71847_2_, p_71847_3_, p_71847_4_, l, 2);
                }
                else
                {
                    if (p_71847_1_.func_72798_a(p_71847_2_ - 1, p_71847_3_, p_71847_4_) == this.field_72267_a.field_71990_ca)
                    {
                        return;
                    }

                    if (p_71847_1_.func_72798_a(p_71847_2_ + 1, p_71847_3_, p_71847_4_) == this.field_72267_a.field_71990_ca)
                    {
                        return;
                    }

                    if (p_71847_1_.func_72798_a(p_71847_2_, p_71847_3_, p_71847_4_ - 1) == this.field_72267_a.field_71990_ca)
                    {
                        return;
                    }

                    if (p_71847_1_.func_72798_a(p_71847_2_, p_71847_3_, p_71847_4_ + 1) == this.field_72267_a.field_71990_ca)
                    {
                        return;
                    }

                    int i1 = p_71847_5_.nextInt(4);
                    int j1 = p_71847_2_;
                    int k1 = p_71847_4_;

                    if (i1 == 0)
                    {
                        j1 = p_71847_2_ - 1;
                    }

                    if (i1 == 1)
                    {
                        ++j1;
                    }

                    if (i1 == 2)
                    {
                        k1 = p_71847_4_ - 1;
                    }

                    if (i1 == 3)
                    {
                        ++k1;
                    }

                    int l1 = p_71847_1_.func_72798_a(j1, p_71847_3_ - 1, k1);

                    if (p_71847_1_.func_72798_a(j1, p_71847_3_, k1) == 0 && (l1 == Block.field_72050_aA.field_71990_ca || l1 == Block.field_71979_v.field_71990_ca || l1 == Block.field_71980_u.field_71990_ca))
                    {
                        p_71847_1_.func_94575_c(j1, p_71847_3_, k1, this.field_72267_a.field_71990_ca);
                    }
                }
            }
        }
    }

    public void func_72264_l(World p_72264_1_, int p_72264_2_, int p_72264_3_, int p_72264_4_)
    {
        int l = p_72264_1_.func_72805_g(p_72264_2_, p_72264_3_, p_72264_4_) + MathHelper.func_76136_a(p_72264_1_.field_73012_v, 2, 5);

        if (l > 7)
        {
            l = 7;
        }

        p_72264_1_.func_72921_c(p_72264_2_, p_72264_3_, p_72264_4_, l, 2);
    }

    private float func_72266_n(World p_72266_1_, int p_72266_2_, int p_72266_3_, int p_72266_4_)
    {
        float f = 1.0F;
        int l = p_72266_1_.func_72798_a(p_72266_2_, p_72266_3_, p_72266_4_ - 1);
        int i1 = p_72266_1_.func_72798_a(p_72266_2_, p_72266_3_, p_72266_4_ + 1);
        int j1 = p_72266_1_.func_72798_a(p_72266_2_ - 1, p_72266_3_, p_72266_4_);
        int k1 = p_72266_1_.func_72798_a(p_72266_2_ + 1, p_72266_3_, p_72266_4_);
        int l1 = p_72266_1_.func_72798_a(p_72266_2_ - 1, p_72266_3_, p_72266_4_ - 1);
        int i2 = p_72266_1_.func_72798_a(p_72266_2_ + 1, p_72266_3_, p_72266_4_ - 1);
        int j2 = p_72266_1_.func_72798_a(p_72266_2_ + 1, p_72266_3_, p_72266_4_ + 1);
        int k2 = p_72266_1_.func_72798_a(p_72266_2_ - 1, p_72266_3_, p_72266_4_ + 1);
        boolean flag = j1 == this.field_71990_ca || k1 == this.field_71990_ca;
        boolean flag1 = l == this.field_71990_ca || i1 == this.field_71990_ca;
        boolean flag2 = l1 == this.field_71990_ca || i2 == this.field_71990_ca || j2 == this.field_71990_ca || k2 == this.field_71990_ca;

        for (int l2 = p_72266_2_ - 1; l2 <= p_72266_2_ + 1; ++l2)
        {
            for (int i3 = p_72266_4_ - 1; i3 <= p_72266_4_ + 1; ++i3)
            {
                int j3 = p_72266_1_.func_72798_a(l2, p_72266_3_ - 1, i3);
                float f1 = 0.0F;

                if (j3 == Block.field_72050_aA.field_71990_ca)
                {
                    f1 = 1.0F;

                    if (p_72266_1_.func_72805_g(l2, p_72266_3_ - 1, i3) > 0)
                    {
                        f1 = 3.0F;
                    }
                }

                if (l2 != p_72266_2_ || i3 != p_72266_4_)
                {
                    f1 /= 4.0F;
                }

                f += f1;
            }
        }

        if (flag2 || flag && flag1)
        {
            f /= 2.0F;
        }

        return f;
    }

    @SideOnly(Side.CLIENT)
    public int func_71889_f_(int p_71889_1_)
    {
        int j = p_71889_1_ * 32;
        int k = 255 - p_71889_1_ * 8;
        int l = p_71889_1_ * 4;
        return j << 16 | k << 8 | l;
    }

    @SideOnly(Side.CLIENT)
    public int func_71920_b(IBlockAccess p_71920_1_, int p_71920_2_, int p_71920_3_, int p_71920_4_)
    {
        return this.func_71889_f_(p_71920_1_.func_72805_g(p_71920_2_, p_71920_3_, p_71920_4_));
    }

    public void func_71919_f()
    {
        float f = 0.125F;
        this.func_71905_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
    }

    public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_)
    {
        this.field_72022_cl = (double)((float)(p_71902_1_.func_72805_g(p_71902_2_, p_71902_3_, p_71902_4_) * 2 + 2) / 16.0F);
        float f = 0.125F;
        this.func_71905_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, (float)this.field_72022_cl, 0.5F + f);
    }

    public int func_71857_b()
    {
        return 19;
    }

    @SideOnly(Side.CLIENT)
    public int func_72265_d(IBlockAccess p_72265_1_, int p_72265_2_, int p_72265_3_, int p_72265_4_)
    {
        int l = p_72265_1_.func_72805_g(p_72265_2_, p_72265_3_, p_72265_4_);
        return l < 7 ? -1 : (p_72265_1_.func_72798_a(p_72265_2_ - 1, p_72265_3_, p_72265_4_) == this.field_72267_a.field_71990_ca ? 0 : (p_72265_1_.func_72798_a(p_72265_2_ + 1, p_72265_3_, p_72265_4_) == this.field_72267_a.field_71990_ca ? 1 : (p_72265_1_.func_72798_a(p_72265_2_, p_72265_3_, p_72265_4_ - 1) == this.field_72267_a.field_71990_ca ? 2 : (p_72265_1_.func_72798_a(p_72265_2_, p_72265_3_, p_72265_4_ + 1) == this.field_72267_a.field_71990_ca ? 3 : -1))));
    }

    public void func_71914_a(World p_71914_1_, int p_71914_2_, int p_71914_3_, int p_71914_4_, int p_71914_5_, float p_71914_6_, int p_71914_7_)
    {
        super.func_71914_a(p_71914_1_, p_71914_2_, p_71914_3_, p_71914_4_, p_71914_5_, p_71914_6_, p_71914_7_);

        if (!p_71914_1_.field_72995_K)
        {
            Item item = null;

            if (this.field_72267_a == Block.field_72061_ba)
            {
                item = Item.field_77739_bg;
            }

            if (this.field_72267_a == Block.field_71997_br)
            {
                item = Item.field_77740_bh;
            }

            for (int j1 = 0; j1 < 3; ++j1)
            {
                if (p_71914_1_.field_73012_v.nextInt(15) <= p_71914_5_)
                {
                    this.func_71929_a(p_71914_1_, p_71914_2_, p_71914_3_, p_71914_4_, new ItemStack(item));
                }
            }
        }
    }

    public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_)
    {
        return -1;
    }

    public int func_71925_a(Random p_71925_1_)
    {
        return 1;
    }

    @SideOnly(Side.CLIENT)
    public int func_71922_a(World p_71922_1_, int p_71922_2_, int p_71922_3_, int p_71922_4_)
    {
        return this.field_72267_a == Block.field_72061_ba ? Item.field_77739_bg.field_77779_bT : (this.field_72267_a == Block.field_71997_br ? Item.field_77740_bh.field_77779_bT : 0);
    }

    @SideOnly(Side.CLIENT)
    public void func_94332_a(IconRegister p_94332_1_)
    {
        this.field_94336_cN = p_94332_1_.func_94245_a(this.func_111023_E() + "_disconnected");
        this.field_94369_b = p_94332_1_.func_94245_a(this.func_111023_E() + "_connected");
    }

    @SideOnly(Side.CLIENT)
    public Icon func_94368_p()
    {
        return this.field_94369_b;
    }
}