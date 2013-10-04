package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;

public class ComponentNetherBridgeCorridor5 extends ComponentNetherBridgePiece
{
    public ComponentNetherBridgeCorridor5() {}

    public ComponentNetherBridgeCorridor5(int p_i2050_1_, Random p_i2050_2_, StructureBoundingBox p_i2050_3_, int p_i2050_4_)
    {
        super(p_i2050_1_);
        this.field_74885_f = p_i2050_4_;
        this.field_74887_e = p_i2050_3_;
    }

    public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
    {
        this.func_74963_a((ComponentNetherBridgeStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, 1, 0, true);
    }

    public static ComponentNetherBridgeCorridor5 func_74981_a(List p_74981_0_, Random p_74981_1_, int p_74981_2_, int p_74981_3_, int p_74981_4_, int p_74981_5_, int p_74981_6_)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_78889_a(p_74981_2_, p_74981_3_, p_74981_4_, -1, 0, 0, 5, 7, 5, p_74981_5_);
        return func_74964_a(structureboundingbox) && StructureComponent.func_74883_a(p_74981_0_, structureboundingbox) == null ? new ComponentNetherBridgeCorridor5(p_74981_6_, p_74981_1_, structureboundingbox, p_74981_5_) : null;
    }

    public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
    {
        this.func_74884_a(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 1, 4, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 0, 2, 0, 4, 5, 4, 0, 0, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 0, 2, 0, 0, 5, 4, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 4, 2, 0, 4, 5, 4, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 0, 3, 1, 0, 4, 1, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 0, 3, 3, 0, 4, 3, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 4, 3, 1, 4, 4, 1, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 4, 3, 3, 4, 4, 3, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 0, 6, 0, 4, 6, 4, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);

        for (int i = 0; i <= 4; ++i)
        {
            for (int j = 0; j <= 4; ++j)
            {
                this.func_74870_b(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, i, -1, j, p_74875_3_);
            }
        }

        return true;
    }
}
