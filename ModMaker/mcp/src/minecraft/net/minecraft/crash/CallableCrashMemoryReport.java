package net.minecraft.crash;

import java.util.concurrent.Callable;
import net.minecraft.util.AxisAlignedBB;

class CallableCrashMemoryReport implements Callable
{
    final CrashReport field_83004_a;

    CallableCrashMemoryReport(CrashReport p_i1344_1_)
    {
        this.field_83004_a = p_i1344_1_;
    }

    public String func_83003_a()
    {
        int i = AxisAlignedBB.func_72332_a().func_83013_c();
        int j = 56 * i;
        int k = j / 1024 / 1024;
        int l = AxisAlignedBB.func_72332_a().func_83012_d();
        int i1 = 56 * l;
        int j1 = i1 / 1024 / 1024;
        return i + " (" + j + " bytes; " + k + " MB) allocated, " + l + " (" + i1 + " bytes; " + j1 + " MB) used";
    }

    public Object call()
    {
        return this.func_83003_a();
    }
}
