package net.minecraft.world.gen.structure;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ReportedException;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.gen.MapGenBase;

public abstract class MapGenStructure extends MapGenBase
{
    private MapGenStructureData field_143029_e;
    protected Map field_75053_d = new HashMap();

    public abstract String func_143025_a();

    protected final void func_75037_a(World p_75037_1_, int p_75037_2_, int p_75037_3_, int p_75037_4_, int p_75037_5_, byte[] p_75037_6_)
    {
        this.func_143027_a(p_75037_1_);

        if (!this.field_75053_d.containsKey(Long.valueOf(ChunkCoordIntPair.func_77272_a(p_75037_2_, p_75037_3_))))
        {
            this.field_75038_b.nextInt();

            try
            {
                if (this.func_75047_a(p_75037_2_, p_75037_3_))
                {
                    StructureStart structurestart = this.func_75049_b(p_75037_2_, p_75037_3_);
                    this.field_75053_d.put(Long.valueOf(ChunkCoordIntPair.func_77272_a(p_75037_2_, p_75037_3_)), structurestart);
                    this.func_143026_a(p_75037_2_, p_75037_3_, structurestart);
                }
            }
            catch (Throwable throwable)
            {
                CrashReport crashreport = CrashReport.func_85055_a(throwable, "Exception preparing structure feature");
                CrashReportCategory crashreportcategory = crashreport.func_85058_a("Feature being prepared");
                crashreportcategory.func_71500_a("Is feature chunk", new CallableIsFeatureChunk(this, p_75037_2_, p_75037_3_));
                crashreportcategory.func_71507_a("Chunk location", String.format("%d,%d", new Object[] {Integer.valueOf(p_75037_2_), Integer.valueOf(p_75037_3_)}));
                crashreportcategory.func_71500_a("Chunk pos hash", new CallableChunkPosHash(this, p_75037_2_, p_75037_3_));
                crashreportcategory.func_71500_a("Structure type", new CallableStructureType(this));
                throw new ReportedException(crashreport);
            }
        }
    }

    public boolean func_75051_a(World p_75051_1_, Random p_75051_2_, int p_75051_3_, int p_75051_4_)
    {
        this.func_143027_a(p_75051_1_);
        int k = (p_75051_3_ << 4) + 8;
        int l = (p_75051_4_ << 4) + 8;
        boolean flag = false;
        Iterator iterator = this.field_75053_d.values().iterator();

        while (iterator.hasNext())
        {
            StructureStart structurestart = (StructureStart)iterator.next();

            if (structurestart.func_75069_d() && structurestart.func_75071_a().func_78885_a(k, l, k + 15, l + 15))
            {
                structurestart.func_75068_a(p_75051_1_, p_75051_2_, new StructureBoundingBox(k, l, k + 15, l + 15));
                flag = true;
                this.func_143026_a(structurestart.func_143019_e(), structurestart.func_143018_f(), structurestart);
            }
        }

        return flag;
    }

    public boolean func_75048_a(int p_75048_1_, int p_75048_2_, int p_75048_3_)
    {
        this.func_143027_a(this.field_75039_c);
        return this.func_143028_c(p_75048_1_, p_75048_2_, p_75048_3_) != null;
    }

    protected StructureStart func_143028_c(int p_143028_1_, int p_143028_2_, int p_143028_3_)
    {
        Iterator iterator = this.field_75053_d.values().iterator();

        while (iterator.hasNext())
        {
            StructureStart structurestart = (StructureStart)iterator.next();

            if (structurestart.func_75069_d() && structurestart.func_75071_a().func_78885_a(p_143028_1_, p_143028_3_, p_143028_1_, p_143028_3_))
            {
                Iterator iterator1 = structurestart.func_75073_b().iterator();

                while (iterator1.hasNext())
                {
                    StructureComponent structurecomponent = (StructureComponent)iterator1.next();

                    if (structurecomponent.func_74874_b().func_78890_b(p_143028_1_, p_143028_2_, p_143028_3_))
                    {
                        return structurestart;
                    }
                }
            }
        }

        return null;
    }

    public boolean func_142038_b(int p_142038_1_, int p_142038_2_, int p_142038_3_)
    {
        this.func_143027_a(this.field_75039_c);
        Iterator iterator = this.field_75053_d.values().iterator();
        StructureStart structurestart;

        do
        {
            if (!iterator.hasNext())
            {
                return false;
            }

            structurestart = (StructureStart)iterator.next();
        }
        while (!structurestart.func_75069_d());

        return structurestart.func_75071_a().func_78885_a(p_142038_1_, p_142038_3_, p_142038_1_, p_142038_3_);
    }

