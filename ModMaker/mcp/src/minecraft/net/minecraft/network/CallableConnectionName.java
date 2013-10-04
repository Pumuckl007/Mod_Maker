package net.minecraft.network;

import java.util.concurrent.Callable;

class CallableConnectionName implements Callable
{
    final NetServerHandler field_111201_a;

    final NetworkListenThread field_111200_b;

    CallableConnectionName(NetworkListenThread p_i1531_1_, NetServerHandler p_i1531_2_)
    {
        this.field_111200_b = p_i1531_1_;
        this.field_111201_a = p_i1531_2_;
    }

    public String func_111199_a()
    {
        return this.field_111201_a.toString();
    }

    public Object call()
    {
        return this.func_111199_a();
    }
}
