package net.minecraft.client.multiplayer;

import com.google.common.base.Charsets;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.URLEncoder;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.crypto.SecretKey;
import net.minecraft.client.ClientBrandRetriever;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiDisconnected;
import net.minecraft.client.gui.GuiDownloadTerrain;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiMerchant;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiPlayerInfo;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenDemo;
import net.minecraft.client.gui.GuiScreenDisconnectedOnline;
import net.minecraft.client.gui.GuiWinGame;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.particle.EntityCrit2FX;
import net.minecraft.client.particle.EntityPickupFX;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLeashKnot;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.NpcMerchant;
import net.minecraft.entity.ai.attributes.AttributeInstance;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityEnderEye;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.item.EntityFallingSand;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.inventory.AnimalChest;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMap;
import net.minecraft.item.ItemStack;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.MemoryConnection;
import net.minecraft.network.TcpConnection;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet0KeepAlive;
import net.minecraft.network.packet.Packet100OpenWindow;
import net.minecraft.network.packet.Packet101CloseWindow;
import net.minecraft.network.packet.Packet103SetSlot;
import net.minecraft.network.packet.Packet104WindowItems;
import net.minecraft.network.packet.Packet105UpdateProgressbar;
import net.minecraft.network.packet.Packet106Transaction;
import net.minecraft.network.packet.Packet10Flying;
import net.minecraft.network.packet.Packet130UpdateSign;
import net.minecraft.network.packet.Packet131MapData;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.network.packet.Packet133TileEditorOpen;
import net.minecraft.network.packet.Packet16BlockItemSwitch;
import net.minecraft.network.packet.Packet17Sleep;
import net.minecraft.network.packet.Packet18Animation;
import net.minecraft.network.packet.Packet1Login;
import net.minecraft.network.packet.Packet200Statistic;
import net.minecraft.network.packet.Packet201PlayerInfo;
import net.minecraft.network.packet.Packet202PlayerAbilities;
import net.minecraft.network.packet.Packet203AutoComplete;
import net.minecraft.network.packet.Packet205ClientCommand;
import net.minecraft.network.packet.Packet206SetObjective;
import net.minecraft.network.packet.Packet207SetScore;
import net.minecraft.network.packet.Packet208SetDisplayObjective;
import net.minecraft.network.packet.Packet209SetPlayerTeam;
import net.minecraft.network.packet.Packet20NamedEntitySpawn;
import net.minecraft.network.packet.Packet22Collect;
import net.minecraft.network.packet.Packet23VehicleSpawn;
import net.minecraft.network.packet.Packet24MobSpawn;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.network.packet.Packet252SharedKey;
import net.minecraft.network.packet.Packet253ServerAuthData;
import net.minecraft.network.packet.Packet255KickDisconnect;
import net.minecraft.network.packet.Packet25EntityPainting;
import net.minecraft.network.packet.Packet26EntityExpOrb;
import net.minecraft.network.packet.Packet28EntityVelocity;
import net.minecraft.network.packet.Packet29DestroyEntity;
import net.minecraft.network.packet.Packet30Entity;
import net.minecraft.network.packet.Packet34EntityTeleport;
import net.minecraft.network.packet.Packet35EntityHeadRotation;
import net.minecraft.network.packet.Packet38EntityStatus;
import net.minecraft.network.packet.Packet39AttachEntity;
import net.minecraft.network.packet.Packet3Chat;
import net.minecraft.network.packet.Packet40EntityMetadata;
import net.minecraft.network.packet.Packet41EntityEffect;
import net.minecraft.network.packet.Packet42RemoveEntityEffect;
import net.minecraft.network.packet.Packet43Experience;
import net.minecraft.network.packet.Packet44UpdateAttributes;
import net.minecraft.network.packet.Packet44UpdateAttributesSnapshot;
import net.minecraft.network.packet.Packet4UpdateTime;
import net.minecraft.network.packet.Packet51MapChunk;
import net.minecraft.network.packet.Packet52MultiBlockChange;
import net.minecraft.network.packet.Packet53BlockChange;
import net.minecraft.network.packet.Packet54PlayNoteBlock;
import net.minecraft.network.packet.Packet55BlockDestroy;
import net.minecraft.network.packet.Packet56MapChunks;
import net.minecraft.network.packet.Packet5PlayerInventory;
import net.minecraft.network.packet.Packet60Explosion;
import net.minecraft.network.packet.Packet61DoorChange;
import net.minecraft.network.packet.Packet62LevelSound;
import net.minecraft.network.packet.Packet63WorldParticles;
import net.minecraft.network.packet.Packet6SpawnPosition;
import net.minecraft.network.packet.Packet70GameEvent;
import net.minecraft.network.packet.Packet71Weather;
import net.minecraft.network.packet.Packet8UpdateHealth;
import net.minecraft.network.packet.Packet9Respawn;
import net.minecraft.potion.PotionEffect;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScoreObjectiveCriteria;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.tileentity.TileEntityBrewingStand;
import net.minecraft.tileentity.TileEntityCommandBlock;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.tileentity.TileEntityDropper;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.CryptManager;
import net.minecraft.util.MathHelper;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.EnumGameType;
import net.minecraft.world.Explosion;
import net.minecraft.world.WorldProviderSurface;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.MapStorage;
import org.lwjgl.input.Keyboard;

@SideOnly(Side.CLIENT)
public class NetClientHandler extends NetHandler
{
    private boolean field_72554_f;
    private INetworkManager field_72555_g;
    public String field_72560_a;
    private Minecraft field_72563_h;
    private WorldClient field_72564_i;
    private boolean field_72561_j;
    public MapStorage field_72558_b = new MapStorage((ISaveHandler)null);
    private Map field_72562_k = new HashMap();
    public List field_72559_c = new ArrayList();
    public int field_72556_d = 20;
    private GuiScreen field_98183_l;
    Random field_72557_e = new Random();

    public NetClientHandler(Minecraft p_i1176_1_, String p_i1176_2_, int p_i1176_3_) throws IOException
    {
        this.field_72563_h = p_i1176_1_;
        Socket socket = new Socket(InetAddress.getByName(p_i1176_2_), p_i1176_3_);
        this.field_72555_g = new TcpConnection(p_i1176_1_.func_98033_al(), socket, "Client", this);
    }

    public NetClientHandler(Minecraft p_i1177_1_, String p_i1177_2_, int p_i1177_3_, GuiScreen p_i1177_4_) throws IOException
    {
        this.field_72563_h = p_i1177_1_;
        this.field_98183_l = p_i1177_4_;
        Socket socket = new Socket(InetAddress.getByName(p_i1177_2_), p_i1177_3_);
        this.field_72555_g = new TcpConnection(p_i1177_1_.func_98033_al(), socket, "Client", this);
    }

    public NetClientHandler(Minecraft p_i1178_1_, IntegratedServer p_i1178_2_) throws IOException
    {
        this.field_72563_h = p_i1178_1_;
        this.field_72555_g = new MemoryConnection(p_i1178_1_.func_98033_al(), this);
        p_i1178_2_.func_71343_a().func_71754_a((MemoryConnection)this.field_72555_g, p_i1178_1_.func_110432_I().func_111285_a());
    }

    public void func_72547_c()
    {
        if (this.field_72555_g != null)
        {
            this.field_72555_g.func_74427_a();
        }

        this.field_72555_g = null;
        this.field_72564_i = null;
    }

    public void func_72551_d()
    {
        if (!this.field_72554_f && this.field_72555_g != null)
        {
            this.field_72555_g.func_74428_b();
        }

        if (this.field_72555_g != null)
        {
            this.field_72555_g.func_74427_a();
        }
    }

    public void func_72470_a(Packet253ServerAuthData p_72470_1_)
    {
        String s = p_72470_1_.func_73377_d().trim();
        PublicKey publickey = p_72470_1_.func_73376_f();
        SecretKey secretkey = CryptManager.func_75890_a();

        if (!"-".equals(s))
        {
            String s1 = (new BigInteger(CryptManager.func_75895_a(s, publickey, secretkey))).toString(16);
            String s2 = this.func_72550_a(this.field_72563_h.func_110432_I().func_111285_a(), this.field_72563_h.func_110432_I().func_111286_b(), s1);

            if (!"ok".equalsIgnoreCase(s2))
            {
                this.field_72555_g.func_74424_a("disconnect.loginFailedInfo", new Object[] {s2});
                return;
            }
        }

        this.func_72552_c(new Packet252SharedKey(secretkey, publickey, p_72470_1_.func_73378_g()));
    }

    private String func_72550_a(String p_72550_1_, String p_72550_2_, String p_72550_3_)
    {
        try
        {
            URL url = new URL("http://session.minecraft.net/game/joinserver.jsp?user=" + func_72549_a(p_72550_1_) + "&sessionId=" + func_72549_a(p_72550_2_) + "&serverId=" + func_72549_a(p_72550_3_));
            InputStream inputstream = url.openConnection(this.field_72563_h.func_110437_J()).getInputStream();
            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
            String s3 = bufferedreader.readLine();
            bufferedreader.close();
            return s3;
        }
        catch (IOException ioexception)
        {
            return ioexception.toString();
        }
    }

