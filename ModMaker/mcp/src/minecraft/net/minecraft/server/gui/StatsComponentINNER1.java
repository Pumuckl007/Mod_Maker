package net.minecraft.server.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SideOnly(Side.SERVER)
class StatsComponentINNER1 implements ActionListener
{
    final StatsComponent field_120030_a;

    StatsComponentINNER1(StatsComponent p_i2368_1_)
    {
        this.field_120030_a = p_i2368_1_;
    }

    public void actionPerformed(ActionEvent p_actionPerformed_1_)
    {
        StatsComponent.func_120033_a(this.field_120030_a);
    }
}
