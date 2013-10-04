package net.minecraft.entity;

import java.util.concurrent.Callable;

class CallableEntityTracker implements Callable
{
    final int field_96570_a;

    final EntityTracker field_96569_b;

    CallableEntityTracker(EntityTracker p_i1515_1_, int p_i1515_2_)
    {
        this.field_96569_b = p_i1515_1_;
        this.field_96570_a = p_i1515_2_;
    }

    public String func_96568_a()
    {
        String s = "Once per " + this.field_96570_a + " ticks";

        if (this.field_96570_a == Integer.MAX_VALUE)
        {
            s = "Maximum (" + s + ")";
        }

        return s;
    }

    public Object call()
    {
        return this.func_96568_a();
    }
}