    private static String func_72549_a(String p_72549_0_) throws IOException
    {
        return URLEncoder.encode(p_72549_0_, "UTF-8");
    }

    public void func_72513_a(Packet252SharedKey p_72513_1_)
    {
        this.func_72552_c(new Packet205ClientCommand(0));
    }

    public void func_72455_a(Packet1Login p_72455_1_)
    {
        this.field_72563_h.field_71442_b = new PlayerControllerMP(this.field_72563_h, this);
        this.field_72563_h.field_71413_E.func_77450_a(StatList.field_75950_i, 1);
        this.field_72564_i = new WorldClient(this, new WorldSettings(0L, p_72455_1_.field_73557_d, false, p_72455_1_.field_73560_c, p_72455_1_.field_73559_b), p_72455_1_.field_73558_e, p_72455_1_.field_73555_f, this.field_72563_h.field_71424_I, this.field_72563_h.func_98033_al());
        this.field_72564_i.field_72995_K = true;
        this.field_72563_h.func_71403_a(this.field_72564_i);
        this.field_72563_h.field_71439_g.field_71093_bK = p_72455_1_.field_73558_e;
        this.field_72563_h.func_71373_a(new GuiDownloadTerrain(this));
        this.field_72563_h.field_71439_g.field_70157_k = p_72455_1_.field_73561_a;
        this.field_72556_d = p_72455_1_.field_73562_h;
        this.field_72563_h.field_71442_b.func_78746_a(p_72455_1_.field_73557_d);
        this.field_72563_h.field_71474_y.func_82879_c();
        this.field_72555_g.func_74429_a(new Packet250CustomPayload("MC|Brand", ClientBrandRetriever.getClientModName().getBytes(Charsets.UTF_8)));
    }

    public void func_72511_a(Packet23VehicleSpawn p_72511_1_)
    {
        double d0 = (double)p_72511_1_.field_73524_b / 32.0D;
        double d1 = (double)p_72511_1_.field_73525_c / 32.0D;
        double d2 = (double)p_72511_1_.field_73522_d / 32.0D;
        Object object = null;

        if (p_72511_1_.field_73527_h == 10)
        {
            object = EntityMinecart.func_94090_a(this.field_72564_i, d0, d1, d2, p_72511_1_.field_73528_i);
        }
        else if (p_72511_1_.field_73527_h == 90)
        {
            Entity entity = this.func_72545_a(p_72511_1_.field_73528_i);

            if (entity instanceof EntityPlayer)
            {
                object = new EntityFishHook(this.field_72564_i, d0, d1, d2, (EntityPlayer)entity);
            }

            p_72511_1_.field_73528_i = 0;
        }
        else if (p_72511_1_.field_73527_h == 60)
        {
            object = new EntityArrow(this.field_72564_i, d0, d1, d2);
        }
        else if (p_72511_1_.field_73527_h == 61)
        {
            object = new EntitySnowball(this.field_72564_i, d0, d1, d2);
        }
        else if (p_72511_1_.field_73527_h == 71)
        {
            object = new EntityItemFrame(this.field_72564_i, (int)d0, (int)d1, (int)d2, p_72511_1_.field_73528_i);
            p_72511_1_.field_73528_i = 0;
        }
        else if (p_72511_1_.field_73527_h == 77)
        {
            object = new EntityLeashKnot(this.field_72564_i, (int)d0, (int)d1, (int)d2);
            p_72511_1_.field_73528_i = 0;
        }
        else if (p_72511_1_.field_73527_h == 65)
        {
            object = new EntityEnderPearl(this.field_72564_i, d0, d1, d2);
        }
        else if (p_72511_1_.field_73527_h == 72)
        {
            object = new EntityEnderEye(this.field_72564_i, d0, d1, d2);
        }
        else if (p_72511_1_.field_73527_h == 76)
        {
            object = new EntityFireworkRocket(this.field_72564_i, d0, d1, d2, (ItemStack)null);
        }
        else if (p_72511_1_.field_73527_h == 63)
        {
            object = new EntityLargeFireball(this.field_72564_i, d0, d1, d2, (double)p_72511_1_.field_73523_e / 8000.0D, (double)p_72511_1_.field_73520_f / 8000.0D, (double)p_72511_1_.field_73521_g / 8000.0D);
            p_72511_1_.field_73528_i = 0;
        }
        else if (p_72511_1_.field_73527_h == 64)
        {
            object = new EntitySmallFireball(this.field_72564_i, d0, d1, d2, (double)p_72511_1_.field_73523_e / 8000.0D, (double)p_72511_1_.field_73520_f / 8000.0D, (double)p_72511_1_.field_73521_g / 8000.0D);
            p_72511_1_.field_73528_i = 0;
        }
        else if (p_72511_1_.field_73527_h == 66)
        {
            object = new EntityWitherSkull(this.field_72564_i, d0, d1, d2, (double)p_72511_1_.field_73523_e / 8000.0D, (double)p_72511_1_.field_73520_f / 8000.0D, (double)p_72511_1_.field_73521_g / 8000.0D);
            p_72511_1_.field_73528_i = 0;
        }
        else if (p_72511_1_.field_73527_h == 62)
        {
            object = new EntityEgg(this.field_72564_i, d0, d1, d2);
        }
        else if (p_72511_1_.field_73527_h == 73)
        {
            object = new EntityPotion(this.field_72564_i, d0, d1, d2, p_72511_1_.field_73528_i);
            p_72511_1_.field_73528_i = 0;
        }
        else if (p_72511_1_.field_73527_h == 75)
        {
            object = new EntityExpBottle(this.field_72564_i, d0, d1, d2);
            p_72511_1_.field_73528_i = 0;
        }
        else if (p_72511_1_.field_73527_h == 1)
        {
            object = new EntityBoat(this.field_72564_i, d0, d1, d2);
        }
        else if (p_72511_1_.field_73527_h == 50)
        {
            object = new EntityTNTPrimed(this.field_72564_i, d0, d1, d2, (EntityLivingBase)null);
        }
        else if (p_72511_1_.field_73527_h == 51)
        {
            object = new EntityEnderCrystal(this.field_72564_i, d0, d1, d2);
        }
        else if (p_72511_1_.field_73527_h == 2)
        {
            object = new EntityItem(this.field_72564_i, d0, d1, d2);
        }
        else if (p_72511_1_.field_73527_h == 70)
        {
            object = new EntityFallingSand(this.field_72564_i, d0, d1, d2, p_72511_1_.field_73528_i & 65535, p_72511_1_.field_73528_i >> 16);
            p_72511_1_.field_73528_i = 0;
        }

        if (object != null)
        {
            ((Entity)object).field_70118_ct = p_72511_1_.field_73524_b;
            ((Entity)object).field_70117_cu = p_72511_1_.field_73525_c;
            ((Entity)object).field_70116_cv = p_72511_1_.field_73522_d;
            ((Entity)object).field_70125_A = (float)(p_72511_1_.field_92077_h * 360) / 256.0F;
            ((Entity)object).field_70177_z = (float)(p_72511_1_.field_92078_i * 360) / 256.0F;
            Entity[] aentity = ((Entity)object).func_70021_al();

            if (aentity != null)
            {
                int i = p_72511_1_.field_73526_a - ((Entity)object).field_70157_k;

                for (int j = 0; j < aentity.length; ++j)
                {
                    aentity[j].field_70157_k += i;
                }
            }

            ((Entity)object).field_70157_k = p_72511_1_.field_73526_a;
            this.field_72564_i.func_73027_a(p_72511_1_.field_73526_a, (Entity)object);

            if (p_72511_1_.field_73528_i > 0)
            {
                if (p_72511_1_.field_73527_h == 60)
                {
                    Entity entity1 = this.func_72545_a(p_72511_1_.field_73528_i);

                    if (entity1 instanceof EntityLivingBase)
                    {
                        EntityArrow entityarrow = (EntityArrow)object;
                        entityarrow.field_70250_c = entity1;
                    }
                }

                ((Entity)object).func_70016_h((double)p_72511_1_.field_73523_e / 8000.0D, (double)p_72511_1_.field_73520_f / 8000.0D, (double)p_72511_1_.field_73521_g / 8000.0D);
            }
        }
    }

    public void func_72514_a(Packet26EntityExpOrb p_72514_1_)
    {
        EntityXPOrb entityxporb = new EntityXPOrb(this.field_72564_i, (double)p_72514_1_.field_73531_b, (double)p_72514_1_.field_73532_c, (double)p_72514_1_.field_73529_d, p_72514_1_.field_73530_e);
        entityxporb.field_70118_ct = p_72514_1_.field_73531_b;
        entityxporb.field_70117_cu = p_72514_1_.field_73532_c;
        entityxporb.field_70116_cv = p_72514_1_.field_73529_d;
        entityxporb.field_70177_z = 0.0F;
        entityxporb.field_70125_A = 0.0F;
        entityxporb.field_70157_k = p_72514_1_.field_73533_a;
        this.field_72564_i.func_73027_a(p_72514_1_.field_73533_a, entityxporb);
    }

