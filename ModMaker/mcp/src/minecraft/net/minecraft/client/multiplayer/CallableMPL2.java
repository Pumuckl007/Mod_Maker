package net.minecraft.client.multiplayer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.concurrent.Callable;

@SideOnly(Side.CLIENT)
class CallableMPL2 implements Callable
{
    final WorldClient field_78835_a;

    CallableMPL2(WorldClient p_i1187_1_)
    {
        this.field_78835_a = p_i1187_1_;
    }

    public String func_78834_a()
    {
        return WorldClient.func_73030_b(this.field_78835_a).size() + " total; " + WorldClient.func_73030_b(this.field_78835_a).toString();
    }

    public Object call()
    {
        return this.func_78834_a();
    }
}
