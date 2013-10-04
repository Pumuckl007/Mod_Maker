package net.minecraft.client.renderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.concurrent.Callable;

@SideOnly(Side.CLIENT)
class CallableScreenName implements Callable
{
    final EntityRenderer field_90032_a;

    CallableScreenName(EntityRenderer p_i1243_1_)
    {
        this.field_90032_a = p_i1243_1_;
    }

    public String func_90031_a()
    {
        return EntityRenderer.func_90030_a(this.field_90032_a).field_71462_r.getClass().getCanonicalName();
    }

    public Object call()
    {
        return this.func_90031_a();
    }
}
