package net.minecraft.world;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEventData;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityTracker;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.INpc;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.logging.ILogAgent;
import net.minecraft.network.packet.Packet38EntityStatus;
import net.minecraft.network.packet.Packet54PlayNoteBlock;
import net.minecraft.network.packet.Packet60Explosion;
import net.minecraft.network.packet.Packet70GameEvent;
import net.minecraft.network.packet.Packet71Weather;
import net.minecraft.profiler.Profiler;
import net.minecraft.scoreboard.ScoreboardSaveData;
import net.minecraft.scoreboard.ServerScoreboard;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerManager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.IntHashMap;
import net.minecraft.util.ReportedException;
import net.minecraft.util.Vec3;
import net.minecraft.util.WeightedRandom;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;
import net.minecraft.world.chunk.storage.IChunkLoader;
import net.minecraft.world.gen.ChunkProviderServer;
import net.minecraft.world.gen.feature.WorldGeneratorBonusChest;
import net.minecraft.world.storage.ISaveHandler;

public class WorldServer extends World
{
    private final MinecraftServer field_73061_a;
    private final EntityTracker field_73062_L;
    private final PlayerManager field_73063_M;
    private Set field_73064_N;
    private TreeSet field_73065_O;
    public ChunkProviderServer field_73059_b;
    public boolean field_73058_d;
    public boolean field_73068_P;
    private int field_80004_Q;
    private final Teleporter field_85177_Q;
    private final SpawnerAnimals field_135059_Q = new SpawnerAnimals();
    private ServerBlockEventList[] field_73067_Q = new ServerBlockEventList[] {new ServerBlockEventList((ServerBlockEvent)null), new ServerBlockEventList((ServerBlockEvent)null)};
    private int field_73070_R;
    public static final WeightedRandomChestContent[] field_73069_S = new WeightedRandomChestContent[] {new WeightedRandomChestContent(Item.field_77669_D.field_77779_bT, 0, 1, 3, 10), new WeightedRandomChestContent(Block.field_71988_x.field_71990_ca, 0, 1, 3, 10), new WeightedRandomChestContent(Block.field_71951_J.field_71990_ca, 0, 1, 3, 10), new WeightedRandomChestContent(Item.field_77719_y.field_77779_bT, 0, 1, 1, 3), new WeightedRandomChestContent(Item.field_77712_u.field_77779_bT, 0, 1, 1, 5), new WeightedRandomChestContent(Item.field_77720_x.field_77779_bT, 0, 1, 1, 3), new WeightedRandomChestContent(Item.field_77713_t.field_77779_bT, 0, 1, 1, 5), new WeightedRandomChestContent(Item.field_77706_j.field_77779_bT, 0, 2, 3, 5), new WeightedRandomChestContent(Item.field_77684_U.field_77779_bT, 0, 2, 3, 3)};
    private List field_94579_S = new ArrayList();
    private IntHashMap field_73066_T;

    public WorldServer(MinecraftServer p_i1522_1_, ISaveHandler p_i1522_2_, String p_i1522_3_, int p_i1522_4_, WorldSettings p_i1522_5_, Profiler p_i1522_6_, ILogAgent p_i1522_7_)
    {
        super(p_i1522_2_, p_i1522_3_, p_i1522_5_, WorldProvider.func_76570_a(p_i1522_4_), p_i1522_6_, p_i1522_7_);
        this.field_73061_a = p_i1522_1_;
        this.field_73062_L = new EntityTracker(this);
        this.field_73063_M = new PlayerManager(this, p_i1522_1_.func_71203_ab().func_72395_o());

        if (this.field_73066_T == null)
        {
            this.field_73066_T = new IntHashMap();
        }

        if (this.field_73064_N == null)
        {
            this.field_73064_N = new HashSet();
        }

        if (this.field_73065_O == null)
        {
            this.field_73065_O = new TreeSet();
        }

        this.field_85177_Q = new Teleporter(this);
        this.field_96442_D = new ServerScoreboard(p_i1522_1_);
        ScoreboardSaveData scoreboardsavedata = (ScoreboardSaveData)this.field_72988_C.func_75742_a(ScoreboardSaveData.class, "scoreboard");

        if (scoreboardsavedata == null)
        {
            scoreboardsavedata = new ScoreboardSaveData();
            this.field_72988_C.func_75745_a("scoreboard", scoreboardsavedata);
        }

        scoreboardsavedata.func_96499_a(this.field_96442_D);
        ((ServerScoreboard)this.field_96442_D).func_96547_a(scoreboardsavedata);
    }

