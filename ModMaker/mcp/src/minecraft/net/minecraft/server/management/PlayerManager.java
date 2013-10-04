package net.minecraft.server.management;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.LongHashMap;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldServer;

public class PlayerManager
{
    private final WorldServer field_72701_a;
    private final List field_72699_b = new ArrayList();
    private final LongHashMap field_72700_c = new LongHashMap();
    private final List field_72697_d = new ArrayList();
    private final List field_111193_e = new ArrayList();
    private final int field_72698_e;
    private long field_111192_g;
    private final int[][] field_72696_f = new int[][] {{1, 0}, {0, 1}, { -1, 0}, {0, -1}};

    public PlayerManager(WorldServer p_i1519_1_, int p_i1519_2_)
    {
        if (p_i1519_2_ > 15)
        {
            throw new IllegalArgumentException("Too big view radius!");
        }
        else if (p_i1519_2_ < 3)
        {
            throw new IllegalArgumentException("Too small view radius!");
        }
        else
        {
            this.field_72698_e = p_i1519_2_;
            this.field_72701_a = p_i1519_1_;
        }
    }

    public WorldServer func_72688_a()
    {
        return this.field_72701_a;
    }

    public void func_72693_b()
    {
        long i = this.field_72701_a.func_82737_E();
        int j;
        PlayerInstance playerinstance;

        if (i - this.field_111192_g > 8000L)
        {
            this.field_111192_g = i;

            for (j = 0; j < this.field_111193_e.size(); ++j)
            {
                playerinstance = (PlayerInstance)this.field_111193_e.get(j);
                playerinstance.func_73254_a();
                playerinstance.func_111194_a();
            }
        }
        else
        {
            for (j = 0; j < this.field_72697_d.size(); ++j)
            {
                playerinstance = (PlayerInstance)this.field_72697_d.get(j);
                playerinstance.func_73254_a();
            }
        }

        this.field_72697_d.clear();

        if (this.field_72699_b.isEmpty())
        {
            WorldProvider worldprovider = this.field_72701_a.field_73011_w;

            if (!worldprovider.func_76567_e())
            {
                this.field_72701_a.field_73059_b.func_73240_a();
            }
        }
    }

    public PlayerInstance func_72690_a(int p_72690_1_, int p_72690_2_, boolean p_72690_3_)
    {
        long k = (long)p_72690_1_ + 2147483647L | (long)p_72690_2_ + 2147483647L << 32;
        PlayerInstance playerinstance = (PlayerInstance)this.field_72700_c.func_76164_a(k);

        if (playerinstance == null && p_72690_3_)
        {
            playerinstance = new PlayerInstance(this, p_72690_1_, p_72690_2_);
            this.field_72700_c.func_76163_a(k, playerinstance);
            this.field_111193_e.add(playerinstance);
        }

        return playerinstance;
    }

    public void func_72687_a(int p_72687_1_, int p_72687_2_, int p_72687_3_)
    {
        int l = p_72687_1_ >> 4;
        int i1 = p_72687_3_ >> 4;
        PlayerInstance playerinstance = this.func_72690_a(l, i1, false);

        if (playerinstance != null)
        {
            playerinstance.func_73259_a(p_72687_1_ & 15, p_72687_2_, p_72687_3_ & 15);
        }
    }

    public void func_72683_a(EntityPlayerMP p_72683_1_)
    {
        int i = (int)p_72683_1_.field_70165_t >> 4;
        int j = (int)p_72683_1_.field_70161_v >> 4;
        p_72683_1_.field_71131_d = p_72683_1_.field_70165_t;
        p_72683_1_.field_71132_e = p_72683_1_.field_70161_v;

        for (int k = i - this.field_72698_e; k <= i + this.field_72698_e; ++k)
        {
            for (int l = j - this.field_72698_e; l <= j + this.field_72698_e; ++l)
            {
                this.func_72690_a(k, l, true).func_73255_a(p_72683_1_);
            }
        }

        this.field_72699_b.add(p_72683_1_);
        this.func_72691_b(p_72683_1_);
    }

