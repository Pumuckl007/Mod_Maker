package net.minecraft.world.chunk.storage;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.NibbleArray;

public class ChunkLoader
{
    public static AnvilConverterData func_76691_a(NBTTagCompound p_76691_0_)
    {
        int i = p_76691_0_.func_74762_e("xPos");
        int j = p_76691_0_.func_74762_e("zPos");
        AnvilConverterData anvilconverterdata = new AnvilConverterData(i, j);
        anvilconverterdata.field_76693_g = p_76691_0_.func_74770_j("Blocks");
        anvilconverterdata.field_76692_f = new NibbleArrayReader(p_76691_0_.func_74770_j("Data"), 7);
        anvilconverterdata.field_76695_e = new NibbleArrayReader(p_76691_0_.func_74770_j("SkyLight"), 7);
        anvilconverterdata.field_76694_d = new NibbleArrayReader(p_76691_0_.func_74770_j("BlockLight"), 7);
        anvilconverterdata.field_76697_c = p_76691_0_.func_74770_j("HeightMap");
        anvilconverterdata.field_76696_b = p_76691_0_.func_74767_n("TerrainPopulated");
        anvilconverterdata.field_76702_h = p_76691_0_.func_74761_m("Entities");
        anvilconverterdata.field_76703_i = p_76691_0_.func_74761_m("TileEntities");
        anvilconverterdata.field_76700_j = p_76691_0_.func_74761_m("TileTicks");

        try
        {
            anvilconverterdata.field_76698_a = p_76691_0_.func_74763_f("LastUpdate");
        }
        catch (ClassCastException classcastexception)
        {
            anvilconverterdata.field_76698_a = (long)p_76691_0_.func_74762_e("LastUpdate");
        }

        return anvilconverterdata;
    }

    public static void func_76690_a(AnvilConverterData p_76690_0_, NBTTagCompound p_76690_1_, WorldChunkManager p_76690_2_)
    {
        p_76690_1_.func_74768_a("xPos", p_76690_0_.field_76701_k);
        p_76690_1_.func_74768_a("zPos", p_76690_0_.field_76699_l);
        p_76690_1_.func_74772_a("LastUpdate", p_76690_0_.field_76698_a);
        int[] aint = new int[p_76690_0_.field_76697_c.length];

        for (int i = 0; i < p_76690_0_.field_76697_c.length; ++i)
        {
            aint[i] = p_76690_0_.field_76697_c[i];
        }

        p_76690_1_.func_74783_a("HeightMap", aint);
        p_76690_1_.func_74757_a("TerrainPopulated", p_76690_0_.field_76696_b);
        NBTTagList nbttaglist = new NBTTagList("Sections");
        int j;

        for (int k = 0; k < 8; ++k)
        {
            boolean flag = true;

            for (j = 0; j < 16 && flag; ++j)
            {
                int l = 0;

                while (l < 16 && flag)
                {
                    int i1 = 0;

                    while (true)
                    {
                        if (i1 < 16)
                        {
                            int j1 = j << 11 | i1 << 7 | l + (k << 4);
                            byte b0 = p_76690_0_.field_76693_g[j1];

                            if (b0 == 0)
                            {
                                ++i1;
                                continue;
                            }

                            flag = false;
                        }

                        ++l;
                        break;
                    }
                }
            }

            if (!flag)
            {
                byte[] abyte = new byte[4096];
                NibbleArray nibblearray = new NibbleArray(abyte.length, 4);
                NibbleArray nibblearray1 = new NibbleArray(abyte.length, 4);
                NibbleArray nibblearray2 = new NibbleArray(abyte.length, 4);

                for (int k1 = 0; k1 < 16; ++k1)
                {
                    for (int l1 = 0; l1 < 16; ++l1)
                    {
                        for (int i2 = 0; i2 < 16; ++i2)
                        {
                            int j2 = k1 << 11 | i2 << 7 | l1 + (k << 4);
                            byte b1 = p_76690_0_.field_76693_g[j2];
                            abyte[l1 << 8 | i2 << 4 | k1] = (byte)(b1 & 255);
                            nibblearray.func_76581_a(k1, l1, i2, p_76690_0_.field_76692_f.func_76686_a(k1, l1 + (k << 4), i2));
                            nibblearray1.func_76581_a(k1, l1, i2, p_76690_0_.field_76695_e.func_76686_a(k1, l1 + (k << 4), i2));
                            nibblearray2.func_76581_a(k1, l1, i2, p_76690_0_.field_76694_d.func_76686_a(k1, l1 + (k << 4), i2));
                        }
                    }
                }

                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.func_74774_a("Y", (byte)(k & 255));
                nbttagcompound1.func_74773_a("Blocks", abyte);
                nbttagcompound1.func_74773_a("Data", nibblearray.field_76585_a);
                nbttagcompound1.func_74773_a("SkyLight", nibblearray1.field_76585_a);
                nbttagcompound1.func_74773_a("BlockLight", nibblearray2.field_76585_a);
                nbttaglist.func_74742_a(nbttagcompound1);
            }
        }

        p_76690_1_.func_74782_a("Sections", nbttaglist);
        byte[] abyte1 = new byte[256];

        for (int k2 = 0; k2 < 16; ++k2)
        {
            for (j = 0; j < 16; ++j)
            {
                abyte1[j << 4 | k2] = (byte)(p_76690_2_.func_76935_a(p_76690_0_.field_76701_k << 4 | k2, p_76690_0_.field_76699_l << 4 | j).field_76756_M & 255);
            }
        }

        p_76690_1_.func_74773_a("Biomes", abyte1);
        p_76690_1_.func_74782_a("Entities", p_76690_0_.field_76702_h);
        p_76690_1_.func_74782_a("TileEntities", p_76690_0_.field_76703_i);

        if (p_76690_0_.field_76700_j != null)
        {
            p_76690_1_.func_74782_a("TileTicks", p_76690_0_.field_76700_j);
        }
    }
}
