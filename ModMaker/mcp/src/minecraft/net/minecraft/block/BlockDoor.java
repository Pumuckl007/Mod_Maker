package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.IconFlipped;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDoor extends Block
{
    @SideOnly(Side.CLIENT)
    private Icon[] field_111044_a;
    @SideOnly(Side.CLIENT)
    private Icon[] field_111043_b;

    protected BlockDoor(int p_i2193_1_, Material p_i2193_2_)
    {
        super(p_i2193_1_, p_i2193_2_);
        float f = 0.5F;
        float f1 = 1.0F;
        this.func_71905_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
    }

    @SideOnly(Side.CLIENT)
    public Icon func_71858_a(int p_71858_1_, int p_71858_2_)
    {
        return this.field_111043_b[0];
    }

    @SideOnly(Side.CLIENT)
    public Icon func_71895_b(IBlockAccess p_71895_1_, int p_71895_2_, int p_71895_3_, int p_71895_4_, int p_71895_5_)
    {
        if (p_71895_5_ != 1 && p_71895_5_ != 0)
        {
            int i1 = this.func_72234_b_(p_71895_1_, p_71895_2_, p_71895_3_, p_71895_4_);
            int j1 = i1 & 3;
            boolean flag = (i1 & 4) != 0;
            boolean flag1 = false;
            boolean flag2 = (i1 & 8) != 0;

            if (flag)
            {
                if (j1 == 0 && p_71895_5_ == 2)
                {
                    flag1 = !flag1;
                }
                else if (j1 == 1 && p_71895_5_ == 5)
                {
                    flag1 = !flag1;
                }
                else if (j1 == 2 && p_71895_5_ == 3)
                {
                    flag1 = !flag1;
                }
                else if (j1 == 3 && p_71895_5_ == 4)
                {
                    flag1 = !flag1;
                }
            }
            else
            {
                if (j1 == 0 && p_71895_5_ == 5)
                {
                    flag1 = !flag1;
                }
                else if (j1 == 1 && p_71895_5_ == 3)
                {
                    flag1 = !flag1;
                }
                else if (j1 == 2 && p_71895_5_ == 4)
                {
                    flag1 = !flag1;
                }
                else if (j1 == 3 && p_71895_5_ == 2)
                {
                    flag1 = !flag1;
                }

                if ((i1 & 16) != 0)
                {
                    flag1 = !flag1;
                }
            }

            return flag2 ? this.field_111044_a[flag1 ? 1 : 0] : this.field_111043_b[flag1 ? 1 : 0];
        }
        else
        {
            return this.field_111043_b[0];
        }
    }

    @SideOnly(Side.CLIENT)
    public void func_94332_a(IconRegister p_94332_1_)
    {
        this.field_111044_a = new Icon[2];
        this.field_111043_b = new Icon[2];
        this.field_111044_a[0] = p_94332_1_.func_94245_a(this.func_111023_E() + "_upper");
        this.field_111043_b[0] = p_94332_1_.func_94245_a(this.func_111023_E() + "_lower");
        this.field_111044_a[1] = new IconFlipped(this.field_111044_a[0], true, false);
        this.field_111043_b[1] = new IconFlipped(this.field_111043_b[0], true, false);
    }

    public boolean func_71926_d()
    {
        return false;
    }

    public boolean func_71918_c(IBlockAccess p_71918_1_, int p_71918_2_, int p_71918_3_, int p_71918_4_)
    {
        int l = this.func_72234_b_(p_71918_1_, p_71918_2_, p_71918_3_, p_71918_4_);
        return (l & 4) != 0;
    }

    public boolean func_71886_c()
    {
        return false;
    }

    public int func_71857_b()
    {
        return 7;
    }

    @SideOnly(Side.CLIENT)
    public AxisAlignedBB func_71911_a_(World p_71911_1_, int p_71911_2_, int p_71911_3_, int p_71911_4_)
    {
        this.func_71902_a(p_71911_1_, p_71911_2_, p_71911_3_, p_71911_4_);
        return super.func_71911_a_(p_71911_1_, p_71911_2_, p_71911_3_, p_71911_4_);
    }

    public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int p_71872_4_)
    {
        this.func_71902_a(p_71872_1_, p_71872_2_, p_71872_3_, p_71872_4_);
        return super.func_71872_e(p_71872_1_, p_71872_2_, p_71872_3_, p_71872_4_);
    }

    public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_)
    {
        this.func_72232_e(this.func_72234_b_(p_71902_1_, p_71902_2_, p_71902_3_, p_71902_4_));
    }

    public int func_72235_d(IBlockAccess p_72235_1_, int p_72235_2_, int p_72235_3_, int p_72235_4_)
    {
        return this.func_72234_b_(p_72235_1_, p_72235_2_, p_72235_3_, p_72235_4_) & 3;
    }

    public boolean func_72233_a_(IBlockAccess p_72233_1_, int p_72233_2_, int p_72233_3_, int p_72233_4_)
    {
        return (this.func_72234_b_(p_72233_1_, p_72233_2_, p_72233_3_, p_72233_4_) & 4) != 0;
    }

    private void func_72232_e(int p_72232_1_)
    {
        float f = 0.1875F;
        this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
        int j = p_72232_1_ & 3;
        boolean flag = (p_72232_1_ & 4) != 0;
        boolean flag1 = (p_72232_1_ & 16) != 0;

        if (j == 0)
        {
            if (flag)
            {
                if (!flag1)
                {
                    this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
                }
                else
                {
                    this.func_71905_a(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
                }
            }
            else
            {
                this.func_71905_a(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
            }
        }
        else if (j == 1)
        {
            if (flag)
            {
                if (!flag1)
                {
                    this.func_71905_a(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
                }
                else
                {
                    this.func_71905_a(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
                }
            }
            else
            {
                this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
            }
        }
        else if (j == 2)
        {
            if (flag)
            {
                if (!flag1)
                {
                    this.func_71905_a(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
                }
                else
                {
                    this.func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
                }
            }
            else
            {
                this.func_71905_a(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            }
        }
        else if (j == 3)
        {
            if (flag)
            {
                if (!flag1)
                {
                    this.func_71905_a(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
                }
                else
                {
                    this.func_71905_a(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
                }
            }
            else
            {
                this.func_71905_a(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
            }
        }
    }

    public void func_71921_a(World p_71921_1_, int p_71921_2_, int p_71921_3_, int p_71921_4_, EntityPlayer p_71921_5_) {}

    public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, float p_71903_8_, float p_71903_9_)
    {
        if (this.field_72018_cp == Material.field_76243_f)
        {
            return true;
        }
        else
        {
            int i1 = this.func_72234_b_(p_71903_1_, p_71903_2_, p_71903_3_, p_71903_4_);
            int j1 = i1 & 7;
            j1 ^= 4;

            if ((i1 & 8) == 0)
            {
                p_71903_1_.func_72921_c(p_71903_2_, p_71903_3_, p_71903_4_, j1, 2);
                p_71903_1_.func_72909_d(p_71903_2_, p_71903_3_, p_71903_4_, p_71903_2_, p_71903_3_, p_71903_4_);
            }
            else
            {
                p_71903_1_.func_72921_c(p_71903_2_, p_71903_3_ - 1, p_71903_4_, j1, 2);
                p_71903_1_.func_72909_d(p_71903_2_, p_71903_3_ - 1, p_71903_4_, p_71903_2_, p_71903_3_, p_71903_4_);
            }

            p_71903_1_.func_72889_a(p_71903_5_, 1003, p_71903_2_, p_71903_3_, p_71903_4_, 0);
            return true;
        }
    }

    public void func_72231_a(World p_72231_1_, int p_72231_2_, int p_72231_3_, int p_72231_4_, boolean p_72231_5_)
    {
        int l = this.func_72234_b_(p_72231_1_, p_72231_2_, p_72231_3_, p_72231_4_);
        boolean flag1 = (l & 4) != 0;

        if (flag1 != p_72231_5_)
        {
            int i1 = l & 7;
            i1 ^= 4;

            if ((l & 8) == 0)
            {
                p_72231_1_.func_72921_c(p_72231_2_, p_72231_3_, p_72231_4_, i1, 2);
                p_72231_1_.func_72909_d(p_72231_2_, p_72231_3_, p_72231_4_, p_72231_2_, p_72231_3_, p_72231_4_);
            }
            else
            {
                p_72231_1_.func_72921_c(p_72231_2_, p_72231_3_ - 1, p_72231_4_, i1, 2);
                p_72231_1_.func_72909_d(p_72231_2_, p_72231_3_ - 1, p_72231_4_, p_72231_2_, p_72231_3_, p_72231_4_);
            }

            p_72231_1_.func_72889_a((EntityPlayer)null, 1003, p_72231_2_, p_72231_3_, p_72231_4_, 0);
        }
    }

    public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_)
    {
        int i1 = p_71863_1_.func_72805_g(p_71863_2_, p_71863_3_, p_71863_4_);

        if ((i1 & 8) == 0)
        {
            boolean flag = false;

            if (p_71863_1_.func_72798_a(p_71863_2_, p_71863_3_ + 1, p_71863_4_) != this.field_71990_ca)
            {
                p_71863_1_.func_94571_i(p_71863_2_, p_71863_3_, p_71863_4_);
                flag = true;
            }

            if (!p_71863_1_.func_72797_t(p_71863_2_, p_71863_3_ - 1, p_71863_4_))
            {
                p_71863_1_.func_94571_i(p_71863_2_, p_71863_3_, p_71863_4_);
                flag = true;

                if (p_71863_1_.func_72798_a(p_71863_2_, p_71863_3_ + 1, p_71863_4_) == this.field_71990_ca)
                {
                    p_71863_1_.func_94571_i(p_71863_2_, p_71863_3_ + 1, p_71863_4_);
                }
            }

            if (flag)
            {
                if (!p_71863_1_.field_72995_K)
                {
                    this.func_71897_c(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, i1, 0);
                }
            }
            else
            {
                boolean flag1 = p_71863_1_.func_72864_z(p_71863_2_, p_71863_3_, p_71863_4_) || p_71863_1_.func_72864_z(p_71863_2_, p_71863_3_ + 1, p_71863_4_);

                if ((flag1 || p_71863_5_ > 0 && Block.field_71973_m[p_71863_5_].func_71853_i()) && p_71863_5_ != this.field_71990_ca)
                {
                    this.func_72231_a(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, flag1);
                }
            }
        }
        else
        {
            if (p_71863_1_.func_72798_a(p_71863_2_, p_71863_3_ - 1, p_71863_4_) != this.field_71990_ca)
            {
                p_71863_1_.func_94571_i(p_71863_2_, p_71863_3_, p_71863_4_);
            }

            if (p_71863_5_ > 0 && p_71863_5_ != this.field_71990_ca)
            {
                this.func_71863_a(p_71863_1_, p_71863_2_, p_71863_3_ - 1, p_71863_4_, p_71863_5_);
            }
        }
    }

    public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_)
    {
        return (p_71885_1_ & 8) != 0 ? 0 : (this.field_72018_cp == Material.field_76243_f ? Item.field_77766_aB.field_77779_bT : Item.field_77790_av.field_77779_bT);
    }

    public MovingObjectPosition func_71878_a(World p_71878_1_, int p_71878_2_, int p_71878_3_, int p_71878_4_, Vec3 p_71878_5_, Vec3 p_71878_6_)
    {
        this.func_71902_a(p_71878_1_, p_71878_2_, p_71878_3_, p_71878_4_);
        return super.func_71878_a(p_71878_1_, p_71878_2_, p_71878_3_, p_71878_4_, p_71878_5_, p_71878_6_);
    }

    public boolean func_71930_b(World p_71930_1_, int p_71930_2_, int p_71930_3_, int p_71930_4_)
    {
        return p_71930_3_ >= 255 ? false : p_71930_1_.func_72797_t(p_71930_2_, p_71930_3_ - 1, p_71930_4_) && super.func_71930_b(p_71930_1_, p_71930_2_, p_71930_3_, p_71930_4_) && super.func_71930_b(p_71930_1_, p_71930_2_, p_71930_3_ + 1, p_71930_4_);
    }

    public int func_71915_e()
    {
        return 1;
    }

    public int func_72234_b_(IBlockAccess p_72234_1_, int p_72234_2_, int p_72234_3_, int p_72234_4_)
    {
        int l = p_72234_1_.func_72805_g(p_72234_2_, p_72234_3_, p_72234_4_);
        boolean flag = (l & 8) != 0;
        int i1;
        int j1;

        if (flag)
        {
            i1 = p_72234_1_.func_72805_g(p_72234_2_, p_72234_3_ - 1, p_72234_4_);
            j1 = l;
        }
        else
        {
            i1 = l;
            j1 = p_72234_1_.func_72805_g(p_72234_2_, p_72234_3_ + 1, p_72234_4_);
        }

        boolean flag1 = (j1 & 1) != 0;
        return i1 & 7 | (flag ? 8 : 0) | (flag1 ? 16 : 0);
    }

    @SideOnly(Side.CLIENT)
    public int func_71922_a(World p_71922_1_, int p_71922_2_, int p_71922_3_, int p_71922_4_)
    {
        return this.field_72018_cp == Material.field_76243_f ? Item.field_77766_aB.field_77779_bT : Item.field_77790_av.field_77779_bT;
    }

    public void func_71846_a(World p_71846_1_, int p_71846_2_, int p_71846_3_, int p_71846_4_, int p_71846_5_, EntityPlayer p_71846_6_)
    {
        if (p_71846_6_.field_71075_bZ.field_75098_d && (p_71846_5_ & 8) != 0 && p_71846_1_.func_72798_a(p_71846_2_, p_71846_3_ - 1, p_71846_4_) == this.field_71990_ca)
        {
            p_71846_1_.func_94571_i(p_71846_2_, p_71846_3_ - 1, p_71846_4_);
        }
    }
}