    public void func_72835_b()
    {
        super.func_72835_b();

        if (this.func_72912_H().func_76093_s() && this.field_73013_u < 3)
        {
            this.field_73013_u = 3;
        }

        this.field_73011_w.field_76578_c.func_76938_b();

        if (this.func_73056_e())
        {
            if (this.func_82736_K().func_82766_b("doDaylightCycle"))
            {
                long i = this.field_72986_A.func_76073_f() + 24000L;
                this.field_72986_A.func_76068_b(i - i % 24000L);
            }

            this.func_73053_d();
        }

        this.field_72984_F.func_76320_a("mobSpawner");

        if (this.func_82736_K().func_82766_b("doMobSpawning"))
        {
            this.field_135059_Q.func_77192_a(this, this.field_72985_G, this.field_72992_H, this.field_72986_A.func_82573_f() % 400L == 0L);
        }

        this.field_72984_F.func_76318_c("chunkSource");
        this.field_73020_y.func_73156_b();
        int j = this.func_72967_a(1.0F);

        if (j != this.field_73008_k)
        {
            this.field_73008_k = j;
        }

        this.field_72986_A.func_82572_b(this.field_72986_A.func_82573_f() + 1L);

        if (this.func_82736_K().func_82766_b("doDaylightCycle"))
        {
            this.field_72986_A.func_76068_b(this.field_72986_A.func_76073_f() + 1L);
        }

        this.field_72984_F.func_76318_c("tickPending");
        this.func_72955_a(false);
        this.field_72984_F.func_76318_c("tickTiles");
        this.func_72893_g();
        this.field_72984_F.func_76318_c("chunkMap");
        this.field_73063_M.func_72693_b();
        this.field_72984_F.func_76318_c("village");
        this.field_72982_D.func_75544_a();
        this.field_72983_E.func_75528_a();
        this.field_72984_F.func_76318_c("portalForcer");
        this.field_85177_Q.func_85189_a(this.func_82737_E());
        this.field_72984_F.func_76319_b();
        this.func_73055_Q();
    }

    public SpawnListEntry func_73057_a(EnumCreatureType p_73057_1_, int p_73057_2_, int p_73057_3_, int p_73057_4_)
    {
        List list = this.func_72863_F().func_73155_a(p_73057_1_, p_73057_2_, p_73057_3_, p_73057_4_);
        return list != null && !list.isEmpty() ? (SpawnListEntry)WeightedRandom.func_76271_a(this.field_73012_v, list) : null;
    }

    public void func_72854_c()
    {
        this.field_73068_P = !this.field_73010_i.isEmpty();
        Iterator iterator = this.field_73010_i.iterator();

        while (iterator.hasNext())
        {
            EntityPlayer entityplayer = (EntityPlayer)iterator.next();

            if (!entityplayer.func_70608_bn())
            {
                this.field_73068_P = false;
                break;
            }
        }
    }

    protected void func_73053_d()
    {
        this.field_73068_P = false;
        Iterator iterator = this.field_73010_i.iterator();

        while (iterator.hasNext())
        {
            EntityPlayer entityplayer = (EntityPlayer)iterator.next();

            if (entityplayer.func_70608_bn())
            {
                entityplayer.func_70999_a(false, false, true);
            }
        }

        this.func_73051_P();
    }

    private void func_73051_P()
    {
        this.field_72986_A.func_76080_g(0);
        this.field_72986_A.func_76084_b(false);
        this.field_72986_A.func_76090_f(0);
        this.field_72986_A.func_76069_a(false);
    }

    public boolean func_73056_e()
    {
        if (this.field_73068_P && !this.field_72995_K)
        {
            Iterator iterator = this.field_73010_i.iterator();
            EntityPlayer entityplayer;

            do
            {
                if (!iterator.hasNext())
                {
                    return true;
                }

                entityplayer = (EntityPlayer)iterator.next();
            }
            while (entityplayer.func_71026_bH());

            return false;
        }
        else
        {
            return false;
        }
    }

