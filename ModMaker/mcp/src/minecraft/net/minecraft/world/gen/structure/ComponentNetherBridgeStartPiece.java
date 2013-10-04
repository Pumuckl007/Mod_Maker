package net.minecraft.world.gen.structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.nbt.NBTTagCompound;

public class ComponentNetherBridgeStartPiece extends ComponentNetherBridgeCrossing3
{
    public StructureNetherBridgePieceWeight field_74970_a;
    public List field_74968_b;
    public List field_74969_c;
    public ArrayList field_74967_d = new ArrayList();

    public ComponentNetherBridgeStartPiece() {}

    public ComponentNetherBridgeStartPiece(Random p_i2059_1_, int p_i2059_2_, int p_i2059_3_)
    {
        super(p_i2059_1_, p_i2059_2_, p_i2059_3_);
        this.field_74968_b = new ArrayList();
        StructureNetherBridgePieceWeight[] astructurenetherbridgepieceweight = StructureNetherBridgePieces.func_78739_a();
        int k = astructurenetherbridgepieceweight.length;
        int l;
        StructureNetherBridgePieceWeight structurenetherbridgepieceweight;

        for (l = 0; l < k; ++l)
        {
            structurenetherbridgepieceweight = astructurenetherbridgepieceweight[l];
            structurenetherbridgepieceweight.field_78827_c = 0;
            this.field_74968_b.add(structurenetherbridgepieceweight);
        }

        this.field_74969_c = new ArrayList();
        astructurenetherbridgepieceweight = StructureNetherBridgePieces.func_78737_b();
        k = astructurenetherbridgepieceweight.length;

        for (l = 0; l < k; ++l)
        {
            structurenetherbridgepieceweight = astructurenetherbridgepieceweight[l];
            structurenetherbridgepieceweight.field_78827_c = 0;
            this.field_74969_c.add(structurenetherbridgepieceweight);
        }
    }

    protected void func_143011_b(NBTTagCompound p_143011_1_)
    {
        super.func_143011_b(p_143011_1_);
    }

    protected void func_143012_a(NBTTagCompound p_143012_1_)
    {
        super.func_143012_a(p_143012_1_);
    }
}
