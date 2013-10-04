package net.minecraft.server.management;

import com.google.common.base.Charsets;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.File;
import java.net.SocketAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemInWorldManager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.NetServerHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet16BlockItemSwitch;
import net.minecraft.network.packet.Packet1Login;
import net.minecraft.network.packet.Packet201PlayerInfo;
import net.minecraft.network.packet.Packet202PlayerAbilities;
import net.minecraft.network.packet.Packet209SetPlayerTeam;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.network.packet.Packet3Chat;
import net.minecraft.network.packet.Packet41EntityEffect;
import net.minecraft.network.packet.Packet43Experience;
import net.minecraft.network.packet.Packet4UpdateTime;
import net.minecraft.network.packet.Packet6SpawnPosition;
import net.minecraft.network.packet.Packet70GameEvent;
import net.minecraft.network.packet.Packet9Respawn;
import net.minecraft.potion.PotionEffect;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ServerScoreboard;
import net.minecraft.scoreboard.Team;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumGameType;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.demo.DemoWorldManager;
import net.minecraft.world.storage.IPlayerFileData;

public abstract class ServerConfigurationManager
{
    private static final SimpleDateFormat field_72403_e = new SimpleDateFormat("yyyy-MM-dd \'at\' HH:mm:ss z");
    private final MinecraftServer field_72400_f;
    public final List field_72404_b = new ArrayList();
    private final BanList field_72401_g = new BanList(new File("banned-players.txt"));
    private final BanList field_72413_h = new BanList(new File("banned-ips.txt"));
    private Set field_72414_i = new HashSet();
    private Set field_72411_j = new HashSet();
    private IPlayerFileData field_72412_k;
    private boolean field_72409_l;
    protected int field_72405_c;
    protected int field_72402_d;
    private EnumGameType field_72410_m;
    private boolean field_72407_n;
    private int field_72408_o;

    public ServerConfigurationManager(MinecraftServer p_i1500_1_)
    {
        this.field_72400_f = p_i1500_1_;
        this.field_72401_g.func_73708_a(false);
        this.field_72413_h.func_73708_a(false);
        this.field_72405_c = 8;
    }

    public void func_72355_a(INetworkManager p_72355_1_, EntityPlayerMP p_72355_2_)
    {
        NBTTagCompound nbttagcompound = this.func_72380_a(p_72355_2_);
        p_72355_2_.func_70029_a(this.field_72400_f.func_71218_a(p_72355_2_.field_71093_bK));
        p_72355_2_.field_71134_c.func_73080_a((WorldServer)p_72355_2_.field_70170_p);
        String s = "local";

        if (p_72355_1_.func_74430_c() != null)
        {
            s = p_72355_1_.func_74430_c().toString();
        }

        this.field_72400_f.func_98033_al().func_98233_a(p_72355_2_.func_70005_c_() + "[" + s + "] logged in with entity id " + p_72355_2_.field_70157_k + " at (" + p_72355_2_.field_70165_t + ", " + p_72355_2_.field_70163_u + ", " + p_72355_2_.field_70161_v + ")");
        WorldServer worldserver = this.field_72400_f.func_71218_a(p_72355_2_.field_71093_bK);
        ChunkCoordinates chunkcoordinates = worldserver.func_72861_E();
        this.func_72381_a(p_72355_2_, (EntityPlayerMP)null, worldserver);
        NetServerHandler netserverhandler = new NetServerHandler(this.field_72400_f, p_72355_1_, p_72355_2_);
        netserverhandler.func_72567_b(new Packet1Login(p_72355_2_.field_70157_k, worldserver.func_72912_H().func_76067_t(), p_72355_2_.field_71134_c.func_73081_b(), worldserver.func_72912_H().func_76093_s(), worldserver.field_73011_w.field_76574_g, worldserver.field_73013_u, worldserver.func_72800_K(), this.func_72352_l()));
        netserverhandler.func_72567_b(new Packet250CustomPayload("MC|Brand", this.func_72365_p().getServerModName().getBytes(Charsets.UTF_8)));
        netserverhandler.func_72567_b(new Packet6SpawnPosition(chunkcoordinates.field_71574_a, chunkcoordinates.field_71572_b, chunkcoordinates.field_71573_c));
        netserverhandler.func_72567_b(new Packet202PlayerAbilities(p_72355_2_.field_71075_bZ));
        netserverhandler.func_72567_b(new Packet16BlockItemSwitch(p_72355_2_.field_71071_by.field_70461_c));
        this.func_96456_a((ServerScoreboard)worldserver.func_96441_U(), p_72355_2_);
        this.func_72354_b(p_72355_2_, worldserver);
        this.func_92062_k(ChatMessageComponent.func_111082_b("multiplayer.player.joined", new Object[] {p_72355_2_.func_96090_ax()}).func_111059_a(EnumChatFormatting.YELLOW));
        this.func_72377_c(p_72355_2_);
        netserverhandler.func_72569_a(p_72355_2_.field_70165_t, p_72355_2_.field_70163_u, p_72355_2_.field_70161_v, p_72355_2_.field_70177_z, p_72355_2_.field_70125_A);
        this.field_72400_f.func_71212_ac().func_71745_a(netserverhandler);
        netserverhandler.func_72567_b(new Packet4UpdateTime(worldserver.func_82737_E(), worldserver.func_72820_D(), worldserver.func_82736_K().func_82766_b("doDaylightCycle")));

        if (this.field_72400_f.func_71202_P().length() > 0)
        {
            p_72355_2_.func_71115_a(this.field_72400_f.func_71202_P(), this.field_72400_f.func_71227_R());
        }

        Iterator iterator = p_72355_2_.func_70651_bq().iterator();

        while (iterator.hasNext())
        {
            PotionEffect potioneffect = (PotionEffect)iterator.next();
            netserverhandler.func_72567_b(new Packet41EntityEffect(p_72355_2_.field_70157_k, potioneffect));
        }

        p_72355_2_.func_71116_b();

        if (nbttagcompound != null && nbttagcompound.func_74764_b("Riding"))
        {
            Entity entity = EntityList.func_75615_a(nbttagcompound.func_74775_l("Riding"), worldserver);

            if (entity != null)
            {
                entity.field_98038_p = true;
                worldserver.func_72838_d(entity);
                p_72355_2_.func_70078_a(entity);
                entity.field_98038_p = false;
            }
        }
    }

