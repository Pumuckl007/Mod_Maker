package net.minecraft.block;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;

public class BlockBaseRailLogic
{
    private World field_94516_b;
    private int field_94517_c;
    private int field_94514_d;
    private int field_94515_e;
    private final boolean field_94512_f;
    private List field_94513_g;

    final BlockRailBase field_94518_a;

    public BlockBaseRailLogic(BlockRailBase p_i2166_1_, World p_i2166_2_, int p_i2166_3_, int p_i2166_4_, int p_i2166_5_)
    {
        this.field_94518_a = p_i2166_1_;
        this.field_94513_g = new ArrayList();
        this.field_94516_b = p_i2166_2_;
        this.field_94517_c = p_i2166_3_;
        this.field_94514_d = p_i2166_4_;
        this.field_94515_e = p_i2166_5_;
        int l = p_i2166_2_.func_72798_a(p_i2166_3_, p_i2166_4_, p_i2166_5_);
        int i1 = p_i2166_2_.func_72805_g(p_i2166_3_, p_i2166_4_, p_i2166_5_);

        if (((BlockRailBase)Block.field_71973_m[l]).field_72186_a)
        {
            this.field_94512_f = true;
            i1 &= -9;
        }
        else
        {
            this.field_94512_f = false;
        }

        this.func_94504_a(i1);
    }

    private void func_94504_a(int p_94504_1_)
    {
        this.field_94513_g.clear();

        if (p_94504_1_ == 0)
        {
            this.field_94513_g.add(new ChunkPosition(this.field_94517_c, this.field_94514_d, this.field_94515_e - 1));
            this.field_94513_g.add(new ChunkPosition(this.field_94517_c, this.field_94514_d, this.field_94515_e + 1));
        }
        else if (p_94504_1_ == 1)
        {
            this.field_94513_g.add(new ChunkPosition(this.field_94517_c - 1, this.field_94514_d, this.field_94515_e));
            this.field_94513_g.add(new ChunkPosition(this.field_94517_c + 1, this.field_94514_d, this.field_94515_e));
        }
        else if (p_94504_1_ == 2)
        {
            this.field_94513_g.add(new ChunkPosition(this.field_94517_c - 1, this.field_94514_d, this.field_94515_e));
            this.field_94513_g.add(new ChunkPosition(this.field_94517_c + 1, this.field_94514_d + 1, this.field_94515_e));
        }
        else if (p_94504_1_ == 3)
        {
            this.field_94513_g.add(new ChunkPosition(this.field_94517_c - 1, this.field_94514_d + 1, this.field_94515_e));
            this.field_94513_g.add(new ChunkPosition(this.field_94517_c + 1, this.field_94514_d, this.field_94515_e));
        }
        else if (p_94504_1_ == 4)
        {
            this.field_94513_g.add(new ChunkPosition(this.field_94517_c, this.field_94514_d + 1, this.field_94515_e - 1));
            this.field_94513_g.add(new ChunkPosition(this.field_94517_c, this.field_94514_d, this.field_94515_e + 1));
        }
        else if (p_94504_1_ == 5)
        {
            this.field_94513_g.add(new ChunkPosition(this.field_94517_c, this.field_94514_d, this.field_94515_e - 1));
            this.field_94513_g.add(new ChunkPosition(this.field_94517_c, this.field_94514_d + 1, this.field_94515_e + 1));
        }
        else if (p_94504_1_ == 6)
        {
            this.field_94513_g.add(new ChunkPosition(this.field_94517_c + 1, this.field_94514_d, this.field_94515_e));
            this.field_94513_g.add(new ChunkPosition(this.field_94517_c, this.field_94514_d, this.field_94515_e + 1));
        }
        else if (p_94504_1_ == 7)
        {
            this.field_94513_g.add(new ChunkPosition(this.field_94517_c - 1, this.field_94514_d, this.field_94515_e));
            this.field_94513_g.add(new ChunkPosition(this.field_94517_c, this.field_94514_d, this.field_94515_e + 1));
        }
        else if (p_94504_1_ == 8)
        {
            this.field_94513_g.add(new ChunkPosition(this.field_94517_c - 1, this.field_94514_d, this.field_94515_e));
            this.field_94513_g.add(new ChunkPosition(this.field_94517_c, this.field_94514_d, this.field_94515_e - 1));
        }
        else if (p_94504_1_ == 9)
        {
            this.field_94513_g.add(new ChunkPosition(this.field_94517_c + 1, this.field_94514_d, this.field_94515_e));
            this.field_94513_g.add(new ChunkPosition(this.field_94517_c, this.field_94514_d, this.field_94515_e - 1));
        }
    }

