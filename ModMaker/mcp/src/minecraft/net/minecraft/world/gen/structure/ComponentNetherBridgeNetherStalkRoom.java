package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;

public class ComponentNetherBridgeNetherStalkRoom extends ComponentNetherBridgePiece
{
    public ComponentNetherBridgeNetherStalkRoom() {}

    public ComponentNetherBridgeNetherStalkRoom(int p_i2052_1_, Random p_i2052_2_, StructureBoundingBox p_i2052_3_, int p_i2052_4_)
    {
        super(p_i2052_1_);
        this.field_74885_f = p_i2052_4_;
        this.field_74887_e = p_i2052_3_;
    }

    public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
    {
        this.func_74963_a((ComponentNetherBridgeStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, 5, 3, true);
        this.func_74963_a((ComponentNetherBridgeStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, 5, 11, true);
    }

    public static ComponentNetherBridgeNetherStalkRoom func_74977_a(List p_74977_0_, Random p_74977_1_, int p_74977_2_, int p_74977_3_, int p_74977_4_, int p_74977_5_, int p_74977_6_)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_78889_a(p_74977_2_, p_74977_3_, p_74977_4_, -5, -3, 0, 13, 14, 13, p_74977_5_);
        return func_74964_a(structureboundingbox) && StructureComponent.func_74883_a(p_74977_0_, structureboundingbox) == null ? new ComponentNetherBridgeNetherStalkRoom(p_74977_6_, p_74977_1_, structureboundingbox, p_74977_5_) : null;
    }

    public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
    {
        this.func_74884_a(p_74875_1_, p_74875_3_, 0, 3, 0, 12, 4, 12, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 0, 5, 0, 12, 13, 12, 0, 0, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 0, 5, 0, 1, 12, 12, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 11, 5, 0, 12, 12, 12, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 2, 5, 11, 4, 12, 12, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 8, 5, 11, 10, 12, 12, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 5, 9, 11, 7, 12, 12, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 2, 5, 0, 4, 12, 1, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 8, 5, 0, 10, 12, 1, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 5, 9, 0, 7, 12, 1, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 2, 11, 2, 10, 12, 10, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        int i;

        for (i = 1; i <= 11; i += 2)
        {
            this.func_74884_a(p_74875_1_, p_74875_3_, i, 10, 0, i, 11, 0, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
            this.func_74884_a(p_74875_1_, p_74875_3_, i, 10, 12, i, 11, 12, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
            this.func_74884_a(p_74875_1_, p_74875_3_, 0, 10, i, 0, 11, i, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
            this.func_74884_a(p_74875_1_, p_74875_3_, 12, 10, i, 12, 11, i, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
            this.func_74864_a(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, i, 13, 0, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, i, 13, 12, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, 0, 13, i, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, 12, 13, i, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72098_bB.field_71990_ca, 0, i + 1, 13, 0, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72098_bB.field_71990_ca, 0, i + 1, 13, 12, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72098_bB.field_71990_ca, 0, 0, 13, i + 1, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72098_bB.field_71990_ca, 0, 12, 13, i + 1, p_74875_3_);
        }

        this.func_74864_a(p_74875_1_, Block.field_72098_bB.field_71990_ca, 0, 0, 13, 0, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72098_bB.field_71990_ca, 0, 0, 13, 12, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72098_bB.field_71990_ca, 0, 0, 13, 0, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72098_bB.field_71990_ca, 0, 12, 13, 0, p_74875_3_);

        for (i = 3; i <= 9; i += 2)
        {
            this.func_74884_a(p_74875_1_, p_74875_3_, 1, 7, i, 1, 8, i, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
            this.func_74884_a(p_74875_1_, p_74875_3_, 11, 7, i, 11, 8, i, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
        }

        i = this.func_74863_c(Block.field_72100_bC.field_71990_ca, 3);
        int j;
        int k;
        int l;

        for (j = 0; j <= 6; ++j)
        {
            k = j + 4;

            for (l = 5; l <= 7; ++l)
            {
                this.func_74864_a(p_74875_1_, Block.field_72100_bC.field_71990_ca, i, l, 5 + j, k, p_74875_3_);
            }

            if (k >= 5 && k <= 8)
            {
                this.func_74884_a(p_74875_1_, p_74875_3_, 5, 5, k, 7, j + 4, k, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
            }
            else if (k >= 9 && k <= 10)
            {
                this.func_74884_a(p_74875_1_, p_74875_3_, 5, 8, k, 7, j + 4, k, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
            }

            if (j >= 1)
            {
                this.func_74884_a(p_74875_1_, p_74875_3_, 5, 6 + j, k, 7, 9 + j, k, 0, 0, false);
            }
        }

        for (j = 5; j <= 7; ++j)
        {
            this.func_74864_a(p_74875_1_, Block.field_72100_bC.field_71990_ca, i, j, 12, 11, p_74875_3_);
        }

        this.func_74884_a(p_74875_1_, p_74875_3_, 5, 6, 7, 5, 7, 7, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 7, 6, 7, 7, 7, 7, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 5, 13, 12, 7, 13, 12, 0, 0, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 2, 5, 2, 3, 5, 3, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 2, 5, 9, 3, 5, 10, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 2, 5, 4, 2, 5, 8, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 9, 5, 2, 10, 5, 3, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 9, 5, 9, 10, 5, 10, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 10, 5, 4, 10, 5, 8, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        j = this.func_74863_c(Block.field_72100_bC.field_71990_ca, 0);
        k = this.func_74863_c(Block.field_72100_bC.field_71990_ca, 1);
        this.func_74864_a(p_74875_1_, Block.field_72100_bC.field_71990_ca, k, 4, 5, 2, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72100_bC.field_71990_ca, k, 4, 5, 3, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72100_bC.field_71990_ca, k, 4, 5, 9, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72100_bC.field_71990_ca, k, 4, 5, 10, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72100_bC.field_71990_ca, j, 8, 5, 2, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72100_bC.field_71990_ca, j, 8, 5, 3, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72100_bC.field_71990_ca, j, 8, 5, 9, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72100_bC.field_71990_ca, j, 8, 5, 10, p_74875_3_);
        this.func_74884_a(p_74875_1_, p_74875_3_, 3, 4, 4, 4, 4, 8, Block.field_72013_bc.field_71990_ca, Block.field_72013_bc.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 8, 4, 4, 9, 4, 8, Block.field_72013_bc.field_71990_ca, Block.field_72013_bc.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 3, 5, 4, 4, 5, 8, Block.field_72094_bD.field_71990_ca, Block.field_72094_bD.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 8, 5, 4, 9, 5, 8, Block.field_72094_bD.field_71990_ca, Block.field_72094_bD.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 4, 2, 0, 8, 2, 12, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 0, 2, 4, 12, 2, 8, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 4, 0, 0, 8, 1, 3, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 4, 0, 9, 8, 1, 12, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 0, 0, 4, 3, 1, 8, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 9, 0, 4, 12, 1, 8, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        int i1;

        for (l = 4; l <= 8; ++l)
        {
            for (i1 = 0; i1 <= 2; ++i1)
            {
                this.func_74870_b(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, l, -1, i1, p_74875_3_);
                this.func_74870_b(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, l, -1, 12 - i1, p_74875_3_);
            }
        }

        for (l = 0; l <= 2; ++l)
        {
            for (i1 = 4; i1 <= 8; ++i1)
            {
                this.func_74870_b(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, l, -1, i1, p_74875_3_);
                this.func_74870_b(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, 12 - l, -1, i1, p_74875_3_);
            }
        }

        return true;
    }
}