    protected void func_96456_a(ServerScoreboard p_96456_1_, EntityPlayerMP p_96456_2_)
    {
        HashSet hashset = new HashSet();
        Iterator iterator = p_96456_1_.func_96525_g().iterator();

        while (iterator.hasNext())
        {
            ScorePlayerTeam scoreplayerteam = (ScorePlayerTeam)iterator.next();
            p_96456_2_.field_71135_a.func_72567_b(new Packet209SetPlayerTeam(scoreplayerteam, 0));
        }

        for (int i = 0; i < 3; ++i)
        {
            ScoreObjective scoreobjective = p_96456_1_.func_96539_a(i);

            if (scoreobjective != null && !hashset.contains(scoreobjective))
            {
                List list = p_96456_1_.func_96550_d(scoreobjective);
                Iterator iterator1 = list.iterator();

                while (iterator1.hasNext())
                {
                    Packet packet = (Packet)iterator1.next();
                    p_96456_2_.field_71135_a.func_72567_b(packet);
                }

                hashset.add(scoreobjective);
            }
        }
    }

    public void func_72364_a(WorldServer[] p_72364_1_)
    {
        this.field_72412_k = p_72364_1_[0].func_72860_G().func_75756_e();
    }

    public void func_72375_a(EntityPlayerMP p_72375_1_, WorldServer p_72375_2_)
    {
        WorldServer worldserver1 = p_72375_1_.func_71121_q();

        if (p_72375_2_ != null)
        {
            p_72375_2_.func_73040_p().func_72695_c(p_72375_1_);
        }

        worldserver1.func_73040_p().func_72683_a(p_72375_1_);
        worldserver1.field_73059_b.func_73158_c((int)p_72375_1_.field_70165_t >> 4, (int)p_72375_1_.field_70161_v >> 4);
    }

    public int func_72372_a()
    {
        return PlayerManager.func_72686_a(this.func_72395_o());
    }

    public NBTTagCompound func_72380_a(EntityPlayerMP p_72380_1_)
    {
        NBTTagCompound nbttagcompound = this.field_72400_f.field_71305_c[0].func_72912_H().func_76072_h();
        NBTTagCompound nbttagcompound1;

        if (p_72380_1_.func_70005_c_().equals(this.field_72400_f.func_71214_G()) && nbttagcompound != null)
        {
            p_72380_1_.func_70020_e(nbttagcompound);
            nbttagcompound1 = nbttagcompound;
            System.out.println("loading single player");
        }
        else
        {
            nbttagcompound1 = this.field_72412_k.func_75752_b(p_72380_1_);
        }

        return nbttagcompound1;
    }

