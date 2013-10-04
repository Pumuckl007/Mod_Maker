package net.minecraft.world;

import java.util.concurrent.Callable;

class CallableLvl2 implements Callable
{
    final World field_77405_a;

    CallableLvl2(World p_i1951_1_)
    {
        this.field_77405_a = p_i1951_1_;
    }

    public String func_77404_a()
    {
        return this.field_77405_a.field_73010_i.size() + " total; " + this.field_77405_a.field_73010_i.toString();
    }

    public Object call()
    {
        return this.func_77404_a();
    }
}