    public void func_72508_a(Packet71Weather p_72508_1_)
    {
        double d0 = (double)p_72508_1_.field_73536_b / 32.0D;
        double d1 = (double)p_72508_1_.field_73537_c / 32.0D;
        double d2 = (double)p_72508_1_.field_73534_d / 32.0D;
        EntityLightningBolt entitylightningbolt = null;

        if (p_72508_1_.field_73535_e == 1)
        {
            entitylightningbolt = new EntityLightningBolt(this.field_72564_i, d0, d1, d2);
        }

        if (entitylightningbolt != null)
        {
            entitylightningbolt.field_70118_ct = p_72508_1_.field_73536_b;
            entitylightningbolt.field_70117_cu = p_72508_1_.field_73537_c;
            entitylightningbolt.field_70116_cv = p_72508_1_.field_73534_d;
            entitylightningbolt.field_70177_z = 0.0F;
            entitylightningbolt.field_70125_A = 0.0F;
            entitylightningbolt.field_70157_k = p_72508_1_.field_73538_a;
            this.field_72564_i.func_72942_c(entitylightningbolt);
        }
    }

    public void func_72495_a(Packet25EntityPainting p_72495_1_)
    {
        EntityPainting entitypainting = new EntityPainting(this.field_72564_i, p_72495_1_.field_73506_b, p_72495_1_.field_73507_c, p_72495_1_.field_73504_d, p_72495_1_.field_73505_e, p_72495_1_.field_73503_f);
        this.field_72564_i.func_73027_a(p_72495_1_.field_73508_a, entitypainting);
    }

    public void func_72520_a(Packet28EntityVelocity p_72520_1_)
    {
        Entity entity = this.func_72545_a(p_72520_1_.field_73390_a);

        if (entity != null)
        {
            entity.func_70016_h((double)p_72520_1_.field_73388_b / 8000.0D, (double)p_72520_1_.field_73389_c / 8000.0D, (double)p_72520_1_.field_73387_d / 8000.0D);
        }
    }

    public void func_72493_a(Packet40EntityMetadata p_72493_1_)
    {
        Entity entity = this.func_72545_a(p_72493_1_.field_73393_a);

        if (entity != null && p_72493_1_.func_73391_d() != null)
        {
            entity.func_70096_w().func_75687_a(p_72493_1_.func_73391_d());
        }
    }

    public void func_72518_a(Packet20NamedEntitySpawn p_72518_1_)
    {
        double d0 = (double)p_72518_1_.field_73515_c / 32.0D;
        double d1 = (double)p_72518_1_.field_73512_d / 32.0D;
        double d2 = (double)p_72518_1_.field_73513_e / 32.0D;
        float f = (float)(p_72518_1_.field_73510_f * 360) / 256.0F;
        float f1 = (float)(p_72518_1_.field_73511_g * 360) / 256.0F;
        EntityOtherPlayerMP entityotherplayermp = new EntityOtherPlayerMP(this.field_72563_h.field_71441_e, p_72518_1_.field_73514_b);
        entityotherplayermp.field_70169_q = entityotherplayermp.field_70142_S = (double)(entityotherplayermp.field_70118_ct = p_72518_1_.field_73515_c);
        entityotherplayermp.field_70167_r = entityotherplayermp.field_70137_T = (double)(entityotherplayermp.field_70117_cu = p_72518_1_.field_73512_d);
        entityotherplayermp.field_70166_s = entityotherplayermp.field_70136_U = (double)(entityotherplayermp.field_70116_cv = p_72518_1_.field_73513_e);
        int i = p_72518_1_.field_73518_h;

        if (i == 0)
        {
            entityotherplayermp.field_71071_by.field_70462_a[entityotherplayermp.field_71071_by.field_70461_c] = null;
        }
        else
        {
            entityotherplayermp.field_71071_by.field_70462_a[entityotherplayermp.field_71071_by.field_70461_c] = new ItemStack(i, 1, 0);
        }

        entityotherplayermp.func_70080_a(d0, d1, d2, f, f1);
        this.field_72564_i.func_73027_a(p_72518_1_.field_73516_a, entityotherplayermp);
        List list = p_72518_1_.func_73509_c();

        if (list != null)
        {
            entityotherplayermp.func_70096_w().func_75687_a(list);
        }
    }

    public void func_72512_a(Packet34EntityTeleport p_72512_1_)
    {
        Entity entity = this.func_72545_a(p_72512_1_.field_73319_a);

        if (entity != null)
        {
            entity.field_70118_ct = p_72512_1_.field_73317_b;
            entity.field_70117_cu = p_72512_1_.field_73318_c;
            entity.field_70116_cv = p_72512_1_.field_73315_d;
            double d0 = (double)entity.field_70118_ct / 32.0D;
            double d1 = (double)entity.field_70117_cu / 32.0D + 0.015625D;
            double d2 = (double)entity.field_70116_cv / 32.0D;
            float f = (float)(p_72512_1_.field_73316_e * 360) / 256.0F;
            float f1 = (float)(p_72512_1_.field_73314_f * 360) / 256.0F;
            entity.func_70056_a(d0, d1, d2, f, f1, 3);
        }
    }

    public void func_72502_a(Packet16BlockItemSwitch p_72502_1_)
    {
        if (p_72502_1_.field_73386_a >= 0 && p_72502_1_.field_73386_a < InventoryPlayer.func_70451_h())
        {
            this.field_72563_h.field_71439_g.field_71071_by.field_70461_c = p_72502_1_.field_73386_a;
        }
    }

    public void func_72482_a(Packet30Entity p_72482_1_)
    {
        Entity entity = this.func_72545_a(p_72482_1_.field_73554_a);

        if (entity != null)
        {
            entity.field_70118_ct += p_72482_1_.field_73552_b;
            entity.field_70117_cu += p_72482_1_.field_73553_c;
            entity.field_70116_cv += p_72482_1_.field_73550_d;
            double d0 = (double)entity.field_70118_ct / 32.0D;
            double d1 = (double)entity.field_70117_cu / 32.0D;
            double d2 = (double)entity.field_70116_cv / 32.0D;
            float f = p_72482_1_.field_73549_g ? (float)(p_72482_1_.field_73551_e * 360) / 256.0F : entity.field_70177_z;
            float f1 = p_72482_1_.field_73549_g ? (float)(p_72482_1_.field_73548_f * 360) / 256.0F : entity.field_70125_A;
            entity.func_70056_a(d0, d1, d2, f, f1, 3);
        }
    }

    public void func_72478_a(Packet35EntityHeadRotation p_72478_1_)
    {
        Entity entity = this.func_72545_a(p_72478_1_.field_73383_a);

        if (entity != null)
        {
            float f = (float)(p_72478_1_.field_73382_b * 360) / 256.0F;
            entity.func_70034_d(f);
        }
    }

    public void func_72491_a(Packet29DestroyEntity p_72491_1_)
    {
        for (int i = 0; i < p_72491_1_.field_73368_a.length; ++i)
        {
            this.field_72564_i.func_73028_b(p_72491_1_.field_73368_a[i]);
        }
    }

    public void func_72498_a(Packet10Flying p_72498_1_)
    {
        EntityClientPlayerMP entityclientplayermp = this.field_72563_h.field_71439_g;
        double d0 = entityclientplayermp.field_70165_t;
        double d1 = entityclientplayermp.field_70163_u;
        double d2 = entityclientplayermp.field_70161_v;
        float f = entityclientplayermp.field_70177_z;
        float f1 = entityclientplayermp.field_70125_A;

        if (p_72498_1_.field_73546_h)
        {
            d0 = p_72498_1_.field_73545_a;
            d1 = p_72498_1_.field_73543_b;
            d2 = p_72498_1_.field_73544_c;
        }

        if (p_72498_1_.field_73547_i)
        {
            f = p_72498_1_.field_73542_e;
            f1 = p_72498_1_.field_73539_f;
        }

        entityclientplayermp.field_70139_V = 0.0F;
        entityclientplayermp.field_70159_w = entityclientplayermp.field_70181_x = entityclientplayermp.field_70179_y = 0.0D;
        entityclientplayermp.func_70080_a(d0, d1, d2, f, f1);
        p_72498_1_.field_73545_a = entityclientplayermp.field_70165_t;
        p_72498_1_.field_73543_b = entityclientplayermp.field_70121_D.field_72338_b;
        p_72498_1_.field_73544_c = entityclientplayermp.field_70161_v;
        p_72498_1_.field_73541_d = entityclientplayermp.field_70163_u;
        this.field_72555_g.func_74429_a(p_72498_1_);

        if (!this.field_72561_j)
        {
            this.field_72563_h.field_71439_g.field_70169_q = this.field_72563_h.field_71439_g.field_70165_t;
            this.field_72563_h.field_71439_g.field_70167_r = this.field_72563_h.field_71439_g.field_70163_u;
            this.field_72563_h.field_71439_g.field_70166_s = this.field_72563_h.field_71439_g.field_70161_v;
            this.field_72561_j = true;
            this.field_72563_h.func_71373_a((GuiScreen)null);
        }
    }