    protected void func_72391_b(EntityPlayerMP p_72391_1_)
    {
        this.field_72412_k.func_75753_a(p_72391_1_);
    }

    public void func_72377_c(EntityPlayerMP p_72377_1_)
    {
        this.func_72384_a(new Packet201PlayerInfo(p_72377_1_.func_70005_c_(), true, 1000));
        this.field_72404_b.add(p_72377_1_);
        WorldServer worldserver = this.field_72400_f.func_71218_a(p_72377_1_.field_71093_bK);
        worldserver.func_72838_d(p_72377_1_);
        this.func_72375_a(p_72377_1_, (WorldServer)null);

        for (int i = 0; i < this.field_72404_b.size(); ++i)
        {
            EntityPlayerMP entityplayermp1 = (EntityPlayerMP)this.field_72404_b.get(i);
            p_72377_1_.field_71135_a.func_72567_b(new Packet201PlayerInfo(entityplayermp1.func_70005_c_(), true, entityplayermp1.field_71138_i));
        }
    }

    public void func_72358_d(EntityPlayerMP p_72358_1_)
    {
        p_72358_1_.func_71121_q().func_73040_p().func_72685_d(p_72358_1_);
    }

    public void func_72367_e(EntityPlayerMP p_72367_1_)
    {
        this.func_72391_b(p_72367_1_);
        WorldServer worldserver = p_72367_1_.func_71121_q();

        if (p_72367_1_.field_70154_o != null)
        {
            worldserver.func_72973_f(p_72367_1_.field_70154_o);
            System.out.println("removing player mount");
        }

        worldserver.func_72900_e(p_72367_1_);
        worldserver.func_73040_p().func_72695_c(p_72367_1_);
        this.field_72404_b.remove(p_72367_1_);
        this.func_72384_a(new Packet201PlayerInfo(p_72367_1_.func_70005_c_(), false, 9999));
    }

    public String func_72399_a(SocketAddress p_72399_1_, String p_72399_2_)
    {
        if (this.field_72401_g.func_73704_a(p_72399_2_))
        {
            BanEntry banentry = (BanEntry)this.field_72401_g.func_73712_c().get(p_72399_2_);
            String s1 = "You are banned from this server!\nReason: " + banentry.func_73686_f();

            if (banentry.func_73680_d() != null)
            {
                s1 = s1 + "\nYour ban will be removed on " + field_72403_e.format(banentry.func_73680_d());
            }

            return s1;
        }
        else if (!this.func_72370_d(p_72399_2_))
        {
            return "You are not white-listed on this server!";
        }
        else
        {
            String s2 = p_72399_1_.toString();
            s2 = s2.substring(s2.indexOf("/") + 1);
            s2 = s2.substring(0, s2.indexOf(":"));

            if (this.field_72413_h.func_73704_a(s2))
            {
                BanEntry banentry1 = (BanEntry)this.field_72413_h.func_73712_c().get(s2);
                String s3 = "Your IP address is banned from this server!\nReason: " + banentry1.func_73686_f();

                if (banentry1.func_73680_d() != null)
                {
                    s3 = s3 + "\nYour ban will be removed on " + field_72403_e.format(banentry1.func_73680_d());
                }

                return s3;
            }
            else
            {
                return this.field_72404_b.size() >= this.field_72405_c ? "The server is full!" : null;
            }
        }
    }

    public EntityPlayerMP func_72366_a(String p_72366_1_)
    {
        ArrayList arraylist = new ArrayList();
        EntityPlayerMP entityplayermp;

        for (int i = 0; i < this.field_72404_b.size(); ++i)
        {
            entityplayermp = (EntityPlayerMP)this.field_72404_b.get(i);

            if (entityplayermp.func_70005_c_().equalsIgnoreCase(p_72366_1_))
            {
                arraylist.add(entityplayermp);
            }
        }

        Iterator iterator = arraylist.iterator();

        while (iterator.hasNext())
        {
            entityplayermp = (EntityPlayerMP)iterator.next();
            entityplayermp.field_71135_a.func_72565_c("You logged in from another location");
        }

        Object object;

        if (this.field_72400_f.func_71242_L())
        {
            object = new DemoWorldManager(this.field_72400_f.func_71218_a(0));
        }
        else
        {
            object = new ItemInWorldManager(this.field_72400_f.func_71218_a(0));
        }

        return new EntityPlayerMP(this.field_72400_f, this.field_72400_f.func_71218_a(0), p_72366_1_, (ItemInWorldManager)object);
    }

