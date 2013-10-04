package net.minecraft.world.gen.structure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.biome.BiomeGenBase;

public class MapGenStronghold extends MapGenStructure
{
    private BiomeGenBase[] field_75058_e;
    private boolean field_75056_f;
    private ChunkCoordIntPair[] field_75057_g;
    private double field_82671_h;
    private int field_82672_i;

    public MapGenStronghold()
    {
        this.field_75058_e = new BiomeGenBase[] {BiomeGenBase.field_76769_d, BiomeGenBase.field_76767_f, BiomeGenBase.field_76770_e, BiomeGenBase.field_76780_h, BiomeGenBase.field_76768_g, BiomeGenBase.field_76774_n, BiomeGenBase.field_76775_o, BiomeGenBase.field_76786_s, BiomeGenBase.field_76785_t, BiomeGenBase.field_76783_v, BiomeGenBase.field_76782_w, BiomeGenBase.field_76792_x};
        this.field_75057_g = new ChunkCoordIntPair[3];
        this.field_82671_h = 32.0D;
        this.field_82672_i = 3;
    }

    public MapGenStronghold(Map p_i2068_1_)
    {
        this.field_75058_e = new BiomeGenBase[] {BiomeGenBase.field_76769_d, BiomeGenBase.field_76767_f, BiomeGenBase.field_76770_e, BiomeGenBase.field_76780_h, BiomeGenBase.field_76768_g, BiomeGenBase.field_76774_n, BiomeGenBase.field_76775_o, BiomeGenBase.field_76786_s, BiomeGenBase.field_76785_t, BiomeGenBase.field_76783_v, BiomeGenBase.field_76782_w, BiomeGenBase.field_76792_x};
        this.field_75057_g = new ChunkCoordIntPair[3];
        this.field_82671_h = 32.0D;
        this.field_82672_i = 3;
        Iterator iterator = p_i2068_1_.entrySet().iterator();

        while (iterator.hasNext())
        {
            Entry entry = (Entry)iterator.next();

            if (((String)entry.getKey()).equals("distance"))
            {
                this.field_82671_h = MathHelper.func_82713_a((String)entry.getValue(), this.field_82671_h, 1.0D);
            }
            else if (((String)entry.getKey()).equals("count"))
            {
                this.field_75057_g = new ChunkCoordIntPair[MathHelper.func_82714_a((String)entry.getValue(), this.field_75057_g.length, 1)];
            }
            else if (((String)entry.getKey()).equals("spread"))
            {
                this.field_82672_i = MathHelper.func_82714_a((String)entry.getValue(), this.field_82672_i, 1);
            }
        }
    }

    public String func_143025_a()
    {
        return "Stronghold";
    }

    protected boolean func_75047_a(int p_75047_1_, int p_75047_2_)
    {
        if (!this.field_75056_f)
        {
            Random random = new Random();
            random.setSeed(this.field_75039_c.func_72905_C());
            double d0 = random.nextDouble() * Math.PI * 2.0D;
            int k = 1;

            for (int l = 0; l < this.field_75057_g.length; ++l)
            {
                double d1 = (1.25D * (double)k + random.nextDouble()) * this.field_82671_h * (double)k;
                int i1 = (int)Math.round(Math.cos(d0) * d1);
                int j1 = (int)Math.round(Math.sin(d0) * d1);
                ArrayList arraylist = new ArrayList();
                Collections.addAll(arraylist, this.field_75058_e);
                ChunkPosition chunkposition = this.field_75039_c.func_72959_q().func_76941_a((i1 << 4) + 8, (j1 << 4) + 8, 112, arraylist, random);

                if (chunkposition != null)
                {
                    i1 = chunkposition.field_76930_a >> 4;
                    j1 = chunkposition.field_76929_c >> 4;
                }

                this.field_75057_g[l] = new ChunkCoordIntPair(i1, j1);
                d0 += (Math.PI * 2D) * (double)k / (double)this.field_82672_i;

                if (l == this.field_82672_i)
                {
                    k += 2 + random.nextInt(5);
                    this.field_82672_i += 1 + random.nextInt(2);
                }
            }

            this.field_75056_f = true;
        }

        ChunkCoordIntPair[] achunkcoordintpair = this.field_75057_g;
        int k1 = achunkcoordintpair.length;

        for (int l1 = 0; l1 < k1; ++l1)
        {
            ChunkCoordIntPair chunkcoordintpair = achunkcoordintpair[l1];

            if (p_75047_1_ == chunkcoordintpair.field_77276_a && p_75047_2_ == chunkcoordintpair.field_77275_b)
            {
                return true;
            }
        }

        return false;
    }

    protected List func_75052_o_()
    {
        ArrayList arraylist = new ArrayList();
        ChunkCoordIntPair[] achunkcoordintpair = this.field_75057_g;
        int i = achunkcoordintpair.length;

        for (int j = 0; j < i; ++j)
        {
            ChunkCoordIntPair chunkcoordintpair = achunkcoordintpair[j];

            if (chunkcoordintpair != null)
            {
                arraylist.add(chunkcoordintpair.func_77271_a(64));
            }
        }

        return arraylist;
    }

    protected StructureStart func_75049_b(int p_75049_1_, int p_75049_2_)
    {
        StructureStrongholdStart structurestrongholdstart;

        for (structurestrongholdstart = new StructureStrongholdStart(this.field_75039_c, this.field_75038_b, p_75049_1_, p_75049_2_); structurestrongholdstart.func_75073_b().isEmpty() || ((ComponentStrongholdStairs2)structurestrongholdstart.func_75073_b().get(0)).field_75025_b == null; structurestrongholdstart = new StructureStrongholdStart(this.field_75039_c, this.field_75038_b, p_75049_1_, p_75049_2_))
        {
            ;
        }

        return structurestrongholdstart;
    }
}
