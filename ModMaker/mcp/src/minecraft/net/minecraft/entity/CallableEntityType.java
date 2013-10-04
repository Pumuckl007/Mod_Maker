package net.minecraft.entity;

import java.util.concurrent.Callable;

class CallableEntityType implements Callable
{
    final Entity field_85155_a;

    CallableEntityType(Entity p_i1579_1_)
    {
        this.field_85155_a = p_i1579_1_;
    }

    public String func_85154_a()
    {
        return EntityList.func_75621_b(this.field_85155_a) + " (" + this.field_85155_a.getClass().getCanonicalName() + ")";
    }

    public Object call()
    {
        return this.func_85154_a();
    }
}
