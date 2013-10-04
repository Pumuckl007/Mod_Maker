package net.minecraft.world.storage;

import java.util.concurrent.Callable;

class CallableLevelDimension implements Callable
{
    final WorldInfo field_85115_a;

    CallableLevelDimension(WorldInfo p_i2153_1_)
    {
        this.field_85115_a = p_i2153_1_;
    }

    public String func_85114_a()
    {
        return String.valueOf(WorldInfo.func_85122_i(this.field_85115_a));
    }

    public Object call()
    {
        return this.func_85114_a();
    }
}
