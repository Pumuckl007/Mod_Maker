package net.minecraft.crash;

import java.util.concurrent.Callable;

class CallableJavaInfo implements Callable
{
    final CrashReport field_71490_a;

    CallableJavaInfo(CrashReport p_i1340_1_)
    {
        this.field_71490_a = p_i1340_1_;
    }

    public String func_71489_a()
    {
        return System.getProperty("java.version") + ", " + System.getProperty("java.vendor");
    }

    public Object call()
    {
        return this.func_71489_a();
    }
}
