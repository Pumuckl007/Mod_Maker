package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockRailPowered extends BlockRailBase
{
    @SideOnly(Side.CLIENT)
    protected Icon field_94362_b;

    protected BlockRailPowered(int p_i2239_1_)
    {
        super(p_i2239_1_, true);
    }

    @SideOnly(Side.CLIENT)
    public Icon func_71858_a(int p_71858_1_, int p_71858_2_)
    {
        return (p_71858_2_ & 8) == 0 ? this.field_94336_cN : this.field_94362_b;
    }

    @SideOnly(Side.CLIENT)
    public void func_94332_a(IconRegister p_94332_1_)
    {
        super.func_94332_a(p_94332_1_);
        this.field_94362_b = p_94332_1_.func_94245_a(this.func_111023_E() + "_powered");
    }

    protected boolean func_94360_a(World p_94360_1_, int p_94360_2_, int p_94360_3_, int p_94360_4_, int p_94360_5_, boolean p_94360_6_, int p_94360_7_)
    {
        if (p_94360_7_ >= 8)
        {
            return false;
        }
        else
        {
            int j1 = p_94360_5_ & 7;
            boolean flag1 = true;

            switch (j1)
            {
                case 0:
                    if (p_94360_6_)
                    {
                        ++p_94360_4_;
                    }
                    else
                    {
                        --p_94360_4_;
                    }

                    break;
                case 1:
                    if (p_94360_6_)
                    {
                        --p_94360_2_;
                    }
                    else
                    {
                        ++p_94360_2_;
                    }

                    break;
                case 2:
                    if (p_94360_6_)
                    {
                        --p_94360_2_;
                    }
                    else
                    {
                        ++p_94360_2_;
                        ++p_94360_3_;
                        flag1 = false;
                    }

                    j1 = 1;
                    break;
                case 3:
                    if (p_94360_6_)
                    {
                        --p_94360_2_;
                        ++p_94360_3_;
                        flag1 = false;
                    }
                    else
                    {
                        ++p_94360_2_;
                    }

                    j1 = 1;
                    break;
                case 4:
                    if (p_94360_6_)
                    {
                        ++p_94360_4_;
                    }
                    else
                    {
                        --p_94360_4_;
                        ++p_94360_3_;
                        flag1 = false;
                    }

                    j1 = 0;
                    break;
                case 5:
                    if (p_94360_6_)
                    {
                        ++p_94360_4_;
                        ++p_94360_3_;
                        flag1 = false;
                    }
                    else
                    {
                        --p_94360_4_;
                    }

                    j1 = 0;
            }

            return this.func_94361_a(p_94360_1_, p_94360_2_, p_94360_3_, p_94360_4_, p_94360_6_, p_94360_7_, j1) ? true : flag1 && this.func_94361_a(p_94360_1_, p_94360_2_, p_94360_3_ - 1, p_94360_4_, p_94360_6_, p_94360_7_, j1);
        }
    }

    protected boolean func_94361_a(World p_94361_1_, int p_94361_2_, int p_94361_3_, int p_94361_4_, boolean p_94361_5_, int p_94361_6_, int p_94361_7_)
    {
        int j1 = p_94361_1_.func_72798_a(p_94361_2_, p_94361_3_, p_94361_4_);

        if (j1 == this.field_71990_ca)
        {
            int k1 = p_94361_1_.func_72805_g(p_94361_2_, p_94361_3_, p_94361_4_);
            int l1 = k1 & 7;

            if (p_94361_7_ == 1 && (l1 == 0 || l1 == 4 || l1 == 5))
            {
                return false;
            }

            if (p_94361_7_ == 0 && (l1 == 1 || l1 == 2 || l1 == 3))
            {
                return false;
            }

            if ((k1 & 8) != 0)
            {
                if (p_94361_1_.func_72864_z(p_94361_2_, p_94361_3_, p_94361_4_))
                {
                    return true;
                }

                return this.func_94360_a(p_94361_1_, p_94361_2_, p_94361_3_, p_94361_4_, k1, p_94361_5_, p_94361_6_ + 1);
            }
        }

        return false;
    }

    protected void func_94358_a(World p_94358_1_, int p_94358_2_, int p_94358_3_, int p_94358_4_, int p_94358_5_, int p_94358_6_, int p_94358_7_)
    {
        boolean flag = p_94358_1_.func_72864_z(p_94358_2_, p_94358_3_, p_94358_4_);
        flag = flag || this.func_94360_a(p_94358_1_, p_94358_2_, p_94358_3_, p_94358_4_, p_94358_5_, true, 0) || this.func_94360_a(p_94358_1_, p_94358_2_, p_94358_3_, p_94358_4_, p_94358_5_, false, 0);
        boolean flag1 = false;

        if (flag && (p_94358_5_ & 8) == 0)
        {
            p_94358_1_.func_72921_c(p_94358_2_, p_94358_3_, p_94358_4_, p_94358_6_ | 8, 3);
            flag1 = true;
        }
        else if (!flag && (p_94358_5_ & 8) != 0)
        {
            p_94358_1_.func_72921_c(p_94358_2_, p_94358_3_, p_94358_4_, p_94358_6_, 3);
            flag1 = true;
        }

        if (flag1)
        {
            p_94358_1_.func_72898_h(p_94358_2_, p_94358_3_ - 1, p_94358_4_, this.field_71990_ca);

            if (p_94358_6_ == 2 || p_94358_6_ == 3 || p_94358_6_ == 4 || p_94358_6_ == 5)
            {
                p_94358_1_.func_72898_h(p_94358_2_, p_94358_3_ + 1, p_94358_4_, this.field_71990_ca);
            }
        }
    }
}
