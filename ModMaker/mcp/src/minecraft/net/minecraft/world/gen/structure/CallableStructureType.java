package net.minecraft.world.gen.structure;

import java.util.concurrent.Callable;

class CallableStructureType implements Callable
{
    final MapGenStructure field_85161_a;

    CallableStructureType(MapGenStructure p_i2090_1_)
    {
        this.field_85161_a = p_i2090_1_;
    }

    public String func_85160_a()
    {
        return this.field_85161_a.getClass().getCanonicalName();
    }

    public Object call()
    {
        return this.func_85160_a();
    }
}
