package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Collections;
import java.util.List;
import net.minecraft.client.multiplayer.GuiConnecting;
import net.minecraft.client.multiplayer.LanServer;
import net.minecraft.client.multiplayer.LanServerList;
import net.minecraft.client.multiplayer.ServerAddress;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.multiplayer.ServerList;
import net.minecraft.client.multiplayer.ThreadLanServerFind;
import net.minecraft.client.resources.I18n;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet254ServerPing;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import org.lwjgl.input.Keyboard;

@SideOnly(Side.CLIENT)
public class GuiMultiplayer extends GuiScreen
{
    private static int field_74027_a;
    private static Object field_74023_b = new Object();
    private GuiScreen field_74025_c;
    private GuiSlotServer field_74022_d;
    private ServerList field_74030_m;
    private int field_74028_n = -1;
    private GuiButton field_96289_p;
    private GuiButton field_74038_p;
    private GuiButton field_74037_q;
    private boolean field_74036_r;
    private boolean field_74035_s;
    private boolean field_74034_t;
    private boolean field_74033_u;
    private String field_74032_v;
    private ServerData field_74031_w;
    private LanServerList field_74041_x;
    private ThreadLanServerFind field_74040_y;
    private int field_74039_z;
    private boolean field_74024_A;
    private List field_74026_B = Collections.emptyList();

    public GuiMultiplayer(GuiScreen p_i1040_1_)
    {
        this.field_74025_c = p_i1040_1_;
    }

    public void func_73866_w_()
    {
        Keyboard.enableRepeatEvents(true);
        this.field_73887_h.clear();

        if (!this.field_74024_A)
        {
            this.field_74024_A = true;
            this.field_74030_m = new ServerList(this.field_73882_e);
            this.field_74030_m.func_78853_a();
            this.field_74041_x = new LanServerList();

            try
            {
                this.field_74040_y = new ThreadLanServerFind(this.field_74041_x);
                this.field_74040_y.start();
            }
            catch (Exception exception)
            {
                this.field_73882_e.func_98033_al().func_98236_b("Unable to start LAN server detection: " + exception.getMessage());
            }

            this.field_74022_d = new GuiSlotServer(this);
        }
        else
        {
            this.field_74022_d.func_77207_a(this.field_73880_f, this.field_73881_g, 32, this.field_73881_g - 64);
        }

        this.func_74016_g();
    }

    public void func_74016_g()
    {
        this.field_73887_h.add(this.field_96289_p = new GuiButton(7, this.field_73880_f / 2 - 154, this.field_73881_g - 28, 70, 20, I18n.func_135053_a("selectServer.edit")));
        this.field_73887_h.add(this.field_74037_q = new GuiButton(2, this.field_73880_f / 2 - 74, this.field_73881_g - 28, 70, 20, I18n.func_135053_a("selectServer.delete")));
        this.field_73887_h.add(this.field_74038_p = new GuiButton(1, this.field_73880_f / 2 - 154, this.field_73881_g - 52, 100, 20, I18n.func_135053_a("selectServer.select")));
        this.field_73887_h.add(new GuiButton(4, this.field_73880_f / 2 - 50, this.field_73881_g - 52, 100, 20, I18n.func_135053_a("selectServer.direct")));
        this.field_73887_h.add(new GuiButton(3, this.field_73880_f / 2 + 4 + 50, this.field_73881_g - 52, 100, 20, I18n.func_135053_a("selectServer.add")));
        this.field_73887_h.add(new GuiButton(8, this.field_73880_f / 2 + 4, this.field_73881_g - 28, 70, 20, I18n.func_135053_a("selectServer.refresh")));
        this.field_73887_h.add(new GuiButton(0, this.field_73880_f / 2 + 4 + 76, this.field_73881_g - 28, 75, 20, I18n.func_135053_a("gui.cancel")));
        boolean flag = this.field_74028_n >= 0 && this.field_74028_n < this.field_74022_d.func_77217_a();
        this.field_74038_p.field_73742_g = flag;
        this.field_96289_p.field_73742_g = flag;
        this.field_74037_q.field_73742_g = flag;
    }

    public void func_73876_c()
    {
        super.func_73876_c();
        ++this.field_74039_z;

        if (this.field_74041_x.func_77553_a())
        {
            this.field_74026_B = this.field_74041_x.func_77554_c();
            this.field_74041_x.func_77552_b();
        }
    }

    public void func_73874_b()
    {
        Keyboard.enableRepeatEvents(false);

        if (this.field_74040_y != null)
        {
            this.field_74040_y.interrupt();
            this.field_74040_y = null;
        }
    }

