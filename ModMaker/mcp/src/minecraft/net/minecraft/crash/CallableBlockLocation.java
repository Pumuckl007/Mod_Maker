package net.minecraft.crash;

import java.util.concurrent.Callable;

final class CallableBlockLocation implements Callable
{
    final int field_85067_a;

    final int field_85065_b;

    final int field_85066_c;

    CallableBlockLocation(int p_i1351_1_, int p_i1351_2_, int p_i1351_3_)
    {
        this.field_85067_a = p_i1351_1_;
        this.field_85065_b = p_i1351_2_;
        this.field_85066_c = p_i1351_3_;
    }

    public String func_85064_a()
    {
        return CrashReportCategory.func_85071_a(this.field_85067_a, this.field_85065_b, this.field_85066_c);
    }

    public Object call()
    {
        return this.func_85064_a();
    }
}
