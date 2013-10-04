package net.minecraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public abstract class BlockRotatedPillar extends Block
{
    @SideOnly(Side.CLIENT)
    protected Icon field_111051_a;

    protected BlockRotatedPillar(int p_i2250_1_, Material p_i2250_2_)
    {
        super(p_i2250_1_, p_i2250_2_);
    }

    public int func_71857_b()
    {
        return 31;
    }

    public int func_85104_a(World p_85104_1_, int p_85104_2_, int p_85104_3_, int p_85104_4_, int p_85104_5_, float p_85104_6_, float p_85104_7_, float p_85104_8_, int p_85104_9_)
    {
        int j1 = p_85104_9_ & 3;
        byte b0 = 0;

        switch (p_85104_5_)
        {
            case 0:
            case 1:
                b0 = 0;
                break;
            case 2:
            case 3:
                b0 = 8;
                break;
            case 4:
            case 5:
                b0 = 4;
        }

        return j1 | b0;
    }

    @SideOnly(Side.CLIENT)
    public Icon func_71858_a(int p_71858_1_, int p_71858_2_)
    {
        int k = p_71858_2_ & 12;
        int l = p_71858_2_ & 3;
        return k == 0 && (p_71858_1_ == 1 || p_71858_1_ == 0) ? this.func_111049_d(l) : (k == 4 && (p_71858_1_ == 5 || p_71858_1_ == 4) ? this.func_111049_d(l) : (k == 8 && (p_71858_1_ == 2 || p_71858_1_ == 3) ? this.func_111049_d(l) : this.func_111048_c(l)));
    }

    public int func_71899_b(int p_71899_1_)
    {
        return p_71899_1_ & 3;
    }

    @SideOnly(Side.CLIENT)
    protected abstract Icon func_111048_c(int i);

    @SideOnly(Side.CLIENT)
    protected Icon func_111049_d(int p_111049_1_)
    {
        return this.field_111051_a;
    }

    public int func_111050_e(int p_111050_1_)
    {
        return p_111050_1_ & 3;
    }

    protected ItemStack func_71880_c_(int p_71880_1_)
    {
        return new ItemStack(this.field_71990_ca, 1, this.func_111050_e(p_71880_1_));
    }
}
