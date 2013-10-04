package net.minecraft.world.gen;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;

public class ChunkProviderEnd implements IChunkProvider
{
    private Random field_73204_i;
    private NoiseGeneratorOctaves field_73201_j;
    private NoiseGeneratorOctaves field_73202_k;
    private NoiseGeneratorOctaves field_73199_l;
    public NoiseGeneratorOctaves field_73196_a;
    public NoiseGeneratorOctaves field_73194_b;
    private World field_73200_m;
    private double[] field_73197_n;
    private BiomeGenBase[] field_73198_o;
    double[] field_73195_c;
    double[] field_73192_d;
    double[] field_73193_e;
    double[] field_73190_f;
    double[] field_73191_g;
    int[][] field_73203_h = new int[32][32];

    public ChunkProviderEnd(World p_i2007_1_, long p_i2007_2_)
    {
        this.field_73200_m = p_i2007_1_;
        this.field_73204_i = new Random(p_i2007_2_);
        this.field_73201_j = new NoiseGeneratorOctaves(this.field_73204_i, 16);
        this.field_73202_k = new NoiseGeneratorOctaves(this.field_73204_i, 16);
        this.field_73199_l = new NoiseGeneratorOctaves(this.field_73204_i, 8);
        this.field_73196_a = new NoiseGeneratorOctaves(this.field_73204_i, 10);
        this.field_73194_b = new NoiseGeneratorOctaves(this.field_73204_i, 16);
    }

    public void func_73189_a(int p_73189_1_, int p_73189_2_, byte[] p_73189_3_, BiomeGenBase[] p_73189_4_)
    {
        byte b0 = 2;
        int k = b0 + 1;
        byte b1 = 33;
        int l = b0 + 1;
        this.field_73197_n = this.func_73187_a(this.field_73197_n, p_73189_1_ * b0, 0, p_73189_2_ * b0, k, b1, l);

        for (int i1 = 0; i1 < b0; ++i1)
        {
            for (int j1 = 0; j1 < b0; ++j1)
            {
                for (int k1 = 0; k1 < 32; ++k1)
                {
                    double d0 = 0.25D;
                    double d1 = this.field_73197_n[((i1 + 0) * l + j1 + 0) * b1 + k1 + 0];
                    double d2 = this.field_73197_n[((i1 + 0) * l + j1 + 1) * b1 + k1 + 0];
                    double d3 = this.field_73197_n[((i1 + 1) * l + j1 + 0) * b1 + k1 + 0];
                    double d4 = this.field_73197_n[((i1 + 1) * l + j1 + 1) * b1 + k1 + 0];
                    double d5 = (this.field_73197_n[((i1 + 0) * l + j1 + 0) * b1 + k1 + 1] - d1) * d0;
                    double d6 = (this.field_73197_n[((i1 + 0) * l + j1 + 1) * b1 + k1 + 1] - d2) * d0;
                    double d7 = (this.field_73197_n[((i1 + 1) * l + j1 + 0) * b1 + k1 + 1] - d3) * d0;
                    double d8 = (this.field_73197_n[((i1 + 1) * l + j1 + 1) * b1 + k1 + 1] - d4) * d0;

                    for (int l1 = 0; l1 < 4; ++l1)
                    {
                        double d9 = 0.125D;
                        double d10 = d1;
                        double d11 = d2;
                        double d12 = (d3 - d1) * d9;
                        double d13 = (d4 - d2) * d9;

                        for (int i2 = 0; i2 < 8; ++i2)
                        {
                            int j2 = i2 + i1 * 8 << 11 | 0 + j1 * 8 << 7 | k1 * 4 + l1;
                            short short1 = 128;
                            double d14 = 0.125D;
                            double d15 = d10;
                            double d16 = (d11 - d10) * d14;

                            for (int k2 = 0; k2 < 8; ++k2)
                            {
                                int l2 = 0;

                                if (d15 > 0.0D)
                                {
                                    l2 = Block.field_72082_bJ.field_71990_ca;
                                }

                                p_73189_3_[j2] = (byte)l2;
                                j2 += short1;
                                d15 += d16;
                            }

                            d10 += d12;
                            d11 += d13;
                        }

                        d1 += d5;
                        d2 += d6;
                        d3 += d7;
                        d4 += d8;
                    }
                }
            }
        }
    }

