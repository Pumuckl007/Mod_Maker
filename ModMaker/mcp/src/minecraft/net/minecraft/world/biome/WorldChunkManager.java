package net.minecraft.world.biome;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class WorldChunkManager
{
    private GenLayer field_76944_d;
    private GenLayer field_76945_e;
    private BiomeCache field_76942_f;
    private List field_76943_g;

    protected WorldChunkManager()
    {
        this.field_76942_f = new BiomeCache(this);
        this.field_76943_g = new ArrayList();
        this.field_76943_g.add(BiomeGenBase.field_76767_f);
        this.field_76943_g.add(BiomeGenBase.field_76772_c);
        this.field_76943_g.add(BiomeGenBase.field_76768_g);
        this.field_76943_g.add(BiomeGenBase.field_76784_u);
        this.field_76943_g.add(BiomeGenBase.field_76785_t);
        this.field_76943_g.add(BiomeGenBase.field_76782_w);
        this.field_76943_g.add(BiomeGenBase.field_76792_x);
    }

    public WorldChunkManager(long p_i1975_1_, WorldType p_i1975_3_)
    {
        this();
        GenLayer[] agenlayer = GenLayer.func_75901_a(p_i1975_1_, p_i1975_3_);
        this.field_76944_d = agenlayer[0];
        this.field_76945_e = agenlayer[1];
    }

    public WorldChunkManager(World p_i1976_1_)
    {
        this(p_i1976_1_.func_72905_C(), p_i1976_1_.func_72912_H().func_76067_t());
    }

    public List func_76932_a()
    {
        return this.field_76943_g;
    }

    public BiomeGenBase func_76935_a(int p_76935_1_, int p_76935_2_)
    {
        return this.field_76942_f.func_76837_b(p_76935_1_, p_76935_2_);
    }

    public float[] func_76936_a(float[] p_76936_1_, int p_76936_2_, int p_76936_3_, int p_76936_4_, int p_76936_5_)
    {
        IntCache.func_76446_a();

        if (p_76936_1_ == null || p_76936_1_.length < p_76936_4_ * p_76936_5_)
        {
            p_76936_1_ = new float[p_76936_4_ * p_76936_5_];
        }

        int[] aint = this.field_76945_e.func_75904_a(p_76936_2_, p_76936_3_, p_76936_4_, p_76936_5_);

        for (int i1 = 0; i1 < p_76936_4_ * p_76936_5_; ++i1)
        {
            float f = (float)BiomeGenBase.field_76773_a[aint[i1]].func_76744_g() / 65536.0F;

            if (f > 1.0F)
            {
                f = 1.0F;
            }

            p_76936_1_[i1] = f;
        }

        return p_76936_1_;
    }

    @SideOnly(Side.CLIENT)
    public float func_76939_a(float p_76939_1_, int p_76939_2_)
    {
        return p_76939_1_;
    }

    public float[] func_76934_b(float[] p_76934_1_, int p_76934_2_, int p_76934_3_, int p_76934_4_, int p_76934_5_)
    {
        IntCache.func_76446_a();

        if (p_76934_1_ == null || p_76934_1_.length < p_76934_4_ * p_76934_5_)
        {
            p_76934_1_ = new float[p_76934_4_ * p_76934_5_];
        }

        int[] aint = this.field_76945_e.func_75904_a(p_76934_2_, p_76934_3_, p_76934_4_, p_76934_5_);

        for (int i1 = 0; i1 < p_76934_4_ * p_76934_5_; ++i1)
        {
            float f = (float)BiomeGenBase.field_76773_a[aint[i1]].func_76734_h() / 65536.0F;

            if (f > 1.0F)
            {
                f = 1.0F;
            }

            p_76934_1_[i1] = f;
        }

        return p_76934_1_;
    }

    public BiomeGenBase[] func_76937_a(BiomeGenBase[] p_76937_1_, int p_76937_2_, int p_76937_3_, int p_76937_4_, int p_76937_5_)
    {
        IntCache.func_76446_a();

        if (p_76937_1_ == null || p_76937_1_.length < p_76937_4_ * p_76937_5_)
        {
            p_76937_1_ = new BiomeGenBase[p_76937_4_ * p_76937_5_];
        }

        int[] aint = this.field_76944_d.func_75904_a(p_76937_2_, p_76937_3_, p_76937_4_, p_76937_5_);

        for (int i1 = 0; i1 < p_76937_4_ * p_76937_5_; ++i1)
        {
            p_76937_1_[i1] = BiomeGenBase.field_76773_a[aint[i1]];
        }

        return p_76937_1_;
    }

    public BiomeGenBase[] func_76933_b(BiomeGenBase[] p_76933_1_, int p_76933_2_, int p_76933_3_, int p_76933_4_, int p_76933_5_)
    {
        return this.func_76931_a(p_76933_1_, p_76933_2_, p_76933_3_, p_76933_4_, p_76933_5_, true);
    }

    public BiomeGenBase[] func_76931_a(BiomeGenBase[] p_76931_1_, int p_76931_2_, int p_76931_3_, int p_76931_4_, int p_76931_5_, boolean p_76931_6_)
    {
        IntCache.func_76446_a();

        if (p_76931_1_ == null || p_76931_1_.length < p_76931_4_ * p_76931_5_)
        {
            p_76931_1_ = new BiomeGenBase[p_76931_4_ * p_76931_5_];
        }

        if (p_76931_6_ && p_76931_4_ == 16 && p_76931_5_ == 16 && (p_76931_2_ & 15) == 0 && (p_76931_3_ & 15) == 0)
        {
            BiomeGenBase[] abiomegenbase1 = this.field_76942_f.func_76839_e(p_76931_2_, p_76931_3_);
            System.arraycopy(abiomegenbase1, 0, p_76931_1_, 0, p_76931_4_ * p_76931_5_);
            return p_76931_1_;
        }
        else
        {
            int[] aint = this.field_76945_e.func_75904_a(p_76931_2_, p_76931_3_, p_76931_4_, p_76931_5_);

            for (int i1 = 0; i1 < p_76931_4_ * p_76931_5_; ++i1)
            {
                p_76931_1_[i1] = BiomeGenBase.field_76773_a[aint[i1]];
            }

            return p_76931_1_;
        }
    }

    public boolean func_76940_a(int p_76940_1_, int p_76940_2_, int p_76940_3_, List p_76940_4_)
    {
        IntCache.func_76446_a();
        int l = p_76940_1_ - p_76940_3_ >> 2;
        int i1 = p_76940_2_ - p_76940_3_ >> 2;
        int j1 = p_76940_1_ + p_76940_3_ >> 2;
        int k1 = p_76940_2_ + p_76940_3_ >> 2;
        int l1 = j1 - l + 1;
        int i2 = k1 - i1 + 1;
        int[] aint = this.field_76944_d.func_75904_a(l, i1, l1, i2);

        for (int j2 = 0; j2 < l1 * i2; ++j2)
        {
            BiomeGenBase biomegenbase = BiomeGenBase.field_76773_a[aint[j2]];

            if (!p_76940_4_.contains(biomegenbase))
            {
                return false;
            }
        }

        return true;
    }

    public ChunkPosition func_76941_a(int p_76941_1_, int p_76941_2_, int p_76941_3_, List p_76941_4_, Random p_76941_5_)
    {
        IntCache.func_76446_a();
        int l = p_76941_1_ - p_76941_3_ >> 2;
        int i1 = p_76941_2_ - p_76941_3_ >> 2;
        int j1 = p_76941_1_ + p_76941_3_ >> 2;
        int k1 = p_76941_2_ + p_76941_3_ >> 2;
        int l1 = j1 - l + 1;
        int i2 = k1 - i1 + 1;
        int[] aint = this.field_76944_d.func_75904_a(l, i1, l1, i2);
        ChunkPosition chunkposition = null;
        int j2 = 0;

        for (int k2 = 0; k2 < l1 * i2; ++k2)
        {
            int l2 = l + k2 % l1 << 2;
            int i3 = i1 + k2 / l1 << 2;
            BiomeGenBase biomegenbase = BiomeGenBase.field_76773_a[aint[k2]];

            if (p_76941_4_.contains(biomegenbase) && (chunkposition == null || p_76941_5_.nextInt(j2 + 1) == 0))
            {
                chunkposition = new ChunkPosition(l2, 0, i3);
                ++j2;
            }
        }

        return chunkposition;
    }

    public void func_76938_b()
    {
        this.field_76942_f.func_76838_a();
    }
}
