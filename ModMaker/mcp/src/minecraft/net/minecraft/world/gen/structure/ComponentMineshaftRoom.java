package net.minecraft.world.gen.structure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagIntArray;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;

public class ComponentMineshaftRoom extends StructureComponent
{
    private List field_74949_a = new LinkedList();

    public ComponentMineshaftRoom() {}

    public ComponentMineshaftRoom(int p_i2037_1_, Random p_i2037_2_, int p_i2037_3_, int p_i2037_4_)
    {
        super(p_i2037_1_);
        this.field_74887_e = new StructureBoundingBox(p_i2037_3_, 50, p_i2037_4_, p_i2037_3_ + 7 + p_i2037_2_.nextInt(6), 54 + p_i2037_2_.nextInt(6), p_i2037_4_ + 7 + p_i2037_2_.nextInt(6));
    }

    public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
    {
        int i = this.func_74877_c();
        int j = this.field_74887_e.func_78882_c() - 3 - 1;

        if (j <= 0)
        {
            j = 1;
        }

        int k;
        StructureComponent structurecomponent1;
        StructureBoundingBox structureboundingbox;

        for (k = 0; k < this.field_74887_e.func_78883_b(); k += 4)
        {
            k += p_74861_3_.nextInt(this.field_74887_e.func_78883_b());

            if (k + 3 > this.field_74887_e.func_78883_b())
            {
                break;
            }

            structurecomponent1 = StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a + k, this.field_74887_e.field_78895_b + p_74861_3_.nextInt(j) + 1, this.field_74887_e.field_78896_c - 1, 2, i);

            if (structurecomponent1 != null)
            {
                structureboundingbox = structurecomponent1.func_74874_b();
                this.field_74949_a.add(new StructureBoundingBox(structureboundingbox.field_78897_a, structureboundingbox.field_78895_b, this.field_74887_e.field_78896_c, structureboundingbox.field_78893_d, structureboundingbox.field_78894_e, this.field_74887_e.field_78896_c + 1));
            }
        }

        for (k = 0; k < this.field_74887_e.func_78883_b(); k += 4)
        {
            k += p_74861_3_.nextInt(this.field_74887_e.func_78883_b());

            if (k + 3 > this.field_74887_e.func_78883_b())
            {
                break;
            }

            structurecomponent1 = StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a + k, this.field_74887_e.field_78895_b + p_74861_3_.nextInt(j) + 1, this.field_74887_e.field_78892_f + 1, 0, i);

            if (structurecomponent1 != null)
            {
                structureboundingbox = structurecomponent1.func_74874_b();
                this.field_74949_a.add(new StructureBoundingBox(structureboundingbox.field_78897_a, structureboundingbox.field_78895_b, this.field_74887_e.field_78892_f - 1, structureboundingbox.field_78893_d, structureboundingbox.field_78894_e, this.field_74887_e.field_78892_f));
            }
        }

        for (k = 0; k < this.field_74887_e.func_78880_d(); k += 4)
        {
            k += p_74861_3_.nextInt(this.field_74887_e.func_78880_d());

            if (k + 3 > this.field_74887_e.func_78880_d())
            {
                break;
            }

            structurecomponent1 = StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78897_a - 1, this.field_74887_e.field_78895_b + p_74861_3_.nextInt(j) + 1, this.field_74887_e.field_78896_c + k, 1, i);

            if (structurecomponent1 != null)
            {
                structureboundingbox = structurecomponent1.func_74874_b();
                this.field_74949_a.add(new StructureBoundingBox(this.field_74887_e.field_78897_a, structureboundingbox.field_78895_b, structureboundingbox.field_78896_c, this.field_74887_e.field_78897_a + 1, structureboundingbox.field_78894_e, structureboundingbox.field_78892_f));
            }
        }

        for (k = 0; k < this.field_74887_e.func_78880_d(); k += 4)
        {
            k += p_74861_3_.nextInt(this.field_74887_e.func_78880_d());

            if (k + 3 > this.field_74887_e.func_78880_d())
            {
                break;
            }

            structurecomponent1 = StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, this.field_74887_e.field_78893_d + 1, this.field_74887_e.field_78895_b + p_74861_3_.nextInt(j) + 1, this.field_74887_e.field_78896_c + k, 3, i);

            if (structurecomponent1 != null)
            {
                structureboundingbox = structurecomponent1.func_74874_b();
                this.field_74949_a.add(new StructureBoundingBox(this.field_74887_e.field_78893_d - 1, structureboundingbox.field_78895_b, structureboundingbox.field_78896_c, this.field_74887_e.field_78893_d, structureboundingbox.field_78894_e, structureboundingbox.field_78892_f));
            }
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
            this.func_74884_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c, this.field_74887_e.field_78893_d, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f, Block.field_71979_v.field_71990_ca, 0, true);
            this.func_74884_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b + 1, this.field_74887_e.field_78896_c, this.field_74887_e.field_78893_d, Math.min(this.field_74887_e.field_78895_b + 3, this.field_74887_e.field_78894_e), this.field_74887_e.field_78892_f, 0, 0, false);
            Iterator iterator = this.field_74949_a.iterator();

            while (iterator.hasNext())
            {
                StructureBoundingBox structureboundingbox1 = (StructureBoundingBox)iterator.next();
                this.func_74884_a(p_74875_1_, p_74875_3_, structureboundingbox1.field_78897_a, structureboundingbox1.field_78894_e - 2, structureboundingbox1.field_78896_c, structureboundingbox1.field_78893_d, structureboundingbox1.field_78894_e, structureboundingbox1.field_78892_f, 0, 0, false);
            }

            this.func_74867_a(p_74875_1_, p_74875_3_, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b + 4, this.field_74887_e.field_78896_c, this.field_74887_e.field_78893_d, this.field_74887_e.field_78894_e, this.field_74887_e.field_78892_f, 0, false);
            return true;
        }
    }

    protected void func_143012_a(NBTTagCompound p_143012_1_)
    {
        NBTTagList nbttaglist = new NBTTagList("Entrances");
        Iterator iterator = this.field_74949_a.iterator();

        while (iterator.hasNext())
        {
            StructureBoundingBox structureboundingbox = (StructureBoundingBox)iterator.next();
            nbttaglist.func_74742_a(structureboundingbox.func_143047_a(""));
        }

        p_143012_1_.func_74782_a("Entrances", nbttaglist);
    }

    protected void func_143011_b(NBTTagCompound p_143011_1_)
    {
        NBTTagList nbttaglist = p_143011_1_.func_74761_m("Entrances");

        for (int i = 0; i < nbttaglist.func_74745_c(); ++i)
        {
            this.field_74949_a.add(new StructureBoundingBox(((NBTTagIntArray)nbttaglist.func_74743_b(i)).field_74749_a));
        }
    }
}
