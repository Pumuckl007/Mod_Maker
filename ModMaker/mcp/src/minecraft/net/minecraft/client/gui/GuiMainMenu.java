package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.mco.ExceptionMcoService;
import net.minecraft.client.mco.GuiScreenClientOutdated;
import net.minecraft.client.mco.McoClient;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.demo.DemoWorldServer;
import net.minecraft.world.storage.ISaveFormat;
import net.minecraft.world.storage.WorldInfo;
import org.apache.commons.io.Charsets;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Project;

@SideOnly(Side.CLIENT)
public class GuiMainMenu extends GuiScreen
{
    private static final Random field_73976_a = new Random();
    private float field_73974_b;
    private String field_73975_c = "missingno";
    private GuiButton field_73973_d;
    private int field_73979_m;
    private DynamicTexture field_73977_n;
    private boolean field_96141_q = true;
    private static boolean field_96140_r;
    private static boolean field_96139_s;
    private final Object field_104025_t = new Object();
    private String field_92025_p;
    private String field_104024_v;
    private static final ResourceLocation field_110353_x = new ResourceLocation("texts/splashes.txt");
    private static final ResourceLocation field_110352_y = new ResourceLocation("textures/gui/title/minecraft.png");
    private static final ResourceLocation[] field_73978_o = new ResourceLocation[] {new ResourceLocation("textures/gui/title/background/panorama_0.png"), new ResourceLocation("textures/gui/title/background/panorama_1.png"), new ResourceLocation("textures/gui/title/background/panorama_2.png"), new ResourceLocation("textures/gui/title/background/panorama_3.png"), new ResourceLocation("textures/gui/title/background/panorama_4.png"), new ResourceLocation("textures/gui/title/background/panorama_5.png")};
    public static final String field_96138_a = "Please click " + EnumChatFormatting.UNDERLINE + "here" + EnumChatFormatting.RESET + " for more information.";
    private int field_92024_r;
    private int field_92023_s;
    private int field_92022_t;
    private int field_92021_u;
    private int field_92020_v;
    private int field_92019_w;
    private ResourceLocation field_110351_G;
    private GuiButton field_130023_H;

    public GuiMainMenu()
    {
        BufferedReader bufferedreader = null;
        String s;

        try
        {
            ArrayList arraylist = new ArrayList();
            bufferedreader = new BufferedReader(new InputStreamReader(Minecraft.func_71410_x().func_110442_L().func_110536_a(field_110353_x).func_110527_b(), Charsets.UTF_8));

            while ((s = bufferedreader.readLine()) != null)
            {
                s = s.trim();

                if (!s.isEmpty())
                {
                    arraylist.add(s);
                }
            }

            do
            {
                this.field_73975_c = (String)arraylist.get(field_73976_a.nextInt(arraylist.size()));
            }
            while (this.field_73975_c.hashCode() == 125780783);
        }
        catch (IOException ioexception)
        {
            ;
        }
        finally
        {
            if (bufferedreader != null)
            {
                try
                {
                    bufferedreader.close();
                }
                catch (IOException ioexception1)
                {
                    ;
                }
            }
        }

        this.field_73974_b = field_73976_a.nextFloat();
        this.field_92025_p = "";
        String s1 = System.getProperty("os_architecture");
        s = System.getProperty("java_version");

        if ("ppc".equalsIgnoreCase(s1))
        {
            this.field_92025_p = "" + EnumChatFormatting.BOLD + "Notice!" + EnumChatFormatting.RESET + " PowerPC compatibility will be dropped in Minecraft 1.6";
            this.field_104024_v = "http://tinyurl.com/javappc";
        }
        else if (s != null && s.startsWith("1.5"))
        {
            this.field_92025_p = "" + EnumChatFormatting.BOLD + "Notice!" + EnumChatFormatting.RESET + " Java 1.5 compatibility will be dropped in Minecraft 1.6";
            this.field_104024_v = "http://tinyurl.com/javappc";
        }
    }

    public void func_73876_c()
    {
        ++this.field_73979_m;
    }

    public boolean func_73868_f()
    {
        return false;
    }

    protected void func_73869_a(char p_73869_1_, int p_73869_2_) {}

