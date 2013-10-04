package net.minecraft.client.multiplayer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;
import net.minecraft.client.Minecraft;

@SideOnly(Side.CLIENT)
public class ThreadLanServerFind extends Thread
{
    private final LanServerList field_77500_a;
    private final InetAddress field_77498_b;
    private final MulticastSocket field_77499_c;

    public ThreadLanServerFind(LanServerList p_i1320_1_) throws IOException
    {
        super("LanServerDetector");
        this.field_77500_a = p_i1320_1_;
        this.setDaemon(true);
        this.field_77499_c = new MulticastSocket(4445);
        this.field_77498_b = InetAddress.getByName("224.0.2.60");
        this.field_77499_c.setSoTimeout(5000);
        this.field_77499_c.joinGroup(this.field_77498_b);
    }

    public void run()
    {
        byte[] abyte = new byte[1024];

        while (!this.isInterrupted())
        {
            DatagramPacket datagrampacket = new DatagramPacket(abyte, abyte.length);

            try
            {
                this.field_77499_c.receive(datagrampacket);
            }
            catch (SocketTimeoutException sockettimeoutexception)
            {
                continue;
            }
            catch (IOException ioexception)
            {
                ioexception.printStackTrace();
                break;
            }

            String s = new String(datagrampacket.getData(), datagrampacket.getOffset(), datagrampacket.getLength());
            Minecraft.func_71410_x().func_98033_al().func_98230_d(datagrampacket.getAddress() + ": " + s);
            this.field_77500_a.func_77551_a(s, datagrampacket.getAddress());
        }

        try
        {
            this.field_77499_c.leaveGroup(this.field_77498_b);
        }
        catch (IOException ioexception1)
        {
            ;
        }

        this.field_77499_c.close();
    }
}
