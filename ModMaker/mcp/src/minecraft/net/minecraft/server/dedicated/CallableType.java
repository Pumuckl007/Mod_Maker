package net.minecraft.server.dedicated;

import java.util.concurrent.Callable;

class CallableType implements Callable
{
    final DedicatedServer field_71743_a;

    CallableType(DedicatedServer p_i1506_1_)
    {
        this.field_71743_a = p_i1506_1_;
    }

    public String func_71742_a()
    {
        String s = this.field_71743_a.getServerModName();
        return !s.equals("vanilla") ? "Definitely; Server brand changed to \'" + s + "\'" : "Unknown (can\'t tell)";
    }

    public Object call()
    {
        return this.func_71742_a();
    }
}
