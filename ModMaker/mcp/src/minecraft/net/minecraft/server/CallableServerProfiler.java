package net.minecraft.server;

import java.util.concurrent.Callable;

public class CallableServerProfiler implements Callable
{
    final MinecraftServer field_74272_a;

    public CallableServerProfiler(MinecraftServer p_i1496_1_)
    {
        this.field_74272_a = p_i1496_1_;
    }

    public String func_96557_a()
    {
        int i = this.field_74272_a.field_71305_c[0].func_82732_R().func_82591_c();
        int j = 56 * i;
        int k = j / 1024 / 1024;
        int l = this.field_74272_a.field_71305_c[0].func_82732_R().func_82590_d();
        int i1 = 56 * l;
        int j1 = i1 / 1024 / 1024;
        return i + " (" + j + " bytes; " + k + " MB) allocated, " + l + " (" + i1 + " bytes; " + j1 + " MB) used";
    }

    public Object call()
    {
        return this.func_96557_a();
    }
}
