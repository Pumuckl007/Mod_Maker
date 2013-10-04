package net.minecraft.world;

import java.util.concurrent.Callable;

class CallableLvl3 implements Callable
{
    final World field_77440_a;

    CallableLvl3(World p_i1952_1_)
    {
        this.field_77440_a = p_i1952_1_;
    }

    public String func_77439_a()
    {
        return this.field_77440_a.field_73020_y.func_73148_d();
    }

    public Object call()
    {
        return this.func_77439_a();
    }
}