    public void func_72496_a(Packet52MultiBlockChange p_72496_1_)
    {
        int i = p_72496_1_.field_73452_a * 16;
        int j = p_72496_1_.field_73450_b * 16;

        if (p_72496_1_.field_73451_c != null)
        {
            DataInputStream datainputstream = new DataInputStream(new ByteArrayInputStream(p_72496_1_.field_73451_c));

            try
            {
                for (int k = 0; k < p_72496_1_.field_73448_d; ++k)
                {
                    short short1 = datainputstream.readShort();
                    short short2 = datainputstream.readShort();
                    int l = short2 >> 4 & 4095;
                    int i1 = short2 & 15;
                    int j1 = short1 >> 12 & 15;
                    int k1 = short1 >> 8 & 15;
                    int l1 = short1 & 255;
                    this.field_72564_i.func_73023_g(j1 + i, l1, k1 + j, l, i1);
                }
            }
            catch (IOException ioexception)
            {
                ;
            }
        }
    }

    public void func_72463_a(Packet51MapChunk p_72463_1_)
    {
        if (p_72463_1_.field_73598_e)
        {
            if (p_72463_1_.field_73600_c == 0)
            {
                this.field_72564_i.func_73025_a(p_72463_1_.field_73601_a, p_72463_1_.field_73599_b, false);
                return;
            }

            this.field_72564_i.func_73025_a(p_72463_1_.field_73601_a, p_72463_1_.field_73599_b, true);
        }

        this.field_72564_i.func_73031_a(p_72463_1_.field_73601_a << 4, 0, p_72463_1_.field_73599_b << 4, (p_72463_1_.field_73601_a << 4) + 15, 256, (p_72463_1_.field_73599_b << 4) + 15);
        Chunk chunk = this.field_72564_i.func_72964_e(p_72463_1_.field_73601_a, p_72463_1_.field_73599_b);

        if (p_72463_1_.field_73598_e && chunk == null)
        {
            this.field_72564_i.func_73025_a(p_72463_1_.field_73601_a, p_72463_1_.field_73599_b, true);
            chunk = this.field_72564_i.func_72964_e(p_72463_1_.field_73601_a, p_72463_1_.field_73599_b);
        }

        if (chunk != null)
        {
            chunk.func_76607_a(p_72463_1_.func_73593_d(), p_72463_1_.field_73600_c, p_72463_1_.field_73597_d, p_72463_1_.field_73598_e);
            this.field_72564_i.func_72909_d(p_72463_1_.field_73601_a << 4, 0, p_72463_1_.field_73599_b << 4, (p_72463_1_.field_73601_a << 4) + 15, 256, (p_72463_1_.field_73599_b << 4) + 15);

            if (!p_72463_1_.field_73598_e || !(this.field_72564_i.field_73011_w instanceof WorldProviderSurface))
            {
                chunk.func_76613_n();
            }
        }
    }

    public void func_72456_a(Packet53BlockChange p_72456_1_)
    {
        this.field_72564_i.func_73023_g(p_72456_1_.field_73425_a, p_72456_1_.field_73423_b, p_72456_1_.field_73424_c, p_72456_1_.field_73421_d, p_72456_1_.field_73422_e);
    }

    public void func_72492_a(Packet255KickDisconnect p_72492_1_)
    {
        this.field_72555_g.func_74424_a("disconnect.kicked", new Object[0]);
        this.field_72554_f = true;
        this.field_72563_h.func_71403_a((WorldClient)null);

        if (this.field_98183_l != null)
        {
            this.field_72563_h.func_71373_a(new GuiScreenDisconnectedOnline(this.field_98183_l, "disconnect.disconnected", "disconnect.genericReason", new Object[] {p_72492_1_.field_73631_a}));
        }
        else
        {
            this.field_72563_h.func_71373_a(new GuiDisconnected(new GuiMultiplayer(new GuiMainMenu()), "disconnect.disconnected", "disconnect.genericReason", new Object[] {p_72492_1_.field_73631_a}));
        }
    }

    public void func_72515_a(String p_72515_1_, Object[] p_72515_2_)
    {
        if (!this.field_72554_f)
        {
            this.field_72554_f = true;
            this.field_72563_h.func_71403_a((WorldClient)null);

            if (this.field_98183_l != null)
            {
                this.field_72563_h.func_71373_a(new GuiScreenDisconnectedOnline(this.field_98183_l, "disconnect.lost", p_72515_1_, p_72515_2_));
            }
            else
            {
                this.field_72563_h.func_71373_a(new GuiDisconnected(new GuiMultiplayer(new GuiMainMenu()), "disconnect.lost", p_72515_1_, p_72515_2_));
            }
        }
    }

    public void func_72546_b(Packet p_72546_1_)
    {
        if (!this.field_72554_f)
        {
            this.field_72555_g.func_74429_a(p_72546_1_);
            this.field_72555_g.func_74423_d();
        }
    }

    public void func_72552_c(Packet p_72552_1_)
    {
        if (!this.field_72554_f)
        {
            this.field_72555_g.func_74429_a(p_72552_1_);
        }
    }

    public void func_72475_a(Packet22Collect p_72475_1_)
    {
        Entity entity = this.func_72545_a(p_72475_1_.field_73313_a);
        Object object = (EntityLivingBase)this.func_72545_a(p_72475_1_.field_73312_b);

        if (object == null)
        {
            object = this.field_72563_h.field_71439_g;
        }

        if (entity != null)
        {
            if (entity instanceof EntityXPOrb)
            {
                this.field_72564_i.func_72956_a(entity, "random.orb", 0.2F, ((this.field_72557_e.nextFloat() - this.field_72557_e.nextFloat()) * 0.7F + 1.0F) * 2.0F);
            }
            else
            {
                this.field_72564_i.func_72956_a(entity, "random.pop", 0.2F, ((this.field_72557_e.nextFloat() - this.field_72557_e.nextFloat()) * 0.7F + 1.0F) * 2.0F);
            }

            this.field_72563_h.field_71452_i.func_78873_a(new EntityPickupFX(this.field_72563_h.field_71441_e, entity, (Entity)object, -0.5F));
            this.field_72564_i.func_73028_b(p_72475_1_.field_73313_a);
        }
    }

    public void func_72481_a(Packet3Chat p_72481_1_)
    {
        this.field_72563_h.field_71456_v.func_73827_b().func_73765_a(ChatMessageComponent.func_111078_c(p_72481_1_.field_73476_b).func_111068_a(true));
    }

    public void func_72524_a(Packet18Animation p_72524_1_)
    {
        Entity entity = this.func_72545_a(p_72524_1_.field_73470_a);

        if (entity != null)
        {
            if (p_72524_1_.field_73469_b == 1)
            {
                EntityLivingBase entitylivingbase = (EntityLivingBase)entity;
                entitylivingbase.func_71038_i();
            }
            else if (p_72524_1_.field_73469_b == 2)
            {
                entity.func_70057_ab();
            }
            else if (p_72524_1_.field_73469_b == 3)
            {
                EntityPlayer entityplayer = (EntityPlayer)entity;
                entityplayer.func_70999_a(false, false, false);
            }
            else if (p_72524_1_.field_73469_b != 4)
            {
                if (p_72524_1_.field_73469_b == 6)
                {
                    this.field_72563_h.field_71452_i.func_78873_a(new EntityCrit2FX(this.field_72563_h.field_71441_e, entity));
                }
                else if (p_72524_1_.field_73469_b == 7)
                {
                    EntityCrit2FX entitycrit2fx = new EntityCrit2FX(this.field_72563_h.field_71441_e, entity, "magicCrit");
                    this.field_72563_h.field_71452_i.func_78873_a(entitycrit2fx);
                }
                else if (p_72524_1_.field_73469_b == 5 && entity instanceof EntityOtherPlayerMP)
                {
                    ;
                }
            }
        }
    }

    public void func_72460_a(Packet17Sleep p_72460_1_)
    {
        Entity entity = this.func_72545_a(p_72460_1_.field_73625_a);

        if (entity != null)
        {
            if (p_72460_1_.field_73622_e == 0)
            {
                EntityPlayer entityplayer = (EntityPlayer)entity;
                entityplayer.func_71018_a(p_72460_1_.field_73623_b, p_72460_1_.field_73624_c, p_72460_1_.field_73621_d);
            }
        }
    }

    public void func_72553_e()
    {
        this.field_72554_f = true;
        this.field_72555_g.func_74427_a();
        this.field_72555_g.func_74424_a("disconnect.closed", new Object[0]);
    }