    @SideOnly(Side.CLIENT)
    public void func_72974_f()
    {
        if (this.field_72986_A.func_76075_d() <= 0)
        {
            this.field_72986_A.func_76056_b(64);
        }

        int i = this.field_72986_A.func_76079_c();
        int j = this.field_72986_A.func_76074_e();
        int k = 0;

        while (this.func_72922_b(i, j) == 0)
        {
            i += this.field_73012_v.nextInt(8) - this.field_73012_v.nextInt(8);
            j += this.field_73012_v.nextInt(8) - this.field_73012_v.nextInt(8);
            ++k;

            if (k == 10000)
            {
                break;
            }
        }

        this.field_72986_A.func_76058_a(i);
        this.field_72986_A.func_76087_c(j);
    }

    protected void func_72893_g()
    {
        super.func_72893_g();
        int i = 0;
        int j = 0;
        Iterator iterator = this.field_72993_I.iterator();

        while (iterator.hasNext())
        {
            ChunkCoordIntPair chunkcoordintpair = (ChunkCoordIntPair)iterator.next();
            int k = chunkcoordintpair.field_77276_a * 16;
            int l = chunkcoordintpair.field_77275_b * 16;
            this.field_72984_F.func_76320_a("getChunk");
            Chunk chunk = this.func_72964_e(chunkcoordintpair.field_77276_a, chunkcoordintpair.field_77275_b);
            this.func_72941_a(k, l, chunk);
            this.field_72984_F.func_76318_c("tickChunk");
            chunk.func_76586_k();
            this.field_72984_F.func_76318_c("thunder");
            int i1;
            int j1;
            int k1;
            int l1;

            if (this.field_73012_v.nextInt(100000) == 0 && this.func_72896_J() && this.func_72911_I())
            {
                this.field_73005_l = this.field_73005_l * 3 + 1013904223;
                i1 = this.field_73005_l >> 2;
                j1 = k + (i1 & 15);
                k1 = l + (i1 >> 8 & 15);
                l1 = this.func_72874_g(j1, k1);

                if (this.func_72951_B(j1, l1, k1))
                {
                    this.func_72942_c(new EntityLightningBolt(this, (double)j1, (double)l1, (double)k1));
                }
            }

            this.field_72984_F.func_76318_c("iceandsnow");
            int i2;

            if (this.field_73012_v.nextInt(16) == 0)
            {
                this.field_73005_l = this.field_73005_l * 3 + 1013904223;
                i1 = this.field_73005_l >> 2;
                j1 = i1 & 15;
                k1 = i1 >> 8 & 15;
                l1 = this.func_72874_g(j1 + k, k1 + l);

                if (this.func_72850_v(j1 + k, l1 - 1, k1 + l))
                {
                    this.func_94575_c(j1 + k, l1 - 1, k1 + l, Block.field_72036_aT.field_71990_ca);
                }

                if (this.func_72896_J() && this.func_72858_w(j1 + k, l1, k1 + l))
                {
                    this.func_94575_c(j1 + k, l1, k1 + l, Block.field_72037_aS.field_71990_ca);
                }

                if (this.func_72896_J())
                {
                    BiomeGenBase biomegenbase = this.func_72807_a(j1 + k, k1 + l);

                    if (biomegenbase.func_76738_d())
                    {
                        i2 = this.func_72798_a(j1 + k, l1 - 1, k1 + l);

                        if (i2 != 0)
                        {
                            Block.field_71973_m[i2].func_71892_f(this, j1 + k, l1 - 1, k1 + l);
                        }
                    }
                }
            }

            this.field_72984_F.func_76318_c("tickTiles");
            ExtendedBlockStorage[] aextendedblockstorage = chunk.func_76587_i();
            j1 = aextendedblockstorage.length;

            for (k1 = 0; k1 < j1; ++k1)
            {
                ExtendedBlockStorage extendedblockstorage = aextendedblockstorage[k1];

                if (extendedblockstorage != null && extendedblockstorage.func_76675_b())
                {
                    for (int j2 = 0; j2 < 3; ++j2)
                    {
                        this.field_73005_l = this.field_73005_l * 3 + 1013904223;
                        i2 = this.field_73005_l >> 2;
                        int k2 = i2 & 15;
                        int l2 = i2 >> 8 & 15;
                        int i3 = i2 >> 16 & 15;
                        int j3 = extendedblockstorage.func_76656_a(k2, i3, l2);
                        ++j;
                        Block block = Block.field_71973_m[j3];

                        if (block != null && block.func_71881_r())
                        {
                            ++i;
                            block.func_71847_b(this, k2 + k, i3 + extendedblockstorage.func_76662_d(), l2 + l, this.field_73012_v);
                        }
                    }
                }
            }

            this.field_72984_F.func_76319_b();
        }
    }

