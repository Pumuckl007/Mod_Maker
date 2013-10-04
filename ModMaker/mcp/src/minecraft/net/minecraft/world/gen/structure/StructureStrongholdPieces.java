package net.minecraft.world.gen.structure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class StructureStrongholdPieces
{
    private static final StructureStrongholdPieceWeight[] field_75205_b = new StructureStrongholdPieceWeight[] {new StructureStrongholdPieceWeight(ComponentStrongholdStraight.class, 40, 0), new StructureStrongholdPieceWeight(ComponentStrongholdPrison.class, 5, 5), new StructureStrongholdPieceWeight(ComponentStrongholdLeftTurn.class, 20, 0), new StructureStrongholdPieceWeight(ComponentStrongholdRightTurn.class, 20, 0), new StructureStrongholdPieceWeight(ComponentStrongholdRoomCrossing.class, 10, 6), new StructureStrongholdPieceWeight(ComponentStrongholdStairsStraight.class, 5, 5), new StructureStrongholdPieceWeight(ComponentStrongholdStairs.class, 5, 5), new StructureStrongholdPieceWeight(ComponentStrongholdCrossing.class, 5, 4), new StructureStrongholdPieceWeight(ComponentStrongholdChestCorridor.class, 5, 4), new StructureStrongholdPieceWeight2(ComponentStrongholdLibrary.class, 10, 2), new StructureStrongholdPieceWeight3(ComponentStrongholdPortalRoom.class, 20, 1)};
    private static List field_75206_c;
    private static Class field_75203_d;
    static int field_75207_a;
    private static final StructureStrongholdStones field_75204_e = new StructureStrongholdStones((StructureStrongholdPieceWeight2)null);

    public static void func_143046_a()
    {
        MapGenStructureIO.func_143031_a(ComponentStrongholdChestCorridor.class, "SHCC");
        MapGenStructureIO.func_143031_a(ComponentStrongholdCorridor.class, "SHFC");
        MapGenStructureIO.func_143031_a(ComponentStrongholdCrossing.class, "SH5C");
        MapGenStructureIO.func_143031_a(ComponentStrongholdLeftTurn.class, "SHLT");
        MapGenStructureIO.func_143031_a(ComponentStrongholdLibrary.class, "SHLi");
        MapGenStructureIO.func_143031_a(ComponentStrongholdPortalRoom.class, "SHPR");
        MapGenStructureIO.func_143031_a(ComponentStrongholdPrison.class, "SHPH");
        MapGenStructureIO.func_143031_a(ComponentStrongholdRightTurn.class, "SHRT");
        MapGenStructureIO.func_143031_a(ComponentStrongholdRoomCrossing.class, "SHRC");
        MapGenStructureIO.func_143031_a(ComponentStrongholdStairs.class, "SHSD");
        MapGenStructureIO.func_143031_a(ComponentStrongholdStairs2.class, "SHStart");
        MapGenStructureIO.func_143031_a(ComponentStrongholdStraight.class, "SHS");
        MapGenStructureIO.func_143031_a(ComponentStrongholdStairsStraight.class, "SHSSD");
    }

    public static void func_75198_a()
    {
        field_75206_c = new ArrayList();
        StructureStrongholdPieceWeight[] astructurestrongholdpieceweight = field_75205_b;
        int i = astructurestrongholdpieceweight.length;

        for (int j = 0; j < i; ++j)
        {
            StructureStrongholdPieceWeight structurestrongholdpieceweight = astructurestrongholdpieceweight[j];
            structurestrongholdpieceweight.field_75193_c = 0;
            field_75206_c.add(structurestrongholdpieceweight);
        }

        field_75203_d = null;
    }

    private static boolean func_75202_c()
    {
        boolean flag = false;
        field_75207_a = 0;
        StructureStrongholdPieceWeight structurestrongholdpieceweight;

        for (Iterator iterator = field_75206_c.iterator(); iterator.hasNext(); field_75207_a += structurestrongholdpieceweight.field_75192_b)
        {
            structurestrongholdpieceweight = (StructureStrongholdPieceWeight)iterator.next();

            if (structurestrongholdpieceweight.field_75191_d > 0 && structurestrongholdpieceweight.field_75193_c < structurestrongholdpieceweight.field_75191_d)
            {
                flag = true;
            }
        }

        return flag;
    }

    private static ComponentStronghold func_75200_a(Class p_75200_0_, List p_75200_1_, Random p_75200_2_, int p_75200_3_, int p_75200_4_, int p_75200_5_, int p_75200_6_, int p_75200_7_)
    {
        Object object = null;

        if (p_75200_0_ == ComponentStrongholdStraight.class)
        {
            object = ComponentStrongholdStraight.func_75018_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
        }
        else if (p_75200_0_ == ComponentStrongholdPrison.class)
        {
            object = ComponentStrongholdPrison.func_75016_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
        }
        else if (p_75200_0_ == ComponentStrongholdLeftTurn.class)
        {
            object = ComponentStrongholdLeftTurn.func_75010_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
        }
        else if (p_75200_0_ == ComponentStrongholdRightTurn.class)
        {
            object = ComponentStrongholdRightTurn.func_75010_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
        }
        else if (p_75200_0_ == ComponentStrongholdRoomCrossing.class)
        {
            object = ComponentStrongholdRoomCrossing.func_75012_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
        }
        else if (p_75200_0_ == ComponentStrongholdStairsStraight.class)
        {
            object = ComponentStrongholdStairsStraight.func_75028_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
        }
        else if (p_75200_0_ == ComponentStrongholdStairs.class)
        {
            object = ComponentStrongholdStairs.func_75022_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
        }
        else if (p_75200_0_ == ComponentStrongholdCrossing.class)
        {
            object = ComponentStrongholdCrossing.func_74994_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
        }
        else if (p_75200_0_ == ComponentStrongholdChestCorridor.class)
        {
            object = ComponentStrongholdChestCorridor.func_75000_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
        }
        else if (p_75200_0_ == ComponentStrongholdLibrary.class)
        {
            object = ComponentStrongholdLibrary.func_75006_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
        }
        else if (p_75200_0_ == ComponentStrongholdPortalRoom.class)
        {
            object = ComponentStrongholdPortalRoom.func_75004_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
        }

        return (ComponentStronghold)object;
    }

    private static ComponentStronghold func_75201_b(ComponentStrongholdStairs2 p_75201_0_, List p_75201_1_, Random p_75201_2_, int p_75201_3_, int p_75201_4_, int p_75201_5_, int p_75201_6_, int p_75201_7_)
    {
        if (!func_75202_c())
        {
            return null;
        }
        else
        {
            if (field_75203_d != null)
            {
                ComponentStronghold componentstronghold = func_75200_a(field_75203_d, p_75201_1_, p_75201_2_, p_75201_3_, p_75201_4_, p_75201_5_, p_75201_6_, p_75201_7_);
                field_75203_d = null;

                if (componentstronghold != null)
                {
                    return componentstronghold;
                }
            }

            int j1 = 0;

            while (j1 < 5)
            {
                ++j1;
                int k1 = p_75201_2_.nextInt(field_75207_a);
                Iterator iterator = field_75206_c.iterator();

                while (iterator.hasNext())
                {
                    StructureStrongholdPieceWeight structurestrongholdpieceweight = (StructureStrongholdPieceWeight)iterator.next();
                    k1 -= structurestrongholdpieceweight.field_75192_b;

                    if (k1 < 0)
                    {
                        if (!structurestrongholdpieceweight.func_75189_a(p_75201_7_) || structurestrongholdpieceweight == p_75201_0_.field_75027_a)
                        {
                            break;
                        }

                        ComponentStronghold componentstronghold1 = func_75200_a(structurestrongholdpieceweight.field_75194_a, p_75201_1_, p_75201_2_, p_75201_3_, p_75201_4_, p_75201_5_, p_75201_6_, p_75201_7_);

                        if (componentstronghold1 != null)
                        {
                            ++structurestrongholdpieceweight.field_75193_c;
                            p_75201_0_.field_75027_a = structurestrongholdpieceweight;

                            if (!structurestrongholdpieceweight.func_75190_a())
                            {
                                field_75206_c.remove(structurestrongholdpieceweight);
                            }

                            return componentstronghold1;
                        }
                    }
                }
            }

            StructureBoundingBox structureboundingbox = ComponentStrongholdCorridor.func_74992_a(p_75201_1_, p_75201_2_, p_75201_3_, p_75201_4_, p_75201_5_, p_75201_6_);

            if (structureboundingbox != null && structureboundingbox.field_78895_b > 1)
            {
                return new ComponentStrongholdCorridor(p_75201_7_, p_75201_2_, structureboundingbox, p_75201_6_);
            }
            else
            {
                return null;
            }
        }
    }

    private static StructureComponent func_75196_c(ComponentStrongholdStairs2 p_75196_0_, List p_75196_1_, Random p_75196_2_, int p_75196_3_, int p_75196_4_, int p_75196_5_, int p_75196_6_, int p_75196_7_)
    {
        if (p_75196_7_ > 50)
        {
            return null;
        }
        else if (Math.abs(p_75196_3_ - p_75196_0_.func_74874_b().field_78897_a) <= 112 && Math.abs(p_75196_5_ - p_75196_0_.func_74874_b().field_78896_c) <= 112)
        {
            ComponentStronghold componentstronghold = func_75201_b(p_75196_0_, p_75196_1_, p_75196_2_, p_75196_3_, p_75196_4_, p_75196_5_, p_75196_6_, p_75196_7_ + 1);

            if (componentstronghold != null)
            {
                p_75196_1_.add(componentstronghold);
                p_75196_0_.field_75026_c.add(componentstronghold);
            }

            return componentstronghold;
        }
        else
        {
            return null;
        }
    }

    static StructureComponent func_75195_a(ComponentStrongholdStairs2 p_75195_0_, List p_75195_1_, Random p_75195_2_, int p_75195_3_, int p_75195_4_, int p_75195_5_, int p_75195_6_, int p_75195_7_)
    {
        return func_75196_c(p_75195_0_, p_75195_1_, p_75195_2_, p_75195_3_, p_75195_4_, p_75195_5_, p_75195_6_, p_75195_7_);
    }

    static Class func_75199_a(Class p_75199_0_)
    {
        field_75203_d = p_75199_0_;
        return p_75199_0_;
    }

    static StructureStrongholdStones func_75197_b()
    {
        return field_75204_e;
    }
}
