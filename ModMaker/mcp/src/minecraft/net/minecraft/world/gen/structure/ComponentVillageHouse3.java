package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;

public class ComponentVillageHouse3 extends ComponentVillage
{
    public ComponentVillageHouse3() {}

    public ComponentVillageHouse3(ComponentVillageStartPiece p_i2106_1_, int p_i2106_2_, Random p_i2106_3_, StructureBoundingBox p_i2106_4_, int p_i2106_5_)
    {
        super(p_i2106_1_, p_i2106_2_);
        this.field_74885_f = p_i2106_5_;
        this.field_74887_e = p_i2106_4_;
    }

    public static ComponentVillageHouse3 func_74921_a(ComponentVillageStartPiece p_74921_0_, List p_74921_1_, Random p_74921_2_, int p_74921_3_, int p_74921_4_, int p_74921_5_, int p_74921_6_, int p_74921_7_)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_78889_a(p_74921_3_, p_74921_4_, p_74921_5_, 0, 0, 0, 9, 7, 12, p_74921_6_);
        return func_74895_a(structureboundingbox) && StructureComponent.func_74883_a(p_74921_1_, structureboundingbox) == null ? new ComponentVillageHouse3(p_74921_0_, p_74921_7_, p_74921_2_, structureboundingbox, p_74921_6_) : null;
    }

    public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
    {
        if (this.field_143015_k < 0)
        {
            this.field_143015_k = this.func_74889_b(p_74875_1_, p_74875_3_);

            if (this.field_143015_k < 0)
            {
                return true;
            }

            this.field_74887_e.func_78886_a(0, this.field_143015_k - this.field_74887_e.field_78894_e + 7 - 1, 0);
        }

        this.func_74884_a(p_74875_1_, p_74875_3_, 1, 1, 1, 7, 4, 4, 0, 0, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 2, 1, 6, 8, 4, 10, 0, 0, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 2, 0, 5, 8, 0, 10, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 1, 0, 1, 7, 0, 4, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 0, 0, 0, 0, 3, 5, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 8, 0, 0, 8, 3, 10, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 1, 0, 0, 7, 2, 0, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 1, 0, 5, 2, 1, 5, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 2, 0, 6, 2, 3, 10, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 3, 0, 10, 7, 3, 10, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 1, 2, 0, 7, 3, 0, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 1, 2, 5, 2, 3, 5, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 0, 4, 1, 8, 4, 1, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 0, 4, 4, 3, 4, 4, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 0, 5, 2, 8, 5, 3, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
        this.func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 0, 4, 2, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 0, 4, 3, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 8, 4, 2, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 8, 4, 3, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 8, 4, 4, p_74875_3_);
        int i = this.func_74863_c(Block.field_72063_at.field_71990_ca, 3);
        int j = this.func_74863_c(Block.field_72063_at.field_71990_ca, 2);
        int k;
        int l;

        for (k = -1; k <= 2; ++k)
        {
            for (l = 0; l <= 8; ++l)
            {
                this.func_74864_a(p_74875_1_, Block.field_72063_at.field_71990_ca, i, l, 4 + k, k, p_74875_3_);

                if ((k > -1 || l <= 1) && (k > 0 || l <= 3) && (k > 1 || l <= 4 || l >= 6))
                {
                    this.func_74864_a(p_74875_1_, Block.field_72063_at.field_71990_ca, j, l, 4 + k, 5 - k, p_74875_3_);
                }
            }
        }

        this.func_74884_a(p_74875_1_, p_74875_3_, 3, 4, 5, 3, 4, 10, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 7, 4, 2, 7, 4, 10, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 4, 5, 4, 4, 5, 10, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 6, 5, 4, 6, 5, 10, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 5, 6, 3, 5, 6, 10, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
        k = this.func_74863_c(Block.field_72063_at.field_71990_ca, 0);
        int i1;

        for (l = 4; l >= 1; --l)
        {
            this.func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, l, 2 + l, 7 - l, p_74875_3_);

            for (i1 = 8 - l; i1 <= 10; ++i1)
            {
                this.func_74864_a(p_74875_1_, Block.field_72063_at.field_71990_ca, k, l, 2 + l, i1, p_74875_3_);
            }
        }

        l = this.func_74863_c(Block.field_72063_at.field_71990_ca, 1);
        this.func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 6, 6, 3, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 7, 5, 4, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72063_at.field_71990_ca, l, 6, 6, 4, p_74875_3_);
        int j1;

        for (i1 = 6; i1 <= 8; ++i1)
        {
            for (j1 = 5; j1 <= 10; ++j1)
            {
                this.func_74864_a(p_74875_1_, Block.field_72063_at.field_71990_ca, l, i1, 12 - i1, j1, p_74875_3_);
            }
        }

        this.func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 0, 2, 1, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 0, 2, 4, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 0, 2, 2, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 0, 2, 3, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 4, 2, 0, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 5, 2, 0, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 6, 2, 0, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 8, 2, 1, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 8, 2, 2, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 8, 2, 3, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 8, 2, 4, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 8, 2, 5, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 8, 2, 6, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 8, 2, 7, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 8, 2, 8, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 8, 2, 9, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 2, 2, 6, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 2, 2, 7, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 2, 2, 8, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 2, 2, 9, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 4, 4, 10, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 5, 4, 10, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 6, 4, 10, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 5, 5, 10, p_74875_3_);
        this.func_74864_a(p_74875_1_, 0, 0, 2, 1, 0, p_74875_3_);
        this.func_74864_a(p_74875_1_, 0, 0, 2, 2, 0, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 0, 2, 3, 1, p_74875_3_);
        this.func_74881_a(p_74875_1_, p_74875_3_, p_74875_2_, 2, 1, 0, this.func_74863_c(Block.field_72054_aE.field_71990_ca, 1));
        this.func_74884_a(p_74875_1_, p_74875_3_, 1, 0, -1, 3, 2, -1, 0, 0, false);

        if (this.func_74866_a(p_74875_1_, 2, 0, -1, p_74875_3_) == 0 && this.func_74866_a(p_74875_1_, 2, -1, -1, p_74875_3_) != 0)
        {
            this.func_74864_a(p_74875_1_, Block.field_72057_aH.field_71990_ca, this.func_74863_c(Block.field_72057_aH.field_71990_ca, 3), 2, 0, -1, p_74875_3_);
        }

        for (i1 = 0; i1 < 5; ++i1)
        {
            for (j1 = 0; j1 < 9; ++j1)
            {
                this.func_74871_b(p_74875_1_, j1, 7, i1, p_74875_3_);
                this.func_74870_b(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, j1, -1, i1, p_74875_3_);
            }
        }

        for (i1 = 5; i1 < 11; ++i1)
        {
            for (j1 = 2; j1 < 9; ++j1)
            {
                this.func_74871_b(p_74875_1_, j1, 7, i1, p_74875_3_);
                this.func_74870_b(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, j1, -1, i1, p_74875_3_);
            }
        }

        this.func_74893_a(p_74875_1_, p_74875_3_, 4, 1, 2, 2);
        return true;
    }
}
