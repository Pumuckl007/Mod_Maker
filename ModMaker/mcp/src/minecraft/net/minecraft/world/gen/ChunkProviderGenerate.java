package net.minecraft.world.gen;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.SpawnerAnimals;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.MapGenScatteredFeature;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.structure.MapGenMineshaft;
import net.minecraft.world.gen.structure.MapGenStronghold;
import net.minecraft.world.gen.structure.MapGenVillage;

public class ChunkProviderGenerate implements IChunkProvider
{
    private Random field_73220_k;
    private NoiseGeneratorOctaves field_73217_l;
    private NoiseGeneratorOctaves field_73218_m;
    private NoiseGeneratorOctaves field_73215_n;
    private NoiseGeneratorOctaves field_73216_o;
    public NoiseGeneratorOctaves field_73214_a;
    public NoiseGeneratorOctaves field_73212_b;
    public NoiseGeneratorOctaves field_73213_c;
    private World field_73230_p;
    private final boolean field_73229_q;
    private double[] field_73228_r;
    private double[] field_73227_s = new double[256];
    private MapGenBase field_73226_t = new MapGenCaves();
    private MapGenStronghold field_73225_u = new MapGenStronghold();
    private MapGenVillage field_73224_v = new MapGenVillage();
    private MapGenMineshaft field_73223_w = new MapGenMineshaft();
    private MapGenScatteredFeature field_73233_x = new MapGenScatteredFeature();
    private MapGenBase field_73232_y = new MapGenRavine();
    private BiomeGenBase[] field_73231_z;
    double[] field_73210_d;
    double[] field_73211_e;
    double[] field_73208_f;
    double[] field_73209_g;
    double[] field_73221_h;
    float[] field_73222_i;
    int[][] field_73219_j = new int[32][32];

    public ChunkProviderGenerate(World p_i2006_1_, long p_i2006_2_, boolean p_i2006_4_)
    {
        this.field_73230_p = p_i2006_1_;
        this.field_73229_q = p_i2006_4_;
        this.field_73220_k = new Random(p_i2006_2_);
        this.field_73217_l = new NoiseGeneratorOctaves(this.field_73220_k, 16);
        this.field_73218_m = new NoiseGeneratorOctaves(this.field_73220_k, 16);
        this.field_73215_n = new NoiseGeneratorOctaves(this.field_73220_k, 8);
        this.field_73216_o = new NoiseGeneratorOctaves(this.field_73220_k, 4);
        this.field_73214_a = new NoiseGeneratorOctaves(this.field_73220_k, 10);
        this.field_73212_b = new NoiseGeneratorOctaves(this.field_73220_k, 16);
        this.field_73213_c = new NoiseGeneratorOctaves(this.field_73220_k, 8);
    }

