package net.minecraft.client.renderer.texture;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.concurrent.Callable;

@SideOnly(Side.CLIENT)
class TextureManagerINNER1 implements Callable
{
    final TextureObject field_135062_a;

    final TextureManager field_135061_b;

    TextureManagerINNER1(TextureManager p_i1283_1_, TextureObject p_i1283_2_)
    {
        this.field_135061_b = p_i1283_1_;
        this.field_135062_a = p_i1283_2_;
    }

    public String func_135060_a()
    {
        return this.field_135062_a.getClass().getName();
    }

    public Object call()
    {
        return this.func_135060_a();
    }
}
