package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;

public class ComponentStrongholdLibrary extends ComponentStronghold
{
    public static final WeightedRandomChestContent[] field_75007_b = new WeightedRandomChestContent[] {new WeightedRandomChestContent(Item.field_77760_aL.field_77779_bT, 0, 1, 3, 20), new WeightedRandomChestContent(Item.field_77759_aK.field_77779_bT, 0, 2, 7, 20), new WeightedRandomChestContent(Item.field_82801_bO.field_77779_bT, 0, 1, 1, 1), new WeightedRandomChestContent(Item.field_77750_aQ.field_77779_bT, 0, 1, 1, 1)};
    private boolean field_75008_c;

    public ComponentStrongholdLibrary() {}

    public ComponentStrongholdLibrary(int p_i2075_1_, Random p_i2075_2_, StructureBoundingBox p_i2075_3_, int p_i2075_4_)
    {
        super(p_i2075_1_);
        this.field_74885_f = p_i2075_4_;
        this.field_143013_d = this.func_74988_a(p_i2075_2_);
        this.field_74887_e = p_i2075_3_;
        this.field_75008_c = p_i2075_3_.func_78882_c() > 6;
    }

    protected void func_143012_a(NBTTagCompound p_143012_1_)
    {
        super.func_143012_a(p_143012_1_);
        p_143012_1_.func_74757_a("Tall", this.field_75008_c);
    }

    protected void func_143011_b(NBTTagCompound p_143011_1_)
    {
        super.func_143011_b(p_143011_1_);
        this.field_75008_c = p_143011_1_.func_74767_n("Tall");
    }

    public static ComponentStrongholdLibrary func_75006_a(List p_75006_0_, Random p_75006_1_, int p_75006_2_, int p_75006_3_, int p_75006_4_, int p_75006_5_, int p_75006_6_)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_78889_a(p_75006_2_, p_75006_3_, p_75006_4_, -4, -1, 0, 14, 11, 15, p_75006_5_);

        if (!func_74991_a(structureboundingbox) || StructureComponent.func_74883_a(p_75006_0_, structureboundingbox) != null)
        {
            structureboundingbox = StructureBoundingBox.func_78889_a(p_75006_2_, p_75006_3_, p_75006_4_, -4, -1, 0, 14, 6, 15, p_75006_5_);

            if (!func_74991_a(structureboundingbox) || StructureComponent.func_74883_a(p_75006_0_, structureboundingbox) != null)
            {
                return null;
            }
        }

