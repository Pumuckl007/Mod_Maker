package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.mco.ExceptionMcoService;
import net.minecraft.client.mco.ExceptionRetryCall;
import net.minecraft.client.mco.McoClient;
import net.minecraft.client.mco.McoServer;
import net.minecraft.client.mco.McoServerAddress;
import net.minecraft.client.multiplayer.NetClientHandler;
import net.minecraft.client.multiplayer.ServerAddress;
import net.minecraft.client.resources.I18n;

@SideOnly(Side.CLIENT)
public class TaskOnlineConnect extends TaskLongRunning
{
    private NetClientHandler field_96586_a;
    private final McoServer field_96585_c;
    private final GuiScreen field_96584_d;

    public TaskOnlineConnect(GuiScreen p_i1119_1_, McoServer p_i1119_2_)
    {
        this.field_96584_d = p_i1119_1_;
        this.field_96585_c = p_i1119_2_;
    }

    public void run()
    {
        this.func_96576_b(I18n.func_135053_a("mco.connect.connecting"));
        McoClient mcoclient = new McoClient(this.func_96578_b().func_110432_I());
        boolean flag = false;
        boolean flag1 = false;
        int i = 5;
        McoServerAddress mcoserveraddress = null;

        for (int j = 0; j < 10 && !this.func_96577_c(); ++j)
        {
            try
            {
                mcoserveraddress = mcoclient.func_96374_a(this.field_96585_c.field_96408_a);
                flag = true;
            }
            catch (ExceptionRetryCall exceptionretrycall)
            {
                i = exceptionretrycall.field_96393_c;
            }
            catch (ExceptionMcoService exceptionmcoservice)
            {
                flag1 = true;
                this.func_96575_a(exceptionmcoservice.toString());
                Minecraft.func_71410_x().func_98033_al().func_98232_c(exceptionmcoservice.toString());
                break;
            }
            catch (IOException ioexception)
            {
                Minecraft.func_71410_x().func_98033_al().func_98236_b("Realms: could not parse response");
            }
            catch (Exception exception)
            {
                flag1 = true;
                this.func_96575_a(exception.getLocalizedMessage());
            }

            if (flag)
            {
                break;
            }

            this.func_111251_a(i);
        }

        if (!this.func_96577_c() && !flag1)
        {
            if (flag)
            {
                ServerAddress serveraddress = ServerAddress.func_78860_a(mcoserveraddress.field_96417_a);
                this.func_96582_a(serveraddress.func_78861_a(), serveraddress.func_78864_b());
            }
            else
            {
                this.func_96578_b().func_71373_a(this.field_96584_d);
            }
        }
    }

    private void func_111251_a(int p_111251_1_)
    {
        try
        {
            Thread.sleep((long)(p_111251_1_ * 1000));
        }
        catch (InterruptedException interruptedexception)
        {
            Minecraft.func_71410_x().func_98033_al().func_98236_b(interruptedexception.getLocalizedMessage());
        }
    }

    private void func_96582_a(String p_96582_1_, int p_96582_2_)
    {
        (new ThreadOnlineConnect(this, p_96582_1_, p_96582_2_)).start();
    }

    public void func_96573_a()
    {
        if (this.field_96586_a != null)
        {
            this.field_96586_a.func_72551_d();
        }
    }

    static NetClientHandler func_96583_a(TaskOnlineConnect p_96583_0_, NetClientHandler p_96583_1_)
    {
        return p_96583_0_.field_96586_a = p_96583_1_;
    }

    static GuiScreen func_98172_a(TaskOnlineConnect p_98172_0_)
    {
        return p_98172_0_.field_96584_d;
    }

    static NetClientHandler func_96580_a(TaskOnlineConnect p_96580_0_)
    {
        return p_96580_0_.field_96586_a;
    }
}
