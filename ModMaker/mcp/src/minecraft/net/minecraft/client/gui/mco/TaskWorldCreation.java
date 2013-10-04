package net.minecraft.client.gui.mco;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import net.minecraft.client.gui.TaskLongRunning;
import net.minecraft.client.mco.ExceptionMcoService;
import net.minecraft.client.mco.McoClient;
import net.minecraft.client.mco.WorldTemplate;
import net.minecraft.client.resources.I18n;

@SideOnly(Side.CLIENT)
class TaskWorldCreation extends TaskLongRunning
{
    private final String field_96589_c;
    private final String field_96587_d;
    private final String field_104065_f;
    private final WorldTemplate field_111253_f;

    final GuiScreenCreateOnlineWorld field_96590_a;

    public TaskWorldCreation(GuiScreenCreateOnlineWorld p_i1106_1_, String p_i1106_2_, String p_i1106_3_, String p_i1106_4_, WorldTemplate p_i1106_5_)
    {
        this.field_96590_a = p_i1106_1_;
        this.field_96589_c = p_i1106_2_;
        this.field_96587_d = p_i1106_3_;
        this.field_104065_f = p_i1106_4_;
        this.field_111253_f = p_i1106_5_;
    }

    public void run()
    {
        String s = I18n.func_135053_a("mco.create.world.wait");
        this.func_96576_b(s);
        McoClient mcoclient = new McoClient(GuiScreenCreateOnlineWorld.func_96248_a(this.field_96590_a).func_110432_I());

        try
        {
            if (this.field_111253_f != null)
            {
                mcoclient.func_96386_a(this.field_96589_c, this.field_96587_d, this.field_104065_f, this.field_111253_f.field_110734_a);
            }
            else
            {
                mcoclient.func_96386_a(this.field_96589_c, this.field_96587_d, this.field_104065_f, "-1");
            }

            GuiScreenCreateOnlineWorld.func_96246_c(this.field_96590_a).func_71373_a(GuiScreenCreateOnlineWorld.func_96247_b(this.field_96590_a));
        }
        catch (ExceptionMcoService exceptionmcoservice)
        {
            GuiScreenCreateOnlineWorld.func_130026_d(this.field_96590_a).func_98033_al().func_98232_c(exceptionmcoservice.toString());
            this.func_96575_a(exceptionmcoservice.toString());
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            GuiScreenCreateOnlineWorld.func_130027_e(this.field_96590_a).func_98033_al().func_98236_b("Realms: " + unsupportedencodingexception.getLocalizedMessage());
            this.func_96575_a(unsupportedencodingexception.getLocalizedMessage());
        }
        catch (IOException ioexception)
        {
            GuiScreenCreateOnlineWorld.func_130028_f(this.field_96590_a).func_98033_al().func_98236_b("Realms: could not parse response");
            this.func_96575_a(ioexception.getLocalizedMessage());
        }
        catch (Exception exception)
        {
            this.func_96575_a(exception.getLocalizedMessage());
        }
    }
}
