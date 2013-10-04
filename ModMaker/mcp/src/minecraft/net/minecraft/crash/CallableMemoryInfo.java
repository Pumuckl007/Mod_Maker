package net.minecraft.crash;

import java.util.concurrent.Callable;

class CallableMemoryInfo implements Callable
{
    final CrashReport field_71486_a;

    CallableMemoryInfo(CrashReport p_i1342_1_)
    {
        this.field_71486_a = p_i1342_1_;
    }

    public String func_71485_a()
    {
        Runtime runtime = Runtime.getRuntime();
        long i = runtime.maxMemory();
        long j = runtime.totalMemory();
        long k = runtime.freeMemory();
        long l = i / 1024L / 1024L;
        long i1 = j / 1024L / 1024L;
        long j1 = k / 1024L / 1024L;
        return k + " bytes (" + j1 + " MB) / " + j + " bytes (" + i1 + " MB) up to " + i + " bytes (" + l + " MB)";
    }

    public Object call()
    {
        return this.func_71485_a();
    }
}
