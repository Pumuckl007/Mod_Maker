package net.minecraft.world.storage;

import java.util.concurrent.Callable;

class CallableLevelSeed implements Callable
{
    final WorldInfo field_85143_a;

    CallableLevelSeed(WorldInfo p_i2148_1_)
    {
        this.field_85143_a = p_i2148_1_;
    }

    public String func_85142_a()
    {
        return String.valueOf(this.field_85143_a.func_76063_b());
    }

    public Object call()
    {
        return this.func_85142_a();
    }
}
