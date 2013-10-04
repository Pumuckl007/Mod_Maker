package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityMinecartChest;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;

public class ComponentMineshaftCorridor extends StructureComponent
{
    private boolean field_74958_a;
    private boolean field_74956_b;
    private boolean field_74957_c;
    private int field_74955_d;

    public ComponentMineshaftCorridor() {}

    protected void func_143012_a(NBTTagCompound p_143012_1_)
    {
        p_143012_1_.func_74757_a("hr", this.field_74958_a);
        p_143012_1_.func_74757_a("sc", this.field_74956_b);
        p_143012_1_.func_74757_a("hps", this.field_74957_c);
        p_143012_1_.func_74768_a("Num", this.field_74955_d);
    }

    protected void func_143011_b(NBTTagCompound p_143011_1_)
    {
        this.field_74958_a = p_143011_1_.func_74767_n("hr");
        this.field_74956_b = p_143011_1_.func_74767_n("sc");
        this.field_74957_c = p_143011_1_.func_74767_n("hps");
        this.field_74955_d = p_143011_1_.func_74762_e("Num");
    }

    public ComponentMineshaftCorridor(int p_i2035_1_, Random p_i2035_2_, StructureBoundingBox p_i2035_3_, int p_i2035_4_)
    {
        super(p_i2035_1_);
        this.field_74885_f = p_i2035_4_;
        this.field_74887_e = p_i2035_3_;
        this.field_74958_a = p_i2035_2_.nextInt(3) == 0;
        this.field_74956_b = !this.field_74958_a && p_i2035_2_.nextInt(23) == 0;

        if (this.field_74885_f != 2 && this.field_74885_f != 0)
        {
            this.field_74955_d = p_i2035_3_.func_78883_b() / 5;
        }
        else
        {
            this.field_74955_d = p_i2035_3_.func_78880_d() / 5;
        }
    }

    public static StructureBoundingBox func_74954_a(List p_74954_0_, Random p_74954_1_, int p_74954_2_, int p_74954_3_, int p_74954_4_, int p_74954_5_)
    {
        StructureBoundingBox structureboundingbox = new StructureBoundingBox(p_74954_2_, p_74954_3_, p_74954_4_, p_74954_2_, p_74954_3_ + 2, p_74954_4_);
        int i1;

        for (i1 = p_74954_1_.nextInt(3) + 2; i1 > 0; --i1)
        {
            int j1 = i1 * 5;

            switch (p_74954_5_)
            {
                case 0:
                    structureboundingbox.field_78893_d = p_74954_2_ + 2;
                    structureboundingbox.field_78892_f = p_74954_4_ + (j1 - 1);
                    break;
                case 1:
                    structureboundingbox.field_78897_a = p_74954_2_ - (j1 - 1);
                    structureboundingbox.field_78892_f = p_74954_4_ + 2;
                    break;
                case 2:
                    structureboundingbox.field_78893_d = p_74954_2_ + 2;
                    structureboundingbox.field_78896_c = p_74954_4_ - (j1 - 1);
                    break;
                case 3:
                    structureboundingbox.field_78893_d = p_74954_2_ + (j1 - 1);
                    structureboundingbox.field_78892_f = p_74954_4_ + 2;
            }

            if (StructureComponent.func_74883_a(p_74954_0_, structureboundingbox) == null)
            {
                break;
            }
        }

        return i1 > 0 ? structureboundingbox : null;
    }

