package net.minecraft.server.integrated;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.concurrent.Callable;
import net.minecraft.client.ClientBrandRetriever;
import net.minecraft.client.Minecraft;

@SideOnly(Side.CLIENT)
class CallableIsModded implements Callable
{
    final IntegratedServer field_76972_a;

    CallableIsModded(IntegratedServer p_i1316_1_)
    {
        this.field_76972_a = p_i1316_1_;
    }

    public String func_76971_a()
    {
        String s = ClientBrandRetriever.getClientModName();

        if (!s.equals("vanilla"))
        {
            return "Definitely; Client brand changed to \'" + s + "\'";
        }
        else
        {
            s = this.field_76972_a.getServerModName();
            return !s.equals("vanilla") ? "Definitely; Server brand changed to \'" + s + "\'" : (Minecraft.class.getSigners() == null ? "Very likely; Jar signature invalidated" : "Probably not. Jar signature remains and both client + server brands are untouched.");
        }
    }

    public Object call()
    {
        return this.func_76971_a();
    }
}