    public void func_73188_b(int p_73188_1_, int p_73188_2_, byte[] p_73188_3_, BiomeGenBase[] p_73188_4_)
    {
        for (int k = 0; k < 16; ++k)
        {
            for (int l = 0; l < 16; ++l)
            {
                byte b0 = 1;
                int i1 = -1;
                byte b1 = (byte)Block.field_72082_bJ.field_71990_ca;
                byte b2 = (byte)Block.field_72082_bJ.field_71990_ca;

                for (int j1 = 127; j1 >= 0; --j1)
                {
                    int k1 = (l * 16 + k) * 128 + j1;
                    byte b3 = p_73188_3_[k1];

                    if (b3 == 0)
                    {
                        i1 = -1;
                    }
                    else if (b3 == Block.field_71981_t.field_71990_ca)
                    {
                        if (i1 == -1)
                        {
                            if (b0 <= 0)
                            {
                                b1 = 0;
                                b2 = (byte)Block.field_72082_bJ.field_71990_ca;
                            }

                            i1 = b0;

                            if (j1 >= 0)
                            {
                                p_73188_3_[k1] = b1;
                            }
                            else
                            {
                                p_73188_3_[k1] = b2;
                            }
                        }
                        else if (i1 > 0)
                        {
                            --i1;
                            p_73188_3_[k1] = b2;
                        }
                    }
                }
            }
        }
    }

    public Chunk func_73158_c(int p_73158_1_, int p_73158_2_)
    {
        return this.func_73154_d(p_73158_1_, p_73158_2_);
    }

    public Chunk func_73154_d(int p_73154_1_, int p_73154_2_)
    {
        this.field_73204_i.setSeed((long)p_73154_1_ * 341873128712L + (long)p_73154_2_ * 132897987541L);
        byte[] abyte = new byte[32768];
        this.field_73198_o = this.field_73200_m.func_72959_q().func_76933_b(this.field_73198_o, p_73154_1_ * 16, p_73154_2_ * 16, 16, 16);
        this.func_73189_a(p_73154_1_, p_73154_2_, abyte, this.field_73198_o);
        this.func_73188_b(p_73154_1_, p_73154_2_, abyte, this.field_73198_o);
        Chunk chunk = new Chunk(this.field_73200_m, abyte, p_73154_1_, p_73154_2_);
        byte[] abyte1 = chunk.func_76605_m();

        for (int k = 0; k < abyte1.length; ++k)
        {
            abyte1[k] = (byte)this.field_73198_o[k].field_76756_M;
        }

        chunk.func_76603_b();
        return chunk;
    }

