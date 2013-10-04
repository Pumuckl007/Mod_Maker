package net.minecraft.command;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

class CommandSpreadPlayersPosition
{
    double field_111101_a;
    double field_111100_b;

    CommandSpreadPlayersPosition() {}

    CommandSpreadPlayersPosition(double p_i1358_1_, double p_i1358_3_)
    {
        this.field_111101_a = p_i1358_1_;
        this.field_111100_b = p_i1358_3_;
    }

    double func_111099_a(CommandSpreadPlayersPosition p_111099_1_)
    {
        double d0 = this.field_111101_a - p_111099_1_.field_111101_a;
        double d1 = this.field_111100_b - p_111099_1_.field_111100_b;
        return Math.sqrt(d0 * d0 + d1 * d1);
    }

    void func_111095_a()
    {
        double d0 = (double)this.func_111096_b();
        this.field_111101_a /= d0;
        this.field_111100_b /= d0;
    }

    float func_111096_b()
    {
        return MathHelper.func_76133_a(this.field_111101_a * this.field_111101_a + this.field_111100_b * this.field_111100_b);
    }

    public void func_111094_b(CommandSpreadPlayersPosition p_111094_1_)
    {
        this.field_111101_a -= p_111094_1_.field_111101_a;
        this.field_111100_b -= p_111094_1_.field_111100_b;
    }

    public boolean func_111093_a(double p_111093_1_, double p_111093_3_, double p_111093_5_, double p_111093_7_)
    {
        boolean flag = false;

        if (this.field_111101_a < p_111093_1_)
        {
            this.field_111101_a = p_111093_1_;
            flag = true;
        }
        else if (this.field_111101_a > p_111093_5_)
        {
            this.field_111101_a = p_111093_5_;
            flag = true;
        }

        if (this.field_111100_b < p_111093_3_)
        {
            this.field_111100_b = p_111093_3_;
            flag = true;
        }
        else if (this.field_111100_b > p_111093_7_)
        {
            this.field_111100_b = p_111093_7_;
            flag = true;
        }

        return flag;
    }

    public int func_111092_a(World p_111092_1_)
    {
        int i = MathHelper.func_76128_c(this.field_111101_a);
        int j = MathHelper.func_76128_c(this.field_111100_b);

        for (int k = 256; k > 0; --k)
        {
            int l = p_111092_1_.func_72798_a(i, k, j);

            if (l != 0)
            {
                return k + 1;
            }
        }

        return 257;
    }

    public boolean func_111098_b(World p_111098_1_)
    {
        int i = MathHelper.func_76128_c(this.field_111101_a);
        int j = MathHelper.func_76128_c(this.field_111100_b);

        for (int k = 256; k > 0; --k)
        {
            int l = p_111098_1_.func_72798_a(i, k, j);

            if (l != 0)
            {
                Material material = Block.field_71973_m[l].field_72018_cp;
                return !material.func_76224_d() && material != Material.field_76250_n;
            }
        }

        return false;
    }

    public void func_111097_a(Random p_111097_1_, double p_111097_2_, double p_111097_4_, double p_111097_6_, double p_111097_8_)
    {
        this.field_111101_a = MathHelper.func_82716_a(p_111097_1_, p_111097_2_, p_111097_6_);
        this.field_111100_b = MathHelper.func_82716_a(p_111097_1_, p_111097_4_, p_111097_8_);
    }
}
