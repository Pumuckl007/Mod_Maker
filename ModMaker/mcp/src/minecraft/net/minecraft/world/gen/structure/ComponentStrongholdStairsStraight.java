package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;

public class ComponentStrongholdStairsStraight extends ComponentStronghold
{
    public ComponentStrongholdStairsStraight() {}

    public ComponentStrongholdStairsStraight(int p_i2085_1_, Random p_i2085_2_, StructureBoundingBox p_i2085_3_, int p_i2085_4_)
    {
        super(p_i2085_1_);
        this.field_74885_f = p_i2085_4_;
        this.field_143013_d = this.func_74988_a(p_i2085_2_);
        this.field_74887_e = p_i2085_3_;
    }

    public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
    {
        this.func_74986_a((ComponentStrongholdStairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
    }

    public static ComponentStrongholdStairsStraight func_75028_a(List p_75028_0_, Random p_75028_1_, int p_75028_2_, int p_75028_3_, int p_75028_4_, int p_75028_5_, int p_75028_6_)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_78889_a(p_75028_2_, p_75028_3_, p_75028_4_, -1, -7, 0, 5, 11, 8, p_75028_5_);
        return func_74991_a(structureboundingbox) && StructureComponent.func_74883_a(p_75028_0_, structureboundingbox) == null ? new ComponentStrongholdStairsStraight(p_75028_6_, p_75028_1_, structureboundingbox, p_75028_5_) : null;
    }

    public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
    {
        if (this.func_74860_a(p_74875_1_, p_74875_3_))
        {
            return false;
        }
        else
        {
            this.func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 10, 7, true, p_74875_2_, StructureStrongholdPieces.func_75197_b());
            this.func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, this.field_143013_d, 1, 7, 0);
            this.func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, EnumDoor.OPENING, 1, 1, 7);
            int i = this.func_74863_c(Block.field_72057_aH.field_71990_ca, 2);

            for (int j = 0; j < 6; ++j)
            {
                this.func_74864_a(p_74875_1_, Block.field_72057_aH.field_71990_ca, i, 1, 6 - j, 1 + j, p_74875_3_);
                this.func_74864_a(p_74875_1_, Block.field_72057_aH.field_71990_ca, i, 2, 6 - j, 1 + j, p_74875_3_);
                this.func_74864_a(p_74875_1_, Block.field_72057_aH.field_71990_ca, i, 3, 6 - j, 1 + j, p_74875_3_);

                if (j < 5)
                {
                    this.func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 1, 5 - j, 1 + j, p_74875_3_);
                    this.func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 2, 5 - j, 1 + j, p_74875_3_);
                    this.func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 3, 5 - j, 1 + j, p_74875_3_);
                }
            }

            return true;
        }
    }
}