    public EntityPlayerMP func_72368_a(EntityPlayerMP p_72368_1_, int p_72368_2_, boolean p_72368_3_)
    {
        p_72368_1_.func_71121_q().func_73039_n().func_72787_a(p_72368_1_);
        p_72368_1_.func_71121_q().func_73039_n().func_72790_b(p_72368_1_);
        p_72368_1_.func_71121_q().func_73040_p().func_72695_c(p_72368_1_);
        this.field_72404_b.remove(p_72368_1_);
        this.field_72400_f.func_71218_a(p_72368_1_.field_71093_bK).func_72973_f(p_72368_1_);
        ChunkCoordinates chunkcoordinates = p_72368_1_.func_70997_bJ();
        boolean flag1 = p_72368_1_.func_82245_bX();
        p_72368_1_.field_71093_bK = p_72368_2_;
        Object object;

        if (this.field_72400_f.func_71242_L())
        {
            object = new DemoWorldManager(this.field_72400_f.func_71218_a(p_72368_1_.field_71093_bK));
        }
        else
        {
            object = new ItemInWorldManager(this.field_72400_f.func_71218_a(p_72368_1_.field_71093_bK));
        }

        EntityPlayerMP entityplayermp1 = new EntityPlayerMP(this.field_72400_f, this.field_72400_f.func_71218_a(p_72368_1_.field_71093_bK), p_72368_1_.func_70005_c_(), (ItemInWorldManager)object);
        entityplayermp1.field_71135_a = p_72368_1_.field_71135_a;
        entityplayermp1.func_71049_a(p_72368_1_, p_72368_3_);
        entityplayermp1.field_70157_k = p_72368_1_.field_70157_k;
        WorldServer worldserver = this.field_72400_f.func_71218_a(p_72368_1_.field_71093_bK);
        this.func_72381_a(entityplayermp1, p_72368_1_, worldserver);
        ChunkCoordinates chunkcoordinates1;

        if (chunkcoordinates != null)
        {
            chunkcoordinates1 = EntityPlayer.func_71056_a(this.field_72400_f.func_71218_a(p_72368_1_.field_71093_bK), chunkcoordinates, flag1);

            if (chunkcoordinates1 != null)
            {
                entityplayermp1.func_70012_b((double)((float)chunkcoordinates1.field_71574_a + 0.5F), (double)((float)chunkcoordinates1.field_71572_b + 0.1F), (double)((float)chunkcoordinates1.field_71573_c + 0.5F), 0.0F, 0.0F);
                entityplayermp1.func_71063_a(chunkcoordinates, flag1);
            }
            else
            {
                entityplayermp1.field_71135_a.func_72567_b(new Packet70GameEvent(0, 0));
            }
        }

        worldserver.field_73059_b.func_73158_c((int)entityplayermp1.field_70165_t >> 4, (int)entityplayermp1.field_70161_v >> 4);

        while (!worldserver.func_72945_a(entityplayermp1, entityplayermp1.field_70121_D).isEmpty())
        {
            entityplayermp1.func_70107_b(entityplayermp1.field_70165_t, entityplayermp1.field_70163_u + 1.0D, entityplayermp1.field_70161_v);
        }

        entityplayermp1.field_71135_a.func_72567_b(new Packet9Respawn(entityplayermp1.field_71093_bK, (byte)entityplayermp1.field_70170_p.field_73013_u, entityplayermp1.field_70170_p.func_72912_H().func_76067_t(), entityplayermp1.field_70170_p.func_72800_K(), entityplayermp1.field_71134_c.func_73081_b()));
        chunkcoordinates1 = worldserver.func_72861_E();
        entityplayermp1.field_71135_a.func_72569_a(entityplayermp1.field_70165_t, entityplayermp1.field_70163_u, entityplayermp1.field_70161_v, entityplayermp1.field_70177_z, entityplayermp1.field_70125_A);
        entityplayermp1.field_71135_a.func_72567_b(new Packet6SpawnPosition(chunkcoordinates1.field_71574_a, chunkcoordinates1.field_71572_b, chunkcoordinates1.field_71573_c));
        entityplayermp1.field_71135_a.func_72567_b(new Packet43Experience(entityplayermp1.field_71106_cc, entityplayermp1.field_71067_cb, entityplayermp1.field_71068_ca));
        this.func_72354_b(entityplayermp1, worldserver);
        worldserver.func_73040_p().func_72683_a(entityplayermp1);
        worldserver.func_72838_d(entityplayermp1);
        this.field_72404_b.add(entityplayermp1);
        entityplayermp1.func_71116_b();
        entityplayermp1.func_70606_j(entityplayermp1.func_110143_aJ());
        return entityplayermp1;
    }