    public void func_72519_a(Packet24MobSpawn p_72519_1_)
    {
        double d0 = (double)p_72519_1_.field_73495_c / 32.0D;
        double d1 = (double)p_72519_1_.field_73492_d / 32.0D;
        double d2 = (double)p_72519_1_.field_73493_e / 32.0D;
        float f = (float)(p_72519_1_.field_73500_i * 360) / 256.0F;
        float f1 = (float)(p_72519_1_.field_73497_j * 360) / 256.0F;
        EntityLivingBase entitylivingbase = (EntityLivingBase)EntityList.func_75616_a(p_72519_1_.field_73494_b, this.field_72563_h.field_71441_e);
        entitylivingbase.field_70118_ct = p_72519_1_.field_73495_c;
        entitylivingbase.field_70117_cu = p_72519_1_.field_73492_d;
        entitylivingbase.field_70116_cv = p_72519_1_.field_73493_e;
        entitylivingbase.field_70759_as = (float)(p_72519_1_.field_73498_k * 360) / 256.0F;
        Entity[] aentity = entitylivingbase.func_70021_al();

        if (aentity != null)
        {
            int i = p_72519_1_.field_73496_a - entitylivingbase.field_70157_k;

            for (int j = 0; j < aentity.length; ++j)
            {
                aentity[j].field_70157_k += i;
            }
        }

        entitylivingbase.field_70157_k = p_72519_1_.field_73496_a;
        entitylivingbase.func_70080_a(d0, d1, d2, f, f1);
        entitylivingbase.field_70159_w = (double)((float)p_72519_1_.field_73490_f / 8000.0F);
        entitylivingbase.field_70181_x = (double)((float)p_72519_1_.field_73491_g / 8000.0F);
        entitylivingbase.field_70179_y = (double)((float)p_72519_1_.field_73499_h / 8000.0F);
        this.field_72564_i.func_73027_a(p_72519_1_.field_73496_a, entitylivingbase);
        List list = p_72519_1_.func_73489_c();

        if (list != null)
        {
            entitylivingbase.func_70096_w().func_75687_a(list);
        }
    }

    public void func_72497_a(Packet4UpdateTime p_72497_1_)
    {
        this.field_72563_h.field_71441_e.func_82738_a(p_72497_1_.field_82562_a);
        this.field_72563_h.field_71441_e.func_72877_b(p_72497_1_.field_73301_a);
    }

    public void func_72466_a(Packet6SpawnPosition p_72466_1_)
    {
        this.field_72563_h.field_71439_g.func_71063_a(new ChunkCoordinates(p_72466_1_.field_73300_a, p_72466_1_.field_73298_b, p_72466_1_.field_73299_c), true);
        this.field_72563_h.field_71441_e.func_72912_H().func_76081_a(p_72466_1_.field_73300_a, p_72466_1_.field_73298_b, p_72466_1_.field_73299_c);
    }

    public void func_72484_a(Packet39AttachEntity p_72484_1_)
    {
        Object object = this.func_72545_a(p_72484_1_.field_111006_b);
        Entity entity = this.func_72545_a(p_72484_1_.field_73296_b);

        if (p_72484_1_.field_111007_a == 0)
        {
            boolean flag = false;

            if (p_72484_1_.field_111006_b == this.field_72563_h.field_71439_g.field_70157_k)
            {
                object = this.field_72563_h.field_71439_g;

                if (entity instanceof EntityBoat)
                {
                    ((EntityBoat)entity).func_70270_d(false);
                }

                flag = ((Entity)object).field_70154_o == null && entity != null;
            }
            else if (entity instanceof EntityBoat)
            {
                ((EntityBoat)entity).func_70270_d(true);
            }

            if (object == null)
            {
                return;
            }

            ((Entity)object).func_70078_a(entity);

            if (flag)
            {
                GameSettings gamesettings = this.field_72563_h.field_71474_y;
                this.field_72563_h.field_71456_v.func_110326_a(I18n.func_135052_a("mount.onboard", new Object[] {GameSettings.func_74298_c(gamesettings.field_74311_E.field_74512_d)}), false);
            }
        }
        else if (p_72484_1_.field_111007_a == 1 && object != null && object instanceof EntityLiving)
        {
            if (entity != null)
            {
                ((EntityLiving)object).func_110162_b(entity, false);
            }
            else
            {
                ((EntityLiving)object).func_110160_i(false, false);
            }
        }
    }

    public void func_72485_a(Packet38EntityStatus p_72485_1_)
    {
        Entity entity = this.func_72545_a(p_72485_1_.field_73627_a);

        if (entity != null)
        {
            entity.func_70103_a(p_72485_1_.field_73626_b);
        }
    }

    private Entity func_72545_a(int p_72545_1_)
    {
        return (Entity)(p_72545_1_ == this.field_72563_h.field_71439_g.field_70157_k ? this.field_72563_h.field_71439_g : this.field_72564_i.func_73045_a(p_72545_1_));
    }

    public void func_72521_a(Packet8UpdateHealth p_72521_1_)
    {
        this.field_72563_h.field_71439_g.func_71150_b(p_72521_1_.field_73640_a);
        this.field_72563_h.field_71439_g.func_71024_bL().func_75114_a(p_72521_1_.field_73638_b);
        this.field_72563_h.field_71439_g.func_71024_bL().func_75119_b(p_72521_1_.field_73639_c);
    }

    public void func_72522_a(Packet43Experience p_72522_1_)
    {
        this.field_72563_h.field_71439_g.func_71152_a(p_72522_1_.field_73396_a, p_72522_1_.field_73394_b, p_72522_1_.field_73395_c);
    }

    public void func_72483_a(Packet9Respawn p_72483_1_)
    {
        if (p_72483_1_.field_73373_a != this.field_72563_h.field_71439_g.field_71093_bK)
        {
            this.field_72561_j = false;
            Scoreboard scoreboard = this.field_72564_i.func_96441_U();
            this.field_72564_i = new WorldClient(this, new WorldSettings(0L, p_72483_1_.field_73369_d, false, this.field_72563_h.field_71441_e.func_72912_H().func_76093_s(), p_72483_1_.field_73370_e), p_72483_1_.field_73373_a, p_72483_1_.field_73371_b, this.field_72563_h.field_71424_I, this.field_72563_h.func_98033_al());
            this.field_72564_i.func_96443_a(scoreboard);
            this.field_72564_i.field_72995_K = true;
            this.field_72563_h.func_71403_a(this.field_72564_i);
            this.field_72563_h.field_71439_g.field_71093_bK = p_72483_1_.field_73373_a;
            this.field_72563_h.func_71373_a(new GuiDownloadTerrain(this));
        }

        this.field_72563_h.func_71354_a(p_72483_1_.field_73373_a);
        this.field_72563_h.field_71442_b.func_78746_a(p_72483_1_.field_73369_d);
    }

    public void func_72499_a(Packet60Explosion p_72499_1_)
    {
        Explosion explosion = new Explosion(this.field_72563_h.field_71441_e, (Entity)null, p_72499_1_.field_73616_a, p_72499_1_.field_73614_b, p_72499_1_.field_73615_c, p_72499_1_.field_73612_d);
        explosion.field_77281_g = p_72499_1_.field_73613_e;
        explosion.func_77279_a(true);
        this.field_72563_h.field_71439_g.field_70159_w += (double)p_72499_1_.func_73607_d();
        this.field_72563_h.field_71439_g.field_70181_x += (double)p_72499_1_.func_73609_f();
        this.field_72563_h.field_71439_g.field_70179_y += (double)p_72499_1_.func_73608_g();
    }

