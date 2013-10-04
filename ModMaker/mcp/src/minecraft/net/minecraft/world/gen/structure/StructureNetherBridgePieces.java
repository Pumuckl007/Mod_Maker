package net.minecraft.world.gen.structure;

import java.util.List;
import java.util.Random;

public class StructureNetherBridgePieces
{
    private static final StructureNetherBridgePieceWeight[] field_78742_a = new StructureNetherBridgePieceWeight[] {new StructureNetherBridgePieceWeight(ComponentNetherBridgeStraight.class, 30, 0, true), new StructureNetherBridgePieceWeight(ComponentNetherBridgeCrossing3.class, 10, 4), new StructureNetherBridgePieceWeight(ComponentNetherBridgeCrossing.class, 10, 4), new StructureNetherBridgePieceWeight(ComponentNetherBridgeStairs.class, 10, 3), new StructureNetherBridgePieceWeight(ComponentNetherBridgeThrone.class, 5, 2), new StructureNetherBridgePieceWeight(ComponentNetherBridgeEntrance.class, 5, 1)};
    private static final StructureNetherBridgePieceWeight[] field_78741_b = new StructureNetherBridgePieceWeight[] {new StructureNetherBridgePieceWeight(ComponentNetherBridgeCorridor5.class, 25, 0, true), new StructureNetherBridgePieceWeight(ComponentNetherBridgeCrossing2.class, 15, 5), new StructureNetherBridgePieceWeight(ComponentNetherBridgeCorridor2.class, 5, 10), new StructureNetherBridgePieceWeight(ComponentNetherBridgeCorridor.class, 5, 10), new StructureNetherBridgePieceWeight(ComponentNetherBridgeCorridor3.class, 10, 3, true), new StructureNetherBridgePieceWeight(ComponentNetherBridgeCorridor4.class, 7, 2), new StructureNetherBridgePieceWeight(ComponentNetherBridgeNetherStalkRoom.class, 5, 2)};

    public static void func_143049_a()
    {
        MapGenStructureIO.func_143031_a(ComponentNetherBridgeCrossing3.class, "NeBCr");
        MapGenStructureIO.func_143031_a(ComponentNetherBridgeEnd.class, "NeBEF");
        MapGenStructureIO.func_143031_a(ComponentNetherBridgeStraight.class, "NeBS");
        MapGenStructureIO.func_143031_a(ComponentNetherBridgeCorridor3.class, "NeCCS");
        MapGenStructureIO.func_143031_a(ComponentNetherBridgeCorridor4.class, "NeCTB");
        MapGenStructureIO.func_143031_a(ComponentNetherBridgeEntrance.class, "NeCE");
        MapGenStructureIO.func_143031_a(ComponentNetherBridgeCrossing2.class, "NeSCSC");
        MapGenStructureIO.func_143031_a(ComponentNetherBridgeCorridor.class, "NeSCLT");
        MapGenStructureIO.func_143031_a(ComponentNetherBridgeCorridor5.class, "NeSC");
        MapGenStructureIO.func_143031_a(ComponentNetherBridgeCorridor2.class, "NeSCRT");
        MapGenStructureIO.func_143031_a(ComponentNetherBridgeNetherStalkRoom.class, "NeCSR");
        MapGenStructureIO.func_143031_a(ComponentNetherBridgeThrone.class, "NeMT");
        MapGenStructureIO.func_143031_a(ComponentNetherBridgeCrossing.class, "NeRC");
        MapGenStructureIO.func_143031_a(ComponentNetherBridgeStairs.class, "NeSR");
        MapGenStructureIO.func_143031_a(ComponentNetherBridgeStartPiece.class, "NeStart");
    }

    private static ComponentNetherBridgePiece func_78738_b(StructureNetherBridgePieceWeight p_78738_0_, List p_78738_1_, Random p_78738_2_, int p_78738_3_, int p_78738_4_, int p_78738_5_, int p_78738_6_, int p_78738_7_)
    {
        Class oclass = p_78738_0_.field_78828_a;
        Object object = null;

        if (oclass == ComponentNetherBridgeStraight.class)
        {
            object = ComponentNetherBridgeStraight.func_74983_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
        }
        else if (oclass == ComponentNetherBridgeCrossing3.class)
        {
            object = ComponentNetherBridgeCrossing3.func_74966_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
        }
        else if (oclass == ComponentNetherBridgeCrossing.class)
        {
            object = ComponentNetherBridgeCrossing.func_74974_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
        }
        else if (oclass == ComponentNetherBridgeStairs.class)
        {
            object = ComponentNetherBridgeStairs.func_74973_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
        }
        else if (oclass == ComponentNetherBridgeThrone.class)
        {
            object = ComponentNetherBridgeThrone.func_74975_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
        }
        else if (oclass == ComponentNetherBridgeEntrance.class)
        {
            object = ComponentNetherBridgeEntrance.func_74984_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
        }
        else if (oclass == ComponentNetherBridgeCorridor5.class)
        {
            object = ComponentNetherBridgeCorridor5.func_74981_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
        }
        else if (oclass == ComponentNetherBridgeCorridor2.class)
        {
            object = ComponentNetherBridgeCorridor2.func_74980_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
        }
        else if (oclass == ComponentNetherBridgeCorridor.class)
        {
            object = ComponentNetherBridgeCorridor.func_74978_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
        }
        else if (oclass == ComponentNetherBridgeCorridor3.class)
        {
            object = ComponentNetherBridgeCorridor3.func_74982_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
        }
        else if (oclass == ComponentNetherBridgeCorridor4.class)
        {
            object = ComponentNetherBridgeCorridor4.func_74985_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
        }
        else if (oclass == ComponentNetherBridgeCrossing2.class)
        {
            object = ComponentNetherBridgeCrossing2.func_74979_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
        }
        else if (oclass == ComponentNetherBridgeNetherStalkRoom.class)
        {
            object = ComponentNetherBridgeNetherStalkRoom.func_74977_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
        }

        return (ComponentNetherBridgePiece)object;
    }

    static ComponentNetherBridgePiece func_78740_a(StructureNetherBridgePieceWeight p_78740_0_, List p_78740_1_, Random p_78740_2_, int p_78740_3_, int p_78740_4_, int p_78740_5_, int p_78740_6_, int p_78740_7_)
    {
        return func_78738_b(p_78740_0_, p_78740_1_, p_78740_2_, p_78740_3_, p_78740_4_, p_78740_5_, p_78740_6_, p_78740_7_);
    }

    static StructureNetherBridgePieceWeight[] func_78739_a()
    {
        return field_78742_a;
    }

    static StructureNetherBridgePieceWeight[] func_78737_b()
    {
        return field_78741_b;
    }
}