    public void func_72356_a(EntityPlayerMP p_72356_1_, int p_72356_2_)
    {
        int j = p_72356_1_.field_71093_bK;
        WorldServer worldserver = this.field_72400_f.func_71218_a(p_72356_1_.field_71093_bK);
        p_72356_1_.field_71093_bK = p_72356_2_;
        WorldServer worldserver1 = this.field_72400_f.func_71218_a(p_72356_1_.field_71093_bK);
        p_72356_1_.field_71135_a.func_72567_b(new Packet9Respawn(p_72356_1_.field_71093_bK, (byte)p_72356_1_.field_70170_p.field_73013_u, worldserver1.func_72912_H().func_76067_t(), worldserver1.func_72800_K(), p_72356_1_.field_71134_c.func_73081_b()));
        worldserver.func_72973_f(p_72356_1_);
        p_72356_1_.field_70128_L = false;
        this.func_82448_a(p_72356_1_, j, worldserver, worldserver1);
        this.func_72375_a(p_72356_1_, worldserver);
        p_72356_1_.field_71135_a.func_72569_a(p_72356_1_.field_70165_t, p_72356_1_.field_70163_u, p_72356_1_.field_70161_v, p_72356_1_.field_70177_z, p_72356_1_.field_70125_A);
        p_72356_1_.field_71134_c.func_73080_a(worldserver1);
        this.func_72354_b(p_72356_1_, worldserver1);
        this.func_72385_f(p_72356_1_);
        Iterator iterator = p_72356_1_.func_70651_bq().iterator();

        while (iterator.hasNext())
        {
            PotionEffect potioneffect = (PotionEffect)iterator.next();
            p_72356_1_.field_71135_a.func_72567_b(new Packet41EntityEffect(p_72356_1_.field_70157_k, potioneffect));
        }
    }

    public void func_82448_a(Entity p_82448_1_, int p_82448_2_, WorldServer p_82448_3_, WorldServer p_82448_4_)
    {
        double d0 = p_82448_1_.field_70165_t;
        double d1 = p_82448_1_.field_70161_v;
        double d2 = 8.0D;
        double d3 = p_82448_1_.field_70165_t;
        double d4 = p_82448_1_.field_70163_u;
        double d5 = p_82448_1_.field_70161_v;
        float f = p_82448_1_.field_70177_z;
        p_82448_3_.field_72984_F.func_76320_a("moving");

        if (p_82448_1_.field_71093_bK == -1)
        {
            d0 /= d2;
            d1 /= d2;
            p_82448_1_.func_70012_b(d0, p_82448_1_.field_70163_u, d1, p_82448_1_.field_70177_z, p_82448_1_.field_70125_A);

            if (p_82448_1_.func_70089_S())
            {
                p_82448_3_.func_72866_a(p_82448_1_, false);
            }
        }
        else if (p_82448_1_.field_71093_bK == 0)
        {
            d0 *= d2;
            d1 *= d2;
            p_82448_1_.func_70012_b(d0, p_82448_1_.field_70163_u, d1, p_82448_1_.field_70177_z, p_82448_1_.field_70125_A);

            if (p_82448_1_.func_70089_S())
            {
                p_82448_3_.func_72866_a(p_82448_1_, false);
            }
        }
        else
        {
            ChunkCoordinates chunkcoordinates;

            if (p_82448_2_ == 1)
            {
                chunkcoordinates = p_82448_4_.func_72861_E();
            }
            else
            {
                chunkcoordinates = p_82448_4_.func_73054_j();
            }

            d0 = (double)chunkcoordinates.field_71574_a;
            p_82448_1_.field_70163_u = (double)chunkcoordinates.field_71572_b;
            d1 = (double)chunkcoordinates.field_71573_c;
            p_82448_1_.func_70012_b(d0, p_82448_1_.field_70163_u, d1, 90.0F, 0.0F);

            if (p_82448_1_.func_70089_S())
            {
                p_82448_3_.func_72866_a(p_82448_1_, false);
            }
        }

        p_82448_3_.field_72984_F.func_76319_b();

        if (p_82448_2_ != 1)
        {
            p_82448_3_.field_72984_F.func_76320_a("placing");
            d0 = (double)MathHelper.func_76125_a((int)d0, -29999872, 29999872);
            d1 = (double)MathHelper.func_76125_a((int)d1, -29999872, 29999872);

            if (p_82448_1_.func_70089_S())
            {
                p_82448_4_.func_72838_d(p_82448_1_);
                p_82448_1_.func_70012_b(d0, p_82448_1_.field_70163_u, d1, p_82448_1_.field_70177_z, p_82448_1_.field_70125_A);
                p_82448_4_.func_72866_a(p_82448_1_, false);
                p_82448_4_.func_85176_s().func_77185_a(p_82448_1_, d3, d4, d5, f);
            }

            p_82448_3_.field_72984_F.func_76319_b();
        }

        p_82448_1_.func_70029_a(p_82448_4_);
    }

