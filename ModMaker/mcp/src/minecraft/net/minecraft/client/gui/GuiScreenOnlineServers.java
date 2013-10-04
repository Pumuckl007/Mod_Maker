package net.minecraft.client.gui;

import com.google.common.collect.Lists;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.mco.GuiScreenCreateOnlineWorld;
import net.minecraft.client.gui.mco.GuiScreenPendingInvitation;
import net.minecraft.client.mco.ExceptionMcoService;
import net.minecraft.client.mco.GuiScreenConfirmationType;
import net.minecraft.client.mco.McoClient;
import net.minecraft.client.mco.McoServer;
import net.minecraft.client.mco.McoServerList;
import net.minecraft.client.multiplayer.ServerAddress;
import net.minecraft.client.resources.I18n;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiScreenOnlineServers extends GuiScreen
{
    private static final ResourceLocation field_130039_a = new ResourceLocation("textures/gui/widgets.png");
    private GuiScreen field_96188_a;
    private GuiSlotOnlineServerList field_96186_b;
    private static int field_96187_c;
    private static final Object field_96185_d = new Object();
    private long field_96189_n = -1L;
    private GuiButton field_96190_o;
    private GuiButton field_96198_p;
    private GuiButtonLink field_96197_q;
    private GuiButton field_96196_r;
    private String field_96195_s;
    private static McoServerList field_96194_t = new McoServerList();
    private boolean field_96193_u;
    private List field_96192_v = Lists.newArrayList();
    private volatile int field_96199_x = 0;
    private Long field_102019_y;
    private int field_104044_y;

    public GuiScreenOnlineServers(GuiScreen p_i1123_1_)
    {
        this.field_96188_a = p_i1123_1_;
    }

    public void func_73866_w_()
    {
        Keyboard.enableRepeatEvents(true);
        this.field_73887_h.clear();
        field_96194_t.func_130129_a(this.field_73882_e.func_110432_I());

        if (!this.field_96193_u)
        {
            this.field_96193_u = true;
            this.field_96186_b = new GuiSlotOnlineServerList(this);
        }
        else
        {
            this.field_96186_b.func_104084_a(this.field_73880_f, this.field_73881_g, 32, this.field_73881_g - 64);
        }

        this.func_96178_g();
    }

    public void func_96178_g()
    {
        this.field_73887_h.add(this.field_96196_r = new GuiButton(1, this.field_73880_f / 2 - 154, this.field_73881_g - 52, 100, 20, I18n.func_135053_a("mco.selectServer.play")));
        this.field_73887_h.add(this.field_96198_p = new GuiButton(2, this.field_73880_f / 2 - 48, this.field_73881_g - 52, 100, 20, I18n.func_135053_a("mco.selectServer.create")));
        this.field_73887_h.add(this.field_96190_o = new GuiButton(3, this.field_73880_f / 2 + 58, this.field_73881_g - 52, 100, 20, I18n.func_135053_a("mco.selectServer.configure")));
        this.field_73887_h.add(this.field_96197_q = new GuiButtonLink(4, this.field_73880_f / 2 - 154, this.field_73881_g - 28, 154, 20, I18n.func_135053_a("mco.selectServer.moreinfo")));
        this.field_73887_h.add(new GuiButton(0, this.field_73880_f / 2 + 6, this.field_73881_g - 28, 153, 20, I18n.func_135053_a("gui.cancel")));
        McoServer mcoserver = this.func_140030_b(this.field_96189_n);
        this.field_96196_r.field_73742_g = mcoserver != null && mcoserver.field_96404_d.equals("OPEN") && !mcoserver.field_98166_h;
        this.field_96198_p.field_73742_g = this.field_96199_x > 0;

        if (mcoserver != null && !mcoserver.field_96405_e.equals(this.field_73882_e.func_110432_I().func_111285_a()))
        {
            this.field_96190_o.field_73744_e = I18n.func_135053_a("mco.selectServer.leave");
        }
    }

    public void func_73876_c()
    {
        super.func_73876_c();
        ++this.field_104044_y;

        if (field_96194_t.func_130127_a())
        {
            List list = field_96194_t.func_98252_c();
            Iterator iterator = list.iterator();

            while (iterator.hasNext())
            {
                McoServer mcoserver = (McoServer)iterator.next();
                Iterator iterator1 = this.field_96192_v.iterator();

                while (iterator1.hasNext())
                {
                    McoServer mcoserver1 = (McoServer)iterator1.next();

                    if (mcoserver.field_96408_a == mcoserver1.field_96408_a)
                    {
                        mcoserver.func_96401_a(mcoserver1);

                        if (this.field_102019_y != null && this.field_102019_y.longValue() == mcoserver.field_96408_a)
                        {
                            this.field_102019_y = null;
                            mcoserver.field_96411_l = false;
                        }

                        break;
                    }
                }
            }

            this.field_96199_x = field_96194_t.func_140056_e();
            this.field_96192_v = list;
            field_96194_t.func_98250_b();
        }

        this.field_96198_p.field_73742_g = this.field_96199_x > 0;
    }

    public void func_73874_b()
    {
        Keyboard.enableRepeatEvents(false);
    }

    protected void func_73875_a(GuiButton p_73875_1_)
    {
        if (p_73875_1_.field_73742_g)
        {
            if (p_73875_1_.field_73741_f == 1)
            {
                this.func_140032_e(this.field_96189_n);
            }
            else if (p_73875_1_.field_73741_f == 3)
            {
                this.func_140019_s();
            }
            else if (p_73875_1_.field_73741_f == 0)
            {
                field_96194_t.func_98248_d();
                this.field_73882_e.func_71373_a(this.field_96188_a);
            }
            else if (p_73875_1_.field_73741_f == 2)
            {
                field_96194_t.func_98248_d();
                this.field_73882_e.func_71373_a(new GuiScreenCreateOnlineWorld(this));
            }
            else if (p_73875_1_.field_73741_f == 4)
            {
                this.field_96197_q.func_96135_a("http://realms.minecraft.net/");
            }
            else
            {
                this.field_96186_b.func_73875_a(p_73875_1_);
            }
        }
    }

    private void func_140019_s()
    {
        McoServer mcoserver = this.func_140030_b(this.field_96189_n);

        if (mcoserver != null)
        {
            if (this.field_73882_e.func_110432_I().func_111285_a().equals(mcoserver.field_96405_e))
            {
                McoServer mcoserver1 = this.func_98086_a(mcoserver.field_96408_a);

                if (mcoserver1 != null)
                {
                    field_96194_t.func_98248_d();
                    this.field_73882_e.func_71373_a(new GuiScreenConfigureWorld(this, mcoserver1));
                }
            }
            else
            {
                String s = I18n.func_135053_a("mco.configure.world.leave.question.line1");
                String s1 = I18n.func_135053_a("mco.configure.world.leave.question.line2");
                this.field_73882_e.func_71373_a(new GuiScreenConfirmation(this, GuiScreenConfirmationType.Info, s, s1, 3));
            }
        }
    }

    private McoServer func_140030_b(long p_140030_1_)
    {
        Iterator iterator = this.field_96192_v.iterator();
        McoServer mcoserver;

        do
        {
            if (!iterator.hasNext())
            {
                return null;
            }

            mcoserver = (McoServer)iterator.next();
        }
        while (mcoserver.field_96408_a != p_140030_1_);

        return mcoserver;
    }

    private int func_140009_c(long p_140009_1_)
    {
        for (int j = 0; j < this.field_96192_v.size(); ++j)
        {
            if (((McoServer)this.field_96192_v.get(j)).field_96408_a == p_140009_1_)
            {
                return j;
            }
        }

        return -1;
    }

    public void func_73878_a(boolean p_73878_1_, int p_73878_2_)
    {
        if (p_73878_2_ == 3 && p_73878_1_)
        {
            (new ThreadOnlineScreen(this)).start();
        }

        this.field_73882_e.func_71373_a(this);
    }

    private void func_140012_t()
    {
        int i = this.func_140009_c(this.field_96189_n);

        if (this.field_96192_v.size() - 1 == i)
        {
            --i;
        }

        if (this.field_96192_v.size() == 0)
        {
            i = -1;
        }

        if (i >= 0 && i < this.field_96192_v.size())
        {
            this.field_96189_n = ((McoServer)this.field_96192_v.get(i)).field_96408_a;
        }
    }

    public void func_102018_a(long p_102018_1_)
    {
        this.field_96189_n = -1L;
        this.field_102019_y = Long.valueOf(p_102018_1_);
    }

    private McoServer func_98086_a(long p_98086_1_)
    {
        McoClient mcoclient = new McoClient(this.field_73882_e.func_110432_I());

        try
        {
            return mcoclient.func_98176_a(p_98086_1_);
        }
        catch (ExceptionMcoService exceptionmcoservice)
        {
            this.field_73882_e.func_98033_al().func_98232_c(exceptionmcoservice.toString());
        }
        catch (IOException ioexception)
        {
            this.field_73882_e.func_98033_al().func_98236_b("Realms: could not parse response");
        }

        return null;
    }

    protected void func_73869_a(char p_73869_1_, int p_73869_2_)
    {
        if (p_73869_2_ == 59)
        {
            this.field_73882_e.field_71474_y.field_80005_w = !this.field_73882_e.field_71474_y.field_80005_w;
            this.field_73882_e.field_71474_y.func_74303_b();
        }
        else
        {
            if (p_73869_2_ != 28 && p_73869_2_ != 156)
            {
                super.func_73869_a(p_73869_1_, p_73869_2_);
            }
            else
            {
                this.func_73875_a((GuiButton)this.field_73887_h.get(0));
            }
        }
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        this.field_96195_s = null;
        this.func_73873_v_();
        this.field_96186_b.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
        this.func_73732_a(this.field_73886_k, I18n.func_135053_a("mco.title"), this.field_73880_f / 2, 20, 16777215);
        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);

        if (this.field_96195_s != null)
        {
            this.func_96165_a(this.field_96195_s, p_73863_1_, p_73863_2_);
        }

        this.func_130038_b(p_73863_1_, p_73863_2_);
    }

    protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_)
    {
        super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);

        if (this.func_130037_c(p_73864_1_, p_73864_2_) && field_96194_t.func_130124_d() != 0)
        {
            GuiScreenPendingInvitation guiscreenpendinginvitation = new GuiScreenPendingInvitation(this);
            this.field_73882_e.func_71373_a(guiscreenpendinginvitation);
        }
    }

    private void func_130038_b(int p_130038_1_, int p_130038_2_)
    {
        int k = field_96194_t.func_130124_d();
        boolean flag = this.func_130037_c(p_130038_1_, p_130038_2_);
        this.field_73882_e.func_110434_K().func_110577_a(field_130039_a);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glPushMatrix();
        this.func_73729_b(this.field_73880_f / 2 + 58, 15, flag ? 166 : 182, 22, 16, 16);
        GL11.glPopMatrix();
        int l;
        int i1;

        if (k != 0)
        {
            l = 198 + (Math.min(k, 6) - 1) * 8;
            i1 = (int)(Math.max(0.0F, Math.max(MathHelper.func_76126_a((float)(10 + this.field_104044_y) * 0.57F), MathHelper.func_76134_b((float)this.field_104044_y * 0.35F))) * -6.0F);
            this.field_73882_e.func_110434_K().func_110577_a(field_130039_a);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glPushMatrix();
            this.func_73729_b(this.field_73880_f / 2 + 58 + 4, 19 + i1, l, 22, 8, 8);
            GL11.glPopMatrix();
        }

        if (flag && k != 0)
        {
            l = p_130038_1_ + 12;
            i1 = p_130038_2_ - 12;
            String s = I18n.func_135053_a("mco.invites.pending");
            int j1 = this.field_73886_k.func_78256_a(s);
            this.func_73733_a(l - 3, i1 - 3, l + j1 + 3, i1 + 8 + 3, -1073741824, -1073741824);
            this.field_73886_k.func_78261_a(s, l, i1, -1);
        }
    }

    private boolean func_130037_c(int p_130037_1_, int p_130037_2_)
    {
        int k = this.field_73880_f / 2 + 56;
        int l = this.field_73880_f / 2 + 78;
        byte b0 = 13;
        byte b1 = 27;
        return k <= p_130037_1_ && p_130037_1_ <= l && b0 <= p_130037_2_ && p_130037_2_ <= b1;
    }

    private void func_140032_e(long p_140032_1_)
    {
        McoServer mcoserver = this.func_140030_b(p_140032_1_);

        if (mcoserver != null)
        {
            field_96194_t.func_98248_d();
            GuiScreenLongRunningTask guiscreenlongrunningtask = new GuiScreenLongRunningTask(this.field_73882_e, this, new TaskOnlineConnect(this, mcoserver));
            guiscreenlongrunningtask.func_98117_g();
            this.field_73882_e.func_71373_a(guiscreenlongrunningtask);
        }
    }

    private void func_101008_c(int p_101008_1_, int p_101008_2_, int p_101008_3_, int p_101008_4_)
    {
        this.field_73882_e.func_110434_K().func_110577_a(field_130039_a);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glPushMatrix();
        GL11.glScalef(0.5F, 0.5F, 0.5F);
        this.func_73729_b(p_101008_1_ * 2, p_101008_2_ * 2, 191, 0, 16, 15);
        GL11.glPopMatrix();

        if (p_101008_3_ >= p_101008_1_ && p_101008_3_ <= p_101008_1_ + 9 && p_101008_4_ >= p_101008_2_ && p_101008_4_ <= p_101008_2_ + 9)
        {
            this.field_96195_s = I18n.func_135053_a("mco.selectServer.expired");
        }
    }

    private void func_104039_b(int p_104039_1_, int p_104039_2_, int p_104039_3_, int p_104039_4_, int p_104039_5_)
    {
        if (this.field_104044_y % 20 < 10)
        {
            this.field_73882_e.func_110434_K().func_110577_a(field_130039_a);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glPushMatrix();
            GL11.glScalef(0.5F, 0.5F, 0.5F);
            this.func_73729_b(p_104039_1_ * 2, p_104039_2_ * 2, 207, 0, 16, 15);
            GL11.glPopMatrix();
        }

        if (p_104039_3_ >= p_104039_1_ && p_104039_3_ <= p_104039_1_ + 9 && p_104039_4_ >= p_104039_2_ && p_104039_4_ <= p_104039_2_ + 9)
        {
            if (p_104039_5_ == 0)
            {
                this.field_96195_s = I18n.func_135053_a("mco.selectServer.expires.soon");
            }
            else if (p_104039_5_ == 1)
            {
                this.field_96195_s = I18n.func_135053_a("mco.selectServer.expires.day");
            }
            else
            {
                this.field_96195_s = I18n.func_135052_a("mco.selectServer.expires.days", new Object[] {Integer.valueOf(p_104039_5_)});
            }
        }
    }

    private void func_101006_d(int p_101006_1_, int p_101006_2_, int p_101006_3_, int p_101006_4_)
    {
        this.field_73882_e.func_110434_K().func_110577_a(field_130039_a);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glPushMatrix();
        GL11.glScalef(0.5F, 0.5F, 0.5F);
        this.func_73729_b(p_101006_1_ * 2, p_101006_2_ * 2, 207, 0, 16, 15);
        GL11.glPopMatrix();

        if (p_101006_3_ >= p_101006_1_ && p_101006_3_ <= p_101006_1_ + 9 && p_101006_4_ >= p_101006_2_ && p_101006_4_ <= p_101006_2_ + 9)
        {
            this.field_96195_s = I18n.func_135053_a("mco.selectServer.open");
        }
    }

    private void func_101001_e(int p_101001_1_, int p_101001_2_, int p_101001_3_, int p_101001_4_)
    {
        this.field_73882_e.func_110434_K().func_110577_a(field_130039_a);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glPushMatrix();
        GL11.glScalef(0.5F, 0.5F, 0.5F);
        this.func_73729_b(p_101001_1_ * 2, p_101001_2_ * 2, 223, 0, 16, 15);
        GL11.glPopMatrix();

        if (p_101001_3_ >= p_101001_1_ && p_101001_3_ <= p_101001_1_ + 9 && p_101001_4_ >= p_101001_2_ && p_101001_4_ <= p_101001_2_ + 9)
        {
            this.field_96195_s = I18n.func_135053_a("mco.selectServer.closed");
        }
    }

    protected void func_96165_a(String p_96165_1_, int p_96165_2_, int p_96165_3_)
    {
        if (p_96165_1_ != null)
        {
            int k = p_96165_2_ + 12;
            int l = p_96165_3_ - 12;
            int i1 = this.field_73886_k.func_78256_a(p_96165_1_);
            this.func_73733_a(k - 3, l - 3, k + i1 + 3, l + 8 + 3, -1073741824, -1073741824);
            this.field_73886_k.func_78261_a(p_96165_1_, k, l, -1);
        }
    }

    private void func_96174_a(McoServer p_96174_1_) throws IOException
    {
        if (p_96174_1_.field_96414_k.equals(""))
        {
            p_96174_1_.field_96414_k = EnumChatFormatting.GRAY + "" + 0;
        }

        p_96174_1_.field_96415_h = 78;
        ServerAddress serveraddress = ServerAddress.func_78860_a(p_96174_1_.field_96403_g);
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
            dataoutputstream.write(254);
            dataoutputstream.write(1);

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
                    p_96174_1_.field_96415_h = MathHelper.func_82715_a(astring[1], p_96174_1_.field_96415_h);
                    j = MathHelper.func_82715_a(astring[4], 0);
                    k = MathHelper.func_82715_a(astring[5], 0);

                    if (j >= 0 && k >= 0)
                    {
                        p_96174_1_.field_96414_k = EnumChatFormatting.GRAY + "" + j;
                    }
                    else
                    {
                        p_96174_1_.field_96414_k = "" + EnumChatFormatting.DARK_GRAY + "???";
                    }
                }
                else
                {
                    p_96174_1_.field_96415_h = 79;
                    p_96174_1_.field_96414_k = "" + EnumChatFormatting.DARK_GRAY + "???";
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

                p_96174_1_.field_96407_c = EnumChatFormatting.GRAY + s;

                if (j >= 0 && k > 0)
                {
                    p_96174_1_.field_96414_k = EnumChatFormatting.GRAY + "" + j;
                }
                else
                {
                    p_96174_1_.field_96414_k = "" + EnumChatFormatting.DARK_GRAY + "???";
                }

                p_96174_1_.field_96415_h = 77;
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

    static long func_140041_a(GuiScreenOnlineServers p_140041_0_)
    {
        return p_140041_0_.field_96189_n;
    }

    static McoServer func_140011_a(GuiScreenOnlineServers p_140011_0_, long p_140011_1_)
    {
        return p_140011_0_.func_140030_b(p_140011_1_);
    }

    static Minecraft func_98075_b(GuiScreenOnlineServers p_98075_0_)
    {
        return p_98075_0_.field_73882_e;
    }

    static McoServerList func_140040_h()
    {
        return field_96194_t;
    }

    static List func_140013_c(GuiScreenOnlineServers p_140013_0_)
    {
        return p_140013_0_.field_96192_v;
    }

    static void func_140017_d(GuiScreenOnlineServers p_140017_0_)
    {
        p_140017_0_.func_140012_t();
    }

    static Minecraft func_98076_f(GuiScreenOnlineServers p_98076_0_)
    {
        return p_98076_0_.field_73882_e;
    }

    static Minecraft func_140037_f(GuiScreenOnlineServers p_140037_0_)
    {
        return p_140037_0_.field_73882_e;
    }

    static long func_140036_b(GuiScreenOnlineServers p_140036_0_, long p_140036_1_)
    {
        return p_140036_0_.field_96189_n = p_140036_1_;
    }

    static Minecraft func_140015_g(GuiScreenOnlineServers p_140015_0_)
    {
        return p_140015_0_.field_73882_e;
    }

    static GuiButton func_140038_h(GuiScreenOnlineServers p_140038_0_)
    {
        return p_140038_0_.field_96190_o;
    }

    static GuiButton func_140033_i(GuiScreenOnlineServers p_140033_0_)
    {
        return p_140033_0_.field_96196_r;
    }

    static void func_140008_c(GuiScreenOnlineServers p_140008_0_, long p_140008_1_)
    {
        p_140008_0_.func_140032_e(p_140008_1_);
    }

    static int func_140027_d(GuiScreenOnlineServers p_140027_0_, long p_140027_1_)
    {
        return p_140027_0_.func_140009_c(p_140027_1_);
    }

    static Minecraft func_104032_j(GuiScreenOnlineServers p_104032_0_)
    {
        return p_104032_0_.field_73882_e;
    }

    static FontRenderer func_140023_k(GuiScreenOnlineServers p_140023_0_)
    {
        return p_140023_0_.field_73886_k;
    }

    static void func_104031_c(GuiScreenOnlineServers p_104031_0_, int p_104031_1_, int p_104031_2_, int p_104031_3_, int p_104031_4_)
    {
        p_104031_0_.func_101008_c(p_104031_1_, p_104031_2_, p_104031_3_, p_104031_4_);
    }

    static void func_140035_b(GuiScreenOnlineServers p_140035_0_, int p_140035_1_, int p_140035_2_, int p_140035_3_, int p_140035_4_)
    {
        p_140035_0_.func_101001_e(p_140035_1_, p_140035_2_, p_140035_3_, p_140035_4_);
    }

    static Minecraft func_140014_l(GuiScreenOnlineServers p_140014_0_)
    {
        return p_140014_0_.field_73882_e;
    }

    static void func_140031_a(GuiScreenOnlineServers p_140031_0_, int p_140031_1_, int p_140031_2_, int p_140031_3_, int p_140031_4_, int p_140031_5_)
    {
        p_140031_0_.func_104039_b(p_140031_1_, p_140031_2_, p_140031_3_, p_140031_4_, p_140031_5_);
    }

    static void func_140020_c(GuiScreenOnlineServers p_140020_0_, int p_140020_1_, int p_140020_2_, int p_140020_3_, int p_140020_4_)
    {
        p_140020_0_.func_101006_d(p_140020_1_, p_140020_2_, p_140020_3_, p_140020_4_);
    }

    static FontRenderer func_140039_m(GuiScreenOnlineServers p_140039_0_)
    {
        return p_140039_0_.field_73886_k;
    }

    static FontRenderer func_98079_k(GuiScreenOnlineServers p_98079_0_)
    {
        return p_98079_0_.field_73886_k;
    }

    static Object func_140029_i()
    {
        return field_96185_d;
    }

    static int func_140018_j()
    {
        return field_96187_c;
    }

    static int func_140016_k()
    {
        return field_96187_c++;
    }

    static void func_140024_a(GuiScreenOnlineServers p_140024_0_, McoServer p_140024_1_) throws IOException
    {
        p_140024_0_.func_96174_a(p_140024_1_);
    }

    static int func_140021_r()
    {
        return field_96187_c--;
    }

    static FontRenderer func_110402_q(GuiScreenOnlineServers p_110402_0_)
    {
        return p_110402_0_.field_73886_k;
    }

    static FontRenderer func_140010_p(GuiScreenOnlineServers p_140010_0_)
    {
        return p_140010_0_.field_73886_k;
    }

    static Minecraft func_142023_q(GuiScreenOnlineServers p_142023_0_)
    {
        return p_142023_0_.field_73882_e;
    }
}
