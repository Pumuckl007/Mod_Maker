package net.minecraft.world.gen.structure;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.world.World;

public class StructureNetherBridgeStart extends StructureStart
{
    public StructureNetherBridgeStart() {}

    public StructureNetherBridgeStart(World p_i2040_1_, Random p_i2040_2_, int p_i2040_3_, int p_i2040_4_)
    {
        super(p_i2040_3_, p_i2040_4_);
        ComponentNetherBridgeStartPiece componentnetherbridgestartpiece = new ComponentNetherBridgeStartPiece(p_i2040_2_, (p_i2040_3_ << 4) + 2, (p_i2040_4_ << 4) + 2);
        this.field_75075_a.add(componentnetherbridgestartpiece);
        componentnetherbridgestartpiece.func_74861_a(componentnetherbridgestartpiece, this.field_75075_a, p_i2040_2_);
        ArrayList arraylist = componentnetherbridgestartpiece.field_74967_d;

        while (!arraylist.isEmpty())
        {
            int k = p_i2040_2_.nextInt(arraylist.size());
            StructureComponent structurecomponent = (StructureComponent)arraylist.remove(k);
            structurecomponent.func_74861_a(componentnetherbridgestartpiece, this.field_75075_a, p_i2040_2_);
        }

        this.func_75072_c();
        this.func_75070_a(p_i2040_1_, p_i2040_2_, 48, 70);
    }
}