    public boolean func_94573_a(int p_94573_1_, int p_94573_2_, int p_94573_3_, int p_94573_4_)
    {
        NextTickListEntry nextticklistentry = new NextTickListEntry(p_94573_1_, p_94573_2_, p_94573_3_, p_94573_4_);
        return this.field_94579_S.contains(nextticklistentry);
    }

    public void func_72836_a(int p_72836_1_, int p_72836_2_, int p_72836_3_, int p_72836_4_, int p_72836_5_)
    {
        this.func_82740_a(p_72836_1_, p_72836_2_, p_72836_3_, p_72836_4_, p_72836_5_, 0);
    }

    public void func_82740_a(int p_82740_1_, int p_82740_2_, int p_82740_3_, int p_82740_4_, int p_82740_5_, int p_82740_6_)
    {
        NextTickListEntry nextticklistentry = new NextTickListEntry(p_82740_1_, p_82740_2_, p_82740_3_, p_82740_4_);
        byte b0 = 0;

        if (this.field_72999_e && p_82740_4_ > 0)
        {
            if (Block.field_71973_m[p_82740_4_].func_82506_l())
            {
                b0 = 8;

                if (this.func_72904_c(nextticklistentry.field_77183_a - b0, nextticklistentry.field_77181_b - b0, nextticklistentry.field_77182_c - b0, nextticklistentry.field_77183_a + b0, nextticklistentry.field_77181_b + b0, nextticklistentry.field_77182_c + b0))
                {
                    int k1 = this.func_72798_a(nextticklistentry.field_77183_a, nextticklistentry.field_77181_b, nextticklistentry.field_77182_c);

                    if (k1 == nextticklistentry.field_77179_d && k1 > 0)
                    {
                        Block.field_71973_m[k1].func_71847_b(this, nextticklistentry.field_77183_a, nextticklistentry.field_77181_b, nextticklistentry.field_77182_c, this.field_73012_v);
                    }
                }

                return;
            }

            p_82740_5_ = 1;
        }

        if (this.func_72904_c(p_82740_1_ - b0, p_82740_2_ - b0, p_82740_3_ - b0, p_82740_1_ + b0, p_82740_2_ + b0, p_82740_3_ + b0))
        {
            if (p_82740_4_ > 0)
            {
                nextticklistentry.func_77176_a((long)p_82740_5_ + this.field_72986_A.func_82573_f());
                nextticklistentry.func_82753_a(p_82740_6_);
            }

            if (!this.field_73064_N.contains(nextticklistentry))
            {
                this.field_73064_N.add(nextticklistentry);
                this.field_73065_O.add(nextticklistentry);
            }
        }
    }

    public void func_72892_b(int p_72892_1_, int p_72892_2_, int p_72892_3_, int p_72892_4_, int p_72892_5_, int p_72892_6_)
    {
        NextTickListEntry nextticklistentry = new NextTickListEntry(p_72892_1_, p_72892_2_, p_72892_3_, p_72892_4_);
        nextticklistentry.func_82753_a(p_72892_6_);

        if (p_72892_4_ > 0)
        {
            nextticklistentry.func_77176_a((long)p_72892_5_ + this.field_72986_A.func_82573_f());
        }

        if (!this.field_73064_N.contains(nextticklistentry))
        {
            this.field_73064_N.add(nextticklistentry);
            this.field_73065_O.add(nextticklistentry);
        }
    }

