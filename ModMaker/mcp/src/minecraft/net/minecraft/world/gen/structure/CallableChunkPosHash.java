package net.minecraft.world.gen.structure;

import java.util.concurrent.Callable;
import net.minecraft.world.ChunkCoordIntPair;

class CallableChunkPosHash implements Callable
{
    final int field_85165_a;

    final int field_85163_b;

    final MapGenStructure field_85164_c;

    CallableChunkPosHash(MapGenStructure p_i2089_1_, int p_i2089_2_, int p_i2089_3_)
    {
        this.field_85164_c = p_i2089_1_;
        this.field_85165_a = p_i2089_2_;
        this.field_85163_b = p_i2089_3_;
    }

    public String func_85162_a()
    {
        return String.valueOf(ChunkCoordIntPair.func_77272_a(this.field_85165_a, this.field_85163_b));
    }

    public Object call()
    {
        return this.func_85162_a();
    }
}