    public ChunkPosition func_75050_a(World p_75050_1_, int p_75050_2_, int p_75050_3_, int p_75050_4_)
    {
        this.field_75039_c = p_75050_1_;
        this.func_143027_a(p_75050_1_);
        this.field_75038_b.setSeed(p_75050_1_.func_72905_C());
        long l = this.field_75038_b.nextLong();
        long i1 = this.field_75038_b.nextLong();
        long j1 = (long)(p_75050_2_ >> 4) * l;
        long k1 = (long)(p_75050_4_ >> 4) * i1;
        this.field_75038_b.setSeed(j1 ^ k1 ^ p_75050_1_.func_72905_C());
        this.func_75037_a(p_75050_1_, p_75050_2_ >> 4, p_75050_4_ >> 4, 0, 0, (byte[])null);
        double d0 = Double.MAX_VALUE;
        ChunkPosition chunkposition = null;
        Iterator iterator = this.field_75053_d.values().iterator();
        ChunkPosition chunkposition1;
        int l1;
        int i2;
        double d1;
        int j2;

        while (iterator.hasNext())
        {
            StructureStart structurestart = (StructureStart)iterator.next();

            if (structurestart.func_75069_d())
            {
                StructureComponent structurecomponent = (StructureComponent)structurestart.func_75073_b().get(0);
                chunkposition1 = structurecomponent.func_74868_a();
                i2 = chunkposition1.field_76930_a - p_75050_2_;
                l1 = chunkposition1.field_76928_b - p_75050_3_;
                j2 = chunkposition1.field_76929_c - p_75050_4_;
                d1 = (double)(i2 * i2 + l1 * l1 + j2 * j2);

                if (d1 < d0)
                {
                    d0 = d1;
                    chunkposition = chunkposition1;
                }
            }
        }

        if (chunkposition != null)
        {
            return chunkposition;
        }
        else
        {
            List list = this.func_75052_o_();

            if (list != null)
            {
                ChunkPosition chunkposition2 = null;
                Iterator iterator1 = list.iterator();

                while (iterator1.hasNext())
                {
                    chunkposition1 = (ChunkPosition)iterator1.next();
                    i2 = chunkposition1.field_76930_a - p_75050_2_;
                    l1 = chunkposition1.field_76928_b - p_75050_3_;
                    j2 = chunkposition1.field_76929_c - p_75050_4_;
                    d1 = (double)(i2 * i2 + l1 * l1 + j2 * j2);

                    if (d1 < d0)
                    {
                        d0 = d1;
                        chunkposition2 = chunkposition1;
                    }
                }

                return chunkposition2;
            }
            else
            {
                return null;
            }
        }
    }

    protected List func_75052_o_()
    {
        return null;
    }

    private void func_143027_a(World p_143027_1_)
    {
        if (this.field_143029_e == null)
        {
            this.field_143029_e = (MapGenStructureData)p_143027_1_.func_72943_a(MapGenStructureData.class, this.func_143025_a());

            if (this.field_143029_e == null)
            {
                this.field_143029_e = new MapGenStructureData(this.func_143025_a());
                p_143027_1_.func_72823_a(this.func_143025_a(), this.field_143029_e);
            }
            else
            {
                NBTTagCompound nbttagcompound = this.field_143029_e.func_143041_a();
                Iterator iterator = nbttagcompound.func_74758_c().iterator();

                while (iterator.hasNext())
                {
                    NBTBase nbtbase = (NBTBase)iterator.next();

                    if (nbtbase.func_74732_a() == 10)
                    {
                        NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbtbase;

                        if (nbttagcompound1.func_74764_b("ChunkX") && nbttagcompound1.func_74764_b("ChunkZ"))
                        {
                            int i = nbttagcompound1.func_74762_e("ChunkX");
                            int j = nbttagcompound1.func_74762_e("ChunkZ");
                            StructureStart structurestart = MapGenStructureIO.func_143035_a(nbttagcompound1, p_143027_1_);
                            this.field_75053_d.put(Long.valueOf(ChunkCoordIntPair.func_77272_a(i, j)), structurestart);
                        }
                    }
                }
            }
        }
    }

    private void func_143026_a(int p_143026_1_, int p_143026_2_, StructureStart p_143026_3_)
    {
        this.field_143029_e.func_143043_a(p_143026_3_.func_143021_a(p_143026_1_, p_143026_2_), p_143026_1_, p_143026_2_);
        this.field_143029_e.func_76185_a();
    }

    protected abstract boolean func_75047_a(int i, int j);

    protected abstract StructureStart func_75049_b(int i, int j);
}
