package net.minecraft.client.multiplayer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.net.ConnectException;
import java.net.UnknownHostException;
import net.minecraft.client.gui.GuiDisconnected;
import net.minecraft.network.packet.Packet2ClientProtocol;

@SideOnly(Side.CLIENT)
class ThreadConnectToServer extends Thread
{
    final String field_78821_a;

    final int field_78819_b;

    final GuiConnecting field_78820_c;

    ThreadConnectToServer(GuiConnecting p_i1180_1_, String p_i1180_2_, int p_i1180_3_)
    {
        this.field_78820_c = p_i1180_1_;
        this.field_78821_a = p_i1180_2_;
        this.field_78819_b = p_i1180_3_;
    }

    public void run()
    {
        try
        {
            GuiConnecting.func_74252_a(this.field_78820_c, new NetClientHandler(GuiConnecting.func_74256_a(this.field_78820_c), this.field_78821_a, this.field_78819_b));

            if (GuiConnecting.func_74257_b(this.field_78820_c))
            {
                return;
            }

            GuiConnecting.func_74253_d(this.field_78820_c).func_72552_c(new Packet2ClientProtocol(78, GuiConnecting.func_74254_c(this.field_78820_c).func_110432_I().func_111285_a(), this.field_78821_a, this.field_78819_b));
        }
        catch (UnknownHostException unknownhostexception)
        {
            if (GuiConnecting.func_74257_b(this.field_78820_c))
            {
                return;
            }

            GuiConnecting.func_74250_f(this.field_78820_c).func_71373_a(new GuiDisconnected(GuiConnecting.func_98097_e(this.field_78820_c), "connect.failed", "disconnect.genericReason", new Object[] {"Unknown host \'" + this.field_78821_a + "\'"}));
        }
        catch (ConnectException connectexception)
        {
            if (GuiConnecting.func_74257_b(this.field_78820_c))
            {
                return;
            }

            GuiConnecting.func_74251_g(this.field_78820_c).func_71373_a(new GuiDisconnected(GuiConnecting.func_98097_e(this.field_78820_c), "connect.failed", "disconnect.genericReason", new Object[] {connectexception.getMessage()}));
        }
        catch (Exception exception)
        {
            if (GuiConnecting.func_74257_b(this.field_78820_c))
            {
                return;
            }

            exception.printStackTrace();
            GuiConnecting.func_98096_h(this.field_78820_c).func_71373_a(new GuiDisconnected(GuiConnecting.func_98097_e(this.field_78820_c), "connect.failed", "disconnect.genericReason", new Object[] {exception.toString()}));
        }
    }
}
