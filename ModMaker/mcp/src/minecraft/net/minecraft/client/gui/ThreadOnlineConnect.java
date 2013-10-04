package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.net.ConnectException;
import java.net.UnknownHostException;
import net.minecraft.client.multiplayer.NetClientHandler;
import net.minecraft.client.resources.I18n;
import net.minecraft.network.packet.Packet2ClientProtocol;

@SideOnly(Side.CLIENT)
class ThreadOnlineConnect extends Thread
{
    final String field_96595_a;

    final int field_96593_b;

    final TaskOnlineConnect field_96594_c;

    ThreadOnlineConnect(TaskOnlineConnect p_i1118_1_, String p_i1118_2_, int p_i1118_3_)
    {
        this.field_96594_c = p_i1118_1_;
        this.field_96595_a = p_i1118_2_;
        this.field_96593_b = p_i1118_3_;
    }

    public void run()
    {
        try
        {
            TaskOnlineConnect.func_96583_a(this.field_96594_c, new NetClientHandler(this.field_96594_c.func_96578_b(), this.field_96595_a, this.field_96593_b, TaskOnlineConnect.func_98172_a(this.field_96594_c)));

            if (this.field_96594_c.func_96577_c())
            {
                return;
            }

            this.field_96594_c.func_96576_b(I18n.func_135053_a("mco.connect.authorizing"));
            TaskOnlineConnect.func_96580_a(this.field_96594_c).func_72552_c(new Packet2ClientProtocol(78, this.field_96594_c.func_96578_b().func_110432_I().func_111285_a(), this.field_96595_a, this.field_96593_b));
        }
        catch (UnknownHostException unknownhostexception)
        {
            if (this.field_96594_c.func_96577_c())
            {
                return;
            }

            this.field_96594_c.func_96578_b().func_71373_a(new GuiScreenDisconnectedOnline(TaskOnlineConnect.func_98172_a(this.field_96594_c), "connect.failed", "disconnect.genericReason", new Object[] {"Unknown host \'" + this.field_96595_a + "\'"}));
        }
        catch (ConnectException connectexception)
        {
            if (this.field_96594_c.func_96577_c())
            {
                return;
            }

            this.field_96594_c.func_96578_b().func_71373_a(new GuiScreenDisconnectedOnline(TaskOnlineConnect.func_98172_a(this.field_96594_c), "connect.failed", "disconnect.genericReason", new Object[] {connectexception.getMessage()}));
        }
        catch (Exception exception)
        {
            if (this.field_96594_c.func_96577_c())
            {
                return;
            }

            exception.printStackTrace();
            this.field_96594_c.func_96578_b().func_71373_a(new GuiScreenDisconnectedOnline(TaskOnlineConnect.func_98172_a(this.field_96594_c), "connect.failed", "disconnect.genericReason", new Object[] {exception.toString()}));
        }
    }
}
