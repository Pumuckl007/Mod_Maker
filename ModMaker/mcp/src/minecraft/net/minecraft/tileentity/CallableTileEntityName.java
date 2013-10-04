package net.minecraft.tileentity;

import java.util.concurrent.Callable;

class CallableTileEntityName implements Callable
{
    final TileEntity field_85146_a;

    CallableTileEntityName(TileEntity p_i2293_1_)
    {
        this.field_85146_a = p_i2293_1_;
    }

    public String func_85145_a()
    {
        return (String)TileEntity.func_85028_t().get(this.field_85146_a.getClass()) + " // " + this.field_85146_a.getClass().getCanonicalName();
    }

    public Object call()
    {
        return this.func_85145_a();
    }
}
