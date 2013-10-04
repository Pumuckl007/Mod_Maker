package net.minecraft.server;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import net.minecraft.network.NetLoginHandler;
import net.minecraft.network.NetworkListenThread;

public class ServerListenThread extends Thread
{
    private final List field_71775_b = Collections.synchronizedList(new ArrayList());
    private final HashMap field_71776_c = new HashMap();
    private int field_71773_d;
    private final ServerSocket field_71774_e;
    private NetworkListenThread field_71771_f;
    private final InetAddress field_71772_g;
    private final int field_71778_h;

    public ServerListenThread(NetworkListenThread p_i1510_1_, InetAddress p_i1510_2_, int p_i1510_3_) throws IOException
    {
        super("Listen thread");
        this.field_71771_f = p_i1510_1_;
        this.field_71778_h = p_i1510_3_;
        this.field_71774_e = new ServerSocket(p_i1510_3_, 0, p_i1510_2_);
        this.field_71772_g = p_i1510_2_ == null ? this.field_71774_e.getInetAddress() : p_i1510_2_;
        this.field_71774_e.setPerformancePreferences(0, 2, 1);
    }

    public void func_71766_a()
    {
        List list = this.field_71775_b;

        synchronized (this.field_71775_b)
        {
            for (int i = 0; i < this.field_71775_b.size(); ++i)
            {
                NetLoginHandler netloginhandler = (NetLoginHandler)this.field_71775_b.get(i);

                try
                {
                    netloginhandler.func_72532_c();
                }
                catch (Exception exception)
                {
                    netloginhandler.func_72527_a("Internal server error");
                    this.field_71771_f.func_71746_d().func_98033_al().func_98235_b("Failed to handle packet for " + netloginhandler.func_72528_e() + ": " + exception, exception);
                }

                if (netloginhandler.field_72539_c)
                {
                    this.field_71775_b.remove(i--);
                }

                netloginhandler.field_72538_b.func_74427_a();
            }
        }
    }

    public void run()
    {
        while (this.field_71771_f.field_71749_b)
        {
            try
            {
                Socket socket = this.field_71774_e.accept();
                NetLoginHandler netloginhandler = new NetLoginHandler(this.field_71771_f.func_71746_d(), socket, "Connection #" + this.field_71773_d++);
                this.func_71764_a(netloginhandler);
            }
            catch (IOException ioexception)
            {
                ioexception.printStackTrace();
            }
        }

        this.field_71771_f.func_71746_d().func_98033_al().func_98233_a("Closing listening thread");
    }

    private void func_71764_a(NetLoginHandler p_71764_1_)
    {
        if (p_71764_1_ == null)
        {
            throw new IllegalArgumentException("Got null pendingconnection!");
        }
        else
        {
            List list = this.field_71775_b;

            synchronized (this.field_71775_b)
            {
                this.field_71775_b.add(p_71764_1_);
            }
        }
    }

    public void func_71769_a(InetAddress p_71769_1_)
    {
        if (p_71769_1_ != null)
        {
            HashMap hashmap = this.field_71776_c;

            synchronized (this.field_71776_c)
            {
                this.field_71776_c.remove(p_71769_1_);
            }
        }
    }

    public void func_71768_b()
    {
        try
        {
            this.field_71774_e.close();
        }
        catch (Throwable throwable)
        {
            ;
        }
    }

    @SideOnly(Side.CLIENT)
    public int func_71765_d()
    {
        return this.field_71778_h;
    }
}