package net.minecraft.world.storage;

import java.util.concurrent.Callable;

class CallableLevelTime implements Callable
{
    final WorldInfo field_85137_a;

    CallableLevelTime(WorldInfo p_i2152_1_)
    {
        this.field_85137_a = p_i2152_1_;
    }

    public String func_85136_a()
    {
        return String.format("%d game time, %d day time", new Object[] {Long.valueOf(WorldInfo.func_85126_g(this.field_85137_a)), Long.valueOf(WorldInfo.func_85129_h(this.field_85137_a))});
    }

    public Object call()
    {
        return this.func_85136_a();
    }
}