        return new ComponentStrongholdLibrary(p_75006_6_, p_75006_1_, structureboundingbox, p_75006_5_);
    }

    public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
    {
        if (this.func_74860_a(p_74875_1_, p_74875_3_))
        {
            return false;
        }
        else
        {
            byte b0 = 11;

            if (!this.field_75008_c)
            {
                b0 = 6;
            }

            this.func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 13, b0 - 1, 14, true, p_74875_2_, StructureStrongholdPieces.func_75197_b());
            this.func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, this.field_143013_d, 4, 1, 0);
            this.func_74880_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.07F, 2, 1, 1, 11, 4, 13, Block.field_71955_W.field_71990_ca, Block.field_71955_W.field_71990_ca, false);
            boolean flag = true;
            boolean flag1 = true;
            int i;

            for (i = 1; i <= 13; ++i)
            {
                if ((i - 1) % 4 == 0)
                {
                    this.func_74884_a(p_74875_1_, p_74875_3_, 1, 1, i, 1, 4, i, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
                    this.func_74884_a(p_74875_1_, p_74875_3_, 12, 1, i, 12, 4, i, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
                    this.func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 0, 2, 3, i, p_74875_3_);
                    this.func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 0, 11, 3, i, p_74875_3_);

                    if (this.field_75008_c)
                    {
                        this.func_74884_a(p_74875_1_, p_74875_3_, 1, 6, i, 1, 9, i, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
                        this.func_74884_a(p_74875_1_, p_74875_3_, 12, 6, i, 12, 9, i, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
                    }
                }
                else
                {
                    this.func_74884_a(p_74875_1_, p_74875_3_, 1, 1, i, 1, 4, i, Block.field_72093_an.field_71990_ca, Block.field_72093_an.field_71990_ca, false);
                    this.func_74884_a(p_74875_1_, p_74875_3_, 12, 1, i, 12, 4, i, Block.field_72093_an.field_71990_ca, Block.field_72093_an.field_71990_ca, false);

                    if (this.field_75008_c)
                    {
                        this.func_74884_a(p_74875_1_, p_74875_3_, 1, 6, i, 1, 9, i, Block.field_72093_an.field_71990_ca, Block.field_72093_an.field_71990_ca, false);
                        this.func_74884_a(p_74875_1_, p_74875_3_, 12, 6, i, 12, 9, i, Block.field_72093_an.field_71990_ca, Block.field_72093_an.field_71990_ca, false);
                    }
                }
            }

            for (i = 3; i < 12; i += 2)
            {
                this.func_74884_a(p_74875_1_, p_74875_3_, 3, 1, i, 4, 3, i, Block.field_72093_an.field_71990_ca, Block.field_72093_an.field_71990_ca, false);
                this.func_74884_a(p_74875_1_, p_74875_3_, 6, 1, i, 7, 3, i, Block.field_72093_an.field_71990_ca, Block.field_72093_an.field_71990_ca, false);
                this.func_74884_a(p_74875_1_, p_74875_3_, 9, 1, i, 10, 3, i, Block.field_72093_an.field_71990_ca, Block.field_72093_an.field_71990_ca, false);
            }

            if (this.field_75008_c)
            {
                this.func_74884_a(p_74875_1_, p_74875_3_, 1, 5, 1, 3, 5, 13, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
                this.func_74884_a(p_74875_1_, p_74875_3_, 10, 5, 1, 12, 5, 13, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
                this.func_74884_a(p_74875_1_, p_74875_3_, 4, 5, 1, 9, 5, 2, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
                this.func_74884_a(p_74875_1_, p_74875_3_, 4, 5, 12, 9, 5, 13, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
                this.func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 9, 5, 11, p_74875_3_);
                this.func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 8, 5, 11, p_74875_3_);
                this.func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 9, 5, 10, p_74875_3_);
                this.func_74884_a(p_74875_1_, p_74875_3_, 3, 6, 2, 3, 6, 12, Block.field_72031_aZ.field_71990_ca, Block.field_72031_aZ.field_71990_ca, false);
                this.func_74884_a(p_74875_1_, p_74875_3_, 10, 6, 2, 10, 6, 10, Block.field_72031_aZ.field_71990_ca, Block.field_72031_aZ.field_71990_ca, false);
                this.func_74884_a(p_74875_1_, p_74875_3_, 4, 6, 2, 9, 6, 2, Block.field_72031_aZ.field_71990_ca, Block.field_72031_aZ.field_71990_ca, false);
                this.func_74884_a(p_74875_1_, p_74875_3_, 4, 6, 12, 8, 6, 12, Block.field_72031_aZ.field_71990_ca, Block.field_72031_aZ.field_71990_ca, false);
                this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 9, 6, 11, p_74875_3_);
                this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 8, 6, 11, p_74875_3_);
                this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 9, 6, 10, p_74875_3_);
                i = this.func_74863_c(Block.field_72055_aF.field_71990_ca, 3);
                this.func_74864_a(p_74875_1_, Block.field_72055_aF.field_71990_ca, i, 10, 1, 13, p_74875_3_);
                this.func_74864_a(p_74875_1_, Block.field_72055_aF.field_71990_ca, i, 10, 2, 13, p_74875_3_);
                this.func_74864_a(p_74875_1_, Block.field_72055_aF.field_71990_ca, i, 10, 3, 13, p_74875_3_);
                this.func_74864_a(p_74875_1_, Block.field_72055_aF.field_71990_ca, i, 10, 4, 13, p_74875_3_);
                this.func_74864_a(p_74875_1_, Block.field_72055_aF.field_71990_ca, i, 10, 5, 13, p_74875_3_);
                this.func_74864_a(p_74875_1_, Block.field_72055_aF.field_71990_ca, i, 10, 6, 13, p_74875_3_);
                this.func_74864_a(p_74875_1_, Block.field_72055_aF.field_71990_ca, i, 10, 7, 13, p_74875_3_);
                byte b1 = 7;
                byte b2 = 7;
                this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, b1 - 1, 9, b2, p_74875_3_);
                this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, b1, 9, b2, p_74875_3_);
                this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, b1 - 1, 8, b2, p_74875_3_);
                this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, b1, 8, b2, p_74875_3_);
                this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, b1 - 1, 7, b2, p_74875_3_);
                this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, b1, 7, b2, p_74875_3_);
                this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, b1 - 2, 7, b2, p_74875_3_);
                this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, b1 + 1, 7, b2, p_74875_3_);
                this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, b1 - 1, 7, b2 - 1, p_74875_3_);
                this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, b1 - 1, 7, b2 + 1, p_74875_3_);
                this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, b1, 7, b2 - 1, p_74875_3_);
                this.func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, b1, 7, b2 + 1, p_74875_3_);
                this.func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 0, b1 - 2, 8, b2, p_74875_3_);
                this.func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 0, b1 + 1, 8, b2, p_74875_3_);
                this.func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 0, b1 - 1, 8, b2 - 1, p_74875_3_);
                this.func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 0, b1 - 1, 8, b2 + 1, p_74875_3_);
                this.func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 0, b1, 8, b2 - 1, p_74875_3_);
                this.func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 0, b1, 8, b2 + 1, p_74875_3_);
            }

            this.func_74879_a(p_74875_1_, p_74875_3_, p_74875_2_, 3, 3, 5, WeightedRandomChestContent.func_92080_a(field_75007_b, new WeightedRandomChestContent[] {Item.field_92105_bW.func_92112_a(p_74875_2_, 1, 5, 2)}), 1 + p_74875_2_.nextInt(4));

            if (this.field_75008_c)
            {
                this.func_74864_a(p_74875_1_, 0, 0, 12, 9, 1, p_74875_3_);
                this.func_74879_a(p_74875_1_, p_74875_3_, p_74875_2_, 12, 8, 1, WeightedRandomChestContent.func_92080_a(field_75007_b, new WeightedRandomChestContent[] {Item.field_92105_bW.func_92112_a(p_74875_2_, 1, 5, 2)}), 1 + p_74875_2_.nextInt(4));
            }

            return true;
        }
    }
}