    private void func_94509_b()
    {
        for (int i = 0; i < this.field_94513_g.size(); ++i)
        {
            BlockBaseRailLogic blockbaseraillogic = this.func_94501_a((ChunkPosition)this.field_94513_g.get(i));

            if (blockbaseraillogic != null && blockbaseraillogic.func_94508_a(this))
            {
                this.field_94513_g.set(i, new ChunkPosition(blockbaseraillogic.field_94517_c, blockbaseraillogic.field_94514_d, blockbaseraillogic.field_94515_e));
            }
            else
            {
                this.field_94513_g.remove(i--);
            }
        }
    }

    private boolean func_94502_a(int p_94502_1_, int p_94502_2_, int p_94502_3_)
    {
        return BlockRailBase.func_72180_d_(this.field_94516_b, p_94502_1_, p_94502_2_, p_94502_3_) ? true : (BlockRailBase.func_72180_d_(this.field_94516_b, p_94502_1_, p_94502_2_ + 1, p_94502_3_) ? true : BlockRailBase.func_72180_d_(this.field_94516_b, p_94502_1_, p_94502_2_ - 1, p_94502_3_));
    }

    private BlockBaseRailLogic func_94501_a(ChunkPosition p_94501_1_)
    {
        return BlockRailBase.func_72180_d_(this.field_94516_b, p_94501_1_.field_76930_a, p_94501_1_.field_76928_b, p_94501_1_.field_76929_c) ? new BlockBaseRailLogic(this.field_94518_a, this.field_94516_b, p_94501_1_.field_76930_a, p_94501_1_.field_76928_b, p_94501_1_.field_76929_c) : (BlockRailBase.func_72180_d_(this.field_94516_b, p_94501_1_.field_76930_a, p_94501_1_.field_76928_b + 1, p_94501_1_.field_76929_c) ? new BlockBaseRailLogic(this.field_94518_a, this.field_94516_b, p_94501_1_.field_76930_a, p_94501_1_.field_76928_b + 1, p_94501_1_.field_76929_c) : (BlockRailBase.func_72180_d_(this.field_94516_b, p_94501_1_.field_76930_a, p_94501_1_.field_76928_b - 1, p_94501_1_.field_76929_c) ? new BlockBaseRailLogic(this.field_94518_a, this.field_94516_b, p_94501_1_.field_76930_a, p_94501_1_.field_76928_b - 1, p_94501_1_.field_76929_c) : null));
    }

    private boolean func_94508_a(BlockBaseRailLogic p_94508_1_)
    {
        for (int i = 0; i < this.field_94513_g.size(); ++i)
        {
            ChunkPosition chunkposition = (ChunkPosition)this.field_94513_g.get(i);

            if (chunkposition.field_76930_a == p_94508_1_.field_94517_c && chunkposition.field_76929_c == p_94508_1_.field_94515_e)
            {
                return true;
            }
        }

        return false;
    }

    private boolean func_94510_b(int p_94510_1_, int p_94510_2_, int p_94510_3_)
    {
        for (int l = 0; l < this.field_94513_g.size(); ++l)
        {
            ChunkPosition chunkposition = (ChunkPosition)this.field_94513_g.get(l);

            if (chunkposition.field_76930_a == p_94510_1_ && chunkposition.field_76929_c == p_94510_3_)
            {
                return true;
            }
        }

        return false;
    }