    public void func_73866_w_()
    {
        this.field_73977_n = new DynamicTexture(256, 256);
        this.field_110351_G = this.field_73882_e.func_110434_K().func_110578_a("background", this.field_73977_n);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        if (calendar.get(2) + 1 == 11 && calendar.get(5) == 9)
        {
            this.field_73975_c = "Happy birthday, ez!";
        }
        else if (calendar.get(2) + 1 == 6 && calendar.get(5) == 1)
        {
            this.field_73975_c = "Happy birthday, Notch!";
        }
        else if (calendar.get(2) + 1 == 12 && calendar.get(5) == 24)
        {
            this.field_73975_c = "Merry X-mas!";
        }
        else if (calendar.get(2) + 1 == 1 && calendar.get(5) == 1)
        {
            this.field_73975_c = "Happy new year!";
        }
        else if (calendar.get(2) + 1 == 10 && calendar.get(5) == 31)
        {
            this.field_73975_c = "OOoooOOOoooo! Spooky!";
        }

        boolean flag = true;
        int i = this.field_73881_g / 4 + 48;

        if (this.field_73882_e.func_71355_q())
        {
            this.func_73972_b(i, 24);
        }
        else
        {
            this.func_73969_a(i, 24);
        }

        this.func_130020_g();
        this.field_73887_h.add(new GuiButton(0, this.field_73880_f / 2 - 100, i + 72 + 12, 98, 20, I18n.func_135053_a("menu.options")));
        this.field_73887_h.add(new GuiButton(4, this.field_73880_f / 2 + 2, i + 72 + 12, 98, 20, I18n.func_135053_a("menu.quit")));
        this.field_73887_h.add(new GuiButtonLanguage(5, this.field_73880_f / 2 - 124, i + 72 + 12));
        Object object = this.field_104025_t;

        synchronized (this.field_104025_t)
        {
            this.field_92023_s = this.field_73886_k.func_78256_a(this.field_92025_p);
            this.field_92024_r = this.field_73886_k.func_78256_a(field_96138_a);
            int j = Math.max(this.field_92023_s, this.field_92024_r);
            this.field_92022_t = (this.field_73880_f - j) / 2;
            this.field_92021_u = ((GuiButton)this.field_73887_h.get(0)).field_73743_d - 24;
            this.field_92020_v = this.field_92022_t + j;
            this.field_92019_w = this.field_92021_u + 24;
        }
    }

    private void func_130020_g()
    {
        if (this.field_96141_q)
        {
            if (!field_96140_r)
            {
                field_96140_r = true;
                (new RunnableTitleScreen(this)).start();
            }
            else if (field_96139_s)
            {
                this.func_130022_h();
            }
        }
    }

    private void func_130022_h()
    {
        this.field_130023_H.field_73748_h = true;
    }

    private void func_73969_a(int p_73969_1_, int p_73969_2_)
    {
        this.field_73887_h.add(new GuiButton(1, this.field_73880_f / 2 - 100, p_73969_1_, I18n.func_135053_a("menu.singleplayer")));
        this.field_73887_h.add(new GuiButton(2, this.field_73880_f / 2 - 100, p_73969_1_ + p_73969_2_ * 1, I18n.func_135053_a("menu.multiplayer")));
        this.field_73887_h.add(this.field_130023_H = new GuiButton(14, this.field_73880_f / 2 - 100, p_73969_1_ + p_73969_2_ * 2, I18n.func_135053_a("menu.online")));
        this.field_130023_H.field_73748_h = false;
    }

    private void func_73972_b(int p_73972_1_, int p_73972_2_)
    {
        this.field_73887_h.add(new GuiButton(11, this.field_73880_f / 2 - 100, p_73972_1_, I18n.func_135053_a("menu.playdemo")));
        this.field_73887_h.add(this.field_73973_d = new GuiButton(12, this.field_73880_f / 2 - 100, p_73972_1_ + p_73972_2_ * 1, I18n.func_135053_a("menu.resetdemo")));
        ISaveFormat isaveformat = this.field_73882_e.func_71359_d();
        WorldInfo worldinfo = isaveformat.func_75803_c("Demo_World");

        if (worldinfo == null)
        {
            this.field_73973_d.field_73742_g = false;
        }
    }

