package net.minecraft.network;

import java.util.concurrent.Callable;
import net.minecraft.network.packet.Packet;

class CallablePacketID implements Callable
{
    final Packet field_98245_a;

    final NetServerHandler field_98244_b;

    CallablePacketID(NetServerHandler p_i1528_1_, Packet p_i1528_2_)
    {
        this.field_98244_b = p_i1528_1_;
        this.field_98245_a = p_i1528_2_;
    }

    public String func_98243_a()
    {
        return String.valueOf(this.field_98245_a.func_73281_k());
    }

    public Object call()
    {
        return this.func_98243_a();
    }
}
