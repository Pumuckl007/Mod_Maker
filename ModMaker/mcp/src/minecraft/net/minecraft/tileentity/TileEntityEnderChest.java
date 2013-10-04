package net.minecraft.tileentity;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;

public class TileEntityEnderChest extends TileEntity
{
    public float field_70370_a;
    public float field_70368_b;
    public int field_70369_c;
    private int field_70367_d;

    public void func_70316_g()
    {
        super.func_70316_g();

        if (++this.field_70367_d % 20 * 4 == 0)
        {
            this.field_70331_k.func_72965_b(this.field_70329_l, this.field_70330_m, this.field_70327_n, Block.field_72066_bS.field_71990_ca, 1, this.field_70369_c);
        }

        this.field_70368_b = this.field_70370_a;
        float f = 0.1F;
        double d0;

        if (this.field_70369_c > 0 && this.field_70370_a == 0.0F)
        {
            double d1 = (double)this.field_70329_l + 0.5D;
            d0 = (double)this.field_70327_n + 0.5D;
            this.field_70331_k.func_72908_a(d1, (double)this.field_70330_m + 0.5D, d0, "random.chestopen", 0.5F, this.field_70331_k.field_73012_v.nextFloat() * 0.1F + 0.9F);
        }

        if (this.field_70369_c == 0 && this.field_70370_a > 0.0F || this.field_70369_c > 0 && this.field_70370_a < 1.0F)
        {
            float f1 = this.field_70370_a;

            if (this.field_70369_c > 0)
            {
                this.field_70370_a += f;
            }
            else
            {
                this.field_70370_a -= f;
            }

            if (this.field_70370_a > 1.0F)
            {
                this.field_70370_a = 1.0F;
            }

            float f2 = 0.5F;

            if (this.field_70370_a < f2 && f1 >= f2)
            {
                d0 = (double)this.field_70329_l + 0.5D;
                double d2 = (double)this.field_70327_n + 0.5D;
                this.field_70331_k.func_72908_a(d0, (double)this.field_70330_m + 0.5D, d2, "random.chestclosed", 0.5F, this.field_70331_k.field_73012_v.nextFloat() * 0.1F + 0.9F);
            }

            if (this.field_70370_a < 0.0F)
            {
                this.field_70370_a = 0.0F;
            }
        }
    }

    public boolean func_70315_b(int p_70315_1_, int p_70315_2_)
    {
        if (p_70315_1_ == 1)
        {
            this.field_70369_c = p_70315_2_;
            return true;
        }
        else
        {
            return super.func_70315_b(p_70315_1_, p_70315_2_);
        }
    }

    public void func_70313_j()
    {
        this.func_70321_h();
        super.func_70313_j();
    }

    public void func_70364_a()
    {
        ++this.field_70369_c;
        this.field_70331_k.func_72965_b(this.field_70329_l, this.field_70330_m, this.field_70327_n, Block.field_72066_bS.field_71990_ca, 1, this.field_70369_c);
    }

    public void func_70366_b()
    {
        --this.field_70369_c;
        this.field_70331_k.func_72965_b(this.field_70329_l, this.field_70330_m, this.field_70327_n, Block.field_72066_bS.field_71990_ca, 1, this.field_70369_c);
    }

    public boolean func_70365_a(EntityPlayer p_70365_1_)
    {
        return this.field_70331_k.func_72796_p(this.field_70329_l, this.field_70330_m, this.field_70327_n) != this ? false : p_70365_1_.func_70092_e((double)this.field_70329_l + 0.5D, (double)this.field_70330_m + 0.5D, (double)this.field_70327_n + 0.5D) <= 64.0D;
    }
}