    protected void func_73875_a(GuiButton p_73875_1_)
    {
        if (p_73875_1_.field_73741_f == 0)
        {
            this.field_73882_e.func_71373_a(new GuiOptions(this, this.field_73882_e.field_71474_y));
        }

        if (p_73875_1_.field_73741_f == 5)
        {
            this.field_73882_e.func_71373_a(new GuiLanguage(this, this.field_73882_e.field_71474_y, this.field_73882_e.func_135016_M()));
        }

        if (p_73875_1_.field_73741_f == 1)
        {
            this.field_73882_e.func_71373_a(new GuiSelectWorld(this));
        }

        if (p_73875_1_.field_73741_f == 2)
        {
            this.field_73882_e.func_71373_a(new GuiMultiplayer(this));
        }

        if (p_73875_1_.field_73741_f == 14 && this.field_130023_H.field_73748_h)
        {
            this.func_140005_i();
        }

        if (p_73875_1_.field_73741_f == 4)
        {
            this.field_73882_e.func_71400_g();
        }

        if (p_73875_1_.field_73741_f == 11)
        {
            this.field_73882_e.func_71371_a("Demo_World", "Demo_World", DemoWorldServer.field_73071_a);
        }

        if (p_73875_1_.field_73741_f == 12)
        {
            ISaveFormat isaveformat = this.field_73882_e.func_71359_d();
            WorldInfo worldinfo = isaveformat.func_75803_c("Demo_World");

            if (worldinfo != null)
            {
                GuiYesNo guiyesno = GuiSelectWorld.func_74061_a(this, worldinfo.func_76065_j(), 12);
                this.field_73882_e.func_71373_a(guiyesno);
            }
        }
    }

    private void func_140005_i()
    {
        McoClient mcoclient = new McoClient(this.field_73882_e.func_110432_I());

        try
        {
            if (mcoclient.func_140054_c().booleanValue())
            {
                this.field_73882_e.func_71373_a(new GuiScreenClientOutdated(this));
            }
            else
            {
                this.field_73882_e.func_71373_a(new GuiScreenOnlineServers(this));
            }
        }
        catch (ExceptionMcoService exceptionmcoservice)
        {
            this.field_73882_e.func_98033_al().func_98232_c(exceptionmcoservice.toString());
        }
        catch (IOException ioexception)
        {
            this.field_73882_e.func_98033_al().func_98232_c(ioexception.getLocalizedMessage());
        }
    }

    public void func_73878_a(boolean p_73878_1_, int p_73878_2_)
    {
        if (p_73878_1_ && p_73878_2_ == 12)
        {
            ISaveFormat isaveformat = this.field_73882_e.func_71359_d();
            isaveformat.func_75800_d();
            isaveformat.func_75802_e("Demo_World");
            this.field_73882_e.func_71373_a(this);
        }
        else if (p_73878_2_ == 13)
        {
            if (p_73878_1_)
            {
                try
                {
                    Class oclass = Class.forName("java.awt.Desktop");
                    Object object = oclass.getMethod("getDesktop", new Class[0]).invoke((Object)null, new Object[0]);
                    oclass.getMethod("browse", new Class[] {URI.class}).invoke(object, new Object[] {new URI(this.field_104024_v)});
                }
                catch (Throwable throwable)
                {
                    throwable.printStackTrace();
                }
            }

            this.field_73882_e.func_71373_a(this);
        }
    }

    private void func_73970_b(int p_73970_1_, int p_73970_2_, float p_73970_3_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glPushMatrix();
        GL11.glLoadIdentity();
        Project.gluPerspective(120.0F, 1.0F, 0.05F, 10.0F);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glPushMatrix();
        GL11.glLoadIdentity();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_ALPHA_TEST);
        GL11.glDisable(GL11.GL_CULL_FACE);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        byte b0 = 8;