    private double[] func_73187_a(double[] p_73187_1_, int p_73187_2_, int p_73187_3_, int p_73187_4_, int p_73187_5_, int p_73187_6_, int p_73187_7_)
    {
        if (p_73187_1_ == null)
        {
            p_73187_1_ = new double[p_73187_5_ * p_73187_6_ * p_73187_7_];
        }

        double d0 = 684.412D;
        double d1 = 684.412D;
        this.field_73190_f = this.field_73196_a.func_76305_a(this.field_73190_f, p_73187_2_, p_73187_4_, p_73187_5_, p_73187_7_, 1.121D, 1.121D, 0.5D);
        this.field_73191_g = this.field_73194_b.func_76305_a(this.field_73191_g, p_73187_2_, p_73187_4_, p_73187_5_, p_73187_7_, 200.0D, 200.0D, 0.5D);
        d0 *= 2.0D;
        this.field_73195_c = this.field_73199_l.func_76304_a(this.field_73195_c, p_73187_2_, p_73187_3_, p_73187_4_, p_73187_5_, p_73187_6_, p_73187_7_, d0 / 80.0D, d1 / 160.0D, d0 / 80.0D);
        this.field_73192_d = this.field_73201_j.func_76304_a(this.field_73192_d, p_73187_2_, p_73187_3_, p_73187_4_, p_73187_5_, p_73187_6_, p_73187_7_, d0, d1, d0);
        this.field_73193_e = this.field_73202_k.func_76304_a(this.field_73193_e, p_73187_2_, p_73187_3_, p_73187_4_, p_73187_5_, p_73187_6_, p_73187_7_, d0, d1, d0);
        int k1 = 0;
        int l1 = 0;

        for (int i2 = 0; i2 < p_73187_5_; ++i2)
        {
            for (int j2 = 0; j2 < p_73187_7_; ++j2)
            {
                double d2 = (this.field_73190_f[l1] + 256.0D) / 512.0D;

                if (d2 > 1.0D)
                {
                    d2 = 1.0D;
                }

                double d3 = this.field_73191_g[l1] / 8000.0D;

                if (d3 < 0.0D)
                {
                    d3 = -d3 * 0.3D;
                }

                d3 = d3 * 3.0D - 2.0D;
                float f = (float)(i2 + p_73187_2_ - 0) / 1.0F;
                float f1 = (float)(j2 + p_73187_4_ - 0) / 1.0F;
                float f2 = 100.0F - MathHelper.func_76129_c(f * f + f1 * f1) * 8.0F;

                if (f2 > 80.0F)
                {
                    f2 = 80.0F;
                }

                if (f2 < -100.0F)
                {
                    f2 = -100.0F;
                }

                if (d3 > 1.0D)
                {
                    d3 = 1.0D;
                }

                d3 /= 8.0D;
                d3 = 0.0D;

                if (d2 < 0.0D)
                {
                    d2 = 0.0D;
                }

                d2 += 0.5D;
                d3 = d3 * (double)p_73187_6_ / 16.0D;
                ++l1;
                double d4 = (double)p_73187_6_ / 2.0D;

                for (int k2 = 0; k2 < p_73187_6_; ++k2)
                {
                    double d5 = 0.0D;
                    double d6 = ((double)k2 - d4) * 8.0D / d2;

                    if (d6 < 0.0D)
                    {
                        d6 *= -1.0D;
                    }

                    double d7 = this.field_73192_d[k1] / 512.0D;
                    double d8 = this.field_73193_e[k1] / 512.0D;
                    double d9 = (this.field_73195_c[k1] / 10.0D + 1.0D) / 2.0D;

                    if (d9 < 0.0D)
                    {
                        d5 = d7;
                    }
                    else if (d9 > 1.0D)
                    {
                        d5 = d8;
                    }
                    else
                    {
                        d5 = d7 + (d8 - d7) * d9;
                    }

                    d5 -= 8.0D;
                    d5 += (double)f2;
                    byte b0 = 2;
                    double d10;

                    if (k2 > p_73187_6_ / 2 - b0)
                    {
                        d10 = (double)((float)(k2 - (p_73187_6_ / 2 - b0)) / 64.0F);

                        if (d10 < 0.0D)
                        {
                            d10 = 0.0D;
                        }

                        if (d10 > 1.0D)
                        {
                            d10 = 1.0D;
                        }

                        d5 = d5 * (1.0D - d10) + -3000.0D * d10;
                    }

                    b0 = 8;

                    if (k2 < b0)
                    {
                        d10 = (double)((float)(b0 - k2) / ((float)b0 - 1.0F));
                        d5 = d5 * (1.0D - d10) + -30.0D * d10;
                    }

                    p_73187_1_[k1] = d5;
                    ++k1;
                }
            }
        }

        return p_73187_1_;
    }

    public boolean func_73149_a(int p_73149_1_, int p_73149_2_)
    {
        return true;
    }

    public void func_73153_a(IChunkProvider p_73153_1_, int p_73153_2_, int p_73153_3_)
    {
        BlockSand.field_72192_a = true;
        int k = p_73153_2_ * 16;
        int l = p_73153_3_ * 16;
        BiomeGenBase biomegenbase = this.field_73200_m.func_72807_a(k + 16, l + 16);
        biomegenbase.func_76728_a(this.field_73200_m, this.field_73200_m.field_73012_v, k, l);
        BlockSand.field_72192_a = false;
    }

    public boolean func_73151_a(boolean p_73151_1_, IProgressUpdate p_73151_2_)
    {
        return true;
    }

    public void func_104112_b() {}

    public boolean func_73156_b()
    {
        return false;
    }

    public boolean func_73157_c()
    {
        return true;
    }

    public String func_73148_d()
    {
        return "RandomLevelSource";
    }

    public List func_73155_a(EnumCreatureType p_73155_1_, int p_73155_2_, int p_73155_3_, int p_73155_4_)
    {
        BiomeGenBase biomegenbase = this.field_73200_m.func_72807_a(p_73155_2_, p_73155_4_);
        return biomegenbase == null ? null : biomegenbase.func_76747_a(p_73155_1_);
    }

    public ChunkPosition func_73150_a(World p_73150_1_, String p_73150_2_, int p_73150_3_, int p_73150_4_, int p_73150_5_)
    {
        return null;
    }

    public int func_73152_e()
    {
        return 0;
    }

    public void func_82695_e(int p_82695_1_, int p_82695_2_) {}
}
