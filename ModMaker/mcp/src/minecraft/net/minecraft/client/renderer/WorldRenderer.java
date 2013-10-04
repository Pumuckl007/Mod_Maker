package net.minecraft.client.renderer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.ChunkCache;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class WorldRenderer
{
    public World field_78924_a;
    private int field_78942_y = -1;
    private static Tessellator field_78941_z = Tessellator.field_78398_a;
    public static int field_78922_b;
    public int field_78923_c;
    public int field_78920_d;
    public int field_78921_e;
    public int field_78918_f;
    public int field_78919_g;
    public int field_78931_h;
    public int field_78932_i;
    public int field_78929_j;
    public int field_78930_k;
    public boolean field_78927_l;
    public boolean[] field_78928_m = new boolean[2];
    public int field_78925_n;
    public int field_78926_o;
    public int field_78940_p;
    public boolean field_78939_q;
    public AxisAlignedBB field_78938_r;
    public int field_78937_s;
    public boolean field_78936_t = true;
    public boolean field_78935_u;
    public int field_78934_v;
    public boolean field_78933_w;
    private boolean field_78915_A;
    public List field_78943_x = new ArrayList();
    private List field_78916_B;
    private int field_78917_C;

    public WorldRenderer(World p_i1240_1_, List p_i1240_2_, int p_i1240_3_, int p_i1240_4_, int p_i1240_5_, int p_i1240_6_)
    {
        this.field_78924_a = p_i1240_1_;
        this.field_78916_B = p_i1240_2_;
        this.field_78942_y = p_i1240_6_;
        this.field_78923_c = -999;
        this.func_78913_a(p_i1240_3_, p_i1240_4_, p_i1240_5_);
        this.field_78939_q = false;
    }

    public void func_78913_a(int p_78913_1_, int p_78913_2_, int p_78913_3_)
    {
        if (p_78913_1_ != this.field_78923_c || p_78913_2_ != this.field_78920_d || p_78913_3_ != this.field_78921_e)
        {
            this.func_78910_b();
            this.field_78923_c = p_78913_1_;
            this.field_78920_d = p_78913_2_;
            this.field_78921_e = p_78913_3_;
            this.field_78925_n = p_78913_1_ + 8;
            this.field_78926_o = p_78913_2_ + 8;
            this.field_78940_p = p_78913_3_ + 8;
            this.field_78932_i = p_78913_1_ & 1023;
            this.field_78929_j = p_78913_2_;
            this.field_78930_k = p_78913_3_ & 1023;
            this.field_78918_f = p_78913_1_ - this.field_78932_i;
            this.field_78919_g = p_78913_2_ - this.field_78929_j;
            this.field_78931_h = p_78913_3_ - this.field_78930_k;
            float f = 6.0F;
            this.field_78938_r = AxisAlignedBB.func_72330_a((double)((float)p_78913_1_ - f), (double)((float)p_78913_2_ - f), (double)((float)p_78913_3_ - f), (double)((float)(p_78913_1_ + 16) + f), (double)((float)(p_78913_2_ + 16) + f), (double)((float)(p_78913_3_ + 16) + f));
            GL11.glNewList(this.field_78942_y + 2, GL11.GL_COMPILE);
            RenderItem.func_76980_a(AxisAlignedBB.func_72332_a().func_72299_a((double)((float)this.field_78932_i - f), (double)((float)this.field_78929_j - f), (double)((float)this.field_78930_k - f), (double)((float)(this.field_78932_i + 16) + f), (double)((float)(this.field_78929_j + 16) + f), (double)((float)(this.field_78930_k + 16) + f)));
            GL11.glEndList();
            this.func_78914_f();
        }
    }

    private void func_78905_g()
    {
        GL11.glTranslatef((float)this.field_78932_i, (float)this.field_78929_j, (float)this.field_78930_k);
    }

    public void func_78907_a()
    {
        if (this.field_78939_q)
        {
            this.field_78939_q = false;
            int i = this.field_78923_c;
            int j = this.field_78920_d;
            int k = this.field_78921_e;
            int l = this.field_78923_c + 16;
            int i1 = this.field_78920_d + 16;
            int j1 = this.field_78921_e + 16;

            for (int k1 = 0; k1 < 2; ++k1)
            {
                this.field_78928_m[k1] = true;
            }

            Chunk.field_76640_a = false;
            HashSet hashset = new HashSet();
            hashset.addAll(this.field_78943_x);
            this.field_78943_x.clear();
            byte b0 = 1;
            ChunkCache chunkcache = new ChunkCache(this.field_78924_a, i - b0, j - b0, k - b0, l + b0, i1 + b0, j1 + b0, b0);

            if (!chunkcache.func_72806_N())
            {
                ++field_78922_b;
                RenderBlocks renderblocks = new RenderBlocks(chunkcache);
                this.field_78917_C = 0;

                for (int l1 = 0; l1 < 2; ++l1)
                {
                    boolean flag = false;
                    boolean flag1 = false;
                    boolean flag2 = false;

                    for (int i2 = j; i2 < i1; ++i2)
                    {
                        for (int j2 = k; j2 < j1; ++j2)
                        {
                            for (int k2 = i; k2 < l; ++k2)
                            {
                                int l2 = chunkcache.func_72798_a(k2, i2, j2);

                                if (l2 > 0)
                                {
                                    if (!flag2)
                                    {
                                        flag2 = true;
                                        GL11.glNewList(this.field_78942_y + l1, GL11.GL_COMPILE);
                                        GL11.glPushMatrix();
                                        this.func_78905_g();
                                        float f = 1.000001F;
                                        GL11.glTranslatef(-8.0F, -8.0F, -8.0F);
                                        GL11.glScalef(f, f, f);
                                        GL11.glTranslatef(8.0F, 8.0F, 8.0F);
                                        field_78941_z.func_78382_b();
                                        field_78941_z.func_78373_b((double)(-this.field_78923_c), (double)(-this.field_78920_d), (double)(-this.field_78921_e));
                                    }

                                    Block block = Block.field_71973_m[l2];

                                    if (block != null)
                                    {
                                        if (l1 == 0 && block.func_71887_s())
                                        {
                                            TileEntity tileentity = chunkcache.func_72796_p(k2, i2, j2);

                                            if (TileEntityRenderer.field_76963_a.func_76952_a(tileentity))
                                            {
                                                this.field_78943_x.add(tileentity);
                                            }
                                        }

                                        int i3 = block.func_71856_s_();

                                        if (i3 != l1)
                                        {
                                            flag = true;
                                        }
                                        else if (i3 == l1)
                                        {
                                            flag1 |= renderblocks.func_78612_b(block, k2, i2, j2);
                                        }
                                    }
                                }
                            }
                        }
                    }

                    if (flag2)
                    {
                        this.field_78917_C += field_78941_z.func_78381_a();
                        GL11.glPopMatrix();
                        GL11.glEndList();
                        field_78941_z.func_78373_b(0.0D, 0.0D, 0.0D);
                    }
                    else
                    {
                        flag1 = false;
                    }

                    if (flag1)
                    {
                        this.field_78928_m[l1] = false;
                    }

                    if (!flag)
                    {
                        break;
                    }
                }
            }

            HashSet hashset1 = new HashSet();
            hashset1.addAll(this.field_78943_x);
            hashset1.removeAll(hashset);
            this.field_78916_B.addAll(hashset1);
            hashset.removeAll(this.field_78943_x);
            this.field_78916_B.removeAll(hashset);
            this.field_78933_w = Chunk.field_76640_a;
            this.field_78915_A = true;
        }
    }

    public float func_78912_a(Entity p_78912_1_)
    {
        float f = (float)(p_78912_1_.field_70165_t - (double)this.field_78925_n);
        float f1 = (float)(p_78912_1_.field_70163_u - (double)this.field_78926_o);
        float f2 = (float)(p_78912_1_.field_70161_v - (double)this.field_78940_p);
        return f * f + f1 * f1 + f2 * f2;
    }

    public void func_78910_b()
    {
        for (int i = 0; i < 2; ++i)
        {
            this.field_78928_m[i] = true;
        }

        this.field_78927_l = false;
        this.field_78915_A = false;
    }

    public void func_78911_c()
    {
        this.func_78910_b();
        this.field_78924_a = null;
    }

    public int func_78909_a(int p_78909_1_)
    {
        return !this.field_78927_l ? -1 : (!this.field_78928_m[p_78909_1_] ? this.field_78942_y + p_78909_1_ : -1);
    }

    public void func_78908_a(ICamera p_78908_1_)
    {
        this.field_78927_l = p_78908_1_.func_78546_a(this.field_78938_r);
    }

    public void func_78904_d()
    {
        GL11.glCallList(this.field_78942_y + 2);
    }

    public boolean func_78906_e()
    {
        return !this.field_78915_A ? false : this.field_78928_m[0] && this.field_78928_m[1];
    }

    public void func_78914_f()
    {
        this.field_78939_q = true;
    }
}
