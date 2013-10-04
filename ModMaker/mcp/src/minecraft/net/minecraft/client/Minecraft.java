package net.minecraft.client;

import com.google.common.collect.Lists;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.Proxy;
import java.nio.ByteBuffer;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.imageio.ImageIO;
import net.minecraft.block.Block;
import net.minecraft.client.audio.SoundManager;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiGameOver;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiMemoryErrorScreen;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSleepMP;
import net.minecraft.client.gui.LoadingScreenRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.achievement.GuiAchievement;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.multiplayer.GuiConnecting;
import net.minecraft.client.multiplayer.NetClientHandler;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.DefaultResourcePack;
import net.minecraft.client.resources.FoliageColorReloadListener;
import net.minecraft.client.resources.GrassColorReloadListener;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.resources.LanguageManager;
import net.minecraft.client.resources.ReloadableResourceManager;
import net.minecraft.client.resources.ResourceManager;
import net.minecraft.client.resources.ResourcePackRepository;
import net.minecraft.client.resources.ResourcePackRepositoryEntry;
import net.minecraft.client.resources.SimpleReloadableResourceManager;
import net.minecraft.client.resources.data.AnimationMetadataSection;
import net.minecraft.client.resources.data.AnimationMetadataSectionSerializer;
import net.minecraft.client.resources.data.FontMetadataSection;
import net.minecraft.client.resources.data.FontMetadataSectionSerializer;
import net.minecraft.client.resources.data.LanguageMetadataSection;
import net.minecraft.client.resources.data.LanguageMetadataSectionSerializer;
import net.minecraft.client.resources.data.MetadataSerializer;
import net.minecraft.client.resources.data.PackMetadataSection;
import net.minecraft.client.resources.data.PackMetadataSectionSerializer;
import net.minecraft.client.resources.data.TextureMetadataSection;
import net.minecraft.client.resources.data.TextureMetadataSectionSerializer;
import net.minecraft.client.settings.EnumOptions;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.EntityLeashKnot;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.logging.ILogAgent;
import net.minecraft.logging.LogAgent;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.MemoryConnection;
import net.minecraft.profiler.IPlayerUsage;
import net.minecraft.profiler.PlayerUsageSnooper;
import net.minecraft.profiler.Profiler;
import net.minecraft.profiler.ProfilerResult;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.stats.AchievementList;
import net.minecraft.stats.StatFileWriter;
import net.minecraft.stats.StatList;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.EnumOS;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MinecraftError;
import net.minecraft.util.MouseHelper;
import net.minecraft.util.MovementInputFromOptions;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ReportedException;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.ScreenShotHelper;
import net.minecraft.util.Session;
import net.minecraft.util.Timer;
import net.minecraft.util.Util;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.chunk.storage.AnvilSaveConverter;
import net.minecraft.world.storage.ISaveFormat;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.WorldInfo;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.opengl.PixelFormat;
import org.lwjgl.util.glu.GLU;

@SideOnly(Side.CLIENT)
public class Minecraft implements IPlayerUsage
{
    private static final ResourceLocation field_110444_H = new ResourceLocation("textures/gui/title/mojang.png");
    public static final boolean field_142025_a = Util.func_110647_a() == EnumOS.MACOS;
    public static byte[] field_71444_a = new byte[10485760];
    private static final List field_110445_I = Lists.newArrayList(new DisplayMode[] {new DisplayMode(2560, 1600), new DisplayMode(2880, 1800)});
    private final ILogAgent field_94139_O;
    private final File field_130070_K;
    private ServerData field_71422_O;
    public TextureManager field_71446_o;
    private static Minecraft field_71432_P;
    public PlayerControllerMP field_71442_b;
    private boolean field_71431_Q;
    private boolean field_71434_R;
    private CrashReport field_71433_S;
    public int field_71443_c;
    public int field_71440_d;
    private Timer field_71428_T = new Timer(20.0F);
    private PlayerUsageSnooper field_71427_U = new PlayerUsageSnooper("client", this, MinecraftServer.func_130071_aq());
    public WorldClient field_71441_e;
    public RenderGlobal field_71438_f;
    public EntityClientPlayerMP field_71439_g;
    public EntityLivingBase field_71451_h;
    public EntityLivingBase field_96291_i;
    public EffectRenderer field_71452_i;
    private final Session field_71449_j;
    private boolean field_71445_n;
    public FontRenderer field_71466_p;
    public FontRenderer field_71464_q;
    public GuiScreen field_71462_r;
    public LoadingScreenRenderer field_71461_s;
    public EntityRenderer field_71460_t;
    private int field_71429_W;
    private int field_71436_X;
    private int field_71435_Y;
    private IntegratedServer field_71437_Z;
    public GuiAchievement field_71458_u;
    public GuiIngame field_71456_v;
    public boolean field_71454_w;
    public MovingObjectPosition field_71476_x;
    public GameSettings field_71474_y;
    public SoundManager field_71416_A;
    public MouseHelper field_71417_B;
    public final File field_71412_D;
    private final File field_110446_Y;
    private final String field_110447_Z;
    private final Proxy field_110453_aa;
    private ISaveFormat field_71469_aa;
    private static int field_71470_ab;
    private int field_71467_ac;
    private boolean field_71468_ad;
    public StatFileWriter field_71413_E;
    private String field_71475_ae;
    private int field_71477_af;
    boolean field_71414_F;
    public boolean field_71415_G;
    long field_71423_H = func_71386_F();
    private int field_71457_ai;
    private final boolean field_71459_aj;
    private INetworkManager field_71453_ak;
    private boolean field_71455_al;
    public final Profiler field_71424_I = new Profiler();
    private long field_83002_am = -1L;
    private ReloadableResourceManager field_110451_am;
    private final MetadataSerializer field_110452_an = new MetadataSerializer();
    private List field_110449_ao = Lists.newArrayList();
    private DefaultResourcePack field_110450_ap;
    private ResourcePackRepository field_110448_aq;
    private LanguageManager field_135017_as;
    public volatile boolean field_71425_J = true;
    public String field_71426_K = "";
    long field_71419_L = func_71386_F();
    int field_71420_M;
    long field_71421_N = -1L;
    private String field_71465_an = "root";

    public Minecraft(Session p_i1014_1_, int p_i1014_2_, int p_i1014_3_, boolean p_i1014_4_, boolean p_i1014_5_, File p_i1014_6_, File p_i1014_7_, File p_i1014_8_, Proxy p_i1014_9_, String p_i1014_10_)
    {
        field_71432_P = this;
        this.field_94139_O = new LogAgent("Minecraft-Client", " [CLIENT]", (new File(p_i1014_6_, "output-client.log")).getAbsolutePath());
        this.field_71412_D = p_i1014_6_;
        this.field_110446_Y = p_i1014_7_;
        this.field_130070_K = p_i1014_8_;
        this.field_110447_Z = p_i1014_10_;
        this.field_110450_ap = new DefaultResourcePack(this.field_110446_Y);
        this.func_110435_P();
        this.field_110453_aa = p_i1014_9_;
        this.func_71389_H();
        this.field_71449_j = p_i1014_1_;
        this.field_94139_O.func_98233_a("Setting user: " + p_i1014_1_.func_111285_a());
        this.field_94139_O.func_98233_a("(Session ID is " + p_i1014_1_.func_111286_b() + ")");
        this.field_71459_aj = p_i1014_5_;
        this.field_71443_c = p_i1014_2_;
        this.field_71440_d = p_i1014_3_;
        this.field_71436_X = p_i1014_2_;
        this.field_71435_Y = p_i1014_3_;
        this.field_71431_Q = p_i1014_4_;
        ImageIO.setUseCache(false);
        StatList.func_75919_a();
    }

    private void func_71389_H()
    {
        ThreadClientSleep threadclientsleep = new ThreadClientSleep(this, "Timer hack thread");
        threadclientsleep.setDaemon(true);
        threadclientsleep.start();
    }

    public void func_71404_a(CrashReport p_71404_1_)
    {
        this.field_71434_R = true;
        this.field_71433_S = p_71404_1_;
    }

