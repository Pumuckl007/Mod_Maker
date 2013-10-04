package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;
import net.minecraft.world.World;

public class StructureStrongholdStart extends StructureStart
{
    public StructureStrongholdStart() {}

    public StructureStrongholdStart(World p_i2067_1_, Random p_i2067_2_, int p_i2067_3_, int p_i2067_4_)
    {
        super(p_i2067_3_, p_i2067_4_);
        StructureStrongholdPieces.func_75198_a();
        ComponentStrongholdStairs2 componentstrongholdstairs2 = new ComponentStrongholdStairs2(0, p_i2067_2_, (p_i2067_3_ << 4) + 2, (p_i2067_4_ << 4) + 2);
        this.field_75075_a.add(componentstrongholdstairs2);
        componentstrongholdstairs2.func_74861_a(componentstrongholdstairs2, this.field_75075_a, p_i2067_2_);
        List list = componentstrongholdstairs2.field_75026_c;

        while (!list.isEmpty())
        {
            int k = p_i2067_2_.nextInt(list.size());
            StructureComponent structurecomponent = (StructureComponent)list.remove(k);
            structurecomponent.func_74861_a(componentstrongholdstairs2, this.field_75075_a, p_i2067_2_);
        }

        this.func_75072_c();
        this.func_75067_a(p_i2067_1_, p_i2067_2_, 10);
    }
}
