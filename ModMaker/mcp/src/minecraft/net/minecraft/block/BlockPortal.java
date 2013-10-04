package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPortal extends BlockBreakable
{
    public BlockPortal(int p_i2236_1_)
    {
        super(p_i2236_1_, "portal", Material.field_76237_B, false);
        this.func_71907_b(true);
    }

    public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_)
    {
        super.func_71847_b(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_, p_71847_5_);

        if (p_71847_1_.field_73011_w.func_76569_d() && p_71847_5_.nextInt(2000) < p_71847_1_.field_73013_u)
        {
            int l;

            for (l = p_71847_3_; !p_71847_1_.func_72797_t(p_71847_2_, l, p_71847_4_) && l > 0; --l)
            {
                ;
            }

            if (l > 0 && !p_71847_1_.func_72809_s(p_71847_2_, l + 1, p_71847_4_))
            {
                Entity entity = ItemMonsterPlacer.func_77840_a(p_71847_1_, 57, (double)p_71847_2_ + 0.5D, (double)l + 1.1D, (double)p_71847_4_ + 0.5D);

                if (entity != null)
                {
                    entity.field_71088_bW = entity.func_82147_ab();
                }
            }
        }
    }

    public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int p_71872_4_)
    {
        return null;
    }

    public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_)
    {
        float f;
        float f1;

        if (p_71902_1_.func_72798_a(p_71902_2_ - 1, p_71902_3_, p_71902_4_) != this.field_71990_ca && p_71902_1_.func_72798_a(p_71902_2_ + 1, p_71902_3_, p_71902_4_) != this.field_71990_ca)
        {
            f = 0.125F;
            f1 = 0.5F;
            this.func_71905_a(0.5F - f, 0.0F, 0.5F - f1, 0.5F + f, 1.0F, 0.5F + f1);
        }
        else
        {
            f = 0.5F;
            f1 = 0.125F;
            this.func_71905_a(0.5F - f, 0.0F, 0.5F - f1, 0.5F + f, 1.0F, 0.5F + f1);
        }
    }

    public boolean func_71926_d()
    {
        return false;
    }

    public boolean func_71886_c()
    {
        return false;
    }

    public boolean func_72246_i_(World p_72246_1_, int p_72246_2_, int p_72246_3_, int p_72246_4_)
    {
        byte b0 = 0;
        byte b1 = 0;

        if (p_72246_1_.func_72798_a(p_72246_2_ - 1, p_72246_3_, p_72246_4_) == Block.field_72089_ap.field_71990_ca || p_72246_1_.func_72798_a(p_72246_2_ + 1, p_72246_3_, p_72246_4_) == Block.field_72089_ap.field_71990_ca)
        {
            b0 = 1;
        }

        if (p_72246_1_.func_72798_a(p_72246_2_, p_72246_3_, p_72246_4_ - 1) == Block.field_72089_ap.field_71990_ca || p_72246_1_.func_72798_a(p_72246_2_, p_72246_3_, p_72246_4_ + 1) == Block.field_72089_ap.field_71990_ca)
        {
            b1 = 1;
        }

        if (b0 == b1)
        {
            return false;
        }
        else
        {
            if (p_72246_1_.func_72798_a(p_72246_2_ - b0, p_72246_3_, p_72246_4_ - b1) == 0)
            {
                p_72246_2_ -= b0;
                p_72246_4_ -= b1;
            }

            int l;
            int i1;

            for (l = -1; l <= 2; ++l)
            {
                for (i1 = -1; i1 <= 3; ++i1)
                {
                    boolean flag = l == -1 || l == 2 || i1 == -1 || i1 == 3;

                    if (l != -1 && l != 2 || i1 != -1 && i1 != 3)
                    {
                        int j1 = p_72246_1_.func_72798_a(p_72246_2_ + b0 * l, p_72246_3_ + i1, p_72246_4_ + b1 * l);

                        if (flag)
                        {
                            if (j1 != Block.field_72089_ap.field_71990_ca)
                            {
                                return false;
                            }
                        }
                        else if (j1 != 0 && j1 != Block.field_72067_ar.field_71990_ca)
                        {
                            return false;
                        }
                    }
                }
            }

            for (l = 0; l < 2; ++l)
            {
                for (i1 = 0; i1 < 3; ++i1)
                {
                    p_72246_1_.func_72832_d(p_72246_2_ + b0 * l, p_72246_3_ + i1, p_72246_4_ + b1 * l, Block.field_72015_be.field_71990_ca, 0, 2);
                }
            }

            return true;
        }
    }

    public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_)
    {
        byte b0 = 0;
        byte b1 = 1;

        if (p_71863_1_.func_72798_a(p_71863_2_ - 1, p_71863_3_, p_71863_4_) == this.field_71990_ca || p_71863_1_.func_72798_a(p_71863_2_ + 1, p_71863_3_, p_71863_4_) == this.field_71990_ca)
        {
            b0 = 1;
            b1 = 0;
        }

        int i1;

        for (i1 = p_71863_3_; p_71863_1_.func_72798_a(p_71863_2_, i1 - 1, p_71863_4_) == this.field_71990_ca; --i1)
        {
            ;
        }

        if (p_71863_1_.func_72798_a(p_71863_2_, i1 - 1, p_71863_4_) != Block.field_72089_ap.field_71990_ca)
        {
            p_71863_1_.func_94571_i(p_71863_2_, p_71863_3_, p_71863_4_);
        }
        else
        {
            int j1;

            for (j1 = 1; j1 < 4 && p_71863_1_.func_72798_a(p_71863_2_, i1 + j1, p_71863_4_) == this.field_71990_ca; ++j1)
            {
                ;
            }

            if (j1 == 3 && p_71863_1_.func_72798_a(p_71863_2_, i1 + j1, p_71863_4_) == Block.field_72089_ap.field_71990_ca)
            {
                boolean flag = p_71863_1_.func_72798_a(p_71863_2_ - 1, p_71863_3_, p_71863_4_) == this.field_71990_ca || p_71863_1_.func_72798_a(p_71863_2_ + 1, p_71863_3_, p_71863_4_) == this.field_71990_ca;
                boolean flag1 = p_71863_1_.func_72798_a(p_71863_2_, p_71863_3_, p_71863_4_ - 1) == this.field_71990_ca || p_71863_1_.func_72798_a(p_71863_2_, p_71863_3_, p_71863_4_ + 1) == this.field_71990_ca;

                if (flag && flag1)
                {
                    p_71863_1_.func_94571_i(p_71863_2_, p_71863_3_, p_71863_4_);
                }
                else
                {
                    if ((p_71863_1_.func_72798_a(p_71863_2_ + b0, p_71863_3_, p_71863_4_ + b1) != Block.field_72089_ap.field_71990_ca || p_71863_1_.func_72798_a(p_71863_2_ - b0, p_71863_3_, p_71863_4_ - b1) != this.field_71990_ca) && (p_71863_1_.func_72798_a(p_71863_2_ - b0, p_71863_3_, p_71863_4_ - b1) != Block.field_72089_ap.field_71990_ca || p_71863_1_.func_72798_a(p_71863_2_ + b0, p_71863_3_, p_71863_4_ + b1) != this.field_71990_ca))
                    {
                        p_71863_1_.func_94571_i(p_71863_2_, p_71863_3_, p_71863_4_);
                    }
                }
            }
            else
            {
                p_71863_1_.func_94571_i(p_71863_2_, p_71863_3_, p_71863_4_);
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public boolean func_71877_c(IBlockAccess p_71877_1_, int p_71877_2_, int p_71877_3_, int p_71877_4_, int p_71877_5_)
    {
        if (p_71877_1_.func_72798_a(p_71877_2_, p_71877_3_, p_71877_4_) == this.field_71990_ca)
        {
            return false;
        }
        else
        {
            boolean flag = p_71877_1_.func_72798_a(p_71877_2_ - 1, p_71877_3_, p_71877_4_) == this.field_71990_ca && p_71877_1_.func_72798_a(p_71877_2_ - 2, p_71877_3_, p_71877_4_) != this.field_71990_ca;
            boolean flag1 = p_71877_1_.func_72798_a(p_71877_2_ + 1, p_71877_3_, p_71877_4_) == this.field_71990_ca && p_71877_1_.func_72798_a(p_71877_2_ + 2, p_71877_3_, p_71877_4_) != this.field_71990_ca;
            boolean flag2 = p_71877_1_.func_72798_a(p_71877_2_, p_71877_3_, p_71877_4_ - 1) == this.field_71990_ca && p_71877_1_.func_72798_a(p_71877_2_, p_71877_3_, p_71877_4_ - 2) != this.field_71990_ca;
            boolean flag3 = p_71877_1_.func_72798_a(p_71877_2_, p_71877_3_, p_71877_4_ + 1) == this.field_71990_ca && p_71877_1_.func_72798_a(p_71877_2_, p_71877_3_, p_71877_4_ + 2) != this.field_71990_ca;
            boolean flag4 = flag || flag1;
            boolean flag5 = flag2 || flag3;
            return flag4 && p_71877_5_ == 4 ? true : (flag4 && p_71877_5_ == 5 ? true : (flag5 && p_71877_5_ == 2 ? true : flag5 && p_71877_5_ == 3));
        }
    }

    public int func_71925_a(Random p_71925_1_)
    {
        return 0;
    }

    public void func_71869_a(World p_71869_1_, int p_71869_2_, int p_71869_3_, int p_71869_4_, Entity p_71869_5_)
    {
        if (p_71869_5_.field_70154_o == null && p_71869_5_.field_70153_n == null)
        {
            p_71869_5_.func_70063_aa();
        }
    }

    @SideOnly(Side.CLIENT)
    public int func_71856_s_()
    {
        return 1;
    }

    @SideOnly(Side.CLIENT)
    public void func_71862_a(World p_71862_1_, int p_71862_2_, int p_71862_3_, int p_71862_4_, Random p_71862_5_)
    {
        if (p_71862_5_.nextInt(100) == 0)
        {
            p_71862_1_.func_72980_b((double)p_71862_2_ + 0.5D, (double)p_71862_3_ + 0.5D, (double)p_71862_4_ + 0.5D, "portal.portal", 0.5F, p_71862_5_.nextFloat() * 0.4F + 0.8F, false);
        }

        for (int l = 0; l < 4; ++l)
        {
            double d0 = (double)((float)p_71862_2_ + p_71862_5_.nextFloat());
            double d1 = (double)((float)p_71862_3_ + p_71862_5_.nextFloat());
            double d2 = (double)((float)p_71862_4_ + p_71862_5_.nextFloat());
            double d3 = 0.0D;
            double d4 = 0.0D;
            double d5 = 0.0D;
            int i1 = p_71862_5_.nextInt(2) * 2 - 1;
            d3 = ((double)p_71862_5_.nextFloat() - 0.5D) * 0.5D;
            d4 = ((double)p_71862_5_.nextFloat() - 0.5D) * 0.5D;
            d5 = ((double)p_71862_5_.nextFloat() - 0.5D) * 0.5D;

            if (p_71862_1_.func_72798_a(p_71862_2_ - 1, p_71862_3_, p_71862_4_) != this.field_71990_ca && p_71862_1_.func_72798_a(p_71862_2_ + 1, p_71862_3_, p_71862_4_) != this.field_71990_ca)
            {
                d0 = (double)p_71862_2_ + 0.5D + 0.25D * (double)i1;
                d3 = (double)(p_71862_5_.nextFloat() * 2.0F * (float)i1);
            }
            else
            {
                d2 = (double)p_71862_4_ + 0.5D + 0.25D * (double)i1;
                d5 = (double)(p_71862_5_.nextFloat() * 2.0F * (float)i1);
            }

            p_71862_1_.func_72869_a("portal", d0, d1, d2, d3, d4, d5);
        }
    }

    @SideOnly(Side.CLIENT)
    public int func_71922_a(World p_71922_1_, int p_71922_2_, int p_71922_3_, int p_71922_4_)
    {
        return 0;
    }
}
