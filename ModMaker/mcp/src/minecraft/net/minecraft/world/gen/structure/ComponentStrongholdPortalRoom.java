package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.World;

public class ComponentStrongholdPortalRoom extends ComponentStronghold
{
    private boolean field_75005_a;

    public ComponentStrongholdPortalRoom() {}

    public ComponentStrongholdPortalRoom(int p_i2077_1_, Random p_i2077_2_, StructureBoundingBox p_i2077_3_, int p_i2077_4_)
    {
        super(p_i2077_1_);
        this.field_74885_f = p_i2077_4_;
        this.field_74887_e = p_i2077_3_;
    }

    protected void func_143012_a(NBTTagCompound p_143012_1_)
    {
        super.func_143012_a(p_143012_1_);
        p_143012_1_.func_74757_a("Mob", this.field_75005_a);
    }

    protected void func_143011_b(NBTTagCompound p_143011_1_)
    {
        super.func_143011_b(p_143011_1_);
        this.field_75005_a = p_143011_1_.func_74767_n("Mob");
    }

    public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
    {
        if (p_74861_1_ != null)
        {
            ((ComponentStrongholdStairs2)p_74861_1_).field_75025_b = this;
        }
    }

    public static ComponentStrongholdPortalRoom func_75004_a(List p_75004_0_, Random p_75004_1_, int p_75004_2_, int p_75004_3_, int p_75004_4_, int p_75004_5_, int p_75004_6_)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_78889_a(p_75004_2_, p_75004_3_, p_75004_4_, -4, -1, 0, 11, 8, 16, p_75004_5_);
        return func_74991_a(structureboundingbox) && StructureComponent.func_74883_a(p_75004_0_, structureboundingbox) == null ? new ComponentStrongholdPortalRoom(p_75004_6_, p_75004_1_, structureboundingbox, p_75004_5_) : null;
    }

    public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
    {
        this.func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 10, 7, 15, false, p_74875_2_, StructureStrongholdPieces.func_75197_b());
        this.func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, EnumDoor.GRATES, 4, 1, 0);
        byte b0 = 6;
        this.func_74882_a(p_74875_1_, p_74875_3_, 1, b0, 1, 1, b0, 14, false, p_74875_2_, StructureStrongholdPieces.func_75197_b());
        this.func_74882_a(p_74875_1_, p_74875_3_, 9, b0, 1, 9, b0, 14, false, p_74875_2_, StructureStrongholdPieces.func_75197_b());
        this.func_74882_a(p_74875_1_, p_74875_3_, 2, b0, 1, 8, b0, 2, false, p_74875_2_, StructureStrongholdPieces.func_75197_b());
        this.func_74882_a(p_74875_1_, p_74875_3_, 2, b0, 14, 8, b0, 14, false, p_74875_2_, StructureStrongholdPieces.func_75197_b());
        this.func_74882_a(p_74875_1_, p_74875_3_, 1, 1, 1, 2, 1, 4, false, p_74875_2_, StructureStrongholdPieces.func_75197_b());
        this.func_74882_a(p_74875_1_, p_74875_3_, 8, 1, 1, 9, 1, 4, false, p_74875_2_, StructureStrongholdPieces.func_75197_b());
        this.func_74884_a(p_74875_1_, p_74875_3_, 1, 1, 1, 1, 1, 3, Block.field_71944_C.field_71990_ca, Block.field_71944_C.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 9, 1, 1, 9, 1, 3, Block.field_71944_C.field_71990_ca, Block.field_71944_C.field_71990_ca, false);
        this.func_74882_a(p_74875_1_, p_74875_3_, 3, 1, 8, 7, 1, 12, false, p_74875_2_, StructureStrongholdPieces.func_75197_b());
        this.func_74884_a(p_74875_1_, p_74875_3_, 4, 1, 9, 6, 1, 11, Block.field_71944_C.field_71990_ca, Block.field_71944_C.field_71990_ca, false);
        int i;

        for (i = 3; i < 14; i += 2)
        {
            this.func_74884_a(p_74875_1_, p_74875_3_, 0, 3, i, 0, 4, i, Block.field_72002_bp.field_71990_ca, Block.field_72002_bp.field_71990_ca, false);
            this.func_74884_a(p_74875_1_, p_74875_3_, 10, 3, i, 10, 4, i, Block.field_72002_bp.field_71990_ca, Block.field_72002_bp.field_71990_ca, false);
        }

        for (i = 2; i < 9; i += 2)
        {
            this.func_74884_a(p_74875_1_, p_74875_3_, i, 3, 15, i, 4, 15, Block.field_72002_bp.field_71990_ca, Block.field_72002_bp.field_71990_ca, false);
        }

        i = this.func_74863_c(Block.field_71995_bx.field_71990_ca, 3);
        this.func_74882_a(p_74875_1_, p_74875_3_, 4, 1, 5, 6, 1, 7, false, p_74875_2_, StructureStrongholdPieces.func_75197_b());
        this.func_74882_a(p_74875_1_, p_74875_3_, 4, 2, 6, 6, 2, 7, false, p_74875_2_, StructureStrongholdPieces.func_75197_b());
        this.func_74882_a(p_74875_1_, p_74875_3_, 4, 3, 7, 6, 3, 7, false, p_74875_2_, StructureStrongholdPieces.func_75197_b());

        for (int j = 4; j <= 6; ++j)
        {
            this.func_74864_a(p_74875_1_, Block.field_71995_bx.field_71990_ca, i, j, 1, 4, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_71995_bx.field_71990_ca, i, j, 2, 5, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_71995_bx.field_71990_ca, i, j, 3, 6, p_74875_3_);
        }

        byte b1 = 2;
        byte b2 = 0;
        byte b3 = 3;
        byte b4 = 1;

        switch (this.field_74885_f)
        {
            case 0:
                b1 = 0;
                b2 = 2;
                break;
            case 1:
                b1 = 1;
                b2 = 3;
                b3 = 0;
                b4 = 2;
            case 2:
            default:
                break;
            case 3:
                b1 = 3;
                b2 = 1;
                b3 = 0;
                b4 = 2;
        }

        this.func_74864_a(p_74875_1_, Block.field_72104_bI.field_71990_ca, b1 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 4, 3, 8, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72104_bI.field_71990_ca, b1 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 5, 3, 8, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72104_bI.field_71990_ca, b1 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 6, 3, 8, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72104_bI.field_71990_ca, b2 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 4, 3, 12, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72104_bI.field_71990_ca, b2 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 5, 3, 12, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72104_bI.field_71990_ca, b2 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 6, 3, 12, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72104_bI.field_71990_ca, b3 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 3, 3, 9, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72104_bI.field_71990_ca, b3 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 3, 3, 10, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72104_bI.field_71990_ca, b3 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 3, 3, 11, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72104_bI.field_71990_ca, b4 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 7, 3, 9, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72104_bI.field_71990_ca, b4 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 7, 3, 10, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72104_bI.field_71990_ca, b4 + (p_74875_2_.nextFloat() > 0.9F ? 4 : 0), 7, 3, 11, p_74875_3_);

        if (!this.field_75005_a)
        {
            int k = this.func_74862_a(3);
            int l = this.func_74865_a(5, 6);
            int i1 = this.func_74873_b(5, 6);

            if (p_74875_3_.func_78890_b(l, k, i1))
            {
                this.field_75005_a = true;
                p_74875_1_.func_72832_d(l, k, i1, Block.field_72065_as.field_71990_ca, 0, 2);
                TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)p_74875_1_.func_72796_p(l, k, i1);

                if (tileentitymobspawner != null)
                {
                    tileentitymobspawner.func_98049_a().func_98272_a("Silverfish");
                }
            }
        }

        return true;
    }
}
