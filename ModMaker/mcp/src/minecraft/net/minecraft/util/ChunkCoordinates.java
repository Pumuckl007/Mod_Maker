package net.minecraft.util;

public class ChunkCoordinates implements Comparable
{
    public int field_71574_a;
    public int field_71572_b;
    public int field_71573_c;

    public ChunkCoordinates() {}

    public ChunkCoordinates(int p_i1354_1_, int p_i1354_2_, int p_i1354_3_)
    {
        this.field_71574_a = p_i1354_1_;
        this.field_71572_b = p_i1354_2_;
        this.field_71573_c = p_i1354_3_;
    }

    public ChunkCoordinates(ChunkCoordinates p_i1355_1_)
    {
        this.field_71574_a = p_i1355_1_.field_71574_a;
        this.field_71572_b = p_i1355_1_.field_71572_b;
        this.field_71573_c = p_i1355_1_.field_71573_c;
    }

    public boolean equals(Object p_equals_1_)
    {
        if (!(p_equals_1_ instanceof ChunkCoordinates))
        {
            return false;
        }
        else
        {
            ChunkCoordinates chunkcoordinates = (ChunkCoordinates)p_equals_1_;
            return this.field_71574_a == chunkcoordinates.field_71574_a && this.field_71572_b == chunkcoordinates.field_71572_b && this.field_71573_c == chunkcoordinates.field_71573_c;
        }
    }

    public int hashCode()
    {
        return this.field_71574_a + this.field_71573_c << 8 + this.field_71572_b << 16;
    }

    public int func_71570_a(ChunkCoordinates p_71570_1_)
    {
        return this.field_71572_b == p_71570_1_.field_71572_b ? (this.field_71573_c == p_71570_1_.field_71573_c ? this.field_71574_a - p_71570_1_.field_71574_a : this.field_71573_c - p_71570_1_.field_71573_c) : this.field_71572_b - p_71570_1_.field_71572_b;
    }

    public void func_71571_b(int p_71571_1_, int p_71571_2_, int p_71571_3_)
    {
        this.field_71574_a = p_71571_1_;
        this.field_71572_b = p_71571_2_;
        this.field_71573_c = p_71571_3_;
    }

    public float func_71569_e(int p_71569_1_, int p_71569_2_, int p_71569_3_)
    {
        float f = (float)(this.field_71574_a - p_71569_1_);
        float f1 = (float)(this.field_71572_b - p_71569_2_);
        float f2 = (float)(this.field_71573_c - p_71569_3_);
        return f * f + f1 * f1 + f2 * f2;
    }

    public float func_82371_e(ChunkCoordinates p_82371_1_)
    {
        return this.func_71569_e(p_82371_1_.field_71574_a, p_82371_1_.field_71572_b, p_82371_1_.field_71573_c);
    }

    public int compareTo(Object p_compareTo_1_)
    {
        return this.func_71570_a((ChunkCoordinates)p_compareTo_1_);
    }
}
