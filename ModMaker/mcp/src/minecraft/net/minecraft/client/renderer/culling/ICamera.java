package net.minecraft.client.renderer.culling;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.AxisAlignedBB;

@SideOnly(Side.CLIENT)
public interface ICamera
{
    boolean func_78546_a(AxisAlignedBB axisalignedbb);

    void func_78547_a(double d0, double d1, double d2);
}