    public void func_72939_s()
    {
        if (this.field_73010_i.isEmpty())
        {
            if (this.field_80004_Q++ >= 1200)
            {
                return;
            }
        }
        else
        {
            this.func_82742_i();
        }

        super.func_72939_s();
    }

    public void func_82742_i()
    {
        this.field_80004_Q = 0;
    }

    public boolean func_72955_a(boolean p_72955_1_)
    {
        int i = this.field_73065_O.size();

        if (i != this.field_73064_N.size())
        {
            throw new IllegalStateException("TickNextTick list out of synch");
        }
        else
        {
            if (i > 1000)
            {
                i = 1000;
            }

            this.field_72984_F.func_76320_a("cleaning");
            NextTickListEntry nextticklistentry;

            for (int j = 0; j < i; ++j)
            {
                nextticklistentry = (NextTickListEntry)this.field_73065_O.first();

                if (!p_72955_1_ && nextticklistentry.field_77180_e > this.field_72986_A.func_82573_f())
                {
                    break;
                }

                this.field_73065_O.remove(nextticklistentry);
                this.field_73064_N.remove(nextticklistentry);
                this.field_94579_S.add(nextticklistentry);
            }

            this.field_72984_F.func_76319_b();
            this.field_72984_F.func_76320_a("ticking");
            Iterator iterator = this.field_94579_S.iterator();

            while (iterator.hasNext())
            {
                nextticklistentry = (NextTickListEntry)iterator.next();
                iterator.remove();
                byte b0 = 0;

                if (this.func_72904_c(nextticklistentry.field_77183_a - b0, nextticklistentry.field_77181_b - b0, nextticklistentry.field_77182_c - b0, nextticklistentry.field_77183_a + b0, nextticklistentry.field_77181_b + b0, nextticklistentry.field_77182_c + b0))
                {
                    int k = this.func_72798_a(nextticklistentry.field_77183_a, nextticklistentry.field_77181_b, nextticklistentry.field_77182_c);

                    if (k > 0 && Block.func_94329_b(k, nextticklistentry.field_77179_d))
                    {
                        try
                        {
                            Block.field_71973_m[k].func_71847_b(this, nextticklistentry.field_77183_a, nextticklistentry.field_77181_b, nextticklistentry.field_77182_c, this.field_73012_v);
                        }
                        catch (Throwable throwable)
                        {
                            CrashReport crashreport = CrashReport.func_85055_a(throwable, "Exception while ticking a block");
                            CrashReportCategory crashreportcategory = crashreport.func_85058_a("Block being ticked");
                            int l;

                            try
                            {
                                l = this.func_72805_g(nextticklistentry.field_77183_a, nextticklistentry.field_77181_b, nextticklistentry.field_77182_c);
                            }
                            catch (Throwable throwable1)
                            {
                                l = -1;
                            }

                            CrashReportCategory.func_85068_a(crashreportcategory, nextticklistentry.field_77183_a, nextticklistentry.field_77181_b, nextticklistentry.field_77182_c, k, l);
                            throw new ReportedException(crashreport);
                        }
                    }
                }
                else
                {
                    this.func_72836_a(nextticklistentry.field_77183_a, nextticklistentry.field_77181_b, nextticklistentry.field_77182_c, nextticklistentry.field_77179_d, 0);
                }
            }

            this.field_72984_F.func_76319_b();
            this.field_94579_S.clear();
            return !this.field_73065_O.isEmpty();
        }
    }

    public List func_72920_a(Chunk p_72920_1_, boolean p_72920_2_)
    {
        ArrayList arraylist = null;
        ChunkCoordIntPair chunkcoordintpair = p_72920_1_.func_76632_l();
        int i = (chunkcoordintpair.field_77276_a << 4) - 2;
        int j = i + 16 + 2;
        int k = (chunkcoordintpair.field_77275_b << 4) - 2;
        int l = k + 16 + 2;

        for (int i1 = 0; i1 < 2; ++i1)
        {
            Iterator iterator;

            if (i1 == 0)
            {
                iterator = this.field_73065_O.iterator();
            }
            else
            {
                iterator = this.field_94579_S.iterator();

                if (!this.field_94579_S.isEmpty())
                {
                    System.out.println(this.field_94579_S.size());
                }
            }

            while (iterator.hasNext())
            {
                NextTickListEntry nextticklistentry = (NextTickListEntry)iterator.next();

                if (nextticklistentry.field_77183_a >= i && nextticklistentry.field_77183_a < j && nextticklistentry.field_77182_c >= k && nextticklistentry.field_77182_c < l)
                {
                    if (p_72920_2_)
                    {
                        this.field_73064_N.remove(nextticklistentry);
                        iterator.remove();
                    }

                    if (arraylist == null)
                    {
                        arraylist = new ArrayList();
                    }

                    arraylist.add(nextticklistentry);
                }
            }
        }

        return arraylist;
    }