    public void func_72374_b()
    {
        if (++this.field_72408_o > 600)
        {
            this.field_72408_o = 0;
        }

        if (this.field_72408_o < this.field_72404_b.size())
        {
            EntityPlayerMP entityplayermp = (EntityPlayerMP)this.field_72404_b.get(this.field_72408_o);
            this.func_72384_a(new Packet201PlayerInfo(entityplayermp.func_70005_c_(), true, entityplayermp.field_71138_i));
        }
    }

    public void func_72384_a(Packet p_72384_1_)
    {
        for (int i = 0; i < this.field_72404_b.size(); ++i)
        {
            ((EntityPlayerMP)this.field_72404_b.get(i)).field_71135_a.func_72567_b(p_72384_1_);
        }
    }

    public void func_72396_a(Packet p_72396_1_, int p_72396_2_)
    {
        for (int j = 0; j < this.field_72404_b.size(); ++j)
        {
            EntityPlayerMP entityplayermp = (EntityPlayerMP)this.field_72404_b.get(j);

            if (entityplayermp.field_71093_bK == p_72396_2_)
            {
                entityplayermp.field_71135_a.func_72567_b(p_72396_1_);
            }
        }
    }

    public String func_72398_c()
    {
        String s = "";

        for (int i = 0; i < this.field_72404_b.size(); ++i)
        {
            if (i > 0)
            {
                s = s + ", ";
            }

            s = s + ((EntityPlayerMP)this.field_72404_b.get(i)).func_70005_c_();
        }

        return s;
    }

    public String[] func_72369_d()
    {
        String[] astring = new String[this.field_72404_b.size()];

        for (int i = 0; i < this.field_72404_b.size(); ++i)
        {
            astring[i] = ((EntityPlayerMP)this.field_72404_b.get(i)).func_70005_c_();
        }

        return astring;
    }

    public BanList func_72390_e()
    {
        return this.field_72401_g;
    }

    public BanList func_72363_f()
    {
        return this.field_72413_h;
    }

    public void func_72386_b(String p_72386_1_)
    {
        this.field_72414_i.add(p_72386_1_.toLowerCase());
    }

    public void func_72360_c(String p_72360_1_)
    {
        this.field_72414_i.remove(p_72360_1_.toLowerCase());
    }

    public boolean func_72370_d(String p_72370_1_)
    {
        p_72370_1_ = p_72370_1_.trim().toLowerCase();
        return !this.field_72409_l || this.field_72414_i.contains(p_72370_1_) || this.field_72411_j.contains(p_72370_1_);
    }

    public boolean func_72353_e(String p_72353_1_)
    {
        return this.field_72414_i.contains(p_72353_1_.trim().toLowerCase()) || this.field_72400_f.func_71264_H() && this.field_72400_f.field_71305_c[0].func_72912_H().func_76086_u() && this.field_72400_f.func_71214_G().equalsIgnoreCase(p_72353_1_) || this.field_72407_n;
    }

    public EntityPlayerMP func_72361_f(String p_72361_1_)
    {
        Iterator iterator = this.field_72404_b.iterator();
        EntityPlayerMP entityplayermp;

        do
        {
            if (!iterator.hasNext())
            {
                return null;
            }

            entityplayermp = (EntityPlayerMP)iterator.next();
        }
        while (!entityplayermp.func_70005_c_().equalsIgnoreCase(p_72361_1_));

        return entityplayermp;
    }