    protected void func_73875_a(GuiButton p_73875_1_)
    {
        if (p_73875_1_.field_73742_g)
        {
            if (p_73875_1_.field_73741_f == 2)
            {
                String s = this.field_74030_m.func_78850_a(this.field_74028_n).field_78847_a;

                if (s != null)
                {
                    this.field_74036_r = true;
                    String s1 = I18n.func_135053_a("selectServer.deleteQuestion");
                    String s2 = "\'" + s + "\' " + I18n.func_135053_a("selectServer.deleteWarning");
                    String s3 = I18n.func_135053_a("selectServer.deleteButton");
                    String s4 = I18n.func_135053_a("gui.cancel");
                    GuiYesNo guiyesno = new GuiYesNo(this, s1, s2, s3, s4, this.field_74028_n);
                    this.field_73882_e.func_71373_a(guiyesno);
                }
            }
            else if (p_73875_1_.field_73741_f == 1)
            {
                this.func_74004_a(this.field_74028_n);
            }
            else if (p_73875_1_.field_73741_f == 4)
            {
                this.field_74033_u = true;
                this.field_73882_e.func_71373_a(new GuiScreenServerList(this, this.field_74031_w = new ServerData(I18n.func_135053_a("selectServer.defaultName"), "")));
            }
            else if (p_73875_1_.field_73741_f == 3)
            {
                this.field_74035_s = true;
                this.field_73882_e.func_71373_a(new GuiScreenAddServer(this, this.field_74031_w = new ServerData(I18n.func_135053_a("selectServer.defaultName"), "")));
            }
            else if (p_73875_1_.field_73741_f == 7)
            {
                this.field_74034_t = true;
                ServerData serverdata = this.field_74030_m.func_78850_a(this.field_74028_n);
                this.field_74031_w = new ServerData(serverdata.field_78847_a, serverdata.field_78845_b);
                this.field_74031_w.func_82819_b(serverdata.func_82820_d());
                this.field_73882_e.func_71373_a(new GuiScreenAddServer(this, this.field_74031_w));
            }
            else if (p_73875_1_.field_73741_f == 0)
            {
                this.field_73882_e.func_71373_a(this.field_74025_c);
            }
            else if (p_73875_1_.field_73741_f == 8)
            {
                this.field_73882_e.func_71373_a(new GuiMultiplayer(this.field_74025_c));
            }
            else
            {
                this.field_74022_d.func_77219_a(p_73875_1_);
            }
        }
    }

    public void func_73878_a(boolean p_73878_1_, int p_73878_2_)
    {
        if (this.field_74036_r)
        {
            this.field_74036_r = false;

            if (p_73878_1_)
            {
                this.field_74030_m.func_78851_b(p_73878_2_);
                this.field_74030_m.func_78855_b();
                this.field_74028_n = -1;
            }

            this.field_73882_e.func_71373_a(this);
        }
        else if (this.field_74033_u)
        {
            this.field_74033_u = false;

            if (p_73878_1_)
            {
                this.func_74002_a(this.field_74031_w);
            }
            else
            {
                this.field_73882_e.func_71373_a(this);
            }
        }
        else if (this.field_74035_s)
        {
            this.field_74035_s = false;

            if (p_73878_1_)
            {
                this.field_74030_m.func_78849_a(this.field_74031_w);
                this.field_74030_m.func_78855_b();
                this.field_74028_n = -1;
            }

            this.field_73882_e.func_71373_a(this);
        }
        else if (this.field_74034_t)
        {
            this.field_74034_t = false;

            if (p_73878_1_)
            {
                ServerData serverdata = this.field_74030_m.func_78850_a(this.field_74028_n);
                serverdata.field_78847_a = this.field_74031_w.field_78847_a;
                serverdata.field_78845_b = this.field_74031_w.field_78845_b;
                serverdata.func_82819_b(this.field_74031_w.func_82820_d());
                this.field_74030_m.func_78855_b();
            }

            this.field_73882_e.func_71373_a(this);
        }
    }

