package net.minecraft.client.renderer.texture;

import com.google.common.collect.Lists;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.minecraft.client.renderer.StitcherException;

@SideOnly(Side.CLIENT)
public class Stitcher
{
    private final Set field_94319_a;
    private final List field_94317_b;
    private int field_94318_c;
    private int field_94315_d;
    private final int field_94316_e;
    private final int field_94313_f;
    private final boolean field_94314_g;
    private final int field_94323_h;

    public Stitcher(int p_i1278_1_, int p_i1278_2_, boolean p_i1278_3_)
    {
        this(p_i1278_1_, p_i1278_2_, p_i1278_3_, 0);
    }

    public Stitcher(int p_i1279_1_, int p_i1279_2_, boolean p_i1279_3_, int p_i1279_4_)
    {
        this.field_94319_a = new HashSet(256);
        this.field_94317_b = new ArrayList(256);
        this.field_94316_e = p_i1279_1_;
        this.field_94313_f = p_i1279_2_;
        this.field_94314_g = p_i1279_3_;
        this.field_94323_h = p_i1279_4_;
    }

    public int func_110935_a()
    {
        return this.field_94318_c;
    }

    public int func_110936_b()
    {
        return this.field_94315_d;
    }

    public void func_110934_a(TextureAtlasSprite p_110934_1_)
    {
        StitchHolder stitchholder = new StitchHolder(p_110934_1_);

        if (this.field_94323_h > 0)
        {
            stitchholder.func_94196_a(this.field_94323_h);
        }

        this.field_94319_a.add(stitchholder);
    }

    public void func_94305_f()
    {
        StitchHolder[] astitchholder = (StitchHolder[])this.field_94319_a.toArray(new StitchHolder[this.field_94319_a.size()]);
        Arrays.sort(astitchholder);
        StitchHolder[] astitchholder1 = astitchholder;
        int i = astitchholder.length;

        for (int j = 0; j < i; ++j)
        {
            StitchHolder stitchholder = astitchholder1[j];

            if (!this.func_94310_b(stitchholder))
            {
                String s = String.format("Unable to fit: %s - size: %dx%d - Maybe try a lowerresolution texturepack?", new Object[] {stitchholder.func_98150_a().func_94215_i(), Integer.valueOf(stitchholder.func_98150_a().func_94211_a()), Integer.valueOf(stitchholder.func_98150_a().func_94216_b())});
                throw new StitcherException(stitchholder, s);
            }
        }

        if (this.field_94314_g)
        {
            this.field_94318_c = this.func_94308_a(this.field_94318_c);
            this.field_94315_d = this.func_94308_a(this.field_94315_d);
        }
    }

    public List func_94309_g()
    {
        ArrayList arraylist = Lists.newArrayList();
        Iterator iterator = this.field_94317_b.iterator();

        while (iterator.hasNext())
        {
            StitchSlot stitchslot = (StitchSlot)iterator.next();
            stitchslot.func_94184_a(arraylist);
        }

        ArrayList arraylist1 = Lists.newArrayList();
        Iterator iterator1 = arraylist.iterator();

        while (iterator1.hasNext())
        {
            StitchSlot stitchslot1 = (StitchSlot)iterator1.next();
            StitchHolder stitchholder = stitchslot1.func_94183_a();
            TextureAtlasSprite textureatlassprite = stitchholder.func_98150_a();
            textureatlassprite.func_110971_a(this.field_94318_c, this.field_94315_d, stitchslot1.func_94186_b(), stitchslot1.func_94185_c(), stitchholder.func_94195_e());
            arraylist1.add(textureatlassprite);
        }

        return arraylist1;
    }

    private int func_94308_a(int p_94308_1_)
    {
        int j = p_94308_1_ - 1;
        j |= j >> 1;
        j |= j >> 2;
        j |= j >> 4;
        j |= j >> 8;
        j |= j >> 16;
        return j + 1;
    }

    private boolean func_94310_b(StitchHolder p_94310_1_)
    {
        for (int i = 0; i < this.field_94317_b.size(); ++i)
        {
            if (((StitchSlot)this.field_94317_b.get(i)).func_94182_a(p_94310_1_))
            {
                return true;
            }

            p_94310_1_.func_94194_d();

            if (((StitchSlot)this.field_94317_b.get(i)).func_94182_a(p_94310_1_))
            {
                return true;
            }

            p_94310_1_.func_94194_d();
        }

        return this.func_94311_c(p_94310_1_);
    }

    private boolean func_94311_c(StitchHolder p_94311_1_)
    {
        int i = Math.min(p_94311_1_.func_94199_b(), p_94311_1_.func_94197_a());
        boolean flag = this.field_94318_c == 0 && this.field_94315_d == 0;
        boolean flag1;

        if (this.field_94314_g)
        {
            int j = this.func_94308_a(this.field_94318_c);
            int k = this.func_94308_a(this.field_94315_d);
            int l = this.func_94308_a(this.field_94318_c + i);
            int i1 = this.func_94308_a(this.field_94315_d + i);
            boolean flag2 = l <= this.field_94316_e;
            boolean flag3 = i1 <= this.field_94313_f;

            if (!flag2 && !flag3)
            {
                return false;
            }

            int j1 = Math.max(p_94311_1_.func_94199_b(), p_94311_1_.func_94197_a());

            if (flag && !flag2 && this.func_94308_a(this.field_94315_d + j1) > this.field_94313_f)
            {
                return false;
            }

            boolean flag4 = j != l;
            boolean flag5 = k != i1;

            if (flag4 ^ flag5)
            {
                flag1 = flag4 && flag2;
            }
            else
            {
                flag1 = flag2 && j <= k;
            }
        }
        else
        {
            boolean flag6 = this.field_94318_c + i <= this.field_94316_e;
            boolean flag7 = this.field_94315_d + i <= this.field_94313_f;

            if (!flag6 && !flag7)
            {
                return false;
            }

            flag1 = (flag || this.field_94318_c <= this.field_94315_d) && flag6;
        }

        StitchSlot stitchslot;

        if (flag1)
        {
            if (p_94311_1_.func_94197_a() > p_94311_1_.func_94199_b())
            {
                p_94311_1_.func_94194_d();
            }

            if (this.field_94315_d == 0)
            {
                this.field_94315_d = p_94311_1_.func_94199_b();
            }

            stitchslot = new StitchSlot(this.field_94318_c, 0, p_94311_1_.func_94197_a(), this.field_94315_d);
            this.field_94318_c += p_94311_1_.func_94197_a();
        }
        else
        {
            stitchslot = new StitchSlot(0, this.field_94315_d, this.field_94318_c, p_94311_1_.func_94199_b());
            this.field_94315_d += p_94311_1_.func_94199_b();
        }

        stitchslot.func_94182_a(p_94311_1_);
        this.field_94317_b.add(stitchslot);
        return true;
    }
}