    public List func_82449_a(ChunkCoordinates p_82449_1_, int p_82449_2_, int p_82449_3_, int p_82449_4_, int p_82449_5_, int p_82449_6_, int p_82449_7_, Map p_82449_8_, String p_82449_9_, String p_82449_10_, World p_82449_11_)
    {
        if (this.field_72404_b.isEmpty())
        {
            return null;
        }
        else
        {
            Object object = new ArrayList();
            boolean flag = p_82449_4_ < 0;
            boolean flag1 = p_82449_9_ != null && p_82449_9_.startsWith("!");
            boolean flag2 = p_82449_10_ != null && p_82449_10_.startsWith("!");
            int k1 = p_82449_2_ * p_82449_2_;
            int l1 = p_82449_3_ * p_82449_3_;
            p_82449_4_ = MathHelper.func_76130_a(p_82449_4_);

            if (flag1)
            {
                p_82449_9_ = p_82449_9_.substring(1);
            }

            if (flag2)
            {
                p_82449_10_ = p_82449_10_.substring(1);
            }

            for (int i2 = 0; i2 < this.field_72404_b.size(); ++i2)
            {
                EntityPlayerMP entityplayermp = (EntityPlayerMP)this.field_72404_b.get(i2);

                if ((p_82449_11_ == null || entityplayermp.field_70170_p == p_82449_11_) && (p_82449_9_ == null || flag1 != p_82449_9_.equalsIgnoreCase(entityplayermp.func_70023_ak())))
                {
                    if (p_82449_10_ != null)
                    {
                        Team team = entityplayermp.func_96124_cp();
                        String s2 = team == null ? "" : team.func_96661_b();

                        if (flag2 == p_82449_10_.equalsIgnoreCase(s2))
                        {
                            continue;
                        }
                    }

                    if (p_82449_1_ != null && (p_82449_2_ > 0 || p_82449_3_ > 0))
                    {
                        float f = p_82449_1_.func_82371_e(entityplayermp.func_82114_b());

                        if (p_82449_2_ > 0 && f < (float)k1 || p_82449_3_ > 0 && f > (float)l1)
                        {
                            continue;
                        }
                    }

                    if (this.func_96457_a(entityplayermp, p_82449_8_) && (p_82449_5_ == EnumGameType.NOT_SET.func_77148_a() || p_82449_5_ == entityplayermp.field_71134_c.func_73081_b().func_77148_a()) && (p_82449_6_ <= 0 || entityplayermp.field_71068_ca >= p_82449_6_) && entityplayermp.field_71068_ca <= p_82449_7_)
                    {
                        ((List)object).add(entityplayermp);
                    }
                }
            }

            if (p_82449_1_ != null)
            {
                Collections.sort((List)object, new PlayerPositionComparator(p_82449_1_));
            }

            if (flag)
            {
                Collections.reverse((List)object);
            }

            if (p_82449_4_ > 0)
            {
                object = ((List)object).subList(0, Math.min(p_82449_4_, ((List)object).size()));
            }

            return (List)object;
        }
    }

    private boolean func_96457_a(EntityPlayer p_96457_1_, Map p_96457_2_)
    {
        if (p_96457_2_ != null && p_96457_2_.size() != 0)
        {
            Iterator iterator = p_96457_2_.entrySet().iterator();
            Entry entry;
            boolean flag;
            int i;

            do
            {
                if (!iterator.hasNext())
                {
                    return true;
                }

                entry = (Entry)iterator.next();
                String s = (String)entry.getKey();
                flag = false;

                if (s.endsWith("_min") && s.length() > 4)
                {
                    flag = true;
                    s = s.substring(0, s.length() - 4);
                }

                Scoreboard scoreboard = p_96457_1_.func_96123_co();
                ScoreObjective scoreobjective = scoreboard.func_96518_b(s);

                if (scoreobjective == null)
                {
                    return false;
                }

                Score score = p_96457_1_.func_96123_co().func_96529_a(p_96457_1_.func_70023_ak(), scoreobjective);
                i = score.func_96652_c();

                if (i < ((Integer)entry.getValue()).intValue() && flag)
                {
                    return false;
                }
            }
            while (i <= ((Integer)entry.getValue()).intValue() || flag);

            return false;
        }
        else
        {
            return true;
        }
    }

    public void func_72393_a(double p_72393_1_, double p_72393_3_, double p_72393_5_, double p_72393_7_, int p_72393_9_, Packet p_72393_10_)
    {
        this.func_72397_a((EntityPlayer)null, p_72393_1_, p_72393_3_, p_72393_5_, p_72393_7_, p_72393_9_, p_72393_10_);
    }

    public void func_72397_a(EntityPlayer p_72397_1_, double p_72397_2_, double p_72397_4_, double p_72397_6_, double p_72397_8_, int p_72397_10_, Packet p_72397_11_)
    {
        for (int j = 0; j < this.field_72404_b.size(); ++j)
        {
            EntityPlayerMP entityplayermp = (EntityPlayerMP)this.field_72404_b.get(j);

            if (entityplayermp != p_72397_1_ && entityplayermp.field_71093_bK == p_72397_10_)
            {
                double d4 = p_72397_2_ - entityplayermp.field_70165_t;
                double d5 = p_72397_4_ - entityplayermp.field_70163_u;
                double d6 = p_72397_6_ - entityplayermp.field_70161_v;

                if (d4 * d4 + d5 * d5 + d6 * d6 < p_72397_8_ * p_72397_8_)
                {
                    entityplayermp.field_71135_a.func_72567_b(p_72397_11_);
                }
            }
        }
    }