    public void func_72866_a(Entity p_72866_1_, boolean p_72866_2_)
    {
        if (!this.field_73061_a.func_71268_U() && (p_72866_1_ instanceof EntityAnimal || p_72866_1_ instanceof EntityWaterMob))
        {
            p_72866_1_.func_70106_y();
        }

        if (!this.field_73061_a.func_71220_V() && p_72866_1_ instanceof INpc)
        {
            p_72866_1_.func_70106_y();
        }

        super.func_72866_a(p_72866_1_, p_72866_2_);
    }

    protected IChunkProvider func_72970_h()
    {
        IChunkLoader ichunkloader = this.field_73019_z.func_75763_a(this.field_73011_w);
        this.field_73059_b = new ChunkProviderServer(this, ichunkloader, this.field_73011_w.func_76555_c());
        return this.field_73059_b;
    }

    public List func_73049_a(int p_73049_1_, int p_73049_2_, int p_73049_3_, int p_73049_4_, int p_73049_5_, int p_73049_6_)
    {
        ArrayList arraylist = new ArrayList();

        for (int k1 = 0; k1 < this.field_73009_h.size(); ++k1)
        {
            TileEntity tileentity = (TileEntity)this.field_73009_h.get(k1);

            if (tileentity.field_70329_l >= p_73049_1_ && tileentity.field_70330_m >= p_73049_2_ && tileentity.field_70327_n >= p_73049_3_ && tileentity.field_70329_l < p_73049_4_ && tileentity.field_70330_m < p_73049_5_ && tileentity.field_70327_n < p_73049_6_)
            {
                arraylist.add(tileentity);
            }
        }

        return arraylist;
    }

    public boolean func_72962_a(EntityPlayer p_72962_1_, int p_72962_2_, int p_72962_3_, int p_72962_4_)
    {
        return !this.field_73061_a.func_96290_a(this, p_72962_2_, p_72962_3_, p_72962_4_, p_72962_1_);
    }

    protected void func_72963_a(WorldSettings p_72963_1_)
    {
        if (this.field_73066_T == null)
        {
            this.field_73066_T = new IntHashMap();
        }

        if (this.field_73064_N == null)
        {
            this.field_73064_N = new HashSet();
        }

        if (this.field_73065_O == null)
        {
            this.field_73065_O = new TreeSet();
        }

        this.func_73052_b(p_72963_1_);
        super.func_72963_a(p_72963_1_);
    }

    protected void func_73052_b(WorldSettings p_73052_1_)
    {
        if (!this.field_73011_w.func_76567_e())
        {
            this.field_72986_A.func_76081_a(0, this.field_73011_w.func_76557_i(), 0);
        }
        else
        {
            this.field_72987_B = true;
            WorldChunkManager worldchunkmanager = this.field_73011_w.field_76578_c;
            List list = worldchunkmanager.func_76932_a();
            Random random = new Random(this.func_72905_C());
            ChunkPosition chunkposition = worldchunkmanager.func_76941_a(0, 0, 256, list, random);
            int i = 0;
            int j = this.field_73011_w.func_76557_i();
            int k = 0;

            if (chunkposition != null)
            {
                i = chunkposition.field_76930_a;
                k = chunkposition.field_76929_c;
            }
            else
            {
                this.func_98180_V().func_98236_b("Unable to find spawn biome");
            }

            int l = 0;

            while (!this.field_73011_w.func_76566_a(i, k))
            {
                i += random.nextInt(64) - random.nextInt(64);
                k += random.nextInt(64) - random.nextInt(64);
                ++l;

                if (l == 1000)
                {
                    break;
                }
            }

            this.field_72986_A.func_76081_a(i, j, k);
            this.field_72987_B = false;

            if (p_73052_1_.func_77167_c())
            {
                this.func_73047_i();
            }
        }
    }

