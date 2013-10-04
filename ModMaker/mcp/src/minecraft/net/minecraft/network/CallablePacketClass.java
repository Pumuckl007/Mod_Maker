package net.minecraft.network;

import java.util.concurrent.Callable;
import net.minecraft.network.packet.Packet;

class CallablePacketClass implements Callable
{
    final Packet field_98227_a;

    final NetServerHandler field_98226_b;

    CallablePacketClass(NetServerHandler p_i1529_1_, Packet p_i1529_2_)
    {
        this.field_98226_b = p_i1529_1_;
        this.field_98227_a = p_i1529_2_;
    }

    public String func_98225_a()
    {
        return this.field_98227_a.getClass().getCanonicalName();
    }

    public Object call()
    {
        return this.func_98225_a();
    }
}
