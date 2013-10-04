package net.minecraft.world.biome;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.LongHashMap;

public class BiomeCache
{
    private final WorldChunkManager field_76844_a;
    private long field_76842_b;
    private LongHashMap field_76843_c = new LongHashMap();
    private List field_76841_d = new ArrayList();

    public BiomeCache(WorldChunkManager p_i1973_1_)
    {
        this.field_76844_a = p_i1973_1_;
    }

    public BiomeCacheBlock func_76840_a(int p_76840_1_, int p_76840_2_)
    {
        p_76840_1_ >>= 4;
        p_76840_2_ >>= 4;
        long k = (long)p_76840_1_ & 4294967295L | ((long)p_76840_2_ & 4294967295L) << 32;
        BiomeCacheBlock biomecacheblock = (BiomeCacheBlock)this.field_76843_c.func_76164_a(k);

        if (biomecacheblock == null)
        {
            biomecacheblock = new BiomeCacheBlock(this, p_76840_1_, p_76840_2_);
            this.field_76843_c.func_76163_a(k, biomecacheblock);
            this.field_76841_d.add(biomecacheblock);
        }

        biomecacheblock.field_76886_f = MinecraftServer.func_130071_aq();
        return biomecacheblock;
    }

    public BiomeGenBase func_76837_b(int p_76837_1_, int p_76837_2_)
    {
        return this.func_76840_a(p_76837_1_, p_76837_2_).func_76885_a(p_76837_1_, p_76837_2_);
    }

    public void func_76838_a()
    {
        long i = MinecraftServer.func_130071_aq();
        long j = i - this.field_76842_b;

        if (j > 7500L || j < 0L)
        {
            this.field_76842_b = i;

            for (int k = 0; k < this.field_76841_d.size(); ++k)
            {
                BiomeCacheBlock biomecacheblock = (BiomeCacheBlock)this.field_76841_d.get(k);
                long l = i - biomecacheblock.field_76886_f;

                if (l > 30000L || l < 0L)
                {
                    this.field_76841_d.remove(k--);
                    long i1 = (long)biomecacheblock.field_76888_d & 4294967295L | ((long)biomecacheblock.field_76889_e & 4294967295L) << 32;
                    this.field_76843_c.func_76159_d(i1);
                }
            }
        }
    }

    public BiomeGenBase[] func_76839_e(int p_76839_1_, int p_76839_2_)
    {
        return this.func_76840_a(p_76839_1_, p_76839_2_).field_76891_c;
    }

    static WorldChunkManager func_76836_a(BiomeCache p_76836_0_)
    {
        return p_76836_0_.field_76844_a;
    }
}
