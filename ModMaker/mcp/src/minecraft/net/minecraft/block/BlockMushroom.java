package net.minecraft.block;

import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigMushroom;

public class BlockMushroom extends BlockFlower
{
    protected BlockMushroom(int p_i2227_1_)
    {
        super(p_i2227_1_);
        float f = 0.2F;
        this.func_71905_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
        this.func_71907_b(true);
    }

    public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_)
    {
        if (p_71847_5_.nextInt(25) == 0)
        {
            byte b0 = 4;
            int l = 5;
            int i1;
            int j1;
            int k1;

            for (i1 = p_71847_2_ - b0; i1 <= p_71847_2_ + b0; ++i1)
            {
                for (j1 = p_71847_4_ - b0; j1 <= p_71847_4_ + b0; ++j1)
                {
                    for (k1 = p_71847_3_ - 1; k1 <= p_71847_3_ + 1; ++k1)
                    {
                        if (p_71847_1_.func_72798_a(i1, k1, j1) == this.field_71990_ca)
                        {
                            --l;

                            if (l <= 0)
                            {
                                return;
                            }
                        }
                    }
                }
            }

            i1 = p_71847_2_ + p_71847_5_.nextInt(3) - 1;
            j1 = p_71847_3_ + p_71847_5_.nextInt(2) - p_71847_5_.nextInt(2);
            k1 = p_71847_4_ + p_71847_5_.nextInt(3) - 1;

            for (int l1 = 0; l1 < 4; ++l1)
            {
                if (p_71847_1_.func_72799_c(i1, j1, k1) && this.func_71854_d(p_71847_1_, i1, j1, k1))
                {
                    p_71847_2_ = i1;
                    p_71847_3_ = j1;
                    p_71847_4_ = k1;
                }

                i1 = p_71847_2_ + p_71847_5_.nextInt(3) - 1;
                j1 = p_71847_3_ + p_71847_5_.nextInt(2) - p_71847_5_.nextInt(2);
                k1 = p_71847_4_ + p_71847_5_.nextInt(3) - 1;
            }

            if (p_71847_1_.func_72799_c(i1, j1, k1) && this.func_71854_d(p_71847_1_, i1, j1, k1))
            {
                p_71847_1_.func_72832_d(i1, j1, k1, this.field_71990_ca, 0, 2);
            }
        }
    }

    public boolean func_71930_b(World p_71930_1_, int p_71930_2_, int p_71930_3_, int p_71930_4_)
    {
        return super.func_71930_b(p_71930_1_, p_71930_2_, p_71930_3_, p_71930_4_) && this.func_71854_d(p_71930_1_, p_71930_2_, p_71930_3_, p_71930_4_);
    }

    protected boolean func_72263_d_(int p_72263_1_)
    {
        return Block.field_71970_n[p_72263_1_];
    }

    public boolean func_71854_d(World p_71854_1_, int p_71854_2_, int p_71854_3_, int p_71854_4_)
    {
        if (p_71854_3_ >= 0 && p_71854_3_ < 256)
        {
            int l = p_71854_1_.func_72798_a(p_71854_2_, p_71854_3_ - 1, p_71854_4_);
            return l == Block.field_71994_by.field_71990_ca || p_71854_1_.func_72883_k(p_71854_2_, p_71854_3_, p_71854_4_) < 13 && this.func_72263_d_(l);
        }
        else
        {
            return false;
        }
    }

    public boolean func_72271_c(World p_72271_1_, int p_72271_2_, int p_72271_3_, int p_72271_4_, Random p_72271_5_)
    {
        int l = p_72271_1_.func_72805_g(p_72271_2_, p_72271_3_, p_72271_4_);
        p_72271_1_.func_94571_i(p_72271_2_, p_72271_3_, p_72271_4_);
        WorldGenBigMushroom worldgenbigmushroom = null;

        if (this.field_71990_ca == Block.field_72109_af.field_71990_ca)
        {
            worldgenbigmushroom = new WorldGenBigMushroom(0);
        }
        else if (this.field_71990_ca == Block.field_72103_ag.field_71990_ca)
        {
            worldgenbigmushroom = new WorldGenBigMushroom(1);
        }

        if (worldgenbigmushroom != null && worldgenbigmushroom.func_76484_a(p_72271_1_, p_72271_5_, p_72271_2_, p_72271_3_, p_72271_4_))
        {
            return true;
        }
        else
        {
            p_72271_1_.func_72832_d(p_72271_2_, p_72271_3_, p_72271_4_, this.field_71990_ca, l, 3);
            return false;
        }
    }
}