    public void func_72691_b(EntityPlayerMP p_72691_1_)
    {
        ArrayList arraylist = new ArrayList(p_72691_1_.field_71129_f);
        int i = 0;
        int j = this.field_72698_e;
        int k = (int)p_72691_1_.field_70165_t >> 4;
        int l = (int)p_72691_1_.field_70161_v >> 4;
        int i1 = 0;
        int j1 = 0;
        ChunkCoordIntPair chunkcoordintpair = PlayerInstance.func_73253_a(this.func_72690_a(k, l, true));
        p_72691_1_.field_71129_f.clear();

        if (arraylist.contains(chunkcoordintpair))
        {
            p_72691_1_.field_71129_f.add(chunkcoordintpair);
        }

        int k1;

        for (k1 = 1; k1 <= j * 2; ++k1)
        {
            for (int l1 = 0; l1 < 2; ++l1)
            {
                int[] aint = this.field_72696_f[i++ % 4];

                for (int i2 = 0; i2 < k1; ++i2)
                {
                    i1 += aint[0];
                    j1 += aint[1];
                    chunkcoordintpair = PlayerInstance.func_73253_a(this.func_72690_a(k + i1, l + j1, true));

                    if (arraylist.contains(chunkcoordintpair))
                    {
                        p_72691_1_.field_71129_f.add(chunkcoordintpair);
                    }
                }
            }
        }

        i %= 4;

        for (k1 = 0; k1 < j * 2; ++k1)
        {
            i1 += this.field_72696_f[i][0];
            j1 += this.field_72696_f[i][1];
            chunkcoordintpair = PlayerInstance.func_73253_a(this.func_72690_a(k + i1, l + j1, true));

            if (arraylist.contains(chunkcoordintpair))
            {
                p_72691_1_.field_71129_f.add(chunkcoordintpair);
            }
        }
    }

    public void func_72695_c(EntityPlayerMP p_72695_1_)
    {
        int i = (int)p_72695_1_.field_71131_d >> 4;
        int j = (int)p_72695_1_.field_71132_e >> 4;

        for (int k = i - this.field_72698_e; k <= i + this.field_72698_e; ++k)
        {
            for (int l = j - this.field_72698_e; l <= j + this.field_72698_e; ++l)
            {
                PlayerInstance playerinstance = this.func_72690_a(k, l, false);

                if (playerinstance != null)
                {
                    playerinstance.func_73252_b(p_72695_1_);
                }
            }
        }

        this.field_72699_b.remove(p_72695_1_);
    }

    private boolean func_72684_a(int p_72684_1_, int p_72684_2_, int p_72684_3_, int p_72684_4_, int p_72684_5_)
    {
        int j1 = p_72684_1_ - p_72684_3_;
        int k1 = p_72684_2_ - p_72684_4_;
        return j1 >= -p_72684_5_ && j1 <= p_72684_5_ ? k1 >= -p_72684_5_ && k1 <= p_72684_5_ : false;
    }

    public void func_72685_d(EntityPlayerMP p_72685_1_)
    {
        int i = (int)p_72685_1_.field_70165_t >> 4;
        int j = (int)p_72685_1_.field_70161_v >> 4;
        double d0 = p_72685_1_.field_71131_d - p_72685_1_.field_70165_t;
        double d1 = p_72685_1_.field_71132_e - p_72685_1_.field_70161_v;
        double d2 = d0 * d0 + d1 * d1;

        if (d2 >= 64.0D)
        {
            int k = (int)p_72685_1_.field_71131_d >> 4;
            int l = (int)p_72685_1_.field_71132_e >> 4;
            int i1 = this.field_72698_e;
            int j1 = i - k;
            int k1 = j - l;

            if (j1 != 0 || k1 != 0)
            {
                for (int l1 = i - i1; l1 <= i + i1; ++l1)
                {
                    for (int i2 = j - i1; i2 <= j + i1; ++i2)
                    {
                        if (!this.func_72684_a(l1, i2, k, l, i1))
                        {
                            this.func_72690_a(l1, i2, true).func_73255_a(p_72685_1_);
                        }

                        if (!this.func_72684_a(l1 - j1, i2 - k1, i, j, i1))
                        {
                            PlayerInstance playerinstance = this.func_72690_a(l1 - j1, i2 - k1, false);

                            if (playerinstance != null)
                            {
                                playerinstance.func_73252_b(p_72685_1_);
                            }
                        }
                    }
                }

                this.func_72691_b(p_72685_1_);
                p_72685_1_.field_71131_d = p_72685_1_.field_70165_t;
                p_72685_1_.field_71132_e = p_72685_1_.field_70161_v;
            }
        }
    }

    public boolean func_72694_a(EntityPlayerMP p_72694_1_, int p_72694_2_, int p_72694_3_)
    {
        PlayerInstance playerinstance = this.func_72690_a(p_72694_2_, p_72694_3_, false);
        return playerinstance == null ? false : PlayerInstance.func_73258_b(playerinstance).contains(p_72694_1_) && !p_72694_1_.field_71129_f.contains(PlayerInstance.func_73253_a(playerinstance));
    }

    public static int func_72686_a(int p_72686_0_)
    {
        return p_72686_0_ * 16 - 16;
    }

    static WorldServer func_72692_a(PlayerManager p_72692_0_)
    {
        return p_72692_0_.field_72701_a;
    }

    static LongHashMap func_72689_b(PlayerManager p_72689_0_)
    {
        return p_72689_0_.field_72700_c;
    }

    static List func_111191_d(PlayerManager p_111191_0_)
    {
        return p_111191_0_.field_111193_e;
    }

    static List func_72682_c(PlayerManager p_72682_0_)
    {
        return p_72682_0_.field_72697_d;
    }
}