    public void func_71377_b(CrashReport p_71377_1_)
    {
        File file1 = new File(func_71410_x().field_71412_D, "crash-reports");
        File file2 = new File(file1, "crash-" + (new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss")).format(new Date()) + "-client.txt");
        System.out.println(p_71377_1_.func_71502_e());

        if (p_71377_1_.func_71497_f() != null)
        {
            System.out.println("#@!@# Game crashed! Crash report saved to: #@!@# " + p_71377_1_.func_71497_f());
            System.exit(-1);
        }
        else if (p_71377_1_.func_71508_a(file2, this.func_98033_al()))
        {
            System.out.println("#@!@# Game crashed! Crash report saved to: #@!@# " + file2.getAbsolutePath());
            System.exit(-1);
        }
        else
        {
            System.out.println("#@?@# Game crashed! Crash report could not be saved. #@?@#");
            System.exit(-2);
        }
    }

    public void func_71367_a(String p_71367_1_, int p_71367_2_)
    {
        this.field_71475_ae = p_71367_1_;
        this.field_71477_af = p_71367_2_;
    }

    private void func_71384_a() throws LWJGLException
    {
        this.field_71474_y = new GameSettings(this, this.field_71412_D);

        if (this.field_71474_y.field_92119_C > 0 && this.field_71474_y.field_92118_B > 0)
        {
            this.field_71443_c = this.field_71474_y.field_92118_B;
            this.field_71440_d = this.field_71474_y.field_92119_C;
        }

        if (this.field_71431_Q)
        {
            Display.setFullscreen(true);
            this.field_71443_c = Display.getDisplayMode().getWidth();
            this.field_71440_d = Display.getDisplayMode().getHeight();

            if (this.field_71443_c <= 0)
            {
                this.field_71443_c = 1;
            }

            if (this.field_71440_d <= 0)
            {
                this.field_71440_d = 1;
            }
        }
        else
        {
            Display.setDisplayMode(new DisplayMode(this.field_71443_c, this.field_71440_d));
        }

        Display.setResizable(true);
        Display.setTitle("Minecraft 1.6.4");
        this.func_98033_al().func_98233_a("LWJGL Version: " + Sys.getVersion());

        if (Util.func_110647_a() != EnumOS.MACOS)
        {
            try
            {
                Display.setIcon(new ByteBuffer[] {this.func_110439_b(new File(this.field_110446_Y, "/icons/icon_16x16.png")), this.func_110439_b(new File(this.field_110446_Y, "/icons/icon_32x32.png"))});
            }
            catch (IOException ioexception)
            {
                ioexception.printStackTrace();
            }
        }

        try
        {
            Display.create((new PixelFormat()).withDepthBits(24));
        }
        catch (LWJGLException lwjglexception)
        {
            lwjglexception.printStackTrace();

            try
            {
                Thread.sleep(1000L);
            }
            catch (InterruptedException interruptedexception)
            {
                ;
            }

            if (this.field_71431_Q)
            {
                this.func_110441_Q();
            }

            Display.create();
        }

        OpenGlHelper.func_77474_a();
        this.field_71458_u = new GuiAchievement(this);
        this.field_110452_an.func_110504_a(new TextureMetadataSectionSerializer(), TextureMetadataSection.class);
        this.field_110452_an.func_110504_a(new FontMetadataSectionSerializer(), FontMetadataSection.class);
        this.field_110452_an.func_110504_a(new AnimationMetadataSectionSerializer(), AnimationMetadataSection.class);
        this.field_110452_an.func_110504_a(new PackMetadataSectionSerializer(), PackMetadataSection.class);
        this.field_110452_an.func_110504_a(new LanguageMetadataSectionSerializer(), LanguageMetadataSection.class);
        this.field_71469_aa = new AnvilSaveConverter(new File(this.field_71412_D, "saves"));
        this.field_110448_aq = new ResourcePackRepository(this.field_130070_K, this.field_110450_ap, this.field_110452_an, this.field_71474_y);
        this.field_110451_am = new SimpleReloadableResourceManager(this.field_110452_an);
        this.field_135017_as = new LanguageManager(this.field_110452_an, this.field_71474_y.field_74363_ab);
        this.field_110451_am.func_110542_a(this.field_135017_as);
        this.func_110436_a();
        this.field_71446_o = new TextureManager(this.field_110451_am);
        this.field_110451_am.func_110542_a(this.field_71446_o);
        this.field_71416_A = new SoundManager(this.field_110451_am, this.field_71474_y, this.field_110446_Y);
        this.field_110451_am.func_110542_a(this.field_71416_A);
        this.func_71357_I();
        this.field_71466_p = new FontRenderer(this.field_71474_y, new ResourceLocation("textures/font/ascii.png"), this.field_71446_o, false);

        if (this.field_71474_y.field_74363_ab != null)
        {
            this.field_71466_p.func_78264_a(this.field_135017_as.func_135042_a());
            this.field_71466_p.func_78275_b(this.field_135017_as.func_135044_b());
        }

        this.field_71464_q = new FontRenderer(this.field_71474_y, new ResourceLocation("textures/font/ascii_sga.png"), this.field_71446_o, false);
        this.field_110451_am.func_110542_a(this.field_71466_p);
        this.field_110451_am.func_110542_a(this.field_71464_q);
        this.field_110451_am.func_110542_a(new GrassColorReloadListener());
        this.field_110451_am.func_110542_a(new FoliageColorReloadListener());
        RenderManager.field_78727_a.field_78721_f = new ItemRenderer(this);
        this.field_71460_t = new EntityRenderer(this);
        this.field_71413_E = new StatFileWriter(this.field_71449_j, this.field_71412_D);
        AchievementList.field_76004_f.func_75988_a(new StatStringFormatKeyInv(this));
        this.field_71417_B = new MouseHelper();
        this.func_71361_d("Pre startup");
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glShadeModel(GL11.GL_SMOOTH);
        GL11.glClearDepth(1.0D);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glDepthFunc(GL11.GL_LEQUAL);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);
        GL11.glCullFace(GL11.GL_BACK);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        this.func_71361_d("Startup");
        this.field_71438_f = new RenderGlobal(this);
        this.field_71446_o.func_130088_a(TextureMap.field_110575_b, new TextureMap(0, "textures/blocks"));
        this.field_71446_o.func_130088_a(TextureMap.field_110576_c, new TextureMap(1, "textures/items"));
        GL11.glViewport(0, 0, this.field_71443_c, this.field_71440_d);
        this.field_71452_i = new EffectRenderer(this.field_71441_e, this.field_71446_o);
        this.func_71361_d("Post startup");
        this.field_71456_v = new GuiIngame(this);

        if (this.field_71475_ae != null)
        {
            this.func_71373_a(new GuiConnecting(new GuiMainMenu(), this, this.field_71475_ae, this.field_71477_af));
        }
        else
        {
            this.func_71373_a(new GuiMainMenu());
        }

        this.field_71461_s = new LoadingScreenRenderer(this);

        if (this.field_71474_y.field_74353_u && !this.field_71431_Q)
        {
            this.func_71352_k();
        }
    }

    public void func_110436_a()
    {
        ArrayList arraylist = Lists.newArrayList(this.field_110449_ao);
        Iterator iterator = this.field_110448_aq.func_110613_c().iterator();

        while (iterator.hasNext())
        {
            ResourcePackRepositoryEntry resourcepackrepositoryentry = (ResourcePackRepositoryEntry)iterator.next();
            arraylist.add(resourcepackrepositoryentry.func_110514_c());
        }

        this.field_135017_as.func_135043_a(arraylist);
        this.field_110451_am.func_110541_a(arraylist);

        if (this.field_71438_f != null)
        {
            this.field_71438_f.func_72712_a();
        }
    }

    private void func_110435_P()
    {
        this.field_110449_ao.add(this.field_110450_ap);
    }

    private ByteBuffer func_110439_b(File p_110439_1_) throws IOException
    {
        BufferedImage bufferedimage = ImageIO.read(p_110439_1_);
        int[] aint = bufferedimage.getRGB(0, 0, bufferedimage.getWidth(), bufferedimage.getHeight(), (int[])null, 0, bufferedimage.getWidth());
        ByteBuffer bytebuffer = ByteBuffer.allocate(4 * aint.length);
        int[] aint1 = aint;
        int i = aint.length;

        for (int j = 0; j < i; ++j)
        {
            int k = aint1[j];
            bytebuffer.putInt(k << 8 | k >> 24 & 255);
        }

        bytebuffer.flip();
        return bytebuffer;
    }

    private void func_110441_Q() throws LWJGLException
    {
        HashSet hashset = new HashSet();
        Collections.addAll(hashset, Display.getAvailableDisplayModes());
        DisplayMode displaymode = Display.getDesktopDisplayMode();

        if (!hashset.contains(displaymode) && Util.func_110647_a() == EnumOS.MACOS)
        {
            Iterator iterator = field_110445_I.iterator();

            while (iterator.hasNext())
            {
                DisplayMode displaymode1 = (DisplayMode)iterator.next();
                boolean flag = true;
                Iterator iterator1 = hashset.iterator();
                DisplayMode displaymode2;

                while (iterator1.hasNext())
                {
                    displaymode2 = (DisplayMode)iterator1.next();

                    if (displaymode2.getBitsPerPixel() == 32 && displaymode2.getWidth() == displaymode1.getWidth() && displaymode2.getHeight() == displaymode1.getHeight())
                    {
                        flag = false;
                        break;
                    }
                }

                if (!flag)
                {
                    iterator1 = hashset.iterator();

                    while (iterator1.hasNext())
                    {
                        displaymode2 = (DisplayMode)iterator1.next();

                        if (displaymode2.getBitsPerPixel() == 32 && displaymode2.getWidth() == displaymode1.getWidth() / 2 && displaymode2.getHeight() == displaymode1.getHeight() / 2)
                        {
                            displaymode = displaymode2;
                            break;
                        }
                    }
                }
            }
        }

        Display.setDisplayMode(displaymode);
        this.field_71443_c = displaymode.getWidth();
        this.field_71440_d = displaymode.getHeight();
    }

    private void func_71357_I() throws LWJGLException
    {
        ScaledResolution scaledresolution = new ScaledResolution(this.field_71474_y, this.field_71443_c, this.field_71440_d);
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0D, scaledresolution.func_78327_c(), scaledresolution.func_78324_d(), 0.0D, 1000.0D, 3000.0D);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0F, 0.0F, -2000.0F);
        GL11.glViewport(0, 0, this.field_71443_c, this.field_71440_d);
        GL11.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_FOG);
        this.field_71446_o.func_110577_a(field_110444_H);
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78382_b();
        tessellator.func_78378_d(16777215);
        tessellator.func_78374_a(0.0D, (double)this.field_71440_d, 0.0D, 0.0D, 0.0D);
        tessellator.func_78374_a((double)this.field_71443_c, (double)this.field_71440_d, 0.0D, 0.0D, 0.0D);
        tessellator.func_78374_a((double)this.field_71443_c, 0.0D, 0.0D, 0.0D, 0.0D);
        tessellator.func_78374_a(0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
        tessellator.func_78381_a();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        tessellator.func_78378_d(16777215);
        short short1 = 256;
        short short2 = 256;
        this.func_71392_a((scaledresolution.func_78326_a() - short1) / 2, (scaledresolution.func_78328_b() - short2) / 2, 0, 0, short1, short2);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_FOG);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);
        Display.update();
    }

    public void func_71392_a(int p_71392_1_, int p_71392_2_, int p_71392_3_, int p_71392_4_, int p_71392_5_, int p_71392_6_)
    {
        float f = 0.00390625F;
        float f1 = 0.00390625F;
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78382_b();
        tessellator.func_78374_a((double)(p_71392_1_ + 0), (double)(p_71392_2_ + p_71392_6_), 0.0D, (double)((float)(p_71392_3_ + 0) * f), (double)((float)(p_71392_4_ + p_71392_6_) * f1));
        tessellator.func_78374_a((double)(p_71392_1_ + p_71392_5_), (double)(p_71392_2_ + p_71392_6_), 0.0D, (double)((float)(p_71392_3_ + p_71392_5_) * f), (double)((float)(p_71392_4_ + p_71392_6_) * f1));
        tessellator.func_78374_a((double)(p_71392_1_ + p_71392_5_), (double)(p_71392_2_ + 0), 0.0D, (double)((float)(p_71392_3_ + p_71392_5_) * f), (double)((float)(p_71392_4_ + 0) * f1));
        tessellator.func_78374_a((double)(p_71392_1_ + 0), (double)(p_71392_2_ + 0), 0.0D, (double)((float)(p_71392_3_ + 0) * f), (double)((float)(p_71392_4_ + 0) * f1));
        tessellator.func_78381_a();
    }

    public ISaveFormat func_71359_d()
    {
        return this.field_71469_aa;
    }

    public void func_71373_a(GuiScreen p_71373_1_)
    {
        if (this.field_71462_r != null)
        {
            this.field_71462_r.func_73874_b();
        }

        this.field_71413_E.func_77446_d();

        if (p_71373_1_ == null && this.field_71441_e == null)
        {
            p_71373_1_ = new GuiMainMenu();
        }
        else if (p_71373_1_ == null && this.field_71439_g.func_110143_aJ() <= 0.0F)
        {
            p_71373_1_ = new GuiGameOver();
        }

        if (p_71373_1_ instanceof GuiMainMenu)
        {
            this.field_71474_y.field_74330_P = false;
            this.field_71456_v.func_73827_b().func_73761_a();
        }

        this.field_71462_r = (GuiScreen)p_71373_1_;

        if (p_71373_1_ != null)
        {
            this.func_71364_i();
            ScaledResolution scaledresolution = new ScaledResolution(this.field_71474_y, this.field_71443_c, this.field_71440_d);
            int i = scaledresolution.func_78326_a();
            int j = scaledresolution.func_78328_b();
            ((GuiScreen)p_71373_1_).func_73872_a(this, i, j);
            this.field_71454_w = false;
        }
        else
        {
            this.func_71381_h();
        }
    }

    private void func_71361_d(String p_71361_1_)
    {
        int i = GL11.glGetError();

        if (i != 0)
        {
            String s1 = GLU.gluErrorString(i);
            this.func_98033_al().func_98232_c("########## GL ERROR ##########");
            this.func_98033_al().func_98232_c("@ " + p_71361_1_);
            this.func_98033_al().func_98232_c(i + ": " + s1);
        }
    }

    public void func_71405_e()
    {
        try
        {
            this.field_71413_E.func_77446_d();
            this.func_98033_al().func_98233_a("Stopping!");

            try
            {
                this.func_71403_a((WorldClient)null);
            }
            catch (Throwable throwable)
            {
                ;
            }

            try
            {
                GLAllocation.func_74525_a();
            }
            catch (Throwable throwable1)
            {
                ;
            }

            this.field_71416_A.func_77370_b();
        }
        finally
        {
            Display.destroy();

            if (!this.field_71434_R)
            {
                System.exit(0);
            }
        }

        System.gc();
    }

    public void func_99999_d()
    {
        this.field_71425_J = true;
        CrashReport crashreport;

        try
        {
            this.func_71384_a();
        }
        catch (Throwable throwable)
        {
            crashreport = CrashReport.func_85055_a(throwable, "Initializing game");
            crashreport.func_85058_a("Initialization");
            this.func_71377_b(this.func_71396_d(crashreport));
            return;
        }

        try
        {
            while (this.field_71425_J)
            {
                if (this.field_71425_J)
                {
                    if (this.field_71434_R && this.field_71433_S != null)
                    {
                        this.func_71377_b(this.field_71433_S);
                        return;
                    }

                    if (this.field_71468_ad)
                    {
                        this.field_71468_ad = false;
                        this.func_110436_a();
                    }

                    try
                    {
                        this.func_71411_J();
                    }
                    catch (OutOfMemoryError outofmemoryerror)
                    {
                        this.func_71398_f();
                        this.func_71373_a(new GuiMemoryErrorScreen());
                        System.gc();
                    }

                    continue;
                }
            }
        }
        catch (MinecraftError minecrafterror)
        {
        }
        catch (ReportedException reportedexception)
        {
            this.func_71396_d(reportedexception.func_71575_a());
            this.func_71398_f();
            reportedexception.printStackTrace();
            this.func_71377_b(reportedexception.func_71575_a());
        }
        catch (Throwable throwable1)
        {
            crashreport = this.func_71396_d(new CrashReport("Unexpected error", throwable1));
            this.func_71398_f();
            throwable1.printStackTrace();
            this.func_71377_b(crashreport);
        }
        finally
        {
            this.func_71405_e();
        }
    }

    private void func_71411_J()
    {
        AxisAlignedBB.func_72332_a().func_72298_a();

        if (this.field_71441_e != null)
        {
            this.field_71441_e.func_82732_R().func_72343_a();
        }

        this.field_71424_I.func_76320_a("root");

        if (Display.isCloseRequested())
        {
            this.func_71400_g();
        }

        if (this.field_71445_n && this.field_71441_e != null)
        {
            float f = this.field_71428_T.field_74281_c;
            this.field_71428_T.func_74275_a();
            this.field_71428_T.field_74281_c = f;
        }
        else
        {
            this.field_71428_T.func_74275_a();
        }

        long i = System.nanoTime();
        this.field_71424_I.func_76320_a("tick");

        for (int j = 0; j < this.field_71428_T.field_74280_b; ++j)
        {
            this.func_71407_l();
        }

        this.field_71424_I.func_76318_c("preRenderErrors");
        long k = System.nanoTime() - i;
        this.func_71361_d("Pre render");
        RenderBlocks.field_78667_b = this.field_71474_y.field_74347_j;
        this.field_71424_I.func_76318_c("sound");
        this.field_71416_A.func_77369_a(this.field_71439_g, this.field_71428_T.field_74281_c);

        if (!this.field_71445_n)
        {
            this.field_71416_A.func_92071_g();
        }

        this.field_71424_I.func_76319_b();
        this.field_71424_I.func_76320_a("render");
        this.field_71424_I.func_76320_a("display");
        GL11.glEnable(GL11.GL_TEXTURE_2D);

        if (!Keyboard.isKeyDown(65))
        {
            Display.update();
        }

        if (this.field_71439_g != null && this.field_71439_g.func_70094_T())
        {
            this.field_71474_y.field_74320_O = 0;
        }

        this.field_71424_I.func_76319_b();

        if (!this.field_71454_w)
        {
            this.field_71424_I.func_76318_c("gameRenderer");
            this.field_71460_t.func_78480_b(this.field_71428_T.field_74281_c);
            this.field_71424_I.func_76319_b();
        }

        GL11.glFlush();
        this.field_71424_I.func_76319_b();

        if (!Display.isActive() && this.field_71431_Q)
        {
            this.func_71352_k();
        }

        if (this.field_71474_y.field_74330_P && this.field_71474_y.field_74329_Q)
        {
            if (!this.field_71424_I.field_76327_a)
            {
                this.field_71424_I.func_76317_a();
            }

            this.field_71424_I.field_76327_a = true;
            this.func_71366_a(k);
        }
        else
        {
            this.field_71424_I.field_76327_a = false;
            this.field_71421_N = System.nanoTime();
        }

        this.field_71458_u.func_73847_a();
        this.field_71424_I.func_76320_a("root");
        Thread.yield();

        if (Keyboard.isKeyDown(65))
        {
            Display.update();
        }

        this.func_71365_K();

        if (!this.field_71431_Q && Display.wasResized())
        {
            this.field_71443_c = Display.getWidth();
            this.field_71440_d = Display.getHeight();

            if (this.field_71443_c <= 0)
            {
                this.field_71443_c = 1;
            }

            if (this.field_71440_d <= 0)
            {
                this.field_71440_d = 1;
            }

            this.func_71370_a(this.field_71443_c, this.field_71440_d);
        }

        this.func_71361_d("Post render");
        ++this.field_71420_M;
        boolean flag = this.field_71445_n;
        this.field_71445_n = this.func_71356_B() && this.field_71462_r != null && this.field_71462_r.func_73868_f() && !this.field_71437_Z.func_71344_c();

        if (this.func_71387_A() && this.field_71439_g != null && this.field_71439_g.field_71174_a != null && this.field_71445_n != flag)
        {
            ((MemoryConnection)this.field_71439_g.field_71174_a.func_72548_f()).func_74437_a(this.field_71445_n);
        }

        while (func_71386_F() >= this.field_71419_L + 1000L)
        {
            field_71470_ab = this.field_71420_M;
            this.field_71426_K = field_71470_ab + " fps, " + WorldRenderer.field_78922_b + " chunk updates";
            WorldRenderer.field_78922_b = 0;
            this.field_71419_L += 1000L;
            this.field_71420_M = 0;
            this.field_71427_U.func_76471_b();

            if (!this.field_71427_U.func_76468_d())
            {
                this.field_71427_U.func_76463_a();
            }
        }

        this.field_71424_I.func_76319_b();

        if (this.func_90020_K() > 0)
        {
            Display.sync(EntityRenderer.func_78465_a(this.func_90020_K()));
        }
    }

    private int func_90020_K()
    {
        return this.field_71462_r != null && this.field_71462_r instanceof GuiMainMenu ? 2 : this.field_71474_y.field_74350_i;
    }

    public void func_71398_f()
    {
        try
        {
            field_71444_a = new byte[0];
            this.field_71438_f.func_72728_f();
        }
        catch (Throwable throwable)
        {
            ;
        }

        try
        {
            System.gc();
            AxisAlignedBB.func_72332_a().func_72300_b();
            this.field_71441_e.func_82732_R().func_72344_b();
        }
        catch (Throwable throwable1)
        {
            ;
        }

        try
        {
            System.gc();
            this.func_71403_a((WorldClient)null);
        }
        catch (Throwable throwable2)
        {
            ;
        }

        System.gc();
    }

    private void func_71365_K()
    {
        if (Keyboard.isKeyDown(60))
        {
            if (!this.field_71414_F)
            {
                this.field_71414_F = true;
                this.field_71456_v.func_73827_b().func_73765_a(ScreenShotHelper.func_74291_a(this.field_71412_D, this.field_71443_c, this.field_71440_d));
            }
        }
        else
        {
            this.field_71414_F = false;
        }
    }

    private void func_71383_b(int p_71383_1_)
    {
        List list = this.field_71424_I.func_76321_b(this.field_71465_an);

        if (list != null && !list.isEmpty())
        {
            ProfilerResult profilerresult = (ProfilerResult)list.remove(0);

            if (p_71383_1_ == 0)
            {
                if (profilerresult.field_76331_c.length() > 0)
                {
                    int j = this.field_71465_an.lastIndexOf(".");

                    if (j >= 0)
                    {
                        this.field_71465_an = this.field_71465_an.substring(0, j);
                    }
                }
            }
            else
            {
                --p_71383_1_;

                if (p_71383_1_ < list.size() && !((ProfilerResult)list.get(p_71383_1_)).field_76331_c.equals("unspecified"))
                {
                    if (this.field_71465_an.length() > 0)
                    {
                        this.field_71465_an = this.field_71465_an + ".";
                    }

                    this.field_71465_an = this.field_71465_an + ((ProfilerResult)list.get(p_71383_1_)).field_76331_c;
                }
            }
        }
    }

    private void func_71366_a(long p_71366_1_)
    {
        if (this.field_71424_I.field_76327_a)
        {
            List list = this.field_71424_I.func_76321_b(this.field_71465_an);
            ProfilerResult profilerresult = (ProfilerResult)list.remove(0);
            GL11.glClear(GL11.GL_DEPTH_BUFFER_BIT);
            GL11.glMatrixMode(GL11.GL_PROJECTION);
            GL11.glEnable(GL11.GL_COLOR_MATERIAL);
            GL11.glLoadIdentity();
            GL11.glOrtho(0.0D, (double)this.field_71443_c, (double)this.field_71440_d, 0.0D, 1000.0D, 3000.0D);
            GL11.glMatrixMode(GL11.GL_MODELVIEW);
            GL11.glLoadIdentity();
            GL11.glTranslatef(0.0F, 0.0F, -2000.0F);
            GL11.glLineWidth(1.0F);
            GL11.glDisable(GL11.GL_TEXTURE_2D);
            Tessellator tessellator = Tessellator.field_78398_a;
            short short1 = 160;
            int j = this.field_71443_c - short1 - 10;
            int k = this.field_71440_d - short1 * 2;
            GL11.glEnable(GL11.GL_BLEND);
            tessellator.func_78382_b();
            tessellator.func_78384_a(0, 200);
            tessellator.func_78377_a((double)((float)j - (float)short1 * 1.1F), (double)((float)k - (float)short1 * 0.6F - 16.0F), 0.0D);
            tessellator.func_78377_a((double)((float)j - (float)short1 * 1.1F), (double)(k + short1 * 2), 0.0D);
            tessellator.func_78377_a((double)((float)j + (float)short1 * 1.1F), (double)(k + short1 * 2), 0.0D);
            tessellator.func_78377_a((double)((float)j + (float)short1 * 1.1F), (double)((float)k - (float)short1 * 0.6F - 16.0F), 0.0D);
            tessellator.func_78381_a();
            GL11.glDisable(GL11.GL_BLEND);
            double d0 = 0.0D;
            int l;

            for (int i1 = 0; i1 < list.size(); ++i1)
            {
                ProfilerResult profilerresult1 = (ProfilerResult)list.get(i1);
                l = MathHelper.func_76128_c(profilerresult1.field_76332_a / 4.0D) + 1;
                tessellator.func_78371_b(6);
                tessellator.func_78378_d(profilerresult1.func_76329_a());
                tessellator.func_78377_a((double)j, (double)k, 0.0D);
                int j1;
                float f;
                float f1;
                float f2;

                for (j1 = l; j1 >= 0; --j1)
                {
                    f = (float)((d0 + profilerresult1.field_76332_a * (double)j1 / (double)l) * Math.PI * 2.0D / 100.0D);
                    f2 = MathHelper.func_76126_a(f) * (float)short1;
                    f1 = MathHelper.func_76134_b(f) * (float)short1 * 0.5F;
                    tessellator.func_78377_a((double)((float)j + f2), (double)((float)k - f1), 0.0D);
                }

                tessellator.func_78381_a();
                tessellator.func_78371_b(5);
                tessellator.func_78378_d((profilerresult1.func_76329_a() & 16711422) >> 1);

                for (j1 = l; j1 >= 0; --j1)
                {
                    f = (float)((d0 + profilerresult1.field_76332_a * (double)j1 / (double)l) * Math.PI * 2.0D / 100.0D);
                    f2 = MathHelper.func_76126_a(f) * (float)short1;
                    f1 = MathHelper.func_76134_b(f) * (float)short1 * 0.5F;
                    tessellator.func_78377_a((double)((float)j + f2), (double)((float)k - f1), 0.0D);
                    tessellator.func_78377_a((double)((float)j + f2), (double)((float)k - f1 + 10.0F), 0.0D);
                }

                tessellator.func_78381_a();
                d0 += profilerresult1.field_76332_a;
            }

            DecimalFormat decimalformat = new DecimalFormat("##0.00");
            GL11.glEnable(GL11.GL_TEXTURE_2D);
            String s = "";

            if (!profilerresult.field_76331_c.equals("unspecified"))
            {
                s = s + "[0] ";
            }

            if (profilerresult.field_76331_c.length() == 0)
            {
                s = s + "ROOT ";
            }
            else
            {
                s = s + profilerresult.field_76331_c + " ";
            }

            l = 16777215;
            this.field_71466_p.func_78261_a(s, j - short1, k - short1 / 2 - 16, l);
            this.field_71466_p.func_78261_a(s = decimalformat.format(profilerresult.field_76330_b) + "%", j + short1 - this.field_71466_p.func_78256_a(s), k - short1 / 2 - 16, l);

            for (int k1 = 0; k1 < list.size(); ++k1)
            {
                ProfilerResult profilerresult2 = (ProfilerResult)list.get(k1);
                String s1 = "";

                if (profilerresult2.field_76331_c.equals("unspecified"))
                {
                    s1 = s1 + "[?] ";
                }
                else
                {
                    s1 = s1 + "[" + (k1 + 1) + "] ";
                }

                s1 = s1 + profilerresult2.field_76331_c;
                this.field_71466_p.func_78261_a(s1, j - short1, k + short1 / 2 + k1 * 8 + 20, profilerresult2.func_76329_a());
                this.field_71466_p.func_78261_a(s1 = decimalformat.format(profilerresult2.field_76332_a) + "%", j + short1 - 50 - this.field_71466_p.func_78256_a(s1), k + short1 / 2 + k1 * 8 + 20, profilerresult2.func_76329_a());
                this.field_71466_p.func_78261_a(s1 = decimalformat.format(profilerresult2.field_76330_b) + "%", j + short1 - this.field_71466_p.func_78256_a(s1), k + short1 / 2 + k1 * 8 + 20, profilerresult2.func_76329_a());
            }
        }
    }

    public void func_71400_g()
    {
        this.field_71425_J = false;
    }

    public void func_71381_h()
    {
        if (Display.isActive())
        {
            if (!this.field_71415_G)
            {
                this.field_71415_G = true;
                this.field_71417_B.func_74372_a();
                this.func_71373_a((GuiScreen)null);
                this.field_71429_W = 10000;
            }
        }
    }

    public void func_71364_i()
    {
        if (this.field_71415_G)
        {
            KeyBinding.func_74506_a();
            this.field_71415_G = false;
            this.field_71417_B.func_74373_b();
        }
    }

    public void func_71385_j()
    {
        if (this.field_71462_r == null)
        {
            this.func_71373_a(new GuiIngameMenu());

            if (this.func_71356_B() && !this.field_71437_Z.func_71344_c())
            {
                this.field_71416_A.func_82466_e();
            }
        }
    }

    private void func_71399_a(int p_71399_1_, boolean p_71399_2_)
    {
        if (!p_71399_2_)
        {
            this.field_71429_W = 0;
        }

        if (p_71399_1_ != 0 || this.field_71429_W <= 0)
        {
            if (p_71399_2_ && this.field_71476_x != null && this.field_71476_x.field_72313_a == EnumMovingObjectType.TILE && p_71399_1_ == 0)
            {
                int j = this.field_71476_x.field_72311_b;
                int k = this.field_71476_x.field_72312_c;
                int l = this.field_71476_x.field_72309_d;
                this.field_71442_b.func_78759_c(j, k, l, this.field_71476_x.field_72310_e);

                if (this.field_71439_g.func_82246_f(j, k, l))
                {
                    this.field_71452_i.func_78867_a(j, k, l, this.field_71476_x.field_72310_e);
                    this.field_71439_g.func_71038_i();
                }
            }
            else
            {
                this.field_71442_b.func_78767_c();
            }
        }
    }

    private void func_71402_c(int p_71402_1_)
    {
        if (p_71402_1_ != 0 || this.field_71429_W <= 0)
        {
            if (p_71402_1_ == 0)
            {
                this.field_71439_g.func_71038_i();
            }

            if (p_71402_1_ == 1)
            {
                this.field_71467_ac = 4;
            }

            boolean flag = true;
            ItemStack itemstack = this.field_71439_g.field_71071_by.func_70448_g();

            if (this.field_71476_x == null)
            {
                if (p_71402_1_ == 0 && this.field_71442_b.func_78762_g())
                {
                    this.field_71429_W = 10;
                }
            }
            else if (this.field_71476_x.field_72313_a == EnumMovingObjectType.ENTITY)
            {
                if (p_71402_1_ == 0)
                {
                    this.field_71442_b.func_78764_a(this.field_71439_g, this.field_71476_x.field_72308_g);
                }

                if (p_71402_1_ == 1 && this.field_71442_b.func_78768_b(this.field_71439_g, this.field_71476_x.field_72308_g))
                {
                    flag = false;
                }
            }
            else if (this.field_71476_x.field_72313_a == EnumMovingObjectType.TILE)
            {
                int j = this.field_71476_x.field_72311_b;
                int k = this.field_71476_x.field_72312_c;
                int l = this.field_71476_x.field_72309_d;
                int i1 = this.field_71476_x.field_72310_e;

                if (p_71402_1_ == 0)
                {
                    this.field_71442_b.func_78743_b(j, k, l, this.field_71476_x.field_72310_e);
                }
                else
                {
                    int j1 = itemstack != null ? itemstack.field_77994_a : 0;

                    if (this.field_71442_b.func_78760_a(this.field_71439_g, this.field_71441_e, itemstack, j, k, l, i1, this.field_71476_x.field_72307_f))
                    {
                        flag = false;
                        this.field_71439_g.func_71038_i();
                    }

                    if (itemstack == null)
                    {
                        return;
                    }

                    if (itemstack.field_77994_a == 0)
                    {
                        this.field_71439_g.field_71071_by.field_70462_a[this.field_71439_g.field_71071_by.field_70461_c] = null;
                    }
                    else if (itemstack.field_77994_a != j1 || this.field_71442_b.func_78758_h())
                    {
                        this.field_71460_t.field_78516_c.func_78444_b();
                    }
                }
            }

            if (flag && p_71402_1_ == 1)
            {
                ItemStack itemstack1 = this.field_71439_g.field_71071_by.func_70448_g();

                if (itemstack1 != null && this.field_71442_b.func_78769_a(this.field_71439_g, this.field_71441_e, itemstack1))
                {
                    this.field_71460_t.field_78516_c.func_78445_c();
                }
            }
        }
    }

    public void func_71352_k()
    {
        try
        {
            this.field_71431_Q = !this.field_71431_Q;

            if (this.field_71431_Q)
            {
                this.func_110441_Q();
                this.field_71443_c = Display.getDisplayMode().getWidth();
                this.field_71440_d = Display.getDisplayMode().getHeight();

                if (this.field_71443_c <= 0)
                {
                    this.field_71443_c = 1;
                }

                if (this.field_71440_d <= 0)
                {
                    this.field_71440_d = 1;
                }
            }
            else
            {
                Display.setDisplayMode(new DisplayMode(this.field_71436_X, this.field_71435_Y));
                this.field_71443_c = this.field_71436_X;
                this.field_71440_d = this.field_71435_Y;

                if (this.field_71443_c <= 0)
                {
                    this.field_71443_c = 1;
                }

                if (this.field_71440_d <= 0)
                {
                    this.field_71440_d = 1;
                }
            }

            if (this.field_71462_r != null)
            {
                this.func_71370_a(this.field_71443_c, this.field_71440_d);
            }

            Display.setFullscreen(this.field_71431_Q);
            Display.setVSyncEnabled(this.field_71474_y.field_74352_v);
            Display.update();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    private void func_71370_a(int p_71370_1_, int p_71370_2_)
    {
        this.field_71443_c = p_71370_1_ <= 0 ? 1 : p_71370_1_;
        this.field_71440_d = p_71370_2_ <= 0 ? 1 : p_71370_2_;

        if (this.field_71462_r != null)
        {
            ScaledResolution scaledresolution = new ScaledResolution(this.field_71474_y, p_71370_1_, p_71370_2_);
            int k = scaledresolution.func_78326_a();
            int l = scaledresolution.func_78328_b();
            this.field_71462_r.func_73872_a(this, k, l);
        }
    }

    public void func_71407_l()
    {
        if (this.field_71467_ac > 0)
        {
            --this.field_71467_ac;
        }

        this.field_71424_I.func_76320_a("stats");
        this.field_71413_E.func_77449_e();
        this.field_71424_I.func_76318_c("gui");

        if (!this.field_71445_n)
        {
            this.field_71456_v.func_73831_a();
        }

        this.field_71424_I.func_76318_c("pick");
        this.field_71460_t.func_78473_a(1.0F);
        this.field_71424_I.func_76318_c("gameMode");

        if (!this.field_71445_n && this.field_71441_e != null)
        {
            this.field_71442_b.func_78765_e();
        }

        this.field_71424_I.func_76318_c("textures");

        if (!this.field_71445_n)
        {
            this.field_71446_o.func_110550_d();
        }

        if (this.field_71462_r == null && this.field_71439_g != null)
        {
            if (this.field_71439_g.func_110143_aJ() <= 0.0F)
            {
                this.func_71373_a((GuiScreen)null);
            }
            else if (this.field_71439_g.func_70608_bn() && this.field_71441_e != null)
            {
                this.func_71373_a(new GuiSleepMP());
            }
        }
        else if (this.field_71462_r != null && this.field_71462_r instanceof GuiSleepMP && !this.field_71439_g.func_70608_bn())
        {
            this.func_71373_a((GuiScreen)null);
        }

        if (this.field_71462_r != null)
        {
            this.field_71429_W = 10000;
        }

        CrashReport crashreport;
        CrashReportCategory crashreportcategory;

        if (this.field_71462_r != null)
        {
            try
            {
                this.field_71462_r.func_73862_m();
            }
            catch (Throwable throwable)
            {
                crashreport = CrashReport.func_85055_a(throwable, "Updating screen events");
                crashreportcategory = crashreport.func_85058_a("Affected screen");
                crashreportcategory.func_71500_a("Screen name", new CallableUpdatingScreenName(this));
                throw new ReportedException(crashreport);
            }

            if (this.field_71462_r != null)
            {
                try
                {
                    this.field_71462_r.func_73876_c();
                }
                catch (Throwable throwable1)
                {
                    crashreport = CrashReport.func_85055_a(throwable1, "Ticking screen");
                    crashreportcategory = crashreport.func_85058_a("Affected screen");
                    crashreportcategory.func_71500_a("Screen name", new CallableParticleScreenName(this));
                    throw new ReportedException(crashreport);
                }
            }
        }

        if (this.field_71462_r == null || this.field_71462_r.field_73885_j)
        {
            this.field_71424_I.func_76318_c("mouse");
            int i;

            while (Mouse.next())
            {
                i = Mouse.getEventButton();

                if (field_142025_a && i == 0 && (Keyboard.isKeyDown(29) || Keyboard.isKeyDown(157)))
                {
                    i = 1;
                }

                KeyBinding.func_74510_a(i - 100, Mouse.getEventButtonState());

                if (Mouse.getEventButtonState())
                {
                    KeyBinding.func_74507_a(i - 100);
                }

                long j = func_71386_F() - this.field_71423_H;

                if (j <= 200L)
                {
                    int k = Mouse.getEventDWheel();

                    if (k != 0)
                    {
                        this.field_71439_g.field_71071_by.func_70453_c(k);

                        if (this.field_71474_y.field_74331_S)
                        {
                            if (k > 0)
                            {
                                k = 1;
                            }

                            if (k < 0)
                            {
                                k = -1;
                            }

                            this.field_71474_y.field_74328_V += (float)k * 0.25F;
                        }
                    }

                    if (this.field_71462_r == null)
                    {
                        if (!this.field_71415_G && Mouse.getEventButtonState())
                        {
                            this.func_71381_h();
                        }
                    }
                    else if (this.field_71462_r != null)
                    {
                        this.field_71462_r.func_73867_d();
                    }
                }
            }

            if (this.field_71429_W > 0)
            {
                --this.field_71429_W;
            }

            this.field_71424_I.func_76318_c("keyboard");
            boolean flag;

            while (Keyboard.next())
            {
                KeyBinding.func_74510_a(Keyboard.getEventKey(), Keyboard.getEventKeyState());

                if (Keyboard.getEventKeyState())
                {
                    KeyBinding.func_74507_a(Keyboard.getEventKey());
                }

                if (this.field_83002_am > 0L)
                {
                    if (func_71386_F() - this.field_83002_am >= 6000L)
                    {
                        throw new ReportedException(new CrashReport("Manually triggered debug crash", new Throwable()));
                    }

                    if (!Keyboard.isKeyDown(46) || !Keyboard.isKeyDown(61))
                    {
                        this.field_83002_am = -1L;
                    }
                }
                else if (Keyboard.isKeyDown(46) && Keyboard.isKeyDown(61))
                {
                    this.field_83002_am = func_71386_F();
                }

                if (Keyboard.getEventKeyState())
                {
                    if (Keyboard.getEventKey() == 87)
                    {
                        this.func_71352_k();
                    }
                    else
                    {
                        if (this.field_71462_r != null)
                        {
                            this.field_71462_r.func_73860_n();
                        }
                        else
                        {
                            if (Keyboard.getEventKey() == 1)
                            {
                                this.func_71385_j();
                            }

                            if (Keyboard.getEventKey() == 31 && Keyboard.isKeyDown(61))
                            {
                                this.func_110436_a();
                            }

                            if (Keyboard.getEventKey() == 20 && Keyboard.isKeyDown(61))
                            {
                                this.func_110436_a();
                            }

                            if (Keyboard.getEventKey() == 33 && Keyboard.isKeyDown(61))
                            {
                                flag = Keyboard.isKeyDown(42) | Keyboard.isKeyDown(54);
                                this.field_71474_y.func_74306_a(EnumOptions.RENDER_DISTANCE, flag ? -1 : 1);
                            }

                            if (Keyboard.getEventKey() == 30 && Keyboard.isKeyDown(61))
                            {
                                this.field_71438_f.func_72712_a();
                            }

                            if (Keyboard.getEventKey() == 35 && Keyboard.isKeyDown(61))
                            {
                                this.field_71474_y.field_82882_x = !this.field_71474_y.field_82882_x;
                                this.field_71474_y.func_74303_b();
                            }

                            if (Keyboard.getEventKey() == 48 && Keyboard.isKeyDown(61))
                            {
                                RenderManager.field_85095_o = !RenderManager.field_85095_o;
                            }

                            if (Keyboard.getEventKey() == 25 && Keyboard.isKeyDown(61))
                            {
                                this.field_71474_y.field_82881_y = !this.field_71474_y.field_82881_y;
                                this.field_71474_y.func_74303_b();
                            }

                            if (Keyboard.getEventKey() == 59)
                            {
                                this.field_71474_y.field_74319_N = !this.field_71474_y.field_74319_N;
                            }

                            if (Keyboard.getEventKey() == 61)
                            {
                                this.field_71474_y.field_74330_P = !this.field_71474_y.field_74330_P;
                                this.field_71474_y.field_74329_Q = GuiScreen.func_73877_p();
                            }

                            if (Keyboard.getEventKey() == 63)
                            {
                                ++this.field_71474_y.field_74320_O;

                                if (this.field_71474_y.field_74320_O > 2)
                                {
                                    this.field_71474_y.field_74320_O = 0;
                                }
                            }

                            if (Keyboard.getEventKey() == 66)
                            {
                                this.field_71474_y.field_74326_T = !this.field_71474_y.field_74326_T;
                            }
                        }

                        for (i = 0; i < 9; ++i)
                        {
                            if (Keyboard.getEventKey() == 2 + i)
                            {
                                this.field_71439_g.field_71071_by.field_70461_c = i;
                            }
                        }

                        if (this.field_71474_y.field_74330_P && this.field_71474_y.field_74329_Q)
                        {
                            if (Keyboard.getEventKey() == 11)
                            {
                                this.func_71383_b(0);
                            }

                            for (i = 0; i < 9; ++i)
                            {
                                if (Keyboard.getEventKey() == 2 + i)
                                {
                                    this.func_71383_b(i + 1);
                                }
                            }
                        }
                    }
                }
            }

            flag = this.field_71474_y.field_74343_n != 2;

            while (this.field_71474_y.field_74315_B.func_74509_c())
            {
                if (this.field_71442_b.func_110738_j())
                {
                    this.field_71439_g.func_110322_i();
                }
                else
                {
                    this.func_71373_a(new GuiInventory(this.field_71439_g));
                }
            }

            while (this.field_71474_y.field_74316_C.func_74509_c())
            {
                this.field_71439_g.func_71040_bB(GuiScreen.func_73861_o());
            }

            while (this.field_71474_y.field_74310_D.func_74509_c() && flag)
            {
                this.func_71373_a(new GuiChat());
            }

            if (this.field_71462_r == null && this.field_71474_y.field_74323_J.func_74509_c() && flag)
            {
                this.func_71373_a(new GuiChat("/"));
            }

            if (this.field_71439_g.func_71039_bw())
            {
                if (!this.field_71474_y.field_74313_G.field_74513_e)
                {
                    this.field_71442_b.func_78766_c(this.field_71439_g);
                }

                label381:

                while (true)
                {
                    if (!this.field_71474_y.field_74312_F.func_74509_c())
                    {
                        while (this.field_71474_y.field_74313_G.func_74509_c())
                        {
                            ;
                        }

                        while (true)
                        {
                            if (this.field_71474_y.field_74322_I.func_74509_c())
                            {
                                continue;
                            }

                            break label381;
                        }
                    }
                }
            }
            else
            {
                while (this.field_71474_y.field_74312_F.func_74509_c())
                {
                    this.func_71402_c(0);
                }

                while (this.field_71474_y.field_74313_G.func_74509_c())
                {
                    this.func_71402_c(1);
                }

                while (this.field_71474_y.field_74322_I.func_74509_c())
                {
                    this.func_71397_M();
                }
            }

            if (this.field_71474_y.field_74313_G.field_74513_e && this.field_71467_ac == 0 && !this.field_71439_g.func_71039_bw())
            {
                this.func_71402_c(1);
            }

            this.func_71399_a(0, this.field_71462_r == null && this.field_71474_y.field_74312_F.field_74513_e && this.field_71415_G);
        }

        if (this.field_71441_e != null)
        {
            if (this.field_71439_g != null)
            {
                ++this.field_71457_ai;

                if (this.field_71457_ai == 30)
                {
                    this.field_71457_ai = 0;
                    this.field_71441_e.func_72897_h(this.field_71439_g);
                }
            }

            this.field_71424_I.func_76318_c("gameRenderer");

            if (!this.field_71445_n)
            {
                this.field_71460_t.func_78464_a();
            }

            this.field_71424_I.func_76318_c("levelRenderer");

            if (!this.field_71445_n)
            {
                this.field_71438_f.func_72734_e();
            }

            this.field_71424_I.func_76318_c("level");

            if (!this.field_71445_n)
            {
                if (this.field_71441_e.field_73016_r > 0)
                {
                    --this.field_71441_e.field_73016_r;
                }

                this.field_71441_e.func_72939_s();
            }

            if (!this.field_71445_n)
            {
                this.field_71441_e.func_72891_a(this.field_71441_e.field_73013_u > 0, true);

                try
                {
                    this.field_71441_e.func_72835_b();
                }
                catch (Throwable throwable2)
                {
                    crashreport = CrashReport.func_85055_a(throwable2, "Exception in world tick");

                    if (this.field_71441_e == null)
                    {
                        crashreportcategory = crashreport.func_85058_a("Affected level");
                        crashreportcategory.func_71507_a("Problem", "Level is null!");
                    }
                    else
                    {
                        this.field_71441_e.func_72914_a(crashreport);
                    }

                    throw new ReportedException(crashreport);
                }
            }

            this.field_71424_I.func_76318_c("animateTick");

            if (!this.field_71445_n && this.field_71441_e != null)
            {
                this.field_71441_e.func_73029_E(MathHelper.func_76128_c(this.field_71439_g.field_70165_t), MathHelper.func_76128_c(this.field_71439_g.field_70163_u), MathHelper.func_76128_c(this.field_71439_g.field_70161_v));
            }

            this.field_71424_I.func_76318_c("particles");

            if (!this.field_71445_n)
            {
                this.field_71452_i.func_78868_a();
            }
        }
        else if (this.field_71453_ak != null)
        {
            this.field_71424_I.func_76318_c("pendingConnection");
            this.field_71453_ak.func_74428_b();
        }

        this.field_71424_I.func_76319_b();
        this.field_71423_H = func_71386_F();
    }

    public void func_71371_a(String p_71371_1_, String p_71371_2_, WorldSettings p_71371_3_)
    {
        this.func_71403_a((WorldClient)null);
        System.gc();
        ISaveHandler isavehandler = this.field_71469_aa.func_75804_a(p_71371_1_, false);
        WorldInfo worldinfo = isavehandler.func_75757_d();

        if (worldinfo == null && p_71371_3_ != null)
        {
            worldinfo = new WorldInfo(p_71371_3_, p_71371_1_);
            isavehandler.func_75761_a(worldinfo);
        }

        if (p_71371_3_ == null)
        {
            p_71371_3_ = new WorldSettings(worldinfo);
        }

        this.field_71413_E.func_77450_a(StatList.field_75936_f, 1);
        this.field_71437_Z = new IntegratedServer(this, p_71371_1_, p_71371_2_, p_71371_3_);
        this.field_71437_Z.func_71256_s();
        this.field_71455_al = true;
        this.field_71461_s.func_73720_a(I18n.func_135053_a("menu.loadingLevel"));

        while (!this.field_71437_Z.func_71200_ad())
        {
            String s2 = this.field_71437_Z.func_71195_b_();

            if (s2 != null)
            {
                this.field_71461_s.func_73719_c(I18n.func_135053_a(s2));
            }
            else
            {
                this.field_71461_s.func_73719_c("");
            }

            try
            {
                Thread.sleep(200L);
            }
            catch (InterruptedException interruptedexception)
            {
                ;
            }
        }

        this.func_71373_a((GuiScreen)null);

        try
        {
            NetClientHandler netclienthandler = new NetClientHandler(this, this.field_71437_Z);
            this.field_71453_ak = netclienthandler.func_72548_f();
        }
        catch (IOException ioexception)
        {
            this.func_71377_b(this.func_71396_d(new CrashReport("Connecting to integrated server", ioexception)));
        }
    }

    public void func_71403_a(WorldClient p_71403_1_)
    {
        this.func_71353_a(p_71403_1_, "");
    }

    public void func_71353_a(WorldClient p_71353_1_, String p_71353_2_)
    {
        this.field_71413_E.func_77446_d();

        if (p_71353_1_ == null)
        {
            NetClientHandler netclienthandler = this.func_71391_r();

            if (netclienthandler != null)
            {
                netclienthandler.func_72547_c();
            }

            if (this.field_71453_ak != null)
            {
                this.field_71453_ak.func_74431_f();
            }

            if (this.field_71437_Z != null)
            {
                this.field_71437_Z.func_71263_m();
            }

            this.field_71437_Z = null;
        }

        this.field_71451_h = null;
        this.field_71453_ak = null;

        if (this.field_71461_s != null)
        {
            this.field_71461_s.func_73721_b(p_71353_2_);
            this.field_71461_s.func_73719_c("");
        }

        if (p_71353_1_ == null && this.field_71441_e != null)
        {
            this.func_71351_a((ServerData)null);
            this.field_71455_al = false;
        }

        this.field_71416_A.func_77368_a((String)null, 0.0F, 0.0F, 0.0F);
        this.field_71416_A.func_82464_d();
        this.field_71441_e = p_71353_1_;

        if (p_71353_1_ != null)
        {
            if (this.field_71438_f != null)
            {
                this.field_71438_f.func_72732_a(p_71353_1_);
            }

            if (this.field_71452_i != null)
            {
                this.field_71452_i.func_78870_a(p_71353_1_);
            }

            if (this.field_71439_g == null)
            {
                this.field_71439_g = this.field_71442_b.func_78754_a(p_71353_1_);
                this.field_71442_b.func_78745_b(this.field_71439_g);
            }

            this.field_71439_g.func_70065_x();
            p_71353_1_.func_72838_d(this.field_71439_g);
            this.field_71439_g.field_71158_b = new MovementInputFromOptions(this.field_71474_y);
            this.field_71442_b.func_78748_a(this.field_71439_g);
            this.field_71451_h = this.field_71439_g;
        }
        else
        {
            this.field_71469_aa.func_75800_d();
            this.field_71439_g = null;
        }

        System.gc();
        this.field_71423_H = 0L;
    }

    public String func_71393_m()
    {
        return this.field_71438_f.func_72735_c();
    }

    public String func_71408_n()
    {
        return this.field_71438_f.func_72723_d();
    }

    public String func_71388_o()
    {
        return this.field_71441_e.func_72827_u();
    }

    public String func_71374_p()
    {
        return "P: " + this.field_71452_i.func_78869_b() + ". T: " + this.field_71441_e.func_72981_t();
    }

    public void func_71354_a(int p_71354_1_)
    {
        this.field_71441_e.func_72974_f();
        this.field_71441_e.func_73022_a();
        int j = 0;
        String s = null;

        if (this.field_71439_g != null)
        {
            j = this.field_71439_g.field_70157_k;
            this.field_71441_e.func_72900_e(this.field_71439_g);
            s = this.field_71439_g.func_142021_k();
        }

        this.field_71451_h = null;
        this.field_71439_g = this.field_71442_b.func_78754_a(this.field_71441_e);
        this.field_71439_g.field_71093_bK = p_71354_1_;
        this.field_71451_h = this.field_71439_g;
        this.field_71439_g.func_70065_x();
        this.field_71439_g.func_142020_c(s);
        this.field_71441_e.func_72838_d(this.field_71439_g);
        this.field_71442_b.func_78745_b(this.field_71439_g);
        this.field_71439_g.field_71158_b = new MovementInputFromOptions(this.field_71474_y);
        this.field_71439_g.field_70157_k = j;
        this.field_71442_b.func_78748_a(this.field_71439_g);

        if (this.field_71462_r instanceof GuiGameOver)
        {
            this.func_71373_a((GuiScreen)null);
        }
    }

    public final boolean func_71355_q()
    {
        return this.field_71459_aj;
    }

    public NetClientHandler func_71391_r()
    {
        return this.field_71439_g != null ? this.field_71439_g.field_71174_a : null;
    }

    public static boolean func_71382_s()
    {
        return field_71432_P == null || !field_71432_P.field_71474_y.field_74319_N;
    }

    public static boolean func_71375_t()
    {
        return field_71432_P != null && field_71432_P.field_71474_y.field_74347_j;
    }

    public static boolean func_71379_u()
    {
        return field_71432_P != null && field_71432_P.field_71474_y.field_74348_k != 0;
    }

    public boolean func_71409_c(String p_71409_1_)
    {
        return false;
    }

    private void func_71397_M()
    {
        if (this.field_71476_x != null)
        {
            boolean flag = this.field_71439_g.field_71075_bZ.field_75098_d;
            int i = 0;
            boolean flag1 = false;
            int j;
            int k;

            if (this.field_71476_x.field_72313_a == EnumMovingObjectType.TILE)
            {
                k = this.field_71476_x.field_72311_b;
                int l = this.field_71476_x.field_72312_c;
                int i1 = this.field_71476_x.field_72309_d;
                Block block = Block.field_71973_m[this.field_71441_e.func_72798_a(k, l, i1)];

                if (block == null)
                {
                    return;
                }

                j = block.func_71922_a(this.field_71441_e, k, l, i1);

                if (j == 0)
                {
                    return;
                }

                flag1 = Item.field_77698_e[j].func_77614_k();
                int j1 = j < 256 && !Block.field_71973_m[block.field_71990_ca].func_82505_u_() ? j : block.field_71990_ca;
                i = Block.field_71973_m[j1].func_71873_h(this.field_71441_e, k, l, i1);
            }
            else
            {
                if (this.field_71476_x.field_72313_a != EnumMovingObjectType.ENTITY || this.field_71476_x.field_72308_g == null || !flag)
                {
                    return;
                }

                if (this.field_71476_x.field_72308_g instanceof EntityPainting)
                {
                    j = Item.field_77780_as.field_77779_bT;
                }
                else if (this.field_71476_x.field_72308_g instanceof EntityLeashKnot)
                {
                    j = Item.field_111214_ch.field_77779_bT;
                }
                else if (this.field_71476_x.field_72308_g instanceof EntityItemFrame)
                {
                    EntityItemFrame entityitemframe = (EntityItemFrame)this.field_71476_x.field_72308_g;

                    if (entityitemframe.func_82335_i() == null)
                    {
                        j = Item.field_82802_bI.field_77779_bT;
                    }
                    else
                    {
                        j = entityitemframe.func_82335_i().field_77993_c;
                        i = entityitemframe.func_82335_i().func_77960_j();
                        flag1 = true;
                    }
                }
                else if (this.field_71476_x.field_72308_g instanceof EntityMinecart)
                {
                    EntityMinecart entityminecart = (EntityMinecart)this.field_71476_x.field_72308_g;

                    if (entityminecart.func_94087_l() == 2)
                    {
                        j = Item.field_77763_aO.field_77779_bT;
                    }
                    else if (entityminecart.func_94087_l() == 1)
                    {
                        j = Item.field_77762_aN.field_77779_bT;
                    }
                    else if (entityminecart.func_94087_l() == 3)
                    {
                        j = Item.field_94582_cb.field_77779_bT;
                    }
                    else if (entityminecart.func_94087_l() == 5)
                    {
                        j = Item.field_96600_cc.field_77779_bT;
                    }
                    else
                    {
                        j = Item.field_77773_az.field_77779_bT;
                    }
                }
                else if (this.field_71476_x.field_72308_g instanceof EntityBoat)
                {
                    j = Item.field_77769_aE.field_77779_bT;
                }
                else
                {
                    j = Item.field_77815_bC.field_77779_bT;
                    i = EntityList.func_75619_a(this.field_71476_x.field_72308_g);
                    flag1 = true;

                    if (i <= 0 || !EntityList.field_75627_a.containsKey(Integer.valueOf(i)))
                    {
                        return;
                    }
                }
            }

            this.field_71439_g.field_71071_by.func_70433_a(j, i, flag1, flag);

            if (flag)
            {
                k = this.field_71439_g.field_71069_bz.field_75151_b.size() - 9 + this.field_71439_g.field_71071_by.field_70461_c;
                this.field_71442_b.func_78761_a(this.field_71439_g.field_71071_by.func_70301_a(this.field_71439_g.field_71071_by.field_70461_c), k);
            }
        }
    }

    public CrashReport func_71396_d(CrashReport p_71396_1_)
    {
        p_71396_1_.func_85056_g().func_71500_a("Launched Version", new CallableLaunchedVersion(this));
        p_71396_1_.func_85056_g().func_71500_a("LWJGL", new CallableLWJGLVersion(this));
        p_71396_1_.func_85056_g().func_71500_a("OpenGL", new CallableGLInfo(this));
        p_71396_1_.func_85056_g().func_71500_a("Is Modded", new CallableModded(this));
        p_71396_1_.func_85056_g().func_71500_a("Type", new CallableType2(this));
        p_71396_1_.func_85056_g().func_71500_a("Resource Pack", new CallableTexturePack(this));
        p_71396_1_.func_85056_g().func_71500_a("Current Language", new CallableClientProfiler(this));
        p_71396_1_.func_85056_g().func_71500_a("Profiler Position", new CallableClientMemoryStats(this));
        p_71396_1_.func_85056_g().func_71500_a("Vec3 Pool Size", new MinecraftINNER13(this));

        if (this.field_71441_e != null)
        {
            this.field_71441_e.func_72914_a(p_71396_1_);
        }

        return p_71396_1_;
    }

    public static Minecraft func_71410_x()
    {
        return field_71432_P;
    }

    public void func_70000_a(PlayerUsageSnooper p_70000_1_)
    {
        p_70000_1_.func_76472_a("fps", Integer.valueOf(field_71470_ab));
        p_70000_1_.func_76472_a("texpack_name", this.field_110448_aq.func_110610_d());
        p_70000_1_.func_76472_a("vsync_enabled", Boolean.valueOf(this.field_71474_y.field_74352_v));
        p_70000_1_.func_76472_a("display_frequency", Integer.valueOf(Display.getDisplayMode().getFrequency()));
        p_70000_1_.func_76472_a("display_type", this.field_71431_Q ? "fullscreen" : "windowed");
        p_70000_1_.func_76472_a("run_time", Long.valueOf((MinecraftServer.func_130071_aq() - p_70000_1_.func_130105_g()) / 60L * 1000L));

        if (this.field_71437_Z != null && this.field_71437_Z.func_80003_ah() != null)
        {
            p_70000_1_.func_76472_a("snooper_partner", this.field_71437_Z.func_80003_ah().func_80006_f());
        }
    }

    public void func_70001_b(PlayerUsageSnooper p_70001_1_)
    {
        p_70001_1_.func_76472_a("opengl_version", GL11.glGetString(GL11.GL_VERSION));
        p_70001_1_.func_76472_a("opengl_vendor", GL11.glGetString(GL11.GL_VENDOR));
        p_70001_1_.func_76472_a("client_brand", ClientBrandRetriever.getClientModName());
        p_70001_1_.func_76472_a("launched_version", this.field_110447_Z);
        ContextCapabilities contextcapabilities = GLContext.getCapabilities();
        p_70001_1_.func_76472_a("gl_caps[ARB_multitexture]", Boolean.valueOf(contextcapabilities.GL_ARB_multitexture));
        p_70001_1_.func_76472_a("gl_caps[ARB_multisample]", Boolean.valueOf(contextcapabilities.GL_ARB_multisample));
        p_70001_1_.func_76472_a("gl_caps[ARB_texture_cube_map]", Boolean.valueOf(contextcapabilities.GL_ARB_texture_cube_map));
        p_70001_1_.func_76472_a("gl_caps[ARB_vertex_blend]", Boolean.valueOf(contextcapabilities.GL_ARB_vertex_blend));
        p_70001_1_.func_76472_a("gl_caps[ARB_matrix_palette]", Boolean.valueOf(contextcapabilities.GL_ARB_matrix_palette));
        p_70001_1_.func_76472_a("gl_caps[ARB_vertex_program]", Boolean.valueOf(contextcapabilities.GL_ARB_vertex_program));
        p_70001_1_.func_76472_a("gl_caps[ARB_vertex_shader]", Boolean.valueOf(contextcapabilities.GL_ARB_vertex_shader));
        p_70001_1_.func_76472_a("gl_caps[ARB_fragment_program]", Boolean.valueOf(contextcapabilities.GL_ARB_fragment_program));
        p_70001_1_.func_76472_a("gl_caps[ARB_fragment_shader]", Boolean.valueOf(contextcapabilities.GL_ARB_fragment_shader));
        p_70001_1_.func_76472_a("gl_caps[ARB_shader_objects]", Boolean.valueOf(contextcapabilities.GL_ARB_shader_objects));
        p_70001_1_.func_76472_a("gl_caps[ARB_vertex_buffer_object]", Boolean.valueOf(contextcapabilities.GL_ARB_vertex_buffer_object));
        p_70001_1_.func_76472_a("gl_caps[ARB_framebuffer_object]", Boolean.valueOf(contextcapabilities.GL_ARB_framebuffer_object));
        p_70001_1_.func_76472_a("gl_caps[ARB_pixel_buffer_object]", Boolean.valueOf(contextcapabilities.GL_ARB_pixel_buffer_object));
        p_70001_1_.func_76472_a("gl_caps[ARB_uniform_buffer_object]", Boolean.valueOf(contextcapabilities.GL_ARB_uniform_buffer_object));
        p_70001_1_.func_76472_a("gl_caps[ARB_texture_non_power_of_two]", Boolean.valueOf(contextcapabilities.GL_ARB_texture_non_power_of_two));
        p_70001_1_.func_76472_a("gl_caps[gl_max_vertex_uniforms]", Integer.valueOf(GL11.glGetInteger(GL20.GL_MAX_VERTEX_UNIFORM_COMPONENTS)));
        p_70001_1_.func_76472_a("gl_caps[gl_max_fragment_uniforms]", Integer.valueOf(GL11.glGetInteger(GL20.GL_MAX_FRAGMENT_UNIFORM_COMPONENTS)));
        p_70001_1_.func_76472_a("gl_max_texture_size", Integer.valueOf(func_71369_N()));
    }

    public static int func_71369_N()
    {
        for (int i = 16384; i > 0; i >>= 1)
        {
            GL11.glTexImage2D(GL11.GL_PROXY_TEXTURE_2D, 0, GL11.GL_RGBA, i, i, 0, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, (ByteBuffer)null);
            int j = GL11.glGetTexLevelParameteri(GL11.GL_PROXY_TEXTURE_2D, 0, GL11.GL_TEXTURE_WIDTH);

            if (j != 0)
            {
                return i;
            }
        }

        return -1;
    }

    public boolean func_70002_Q()
    {
        return this.field_71474_y.field_74355_t;
    }

    public void func_71351_a(ServerData p_71351_1_)
    {
        this.field_71422_O = p_71351_1_;
    }

    public boolean func_71387_A()
    {
        return this.field_71455_al;
    }

    public boolean func_71356_B()
    {
        return this.field_71455_al && this.field_71437_Z != null;
    }

    public IntegratedServer func_71401_C()
    {
        return this.field_71437_Z;
    }

    public static void func_71363_D()
    {
        if (field_71432_P != null)
        {
            IntegratedServer integratedserver = field_71432_P.func_71401_C();

            if (integratedserver != null)
            {
                integratedserver.func_71260_j();
            }
        }
    }

    public PlayerUsageSnooper func_71378_E()
    {
        return this.field_71427_U;
    }

    public static long func_71386_F()
    {
        return Sys.getTime() * 1000L / Sys.getTimerResolution();
    }

    public boolean func_71372_G()
    {
        return this.field_71431_Q;
    }

    public ILogAgent func_98033_al()
    {
        return this.field_94139_O;
    }

    public Session func_110432_I()
    {
        return this.field_71449_j;
    }

    public Proxy func_110437_J()
    {
        return this.field_110453_aa;
    }

    public TextureManager func_110434_K()
    {
        return this.field_71446_o;
    }

    public ResourceManager func_110442_L()
    {
        return this.field_110451_am;
    }

    public ResourcePackRepository func_110438_M()
    {
        return this.field_110448_aq;
    }

    public LanguageManager func_135016_M()
    {
        return this.field_135017_as;
    }

    static String func_110431_a(Minecraft p_110431_0_)
    {
        return p_110431_0_.field_110447_Z;
    }

    static LanguageManager func_142024_b(Minecraft p_142024_0_)
    {
        return p_142024_0_.field_135017_as;
    }
}
