package net.minecraft.world.gen.structure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.util.MathHelper;

public class StructureVillagePieces
{
    public static void func_143016_a()
    {
        MapGenStructureIO.func_143031_a(ComponentVillageHouse1.class, "ViBH");
        MapGenStructureIO.func_143031_a(ComponentVillageField.class, "ViDF");
        MapGenStructureIO.func_143031_a(ComponentVillageField2.class, "ViF");
        MapGenStructureIO.func_143031_a(ComponentVillageTorch.class, "ViL");
        MapGenStructureIO.func_143031_a(ComponentVillageHall.class, "ViPH");
        MapGenStructureIO.func_143031_a(ComponentVillageHouse4_Garden.class, "ViSH");
        MapGenStructureIO.func_143031_a(ComponentVillageWoodHut.class, "ViSmH");
        MapGenStructureIO.func_143031_a(ComponentVillageChurch.class, "ViST");
        MapGenStructureIO.func_143031_a(ComponentVillageHouse2.class, "ViS");
        MapGenStructureIO.func_143031_a(ComponentVillageStartPiece.class, "ViStart");
        MapGenStructureIO.func_143031_a(ComponentVillagePathGen.class, "ViSR");
        MapGenStructureIO.func_143031_a(ComponentVillageHouse3.class, "ViTRH");
        MapGenStructureIO.func_143031_a(ComponentVillageWell.class, "ViW");
    }

