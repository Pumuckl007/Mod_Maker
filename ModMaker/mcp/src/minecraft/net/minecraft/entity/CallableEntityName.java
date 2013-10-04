package net.minecraft.entity;

import java.util.concurrent.Callable;

class CallableEntityName implements Callable
{
    final Entity field_96564_a;

    CallableEntityName(Entity p_i1580_1_)
    {
        this.field_96564_a = p_i1580_1_;
    }

    public String func_96563_a()
    {
        return this.field_96564_a.func_70023_ak();
    }

    public Object call()
    {
        return this.func_96563_a();
    }
}
