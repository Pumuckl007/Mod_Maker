package net.minecraft.world.gen;

import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

public class MapGenBase
{
    protected int field_75040_a = 8;
    protected Random field_75038_b = new Random();
    protected World field_75039_c;

    public void func_75036_a(IChunkProvider p_75036_1_, World p_75036_2_, int p_75036_3_, int p_75036_4_, byte[] p_75036_5_)
    {
        int k = this.field_75040_a;
        this.field_75039_c = p_75036_2_;
        this.field_75038_b.setSeed(p_75036_2_.func_72905_C());
        long l = this.field_75038_b.nextLong();
        long i1 = this.field_75038_b.nextLong();

        for (int j1 = p_75036_3_ - k; j1 <= p_75036_3_ + k; ++j1)
        {
            for (int k1 = p_75036_4_ - k; k1 <= p_75036_4_ + k; ++k1)
            {
                long l1 = (long)j1 * l;
                long i2 = (long)k1 * i1;
                this.field_75038_b.setSeed(l1 ^ i2 ^ p_75036_2_.func_72905_C());
                this.func_75037_a(p_75036_2_, j1, k1, p_75036_3_, p_75036_4_, p_75036_5_);
            }
        }
    }

    protected void func_75037_a(World p_75037_1_, int p_75037_2_, int p_75037_3_, int p_75037_4_, int p_75037_5_, byte[] p_75037_6_) {}
}
