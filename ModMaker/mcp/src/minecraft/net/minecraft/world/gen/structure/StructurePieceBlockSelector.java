package net.minecraft.world.gen.structure;

import java.util.Random;

public abstract class StructurePieceBlockSelector
{
    protected int field_75066_a;
    protected int field_75065_b;

    public abstract void func_75062_a(Random random, int i, int j, int k, boolean flag);

    public int func_75063_a()
    {
        return this.field_75066_a;
    }

    public int func_75064_b()
    {
        return this.field_75065_b;
    }
}
