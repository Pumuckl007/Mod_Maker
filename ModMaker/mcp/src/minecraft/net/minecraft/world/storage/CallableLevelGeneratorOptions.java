package net.minecraft.world.storage;

import java.util.concurrent.Callable;

class CallableLevelGeneratorOptions implements Callable
{
    final WorldInfo field_85141_a;

    CallableLevelGeneratorOptions(WorldInfo p_i2150_1_)
    {
        this.field_85141_a = p_i2150_1_;
    }

    public String func_85140_a()
    {
        return WorldInfo.func_85130_c(this.field_85141_a);
    }

    public Object call()
    {
        return this.func_85140_a();
    }
}