    protected void func_73047_i()
    {
        WorldGeneratorBonusChest worldgeneratorbonuschest = new WorldGeneratorBonusChest(field_73069_S, 10);

        for (int i = 0; i < 10; ++i)
        {
            int j = this.field_72986_A.func_76079_c() + this.field_73012_v.nextInt(6) - this.field_73012_v.nextInt(6);
            int k = this.field_72986_A.func_76074_e() + this.field_73012_v.nextInt(6) - this.field_73012_v.nextInt(6);
            int l = this.func_72825_h(j, k) + 1;

            if (worldgeneratorbonuschest.func_76484_a(this, this.field_73012_v, j, l, k))
            {
                break;
            }
        }
    }

    public ChunkCoordinates func_73054_j()
    {
        return this.field_73011_w.func_76554_h();
    }

    public void func_73044_a(boolean p_73044_1_, IProgressUpdate p_73044_2_) throws MinecraftException
    {
        if (this.field_73020_y.func_73157_c())
        {
            if (p_73044_2_ != null)
            {
                p_73044_2_.func_73720_a("Saving level");
            }

            this.func_73042_a();

            if (p_73044_2_ != null)
            {
                p_73044_2_.func_73719_c("Saving chunks");
            }

            this.field_73020_y.func_73151_a(p_73044_1_, p_73044_2_);
        }
    }

    public void func_104140_m()
    {
        if (this.field_73020_y.func_73157_c())
        {
            this.field_73020_y.func_104112_b();
        }
    }

    protected void func_73042_a() throws MinecraftException
    {
        this.func_72906_B();
        this.field_73019_z.func_75755_a(this.field_72986_A, this.field_73061_a.func_71203_ab().func_72378_q());
        this.field_72988_C.func_75744_a();
    }

    protected void func_72923_a(Entity p_72923_1_)
    {
        super.func_72923_a(p_72923_1_);
        this.field_73066_T.func_76038_a(p_72923_1_.field_70157_k, p_72923_1_);
        Entity[] aentity = p_72923_1_.func_70021_al();

        if (aentity != null)
        {
            for (int i = 0; i < aentity.length; ++i)
            {
                this.field_73066_T.func_76038_a(aentity[i].field_70157_k, aentity[i]);
            }
        }
    }

    public void func_72847_b(Entity p_72847_1_)
    {
        super.func_72847_b(p_72847_1_);
        this.field_73066_T.func_76049_d(p_72847_1_.field_70157_k);
        Entity[] aentity = p_72847_1_.func_70021_al();

        if (aentity != null)
        {
            for (int i = 0; i < aentity.length; ++i)
            {
                this.field_73066_T.func_76049_d(aentity[i].field_70157_k);
            }
        }
    }

    public Entity func_73045_a(int p_73045_1_)
    {
        return (Entity)this.field_73066_T.func_76041_a(p_73045_1_);
    }

    public boolean func_72942_c(Entity p_72942_1_)
    {
        if (super.func_72942_c(p_72942_1_))
        {
            this.field_73061_a.func_71203_ab().func_72393_a(p_72942_1_.field_70165_t, p_72942_1_.field_70163_u, p_72942_1_.field_70161_v, 512.0D, this.field_73011_w.field_76574_g, new Packet71Weather(p_72942_1_));
            return true;
        }
        else
        {
            return false;
        }
    }

    public void func_72960_a(Entity p_72960_1_, byte p_72960_2_)
    {
        Packet38EntityStatus packet38entitystatus = new Packet38EntityStatus(p_72960_1_.field_70157_k, p_72960_2_);
        this.func_73039_n().func_72789_b(p_72960_1_, packet38entitystatus);
    }

