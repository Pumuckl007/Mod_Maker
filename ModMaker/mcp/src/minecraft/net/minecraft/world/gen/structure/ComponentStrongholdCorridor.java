package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ComponentStrongholdCorridor extends ComponentStronghold
{
    private int field_74993_a;

    public ComponentStrongholdCorridor() {}

    public ComponentStrongholdCorridor(int p_i2072_1_, Random p_i2072_2_, StructureBoundingBox p_i2072_3_, int p_i2072_4_)
    {
        super(p_i2072_1_);
        this.field_74885_f = p_i2072_4_;
        this.field_74887_e = p_i2072_3_;
        this.field_74993_a = p_i2072_4_ != 2 && p_i2072_4_ != 0 ? p_i2072_3_.func_78883_b() : p_i2072_3_.func_78880_d();
    }

    protected void func_143012_a(NBTTagCompound p_143012_1_)
    {
        super.func_143012_a(p_143012_1_);
        p_143012_1_.func_74768_a("Steps", this.field_74993_a);
    }

    protected void func_143011_b(NBTTagCompound p_143011_1_)
    {
        super.func_143011_b(p_143011_1_);
        this.field_74993_a = p_143011_1_.func_74762_e("Steps");
    }

    public static StructureBoundingBox func_74992_a(List p_74992_0_, Random p_74992_1_, int p_74992_2_, int p_74992_3_, int p_74992_4_, int p_74992_5_)
    {
        boolean flag = true;
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_78889_a(p_74992_2_, p_74992_3_, p_74992_4_, -1, -1, 0, 5, 5, 4, p_74992_5_);
        StructureComponent structurecomponent = StructureComponent.func_74883_a(p_74992_0_, structureboundingbox);

        if (structurecomponent == null)
        {
            return null;
        }
        else
        {
            if (structurecomponent.func_74874_b().field_78895_b == structureboundingbox.field_78895_b)
            {
                for (int i1 = 3; i1 >= 1; --i1)
                {
                    structureboundingbox = StructureBoundingBox.func_78889_a(p_74992_2_, p_74992_3_, p_74992_4_, -1, -1, 0, 5, 5, i1 - 1, p_74992_5_);

                    if (!structurecomponent.func_74874_b().func_78884_a(structureboundingbox))
                    {
                        return StructureBoundingBox.func_78889_a(p_74992_2_, p_74992_3_, p_74992_4_, -1, -1, 0, 5, 5, i1, p_74992_5_);
                    }
                }
            }

            return null;
        }
    }

    public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
    {
        if (this.func_74860_a(p_74875_1_, p_74875_3_))
        {
            return false;
        }
        else
        {
            for (int i = 0; i < this.field_74993_a; ++i)
            {
                this.func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 0, 0, i, p_74875_3_);
                this.func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 1, 0, i, p_74875_3_);
                this.func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 2, 0, i, p_74875_3_);
                this.func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 3, 0, i, p_74875_3_);
                this.func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 4, 0, i, p_74875_3_);

                for (int j = 1; j <= 3; ++j)
                {
                    this.func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 0, j, i, p_74875_3_);
                    this.func_74864_a(p_74875_1_, 0, 0, 1, j, i, p_74875_3_);
                    this.func_74864_a(p_74875_1_, 0, 0, 2, j, i, p_74875_3_);
                    this.func_74864_a(p_74875_1_, 0, 0, 3, j, i, p_74875_3_);
                    this.func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 4, j, i, p_74875_3_);
                }

                this.func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 0, 4, i, p_74875_3_);
                this.func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 1, 4, i, p_74875_3_);
                this.func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 2, 4, i, p_74875_3_);
                this.func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 3, 4, i, p_74875_3_);
                this.func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 4, 4, i, p_74875_3_);
            }

            return true;
        }
    }
}
