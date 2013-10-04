package net.minecraft.nbt;

import java.util.concurrent.Callable;

class CallableTagCompound1 implements Callable
{
    final String field_82585_a;

    final NBTTagCompound field_82584_b;

    CallableTagCompound1(NBTTagCompound p_i1373_1_, String p_i1373_2_)
    {
        this.field_82584_b = p_i1373_1_;
        this.field_82585_a = p_i1373_2_;
    }

    public String func_82583_a()
    {
        return NBTBase.field_82578_b[((NBTBase)NBTTagCompound.func_82579_a(this.field_82584_b).get(this.field_82585_a)).func_74732_a()];
    }

    public Object call()
    {
        return this.func_82583_a();
    }
}
