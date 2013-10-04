package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public abstract class ComponentVillage extends StructureComponent
{
    protected int field_143015_k = -1;
    private int field_74896_a;
    private boolean field_143014_b;

    public ComponentVillage() {}

    protected ComponentVillage(ComponentVillageStartPiece p_i2107_1_, int p_i2107_2_)
    {
        super(p_i2107_2_);

        if (p_i2107_1_ != null)
        {
            this.field_143014_b = p_i2107_1_.field_74927_b;
        }
    }

    protected void func_143012_a(NBTTagCompound p_143012_1_)
    {
        p_143012_1_.func_74768_a("HPos", this.field_143015_k);
        p_143012_1_.func_74768_a("VCount", this.field_74896_a);
        p_143012_1_.func_74757_a("Desert", this.field_143014_b);
    }

    protected void func_143011_b(NBTTagCompound p_143011_1_)
    {
        this.field_143015_k = p_143011_1_.func_74762_e("HPos");
        this.field_74896_a = p_143011_1_.func_74762_e("VCount");
        this.field_143014_b = p_143011_1_.func_74767_n("Desert");
    }

    protected StructureComponent func_74891_a(ComponentVillageStartPiece p_74891_1_, List p_74891_2_, Random p_74891_3_, int p_74891_4_, int p_74891_5_)
    {
        switch (this.field_74885_f)
        {
            case 0:
                return StructureVillagePieces.func_75078_a(p_74891_1_, p_74891_2_, p_74891_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b + p_74891_4_, this.field_74887_e.field_78896_c + p_74891_5_, 1, this.func_74877_c());
            case 1:
                return StructureVillagePieces.func_75078_a(p_74891_1_, p_74891_2_, p_74891_3_, this.field_74887_e.field_78897_a + p_74891_5_, this.field_74887_e.field_78895_b + p_74891_4_, this.field_74887_e.field_78896_c - 1, 2, this.func_74877_c());
            case 2:
                return StructureVillagePieces.func_75078_a(p_74891_1_, p_74891_2_, p_74891_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b + p_74891_4_, this.field_74887_e.field_78896_c + p_74891_5_, 1, this.func_74877_c());
            case 3:
                return StructureVillagePieces.func_75078_a(p_74891_1_, p_74891_2_, p_74891_3_, this.field_74887_e.field_78897_a + p_74891_5_, this.field_74887_e.field_78895_b + p_74891_4_, this.field_74887_e.field_78896_c - 1, 2, this.func_74877_c());
            default:
                return null;
        }
    }

    protected StructureComponent func_74894_b(ComponentVillageStartPiece p_74894_1_, List p_74894_2_, Random p_74894_3_, int p_74894_4_, int p_74894_5_)
    {
        switch (this.field_74885_f)
        {
            case 0:
                return StructureVillagePieces.func_75078_a(p_74894_1_, p_74894_2_, p_74894_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b + p_74894_4_, this.field_74887_e.field_78896_c + p_74894_5_, 3, this.func_74877_c());
            case 1:
                return StructureVillagePieces.func_75078_a(p_74894_1_, p_74894_2_, p_74894_3_, this.field_74887_e.field_78897_a + p_74894_5_, this.field_74887_e.field_78895_b + p_74894_4_, this.field_74887_e.field_78892_f + 1, 0, this.func_74877_c());
            case 2:
                return StructureVillagePieces.func_75078_a(p_74894_1_, p_74894_2_, p_74894_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b + p_74894_4_, this.field_74887_e.field_78896_c + p_74894_5_, 3, this.func_74877_c());
            case 3:
                return StructureVillagePieces.func_75078_a(p_74894_1_, p_74894_2_, p_74894_3_, this.field_74887_e.field_78897_a + p_74894_5_, this.field_74887_e.field_78895_b + p_74894_4_, this.field_74887_e.field_78892_f + 1, 0, this.func_74877_c());
            default:
                return null;
        }
    }

    protected int func_74889_b(World p_74889_1_, StructureBoundingBox p_74889_2_)
    {
        int i = 0;
        int j = 0;

        for (int k = this.field_74887_e.field_78896_c; k <= this.field_74887_e.field_78892_f; ++k)
        {
            for (int l = this.field_74887_e.field_78897_a; l <= this.field_74887_e.field_78893_d; ++l)
            {
                if (p_74889_2_.func_78890_b(l, 64, k))
                {
                    i += Math.max(p_74889_1_.func_72825_h(l, k), p_74889_1_.field_73011_w.func_76557_i());
                    ++j;
                }
            }
        }

        if (j == 0)
        {
            return -1;
        }
        else
        {
            return i / j;
        }
    }

    protected static boolean func_74895_a(StructureBoundingBox p_74895_0_)
    {
        return p_74895_0_ != null && p_74895_0_.field_78895_b > 10;
    }

    protected void func_74893_a(World p_74893_1_, StructureBoundingBox p_74893_2_, int p_74893_3_, int p_74893_4_, int p_74893_5_, int p_74893_6_)
    {
        if (this.field_74896_a < p_74893_6_)
        {
            for (int i1 = this.field_74896_a; i1 < p_74893_6_; ++i1)
            {
                int j1 = this.func_74865_a(p_74893_3_ + i1, p_74893_5_);
                int k1 = this.func_74862_a(p_74893_4_);
                int l1 = this.func_74873_b(p_74893_3_ + i1, p_74893_5_);

                if (!p_74893_2_.func_78890_b(j1, k1, l1))
                {
                    break;
                }

                ++this.field_74896_a;
                EntityVillager entityvillager = new EntityVillager(p_74893_1_, this.func_74888_b(i1));
                entityvillager.func_70012_b((double)j1 + 0.5D, (double)k1, (double)l1 + 0.5D, 0.0F, 0.0F);
                p_74893_1_.func_72838_d(entityvillager);
            }
        }
    }

    protected int func_74888_b(int p_74888_1_)
    {
        return 0;
    }

    protected int func_74890_d(int p_74890_1_, int p_74890_2_)
    {
        if (this.field_143014_b)
        {
            if (p_74890_1_ == Block.field_71951_J.field_71990_ca)
            {
                return Block.field_71957_Q.field_71990_ca;
            }

            if (p_74890_1_ == Block.field_71978_w.field_71990_ca)
            {
                return Block.field_71957_Q.field_71990_ca;
            }

            if (p_74890_1_ == Block.field_71988_x.field_71990_ca)
            {
                return Block.field_71957_Q.field_71990_ca;
            }

            if (p_74890_1_ == Block.field_72063_at.field_71990_ca)
            {
                return Block.field_72088_bQ.field_71990_ca;
            }

            if (p_74890_1_ == Block.field_72057_aH.field_71990_ca)
            {
                return Block.field_72088_bQ.field_71990_ca;
            }

            if (p_74890_1_ == Block.field_71940_F.field_71990_ca)
            {
                return Block.field_71957_Q.field_71990_ca;
            }
        }

        return p_74890_1_;
    }

    protected int func_74892_e(int p_74892_1_, int p_74892_2_)
    {
        if (this.field_143014_b)
        {
            if (p_74892_1_ == Block.field_71951_J.field_71990_ca)
            {
                return 0;
            }

            if (p_74892_1_ == Block.field_71978_w.field_71990_ca)
            {
                return 0;
            }

            if (p_74892_1_ == Block.field_71988_x.field_71990_ca)
            {
                return 2;
            }
        }

        return p_74892_2_;
    }

    protected void func_74864_a(World p_74864_1_, int p_74864_2_, int p_74864_3_, int p_74864_4_, int p_74864_5_, int p_74864_6_, StructureBoundingBox p_74864_7_)
    {
        int j1 = this.func_74890_d(p_74864_2_, p_74864_3_);
        int k1 = this.func_74892_e(p_74864_2_, p_74864_3_);
        super.func_74864_a(p_74864_1_, j1, k1, p_74864_4_, p_74864_5_, p_74864_6_, p_74864_7_);
    }

    protected void func_74884_a(World p_74884_1_, StructureBoundingBox p_74884_2_, int p_74884_3_, int p_74884_4_, int p_74884_5_, int p_74884_6_, int p_74884_7_, int p_74884_8_, int p_74884_9_, int p_74884_10_, boolean p_74884_11_)
    {
        int i2 = this.func_74890_d(p_74884_9_, 0);
        int j2 = this.func_74892_e(p_74884_9_, 0);
        int k2 = this.func_74890_d(p_74884_10_, 0);
        int l2 = this.func_74892_e(p_74884_10_, 0);
        super.func_74872_a(p_74884_1_, p_74884_2_, p_74884_3_, p_74884_4_, p_74884_5_, p_74884_6_, p_74884_7_, p_74884_8_, i2, j2, k2, l2, p_74884_11_);
    }

    protected void func_74870_b(World p_74870_1_, int p_74870_2_, int p_74870_3_, int p_74870_4_, int p_74870_5_, int p_74870_6_, StructureBoundingBox p_74870_7_)
    {
        int j1 = this.func_74890_d(p_74870_2_, p_74870_3_);
        int k1 = this.func_74892_e(p_74870_2_, p_74870_3_);
        super.func_74870_b(p_74870_1_, j1, k1, p_74870_4_, p_74870_5_, p_74870_6_, p_74870_7_);
    }
}
