package net.minecraft.entity;

import net.minecraft.util.MathHelper;

public enum EnumEntitySize
{
    SIZE_1,
    SIZE_2,
    SIZE_3,
    SIZE_4,
    SIZE_5,
    SIZE_6;

    public int func_75630_a(double p_75630_1_)
    {
        double d1 = p_75630_1_ - ((double)MathHelper.func_76128_c(p_75630_1_) + 0.5D);

        switch (EnumEntitySizeHelper.field_96565_a[this.ordinal()])
        {
            case 1:
                if (d1 < 0.0D)
                {
                    if (d1 < -0.3125D)
                    {
                        return MathHelper.func_76143_f(p_75630_1_ * 32.0D);
                    }
                }
                else if (d1 < 0.3125D)
                {
                    return MathHelper.func_76143_f(p_75630_1_ * 32.0D);
                }

                return MathHelper.func_76128_c(p_75630_1_ * 32.0D);
            case 2:
                if (d1 < 0.0D)
                {
                    if (d1 < -0.3125D)
                    {
                        return MathHelper.func_76128_c(p_75630_1_ * 32.0D);
                    }
                }
                else if (d1 < 0.3125D)
                {
                    return MathHelper.func_76128_c(p_75630_1_ * 32.0D);
                }

                return MathHelper.func_76143_f(p_75630_1_ * 32.0D);
            case 3:
                if (d1 > 0.0D)
                {
                    return MathHelper.func_76128_c(p_75630_1_ * 32.0D);
                }

                return MathHelper.func_76143_f(p_75630_1_ * 32.0D);
            case 4:
                if (d1 < 0.0D)
                {
                    if (d1 < -0.1875D)
                    {
                        return MathHelper.func_76143_f(p_75630_1_ * 32.0D);
                    }
                }
                else if (d1 < 0.1875D)
                {
                    return MathHelper.func_76143_f(p_75630_1_ * 32.0D);
                }

                return MathHelper.func_76128_c(p_75630_1_ * 32.0D);
            case 5:
                if (d1 < 0.0D)
                {
                    if (d1 < -0.1875D)
                    {
                        return MathHelper.func_76128_c(p_75630_1_ * 32.0D);
                    }
                }
                else if (d1 < 0.1875D)
                {
                    return MathHelper.func_76128_c(p_75630_1_ * 32.0D);
                }

                return MathHelper.func_76143_f(p_75630_1_ * 32.0D);
            case 6:
            default:
                if (d1 > 0.0D)
                {
                    return MathHelper.func_76143_f(p_75630_1_ * 32.0D);
                }
                else
                {
                    return MathHelper.func_76128_c(p_75630_1_ * 32.0D);
                }
        }
    }
}
