package net.minecraft.world.biome;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigMushroom;
import net.minecraft.world.gen.feature.WorldGenCactus;
import net.minecraft.world.gen.feature.WorldGenClay;
import net.minecraft.world.gen.feature.WorldGenDeadBush;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import net.minecraft.world.gen.feature.WorldGenLiquids;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenPumpkin;
import net.minecraft.world.gen.feature.WorldGenReed;
import net.minecraft.world.gen.feature.WorldGenSand;
import net.minecraft.world.gen.feature.WorldGenWaterlily;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeDecorator
{
    public World field_76815_a;
    public Random field_76813_b;
    public int field_76814_c;
    public int field_76811_d;
    public BiomeGenBase field_76812_e;
    public WorldGenerator field_76809_f = new WorldGenClay(4);
    public WorldGenerator field_76810_g;
    public WorldGenerator field_76822_h;
    public WorldGenerator field_76823_i;
    public WorldGenerator field_76820_j;
    public WorldGenerator field_76821_k;
    public WorldGenerator field_76818_l;
    public WorldGenerator field_76819_m;
    public WorldGenerator field_76816_n;
    public WorldGenerator field_76817_o;
    public WorldGenerator field_76831_p;
    public WorldGenerator field_76830_q;
    public WorldGenerator field_76829_r;
    public WorldGenerator field_76828_s;
    public WorldGenerator field_76827_t;
    public WorldGenerator field_76826_u;
    public WorldGenerator field_76825_v;
    public WorldGenerator field_76824_w;
    public WorldGenerator field_76834_x;
    public int field_76833_y;
    public int field_76832_z;
    public int field_76802_A;
    public int field_76803_B;
    public int field_76804_C;
    public int field_76798_D;
    public int field_76799_E;
    public int field_76800_F;
    public int field_76801_G;
    public int field_76805_H;
    public int field_76806_I;
    public int field_76807_J;
    public boolean field_76808_K;

    public BiomeDecorator(BiomeGenBase p_i1974_1_)
    {
        this.field_76810_g = new WorldGenSand(7, Block.field_71939_E.field_71990_ca);
        this.field_76822_h = new WorldGenSand(6, Block.field_71940_F.field_71990_ca);
        this.field_76823_i = new WorldGenMinable(Block.field_71979_v.field_71990_ca, 32);
        this.field_76820_j = new WorldGenMinable(Block.field_71940_F.field_71990_ca, 32);
        this.field_76821_k = new WorldGenMinable(Block.field_71950_I.field_71990_ca, 16);
        this.field_76818_l = new WorldGenMinable(Block.field_71949_H.field_71990_ca, 8);
        this.field_76819_m = new WorldGenMinable(Block.field_71941_G.field_71990_ca, 8);
        this.field_76816_n = new WorldGenMinable(Block.field_72047_aN.field_71990_ca, 7);
        this.field_76817_o = new WorldGenMinable(Block.field_72073_aw.field_71990_ca, 7);
        this.field_76831_p = new WorldGenMinable(Block.field_71947_N.field_71990_ca, 6);
        this.field_76830_q = new WorldGenFlowers(Block.field_72097_ad.field_71990_ca);
        this.field_76829_r = new WorldGenFlowers(Block.field_72107_ae.field_71990_ca);
        this.field_76828_s = new WorldGenFlowers(Block.field_72109_af.field_71990_ca);
        this.field_76827_t = new WorldGenFlowers(Block.field_72103_ag.field_71990_ca);
        this.field_76826_u = new WorldGenBigMushroom();
        this.field_76825_v = new WorldGenReed();
        this.field_76824_w = new WorldGenCactus();
        this.field_76834_x = new WorldGenWaterlily();
        this.field_76802_A = 2;
        this.field_76803_B = 1;
        this.field_76801_G = 1;
        this.field_76805_H = 3;
        this.field_76806_I = 1;
        this.field_76808_K = true;
        this.field_76812_e = p_i1974_1_;
    }

    public void func_76796_a(World p_76796_1_, Random p_76796_2_, int p_76796_3_, int p_76796_4_)
    {
        if (this.field_76815_a != null)
        {
            throw new RuntimeException("Already decorating!!");
        }
        else
        {
            this.field_76815_a = p_76796_1_;
            this.field_76813_b = p_76796_2_;
            this.field_76814_c = p_76796_3_;
            this.field_76811_d = p_76796_4_;
            this.func_76794_a();
            this.field_76815_a = null;
            this.field_76813_b = null;
        }
    }

    protected void func_76794_a()
    {
        this.func_76797_b();
        int i;
        int j;
        int k;

        for (i = 0; i < this.field_76805_H; ++i)
        {
            j = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            k = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            this.field_76810_g.func_76484_a(this.field_76815_a, this.field_76813_b, j, this.field_76815_a.func_72825_h(j, k), k);
        }

        for (i = 0; i < this.field_76806_I; ++i)
        {
            j = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            k = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            this.field_76809_f.func_76484_a(this.field_76815_a, this.field_76813_b, j, this.field_76815_a.func_72825_h(j, k), k);
        }

        for (i = 0; i < this.field_76801_G; ++i)
        {
            j = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            k = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            this.field_76810_g.func_76484_a(this.field_76815_a, this.field_76813_b, j, this.field_76815_a.func_72825_h(j, k), k);
        }

        i = this.field_76832_z;

        if (this.field_76813_b.nextInt(10) == 0)
        {
            ++i;
        }

        int l;

        for (j = 0; j < i; ++j)
        {
            k = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            l = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            WorldGenerator worldgenerator = this.field_76812_e.func_76740_a(this.field_76813_b);
            worldgenerator.func_76487_a(1.0D, 1.0D, 1.0D);
            worldgenerator.func_76484_a(this.field_76815_a, this.field_76813_b, k, this.field_76815_a.func_72976_f(k, l), l);
        }

        for (j = 0; j < this.field_76807_J; ++j)
        {
            k = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            l = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            this.field_76826_u.func_76484_a(this.field_76815_a, this.field_76813_b, k, this.field_76815_a.func_72976_f(k, l), l);
        }

        int i1;

        for (j = 0; j < this.field_76802_A; ++j)
        {
            k = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            l = this.field_76813_b.nextInt(128);
            i1 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            this.field_76830_q.func_76484_a(this.field_76815_a, this.field_76813_b, k, l, i1);

            if (this.field_76813_b.nextInt(4) == 0)
            {
                k = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
                l = this.field_76813_b.nextInt(128);
                i1 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
                this.field_76829_r.func_76484_a(this.field_76815_a, this.field_76813_b, k, l, i1);
            }
        }

        for (j = 0; j < this.field_76803_B; ++j)
        {
            k = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            l = this.field_76813_b.nextInt(128);
            i1 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            WorldGenerator worldgenerator1 = this.field_76812_e.func_76730_b(this.field_76813_b);
            worldgenerator1.func_76484_a(this.field_76815_a, this.field_76813_b, k, l, i1);
        }

        for (j = 0; j < this.field_76804_C; ++j)
        {
            k = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            l = this.field_76813_b.nextInt(128);
            i1 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            (new WorldGenDeadBush(Block.field_71961_Y.field_71990_ca)).func_76484_a(this.field_76815_a, this.field_76813_b, k, l, i1);
        }

        for (j = 0; j < this.field_76833_y; ++j)
        {
            k = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            l = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;

            for (i1 = this.field_76813_b.nextInt(128); i1 > 0 && this.field_76815_a.func_72798_a(k, i1 - 1, l) == 0; --i1)
            {
                ;
            }

            this.field_76834_x.func_76484_a(this.field_76815_a, this.field_76813_b, k, i1, l);
        }

        for (j = 0; j < this.field_76798_D; ++j)
        {
            if (this.field_76813_b.nextInt(4) == 0)
            {
                k = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
                l = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
                i1 = this.field_76815_a.func_72976_f(k, l);
                this.field_76828_s.func_76484_a(this.field_76815_a, this.field_76813_b, k, i1, l);
            }

            if (this.field_76813_b.nextInt(8) == 0)
            {
                k = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
                l = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
                i1 = this.field_76813_b.nextInt(128);
                this.field_76827_t.func_76484_a(this.field_76815_a, this.field_76813_b, k, i1, l);
            }
        }

        if (this.field_76813_b.nextInt(4) == 0)
        {
            j = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            k = this.field_76813_b.nextInt(128);
            l = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            this.field_76828_s.func_76484_a(this.field_76815_a, this.field_76813_b, j, k, l);
        }

        if (this.field_76813_b.nextInt(8) == 0)
        {
            j = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            k = this.field_76813_b.nextInt(128);
            l = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            this.field_76827_t.func_76484_a(this.field_76815_a, this.field_76813_b, j, k, l);
        }

        for (j = 0; j < this.field_76799_E; ++j)
        {
            k = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            l = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            i1 = this.field_76813_b.nextInt(128);
            this.field_76825_v.func_76484_a(this.field_76815_a, this.field_76813_b, k, i1, l);
        }

        for (j = 0; j < 10; ++j)
        {
            k = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            l = this.field_76813_b.nextInt(128);
            i1 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            this.field_76825_v.func_76484_a(this.field_76815_a, this.field_76813_b, k, l, i1);
        }

        if (this.field_76813_b.nextInt(32) == 0)
        {
            j = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            k = this.field_76813_b.nextInt(128);
            l = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            (new WorldGenPumpkin()).func_76484_a(this.field_76815_a, this.field_76813_b, j, k, l);
        }

        for (j = 0; j < this.field_76800_F; ++j)
        {
            k = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            l = this.field_76813_b.nextInt(128);
            i1 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            this.field_76824_w.func_76484_a(this.field_76815_a, this.field_76813_b, k, l, i1);
        }

        if (this.field_76808_K)
        {
            for (j = 0; j < 50; ++j)
            {
                k = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
                l = this.field_76813_b.nextInt(this.field_76813_b.nextInt(120) + 8);
                i1 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
                (new WorldGenLiquids(Block.field_71942_A.field_71990_ca)).func_76484_a(this.field_76815_a, this.field_76813_b, k, l, i1);
            }

            for (j = 0; j < 20; ++j)
            {
                k = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
                l = this.field_76813_b.nextInt(this.field_76813_b.nextInt(this.field_76813_b.nextInt(112) + 8) + 8);
                i1 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
                (new WorldGenLiquids(Block.field_71944_C.field_71990_ca)).func_76484_a(this.field_76815_a, this.field_76813_b, k, l, i1);
            }
        }
    }

    protected void func_76795_a(int p_76795_1_, WorldGenerator p_76795_2_, int p_76795_3_, int p_76795_4_)
    {
        for (int l = 0; l < p_76795_1_; ++l)
        {
            int i1 = this.field_76814_c + this.field_76813_b.nextInt(16);
            int j1 = this.field_76813_b.nextInt(p_76795_4_ - p_76795_3_) + p_76795_3_;
            int k1 = this.field_76811_d + this.field_76813_b.nextInt(16);
            p_76795_2_.func_76484_a(this.field_76815_a, this.field_76813_b, i1, j1, k1);
        }
    }

    protected void func_76793_b(int p_76793_1_, WorldGenerator p_76793_2_, int p_76793_3_, int p_76793_4_)
    {
        for (int l = 0; l < p_76793_1_; ++l)
        {
            int i1 = this.field_76814_c + this.field_76813_b.nextInt(16);
            int j1 = this.field_76813_b.nextInt(p_76793_4_) + this.field_76813_b.nextInt(p_76793_4_) + (p_76793_3_ - p_76793_4_);
            int k1 = this.field_76811_d + this.field_76813_b.nextInt(16);
            p_76793_2_.func_76484_a(this.field_76815_a, this.field_76813_b, i1, j1, k1);
        }
    }

    protected void func_76797_b()
    {
        this.func_76795_a(20, this.field_76823_i, 0, 128);
        this.func_76795_a(10, this.field_76820_j, 0, 128);
        this.func_76795_a(20, this.field_76821_k, 0, 128);
        this.func_76795_a(20, this.field_76818_l, 0, 64);
        this.func_76795_a(2, this.field_76819_m, 0, 32);
        this.func_76795_a(8, this.field_76816_n, 0, 16);
        this.func_76795_a(1, this.field_76817_o, 0, 16);
        this.func_76793_b(1, this.field_76831_p, 16, 16);
    }
}
