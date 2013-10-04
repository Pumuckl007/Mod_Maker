package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ComponentNetherBridgeEnd extends ComponentNetherBridgePiece
{
    private int field_74972_a;

    public ComponentNetherBridgeEnd() {}

    public ComponentNetherBridgeEnd(int p_i2043_1_, Random p_i2043_2_, StructureBoundingBox p_i2043_3_, int p_i2043_4_)
    {
        super(p_i2043_1_);
        this.field_74885_f = p_i2043_4_;
        this.field_74887_e = p_i2043_3_;
        this.field_74972_a = p_i2043_2_.nextInt();
    }

    public static ComponentNetherBridgeEnd func_74971_a(List p_74971_0_, Random p_74971_1_, int p_74971_2_, int p_74971_3_, int p_74971_4_, int p_74971_5_, int p_74971_6_)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_78889_a(p_74971_2_, p_74971_3_, p_74971_4_, -1, -3, 0, 5, 10, 8, p_74971_5_);
        return func_74964_a(structureboundingbox) && StructureComponent.func_74883_a(p_74971_0_, structureboundingbox) == null ? new ComponentNetherBridgeEnd(p_74971_6_, p_74971_1_, structureboundingbox, p_74971_5_) : null;
    }

    protected void func_143011_b(NBTTagCompound p_143011_1_)
    {
        super.func_143011_b(p_143011_1_);
        this.field_74972_a = p_143011_1_.func_74762_e("Seed");
    }

    protected void func_143012_a(NBTTagCompound p_143012_1_)
    {
        super.func_143012_a(p_143012_1_);
        p_143012_1_.func_74768_a("Seed", this.field_74972_a);
    }

    public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
    {
        Random random1 = new Random((long)this.field_74972_a);
        int i;
        int j;
        int k;

        for (i = 0; i <= 4; ++i)
        {
            for (j = 3; j <= 4; ++j)
            {
                k = random1.nextInt(8);
                this.func_74884_a(p_74875_1_, p_74875_3_, i, j, 0, i, j, k, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
            }
        }

        i = random1.nextInt(8);
        this.func_74884_a(p_74875_1_, p_74875_3_, 0, 5, 0, 0, 5, i, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        i = random1.nextInt(8);
        this.func_74884_a(p_74875_1_, p_74875_3_, 4, 5, 0, 4, 5, i, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);

        for (i = 0; i <= 4; ++i)
        {
            j = random1.nextInt(5);
            this.func_74884_a(p_74875_1_, p_74875_3_, i, 2, 0, i, 2, j, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        }

        for (i = 0; i <= 4; ++i)
        {
            for (j = 0; j <= 1; ++j)
            {
                k = random1.nextInt(3);
                this.func_74884_a(p_74875_1_, p_74875_3_, i, j, 0, i, j, k, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
            }
        }

        return true;
    }
}
