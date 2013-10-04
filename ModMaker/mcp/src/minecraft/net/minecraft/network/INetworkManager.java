package net.minecraft.network;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.net.SocketAddress;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;

public interface INetworkManager
{
    void func_74425_a(NetHandler nethandler);

    void func_74429_a(Packet packet);

    void func_74427_a();

    void func_74428_b();

    SocketAddress func_74430_c();

    void func_74423_d();

    int func_74426_e();

    void func_74424_a(String s, Object ... var2);

    @SideOnly(Side.CLIENT)
    void func_74431_f();
}
