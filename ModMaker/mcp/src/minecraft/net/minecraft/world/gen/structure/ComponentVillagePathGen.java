package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ComponentVillagePathGen extends ComponentVillageRoadPiece
{
    private int field_74934_a;

    public ComponentVillagePathGen() {}

    public ComponentVillagePathGen(ComponentVillageStartPiece p_i2105_1_, int p_i2105_2_, Random p_i2105_3_, StructureBoundingBox p_i2105_4_, int p_i2105_5_)
    {
        super(p_i2105_1_, p_i2105_2_);
        this.field_74885_f = p_i2105_5_;
        this.field_74887_e = p_i2105_4_;
        this.field_74934_a = Math.max(p_i2105_4_.func_78883_b(), p_i2105_4_.func_78880_d());
    }

    protected void func_143012_a(NBTTagCompound p_143012_1_)
    {
        super.func_143012_a(p_143012_1_);
        p_143012_1_.func_74768_a("Length", this.field_74934_a);
    }

    protected void func_143011_b(NBTTagCompound p_143011_1_)
    {
        super.func_143011_b(p_143011_1_);
        this.field_74934_a = p_143011_1_.func_74762_e("Length");
    }

    public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
    {
        boolean flag = false;
        int i;
        StructureComponent structurecomponent1;

        for (i = p_74861_3_.nextInt(5); i < this.field_74934_a - 8; i += 2 + p_74861_3_.nextInt(5))
        {
            structurecomponent1 = this.func_74891_a((ComponentVillageStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, 0, i);

            if (structurecomponent1 != null)
            {
                i += Math.max(structurecomponent1.field_74887_e.func_78883_b(), structurecomponent1.field_74887_e.func_78880_d());
                flag = true;
            }
        }

        for (i = p_74861_3_.nextInt(5); i < this.field_74934_a - 8; i += 2 + p_74861_3_.nextInt(5))
        {
            structurecomponent1 = this.func_74894_b((ComponentVillageStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, 0, i);

            if (structurecomponent1 != null)
            {
                i += Math.max(structurecomponent1.field_74887_e.func_78883_b(), structurecomponent1.field_74887_e.func_78880_d());
                flag = true;
            }
        }

        if (flag && p_74861_3_.nextInt(3) > 0)
        {
            switch (this.field_74885_f)
            {
                case 0:
                    StructureVillagePieces.func_75082_b((ComponentVillageStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f - 2, 1, this.func_74877_c());
                    break;
                case 1:
                    StructureVillagePieces.func_75082_b((ComponentVillageStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c - 1, 2, this.func_74877_c());
                    break;
                case 2:
                    StructureVillagePieces.func_75082_b((ComponentVillageStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c, 1, this.func_74877_c());
                    break;
                case 3:
                    StructureVillagePieces.func_75082_b((ComponentVillageStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d - 2, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c - 1, 2, this.func_74877_c());
            }
        }

        if (flag && p_74861_3_.nextInt(3) > 0)
        {
            switch (this.field_74885_f)
            {
                case 0:
                    StructureVillagePieces.func_75082_b((ComponentVillageStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f - 2, 3, this.func_74877_c());
                    break;
                case 1:
                    StructureVillagePieces.func_75082_b((ComponentVillageStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f + 1, 0, this.func_74877_c());
                    break;
                case 2:
                    StructureVillagePieces.func_75082_b((ComponentVillageStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c, 3, this.func_74877_c());
                    break;
                case 3:
                    StructureVillagePieces.func_75082_b((ComponentVillageStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d - 2, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f + 1, 0, this.func_74877_c());
            }
        }
    }

    public static StructureBoundingBox func_74933_a(ComponentVillageStartPiece p_74933_0_, List p_74933_1_, Random p_74933_2_, int p_74933_3_, int p_74933_4_, int p_74933_5_, int p_74933_6_)
    {
        for (int i1 = 7 * MathHelper.func_76136_a(p_74933_2_, 3, 5); i1 >= 7; i1 -= 7)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.func_78889_a(p_74933_3_, p_74933_4_, p_74933_5_, 0, 0, 0, 3, 3, i1, p_74933_6_);

            if (StructureComponent.func_74883_a(p_74933_1_, structureboundingbox) == null)
            {
                return structureboundingbox;
            }
        }

        return null;
    }

    public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
    {
        int i = this.func_74890_d(Block.field_71940_F.field_71990_ca, 0);

        for (int j = this.field_74887_e.field_78897_a; j <= this.field_74887_e.field_78893_d; ++j)
        {
            for (int k = this.field_74887_e.field_78896_c; k <= this.field_74887_e.field_78892_f; ++k)
            {
                if (p_74875_3_.func_78890_b(j, 64, k))
                {
                    int l = p_74875_1_.func_72825_h(j, k) - 1;
                    p_74875_1_.func_72832_d(j, l, k, i, 0, 2);
                }
            }
        }

        return true;
    }
}
