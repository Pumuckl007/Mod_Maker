package net.minecraft.util;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;

public class AABBPool
{
    private final int field_72306_a;
    private final int field_72304_b;
    private final List field_72305_c = new ArrayList();
    private int field_72302_d;
    private int field_72303_e;
    private int field_72301_f;

    public AABBPool(int p_i2301_1_, int p_i2301_2_)
    {
        this.field_72306_a = p_i2301_1_;
        this.field_72304_b = p_i2301_2_;
    }

    public AxisAlignedBB func_72299_a(double p_72299_1_, double p_72299_3_, double p_72299_5_, double p_72299_7_, double p_72299_9_, double p_72299_11_)
    {
        AxisAlignedBB axisalignedbb;

        if (this.field_72302_d >= this.field_72305_c.size())
        {
            axisalignedbb = new AxisAlignedBB(p_72299_1_, p_72299_3_, p_72299_5_, p_72299_7_, p_72299_9_, p_72299_11_);
            this.field_72305_c.add(axisalignedbb);
        }
        else
        {
            axisalignedbb = (AxisAlignedBB)this.field_72305_c.get(this.field_72302_d);
            axisalignedbb.func_72324_b(p_72299_1_, p_72299_3_, p_72299_5_, p_72299_7_, p_72299_9_, p_72299_11_);
        }

        ++this.field_72302_d;
        return axisalignedbb;
    }

    public void func_72298_a()
    {
        if (this.field_72302_d > this.field_72303_e)
        {
            this.field_72303_e = this.field_72302_d;
        }

        if (this.field_72301_f++ == this.field_72306_a)
        {
            int i = Math.max(this.field_72303_e, this.field_72305_c.size() - this.field_72304_b);

            while (this.field_72305_c.size() > i)
            {
                this.field_72305_c.remove(i);
            }

            this.field_72303_e = 0;
            this.field_72301_f = 0;
        }

        this.field_72302_d = 0;
    }

    @SideOnly(Side.CLIENT)
    public void func_72300_b()
    {
        this.field_72302_d = 0;
        this.field_72305_c.clear();
    }

    public int func_83013_c()
    {
        return this.field_72305_c.size();
    }

    public int func_83012_d()
    {
        return this.field_72302_d;
    }
}
