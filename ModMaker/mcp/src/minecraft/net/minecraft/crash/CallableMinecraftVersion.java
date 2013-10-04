package net.minecraft.crash;

import java.util.concurrent.Callable;

public class CallableMinecraftVersion implements Callable
{
    final CrashReport field_71494_a;

    public CallableMinecraftVersion(CrashReport p_i1338_1_)
    {
        this.field_71494_a = p_i1338_1_;
    }

    public String func_71493_a()
    {
        return "1.6.4";
    }

    public Object call()
    {
        return this.func_71493_a();
    }
}
