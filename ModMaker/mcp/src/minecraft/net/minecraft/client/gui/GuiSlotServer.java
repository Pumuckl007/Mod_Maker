package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.LanServer;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.EnumChatFormatting;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
class GuiSlotServer extends GuiSlot
{
    final GuiMultiplayer field_77250_a;

    public GuiSlotServer(GuiMultiplayer p_i1039_1_)
    {
        super(p_i1039_1_.field_73882_e, p_i1039_1_.field_73880_f, p_i1039_1_.field_73881_g, 32, p_i1039_1_.field_73881_g - 64, 36);
        this.field_77250_a = p_i1039_1_;
    }

    protected int func_77217_a()
    {
        return GuiMultiplayer.func_74006_a(this.field_77250_a).func_78856_c() + GuiMultiplayer.func_74003_b(this.field_77250_a).size() + 1;
    }

    protected void func_77213_a(int p_77213_1_, boolean p_77213_2_)
    {
        if (p_77213_1_ < GuiMultiplayer.func_74006_a(this.field_77250_a).func_78856_c() + GuiMultiplayer.func_74003_b(this.field_77250_a).size())
        {
            int j = GuiMultiplayer.func_74020_c(this.field_77250_a);
            GuiMultiplayer.func_74015_a(this.field_77250_a, p_77213_1_);
            ServerData serverdata = GuiMultiplayer.func_74006_a(this.field_77250_a).func_78856_c() > p_77213_1_ ? GuiMultiplayer.func_74006_a(this.field_77250_a).func_78850_a(p_77213_1_) : null;
            boolean flag1 = GuiMultiplayer.func_74020_c(this.field_77250_a) >= 0 && GuiMultiplayer.func_74020_c(this.field_77250_a) < this.func_77217_a() && (serverdata == null || serverdata.field_82821_f == 78);
            boolean flag2 = GuiMultiplayer.func_74020_c(this.field_77250_a) < GuiMultiplayer.func_74006_a(this.field_77250_a).func_78856_c();
            GuiMultiplayer.func_74014_d(this.field_77250_a).field_73742_g = flag1;
            GuiMultiplayer.func_74005_e(this.field_77250_a).field_73742_g = flag2;
            GuiMultiplayer.func_74019_f(this.field_77250_a).field_73742_g = flag2;

            if (p_77213_2_ && flag1)
            {
                GuiMultiplayer.func_74008_b(this.field_77250_a, p_77213_1_);
            }
            else if (flag2 && GuiScreen.func_73877_p() && j >= 0 && j < GuiMultiplayer.func_74006_a(this.field_77250_a).func_78856_c())
            {
                GuiMultiplayer.func_74006_a(this.field_77250_a).func_78857_a(j, GuiMultiplayer.func_74020_c(this.field_77250_a));
            }
        }
    }

    protected boolean func_77218_a(int p_77218_1_)
    {
        return p_77218_1_ == GuiMultiplayer.func_74020_c(this.field_77250_a);
    }

    protected int func_77212_b()
    {
        return this.func_77217_a() * 36;
    }

    protected void func_77221_c()
    {
        this.field_77250_a.func_73873_v_();
    }

    protected void func_77214_a(int p_77214_1_, int p_77214_2_, int p_77214_3_, int p_77214_4_, Tessellator p_77214_5_)
    {
        if (p_77214_1_ < GuiMultiplayer.func_74006_a(this.field_77250_a).func_78856_c())
        {
            this.func_77247_d(p_77214_1_, p_77214_2_, p_77214_3_, p_77214_4_, p_77214_5_);
        }
        else if (p_77214_1_ < GuiMultiplayer.func_74006_a(this.field_77250_a).func_78856_c() + GuiMultiplayer.func_74003_b(this.field_77250_a).size())
        {
            this.func_77248_b(p_77214_1_, p_77214_2_, p_77214_3_, p_77214_4_, p_77214_5_);
        }
        else
        {
            this.func_77249_c(p_77214_1_, p_77214_2_, p_77214_3_, p_77214_4_, p_77214_5_);
        }
    }

    private void func_77248_b(int p_77248_1_, int p_77248_2_, int p_77248_3_, int p_77248_4_, Tessellator p_77248_5_)
    {
        LanServer lanserver = (LanServer)GuiMultiplayer.func_74003_b(this.field_77250_a).get(p_77248_1_ - GuiMultiplayer.func_74006_a(this.field_77250_a).func_78856_c());
        this.field_77250_a.func_73731_b(this.field_77250_a.field_73886_k, I18n.func_135053_a("lanServer.title"), p_77248_2_ + 2, p_77248_3_ + 1, 16777215);
        this.field_77250_a.func_73731_b(this.field_77250_a.field_73886_k, lanserver.func_77487_a(), p_77248_2_ + 2, p_77248_3_ + 12, 8421504);

        if (this.field_77250_a.field_73882_e.field_71474_y.field_80005_w)
        {
            this.field_77250_a.func_73731_b(this.field_77250_a.field_73886_k, I18n.func_135053_a("selectServer.hiddenAddress"), p_77248_2_ + 2, p_77248_3_ + 12 + 11, 3158064);
        }
        else
        {
            this.field_77250_a.func_73731_b(this.field_77250_a.field_73886_k, lanserver.func_77488_b(), p_77248_2_ + 2, p_77248_3_ + 12 + 11, 3158064);
        }
    }

