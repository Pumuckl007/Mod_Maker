package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import net.minecraft.client.mco.ExceptionMcoService;
import net.minecraft.client.mco.McoClient;
import net.minecraft.client.mco.McoServer;
import net.minecraft.client.resources.I18n;
import org.lwjgl.input.Keyboard;

@SideOnly(Side.CLIENT)
public class GuiScreenInvite extends GuiScreen
{
    private GuiTextField field_96227_a;
    private McoServer field_96223_b;
    private final GuiScreen field_96224_c;
    private final GuiScreenConfigureWorld field_96222_d;
    private final int field_96228_n = 0;
    private final int field_96229_o = 1;
    private String field_101016_p = "Could not invite the provided name";
    private String field_96226_p;
    private boolean field_96225_q;

    public GuiScreenInvite(GuiScreen p_i1110_1_, GuiScreenConfigureWorld p_i1110_2_, McoServer p_i1110_3_)
    {
        this.field_96224_c = p_i1110_1_;
        this.field_96222_d = p_i1110_2_;
        this.field_96223_b = p_i1110_3_;
    }

    public void func_73876_c()
    {
        this.field_96227_a.func_73780_a();
    }

    public void func_73866_w_()
    {
        Keyboard.enableRepeatEvents(true);
        this.field_73887_h.clear();
        this.field_73887_h.add(new GuiButton(0, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 96 + 12, I18n.func_135053_a("mco.configure.world.buttons.invite")));
        this.field_73887_h.add(new GuiButton(1, this.field_73880_f / 2 - 100, this.field_73881_g / 4 + 120 + 12, I18n.func_135053_a("gui.cancel")));
        this.field_96227_a = new GuiTextField(this.field_73886_k, this.field_73880_f / 2 - 100, 66, 200, 20);
        this.field_96227_a.func_73796_b(true);
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
                this.field_73882_e.func_71373_a(this.field_96222_d);
            }
            else if (p_73875_1_.field_73741_f == 0)
            {
                McoClient mcoclient = new McoClient(this.field_73882_e.func_110432_I());

                if (this.field_96227_a.func_73781_b() == null || this.field_96227_a.func_73781_b().isEmpty())
                {
                    return;
                }

                try
                {
                    McoServer mcoserver = mcoclient.func_96387_b(this.field_96223_b.field_96408_a, this.field_96227_a.func_73781_b());

                    if (mcoserver != null)
                    {
                        this.field_96223_b.field_96402_f = mcoserver.field_96402_f;
                        this.field_73882_e.func_71373_a(new GuiScreenConfigureWorld(this.field_96224_c, this.field_96223_b));
                    }
                    else
                    {
                        this.func_101015_a(this.field_101016_p);
                    }
                }
                catch (ExceptionMcoService exceptionmcoservice)
                {
                    this.field_73882_e.func_98033_al().func_98232_c(exceptionmcoservice.toString());
                    this.func_101015_a(exceptionmcoservice.field_96391_b);
                }
                catch (IOException ioexception)
                {
                    this.field_73882_e.func_98033_al().func_98236_b("Realms: could not parse response");
                    this.func_101015_a(this.field_101016_p);
                }
            }
        }
    }

    private void func_101015_a(String p_101015_1_)
    {
        this.field_96225_q = true;
        this.field_96226_p = p_101015_1_;
    }

    protected void func_73869_a(char p_73869_1_, int p_73869_2_)
    {
        this.field_96227_a.func_73802_a(p_73869_1_, p_73869_2_);

        if (p_73869_2_ == 15)
        {
            if (this.field_96227_a.func_73806_l())
            {
                this.field_96227_a.func_73796_b(false);
            }
            else
            {
                this.field_96227_a.func_73796_b(true);
            }
        }

        if (p_73869_2_ == 28 || p_73869_2_ == 156)
        {
            this.func_73875_a((GuiButton)this.field_73887_h.get(0));
        }
    }

    protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_)
    {
        super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
        this.field_96227_a.func_73793_a(p_73864_1_, p_73864_2_, p_73864_3_);
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        this.func_73873_v_();
        this.func_73731_b(this.field_73886_k, I18n.func_135053_a("mco.configure.world.invite.profile.name"), this.field_73880_f / 2 - 100, 53, 10526880);

        if (this.field_96225_q)
        {
            this.func_73732_a(this.field_73886_k, this.field_96226_p, this.field_73880_f / 2, 100, 16711680);
        }

        this.field_96227_a.func_73795_f();
        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
    }
}