    public void func_72516_a(Packet100OpenWindow p_72516_1_)
    {
        EntityClientPlayerMP entityclientplayermp = this.field_72563_h.field_71439_g;

        switch (p_72516_1_.field_73429_b)
        {
            case 0:
                entityclientplayermp.func_71007_a(new InventoryBasic(p_72516_1_.field_73430_c, p_72516_1_.field_94500_e, p_72516_1_.field_73428_d));
                entityclientplayermp.field_71070_bA.field_75152_c = p_72516_1_.field_73431_a;
                break;
            case 1:
                entityclientplayermp.func_71058_b(MathHelper.func_76128_c(entityclientplayermp.field_70165_t), MathHelper.func_76128_c(entityclientplayermp.field_70163_u), MathHelper.func_76128_c(entityclientplayermp.field_70161_v));
                entityclientplayermp.field_71070_bA.field_75152_c = p_72516_1_.field_73431_a;
                break;
            case 2:
                TileEntityFurnace tileentityfurnace = new TileEntityFurnace();

                if (p_72516_1_.field_94500_e)
                {
                    tileentityfurnace.func_94129_a(p_72516_1_.field_73430_c);
                }

                entityclientplayermp.func_71042_a(tileentityfurnace);
                entityclientplayermp.field_71070_bA.field_75152_c = p_72516_1_.field_73431_a;
                break;
            case 3:
                TileEntityDispenser tileentitydispenser = new TileEntityDispenser();

                if (p_72516_1_.field_94500_e)
                {
                    tileentitydispenser.func_94049_a(p_72516_1_.field_73430_c);
                }

                entityclientplayermp.func_71006_a(tileentitydispenser);
                entityclientplayermp.field_71070_bA.field_75152_c = p_72516_1_.field_73431_a;
                break;
            case 4:
                entityclientplayermp.func_71002_c(MathHelper.func_76128_c(entityclientplayermp.field_70165_t), MathHelper.func_76128_c(entityclientplayermp.field_70163_u), MathHelper.func_76128_c(entityclientplayermp.field_70161_v), p_72516_1_.field_94500_e ? p_72516_1_.field_73430_c : null);
                entityclientplayermp.field_71070_bA.field_75152_c = p_72516_1_.field_73431_a;
                break;
            case 5:
                TileEntityBrewingStand tileentitybrewingstand = new TileEntityBrewingStand();

                if (p_72516_1_.field_94500_e)
                {
                    tileentitybrewingstand.func_94131_a(p_72516_1_.field_73430_c);
                }

                entityclientplayermp.func_71017_a(tileentitybrewingstand);
                entityclientplayermp.field_71070_bA.field_75152_c = p_72516_1_.field_73431_a;
                break;
            case 6:
                entityclientplayermp.func_71030_a(new NpcMerchant(entityclientplayermp), p_72516_1_.field_94500_e ? p_72516_1_.field_73430_c : null);
                entityclientplayermp.field_71070_bA.field_75152_c = p_72516_1_.field_73431_a;
                break;
            case 7:
                TileEntityBeacon tileentitybeacon = new TileEntityBeacon();
                entityclientplayermp.func_82240_a(tileentitybeacon);

                if (p_72516_1_.field_94500_e)
                {
                    tileentitybeacon.func_94047_a(p_72516_1_.field_73430_c);
                }

                entityclientplayermp.field_71070_bA.field_75152_c = p_72516_1_.field_73431_a;
                break;
            case 8:
                entityclientplayermp.func_82244_d(MathHelper.func_76128_c(entityclientplayermp.field_70165_t), MathHelper.func_76128_c(entityclientplayermp.field_70163_u), MathHelper.func_76128_c(entityclientplayermp.field_70161_v));
                entityclientplayermp.field_71070_bA.field_75152_c = p_72516_1_.field_73431_a;
                break;
            case 9:
                TileEntityHopper tileentityhopper = new TileEntityHopper();

                if (p_72516_1_.field_94500_e)
                {
                    tileentityhopper.func_96115_a(p_72516_1_.field_73430_c);
                }

                entityclientplayermp.func_94064_a(tileentityhopper);
                entityclientplayermp.field_71070_bA.field_75152_c = p_72516_1_.field_73431_a;
                break;
            case 10:
                TileEntityDropper tileentitydropper = new TileEntityDropper();

                if (p_72516_1_.field_94500_e)
                {
                    tileentitydropper.func_94049_a(p_72516_1_.field_73430_c);
                }

                entityclientplayermp.func_71006_a(tileentitydropper);
                entityclientplayermp.field_71070_bA.field_75152_c = p_72516_1_.field_73431_a;
                break;
            case 11:
                Entity entity = this.func_72545_a(p_72516_1_.field_111008_f);

                if (entity != null && entity instanceof EntityHorse)
                {
                    entityclientplayermp.func_110298_a((EntityHorse)entity, new AnimalChest(p_72516_1_.field_73430_c, p_72516_1_.field_94500_e, p_72516_1_.field_73428_d));
                    entityclientplayermp.field_71070_bA.field_75152_c = p_72516_1_.field_73431_a;
                }
        }
    }

    public void func_72490_a(Packet103SetSlot p_72490_1_)
    {
        EntityClientPlayerMP entityclientplayermp = this.field_72563_h.field_71439_g;

        if (p_72490_1_.field_73637_a == -1)
        {
            entityclientplayermp.field_71071_by.func_70437_b(p_72490_1_.field_73636_c);
        }
        else
        {
            boolean flag = false;

            if (this.field_72563_h.field_71462_r instanceof GuiContainerCreative)
            {
                GuiContainerCreative guicontainercreative = (GuiContainerCreative)this.field_72563_h.field_71462_r;
                flag = guicontainercreative.func_74230_h() != CreativeTabs.field_78036_m.func_78021_a();
            }

            if (p_72490_1_.field_73637_a == 0 && p_72490_1_.field_73635_b >= 36 && p_72490_1_.field_73635_b < 45)
            {
                ItemStack itemstack = entityclientplayermp.field_71069_bz.func_75139_a(p_72490_1_.field_73635_b).func_75211_c();

                if (p_72490_1_.field_73636_c != null && (itemstack == null || itemstack.field_77994_a < p_72490_1_.field_73636_c.field_77994_a))
                {
                    p_72490_1_.field_73636_c.field_77992_b = 5;
                }

                entityclientplayermp.field_71069_bz.func_75141_a(p_72490_1_.field_73635_b, p_72490_1_.field_73636_c);
            }
            else if (p_72490_1_.field_73637_a == entityclientplayermp.field_71070_bA.field_75152_c && (p_72490_1_.field_73637_a != 0 || !flag))
            {
                entityclientplayermp.field_71070_bA.func_75141_a(p_72490_1_.field_73635_b, p_72490_1_.field_73636_c);
            }
        }
    }

    public void func_72476_a(Packet106Transaction p_72476_1_)
    {
        Container container = null;
        EntityClientPlayerMP entityclientplayermp = this.field_72563_h.field_71439_g;

        if (p_72476_1_.field_73435_a == 0)
        {
            container = entityclientplayermp.field_71069_bz;
        }
        else if (p_72476_1_.field_73435_a == entityclientplayermp.field_71070_bA.field_75152_c)
        {
            container = entityclientplayermp.field_71070_bA;
        }

        if (container != null && !p_72476_1_.field_73434_c)
        {
            this.func_72552_c(new Packet106Transaction(p_72476_1_.field_73435_a, p_72476_1_.field_73433_b, true));
        }
    }

    public void func_72486_a(Packet104WindowItems p_72486_1_)
    {
        EntityClientPlayerMP entityclientplayermp = this.field_72563_h.field_71439_g;

        if (p_72486_1_.field_73427_a == 0)
        {
            entityclientplayermp.field_71069_bz.func_75131_a(p_72486_1_.field_73426_b);
        }
        else if (p_72486_1_.field_73427_a == entityclientplayermp.field_71070_bA.field_75152_c)
        {
            entityclientplayermp.field_71070_bA.func_75131_a(p_72486_1_.field_73426_b);
        }
    }

    public void func_142031_a(Packet133TileEditorOpen p_142031_1_)
    {
        TileEntity tileentity = this.field_72564_i.func_72796_p(p_142031_1_.field_142035_b, p_142031_1_.field_142036_c, p_142031_1_.field_142034_d);

        if (tileentity != null)
        {
            this.field_72563_h.field_71439_g.func_71014_a(tileentity);
        }
        else if (p_142031_1_.field_142037_a == 0)
        {
            TileEntitySign tileentitysign = new TileEntitySign();
            tileentitysign.func_70308_a(this.field_72564_i);
            tileentitysign.field_70329_l = p_142031_1_.field_142035_b;
            tileentitysign.field_70330_m = p_142031_1_.field_142036_c;
            tileentitysign.field_70327_n = p_142031_1_.field_142034_d;
            this.field_72563_h.field_71439_g.func_71014_a(tileentitysign);
        }
    }

    public void func_72487_a(Packet130UpdateSign p_72487_1_)
    {
        boolean flag = false;

        if (this.field_72563_h.field_71441_e.func_72899_e(p_72487_1_.field_73311_a, p_72487_1_.field_73309_b, p_72487_1_.field_73310_c))
        {
            TileEntity tileentity = this.field_72563_h.field_71441_e.func_72796_p(p_72487_1_.field_73311_a, p_72487_1_.field_73309_b, p_72487_1_.field_73310_c);

            if (tileentity instanceof TileEntitySign)
            {
                TileEntitySign tileentitysign = (TileEntitySign)tileentity;

                if (tileentitysign.func_70409_a())
                {
                    for (int i = 0; i < 4; ++i)
                    {
                        tileentitysign.field_70412_a[i] = p_72487_1_.field_73308_d[i];
                    }

                    tileentitysign.func_70296_d();
                }

                flag = true;
            }
        }

        if (!flag && this.field_72563_h.field_71439_g != null)
        {
            this.field_72563_h.field_71439_g.func_70006_a(ChatMessageComponent.func_111066_d("Unable to locate sign at " + p_72487_1_.field_73311_a + ", " + p_72487_1_.field_73309_b + ", " + p_72487_1_.field_73310_c));
        }
    }

    public void func_72468_a(Packet132TileEntityData p_72468_1_)
    {
        if (this.field_72563_h.field_71441_e.func_72899_e(p_72468_1_.field_73334_a, p_72468_1_.field_73332_b, p_72468_1_.field_73333_c))
        {
            TileEntity tileentity = this.field_72563_h.field_71441_e.func_72796_p(p_72468_1_.field_73334_a, p_72468_1_.field_73332_b, p_72468_1_.field_73333_c);

            if (tileentity != null)
            {
                if (p_72468_1_.field_73330_d == 1 && tileentity instanceof TileEntityMobSpawner)
                {
                    tileentity.func_70307_a(p_72468_1_.field_73331_e);
                }
                else if (p_72468_1_.field_73330_d == 2 && tileentity instanceof TileEntityCommandBlock)
                {
                    tileentity.func_70307_a(p_72468_1_.field_73331_e);
                }
                else if (p_72468_1_.field_73330_d == 3 && tileentity instanceof TileEntityBeacon)
                {
                    tileentity.func_70307_a(p_72468_1_.field_73331_e);
                }
                else if (p_72468_1_.field_73330_d == 4 && tileentity instanceof TileEntitySkull)
                {
                    tileentity.func_70307_a(p_72468_1_.field_73331_e);
                }
            }
        }
    }