    public void func_73206_a(int p_73206_1_, int p_73206_2_, byte[] p_73206_3_)
    {
        byte b0 = 4;
        byte b1 = 16;
        byte b2 = 63;
        int k = b0 + 1;
        byte b3 = 17;
        int l = b0 + 1;
        this.field_73231_z = this.field_73230_p.func_72959_q().func_76937_a(this.field_73231_z, p_73206_1_ * 4 - 2, p_73206_2_ * 4 - 2, k + 5, l + 5);
        this.field_73228_r = this.func_73205_a(this.field_73228_r, p_73206_1_ * b0, 0, p_73206_2_ * b0, k, b3, l);

        for (int i1 = 0; i1 < b0; ++i1)
        {
            for (int j1 = 0; j1 < b0; ++j1)
            {
                for (int k1 = 0; k1 < b1; ++k1)
                {
                    double d0 = 0.125D;
                    double d1 = this.field_73228_r[((i1 + 0) * l + j1 + 0) * b3 + k1 + 0];
                    double d2 = this.field_73228_r[((i1 + 0) * l + j1 + 1) * b3 + k1 + 0];
                    double d3 = this.field_73228_r[((i1 + 1) * l + j1 + 0) * b3 + k1 + 0];
                    double d4 = this.field_73228_r[((i1 + 1) * l + j1 + 1) * b3 + k1 + 0];
                    double d5 = (this.field_73228_r[((i1 + 0) * l + j1 + 0) * b3 + k1 + 1] - d1) * d0;
                    double d6 = (this.field_73228_r[((i1 + 0) * l + j1 + 1) * b3 + k1 + 1] - d2) * d0;
                    double d7 = (this.field_73228_r[((i1 + 1) * l + j1 + 0) * b3 + k1 + 1] - d3) * d0;
                    double d8 = (this.field_73228_r[((i1 + 1) * l + j1 + 1) * b3 + k1 + 1] - d4) * d0;

                    for (int l1 = 0; l1 < 8; ++l1)
                    {
                        double d9 = 0.25D;
                        double d10 = d1;
                        double d11 = d2;
                        double d12 = (d3 - d1) * d9;
                        double d13 = (d4 - d2) * d9;

                        for (int i2 = 0; i2 < 4; ++i2)
                        {
                            int j2 = i2 + i1 * 4 << 11 | 0 + j1 * 4 << 7 | k1 * 8 + l1;
                            short short1 = 128;
                            j2 -= short1;
                            double d14 = 0.25D;
                            double d15 = (d11 - d10) * d14;
                            double d16 = d10 - d15;

                            for (int k2 = 0; k2 < 4; ++k2)
                            {
                                if ((d16 += d15) > 0.0D)
                                {
                                    p_73206_3_[j2 += short1] = (byte)Block.field_71981_t.field_71990_ca;
                                }
                                else if (k1 * 8 + l1 < b2)
                                {
                                    p_73206_3_[j2 += short1] = (byte)Block.field_71943_B.field_71990_ca;
                                }
                                else
                                {
                                    p_73206_3_[j2 += short1] = 0;
                                }
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

    public void func_73207_a(int p_73207_1_, int p_73207_2_, byte[] p_73207_3_, BiomeGenBase[] p_73207_4_)
    {
        byte b0 = 63;
        double d0 = 0.03125D;
        this.field_73227_s = this.field_73216_o.func_76304_a(this.field_73227_s, p_73207_1_ * 16, p_73207_2_ * 16, 0, 16, 16, 1, d0 * 2.0D, d0 * 2.0D, d0 * 2.0D);

        for (int k = 0; k < 16; ++k)
        {
            for (int l = 0; l < 16; ++l)
            {
                BiomeGenBase biomegenbase = p_73207_4_[l + k * 16];
                float f = biomegenbase.func_76743_j();
                int i1 = (int)(this.field_73227_s[k + l * 16] / 3.0D + 3.0D + this.field_73220_k.nextDouble() * 0.25D);
                int j1 = -1;
                byte b1 = biomegenbase.field_76752_A;
                byte b2 = biomegenbase.field_76753_B;

                for (int k1 = 127; k1 >= 0; --k1)
                {
                    int l1 = (l * 16 + k) * 128 + k1;

                    if (k1 <= 0 + this.field_73220_k.nextInt(5))
                    {
                        p_73207_3_[l1] = (byte)Block.field_71986_z.field_71990_ca;
                    }
                    else
                    {
                        byte b3 = p_73207_3_[l1];

                        if (b3 == 0)
                        {
                            j1 = -1;
                        }
                        else if (b3 == Block.field_71981_t.field_71990_ca)
                        {
                            if (j1 == -1)
                            {
                                if (i1 <= 0)
                                {
                                    b1 = 0;
                                    b2 = (byte)Block.field_71981_t.field_71990_ca;
                                }
                                else if (k1 >= b0 - 4 && k1 <= b0 + 1)
                                {
                                    b1 = biomegenbase.field_76752_A;
                                    b2 = biomegenbase.field_76753_B;
                                }

                                if (k1 < b0 && b1 == 0)
                                {
                                    if (f < 0.15F)
                                    {
                                        b1 = (byte)Block.field_72036_aT.field_71990_ca;
                                    }
                                    else
                                    {
                                        b1 = (byte)Block.field_71943_B.field_71990_ca;
                                    }
                                }

                                j1 = i1;

                                if (k1 >= b0 - 1)
                                {
                                    p_73207_3_[l1] = b1;
                                }
                                else
                                {
                                    p_73207_3_[l1] = b2;
                                }
                            }
                            else if (j1 > 0)
                            {
                                --j1;
                                p_73207_3_[l1] = b2;

                                if (j1 == 0 && b2 == Block.field_71939_E.field_71990_ca)
                                {
                                    j1 = this.field_73220_k.nextInt(4);
                                    b2 = (byte)Block.field_71957_Q.field_71990_ca;
                                }
                            }
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
        this.field_73220_k.setSeed((long)p_73154_1_ * 341873128712L + (long)p_73154_2_ * 132897987541L);
        byte[] abyte = new byte[32768];
        this.func_73206_a(p_73154_1_, p_73154_2_, abyte);
        this.field_73231_z = this.field_73230_p.func_72959_q().func_76933_b(this.field_73231_z, p_73154_1_ * 16, p_73154_2_ * 16, 16, 16);
        this.func_73207_a(p_73154_1_, p_73154_2_, abyte, this.field_73231_z);
        this.field_73226_t.func_75036_a(this, this.field_73230_p, p_73154_1_, p_73154_2_, abyte);
        this.field_73232_y.func_75036_a(this, this.field_73230_p, p_73154_1_, p_73154_2_, abyte);

        if (this.field_73229_q)
        {
            this.field_73223_w.func_75036_a(this, this.field_73230_p, p_73154_1_, p_73154_2_, abyte);
            this.field_73224_v.func_75036_a(this, this.field_73230_p, p_73154_1_, p_73154_2_, abyte);
            this.field_73225_u.func_75036_a(this, this.field_73230_p, p_73154_1_, p_73154_2_, abyte);
            this.field_73233_x.func_75036_a(this, this.field_73230_p, p_73154_1_, p_73154_2_, abyte);
        }

        Chunk chunk = new Chunk(this.field_73230_p, abyte, p_73154_1_, p_73154_2_);
        byte[] abyte1 = chunk.func_76605_m();

        for (int k = 0; k < abyte1.length; ++k)
        {
            abyte1[k] = (byte)this.field_73231_z[k].field_76756_M;
        }

        chunk.func_76603_b();
        return chunk;
    }

    private double[] func_73205_a(double[] p_73205_1_, int p_73205_2_, int p_73205_3_, int p_73205_4_, int p_73205_5_, int p_73205_6_, int p_73205_7_)
    {
        if (p_73205_1_ == null)
        {
            p_73205_1_ = new double[p_73205_5_ * p_73205_6_ * p_73205_7_];
        }

        if (this.field_73222_i == null)
        {
            this.field_73222_i = new float[25];

            for (int k1 = -2; k1 <= 2; ++k1)
            {
                for (int l1 = -2; l1 <= 2; ++l1)
                {
                    float f = 10.0F / MathHelper.func_76129_c((float)(k1 * k1 + l1 * l1) + 0.2F);
                    this.field_73222_i[k1 + 2 + (l1 + 2) * 5] = f;
                }
            }
        }

        double d0 = 684.412D;
        double d1 = 684.412D;
        this.field_73209_g = this.field_73214_a.func_76305_a(this.field_73209_g, p_73205_2_, p_73205_4_, p_73205_5_, p_73205_7_, 1.121D, 1.121D, 0.5D);
        this.field_73221_h = this.field_73212_b.func_76305_a(this.field_73221_h, p_73205_2_, p_73205_4_, p_73205_5_, p_73205_7_, 200.0D, 200.0D, 0.5D);
        this.field_73210_d = this.field_73215_n.func_76304_a(this.field_73210_d, p_73205_2_, p_73205_3_, p_73205_4_, p_73205_5_, p_73205_6_, p_73205_7_, d0 / 80.0D, d1 / 160.0D, d0 / 80.0D);
        this.field_73211_e = this.field_73217_l.func_76304_a(this.field_73211_e, p_73205_2_, p_73205_3_, p_73205_4_, p_73205_5_, p_73205_6_, p_73205_7_, d0, d1, d0);
        this.field_73208_f = this.field_73218_m.func_76304_a(this.field_73208_f, p_73205_2_, p_73205_3_, p_73205_4_, p_73205_5_, p_73205_6_, p_73205_7_, d0, d1, d0);
        boolean flag = false;
        boolean flag1 = false;
        int i2 = 0;
        int j2 = 0;

        for (int k2 = 0; k2 < p_73205_5_; ++k2)
        {
            for (int l2 = 0; l2 < p_73205_7_; ++l2)
            {
                float f1 = 0.0F;
                float f2 = 0.0F;
                float f3 = 0.0F;
                byte b0 = 2;
                BiomeGenBase biomegenbase = this.field_73231_z[k2 + 2 + (l2 + 2) * (p_73205_5_ + 5)];

                for (int i3 = -b0; i3 <= b0; ++i3)
                {
                    for (int j3 = -b0; j3 <= b0; ++j3)
                    {
                        BiomeGenBase biomegenbase1 = this.field_73231_z[k2 + i3 + 2 + (l2 + j3 + 2) * (p_73205_5_ + 5)];
                        float f4 = this.field_73222_i[i3 + 2 + (j3 + 2) * 5] / (biomegenbase1.field_76748_D + 2.0F);

                        if (biomegenbase1.field_76748_D > biomegenbase.field_76748_D)
                        {
                            f4 /= 2.0F;
                        }

                        f1 += biomegenbase1.field_76749_E * f4;
                        f2 += biomegenbase1.field_76748_D * f4;
                        f3 += f4;
                    }
                }

                f1 /= f3;
                f2 /= f3;
                f1 = f1 * 0.9F + 0.1F;
                f2 = (f2 * 4.0F - 1.0F) / 8.0F;
                double d2 = this.field_73221_h[j2] / 8000.0D;

                if (d2 < 0.0D)
                {
                    d2 = -d2 * 0.3D;
                }

                d2 = d2 * 3.0D - 2.0D;

                if (d2 < 0.0D)
                {
                    d2 /= 2.0D;

                    if (d2 < -1.0D)
                    {
                        d2 = -1.0D;
                    }

                    d2 /= 1.4D;
                    d2 /= 2.0D;
                }
                else
                {
                    if (d2 > 1.0D)
                    {
                        d2 = 1.0D;
                    }

                    d2 /= 8.0D;
                }

                ++j2;

                for (int k3 = 0; k3 < p_73205_6_; ++k3)
                {
                    double d3 = (double)f2;
                    double d4 = (double)f1;
                    d3 += d2 * 0.2D;
                    d3 = d3 * (double)p_73205_6_ / 16.0D;
                    double d5 = (double)p_73205_6_ / 2.0D + d3 * 4.0D;
                    double d6 = 0.0D;
                    double d7 = ((double)k3 - d5) * 12.0D * 128.0D / 128.0D / d4;

                    if (d7 < 0.0D)
                    {
                        d7 *= 4.0D;
                    }

                    double d8 = this.field_73211_e[i2] / 512.0D;
                    double d9 = this.field_73208_f[i2] / 512.0D;
                    double d10 = (this.field_73210_d[i2] / 10.0D + 1.0D) / 2.0D;

                    if (d10 < 0.0D)
                    {
                        d6 = d8;
                    }
                    else if (d10 > 1.0D)
                    {
                        d6 = d9;
                    }
                    else
                    {
                        d6 = d8 + (d9 - d8) * d10;
                    }

                    d6 -= d7;

                    if (k3 > p_73205_6_ - 4)
                    {
                        double d11 = (double)((float)(k3 - (p_73205_6_ - 4)) / 3.0F);
                        d6 = d6 * (1.0D - d11) + -10.0D * d11;
                    }

                    p_73205_1_[i2] = d6;
                    ++i2;
                }
            }
        }

        return p_73205_1_;
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
        BiomeGenBase biomegenbase = this.field_73230_p.func_72807_a(k + 16, l + 16);
        this.field_73220_k.setSeed(this.field_73230_p.func_72905_C());
        long i1 = this.field_73220_k.nextLong() / 2L * 2L + 1L;
        long j1 = this.field_73220_k.nextLong() / 2L * 2L + 1L;
        this.field_73220_k.setSeed((long)p_73153_2_ * i1 + (long)p_73153_3_ * j1 ^ this.field_73230_p.func_72905_C());
        boolean flag = false;

        if (this.field_73229_q)
        {
            this.field_73223_w.func_75051_a(this.field_73230_p, this.field_73220_k, p_73153_2_, p_73153_3_);
            flag = this.field_73224_v.func_75051_a(this.field_73230_p, this.field_73220_k, p_73153_2_, p_73153_3_);
            this.field_73225_u.func_75051_a(this.field_73230_p, this.field_73220_k, p_73153_2_, p_73153_3_);
            this.field_73233_x.func_75051_a(this.field_73230_p, this.field_73220_k, p_73153_2_, p_73153_3_);
        }

        int k1;
        int l1;
        int i2;

        if (biomegenbase != BiomeGenBase.field_76769_d && biomegenbase != BiomeGenBase.field_76786_s && !flag && this.field_73220_k.nextInt(4) == 0)
        {
            k1 = k + this.field_73220_k.nextInt(16) + 8;
            l1 = this.field_73220_k.nextInt(128);
            i2 = l + this.field_73220_k.nextInt(16) + 8;
            (new WorldGenLakes(Block.field_71943_B.field_71990_ca)).func_76484_a(this.field_73230_p, this.field_73220_k, k1, l1, i2);
        }

        if (!flag && this.field_73220_k.nextInt(8) == 0)
        {
            k1 = k + this.field_73220_k.nextInt(16) + 8;
            l1 = this.field_73220_k.nextInt(this.field_73220_k.nextInt(120) + 8);
            i2 = l + this.field_73220_k.nextInt(16) + 8;

            if (l1 < 63 || this.field_73220_k.nextInt(10) == 0)
            {
                (new WorldGenLakes(Block.field_71938_D.field_71990_ca)).func_76484_a(this.field_73230_p, this.field_73220_k, k1, l1, i2);
            }
        }

        for (k1 = 0; k1 < 8; ++k1)
        {
            l1 = k + this.field_73220_k.nextInt(16) + 8;
            i2 = this.field_73220_k.nextInt(128);
            int j2 = l + this.field_73220_k.nextInt(16) + 8;
            (new WorldGenDungeons()).func_76484_a(this.field_73230_p, this.field_73220_k, l1, i2, j2);
        }

        biomegenbase.func_76728_a(this.field_73230_p, this.field_73220_k, k, l);
        SpawnerAnimals.func_77191_a(this.field_73230_p, biomegenbase, k + 8, l + 8, 16, 16, this.field_73220_k);
        k += 8;
        l += 8;

        for (k1 = 0; k1 < 16; ++k1)
        {
            for (l1 = 0; l1 < 16; ++l1)
            {
                i2 = this.field_73230_p.func_72874_g(k + k1, l + l1);

                if (this.field_73230_p.func_72884_u(k1 + k, i2 - 1, l1 + l))
                {
                    this.field_73230_p.func_72832_d(k1 + k, i2 - 1, l1 + l, Block.field_72036_aT.field_71990_ca, 0, 2);
                }

                if (this.field_73230_p.func_72858_w(k1 + k, i2, l1 + l))
                {
                    this.field_73230_p.func_72832_d(k1 + k, i2, l1 + l, Block.field_72037_aS.field_71990_ca, 0, 2);
                }
            }
        }

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
        BiomeGenBase biomegenbase = this.field_73230_p.func_72807_a(p_73155_2_, p_73155_4_);
        return biomegenbase == null ? null : (p_73155_1_ == EnumCreatureType.monster && this.field_73233_x.func_143030_a(p_73155_2_, p_73155_3_, p_73155_4_) ? this.field_73233_x.func_82667_a() : biomegenbase.func_76747_a(p_73155_1_));
    }

    public ChunkPosition func_73150_a(World p_73150_1_, String p_73150_2_, int p_73150_3_, int p_73150_4_, int p_73150_5_)
    {
        return "Stronghold".equals(p_73150_2_) && this.field_73225_u != null ? this.field_73225_u.func_75050_a(p_73150_1_, p_73150_3_, p_73150_4_, p_73150_5_) : null;
    }

    public int func_73152_e()
    {
        return 0;
    }

    public void func_82695_e(int p_82695_1_, int p_82695_2_)
    {
        if (this.field_73229_q)
        {
            this.field_73223_w.func_75036_a(this, this.field_73230_p, p_82695_1_, p_82695_2_, (byte[])null);
            this.field_73224_v.func_75036_a(this, this.field_73230_p, p_82695_1_, p_82695_2_, (byte[])null);
            this.field_73225_u.func_75036_a(this, this.field_73230_p, p_82695_1_, p_82695_2_, (byte[])null);
            this.field_73233_x.func_75036_a(this, this.field_73230_p, p_82695_1_, p_82695_2_, (byte[])null);
        }
    }
}
