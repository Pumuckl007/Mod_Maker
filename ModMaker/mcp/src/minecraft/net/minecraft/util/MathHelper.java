package net.minecraft.util;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

public class MathHelper
{
    private static float[] field_76144_a = new float[65536];

    public static final float func_76126_a(float p_76126_0_)
    {
        return field_76144_a[(int)(p_76126_0_ * 10430.378F) & 65535];
    }

    public static final float func_76134_b(float p_76134_0_)
    {
        return field_76144_a[(int)(p_76134_0_ * 10430.378F + 16384.0F) & 65535];
    }

    public static final float func_76129_c(float p_76129_0_)
    {
        return (float)Math.sqrt((double)p_76129_0_);
    }

    public static final float func_76133_a(double p_76133_0_)
    {
        return (float)Math.sqrt(p_76133_0_);
    }

    public static int func_76141_d(float p_76141_0_)
    {
        int i = (int)p_76141_0_;
        return p_76141_0_ < (float)i ? i - 1 : i;
    }

    @SideOnly(Side.CLIENT)
    public static int func_76140_b(double p_76140_0_)
    {
        return (int)(p_76140_0_ + 1024.0D) - 1024;
    }

    public static int func_76128_c(double p_76128_0_)
    {
        int i = (int)p_76128_0_;
        return p_76128_0_ < (double)i ? i - 1 : i;
    }

    public static long func_76124_d(double p_76124_0_)
    {
        long i = (long)p_76124_0_;
        return p_76124_0_ < (double)i ? i - 1L : i;
    }

    public static float func_76135_e(float p_76135_0_)
    {
        return p_76135_0_ >= 0.0F ? p_76135_0_ : -p_76135_0_;
    }

    public static int func_76130_a(int p_76130_0_)
    {
        return p_76130_0_ >= 0 ? p_76130_0_ : -p_76130_0_;
    }

    public static int func_76123_f(float p_76123_0_)
    {
        int i = (int)p_76123_0_;
        return p_76123_0_ > (float)i ? i + 1 : i;
    }

    public static int func_76143_f(double p_76143_0_)
    {
        int i = (int)p_76143_0_;
        return p_76143_0_ > (double)i ? i + 1 : i;
    }

    public static int func_76125_a(int p_76125_0_, int p_76125_1_, int p_76125_2_)
    {
        return p_76125_0_ < p_76125_1_ ? p_76125_1_ : (p_76125_0_ > p_76125_2_ ? p_76125_2_ : p_76125_0_);
    }

    public static float func_76131_a(float p_76131_0_, float p_76131_1_, float p_76131_2_)
    {
        return p_76131_0_ < p_76131_1_ ? p_76131_1_ : (p_76131_0_ > p_76131_2_ ? p_76131_2_ : p_76131_0_);
    }

    public static double func_76132_a(double p_76132_0_, double p_76132_2_)
    {
        if (p_76132_0_ < 0.0D)
        {
            p_76132_0_ = -p_76132_0_;
        }

        if (p_76132_2_ < 0.0D)
        {
            p_76132_2_ = -p_76132_2_;
        }

        return p_76132_0_ > p_76132_2_ ? p_76132_0_ : p_76132_2_;
    }

    @SideOnly(Side.CLIENT)
    public static int func_76137_a(int p_76137_0_, int p_76137_1_)
    {
        return p_76137_0_ < 0 ? -((-p_76137_0_ - 1) / p_76137_1_) - 1 : p_76137_0_ / p_76137_1_;
    }

    @SideOnly(Side.CLIENT)
    public static boolean func_76139_a(String p_76139_0_)
    {
        return p_76139_0_ == null || p_76139_0_.length() == 0;
    }

    public static int func_76136_a(Random p_76136_0_, int p_76136_1_, int p_76136_2_)
    {
        return p_76136_1_ >= p_76136_2_ ? p_76136_1_ : p_76136_0_.nextInt(p_76136_2_ - p_76136_1_ + 1) + p_76136_1_;
    }

    public static double func_82716_a(Random p_82716_0_, double p_82716_1_, double p_82716_3_)
    {
        return p_82716_1_ >= p_82716_3_ ? p_82716_1_ : p_82716_0_.nextDouble() * (p_82716_3_ - p_82716_1_) + p_82716_1_;
    }

    public static double func_76127_a(long[] p_76127_0_)
    {
        long i = 0L;
        long[] along1 = p_76127_0_;
        int j = p_76127_0_.length;

        for (int k = 0; k < j; ++k)
        {
            long l = along1[k];
            i += l;
        }

        return (double)i / (double)p_76127_0_.length;
    }

    public static float func_76142_g(float p_76142_0_)
    {
        p_76142_0_ %= 360.0F;

        if (p_76142_0_ >= 180.0F)
        {
            p_76142_0_ -= 360.0F;
        }

        if (p_76142_0_ < -180.0F)
        {
            p_76142_0_ += 360.0F;
        }

        return p_76142_0_;
    }

    public static double func_76138_g(double p_76138_0_)
    {
        p_76138_0_ %= 360.0D;

        if (p_76138_0_ >= 180.0D)
        {
            p_76138_0_ -= 360.0D;
        }

        if (p_76138_0_ < -180.0D)
        {
            p_76138_0_ += 360.0D;
        }

        return p_76138_0_;
    }

    public static int func_82715_a(String p_82715_0_, int p_82715_1_)
    {
        int j = p_82715_1_;

        try
        {
            j = Integer.parseInt(p_82715_0_);
        }
        catch (Throwable throwable)
        {
            ;
        }

        return j;
    }

    public static int func_82714_a(String p_82714_0_, int p_82714_1_, int p_82714_2_)
    {
        int k = p_82714_1_;

        try
        {
            k = Integer.parseInt(p_82714_0_);
        }
        catch (Throwable throwable)
        {
            ;
        }

        if (k < p_82714_2_)
        {
            k = p_82714_2_;
        }

        return k;
    }

    public static double func_82712_a(String p_82712_0_, double p_82712_1_)
    {
        double d1 = p_82712_1_;

        try
        {
            d1 = Double.parseDouble(p_82712_0_);
        }
        catch (Throwable throwable)
        {
            ;
        }

        return d1;
    }

    public static double func_82713_a(String p_82713_0_, double p_82713_1_, double p_82713_3_)
    {
        double d2 = p_82713_1_;

        try
        {
            d2 = Double.parseDouble(p_82713_0_);
        }
        catch (Throwable throwable)
        {
            ;
        }

        if (d2 < p_82713_3_)
        {
            d2 = p_82713_3_;
        }

        return d2;
    }

    static
    {
        for (int i = 0; i < 65536; ++i)
        {
            field_76144_a[i] = (float)Math.sin((double)i * Math.PI * 2.0D / 65536.0D);
        }
    }
}
