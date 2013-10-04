package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;

public class ComponentNetherBridgeCorridor3 extends ComponentNetherBridgePiece
{
    public ComponentNetherBridgeCorridor3() {}

    public ComponentNetherBridgeCorridor3(int p_i2045_1_, Random p_i2045_2_, StructureBoundingBox p_i2045_3_, int p_i2045_4_)
    {
        super(p_i2045_1_);
        this.field_74885_f = p_i2045_4_;
        this.field_74887_e = p_i2045_3_;
    }

    public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
    {
        this.func_74963_a((ComponentNetherBridgeStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, 1, 0, true);
    }

    public static ComponentNetherBridgeCorridor3 func_74982_a(List p_74982_0_, Random p_74982_1_, int p_74982_2_, int p_74982_3_, int p_74982_4_, int p_74982_5_, int p_74982_6_)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_78889_a(p_74982_2_, p_74982_3_, p_74982_4_, -1, -7, 0, 5, 14, 10, p_74982_5_);
        return func_74964_a(structureboundingbox) && StructureComponent.func_74883_a(p_74982_0_, structureboundingbox) == null ? new ComponentNetherBridgeCorridor3(p_74982_6_, p_74982_1_, structureboundingbox, p_74982_5_) : null;
    }

    public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
    {
        int i = this.func_74863_c(Block.field_72100_bC.field_71990_ca, 2);

        for (int j = 0; j <= 9; ++j)
        {
            int k = Math.max(1, 7 - j);
            int l = Math.min(Math.max(k + 5, 14 - j), 13);
            int i1 = j;
            this.func_74884_a(p_74875_1_, p_74875_3_, 0, 0, j, 4, k, j, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
            this.func_74884_a(p_74875_1_, p_74875_3_, 1, k + 1, j, 3, l - 1, j, 0, 0, false);

            if (j <= 6)
            {
                this.func_74864_a(p_74875_1_, Block.field_72100_bC.field_71990_ca, i, 1, k + 1, j, p_74875_3_);
                this.func_74864_a(p_74875_1_, Block.field_72100_bC.field_71990_ca, i, 2, k + 1, j, p_74875_3_);
                this.func_74864_a(p_74875_1_, Block.field_72100_bC.field_71990_ca, i, 3, k + 1, j, p_74875_3_);
            }

            this.func_74884_a(p_74875_1_, p_74875_3_, 0, l, j, 4, l, j, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
            this.func_74884_a(p_74875_1_, p_74875_3_, 0, k + 1, j, 0, l - 1, j, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
            this.func_74884_a(p_74875_1_, p_74875_3_, 4, k + 1, j, 4, l - 1, j, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);

            if ((j & 1) == 0)
            {
                this.func_74884_a(p_74875_1_, p_74875_3_, 0, k + 2, j, 0, k + 3, j, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
                this.func_74884_a(p_74875_1_, p_74875_3_, 4, k + 2, j, 4, k + 3, j, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
            }

            for (int j1 = 0; j1 <= 4; ++j1)
            {
                this.func_74870_b(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, j1, -1, i1, p_74875_3_);
            }
        }

        return true;
    }
}