    public void func_72505_a(Packet105UpdateProgressbar p_72505_1_)
    {
        EntityClientPlayerMP entityclientplayermp = this.field_72563_h.field_71439_g;
        this.func_72509_a(p_72505_1_);

        if (entityclientplayermp.field_71070_bA != null && entityclientplayermp.field_71070_bA.field_75152_c == p_72505_1_.field_73634_a)
        {
            entityclientplayermp.field_71070_bA.func_75137_b(p_72505_1_.field_73632_b, p_72505_1_.field_73633_c);
        }
    }

    public void func_72506_a(Packet5PlayerInventory p_72506_1_)
    {
        Entity entity = this.func_72545_a(p_72506_1_.field_73400_a);

        if (entity != null)
        {
            entity.func_70062_b(p_72506_1_.field_73398_b, p_72506_1_.func_73397_d());
        }
    }

    public void func_72474_a(Packet101CloseWindow p_72474_1_)
    {
        this.field_72563_h.field_71439_g.func_92015_f();
    }

    public void func_72454_a(Packet54PlayNoteBlock p_72454_1_)
    {
        this.field_72563_h.field_71441_e.func_72965_b(p_72454_1_.field_73340_a, p_72454_1_.field_73338_b, p_72454_1_.field_73339_c, p_72454_1_.field_73335_f, p_72454_1_.field_73336_d, p_72454_1_.field_73337_e);
    }

    public void func_72465_a(Packet55BlockDestroy p_72465_1_)
    {
        this.field_72563_h.field_71441_e.func_72888_f(p_72465_1_.func_73322_d(), p_72465_1_.func_73321_f(), p_72465_1_.func_73324_g(), p_72465_1_.func_73320_h(), p_72465_1_.func_73323_i());
    }

    public void func_72453_a(Packet56MapChunks p_72453_1_)
    {
        for (int i = 0; i < p_72453_1_.func_73581_d(); ++i)
        {
            int j = p_72453_1_.func_73582_a(i);
            int k = p_72453_1_.func_73580_b(i);
            this.field_72564_i.func_73025_a(j, k, true);
            this.field_72564_i.func_73031_a(j << 4, 0, k << 4, (j << 4) + 15, 256, (k << 4) + 15);
            Chunk chunk = this.field_72564_i.func_72964_e(j, k);

            if (chunk == null)
            {
                this.field_72564_i.func_73025_a(j, k, true);
                chunk = this.field_72564_i.func_72964_e(j, k);
            }

            if (chunk != null)
            {
                chunk.func_76607_a(p_72453_1_.func_73583_c(i), p_72453_1_.field_73590_a[i], p_72453_1_.field_73588_b[i], true);
                this.field_72564_i.func_72909_d(j << 4, 0, k << 4, (j << 4) + 15, 256, (k << 4) + 15);

                if (!(this.field_72564_i.field_73011_w instanceof WorldProviderSurface))
                {
                    chunk.func_76613_n();
                }
            }
        }
    }

    public boolean func_72469_b()
    {
        return this.field_72563_h != null && this.field_72563_h.field_71441_e != null && this.field_72563_h.field_71439_g != null && this.field_72564_i != null;
    }

    public void func_72488_a(Packet70GameEvent p_72488_1_)
    {
        EntityClientPlayerMP entityclientplayermp = this.field_72563_h.field_71439_g;
        int i = p_72488_1_.field_73618_b;
        int j = p_72488_1_.field_73619_c;

        if (i >= 0 && i < Packet70GameEvent.field_73620_a.length && Packet70GameEvent.field_73620_a[i] != null)
        {
            entityclientplayermp.func_71035_c(Packet70GameEvent.field_73620_a[i]);
        }

        if (i == 1)
        {
            this.field_72564_i.func_72912_H().func_76084_b(true);
            this.field_72564_i.func_72894_k(0.0F);
        }
        else if (i == 2)
        {
            this.field_72564_i.func_72912_H().func_76084_b(false);
            this.field_72564_i.func_72894_k(1.0F);
        }
        else if (i == 3)
        {
            this.field_72563_h.field_71442_b.func_78746_a(EnumGameType.func_77146_a(j));
        }
        else if (i == 4)
        {
            this.field_72563_h.func_71373_a(new GuiWinGame());
        }
        else if (i == 5)
        {
            GameSettings gamesettings = this.field_72563_h.field_71474_y;

            if (j == 0)
            {
                this.field_72563_h.func_71373_a(new GuiScreenDemo());
            }
            else if (j == 101)
            {
                this.field_72563_h.field_71456_v.func_73827_b().func_73757_a("demo.help.movement", new Object[] {Keyboard.getKeyName(gamesettings.field_74351_w.field_74512_d), Keyboard.getKeyName(gamesettings.field_74370_x.field_74512_d), Keyboard.getKeyName(gamesettings.field_74368_y.field_74512_d), Keyboard.getKeyName(gamesettings.field_74366_z.field_74512_d)});
            }
            else if (j == 102)
            {
                this.field_72563_h.field_71456_v.func_73827_b().func_73757_a("demo.help.jump", new Object[] {Keyboard.getKeyName(gamesettings.field_74314_A.field_74512_d)});
            }
            else if (j == 103)
            {
                this.field_72563_h.field_71456_v.func_73827_b().func_73757_a("demo.help.inventory", new Object[] {Keyboard.getKeyName(gamesettings.field_74315_B.field_74512_d)});
            }
        }
        else if (i == 6)
        {
            this.field_72564_i.func_72980_b(entityclientplayermp.field_70165_t, entityclientplayermp.field_70163_u + (double)entityclientplayermp.func_70047_e(), entityclientplayermp.field_70161_v, "random.successful_hit", 0.18F, 0.45F, false);
        }
    }

    public void func_72494_a(Packet131MapData p_72494_1_)
    {
        if (p_72494_1_.field_73438_a == Item.field_77744_bd.field_77779_bT)
        {
            ItemMap.func_77874_a(p_72494_1_.field_73436_b, this.field_72563_h.field_71441_e).func_76192_a(p_72494_1_.field_73437_c);
        }
        else
        {
            this.field_72563_h.func_98033_al().func_98236_b("Unknown itemid: " + p_72494_1_.field_73436_b);
        }
    }

    public void func_72462_a(Packet61DoorChange p_72462_1_)
    {
        if (p_72462_1_.func_82560_d())
        {
            this.field_72563_h.field_71441_e.func_82739_e(p_72462_1_.field_73567_a, p_72462_1_.field_73566_c, p_72462_1_.field_73563_d, p_72462_1_.field_73564_e, p_72462_1_.field_73565_b);
        }
        else
        {
            this.field_72563_h.field_71441_e.func_72926_e(p_72462_1_.field_73567_a, p_72462_1_.field_73566_c, p_72462_1_.field_73563_d, p_72462_1_.field_73564_e, p_72462_1_.field_73565_b);
        }
    }

    public void func_72517_a(Packet200Statistic p_72517_1_)
    {
        this.field_72563_h.field_71439_g.func_71167_b(StatList.func_75923_a(p_72517_1_.field_73472_a), p_72517_1_.field_73471_b);
    }

    public void func_72503_a(Packet41EntityEffect p_72503_1_)
    {
        Entity entity = this.func_72545_a(p_72503_1_.field_73420_a);

        if (entity instanceof EntityLivingBase)
        {
            PotionEffect potioneffect = new PotionEffect(p_72503_1_.field_73418_b, p_72503_1_.field_73417_d, p_72503_1_.field_73419_c);
            potioneffect.func_100012_b(p_72503_1_.func_100008_d());
            ((EntityLivingBase)entity).func_70690_d(potioneffect);
        }
    }

    public void func_72452_a(Packet42RemoveEntityEffect p_72452_1_)
    {
        Entity entity = this.func_72545_a(p_72452_1_.field_73375_a);

        if (entity instanceof EntityLivingBase)
        {
            ((EntityLivingBase)entity).func_70618_n(p_72452_1_.field_73374_b);
        }
    }

    public boolean func_72489_a()
    {
        return false;
    }

    public void func_72480_a(Packet201PlayerInfo p_72480_1_)
    {
        GuiPlayerInfo guiplayerinfo = (GuiPlayerInfo)this.field_72562_k.get(p_72480_1_.field_73365_a);

        if (guiplayerinfo == null && p_72480_1_.field_73363_b)
        {
            guiplayerinfo = new GuiPlayerInfo(p_72480_1_.field_73365_a);
            this.field_72562_k.put(p_72480_1_.field_73365_a, guiplayerinfo);
            this.field_72559_c.add(guiplayerinfo);
        }

        if (guiplayerinfo != null && !p_72480_1_.field_73363_b)
        {
            this.field_72562_k.remove(p_72480_1_.field_73365_a);
            this.field_72559_c.remove(guiplayerinfo);
        }

        if (p_72480_1_.field_73363_b && guiplayerinfo != null)
        {
            guiplayerinfo.field_78829_b = p_72480_1_.field_73364_c;
        }
    }

    public void func_72477_a(Packet0KeepAlive p_72477_1_)
    {
        this.func_72552_c(new Packet0KeepAlive(p_72477_1_.field_73592_a));
    }

