package net.minecraft.world.gen.structure;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class StructureVillageStart extends StructureStart
{
    private boolean field_75076_c;

    public StructureVillageStart() {}

    public StructureVillageStart(World p_i2092_1_, Random p_i2092_2_, int p_i2092_3_, int p_i2092_4_, int p_i2092_5_)
    {
        super(p_i2092_3_, p_i2092_4_);
        List list = StructureVillagePieces.func_75084_a(p_i2092_2_, p_i2092_5_);
        ComponentVillageStartPiece componentvillagestartpiece = new ComponentVillageStartPiece(p_i2092_1_.func_72959_q(), 0, p_i2092_2_, (p_i2092_3_ << 4) + 2, (p_i2092_4_ << 4) + 2, list, p_i2092_5_);
        this.field_75075_a.add(componentvillagestartpiece);
        componentvillagestartpiece.func_74861_a(componentvillagestartpiece, this.field_75075_a, p_i2092_2_);
        List list1 = componentvillagestartpiece.field_74930_j;
        List list2 = componentvillagestartpiece.field_74932_i;
        int l;

        while (!list1.isEmpty() || !list2.isEmpty())
        {
            StructureComponent structurecomponent;

            if (list1.isEmpty())
            {
                l = p_i2092_2_.nextInt(list2.size());
                structurecomponent = (StructureComponent)list2.remove(l);
                structurecomponent.func_74861_a(componentvillagestartpiece, this.field_75075_a, p_i2092_2_);
            }
            else
            {
                l = p_i2092_2_.nextInt(list1.size());
                structurecomponent = (StructureComponent)list1.remove(l);
                structurecomponent.func_74861_a(componentvillagestartpiece, this.field_75075_a, p_i2092_2_);
            }
        }

        this.func_75072_c();
        l = 0;
        Iterator iterator = this.field_75075_a.iterator();

        while (iterator.hasNext())
        {
            StructureComponent structurecomponent1 = (StructureComponent)iterator.next();

            if (!(structurecomponent1 instanceof ComponentVillageRoadPiece))
            {
                ++l;
            }
        }

        this.field_75076_c = l > 2;
    }

    public boolean func_75069_d()
    {
        return this.field_75076_c;
    }

    public void func_143022_a(NBTTagCompound p_143022_1_)
    {
        super.func_143022_a(p_143022_1_);
        p_143022_1_.func_74757_a("Valid", this.field_75076_c);
    }

    public void func_143017_b(NBTTagCompound nbttagcompound)
    {
        super.func_143017_b(nbttagcompound);
        this.field_75076_c = nbttagcompound.func_74767_n("Valid");
    }
}