    protected void func_73869_a(char p_73869_1_, int p_73869_2_)
    {
        int j = this.field_74028_n;

        if (p_73869_2_ == 59)
        {
            this.field_73882_e.field_71474_y.field_80005_w = !this.field_73882_e.field_71474_y.field_80005_w;
            this.field_73882_e.field_71474_y.func_74303_b();
        }
        else
        {
            if (func_73877_p() && p_73869_2_ == 200)
            {
                if (j > 0 && j < this.field_74030_m.func_78856_c())
                {
                    this.field_74030_m.func_78857_a(j, j - 1);
                    --this.field_74028_n;

                    if (j < this.field_74030_m.func_78856_c() - 1)
                    {
                        this.field_74022_d.func_77208_b(-this.field_74022_d.field_77229_d);
                    }
                }
            }
            else if (func_73877_p() && p_73869_2_ == 208)
            {
                if (j >= 0 & j < this.field_74030_m.func_78856_c() - 1)
                {
                    this.field_74030_m.func_78857_a(j, j + 1);
                    ++this.field_74028_n;

                    if (j > 0)
                    {
                        this.field_74022_d.func_77208_b(this.field_74022_d.field_77229_d);
                    }
                }
            }
            else if (p_73869_2_ != 28 && p_73869_2_ != 156)
            {
                super.func_73869_a(p_73869_1_, p_73869_2_);
            }
            else
            {
                this.func_73875_a((GuiButton)this.field_73887_h.get(2));
            }
        }
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        this.field_74032_v = null;
        this.func_73873_v_();
        this.field_74022_d.func_77211_a(p_73863_1_, p_73863_2_, p_73863_3_);
        this.func_73732_a(this.field_73886_k, I18n.func_135053_a("multiplayer.title"), this.field_73880_f / 2, 20, 16777215);
        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);

