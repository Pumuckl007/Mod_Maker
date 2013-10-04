package net.minecraft.entity.ai;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathFinder;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.util.MathHelper;

public class EntityAIControlledByPlayer extends EntityAIBase
{
    private final EntityLiving field_82640_a;
    private final float field_82638_b;
    private float field_82639_c;
    private boolean field_82636_d;
    private int field_82637_e;
    private int field_82635_f;

    public EntityAIControlledByPlayer(EntityLiving p_i1620_1_, float p_i1620_2_)
    {
        this.field_82640_a = p_i1620_1_;
        this.field_82638_b = p_i1620_2_;
        this.func_75248_a(7);
    }

    public void func_75249_e()
    {
        this.field_82639_c = 0.0F;
    }

    public void func_75251_c()
    {
        this.field_82636_d = false;
        this.field_82639_c = 0.0F;
    }

    public boolean func_75250_a()
    {
        return this.field_82640_a.func_70089_S() && this.field_82640_a.field_70153_n != null && this.field_82640_a.field_70153_n instanceof EntityPlayer && (this.field_82636_d || this.field_82640_a.func_82171_bF());
    }

    public void func_75246_d()
    {
        EntityPlayer entityplayer = (EntityPlayer)this.field_82640_a.field_70153_n;
        EntityCreature entitycreature = (EntityCreature)this.field_82640_a;
        float f = MathHelper.func_76142_g(entityplayer.field_70177_z - this.field_82640_a.field_70177_z) * 0.5F;

        if (f > 5.0F)
        {
            f = 5.0F;
        }

        if (f < -5.0F)
        {
            f = -5.0F;
        }

        this.field_82640_a.field_70177_z = MathHelper.func_76142_g(this.field_82640_a.field_70177_z + f);

        if (this.field_82639_c < this.field_82638_b)
        {
            this.field_82639_c += (this.field_82638_b - this.field_82639_c) * 0.01F;
        }

        if (this.field_82639_c > this.field_82638_b)
        {
            this.field_82639_c = this.field_82638_b;
        }

        int i = MathHelper.func_76128_c(this.field_82640_a.field_70165_t);
        int j = MathHelper.func_76128_c(this.field_82640_a.field_70163_u);
        int k = MathHelper.func_76128_c(this.field_82640_a.field_70161_v);
        float f1 = this.field_82639_c;

        if (this.field_82636_d)
        {
            if (this.field_82637_e++ > this.field_82635_f)
            {
                this.field_82636_d = false;
            }

            f1 += f1 * 1.15F * MathHelper.func_76126_a((float)this.field_82637_e / (float)this.field_82635_f * (float)Math.PI);
        }

        float f2 = 0.91F;

        if (this.field_82640_a.field_70122_E)
        {
            f2 = 0.54600006F;
            int l = this.field_82640_a.field_70170_p.func_72798_a(MathHelper.func_76141_d((float)i), MathHelper.func_76141_d((float)j) - 1, MathHelper.func_76141_d((float)k));

            if (l > 0)
            {
                f2 = Block.field_71973_m[l].field_72016_cq * 0.91F;
            }
        }

        float f3 = 0.16277136F / (f2 * f2 * f2);
        float f4 = MathHelper.func_76126_a(entitycreature.field_70177_z * (float)Math.PI / 180.0F);
        float f5 = MathHelper.func_76134_b(entitycreature.field_70177_z * (float)Math.PI / 180.0F);
        float f6 = entitycreature.func_70689_ay() * f3;
        float f7 = Math.max(f1, 1.0F);
        f7 = f6 / f7;
        float f8 = f1 * f7;
        float f9 = -(f8 * f4);
        float f10 = f8 * f5;

        if (MathHelper.func_76135_e(f9) > MathHelper.func_76135_e(f10))
        {
            if (f9 < 0.0F)
            {
                f9 -= this.field_82640_a.field_70130_N / 2.0F;
            }

            if (f9 > 0.0F)
            {
                f9 += this.field_82640_a.field_70130_N / 2.0F;
            }

            f10 = 0.0F;
        }
        else
        {
            f9 = 0.0F;

            if (f10 < 0.0F)
            {
                f10 -= this.field_82640_a.field_70130_N / 2.0F;
            }

            if (f10 > 0.0F)
            {
                f10 += this.field_82640_a.field_70130_N / 2.0F;
            }
        }

        int i1 = MathHelper.func_76128_c(this.field_82640_a.field_70165_t + (double)f9);
        int j1 = MathHelper.func_76128_c(this.field_82640_a.field_70161_v + (double)f10);
        PathPoint pathpoint = new PathPoint(MathHelper.func_76141_d(this.field_82640_a.field_70130_N + 1.0F), MathHelper.func_76141_d(this.field_82640_a.field_70131_O + entityplayer.field_70131_O + 1.0F), MathHelper.func_76141_d(this.field_82640_a.field_70130_N + 1.0F));

        if (i != i1 || k != j1)
        {
            int k1 = this.field_82640_a.field_70170_p.func_72798_a(i, j, k);
            int l1 = this.field_82640_a.field_70170_p.func_72798_a(i, j - 1, k);
            boolean flag = this.func_98216_b(k1) || Block.field_71973_m[k1] == null && this.func_98216_b(l1);

            if (!flag && PathFinder.func_82565_a(this.field_82640_a, i1, j, j1, pathpoint, false, false, true) == 0 && PathFinder.func_82565_a(this.field_82640_a, i, j + 1, k, pathpoint, false, false, true) == 1 && PathFinder.func_82565_a(this.field_82640_a, i1, j + 1, j1, pathpoint, false, false, true) == 1)
            {
                entitycreature.func_70683_ar().func_75660_a();
            }
        }

        if (!entityplayer.field_71075_bZ.field_75098_d && this.field_82639_c >= this.field_82638_b * 0.5F && this.field_82640_a.func_70681_au().nextFloat() < 0.006F && !this.field_82636_d)
        {
            ItemStack itemstack = entityplayer.func_70694_bm();

            if (itemstack != null && itemstack.field_77993_c == Item.field_82793_bR.field_77779_bT)
            {
                itemstack.func_77972_a(1, entityplayer);

                if (itemstack.field_77994_a == 0)
                {
                    ItemStack itemstack1 = new ItemStack(Item.field_77749_aR);
                    itemstack1.func_77982_d(itemstack.field_77990_d);
                    entityplayer.field_71071_by.field_70462_a[entityplayer.field_71071_by.field_70461_c] = itemstack1;
                }
            }
        }

        this.field_82640_a.func_70612_e(0.0F, f1);
    }

    private boolean func_98216_b(int p_98216_1_)
    {
        return Block.field_71973_m[p_98216_1_] != null && (Block.field_71973_m[p_98216_1_].func_71857_b() == 10 || Block.field_71973_m[p_98216_1_] instanceof BlockHalfSlab);
    }

    public boolean func_82634_f()
    {
        return this.field_82636_d;
    }

    public void func_82632_g()
    {
        this.field_82636_d = true;
        this.field_82637_e = 0;
        this.field_82635_f = this.field_82640_a.func_70681_au().nextInt(841) + 140;
    }

    public boolean func_82633_h()
    {
        return !this.func_82634_f() && this.field_82639_c > this.field_82638_b * 0.3F;
    }
}