    public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
    {
        int i = this.func_74877_c();
        int j = p_74861_3_.nextInt(4);

        switch (this.field_74885_f)
        {
            case 0:
                if (j <= 1)
                {
                    StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b - 1 + p_74861_3_.nextInt(3), this.field_74887_e.field_78892_f + 1, this.field_74885_f, i);
                }
                else if (j == 2)
                {
                    StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b - 1 + p_74861_3_.nextInt(3), this.field_74887_e.field_78892_f - 3, 1, i);
                }
                else
                {
                    StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b - 1 + p_74861_3_.nextInt(3), this.field_74887_e.field_78892_f - 3, 3, i);
                }

                break;
            case 1:
                if (j <= 1)
                {
                    StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b - 1 + p_74861_3_.nextInt(3), this.field_74887_e.field_78896_c, this.field_74885_f, i);
                }
                else if (j == 2)
                {
                    StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b - 1 + p_74861_3_.nextInt(3), this.field_74887_e.field_78896_c - 1, 2, i);
                }
                else
                {
                    StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b - 1 + p_74861_3_.nextInt(3), this.field_74887_e.field_78892_f + 1, 0, i);
                }

                break;
            case 2:
                if (j <= 1)
                {
                    StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b - 1 + p_74861_3_.nextInt(3), this.field_74887_e.field_78896_c - 1, this.field_74885_f, i);
                }
                else if (j == 2)
                {
                    StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b - 1 + p_74861_3_.nextInt(3), this.field_74887_e.field_78896_c, 1, i);
                }
                else
                {
                    StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b - 1 + p_74861_3_.nextInt(3), this.field_74887_e.field_78896_c, 3, i);
                }

                break;
            case 3:
                if (j <= 1)
                {
                    StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b - 1 + p_74861_3_.nextInt(3), this.field_74887_e.field_78896_c, this.field_74885_f, i);
                }
                else if (j == 2)
                {
                    StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d - 3, this.field_74887_e.field_78895_b - 1 + p_74861_3_.nextInt(3), this.field_74887_e.field_78896_c - 1, 2, i);
                }
                else
                {
                    StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d - 3, this.field_74887_e.field_78895_b - 1 + p_74861_3_.nextInt(3), this.field_74887_e.field_78892_f + 1, 0, i);
                }
        }

        if (i < 8)
        {
            int k;
            int l;

            if (this.field_74885_f != 2 && this.field_74885_f != 0)
            {
                for (k = this.field_74887_e.field_78897_a + 3; k + 3 <= this.field_74887_e.field_78893_d; k += 5)
                {
                    l = p_74861_3_.nextInt(5);

                    if (l == 0)
                    {
                        StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, k, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c - 1, 2, i + 1);
                    }
                    else if (l == 1)
                    {
                        StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, k, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f + 1, 0, i + 1);
                    }
                }
            }
            else
            {
                for (k = this.field_74887_e.field_78896_c + 3; k + 3 <= this.field_74887_e.field_78892_f; k += 5)
                {
                    l = p_74861_3_.nextInt(5);

                    if (l == 0)
                    {
                        StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b, k, 1, i + 1);
                    }
                    else if (l == 1)
                    {
                        StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b, k, 3, i + 1);
                    }
                }
            }
        }
    }

    protected boolean func_74879_a(World p_74879_1_, StructureBoundingBox p_74879_2_, Random p_74879_3_, int p_74879_4_, int p_74879_5_, int p_74879_6_, WeightedRandomChestContent[] p_74879_7_, int p_74879_8_)
    {
        int i1 = this.func_74865_a(p_74879_4_, p_74879_6_);
        int j1 = this.func_74862_a(p_74879_5_);
        int k1 = this.func_74873_b(p_74879_4_, p_74879_6_);

        if (p_74879_2_.func_78890_b(i1, j1, k1) && p_74879_1_.func_72798_a(i1, j1, k1) == 0)
        {
            p_74879_1_.func_72832_d(i1, j1, k1, Block.field_72056_aG.field_71990_ca, this.func_74863_c(Block.field_72056_aG.field_71990_ca, p_74879_3_.nextBoolean() ? 1 : 0), 2);
            EntityMinecartChest entityminecartchest = new EntityMinecartChest(p_74879_1_, (double)((float)i1 + 0.5F), (double)((float)j1 + 0.5F), (double)((float)k1 + 0.5F));
            WeightedRandomChestContent.func_76293_a(p_74879_3_, p_74879_7_, entityminecartchest, p_74879_8_);
            p_74879_1_.func_72838_d(entityminecartchest);
            return true;
        }
        else
        {
            return false;
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
            boolean flag = false;
            boolean flag1 = true;
            boolean flag2 = false;
            boolean flag3 = true;
            int i = this.field_74955_d * 5 - 1;
            this.func_74884_a(p_74875_1_, p_74875_3_, 0, 0, 0, 2, 1, i, 0, 0, false);
            this.func_74880_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.8F, 0, 2, 0, 2, 2, i, 0, 0, false);

            if (this.field_74956_b)
            {
                this.func_74880_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.6F, 0, 0, 0, 2, 1, i, Block.field_71955_W.field_71990_ca, 0, false);
            }

            int j;
            int k;
            int l;

            for (j = 0; j < this.field_74955_d; ++j)
            {
                k = 2 + j * 5;
                this.func_74884_a(p_74875_1_, p_74875_3_, 0, 0, k, 0, 1, k, Block.field_72031_aZ.field_71990_ca, 0, false);
                this.func_74884_a(p_74875_1_, p_74875_3_, 2, 0, k, 2, 1, k, Block.field_72031_aZ.field_71990_ca, 0, false);

                if (p_74875_2_.nextInt(4) == 0)
                {
                    this.func_74884_a(p_74875_1_, p_74875_3_, 0, 2, k, 0, 2, k, Block.field_71988_x.field_71990_ca, 0, false);
                    this.func_74884_a(p_74875_1_, p_74875_3_, 2, 2, k, 2, 2, k, Block.field_71988_x.field_71990_ca, 0, false);
                }
                else
                {
                    this.func_74884_a(p_74875_1_, p_74875_3_, 0, 2, k, 2, 2, k, Block.field_71988_x.field_71990_ca, 0, false);
                }

                this.func_74876_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.1F, 0, 2, k - 1, Block.field_71955_W.field_71990_ca, 0);
                this.func_74876_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.1F, 2, 2, k - 1, Block.field_71955_W.field_71990_ca, 0);
                this.func_74876_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.1F, 0, 2, k + 1, Block.field_71955_W.field_71990_ca, 0);
                this.func_74876_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.1F, 2, 2, k + 1, Block.field_71955_W.field_71990_ca, 0);
                this.func_74876_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.05F, 0, 2, k - 2, Block.field_71955_W.field_71990_ca, 0);
                this.func_74876_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.05F, 2, 2, k - 2, Block.field_71955_W.field_71990_ca, 0);
                this.func_74876_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.05F, 0, 2, k + 2, Block.field_71955_W.field_71990_ca, 0);
                this.func_74876_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.05F, 2, 2, k + 2, Block.field_71955_W.field_71990_ca, 0);
                this.func_74876_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.05F, 1, 2, k - 1, Block.field_72069_aq.field_71990_ca, 0);
                this.func_74876_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.05F, 1, 2, k + 1, Block.field_72069_aq.field_71990_ca, 0);

                if (p_74875_2_.nextInt(100) == 0)
                {
                    this.func_74879_a(p_74875_1_, p_74875_3_, p_74875_2_, 2, 0, k - 1, WeightedRandomChestContent.func_92080_a(StructureMineshaftPieces.func_78816_a(), new WeightedRandomChestContent[] {Item.field_92105_bW.func_92114_b(p_74875_2_)}), 3 + p_74875_2_.nextInt(4));
                }

                if (p_74875_2_.nextInt(100) == 0)
                {
                    this.func_74879_a(p_74875_1_, p_74875_3_, p_74875_2_, 0, 0, k + 1, WeightedRandomChestContent.func_92080_a(StructureMineshaftPieces.func_78816_a(), new WeightedRandomChestContent[] {Item.field_92105_bW.func_92114_b(p_74875_2_)}), 3 + p_74875_2_.nextInt(4));
                }

                if (this.field_74956_b && !this.field_74957_c)
                {
                    l = this.func_74862_a(0);
                    int i1 = k - 1 + p_74875_2_.nextInt(3);
                    int j1 = this.func_74865_a(1, i1);
                    i1 = this.func_74873_b(1, i1);

                    if (p_74875_3_.func_78890_b(j1, l, i1))
                    {
                        this.field_74957_c = true;
                        p_74875_1_.func_72832_d(j1, l, i1, Block.field_72065_as.field_71990_ca, 0, 2);
                        TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)p_74875_1_.func_72796_p(j1, l, i1);

                        if (tileentitymobspawner != null)
                        {
                            tileentitymobspawner.func_98049_a().func_98272_a("CaveSpider");
                        }
                    }
                }
            }

            for (j = 0; j <= 2; ++j)
            {
                for (k = 0; k <= i; ++k)
                {
                    l = this.func_74866_a(p_74875_1_, j, -1, k, p_74875_3_);

                    if (l == 0)
                    {
                        this.func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, j, -1, k, p_74875_3_);
                    }
                }
            }

            if (this.field_74958_a)
            {
                for (j = 0; j <= i; ++j)
                {
                    k = this.func_74866_a(p_74875_1_, 1, -1, j, p_74875_3_);

                    if (k > 0 && Block.field_71970_n[k])
                    {
                        this.func_74876_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.7F, 1, 0, j, Block.field_72056_aG.field_71990_ca, this.func_74863_c(Block.field_72056_aG.field_71990_ca, 0));
                    }
                }
            }

            return true;
        }
    }
}