    public void func_72471_a(Packet202PlayerAbilities p_72471_1_)
    {
        EntityClientPlayerMP entityclientplayermp = this.field_72563_h.field_71439_g;
        entityclientplayermp.field_71075_bZ.field_75100_b = p_72471_1_.func_73350_f();
        entityclientplayermp.field_71075_bZ.field_75098_d = p_72471_1_.func_73346_h();
        entityclientplayermp.field_71075_bZ.field_75102_a = p_72471_1_.func_73352_d();
        entityclientplayermp.field_71075_bZ.field_75101_c = p_72471_1_.func_73348_g();
        entityclientplayermp.field_71075_bZ.func_75092_a(p_72471_1_.func_73347_i());
        entityclientplayermp.field_71075_bZ.func_82877_b(p_72471_1_.func_82558_j());
    }

    public void func_72461_a(Packet203AutoComplete p_72461_1_)
    {
        String[] astring = p_72461_1_.func_73473_d().split("\u0000");

        if (this.field_72563_h.field_71462_r instanceof GuiChat)
        {
            GuiChat guichat = (GuiChat)this.field_72563_h.field_71462_r;
            guichat.func_73894_a(astring);
        }
    }

    public void func_72457_a(Packet62LevelSound p_72457_1_)
    {
        this.field_72563_h.field_71441_e.func_72980_b(p_72457_1_.func_73572_f(), p_72457_1_.func_73568_g(), p_72457_1_.func_73569_h(), p_72457_1_.func_73570_d(), p_72457_1_.func_73571_i(), p_72457_1_.func_73573_j(), false);
    }

    public void func_72501_a(Packet250CustomPayload p_72501_1_)
    {
        if ("MC|TrList".equals(p_72501_1_.field_73630_a))
        {
            DataInputStream datainputstream = new DataInputStream(new ByteArrayInputStream(p_72501_1_.field_73629_c));

            try
            {
                int i = datainputstream.readInt();
                GuiScreen guiscreen = this.field_72563_h.field_71462_r;

                if (guiscreen != null && guiscreen instanceof GuiMerchant && i == this.field_72563_h.field_71439_g.field_71070_bA.field_75152_c)
                {
                    IMerchant imerchant = ((GuiMerchant)guiscreen).func_74199_h();
                    MerchantRecipeList merchantrecipelist = MerchantRecipeList.func_77204_a(datainputstream);
                    imerchant.func_70930_a(merchantrecipelist);
                }
            }
            catch (IOException ioexception)
            {
                ioexception.printStackTrace();
            }
        }
        else if ("MC|Brand".equals(p_72501_1_.field_73630_a))
        {
            this.field_72563_h.field_71439_g.func_142020_c(new String(p_72501_1_.field_73629_c, Charsets.UTF_8));
        }
    }

    public void func_96436_a(Packet206SetObjective p_96436_1_)
    {
        Scoreboard scoreboard = this.field_72564_i.func_96441_U();
        ScoreObjective scoreobjective;

        if (p_96436_1_.field_96483_c == 0)
        {
            scoreobjective = scoreboard.func_96535_a(p_96436_1_.field_96484_a, ScoreObjectiveCriteria.field_96641_b);
            scoreobjective.func_96681_a(p_96436_1_.field_96482_b);
        }
        else
        {
            scoreobjective = scoreboard.func_96518_b(p_96436_1_.field_96484_a);

            if (p_96436_1_.field_96483_c == 1)
            {
                scoreboard.func_96519_k(scoreobjective);
            }
            else if (p_96436_1_.field_96483_c == 2)
            {
                scoreobjective.func_96681_a(p_96436_1_.field_96482_b);
            }
        }
    }

    public void func_96437_a(Packet207SetScore p_96437_1_)
    {
        Scoreboard scoreboard = this.field_72564_i.func_96441_U();
        ScoreObjective scoreobjective = scoreboard.func_96518_b(p_96437_1_.field_96486_b);

        if (p_96437_1_.field_96485_d == 0)
        {
            Score score = scoreboard.func_96529_a(p_96437_1_.field_96488_a, scoreobjective);
            score.func_96647_c(p_96437_1_.field_96487_c);
        }
        else if (p_96437_1_.field_96485_d == 1)
        {
            scoreboard.func_96515_c(p_96437_1_.field_96488_a);
        }
    }

    public void func_96438_a(Packet208SetDisplayObjective p_96438_1_)
    {
        Scoreboard scoreboard = this.field_72564_i.func_96441_U();

        if (p_96438_1_.field_96480_b.length() == 0)
        {
            scoreboard.func_96530_a(p_96438_1_.field_96481_a, (ScoreObjective)null);
        }
        else
        {
            ScoreObjective scoreobjective = scoreboard.func_96518_b(p_96438_1_.field_96480_b);
            scoreboard.func_96530_a(p_96438_1_.field_96481_a, scoreobjective);
        }
    }

    public void func_96435_a(Packet209SetPlayerTeam p_96435_1_)
    {
        Scoreboard scoreboard = this.field_72564_i.func_96441_U();
        ScorePlayerTeam scoreplayerteam;

        if (p_96435_1_.field_96489_f == 0)
        {
            scoreplayerteam = scoreboard.func_96527_f(p_96435_1_.field_96495_a);
        }
        else
        {
            scoreplayerteam = scoreboard.func_96508_e(p_96435_1_.field_96495_a);
        }

        if (p_96435_1_.field_96489_f == 0 || p_96435_1_.field_96489_f == 2)
        {
            scoreplayerteam.func_96664_a(p_96435_1_.field_96493_b);
            scoreplayerteam.func_96666_b(p_96435_1_.field_96494_c);
            scoreplayerteam.func_96662_c(p_96435_1_.field_96491_d);
            scoreplayerteam.func_98298_a(p_96435_1_.field_98212_g);
        }

        Iterator iterator;
        String s;

        if (p_96435_1_.field_96489_f == 0 || p_96435_1_.field_96489_f == 3)
        {
            iterator = p_96435_1_.field_96492_e.iterator();

            while (iterator.hasNext())
            {
                s = (String)iterator.next();
                scoreboard.func_96521_a(s, scoreplayerteam);
            }
        }

        if (p_96435_1_.field_96489_f == 4)
        {
            iterator = p_96435_1_.field_96492_e.iterator();

            while (iterator.hasNext())
            {
                s = (String)iterator.next();
                scoreboard.func_96512_b(s, scoreplayerteam);
            }
        }

        if (p_96435_1_.field_96489_f == 1)
        {
            scoreboard.func_96511_d(scoreplayerteam);
        }
    }

    public void func_98182_a(Packet63WorldParticles p_98182_1_)
    {
        for (int i = 0; i < p_98182_1_.func_98202_m(); ++i)
        {
            double d0 = this.field_72557_e.nextGaussian() * (double)p_98182_1_.func_98196_i();
            double d1 = this.field_72557_e.nextGaussian() * (double)p_98182_1_.func_98201_j();
            double d2 = this.field_72557_e.nextGaussian() * (double)p_98182_1_.func_98199_k();
            double d3 = this.field_72557_e.nextGaussian() * (double)p_98182_1_.func_98197_l();
            double d4 = this.field_72557_e.nextGaussian() * (double)p_98182_1_.func_98197_l();
            double d5 = this.field_72557_e.nextGaussian() * (double)p_98182_1_.func_98197_l();
            this.field_72564_i.func_72869_a(p_98182_1_.func_98195_d(), p_98182_1_.func_98200_f() + d0, p_98182_1_.func_98194_g() + d1, p_98182_1_.func_98198_h() + d2, d3, d4, d5);
        }
    }

    public void func_110773_a(Packet44UpdateAttributes p_110773_1_)
    {
        Entity entity = this.func_72545_a(p_110773_1_.func_111002_d());

        if (entity != null)
        {
            if (!(entity instanceof EntityLivingBase))
            {
                throw new IllegalStateException("Server tried to update attributes of a non-living entity (actually: " + entity + ")");
            }
            else
            {
                BaseAttributeMap baseattributemap = ((EntityLivingBase)entity).func_110140_aT();
                Iterator iterator = p_110773_1_.func_111003_f().iterator();

                while (iterator.hasNext())
                {
                    Packet44UpdateAttributesSnapshot packet44updateattributessnapshot = (Packet44UpdateAttributesSnapshot)iterator.next();
                    AttributeInstance attributeinstance = baseattributemap.func_111152_a(packet44updateattributessnapshot.func_142040_a());

                    if (attributeinstance == null)
                    {
                        attributeinstance = baseattributemap.func_111150_b(new RangedAttribute(packet44updateattributessnapshot.func_142040_a(), 0.0D, 2.2250738585072014E-308D, Double.MAX_VALUE));
                    }

                    attributeinstance.func_111128_a(packet44updateattributessnapshot.func_142041_b());
                    attributeinstance.func_142049_d();
                    Iterator iterator1 = packet44updateattributessnapshot.func_142039_c().iterator();

                    while (iterator1.hasNext())
                    {
                        AttributeModifier attributemodifier = (AttributeModifier)iterator1.next();
                        attributeinstance.func_111121_a(attributemodifier);
                    }
                }
            }
        }
    }

    public INetworkManager func_72548_f()
    {
        return this.field_72555_g;
    }
}
