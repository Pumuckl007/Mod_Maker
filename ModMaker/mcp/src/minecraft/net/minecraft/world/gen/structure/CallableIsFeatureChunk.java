package net.minecraft.world.gen.structure;

import java.util.concurrent.Callable;

class CallableIsFeatureChunk implements Callable
{
    final int field_85169_a;

    final int field_85167_b;

    final MapGenStructure field_85168_c;

    CallableIsFeatureChunk(MapGenStructure p_i2088_1_, int p_i2088_2_, int p_i2088_3_)
    {
        this.field_85168_c = p_i2088_1_;
        this.field_85169_a = p_i2088_2_;
        this.field_85167_b = p_i2088_3_;
    }

    public String func_85166_a()
    {
        return this.field_85168_c.func_75047_a(this.field_85169_a, this.field_85167_b) ? "True" : "False";
    }

    public Object call()
    {
        return this.func_85166_a();
    }
}
