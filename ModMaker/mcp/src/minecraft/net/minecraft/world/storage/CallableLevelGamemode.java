package net.minecraft.world.storage;

import java.util.concurrent.Callable;

class CallableLevelGamemode implements Callable
{
    final WorldInfo field_85109_a;

    CallableLevelGamemode(WorldInfo p_i2156_1_)
    {
        this.field_85109_a = p_i2156_1_;
    }

    public String func_85108_a()
    {
        return String.format("Game mode: %s (ID %d). Hardcore: %b. Cheats: %b", new Object[] {WorldInfo.func_85120_o(this.field_85109_a).func_77149_b(), Integer.valueOf(WorldInfo.func_85120_o(this.field_85109_a).func_77148_a()), Boolean.valueOf(WorldInfo.func_85117_p(this.field_85109_a)), Boolean.valueOf(WorldInfo.func_85131_q(this.field_85109_a))});
    }

    public Object call()
    {
        return this.func_85108_a();
    }
}
