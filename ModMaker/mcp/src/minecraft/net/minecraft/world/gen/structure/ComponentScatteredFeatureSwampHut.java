package net.minecraft.world.gen.structure;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ComponentScatteredFeatureSwampHut extends ComponentScatteredFeature
{
    private boolean field_82682_h;

    public ComponentScatteredFeatureSwampHut() {}

    public ComponentScatteredFeatureSwampHut(Random p_i2066_1_, int p_i2066_2_, int p_i2066_3_)
    {
        super(p_i2066_1_, p_i2066_2_, 64, p_i2066_3_, 7, 5, 9);
    }

    protected void func_143012_a(NBTTagCompound p_143012_1_)
    {
        super.func_143012_a(p_143012_1_);
        p_143012_1_.func_74757_a("Witch", this.field_82682_h);
    }

    protected void func_143011_b(NBTTagCompound p_143011_1_)
    {
        super.func_143011_b(p_143011_1_);
        this.field_82682_h = p_143011_1_.func_74767_n("Witch");
    }

    public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
    {
        if (!this.func_74935_a(p_74875_1_, p_74875_3_, 0))
        {
            return false;
        }
        else
        {
            this.func_74872_a(p_74875_1_, p_74875_3_, 1, 1, 1, 5, 1, 7, Block.field_71988_x.field_71990_ca, 1, Block.field_71988_x.field_71990_ca, 1, false);
            this.func_74872_a(p_74875_1_, p_74875_3_, 1, 4, 2, 5, 4, 7, Block.field_71988_x.field_71990_ca, 1, Block.field_71988_x.field_71990_ca, 1, false);
            this.func_74872_a(p_74875_1_, p_74875_3_, 2, 1, 0, 4, 1, 0, Block.field_71988_x.field_71990_ca, 1, Block.field_71988_x.field_71990_ca, 1, false);
            this.func_74872_a(p_74875_1_, p_74875_3_, 2, 2, 2, 3, 3, 2, Block.field_71988_x.field_71990_ca, 1, Block.field_71988_x.field_71990_ca, 1, false);
            this.func_74872_a(p_74875_1_, p_74875_3_, 1, 2, 3, 1, 3, 6, Block.field_71988_x.field_71990_ca, 1, Block.field_71988_x.field_71990_ca, 1, false);
            this.func_74872_a(p_74875_1_, p_74875_3_, 5, 2, 3, 5, 3, 6, Block.field_71988_x.field_71990_ca, 1, Block.field_71988_x.field_71990_ca, 1, false);
            this.func_74872_a(p_74875_1_, p_74875_3_, 2, 2, 7, 4, 3, 7, Block.field_71988_x.field_71990_ca, 1, Block.field_71988_x.field_71990_ca, 1, false);
            this.func_74884_a(p_74875_1_, p_74875_3_, 1, 0, 2, 1, 3, 2, Block.field_71951_J.field_71990_ca, Block.field_71951_J.field_71990_ca, false);
            this.func_74884_a(p_74875_1_, p_74875_3_, 5, 0, 2, 5, 3, 2, Block.field_71951_J.field_71990_ca, Block.field_71951_J.field_71990_ca, false);
            this.func_74884_a(p_74875_1_, p_74875_3_, 1, 0, 7, 1, 3, 7, Block.field_71951_J.field_71990_ca, Block.field_71951_J.field_71990_ca, false);
            this.func_74884_a(p_74875_1_, p_74875_3_, 5, 0, 7, 5, 3, 7, Block.field_71951_J.field_71990_ca, Block.field_71951_J.field_71990_ca, false);
            this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 2, 3, 2, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 3, 3, 7, p_74875_3_);
            this.func_74864_a(p_74875_1_, 0, 0, 1, 3, 4, p_74875_3_);
            this.func_74864_a(p_74875_1_, 0, 0, 5, 3, 4, p_74875_3_);
            this.func_74864_a(p_74875_1_, 0, 0, 5, 3, 5, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_82516_cf.field_71990_ca, 7, 1, 3, 5, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72060_ay.field_71990_ca, 0, 3, 2, 6, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72108_bG.field_71990_ca, 0, 4, 2, 6, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 1, 2, 1, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 5, 2, 1, p_74875_3_);
            int i = this.func_74863_c(Block.field_72063_at.field_71990_ca, 3);
            int j = this.func_74863_c(Block.field_72063_at.field_71990_ca, 1);
            int k = this.func_74863_c(Block.field_72063_at.field_71990_ca, 0);
            int l = this.func_74863_c(Block.field_72063_at.field_71990_ca, 2);
            this.func_74872_a(p_74875_1_, p_74875_3_, 0, 4, 1, 6, 4, 1, Block.field_72074_bW.field_71990_ca, i, Block.field_72074_bW.field_71990_ca, i, false);
            this.func_74872_a(p_74875_1_, p_74875_3_, 0, 4, 2, 0, 4, 7, Block.field_72074_bW.field_71990_ca, k, Block.field_72074_bW.field_71990_ca, k, false);
            this.func_74872_a(p_74875_1_, p_74875_3_, 6, 4, 2, 6, 4, 7, Block.field_72074_bW.field_71990_ca, j, Block.field_72074_bW.field_71990_ca, j, false);
            this.func_74872_a(p_74875_1_, p_74875_3_, 0, 4, 8, 6, 4, 8, Block.field_72074_bW.field_71990_ca, l, Block.field_72074_bW.field_71990_ca, l, false);
            int i1;
            int j1;

            for (i1 = 2; i1 <= 7; i1 += 5)
            {
                for (j1 = 1; j1 <= 5; j1 += 4)
                {
                    this.func_74870_b(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, j1, -1, i1, p_74875_3_);
                }
            }

            if (!this.field_82682_h)
            {
                i1 = this.func_74865_a(2, 5);
                j1 = this.func_74862_a(2);
                int k1 = this.func_74873_b(2, 5);

                if (p_74875_3_.func_78890_b(i1, j1, k1))
                {
                    this.field_82682_h = true;
                    EntityWitch entitywitch = new EntityWitch(p_74875_1_);
                    entitywitch.func_70012_b((double)i1 + 0.5D, (double)j1, (double)k1 + 0.5D, 0.0F, 0.0F);
                    entitywitch.func_110161_a((EntityLivingData)null);
                    p_74875_1_.func_72838_d(entitywitch);
                }
            }

            return true;
        }
    }
}