    public Explosion func_72885_a(Entity p_72885_1_, double p_72885_2_, double p_72885_4_, double p_72885_6_, float p_72885_8_, boolean p_72885_9_, boolean p_72885_10_)
    {
        Explosion explosion = new Explosion(this, p_72885_1_, p_72885_2_, p_72885_4_, p_72885_6_, p_72885_8_);
        explosion.field_77286_a = p_72885_9_;
        explosion.field_82755_b = p_72885_10_;
        explosion.func_77278_a();
        explosion.func_77279_a(false);

        if (!p_72885_10_)
        {
            explosion.field_77281_g.clear();
        }

        Iterator iterator = this.field_73010_i.iterator();

        while (iterator.hasNext())
        {
            EntityPlayer entityplayer = (EntityPlayer)iterator.next();

            if (entityplayer.func_70092_e(p_72885_2_, p_72885_4_, p_72885_6_) < 4096.0D)
            {
                ((EntityPlayerMP)entityplayer).field_71135_a.func_72567_b(new Packet60Explosion(p_72885_2_, p_72885_4_, p_72885_6_, p_72885_8_, explosion.field_77281_g, (Vec3)explosion.func_77277_b().get(entityplayer)));
            }
        }

        return explosion;
    }

    public void func_72965_b(int p_72965_1_, int p_72965_2_, int p_72965_3_, int p_72965_4_, int p_72965_5_, int p_72965_6_)
    {
        BlockEventData blockeventdata = new BlockEventData(p_72965_1_, p_72965_2_, p_72965_3_, p_72965_4_, p_72965_5_, p_72965_6_);
        Iterator iterator = this.field_73067_Q[this.field_73070_R].iterator();
        BlockEventData blockeventdata1;

        do
        {
            if (!iterator.hasNext())
            {
                this.field_73067_Q[this.field_73070_R].add(blockeventdata);
                return;
            }

            blockeventdata1 = (BlockEventData)iterator.next();
        }
        while (!blockeventdata1.equals(blockeventdata));
    }

    private void func_73055_Q()
    {
        while (!this.field_73067_Q[this.field_73070_R].isEmpty())
        {
            int i = this.field_73070_R;
            this.field_73070_R ^= 1;
            Iterator iterator = this.field_73067_Q[i].iterator();

            while (iterator.hasNext())
            {
                BlockEventData blockeventdata = (BlockEventData)iterator.next();

                if (this.func_73043_a(blockeventdata))
                {
                    this.field_73061_a.func_71203_ab().func_72393_a((double)blockeventdata.func_76919_a(), (double)blockeventdata.func_76921_b(), (double)blockeventdata.func_76920_c(), 64.0D, this.field_73011_w.field_76574_g, new Packet54PlayNoteBlock(blockeventdata.func_76919_a(), blockeventdata.func_76921_b(), blockeventdata.func_76920_c(), blockeventdata.func_76916_f(), blockeventdata.func_76918_d(), blockeventdata.func_76917_e()));
                }
            }

            this.field_73067_Q[i].clear();
        }
    }

    private boolean func_73043_a(BlockEventData p_73043_1_)
    {
        int i = this.func_72798_a(p_73043_1_.func_76919_a(), p_73043_1_.func_76921_b(), p_73043_1_.func_76920_c());
        return i == p_73043_1_.func_76916_f() ? Block.field_71973_m[i].func_71883_b(this, p_73043_1_.func_76919_a(), p_73043_1_.func_76921_b(), p_73043_1_.func_76920_c(), p_73043_1_.func_76918_d(), p_73043_1_.func_76917_e()) : false;
    }

    public void func_73041_k()
    {
        this.field_73019_z.func_75759_a();
    }

    protected void func_72979_l()
    {
        boolean flag = this.func_72896_J();
        super.func_72979_l();

        if (flag != this.func_72896_J())
        {
            if (flag)
            {
                this.field_73061_a.func_71203_ab().func_72384_a(new Packet70GameEvent(2, 0));
            }
            else
            {
                this.field_73061_a.func_71203_ab().func_72384_a(new Packet70GameEvent(1, 0));
            }
        }
    }

    public MinecraftServer func_73046_m()
    {
        return this.field_73061_a;
    }

    public EntityTracker func_73039_n()
    {
        return this.field_73062_L;
    }

    public PlayerManager func_73040_p()
    {
        return this.field_73063_M;
    }

    public Teleporter func_85176_s()
    {
        return this.field_85177_Q;
    }
}