        for (int k = 0; k < b0 * b0; ++k)
        {
            GL11.glPushMatrix();
            float f1 = ((float)(k % b0) / (float)b0 - 0.5F) / 64.0F;
            float f2 = ((float)(k / b0) / (float)b0 - 0.5F) / 64.0F;
            float f3 = 0.0F;
            GL11.glTranslatef(f1, f2, f3);
            GL11.glRotatef(MathHelper.func_76126_a(((float)this.field_73979_m + p_73970_3_) / 400.0F) * 25.0F + 20.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(-((float)this.field_73979_m + p_73970_3_) * 0.1F, 0.0F, 1.0F, 0.0F);

            for (int l = 0; l < 6; ++l)
            {
                GL11.glPushMatrix();

                if (l == 1)
                {
                    GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
                }

                if (l == 2)
                {
                    GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
                }

                if (l == 3)
                {
                    GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
                }

                if (l == 4)
                {
                    GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
                }

                if (l == 5)
                {
                    GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
                }

                this.field_73882_e.func_110434_K().func_110577_a(field_73978_o[l]);
                tessellator.func_78382_b();
                tessellator.func_78384_a(16777215, 255 / (k + 1));
                float f4 = 0.0F;
                tessellator.func_78374_a(-1.0D, -1.0D, 1.0D, (double)(0.0F + f4), (double)(0.0F + f4));
                tessellator.func_78374_a(1.0D, -1.0D, 1.0D, (double)(1.0F - f4), (double)(0.0F + f4));
                tessellator.func_78374_a(1.0D, 1.0D, 1.0D, (double)(1.0F - f4), (double)(1.0F - f4));
                tessellator.func_78374_a(-1.0D, 1.0D, 1.0D, (double)(0.0F + f4), (double)(1.0F - f4));
                tessellator.func_78381_a();
                GL11.glPopMatrix();
            }

            GL11.glPopMatrix();
            GL11.glColorMask(true, true, true, false);
        }

        tessellator.func_78373_b(0.0D, 0.0D, 0.0D);
        GL11.glColorMask(true, true, true, true);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glPopMatrix();
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glPopMatrix();
        GL11.glDepthMask(true);
        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
    }

    private void func_73968_a(float p_73968_1_)
    {
        this.field_73882_e.func_110434_K().func_110577_a(this.field_110351_G);
        GL11.glCopyTexSubImage2D(GL11.GL_TEXTURE_2D, 0, 0, 0, 0, 0, 256, 256);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glColorMask(true, true, true, false);
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78382_b();
        byte b0 = 3;

        for (int i = 0; i < b0; ++i)
        {
            tessellator.func_78369_a(1.0F, 1.0F, 1.0F, 1.0F / (float)(i + 1));
            int j = this.field_73880_f;
            int k = this.field_73881_g;
            float f1 = (float)(i - b0 / 2) / 256.0F;
            tessellator.func_78374_a((double)j, (double)k, (double)this.field_73735_i, (double)(0.0F + f1), 0.0D);
            tessellator.func_78374_a((double)j, 0.0D, (double)this.field_73735_i, (double)(1.0F + f1), 0.0D);
            tessellator.func_78374_a(0.0D, 0.0D, (double)this.field_73735_i, (double)(1.0F + f1), 1.0D);
            tessellator.func_78374_a(0.0D, (double)k, (double)this.field_73735_i, (double)(0.0F + f1), 1.0D);
        }

        tessellator.func_78381_a();
        GL11.glColorMask(true, true, true, true);
    }

