package net.minecraft.client;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.concurrent.Callable;

@SideOnly(Side.CLIENT)
class CallableModded implements Callable
{
    final Minecraft field_74500_a;

    CallableModded(Minecraft p_i1012_1_)
    {
        this.field_74500_a = p_i1012_1_;
    }

    public String func_74499_a()
    {
        String s = ClientBrandRetriever.getClientModName();
        return !s.equals("vanilla") ? "Definitely; Client brand changed to \'" + s + "\'" : (Minecraft.class.getSigners() == null ? "Very likely; Jar signature invalidated" : "Probably not. Jar signature remains and client brand is untouched.");
    }

    public Object call()
    {
        return this.func_74499_a();
    }
}