        if (this.field_74032_v != null)
        {
            this.func_74007_a(this.field_74032_v, p_73863_1_, p_73863_2_);
        }
    }

    private void func_74004_a(int p_74004_1_)
    {
        if (p_74004_1_ < this.field_74030_m.func_78856_c())
        {
            this.func_74002_a(this.field_74030_m.func_78850_a(p_74004_1_));
        }
        else
        {
            p_74004_1_ -= this.field_74030_m.func_78856_c();

            if (p_74004_1_ < this.field_74026_B.size())
            {
                LanServer lanserver = (LanServer)this.field_74026_B.get(p_74004_1_);
                this.func_74002_a(new ServerData(lanserver.func_77487_a(), lanserver.func_77488_b()));
            }
        }
    }

    private void func_74002_a(ServerData p_74002_1_)
    {
        this.field_73882_e.func_71373_a(new GuiConnecting(this, this.field_73882_e, p_74002_1_));
    }

    private static void func_74017_b(ServerData p_74017_0_) throws IOException
    {
        ServerAddress serveraddress = ServerAddress.func_78860_a(p_74017_0_.field_78845_b);
        Socket socket = null;
        DataInputStream datainputstream = null;
        DataOutputStream dataoutputstream = null;

        try
        {
            socket = new Socket();
            socket.setSoTimeout(3000);
            socket.setTcpNoDelay(true);
            socket.setTrafficClass(18);
            socket.connect(new InetSocketAddress(serveraddress.func_78861_a(), serveraddress.func_78864_b()), 3000);
            datainputstream = new DataInputStream(socket.getInputStream());
            dataoutputstream = new DataOutputStream(socket.getOutputStream());
            Packet254ServerPing packet254serverping = new Packet254ServerPing(78, serveraddress.func_78861_a(), serveraddress.func_78864_b());
            dataoutputstream.writeByte(packet254serverping.func_73281_k());
            packet254serverping.func_73273_a(dataoutputstream);

            if (datainputstream.read() != 255)
            {
                throw new IOException("Bad message");
            }

            String s = Packet.func_73282_a(datainputstream, 256);
            char[] achar = s.toCharArray();

            for (int i = 0; i < achar.length; ++i)
            {
                if (achar[i] != 167 && achar[i] != 0 && ChatAllowedCharacters.field_71568_a.indexOf(achar[i]) < 0)
                {
                    achar[i] = 63;
                }
            }

            s = new String(achar);
            int j;
            int k;
            String[] astring;

            if (s.startsWith("\u00a7") && s.length() > 1)
            {
                astring = s.substring(1).split("\u0000");

                if (MathHelper.func_82715_a(astring[0], 0) == 1)
                {
                    p_74017_0_.field_78843_d = astring[3];
                    p_74017_0_.field_82821_f = MathHelper.func_82715_a(astring[1], p_74017_0_.field_82821_f);
                    p_74017_0_.field_82822_g = astring[2];
                    j = MathHelper.func_82715_a(astring[4], 0);
                    k = MathHelper.func_82715_a(astring[5], 0);

                    if (j >= 0 && k >= 0)
                    {
                        p_74017_0_.field_78846_c = EnumChatFormatting.GRAY + "" + j + "" + EnumChatFormatting.DARK_GRAY + "/" + EnumChatFormatting.GRAY + k;
                    }
                    else
                    {
                        p_74017_0_.field_78846_c = "" + EnumChatFormatting.DARK_GRAY + "???";
                    }
                }
                else
                {
                    p_74017_0_.field_82822_g = "???";
                    p_74017_0_.field_78843_d = "" + EnumChatFormatting.DARK_GRAY + "???";
                    p_74017_0_.field_82821_f = 79;
                    p_74017_0_.field_78846_c = "" + EnumChatFormatting.DARK_GRAY + "???";
                }
            }
            else
            {
                astring = s.split("\u00a7");
                s = astring[0];
                j = -1;
                k = -1;

                try
                {
                    j = Integer.parseInt(astring[1]);
                    k = Integer.parseInt(astring[2]);
                }
                catch (Exception exception)
                {
                    ;
                }

                p_74017_0_.field_78843_d = EnumChatFormatting.GRAY + s;

                if (j >= 0 && k > 0)
                {
                    p_74017_0_.field_78846_c = EnumChatFormatting.GRAY + "" + j + "" + EnumChatFormatting.DARK_GRAY + "/" + EnumChatFormatting.GRAY + k;
                }
                else
                {
                    p_74017_0_.field_78846_c = "" + EnumChatFormatting.DARK_GRAY + "???";
                }

                p_74017_0_.field_82822_g = "1.3";
                p_74017_0_.field_82821_f = 77;
            }
        }
        finally
        {
            try
            {
                if (datainputstream != null)
                {
                    datainputstream.close();
                }
            }
            catch (Throwable throwable)
            {
                ;
            }

            try
            {
                if (dataoutputstream != null)
                {
                    dataoutputstream.close();
                }
            }
            catch (Throwable throwable1)
            {
                ;
            }

            try
            {
                if (socket != null)
                {
                    socket.close();
                }
            }
            catch (Throwable throwable2)
            {
                ;
            }
        }
    }

    protected void func_74007_a(String p_74007_1_, int p_74007_2_, int p_74007_3_)
    {
        if (p_74007_1_ != null)
        {
            int k = p_74007_2_ + 12;
            int l = p_74007_3_ - 12;
            int i1 = this.field_73886_k.func_78256_a(p_74007_1_);
            this.func_73733_a(k - 3, l - 3, k + i1 + 3, l + 8 + 3, -1073741824, -1073741824);
            this.field_73886_k.func_78261_a(p_74007_1_, k, l, -1);
        }
    }

    static ServerList func_74006_a(GuiMultiplayer p_74006_0_)
    {
        return p_74006_0_.field_74030_m;
    }

    static List func_74003_b(GuiMultiplayer p_74003_0_)
    {
        return p_74003_0_.field_74026_B;
    }

    static int func_74020_c(GuiMultiplayer p_74020_0_)
    {
        return p_74020_0_.field_74028_n;
    }

    static int func_74015_a(GuiMultiplayer p_74015_0_, int p_74015_1_)
    {
        return p_74015_0_.field_74028_n = p_74015_1_;
    }

    static GuiButton func_74014_d(GuiMultiplayer p_74014_0_)
    {
        return p_74014_0_.field_74038_p;
    }

    static GuiButton func_74005_e(GuiMultiplayer p_74005_0_)
    {
        return p_74005_0_.field_96289_p;
    }

    static GuiButton func_74019_f(GuiMultiplayer p_74019_0_)
    {
        return p_74019_0_.field_74037_q;
    }

    static void func_74008_b(GuiMultiplayer p_74008_0_, int p_74008_1_)
    {
        p_74008_0_.func_74004_a(p_74008_1_);
    }

    static int func_74010_g(GuiMultiplayer p_74010_0_)
    {
        return p_74010_0_.field_74039_z;
    }

    static Object func_74011_h()
    {
        return field_74023_b;
    }

    static int func_74012_i()
    {
        return field_74027_a;
    }

    static int func_74021_j()
    {
        return field_74027_a++;
    }

    static void func_82291_a(ServerData p_82291_0_) throws IOException
    {
        func_74017_b(p_82291_0_);
    }

    static int func_74018_k()
    {
        return field_74027_a--;
    }

    static String func_74009_a(GuiMultiplayer p_74009_0_, String p_74009_1_)
    {
        return p_74009_0_.field_74032_v = p_74009_1_;
    }
}