    public void func_72389_g()
    {
        for (int i = 0; i < this.field_72404_b.size(); ++i)
        {
            this.func_72391_b((EntityPlayerMP)this.field_72404_b.get(i));
        }
    }

    public void func_72359_h(String p_72359_1_)
    {
        this.field_72411_j.add(p_72359_1_);
    }

    public void func_72379_i(String p_72379_1_)
    {
        this.field_72411_j.remove(p_72379_1_);
    }

    public Set func_72388_h()
    {
        return this.field_72411_j;
    }

    public Set func_72376_i()
    {
        return this.field_72414_i;
    }

    public void func_72362_j() {}

    public void func_72354_b(EntityPlayerMP p_72354_1_, WorldServer p_72354_2_)
    {
        p_72354_1_.field_71135_a.func_72567_b(new Packet4UpdateTime(p_72354_2_.func_82737_E(), p_72354_2_.func_72820_D(), p_72354_2_.func_82736_K().func_82766_b("doDaylightCycle")));

        if (p_72354_2_.func_72896_J())
        {
            p_72354_1_.field_71135_a.func_72567_b(new Packet70GameEvent(1, 0));
        }
    }

    public void func_72385_f(EntityPlayerMP p_72385_1_)
    {
        p_72385_1_.func_71120_a(p_72385_1_.field_71069_bz);
        p_72385_1_.func_71118_n();
        p_72385_1_.field_71135_a.func_72567_b(new Packet16BlockItemSwitch(p_72385_1_.field_71071_by.field_70461_c));
    }

    public int func_72394_k()
    {
        return this.field_72404_b.size();
    }

    public int func_72352_l()
    {
        return this.field_72405_c;
    }

    public String[] func_72373_m()
    {
        return this.field_72400_f.field_71305_c[0].func_72860_G().func_75756_e().func_75754_f();
    }

    public boolean func_72383_n()
    {
        return this.field_72409_l;
    }

    public void func_72371_a(boolean p_72371_1_)
    {
        this.field_72409_l = p_72371_1_;
    }

    public List func_72382_j(String p_72382_1_)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = this.field_72404_b.iterator();

        while (iterator.hasNext())
        {
            EntityPlayerMP entityplayermp = (EntityPlayerMP)iterator.next();

            if (entityplayermp.func_71114_r().equals(p_72382_1_))
            {
                arraylist.add(entityplayermp);
            }
        }

        return arraylist;
    }

    public int func_72395_o()
    {
        return this.field_72402_d;
    }

    public MinecraftServer func_72365_p()
    {
        return this.field_72400_f;
    }

    public NBTTagCompound func_72378_q()
    {
        return null;
    }

    @SideOnly(Side.CLIENT)
    public void func_72357_a(EnumGameType p_72357_1_)
    {
        this.field_72410_m = p_72357_1_;
    }

    private void func_72381_a(EntityPlayerMP p_72381_1_, EntityPlayerMP p_72381_2_, World p_72381_3_)
    {
        if (p_72381_2_ != null)
        {
            p_72381_1_.field_71134_c.func_73076_a(p_72381_2_.field_71134_c.func_73081_b());
        }
        else if (this.field_72410_m != null)
        {
            p_72381_1_.field_71134_c.func_73076_a(this.field_72410_m);
        }

        p_72381_1_.field_71134_c.func_73077_b(p_72381_3_.func_72912_H().func_76077_q());
    }

    @SideOnly(Side.CLIENT)
    public void func_72387_b(boolean p_72387_1_)
    {
        this.field_72407_n = p_72387_1_;
    }

    public void func_72392_r()
    {
        while (!this.field_72404_b.isEmpty())
        {
            ((EntityPlayerMP)this.field_72404_b.get(0)).field_71135_a.func_72565_c("Server closed");
        }
    }

    public void func_110459_a(ChatMessageComponent p_110459_1_, boolean p_110459_2_)
    {
        this.field_72400_f.func_70006_a(p_110459_1_);
        this.func_72384_a(new Packet3Chat(p_110459_1_, p_110459_2_));
    }

    public void func_92062_k(ChatMessageComponent p_92062_1_)
    {
        this.func_110459_a(p_92062_1_, true);
    }
}
