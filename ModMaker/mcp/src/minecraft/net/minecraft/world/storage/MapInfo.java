package net.minecraft.world.storage;

import java.util.Iterator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class MapInfo
{
    public final EntityPlayer field_76211_a;
    public int[] field_76209_b;
    public int[] field_76210_c;
    private int field_76208_e;
    private int field_76205_f;
    private byte[] field_76206_g;
    public int field_82569_d;
    private boolean field_82570_i;

    final MapData field_76207_d;

    public MapInfo(MapData p_i2138_1_, EntityPlayer p_i2138_2_)
    {
        this.field_76207_d = p_i2138_1_;
        this.field_76209_b = new int[128];
        this.field_76210_c = new int[128];
        this.field_76211_a = p_i2138_2_;

        for (int i = 0; i < this.field_76209_b.length; ++i)
        {
            this.field_76209_b[i] = 0;
            this.field_76210_c[i] = 127;
        }
    }

    public byte[] func_76204_a(ItemStack p_76204_1_)
    {
        byte[] abyte;

        if (!this.field_82570_i)
        {
            abyte = new byte[] {(byte)2, this.field_76207_d.field_76197_d};
            this.field_82570_i = true;
            return abyte;
        }
        else
        {
            int i;
            int j;

            if (--this.field_76205_f < 0)
            {
                this.field_76205_f = 4;
                abyte = new byte[this.field_76207_d.field_76203_h.size() * 3 + 1];
                abyte[0] = 1;
                i = 0;

                for (Iterator iterator = this.field_76207_d.field_76203_h.values().iterator(); iterator.hasNext(); ++i)
                {
                    MapCoord mapcoord = (MapCoord)iterator.next();
                    abyte[i * 3 + 1] = (byte)(mapcoord.field_76216_a << 4 | mapcoord.field_76212_d & 15);
                    abyte[i * 3 + 2] = mapcoord.field_76214_b;
                    abyte[i * 3 + 3] = mapcoord.field_76215_c;
                }

                boolean flag = !p_76204_1_.func_82839_y();

                if (this.field_76206_g != null && this.field_76206_g.length == abyte.length)
                {
                    for (j = 0; j < abyte.length; ++j)
                    {
                        if (abyte[j] != this.field_76206_g[j])
                        {
                            flag = false;
                            break;
                        }
                    }
                }
                else
                {
                    flag = false;
                }

                if (!flag)
                {
                    this.field_76206_g = abyte;
                    return abyte;
                }
            }

            for (int k = 0; k < 1; ++k)
            {
                i = this.field_76208_e++ * 11 % 128;

                if (this.field_76209_b[i] >= 0)
                {
                    int l = this.field_76210_c[i] - this.field_76209_b[i] + 1;
                    j = this.field_76209_b[i];
                    byte[] abyte1 = new byte[l + 3];
                    abyte1[0] = 0;
                    abyte1[1] = (byte)i;
                    abyte1[2] = (byte)j;

                    for (int i1 = 0; i1 < abyte1.length - 3; ++i1)
                    {
                        abyte1[i1 + 3] = this.field_76207_d.field_76198_e[(i1 + j) * 128 + i];
                    }

                    this.field_76210_c[i] = -1;
                    this.field_76209_b[i] = -1;
                    return abyte1;
                }
            }

            return null;
        }
    }
}
