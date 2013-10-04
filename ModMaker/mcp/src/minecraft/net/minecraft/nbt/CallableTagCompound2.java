package net.minecraft.nbt;

import java.util.concurrent.Callable;

class CallableTagCompound2 implements Callable
{
    final int field_82588_a;

    final NBTTagCompound field_82587_b;

    CallableTagCompound2(NBTTagCompound p_i1374_1_, int p_i1374_2_)
    {
        this.field_82587_b = p_i1374_1_;
        this.field_82588_a = p_i1374_2_;
    }

    public String func_82586_a()
    {
        return NBTBase.field_82578_b[this.field_82588_a];
    }

    public Object call()
    {
        return this.func_82586_a();
    }
}