    private void func_77249_c(int p_77249_1_, int p_77249_2_, int p_77249_3_, int p_77249_4_, Tessellator p_77249_5_)
    {
        this.field_77250_a.func_73732_a(this.field_77250_a.field_73886_k, I18n.func_135053_a("lanServer.scanning"), this.field_77250_a.field_73880_f / 2, p_77249_3_ + 1, 16777215);
        String s;

        switch (GuiMultiplayer.func_74010_g(this.field_77250_a) / 3 % 4)
        {
            case 0:
            default:
                s = "O o o";
                break;
            case 1:
            case 3:
                s = "o O o";
                break;
            case 2:
                s = "o o O";
        }

        this.field_77250_a.func_73732_a(this.field_77250_a.field_73886_k, s, this.field_77250_a.field_73880_f / 2, p_77249_3_ + 12, 8421504);
    }

    private void func_77247_d(int p_77247_1_, int p_77247_2_, int p_77247_3_, int p_77247_4_, Tessellator p_77247_5_)
    {
        ServerData serverdata = GuiMultiplayer.func_74006_a(this.field_77250_a).func_78850_a(p_77247_1_);

        synchronized (GuiMultiplayer.func_74011_h())
        {
            if (GuiMultiplayer.func_74012_i() < 5 && !serverdata.field_78841_f)
            {
                serverdata.field_78841_f = true;
                serverdata.field_78844_e = -2L;
                serverdata.field_78843_d = "";
                serverdata.field_78846_c = "";
                GuiMultiplayer.func_74021_j();
                (new ThreadPollServers(this, serverdata)).start();
            }
        }

        boolean flag = serverdata.field_82821_f > 78;
        boolean flag1 = serverdata.field_82821_f < 78;
        boolean flag2 = flag || flag1;
        this.field_77250_a.func_73731_b(this.field_77250_a.field_73886_k, serverdata.field_78847_a, p_77247_2_ + 2, p_77247_3_ + 1, 16777215);
        this.field_77250_a.func_73731_b(this.field_77250_a.field_73886_k, serverdata.field_78843_d, p_77247_2_ + 2, p_77247_3_ + 12, 8421504);
        this.field_77250_a.func_73731_b(this.field_77250_a.field_73886_k, serverdata.field_78846_c, p_77247_2_ + 215 - this.field_77250_a.field_73886_k.func_78256_a(serverdata.field_78846_c), p_77247_3_ + 12, 8421504);

        if (flag2)
        {
            String s = EnumChatFormatting.DARK_RED + serverdata.field_82822_g;
            this.field_77250_a.func_73731_b(this.field_77250_a.field_73886_k, s, p_77247_2_ + 200 - this.field_77250_a.field_73886_k.func_78256_a(s), p_77247_3_ + 1, 8421504);
        }

        if (!this.field_77250_a.field_73882_e.field_71474_y.field_80005_w && !serverdata.func_82820_d())
        {
            this.field_77250_a.func_73731_b(this.field_77250_a.field_73886_k, serverdata.field_78845_b, p_77247_2_ + 2, p_77247_3_ + 12 + 11, 3158064);
        }
        else
        {
            this.field_77250_a.func_73731_b(this.field_77250_a.field_73886_k, I18n.func_135053_a("selectServer.hiddenAddress"), p_77247_2_ + 2, p_77247_3_ + 12 + 11, 3158064);
        }

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.field_77250_a.field_73882_e.func_110434_K().func_110577_a(Gui.field_110324_m);
        byte b0 = 0;
        boolean flag3 = false;
        String s1 = "";
        int i1;

        if (flag2)
        {
            s1 = flag ? "Client out of date!" : "Server out of date!";
            i1 = 5;
        }
        else if (serverdata.field_78841_f && serverdata.field_78844_e != -2L)
        {
            if (serverdata.field_78844_e < 0L)
            {
                i1 = 5;
            }
            else if (serverdata.field_78844_e < 150L)
            {
                i1 = 0;
            }
            else if (serverdata.field_78844_e < 300L)
            {
                i1 = 1;
            }
            else if (serverdata.field_78844_e < 600L)
            {
                i1 = 2;
            }
            else if (serverdata.field_78844_e < 1000L)
            {
                i1 = 3;
            }
            else
            {
                i1 = 4;
            }

            if (serverdata.field_78844_e < 0L)
            {
                s1 = "(no connection)";
            }
            else
            {
                s1 = serverdata.field_78844_e + "ms";
            }
        }
        else
        {
            b0 = 1;
            i1 = (int)(Minecraft.func_71386_F() / 100L + (long)(p_77247_1_ * 2) & 7L);

            if (i1 > 4)
            {
                i1 = 8 - i1;
            }

            s1 = "Polling..";
        }

        this.field_77250_a.func_73729_b(p_77247_2_ + 205, p_77247_3_, 0 + b0 * 10, 176 + i1 * 8, 10, 8);
        byte b1 = 4;

        if (this.field_77230_e >= p_77247_2_ + 205 - b1 && this.field_77227_f >= p_77247_3_ - b1 && this.field_77230_e <= p_77247_2_ + 205 + 10 + b1 && this.field_77227_f <= p_77247_3_ + 8 + b1)
        {
            GuiMultiplayer.func_74009_a(this.field_77250_a, s1);
        }
    }
}
