package net.minecraft.server.dedicated;

import java.util.concurrent.Callable;

class CallableServerType implements Callable
{
    final DedicatedServer field_85171_a;

    CallableServerType(DedicatedServer p_i1507_1_)
    {
        this.field_85171_a = p_i1507_1_;
    }

    public String func_85170_a()
    {
        return "Dedicated Server (map_server.txt)";
    }

    public Object call()
    {
        return this.func_85170_a();
    }
}
