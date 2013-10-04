package net.minecraft.world.gen.structure;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.item.ItemDoor;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.util.Direction;
import net.minecraft.util.Facing;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;

public abstract class StructureComponent
{
    protected StructureBoundingBox field_74887_e;
    protected int field_74885_f;
    protected int field_74886_g;

    public StructureComponent() {}

    protected StructureComponent(int p_i2091_1_)
    {
        this.field_74886_g = p_i2091_1_;
        this.field_74885_f = -1;
    }

    public NBTTagCompound func_143010_b()
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        nbttagcompound.func_74778_a("id", MapGenStructureIO.func_143036_a(this));
        nbttagcompound.func_74782_a("BB", this.field_74887_e.func_143047_a("BB"));
        nbttagcompound.func_74768_a("O", this.field_74885_f);
        nbttagcompound.func_74768_a("GD", this.field_74886_g);
        this.func_143012_a(nbttagcompound);
        return nbttagcompound;
    }

    protected abstract void func_143012_a(NBTTagCompound nbttagcompound);

    public void func_143009_a(World p_143009_1_, NBTTagCompound p_143009_2_)
    {
        if (p_143009_2_.func_74764_b("BB"))
        {
            this.field_74887_e = new StructureBoundingBox(p_143009_2_.func_74759_k("BB"));
        }

        this.field_74885_f = p_143009_2_.func_74762_e("O");
        this.field_74886_g = p_143009_2_.func_74762_e("GD");
        this.func_143011_b(p_143009_2_);
    }

    protected abstract void func_143011_b(NBTTagCompound nbttagcompound);

    public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_) {}

    public abstract boolean func_74875_a(World world, Random random, StructureBoundingBox structureboundingbox);

    public StructureBoundingBox func_74874_b()
    {
        return this.field_74887_e;
    }

    public int func_74877_c()
    {
        return this.field_74886_g;
    }

    public static StructureComponent func_74883_a(List p_74883_0_, StructureBoundingBox p_74883_1_)
    {
        Iterator iterator = p_74883_0_.iterator();
        StructureComponent structurecomponent;

        do
        {
            if (!iterator.hasNext())
            {
                return null;
            }

            structurecomponent = (StructureComponent)iterator.next();
        }
        while (structurecomponent.func_74874_b() == null || !structurecomponent.func_74874_b().func_78884_a(p_74883_1_));

        return structurecomponent;
    }

    public ChunkPosition func_74868_a()
    {
        return new ChunkPosition(this.field_74887_e.func_78881_e(), this.field_74887_e.func_78879_f(), this.field_74887_e.func_78891_g());
    }

    protected boolean func_74860_a(World p_74860_1_, StructureBoundingBox p_74860_2_)
    {
        int i = Math.max(this.field_74887_e.field_78897_a - 1, p_74860_2_.field_78897_a);
        int j = Math.max(this.field_74887_e.field_78895_b - 1, p_74860_2_.field_78895_b);
        int k = Math.max(this.field_74887_e.field_78896_c - 1, p_74860_2_.field_78896_c);
        int l = Math.min(this.field_74887_e.field_78893_d + 1, p_74860_2_.field_78893_d);
        int i1 = Math.min(this.field_74887_e.field_78894_e + 1, p_74860_2_.field_78894_e);
        int j1 = Math.min(this.field_74887_e.field_78892_f + 1, p_74860_2_.field_78892_f);
        int k1;
        int l1;
        int i2;

        for (k1 = i; k1 <= l; ++k1)
        {
            for (l1 = k; l1 <= j1; ++l1)
            {
                i2 = p_74860_1_.func_72798_a(k1, j, l1);

                if (i2 > 0 && Block.field_71973_m[i2].field_72018_cp.func_76224_d())
                {
                    return true;
                }

                i2 = p_74860_1_.func_72798_a(k1, i1, l1);

                if (i2 > 0 && Block.field_71973_m[i2].field_72018_cp.func_76224_d())
                {
                    return true;
                }
            }
        }

        for (k1 = i; k1 <= l; ++k1)
        {
            for (l1 = j; l1 <= i1; ++l1)
            {
                i2 = p_74860_1_.func_72798_a(k1, l1, k);

                if (i2 > 0 && Block.field_71973_m[i2].field_72018_cp.func_76224_d())
                {
                    return true;
                }

                i2 = p_74860_1_.func_72798_a(k1, l1, j1);

                if (i2 > 0 && Block.field_71973_m[i2].field_72018_cp.func_76224_d())
                {
                    return true;
                }
            }
        }

        for (k1 = k; k1 <= j1; ++k1)
        {
            for (l1 = j; l1 <= i1; ++l1)
            {
                i2 = p_74860_1_.func_72798_a(i, l1, k1);

                if (i2 > 0 && Block.field_71973_m[i2].field_72018_cp.func_76224_d())
                {
                    return true;
                }

                i2 = p_74860_1_.func_72798_a(l, l1, k1);

                if (i2 > 0 && Block.field_71973_m[i2].field_72018_cp.func_76224_d())
                {
                    return true;
                }
            }
        }

        return false;
    }

    protected int func_74865_a(int p_74865_1_, int p_74865_2_)
    {
        switch (this.field_74885_f)
        {
            case 0:
            case 2:
                return this.field_74887_e.field_78897_a + p_74865_1_;
            case 1:
                return this.field_74887_e.field_78893_d - p_74865_2_;
            case 3:
                return this.field_74887_e.field_78897_a + p_74865_2_;
            default:
                return p_74865_1_;
        }
    }

    protected int func_74862_a(int p_74862_1_)
    {
        return this.field_74885_f == -1 ? p_74862_1_ : p_74862_1_ + this.field_74887_e.field_78895_b;
    }

    protected int func_74873_b(int p_74873_1_, int p_74873_2_)
    {
        switch (this.field_74885_f)
        {
            case 0:
                return this.field_74887_e.field_78896_c + p_74873_2_;
            case 1:
            case 3:
                return this.field_74887_e.field_78896_c + p_74873_1_;
            case 2:
                return this.field_74887_e.field_78892_f - p_74873_2_;
            default:
                return p_74873_2_;
        }
    }

    protected int func_74863_c(int p_74863_1_, int p_74863_2_)
    {
        if (p_74863_1_ == Block.field_72056_aG.field_71990_ca)
        {
            if (this.field_74885_f == 1 || this.field_74885_f == 3)
            {
                if (p_74863_2_ == 1)
                {
                    return 0;
                }

                return 1;
            }
        }
        else if (p_74863_1_ != Block.field_72054_aE.field_71990_ca && p_74863_1_ != Block.field_72045_aL.field_71990_ca)
        {
            if (p_74863_1_ != Block.field_72057_aH.field_71990_ca && p_74863_1_ != Block.field_72063_at.field_71990_ca && p_74863_1_ != Block.field_72100_bC.field_71990_ca && p_74863_1_ != Block.field_71995_bx.field_71990_ca && p_74863_1_ != Block.field_72088_bQ.field_71990_ca)
            {
                if (p_74863_1_ == Block.field_72055_aF.field_71990_ca)
                {
                    if (this.field_74885_f == 0)
                    {
                        if (p_74863_2_ == 2)
                        {
                            return 3;
                        }

                        if (p_74863_2_ == 3)
                        {
                            return 2;
                        }
                    }
                    else if (this.field_74885_f == 1)
                    {
                        if (p_74863_2_ == 2)
                        {
                            return 4;
                        }

                        if (p_74863_2_ == 3)
                        {
                            return 5;
                        }

                        if (p_74863_2_ == 4)
                        {
                            return 2;
                        }

                        if (p_74863_2_ == 5)
                        {
                            return 3;
                        }
                    }
                    else if (this.field_74885_f == 3)
                    {
                        if (p_74863_2_ == 2)
                        {
                            return 5;
                        }

                        if (p_74863_2_ == 3)
                        {
                            return 4;
                        }

                        if (p_74863_2_ == 4)
                        {
                            return 2;
                        }

                        if (p_74863_2_ == 5)
                        {
                            return 3;
                        }
                    }
                }
                else if (p_74863_1_ == Block.field_72034_aR.field_71990_ca)
                {
                    if (this.field_74885_f == 0)
                    {
                        if (p_74863_2_ == 3)
                        {
                            return 4;
                        }

                        if (p_74863_2_ == 4)
                        {
                            return 3;
                        }
                    }
                    else if (this.field_74885_f == 1)
                    {
                        if (p_74863_2_ == 3)
                        {
                            return 1;
                        }

                        if (p_74863_2_ == 4)
                        {
                            return 2;
                        }

                        if (p_74863_2_ == 2)
                        {
                            return 3;
                        }

                        if (p_74863_2_ == 1)
                        {
                            return 4;
                        }
                    }
                    else if (this.field_74885_f == 3)
                    {
                        if (p_74863_2_ == 3)
                        {
                            return 2;
                        }

                        if (p_74863_2_ == 4)
                        {
                            return 1;
                        }

                        if (p_74863_2_ == 2)
                        {
                            return 3;
                        }

                        if (p_74863_2_ == 1)
                        {
                            return 4;
                        }
                    }
                }
                else if (p_74863_1_ != Block.field_72064_bT.field_71990_ca && (Block.field_71973_m[p_74863_1_] == null || !(Block.field_71973_m[p_74863_1_] instanceof BlockDirectional)))
                {
                    if (p_74863_1_ == Block.field_71963_Z.field_71990_ca || p_74863_1_ == Block.field_71956_V.field_71990_ca || p_74863_1_ == Block.field_72043_aJ.field_71990_ca || p_74863_1_ == Block.field_71958_P.field_71990_ca)
                    {
                        if (this.field_74885_f == 0)
                        {
                            if (p_74863_2_ == 2 || p_74863_2_ == 3)
                            {
                                return Facing.field_71588_a[p_74863_2_];
                            }
                        }
                        else if (this.field_74885_f == 1)
                        {
                            if (p_74863_2_ == 2)
                            {
                                return 4;
                            }

                            if (p_74863_2_ == 3)
                            {
                                return 5;
                            }

                            if (p_74863_2_ == 4)
                            {
                                return 2;
                            }

                            if (p_74863_2_ == 5)
                            {
                                return 3;
                            }
                        }
                        else if (this.field_74885_f == 3)
                        {
                            if (p_74863_2_ == 2)
                            {
                                return 5;
                            }

                            if (p_74863_2_ == 3)
                            {
                                return 4;
                            }

                            if (p_74863_2_ == 4)
                            {
                                return 2;
                            }

                            if (p_74863_2_ == 5)
                            {
                                return 3;
                            }
                        }
                    }
                }
                else if (this.field_74885_f == 0)
                {
                    if (p_74863_2_ == 0 || p_74863_2_ == 2)
                    {
                        return Direction.field_71580_e[p_74863_2_];
                    }
                }
                else if (this.field_74885_f == 1)
                {
                    if (p_74863_2_ == 2)
                    {
                        return 1;
                    }

                    if (p_74863_2_ == 0)
                    {
                        return 3;
                    }

                    if (p_74863_2_ == 1)
                    {
                        return 2;
                    }

                    if (p_74863_2_ == 3)
                    {
                        return 0;
                    }
                }
                else if (this.field_74885_f == 3)
                {
                    if (p_74863_2_ == 2)
                    {
                        return 3;
                    }

                    if (p_74863_2_ == 0)
                    {
                        return 1;
                    }

                    if (p_74863_2_ == 1)
                    {
                        return 2;
                    }

                    if (p_74863_2_ == 3)
                    {
                        return 0;
                    }
                }
            }
            else if (this.field_74885_f == 0)
            {
                if (p_74863_2_ == 2)
                {
                    return 3;
                }

                if (p_74863_2_ == 3)
                {
                    return 2;
                }
            }
            else if (this.field_74885_f == 1)
            {
                if (p_74863_2_ == 0)
                {
                    return 2;
                }

                if (p_74863_2_ == 1)
                {
                    return 3;
                }

                if (p_74863_2_ == 2)
                {
                    return 0;
                }

                if (p_74863_2_ == 3)
                {
                    return 1;
                }
            }
            else if (this.field_74885_f == 3)
            {
                if (p_74863_2_ == 0)
                {
                    return 2;
                }

                if (p_74863_2_ == 1)
                {
                    return 3;
                }

                if (p_74863_2_ == 2)
                {
                    return 1;
                }

                if (p_74863_2_ == 3)
                {
                    return 0;
                }
            }
        }
        else if (this.field_74885_f == 0)
        {
            if (p_74863_2_ == 0)
            {
                return 2;
            }

            if (p_74863_2_ == 2)
            {
                return 0;
            }
        }
        else
        {
            if (this.field_74885_f == 1)
            {
                return p_74863_2_ + 1 & 3;
            }

            if (this.field_74885_f == 3)
            {
                return p_74863_2_ + 3 & 3;
            }
        }

        return p_74863_2_;
    }

    protected void func_74864_a(World p_74864_1_, int p_74864_2_, int p_74864_3_, int p_74864_4_, int p_74864_5_, int p_74864_6_, StructureBoundingBox p_74864_7_)
    {
        int j1 = this.func_74865_a(p_74864_4_, p_74864_6_);
        int k1 = this.func_74862_a(p_74864_5_);
        int l1 = this.func_74873_b(p_74864_4_, p_74864_6_);

        if (p_74864_7_.func_78890_b(j1, k1, l1))
        {
            p_74864_1_.func_72832_d(j1, k1, l1, p_74864_2_, p_74864_3_, 2);
        }
    }

    protected int func_74866_a(World p_74866_1_, int p_74866_2_, int p_74866_3_, int p_74866_4_, StructureBoundingBox p_74866_5_)
    {
        int l = this.func_74865_a(p_74866_2_, p_74866_4_);
        int i1 = this.func_74862_a(p_74866_3_);
        int j1 = this.func_74873_b(p_74866_2_, p_74866_4_);
        return !p_74866_5_.func_78890_b(l, i1, j1) ? 0 : p_74866_1_.func_72798_a(l, i1, j1);
    }

    protected void func_74878_a(World p_74878_1_, StructureBoundingBox p_74878_2_, int p_74878_3_, int p_74878_4_, int p_74878_5_, int p_74878_6_, int p_74878_7_, int p_74878_8_)
    {
        for (int k1 = p_74878_4_; k1 <= p_74878_7_; ++k1)
        {
            for (int l1 = p_74878_3_; l1 <= p_74878_6_; ++l1)
            {
                for (int i2 = p_74878_5_; i2 <= p_74878_8_; ++i2)
                {
                    this.func_74864_a(p_74878_1_, 0, 0, l1, k1, i2, p_74878_2_);
                }
            }
        }
    }

    protected void func_74884_a(World p_74884_1_, StructureBoundingBox p_74884_2_, int p_74884_3_, int p_74884_4_, int p_74884_5_, int p_74884_6_, int p_74884_7_, int p_74884_8_, int p_74884_9_, int p_74884_10_, boolean p_74884_11_)
    {
        for (int i2 = p_74884_4_; i2 <= p_74884_7_; ++i2)
        {
            for (int j2 = p_74884_3_; j2 <= p_74884_6_; ++j2)
            {
                for (int k2 = p_74884_5_; k2 <= p_74884_8_; ++k2)
                {
                    if (!p_74884_11_ || this.func_74866_a(p_74884_1_, j2, i2, k2, p_74884_2_) != 0)
                    {
                        if (i2 != p_74884_4_ && i2 != p_74884_7_ && j2 != p_74884_3_ && j2 != p_74884_6_ && k2 != p_74884_5_ && k2 != p_74884_8_)
                        {
                            this.func_74864_a(p_74884_1_, p_74884_10_, 0, j2, i2, k2, p_74884_2_);
                        }
                        else
                        {
                            this.func_74864_a(p_74884_1_, p_74884_9_, 0, j2, i2, k2, p_74884_2_);
                        }
                    }
                }
            }
        }
    }

    protected void func_74872_a(World p_74872_1_, StructureBoundingBox p_74872_2_, int p_74872_3_, int p_74872_4_, int p_74872_5_, int p_74872_6_, int p_74872_7_, int p_74872_8_, int p_74872_9_, int p_74872_10_, int p_74872_11_, int p_74872_12_, boolean p_74872_13_)
    {
        for (int k2 = p_74872_4_; k2 <= p_74872_7_; ++k2)
        {
            for (int l2 = p_74872_3_; l2 <= p_74872_6_; ++l2)
            {
                for (int i3 = p_74872_5_; i3 <= p_74872_8_; ++i3)
                {
                    if (!p_74872_13_ || this.func_74866_a(p_74872_1_, l2, k2, i3, p_74872_2_) != 0)
                    {
                        if (k2 != p_74872_4_ && k2 != p_74872_7_ && l2 != p_74872_3_ && l2 != p_74872_6_ && i3 != p_74872_5_ && i3 != p_74872_8_)
                        {
                            this.func_74864_a(p_74872_1_, p_74872_11_, p_74872_12_, l2, k2, i3, p_74872_2_);
                        }
                        else
                        {
                            this.func_74864_a(p_74872_1_, p_74872_9_, p_74872_10_, l2, k2, i3, p_74872_2_);
                        }
                    }
                }
            }
        }
    }

    protected void func_74882_a(World p_74882_1_, StructureBoundingBox p_74882_2_, int p_74882_3_, int p_74882_4_, int p_74882_5_, int p_74882_6_, int p_74882_7_, int p_74882_8_, boolean p_74882_9_, Random p_74882_10_, StructurePieceBlockSelector p_74882_11_)
    {
        for (int k1 = p_74882_4_; k1 <= p_74882_7_; ++k1)
        {
            for (int l1 = p_74882_3_; l1 <= p_74882_6_; ++l1)
            {
                for (int i2 = p_74882_5_; i2 <= p_74882_8_; ++i2)
                {
                    if (!p_74882_9_ || this.func_74866_a(p_74882_1_, l1, k1, i2, p_74882_2_) != 0)
                    {
                        p_74882_11_.func_75062_a(p_74882_10_, l1, k1, i2, k1 == p_74882_4_ || k1 == p_74882_7_ || l1 == p_74882_3_ || l1 == p_74882_6_ || i2 == p_74882_5_ || i2 == p_74882_8_);
                        this.func_74864_a(p_74882_1_, p_74882_11_.func_75063_a(), p_74882_11_.func_75064_b(), l1, k1, i2, p_74882_2_);
                    }
                }
            }
        }
    }

    protected void func_74880_a(World p_74880_1_, StructureBoundingBox p_74880_2_, Random p_74880_3_, float p_74880_4_, int p_74880_5_, int p_74880_6_, int p_74880_7_, int p_74880_8_, int p_74880_9_, int p_74880_10_, int p_74880_11_, int p_74880_12_, boolean p_74880_13_)
    {
        for (int i2 = p_74880_6_; i2 <= p_74880_9_; ++i2)
        {
            for (int j2 = p_74880_5_; j2 <= p_74880_8_; ++j2)
            {
                for (int k2 = p_74880_7_; k2 <= p_74880_10_; ++k2)
                {
                    if (p_74880_3_.nextFloat() <= p_74880_4_ && (!p_74880_13_ || this.func_74866_a(p_74880_1_, j2, i2, k2, p_74880_2_) != 0))
                    {
                        if (i2 != p_74880_6_ && i2 != p_74880_9_ && j2 != p_74880_5_ && j2 != p_74880_8_ && k2 != p_74880_7_ && k2 != p_74880_10_)
                        {
                            this.func_74864_a(p_74880_1_, p_74880_12_, 0, j2, i2, k2, p_74880_2_);
                        }
                        else
                        {
                            this.func_74864_a(p_74880_1_, p_74880_11_, 0, j2, i2, k2, p_74880_2_);
                        }
                    }
                }
            }
        }
    }

    protected void func_74876_a(World p_74876_1_, StructureBoundingBox p_74876_2_, Random p_74876_3_, float p_74876_4_, int p_74876_5_, int p_74876_6_, int p_74876_7_, int p_74876_8_, int p_74876_9_)
    {
        if (p_74876_3_.nextFloat() < p_74876_4_)
        {
            this.func_74864_a(p_74876_1_, p_74876_8_, p_74876_9_, p_74876_5_, p_74876_6_, p_74876_7_, p_74876_2_);
        }
    }

    protected void func_74867_a(World p_74867_1_, StructureBoundingBox p_74867_2_, int p_74867_3_, int p_74867_4_, int p_74867_5_, int p_74867_6_, int p_74867_7_, int p_74867_8_, int p_74867_9_, boolean p_74867_10_)
    {
        float f = (float)(p_74867_6_ - p_74867_3_ + 1);
        float f1 = (float)(p_74867_7_ - p_74867_4_ + 1);
        float f2 = (float)(p_74867_8_ - p_74867_5_ + 1);
        float f3 = (float)p_74867_3_ + f / 2.0F;
        float f4 = (float)p_74867_5_ + f2 / 2.0F;

        for (int l1 = p_74867_4_; l1 <= p_74867_7_; ++l1)
        {
            float f5 = (float)(l1 - p_74867_4_) / f1;

            for (int i2 = p_74867_3_; i2 <= p_74867_6_; ++i2)
            {
                float f6 = ((float)i2 - f3) / (f * 0.5F);

                for (int j2 = p_74867_5_; j2 <= p_74867_8_; ++j2)
                {
                    float f7 = ((float)j2 - f4) / (f2 * 0.5F);

                    if (!p_74867_10_ || this.func_74866_a(p_74867_1_, i2, l1, j2, p_74867_2_) != 0)
                    {
                        float f8 = f6 * f6 + f5 * f5 + f7 * f7;

                        if (f8 <= 1.05F)
                        {
                            this.func_74864_a(p_74867_1_, p_74867_9_, 0, i2, l1, j2, p_74867_2_);
                        }
                    }
                }
            }
        }
    }

    protected void func_74871_b(World p_74871_1_, int p_74871_2_, int p_74871_3_, int p_74871_4_, StructureBoundingBox p_74871_5_)
    {
        int l = this.func_74865_a(p_74871_2_, p_74871_4_);
        int i1 = this.func_74862_a(p_74871_3_);
        int j1 = this.func_74873_b(p_74871_2_, p_74871_4_);

        if (p_74871_5_.func_78890_b(l, i1, j1))
        {
            while (!p_74871_1_.func_72799_c(l, i1, j1) && i1 < 255)
            {
                p_74871_1_.func_72832_d(l, i1, j1, 0, 0, 2);
                ++i1;
            }
        }
    }

    protected void func_74870_b(World p_74870_1_, int p_74870_2_, int p_74870_3_, int p_74870_4_, int p_74870_5_, int p_74870_6_, StructureBoundingBox p_74870_7_)
    {
        int j1 = this.func_74865_a(p_74870_4_, p_74870_6_);
        int k1 = this.func_74862_a(p_74870_5_);
        int l1 = this.func_74873_b(p_74870_4_, p_74870_6_);

        if (p_74870_7_.func_78890_b(j1, k1, l1))
        {
            while ((p_74870_1_.func_72799_c(j1, k1, l1) || p_74870_1_.func_72803_f(j1, k1, l1).func_76224_d()) && k1 > 1)
            {
                p_74870_1_.func_72832_d(j1, k1, l1, p_74870_2_, p_74870_3_, 2);
                --k1;
            }
        }
    }

    protected boolean func_74879_a(World p_74879_1_, StructureBoundingBox p_74879_2_, Random p_74879_3_, int p_74879_4_, int p_74879_5_, int p_74879_6_, WeightedRandomChestContent[] p_74879_7_, int p_74879_8_)
    {
        int i1 = this.func_74865_a(p_74879_4_, p_74879_6_);
        int j1 = this.func_74862_a(p_74879_5_);
        int k1 = this.func_74873_b(p_74879_4_, p_74879_6_);

        if (p_74879_2_.func_78890_b(i1, j1, k1) && p_74879_1_.func_72798_a(i1, j1, k1) != Block.field_72077_au.field_71990_ca)
        {
            p_74879_1_.func_72832_d(i1, j1, k1, Block.field_72077_au.field_71990_ca, 0, 2);
            TileEntityChest tileentitychest = (TileEntityChest)p_74879_1_.func_72796_p(i1, j1, k1);

            if (tileentitychest != null)
            {
                WeightedRandomChestContent.func_76293_a(p_74879_3_, p_74879_7_, tileentitychest, p_74879_8_);
            }

            return true;
        }
        else
        {
            return false;
        }
    }

    protected boolean func_74869_a(World p_74869_1_, StructureBoundingBox p_74869_2_, Random p_74869_3_, int p_74869_4_, int p_74869_5_, int p_74869_6_, int p_74869_7_, WeightedRandomChestContent[] p_74869_8_, int p_74869_9_)
    {
        int j1 = this.func_74865_a(p_74869_4_, p_74869_6_);
        int k1 = this.func_74862_a(p_74869_5_);
        int l1 = this.func_74873_b(p_74869_4_, p_74869_6_);

        if (p_74869_2_.func_78890_b(j1, k1, l1) && p_74869_1_.func_72798_a(j1, k1, l1) != Block.field_71958_P.field_71990_ca)
        {
            p_74869_1_.func_72832_d(j1, k1, l1, Block.field_71958_P.field_71990_ca, this.func_74863_c(Block.field_71958_P.field_71990_ca, p_74869_7_), 2);
            TileEntityDispenser tileentitydispenser = (TileEntityDispenser)p_74869_1_.func_72796_p(j1, k1, l1);

            if (tileentitydispenser != null)
            {
                WeightedRandomChestContent.func_76294_a(p_74869_3_, p_74869_8_, tileentitydispenser, p_74869_9_);
            }

            return true;
        }
        else
        {
            return false;
        }
    }

    protected void func_74881_a(World p_74881_1_, StructureBoundingBox p_74881_2_, Random p_74881_3_, int p_74881_4_, int p_74881_5_, int p_74881_6_, int p_74881_7_)
    {
        int i1 = this.func_74865_a(p_74881_4_, p_74881_6_);
        int j1 = this.func_74862_a(p_74881_5_);
        int k1 = this.func_74873_b(p_74881_4_, p_74881_6_);

        if (p_74881_2_.func_78890_b(i1, j1, k1))
        {
            ItemDoor.func_77869_a(p_74881_1_, i1, j1, k1, p_74881_7_, Block.field_72054_aE);
        }
    }
}