    public int func_94505_a()
    {
        int i = 0;

        if (this.func_94502_a(this.field_94517_c, this.field_94514_d, this.field_94515_e - 1))
        {
            ++i;
        }

        if (this.func_94502_a(this.field_94517_c, this.field_94514_d, this.field_94515_e + 1))
        {
            ++i;
        }

        if (this.func_94502_a(this.field_94517_c - 1, this.field_94514_d, this.field_94515_e))
        {
            ++i;
        }

        if (this.func_94502_a(this.field_94517_c + 1, this.field_94514_d, this.field_94515_e))
        {
            ++i;
        }

        return i;
    }

    private boolean func_94507_b(BlockBaseRailLogic p_94507_1_)
    {
        return this.func_94508_a(p_94507_1_) ? true : (this.field_94513_g.size() == 2 ? false : (this.field_94513_g.isEmpty() ? true : true));
    }

    private void func_94506_c(BlockBaseRailLogic p_94506_1_)
    {
        this.field_94513_g.add(new ChunkPosition(p_94506_1_.field_94517_c, p_94506_1_.field_94514_d, p_94506_1_.field_94515_e));
        boolean flag = this.func_94510_b(this.field_94517_c, this.field_94514_d, this.field_94515_e - 1);
        boolean flag1 = this.func_94510_b(this.field_94517_c, this.field_94514_d, this.field_94515_e + 1);
        boolean flag2 = this.func_94510_b(this.field_94517_c - 1, this.field_94514_d, this.field_94515_e);
        boolean flag3 = this.func_94510_b(this.field_94517_c + 1, this.field_94514_d, this.field_94515_e);
        byte b0 = -1;

        if (flag || flag1)
        {
            b0 = 0;
        }

        if (flag2 || flag3)
        {
            b0 = 1;
        }

        if (!this.field_94512_f)
        {
            if (flag1 && flag3 && !flag && !flag2)
            {
                b0 = 6;
            }

            if (flag1 && flag2 && !flag && !flag3)
            {
                b0 = 7;
            }

            if (flag && flag2 && !flag1 && !flag3)
            {
                b0 = 8;
            }

            if (flag && flag3 && !flag1 && !flag2)
            {
                b0 = 9;
            }
        }

        if (b0 == 0)
        {
            if (BlockRailBase.func_72180_d_(this.field_94516_b, this.field_94517_c, this.field_94514_d + 1, this.field_94515_e - 1))
            {
                b0 = 4;
            }

            if (BlockRailBase.func_72180_d_(this.field_94516_b, this.field_94517_c, this.field_94514_d + 1, this.field_94515_e + 1))
            {
                b0 = 5;
            }
        }

        if (b0 == 1)
        {
            if (BlockRailBase.func_72180_d_(this.field_94516_b, this.field_94517_c + 1, this.field_94514_d + 1, this.field_94515_e))
            {
                b0 = 2;
            }

            if (BlockRailBase.func_72180_d_(this.field_94516_b, this.field_94517_c - 1, this.field_94514_d + 1, this.field_94515_e))
            {
                b0 = 3;
            }
        }

        if (b0 < 0)
        {
            b0 = 0;
        }

        int i = b0;

        if (this.field_94512_f)
        {
            i = this.field_94516_b.func_72805_g(this.field_94517_c, this.field_94514_d, this.field_94515_e) & 8 | b0;
        }

        this.field_94516_b.func_72921_c(this.field_94517_c, this.field_94514_d, this.field_94515_e, i, 3);
    }

    private boolean func_94503_c(int p_94503_1_, int p_94503_2_, int p_94503_3_)
    {
        BlockBaseRailLogic blockbaseraillogic = this.func_94501_a(new ChunkPosition(p_94503_1_, p_94503_2_, p_94503_3_));

        if (blockbaseraillogic == null)
        {
            return false;
        }
        else
        {
            blockbaseraillogic.func_94509_b();
            return blockbaseraillogic.func_94507_b(this);
        }
    }

