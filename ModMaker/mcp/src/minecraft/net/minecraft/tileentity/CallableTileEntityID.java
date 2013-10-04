package net.minecraft.tileentity;

import java.util.concurrent.Callable;
import net.minecraft.block.Block;

class CallableTileEntityID implements Callable
{
    final TileEntity field_94610_a;

    CallableTileEntityID(TileEntity p_i2294_1_)
    {
        this.field_94610_a = p_i2294_1_;
    }

    public String func_94609_a()
    {
        int i = this.field_94610_a.field_70331_k.func_72798_a(this.field_94610_a.field_70329_l, this.field_94610_a.field_70330_m, this.field_94610_a.field_70327_n);

        try
        {
            return String.format("ID #%d (%s // %s)", new Object[] {Integer.valueOf(i), Block.field_71973_m[i].func_71917_a(), Block.field_71973_m[i].getClass().getCanonicalName()});
        }
        catch (Throwable throwable)
        {
            return "ID #" + i;
        }
    }

    public Object call()
    {
        return this.func_94609_a();
    }
}