    private void func_73971_c(int p_73971_1_, int p_73971_2_, float p_73971_3_)
    {
        GL11.glViewport(0, 0, 256, 256);
        this.func_73970_b(p_73971_1_, p_73971_2_, p_73971_3_);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        this.func_73968_a(p_73971_3_);
        this.func_73968_a(p_73971_3_);
        this.func_73968_a(p_73971_3_);
        this.func_73968_a(p_73971_3_);
        this.func_73968_a(p_73971_3_);
        this.func_73968_a(p_73971_3_);
        this.func_73968_a(p_73971_3_);
        this.func_73968_a(p_73971_3_);
        GL11.glViewport(0, 0, this.field_73882_e.field_71443_c, this.field_73882_e.field_71440_d);
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78382_b();
        float f1 = this.field_73880_f > this.field_73881_g ? 120.0F / (float)this.field_73880_f : 120.0F / (float)this.field_73881_g;
        float f2 = (float)this.field_73881_g * f1 / 256.0F;
        float f3 = (float)this.field_73880_f * f1 / 256.0F;
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
        tessellator.func_78369_a(1.0F, 1.0F, 1.0F, 1.0F);
        int k = this.field_73880_f;
        int l = this.field_73881_g;
        tessellator.func_78374_a(0.0D, (double)l, (double)this.field_73735_i, (double)(0.5F - f2), (double)(0.5F + f3));
        tessellator.func_78374_a((double)k, (double)l, (double)this.field_73735_i, (double)(0.5F - f2), (double)(0.5F - f3));
        tessellator.func_78374_a((double)k, 0.0D, (double)this.field_73735_i, (double)(0.5F + f2), (double)(0.5F - f3));
        tessellator.func_78374_a(0.0D, 0.0D, (double)this.field_73735_i, (double)(0.5F + f2), (double)(0.5F + f3));
        tessellator.func_78381_a();
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        this.func_73971_c(p_73863_1_, p_73863_2_, p_73863_3_);
        Tessellator tessellator = Tessellator.field_78398_a;
        short short1 = 274;
        int k = this.field_73880_f / 2 - short1 / 2;
        byte b0 = 30;
        this.func_73733_a(0, 0, this.field_73880_f, this.field_73881_g, -2130706433, 16777215);
        this.func_73733_a(0, 0, this.field_73880_f, this.field_73881_g, 0, Integer.MIN_VALUE);
        this.field_73882_e.func_110434_K().func_110577_a(field_110352_y);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

        if ((double)this.field_73974_b < 1.0E-4D)
        {
            this.func_73729_b(k + 0, b0 + 0, 0, 0, 99, 44);
            this.func_73729_b(k + 99, b0 + 0, 129, 0, 27, 44);
            this.func_73729_b(k + 99 + 26, b0 + 0, 126, 0, 3, 44);
            this.func_73729_b(k + 99 + 26 + 3, b0 + 0, 99, 0, 26, 44);
            this.func_73729_b(k + 155, b0 + 0, 0, 45, 155, 44);
        }
        else
        {
            this.func_73729_b(k + 0, b0 + 0, 0, 0, 155, 44);
            this.func_73729_b(k + 155, b0 + 0, 0, 45, 155, 44);
        }

        tessellator.func_78378_d(16777215);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)(this.field_73880_f / 2 + 90), 70.0F, 0.0F);
        GL11.glRotatef(-20.0F, 0.0F, 0.0F, 1.0F);
        float f1 = 1.8F - MathHelper.func_76135_e(MathHelper.func_76126_a((float)(Minecraft.func_71386_F() % 1000L) / 1000.0F * (float)Math.PI * 2.0F) * 0.1F);
        f1 = f1 * 100.0F / (float)(this.field_73886_k.func_78256_a(this.field_73975_c) + 32);
        GL11.glScalef(f1, f1, f1);
        this.func_73732_a(this.field_73886_k, this.field_73975_c, 0, -8, 16776960);
        GL11.glPopMatrix();
        String s = "Minecraft 1.6.4";

        if (this.field_73882_e.func_71355_q())
        {
            s = s + " Demo";
        }

        this.func_73731_b(this.field_73886_k, s, 2, this.field_73881_g - 10, 16777215);
        String s1 = "Copyright Mojang AB. Do not distribute!";
        this.func_73731_b(this.field_73886_k, s1, this.field_73880_f - this.field_73886_k.func_78256_a(s1) - 2, this.field_73881_g - 10, 16777215);

        if (this.field_92025_p != null && this.field_92025_p.length() > 0)
        {
            func_73734_a(this.field_92022_t - 2, this.field_92021_u - 2, this.field_92020_v + 2, this.field_92019_w - 1, 1428160512);
            this.func_73731_b(this.field_73886_k, this.field_92025_p, this.field_92022_t, this.field_92021_u, 16777215);
            this.func_73731_b(this.field_73886_k, field_96138_a, (this.field_73880_f - this.field_92024_r) / 2, ((GuiButton)this.field_73887_h.get(0)).field_73743_d - 12, 16777215);
        }

        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
    }

    protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_)
    {
        super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
        Object object = this.field_104025_t;

        synchronized (this.field_104025_t)
        {
            if (this.field_92025_p.length() > 0 && p_73864_1_ >= this.field_92022_t && p_73864_1_ <= this.field_92020_v && p_73864_2_ >= this.field_92021_u && p_73864_2_ <= this.field_92019_w)
            {
                GuiConfirmOpenLink guiconfirmopenlink = new GuiConfirmOpenLink(this, this.field_104024_v, 13, true);
                guiconfirmopenlink.func_92026_h();
                this.field_73882_e.func_71373_a(guiconfirmopenlink);
            }
        }
    }

    static Minecraft func_110348_a(GuiMainMenu p_110348_0_)
    {
        return p_110348_0_.field_73882_e;
    }

    static void func_130021_b(GuiMainMenu p_130021_0_)
    {
        p_130021_0_.func_130022_h();
    }

    static boolean func_110349_a(boolean p_110349_0_)
    {
        field_96139_s = p_110349_0_;
        return p_110349_0_;
    }

    static Minecraft func_130018_c(GuiMainMenu p_130018_0_)
    {
        return p_130018_0_.field_73882_e;
    }

    static Minecraft func_130019_d(GuiMainMenu p_130019_0_)
    {
        return p_130019_0_.field_73882_e;
    }
}
