package net.minecraft.tileentity;

import java.util.concurrent.Callable;

class CallableTileEntityData implements Callable
{
    final TileEntity field_94612_a;

    CallableTileEntityData(TileEntity p_i2295_1_)
    {
        this.field_94612_a = p_i2295_1_;
    }

    public String func_94611_a()
    {
        int i = this.field_94612_a.field_70331_k.func_72805_g(this.field_94612_a.field_70329_l, this.field_94612_a.field_70330_m, this.field_94612_a.field_70327_n);

        if (i < 0)
        {
            return "Unknown? (Got " + i + ")";
        }
        else
        {
            String s = String.format("%4s", new Object[] {Integer.toBinaryString(i)}).replace(" ", "0");
            return String.format("%1$d / 0x%1$X / 0b%2$s", new Object[] {Integer.valueOf(i), s});
        }
    }

    public Object call()
    {
        return this.func_94611_a();
    }
}