    public static List func_75084_a(Random p_75084_0_, int p_75084_1_)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new StructureVillagePieceWeight(ComponentVillageHouse4_Garden.class, 4, MathHelper.func_76136_a(p_75084_0_, 2 + p_75084_1_, 4 + p_75084_1_ * 2)));
        arraylist.add(new StructureVillagePieceWeight(ComponentVillageChurch.class, 20, MathHelper.func_76136_a(p_75084_0_, 0 + p_75084_1_, 1 + p_75084_1_)));
        arraylist.add(new StructureVillagePieceWeight(ComponentVillageHouse1.class, 20, MathHelper.func_76136_a(p_75084_0_, 0 + p_75084_1_, 2 + p_75084_1_)));
        arraylist.add(new StructureVillagePieceWeight(ComponentVillageWoodHut.class, 3, MathHelper.func_76136_a(p_75084_0_, 2 + p_75084_1_, 5 + p_75084_1_ * 3)));
        arraylist.add(new StructureVillagePieceWeight(ComponentVillageHall.class, 15, MathHelper.func_76136_a(p_75084_0_, 0 + p_75084_1_, 2 + p_75084_1_)));
        arraylist.add(new StructureVillagePieceWeight(ComponentVillageField.class, 3, MathHelper.func_76136_a(p_75084_0_, 1 + p_75084_1_, 4 + p_75084_1_)));
        arraylist.add(new StructureVillagePieceWeight(ComponentVillageField2.class, 3, MathHelper.func_76136_a(p_75084_0_, 2 + p_75084_1_, 4 + p_75084_1_ * 2)));
        arraylist.add(new StructureVillagePieceWeight(ComponentVillageHouse2.class, 15, MathHelper.func_76136_a(p_75084_0_, 0, 1 + p_75084_1_)));
        arraylist.add(new StructureVillagePieceWeight(ComponentVillageHouse3.class, 8, MathHelper.func_76136_a(p_75084_0_, 0 + p_75084_1_, 3 + p_75084_1_ * 2)));
        Iterator iterator = arraylist.iterator();

        while (iterator.hasNext())
        {
            if (((StructureVillagePieceWeight)iterator.next()).field_75087_d == 0)
            {
                iterator.remove();
            }
        }

        return arraylist;
    }

    private static int func_75079_a(List p_75079_0_)
    {
        boolean flag = false;
        int i = 0;
        StructureVillagePieceWeight structurevillagepieceweight;

        for (Iterator iterator = p_75079_0_.iterator(); iterator.hasNext(); i += structurevillagepieceweight.field_75088_b)
        {
            structurevillagepieceweight = (StructureVillagePieceWeight)iterator.next();

            if (structurevillagepieceweight.field_75087_d > 0 && structurevillagepieceweight.field_75089_c < structurevillagepieceweight.field_75087_d)
            {
                flag = true;
            }
        }

        return flag ? i : -1;
    }

    private static ComponentVillage func_75083_a(ComponentVillageStartPiece p_75083_0_, StructureVillagePieceWeight p_75083_1_, List p_75083_2_, Random p_75083_3_, int p_75083_4_, int p_75083_5_, int p_75083_6_, int p_75083_7_, int p_75083_8_)
    {
        Class oclass = p_75083_1_.field_75090_a;
        Object object = null;

        if (oclass == ComponentVillageHouse4_Garden.class)
        {
            object = ComponentVillageHouse4_Garden.func_74912_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
        }
        else if (oclass == ComponentVillageChurch.class)
        {
            object = ComponentVillageChurch.func_74919_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
        }
        else if (oclass == ComponentVillageHouse1.class)
        {
            object = ComponentVillageHouse1.func_74898_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
        }
        else if (oclass == ComponentVillageWoodHut.class)
        {
            object = ComponentVillageWoodHut.func_74908_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
        }
        else if (oclass == ComponentVillageHall.class)
        {
            object = ComponentVillageHall.func_74906_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
        }
        else if (oclass == ComponentVillageField.class)
        {
            object = ComponentVillageField.func_74900_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
        }
        else if (oclass == ComponentVillageField2.class)
        {
            object = ComponentVillageField2.func_74902_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
        }
        else if (oclass == ComponentVillageHouse2.class)
        {
            object = ComponentVillageHouse2.func_74915_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
        }
        else if (oclass == ComponentVillageHouse3.class)
        {
            object = ComponentVillageHouse3.func_74921_a(p_75083_0_, p_75083_2_, p_75083_3_, p_75083_4_, p_75083_5_, p_75083_6_, p_75083_7_, p_75083_8_);
        }

        return (ComponentVillage)object;
    }

    private static ComponentVillage func_75081_c(ComponentVillageStartPiece p_75081_0_, List p_75081_1_, Random p_75081_2_, int p_75081_3_, int p_75081_4_, int p_75081_5_, int p_75081_6_, int p_75081_7_)
    {
        int j1 = func_75079_a(p_75081_0_.field_74931_h);

        if (j1 <= 0)
        {
            return null;
        }
        else
        {
            int k1 = 0;

            while (k1 < 5)
            {
                ++k1;
                int l1 = p_75081_2_.nextInt(j1);
                Iterator iterator = p_75081_0_.field_74931_h.iterator();

                while (iterator.hasNext())
                {
                    StructureVillagePieceWeight structurevillagepieceweight = (StructureVillagePieceWeight)iterator.next();
                    l1 -= structurevillagepieceweight.field_75088_b;

                    if (l1 < 0)
                    {
                        if (!structurevillagepieceweight.func_75085_a(p_75081_7_) || structurevillagepieceweight == p_75081_0_.field_74926_d && p_75081_0_.field_74931_h.size() > 1)
                        {
                            break;
                        }

                        ComponentVillage componentvillage = func_75083_a(p_75081_0_, structurevillagepieceweight, p_75081_1_, p_75081_2_, p_75081_3_, p_75081_4_, p_75081_5_, p_75081_6_, p_75081_7_);

                        if (componentvillage != null)
                        {
                            ++structurevillagepieceweight.field_75089_c;
                            p_75081_0_.field_74926_d = structurevillagepieceweight;

                            if (!structurevillagepieceweight.func_75086_a())
                            {
                                p_75081_0_.field_74931_h.remove(structurevillagepieceweight);
                            }

                            return componentvillage;
                        }
                    }
                }
            }

            StructureBoundingBox structureboundingbox = ComponentVillageTorch.func_74904_a(p_75081_0_, p_75081_1_, p_75081_2_, p_75081_3_, p_75081_4_, p_75081_5_, p_75081_6_);

            if (structureboundingbox != null)
            {
                return new ComponentVillageTorch(p_75081_0_, p_75081_7_, p_75081_2_, structureboundingbox, p_75081_6_);
            }
            else
            {
                return null;
            }
        }
    }

    private static StructureComponent func_75077_d(ComponentVillageStartPiece p_75077_0_, List p_75077_1_, Random p_75077_2_, int p_75077_3_, int p_75077_4_, int p_75077_5_, int p_75077_6_, int p_75077_7_)
    {
        if (p_75077_7_ > 50)
        {
            return null;
        }
        else if (Math.abs(p_75077_3_ - p_75077_0_.func_74874_b().field_78897_a) <= 112 && Math.abs(p_75077_5_ - p_75077_0_.func_74874_b().field_78896_c) <= 112)
        {
            ComponentVillage componentvillage = func_75081_c(p_75077_0_, p_75077_1_, p_75077_2_, p_75077_3_, p_75077_4_, p_75077_5_, p_75077_6_, p_75077_7_ + 1);

            if (componentvillage != null)
            {
                int j1 = (componentvillage.field_74887_e.field_78897_a + componentvillage.field_74887_e.field_78893_d) / 2;
                int k1 = (componentvillage.field_74887_e.field_78896_c + componentvillage.field_74887_e.field_78892_f) / 2;
                int l1 = componentvillage.field_74887_e.field_78893_d - componentvillage.field_74887_e.field_78897_a;
                int i2 = componentvillage.field_74887_e.field_78892_f - componentvillage.field_74887_e.field_78896_c;
                int j2 = l1 > i2 ? l1 : i2;

                if (p_75077_0_.func_74925_d().func_76940_a(j1, k1, j2 / 2 + 4, MapGenVillage.field_75055_e))
                {
                    p_75077_1_.add(componentvillage);
                    p_75077_0_.field_74932_i.add(componentvillage);
                    return componentvillage;
                }
            }

            return null;
        }
        else
        {
            return null;
        }
    }

    private static StructureComponent func_75080_e(ComponentVillageStartPiece p_75080_0_, List p_75080_1_, Random p_75080_2_, int p_75080_3_, int p_75080_4_, int p_75080_5_, int p_75080_6_, int p_75080_7_)
    {
        if (p_75080_7_ > 3 + p_75080_0_.field_74928_c)
        {
            return null;
        }
        else if (Math.abs(p_75080_3_ - p_75080_0_.func_74874_b().field_78897_a) <= 112 && Math.abs(p_75080_5_ - p_75080_0_.func_74874_b().field_78896_c) <= 112)
        {
            StructureBoundingBox structureboundingbox = ComponentVillagePathGen.func_74933_a(p_75080_0_, p_75080_1_, p_75080_2_, p_75080_3_, p_75080_4_, p_75080_5_, p_75080_6_);

            if (structureboundingbox != null && structureboundingbox.field_78895_b > 10)
            {
                ComponentVillagePathGen componentvillagepathgen = new ComponentVillagePathGen(p_75080_0_, p_75080_7_, p_75080_2_, structureboundingbox, p_75080_6_);
                int j1 = (componentvillagepathgen.field_74887_e.field_78897_a + componentvillagepathgen.field_74887_e.field_78893_d) / 2;
                int k1 = (componentvillagepathgen.field_74887_e.field_78896_c + componentvillagepathgen.field_74887_e.field_78892_f) / 2;
                int l1 = componentvillagepathgen.field_74887_e.field_78893_d - componentvillagepathgen.field_74887_e.field_78897_a;
                int i2 = componentvillagepathgen.field_74887_e.field_78892_f - componentvillagepathgen.field_74887_e.field_78896_c;
                int j2 = l1 > i2 ? l1 : i2;

                if (p_75080_0_.func_74925_d().func_76940_a(j1, k1, j2 / 2 + 4, MapGenVillage.field_75055_e))
                {
                    p_75080_1_.add(componentvillagepathgen);
                    p_75080_0_.field_74930_j.add(componentvillagepathgen);
                    return componentvillagepathgen;
                }
            }

            return null;
        }
        else
        {
            return null;
        }
    }

    static StructureComponent func_75078_a(ComponentVillageStartPiece p_75078_0_, List p_75078_1_, Random p_75078_2_, int p_75078_3_, int p_75078_4_, int p_75078_5_, int p_75078_6_, int p_75078_7_)
    {
        return func_75077_d(p_75078_0_, p_75078_1_, p_75078_2_, p_75078_3_, p_75078_4_, p_75078_5_, p_75078_6_, p_75078_7_);
    }

    static StructureComponent func_75082_b(ComponentVillageStartPiece p_75082_0_, List p_75082_1_, Random p_75082_2_, int p_75082_3_, int p_75082_4_, int p_75082_5_, int p_75082_6_, int p_75082_7_)
    {
        return func_75080_e(p_75082_0_, p_75082_1_, p_75082_2_, p_75082_3_, p_75082_4_, p_75082_5_, p_75082_6_, p_75082_7_);
    }
}
