package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import net.minecraft.client.mco.ExceptionMcoService;
import net.minecraft.client.mco.ExceptionRetryCall;
import net.minecraft.client.mco.McoClient;

@SideOnly(Side.CLIENT)
class RunnableTitleScreen extends Thread
{
    final GuiMainMenu field_104058_d;

    RunnableTitleScreen(GuiMainMenu p_i1331_1_)
    {
        this.field_104058_d = p_i1331_1_;
    }

    public void run()
    {
        McoClient mcoclient = new McoClient(GuiMainMenu.func_110348_a(this.field_104058_d).func_110432_I());
        boolean flag = false;

        for (int i = 0; i < 3; ++i)
        {
            try
            {
                Boolean obool = mcoclient.func_96375_b();

                if (obool.booleanValue())
                {
                    GuiMainMenu.func_130021_b(this.field_104058_d);
                }

                GuiMainMenu.func_110349_a(obool.booleanValue());
            }
            catch (ExceptionRetryCall exceptionretrycall)
            {
                flag = true;
            }
            catch (ExceptionMcoService exceptionmcoservice)
            {
                GuiMainMenu.func_130018_c(this.field_104058_d).func_98033_al().func_98232_c(exceptionmcoservice.toString());
            }
            catch (IOException ioexception)
            {
                GuiMainMenu.func_130019_d(this.field_104058_d).func_98033_al().func_98236_b("Realms: could not parse response");
            }

            if (!flag)
            {
                break;
            }

            try
            {
                Thread.sleep(10000L);
            }
            catch (InterruptedException interruptedexception)
            {
                Thread.currentThread().interrupt();
            }
        }
    }
}