    public void func_94511_a(boolean p_94511_1_, boolean p_94511_2_)
    {
        boolean flag2 = this.func_94503_c(this.field_94517_c, this.field_94514_d, this.field_94515_e - 1);
        boolean flag3 = this.func_94503_c(this.field_94517_c, this.field_94514_d, this.field_94515_e + 1);
        boolean flag4 = this.func_94503_c(this.field_94517_c - 1, this.field_94514_d, this.field_94515_e);
        boolean flag5 = this.func_94503_c(this.field_94517_c + 1, this.field_94514_d, this.field_94515_e);
        byte b0 = -1;

        if ((flag2 || flag3) && !flag4 && !flag5)
        {
            b0 = 0;
        }

        if ((flag4 || flag5) && !flag2 && !flag3)
        {
            b0 = 1;
        }

        if (!this.field_94512_f)
        {
            if (flag3 && flag5 && !flag2 && !flag4)
            {
                b0 = 6;
            }

            if (flag3 && flag4 && !flag2 && !flag5)
            {
                b0 = 7;
            }

            if (flag2 && flag4 && !flag3 && !flag5)
            {
                b0 = 8;
            }

            if (flag2 && flag5 && !flag3 && !flag4)
            {
                b0 = 9;
            }
        }

        if (b0 == -1)
        {
            if (flag2 || flag3)
            {
                b0 = 0;
            }

            if (flag4 || flag5)
            {
                b0 = 1;
            }

            if (!this.field_94512_f)
            {
                if (p_94511_1_)
                {
                    if (flag3 && flag5)
                    {
                        b0 = 6;
                    }

                    if (flag4 && flag3)
                    {
                        b0 = 7;
                    }

                    if (flag5 && flag2)
                    {
                        b0 = 9;
                    }

                    if (flag2 && flag4)
                    {
                        b0 = 8;
                    }
                }
                else
                {
                    if (flag2 && flag4)
                    {
                        b0 = 8;
                    }

                    if (flag5 && flag2)
                    {
                        b0 = 9;
                    }

                    if (flag4 && flag3)
                    {
                        b0 = 7;
                    }

                    if (flag3 && flag5)
                    {
                        b0 = 6;
                    }
                }
            }
        }

        if (b0 == 0)
        {
            if (BlockRailBase.func_72180_d_(this.field_94516_b, this.field_94517_c, this.field_94514_d + 1, this.field_94515_e - 1))
            {
                b0 = 4;
            }

            if (BlockRailBase.func_72180_d_(this.field_94516_b, this.field_94517_c, this.field_94514_d + 1, this.field_94515_e + 1))
            {
                b0 = 5;
            }
        }

        if (b0 == 1)
        {
            if (BlockRailBase.func_72180_d_(this.field_94516_b, this.field_94517_c + 1, this.field_94514_d + 1, this.field_94515_e))
            {
                b0 = 2;
            }

            if (BlockRailBase.func_72180_d_(this.field_94516_b, this.field_94517_c - 1, this.field_94514_d + 1, this.field_94515_e))
            {
                b0 = 3;
            }
        }

        if (b0 < 0)
        {
            b0 = 0;
        }

        this.func_94504_a(b0);
        int i = b0;

        if (this.field_94512_f)
        {
            i = this.field_94516_b.func_72805_g(this.field_94517_c, this.field_94514_d, this.field_94515_e) & 8 | b0;
        }

        if (p_94511_2_ || this.field_94516_b.func_72805_g(this.field_94517_c, this.field_94514_d, this.field_94515_e) != i)
        {
            this.field_94516_b.func_72921_c(this.field_94517_c, this.field_94514_d, this.field_94515_e, i, 3);

            for (int j = 0; j < this.field_94513_g.size(); ++j)
            {
                BlockBaseRailLogic blockbaseraillogic = this.func_94501_a((ChunkPosition)this.field_94513_g.get(j));

                if (blockbaseraillogic != null)
                {
                    blockbaseraillogic.func_94509_b();

                    if (blockbaseraillogic.func_94507_b(this))
                    {
                        blockbaseraillogic.func_94506_c(this);
                    }
                }
            }
        }
    }
}
