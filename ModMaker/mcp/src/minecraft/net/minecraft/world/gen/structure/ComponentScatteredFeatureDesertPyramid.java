package net.minecraft.world.gen.structure;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Direction;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;

public class ComponentScatteredFeatureDesertPyramid extends ComponentScatteredFeature
{
    private boolean[] field_74940_h = new boolean[4];
    public static final WeightedRandomChestContent[] field_74941_i = new WeightedRandomChestContent[] {new WeightedRandomChestContent(Item.field_77702_n.field_77779_bT, 0, 1, 3, 3), new WeightedRandomChestContent(Item.field_77703_o.field_77779_bT, 0, 1, 5, 10), new WeightedRandomChestContent(Item.field_77717_p.field_77779_bT, 0, 2, 7, 15), new WeightedRandomChestContent(Item.field_77817_bH.field_77779_bT, 0, 1, 3, 2), new WeightedRandomChestContent(Item.field_77755_aX.field_77779_bT, 0, 4, 6, 20), new WeightedRandomChestContent(Item.field_77737_bm.field_77779_bT, 0, 3, 7, 16), new WeightedRandomChestContent(Item.field_77765_aA.field_77779_bT, 0, 1, 1, 3), new WeightedRandomChestContent(Item.field_111215_ce.field_77779_bT, 0, 1, 1, 1), new WeightedRandomChestContent(Item.field_111216_cf.field_77779_bT, 0, 1, 1, 1), new WeightedRandomChestContent(Item.field_111213_cg.field_77779_bT, 0, 1, 1, 1)};

    public ComponentScatteredFeatureDesertPyramid() {}

    public ComponentScatteredFeatureDesertPyramid(Random p_i2062_1_, int p_i2062_2_, int p_i2062_3_)
    {
        super(p_i2062_1_, p_i2062_2_, 64, p_i2062_3_, 21, 15, 21);
    }

    protected void func_143012_a(NBTTagCompound p_143012_1_)
    {
        super.func_143012_a(p_143012_1_);
        p_143012_1_.func_74757_a("hasPlacedChest0", this.field_74940_h[0]);
        p_143012_1_.func_74757_a("hasPlacedChest1", this.field_74940_h[1]);
        p_143012_1_.func_74757_a("hasPlacedChest2", this.field_74940_h[2]);
        p_143012_1_.func_74757_a("hasPlacedChest3", this.field_74940_h[3]);
    }

    protected void func_143011_b(NBTTagCompound p_143011_1_)
    {
        super.func_143011_b(p_143011_1_);
        this.field_74940_h[0] = p_143011_1_.func_74767_n("hasPlacedChest0");
        this.field_74940_h[1] = p_143011_1_.func_74767_n("hasPlacedChest1");
        this.field_74940_h[2] = p_143011_1_.func_74767_n("hasPlacedChest2");
        this.field_74940_h[3] = p_143011_1_.func_74767_n("hasPlacedChest3");
    }

    public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
    {
        this.func_74884_a(p_74875_1_, p_74875_3_, 0, -4, 0, this.field_74939_a - 1, 0, this.field_74938_c - 1, Block.field_71957_Q.field_71990_ca, Block.field_71957_Q.field_71990_ca, false);
        int i;

        for (i = 1; i <= 9; ++i)
        {
            this.func_74884_a(p_74875_1_, p_74875_3_, i, i, i, this.field_74939_a - 1 - i, i, this.field_74938_c - 1 - i, Block.field_71957_Q.field_71990_ca, Block.field_71957_Q.field_71990_ca, false);
            this.func_74884_a(p_74875_1_, p_74875_3_, i + 1, i, i + 1, this.field_74939_a - 2 - i, i, this.field_74938_c - 2 - i, 0, 0, false);
        }

        int j;

        for (i = 0; i < this.field_74939_a; ++i)
        {
            for (j = 0; j < this.field_74938_c; ++j)
            {
                this.func_74870_b(p_74875_1_, Block.field_71957_Q.field_71990_ca, 0, i, -5, j, p_74875_3_);
            }
        }

        i = this.func_74863_c(Block.field_72088_bQ.field_71990_ca, 3);
        j = this.func_74863_c(Block.field_72088_bQ.field_71990_ca, 2);
        int k = this.func_74863_c(Block.field_72088_bQ.field_71990_ca, 0);
        int l = this.func_74863_c(Block.field_72088_bQ.field_71990_ca, 1);
        byte b0 = 1;
        byte b1 = 11;
        this.func_74884_a(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 9, 4, Block.field_71957_Q.field_71990_ca, 0, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 1, 10, 1, 3, 10, 3, Block.field_71957_Q.field_71990_ca, Block.field_71957_Q.field_71990_ca, false);
        this.func_74864_a(p_74875_1_, Block.field_72088_bQ.field_71990_ca, i, 2, 10, 0, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72088_bQ.field_71990_ca, j, 2, 10, 4, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72088_bQ.field_71990_ca, k, 0, 10, 2, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72088_bQ.field_71990_ca, l, 4, 10, 2, p_74875_3_);
        this.func_74884_a(p_74875_1_, p_74875_3_, this.field_74939_a - 5, 0, 0, this.field_74939_a - 1, 9, 4, Block.field_71957_Q.field_71990_ca, 0, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, this.field_74939_a - 4, 10, 1, this.field_74939_a - 2, 10, 3, Block.field_71957_Q.field_71990_ca, Block.field_71957_Q.field_71990_ca, false);
        this.func_74864_a(p_74875_1_, Block.field_72088_bQ.field_71990_ca, i, this.field_74939_a - 3, 10, 0, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72088_bQ.field_71990_ca, j, this.field_74939_a - 3, 10, 4, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72088_bQ.field_71990_ca, k, this.field_74939_a - 5, 10, 2, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72088_bQ.field_71990_ca, l, this.field_74939_a - 1, 10, 2, p_74875_3_);
        this.func_74884_a(p_74875_1_, p_74875_3_, 8, 0, 0, 12, 4, 4, Block.field_71957_Q.field_71990_ca, 0, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 9, 1, 0, 11, 3, 4, 0, 0, false);
        this.func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, 9, 1, 1, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, 9, 2, 1, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, 9, 3, 1, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, 10, 3, 1, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, 11, 3, 1, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, 11, 2, 1, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, 11, 1, 1, p_74875_3_);
        this.func_74884_a(p_74875_1_, p_74875_3_, 4, 1, 1, 8, 3, 3, Block.field_71957_Q.field_71990_ca, 0, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 4, 1, 2, 8, 2, 2, 0, 0, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 12, 1, 1, 16, 3, 3, Block.field_71957_Q.field_71990_ca, 0, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 12, 1, 2, 16, 2, 2, 0, 0, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 5, 4, 5, this.field_74939_a - 6, 4, this.field_74938_c - 6, Block.field_71957_Q.field_71990_ca, Block.field_71957_Q.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 9, 4, 9, 11, 4, 11, 0, 0, false);
        this.func_74872_a(p_74875_1_, p_74875_3_, 8, 1, 8, 8, 3, 8, Block.field_71957_Q.field_71990_ca, 2, Block.field_71957_Q.field_71990_ca, 2, false);
        this.func_74872_a(p_74875_1_, p_74875_3_, 12, 1, 8, 12, 3, 8, Block.field_71957_Q.field_71990_ca, 2, Block.field_71957_Q.field_71990_ca, 2, false);
        this.func_74872_a(p_74875_1_, p_74875_3_, 8, 1, 12, 8, 3, 12, Block.field_71957_Q.field_71990_ca, 2, Block.field_71957_Q.field_71990_ca, 2, false);
        this.func_74872_a(p_74875_1_, p_74875_3_, 12, 1, 12, 12, 3, 12, Block.field_71957_Q.field_71990_ca, 2, Block.field_71957_Q.field_71990_ca, 2, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 1, 1, 5, 4, 4, 11, Block.field_71957_Q.field_71990_ca, Block.field_71957_Q.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, this.field_74939_a - 5, 1, 5, this.field_74939_a - 2, 4, 11, Block.field_71957_Q.field_71990_ca, Block.field_71957_Q.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 6, 7, 9, 6, 7, 11, Block.field_71957_Q.field_71990_ca, Block.field_71957_Q.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, this.field_74939_a - 7, 7, 9, this.field_74939_a - 7, 7, 11, Block.field_71957_Q.field_71990_ca, Block.field_71957_Q.field_71990_ca, false);
        this.func_74872_a(p_74875_1_, p_74875_3_, 5, 5, 9, 5, 7, 11, Block.field_71957_Q.field_71990_ca, 2, Block.field_71957_Q.field_71990_ca, 2, false);
        this.func_74872_a(p_74875_1_, p_74875_3_, this.field_74939_a - 6, 5, 9, this.field_74939_a - 6, 7, 11, Block.field_71957_Q.field_71990_ca, 2, Block.field_71957_Q.field_71990_ca, 2, false);
        this.func_74864_a(p_74875_1_, 0, 0, 5, 5, 10, p_74875_3_);
        this.func_74864_a(p_74875_1_, 0, 0, 5, 6, 10, p_74875_3_);
        this.func_74864_a(p_74875_1_, 0, 0, 6, 6, 10, p_74875_3_);
        this.func_74864_a(p_74875_1_, 0, 0, this.field_74939_a - 6, 5, 10, p_74875_3_);
        this.func_74864_a(p_74875_1_, 0, 0, this.field_74939_a - 6, 6, 10, p_74875_3_);
        this.func_74864_a(p_74875_1_, 0, 0, this.field_74939_a - 7, 6, 10, p_74875_3_);
        this.func_74884_a(p_74875_1_, p_74875_3_, 2, 4, 4, 2, 6, 4, 0, 0, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, this.field_74939_a - 3, 4, 4, this.field_74939_a - 3, 6, 4, 0, 0, false);
        this.func_74864_a(p_74875_1_, Block.field_72088_bQ.field_71990_ca, i, 2, 4, 5, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72088_bQ.field_71990_ca, i, 2, 3, 4, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72088_bQ.field_71990_ca, i, this.field_74939_a - 3, 4, 5, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72088_bQ.field_71990_ca, i, this.field_74939_a - 3, 3, 4, p_74875_3_);
        this.func_74884_a(p_74875_1_, p_74875_3_, 1, 1, 3, 2, 2, 3, Block.field_71957_Q.field_71990_ca, Block.field_71957_Q.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, this.field_74939_a - 3, 1, 3, this.field_74939_a - 2, 2, 3, Block.field_71957_Q.field_71990_ca, Block.field_71957_Q.field_71990_ca, false);
        this.func_74864_a(p_74875_1_, Block.field_72088_bQ.field_71990_ca, 0, 1, 1, 2, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72088_bQ.field_71990_ca, 0, this.field_74939_a - 2, 1, 2, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72079_ak.field_71990_ca, 1, 1, 2, 2, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72079_ak.field_71990_ca, 1, this.field_74939_a - 2, 2, 2, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72088_bQ.field_71990_ca, l, 2, 1, 2, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72088_bQ.field_71990_ca, k, this.field_74939_a - 3, 1, 2, p_74875_3_);
        this.func_74884_a(p_74875_1_, p_74875_3_, 4, 3, 5, 4, 3, 18, Block.field_71957_Q.field_71990_ca, Block.field_71957_Q.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, this.field_74939_a - 5, 3, 5, this.field_74939_a - 5, 3, 17, Block.field_71957_Q.field_71990_ca, Block.field_71957_Q.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 3, 1, 5, 4, 2, 16, 0, 0, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, this.field_74939_a - 6, 1, 5, this.field_74939_a - 5, 2, 16, 0, 0, false);
        int i1;

        for (i1 = 5; i1 <= 17; i1 += 2)
        {
            this.func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, 4, 1, i1, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 1, 4, 2, i1, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, this.field_74939_a - 5, 1, i1, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 1, this.field_74939_a - 5, 2, i1, p_74875_3_);
        }

        this.func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, b0, 10, 0, 7, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, b0, 10, 0, 8, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, b0, 9, 0, 9, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, b0, 11, 0, 9, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, b0, 8, 0, 10, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, b0, 12, 0, 10, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, b0, 7, 0, 10, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, b0, 13, 0, 10, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, b0, 9, 0, 11, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, b0, 11, 0, 11, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, b0, 10, 0, 12, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, b0, 10, 0, 13, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, b1, 10, 0, 10, p_74875_3_);

        for (i1 = 0; i1 <= this.field_74939_a - 1; i1 += this.field_74939_a - 1)
        {
            this.func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, i1, 2, 1, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, b0, i1, 2, 2, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, i1, 2, 3, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, i1, 3, 1, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, b0, i1, 3, 2, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, i1, 3, 3, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, b0, i1, 4, 1, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 1, i1, 4, 2, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, b0, i1, 4, 3, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, i1, 5, 1, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, b0, i1, 5, 2, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, i1, 5, 3, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, b0, i1, 6, 1, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 1, i1, 6, 2, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, b0, i1, 6, 3, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, b0, i1, 7, 1, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, b0, i1, 7, 2, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, b0, i1, 7, 3, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, i1, 8, 1, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, i1, 8, 2, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, i1, 8, 3, p_74875_3_);
        }

        for (i1 = 2; i1 <= this.field_74939_a - 3; i1 += this.field_74939_a - 3 - 2)
        {
            this.func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, i1 - 1, 2, 0, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, b0, i1, 2, 0, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, i1 + 1, 2, 0, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, i1 - 1, 3, 0, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, b0, i1, 3, 0, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, i1 + 1, 3, 0, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, b0, i1 - 1, 4, 0, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 1, i1, 4, 0, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, b0, i1 + 1, 4, 0, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, i1 - 1, 5, 0, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, b0, i1, 5, 0, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, i1 + 1, 5, 0, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, b0, i1 - 1, 6, 0, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 1, i1, 6, 0, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, b0, i1 + 1, 6, 0, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, b0, i1 - 1, 7, 0, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, b0, i1, 7, 0, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, b0, i1 + 1, 7, 0, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, i1 - 1, 8, 0, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, i1, 8, 0, p_74875_3_);
            this.func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, i1 + 1, 8, 0, p_74875_3_);
        }

        this.func_74872_a(p_74875_1_, p_74875_3_, 8, 4, 0, 12, 6, 0, Block.field_71957_Q.field_71990_ca, 2, Block.field_71957_Q.field_71990_ca, 2, false);
        this.func_74864_a(p_74875_1_, 0, 0, 8, 6, 0, p_74875_3_);
        this.func_74864_a(p_74875_1_, 0, 0, 12, 6, 0, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, b0, 9, 5, 0, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 1, 10, 5, 0, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, b0, 11, 5, 0, p_74875_3_);
        this.func_74872_a(p_74875_1_, p_74875_3_, 8, -14, 8, 12, -11, 12, Block.field_71957_Q.field_71990_ca, 2, Block.field_71957_Q.field_71990_ca, 2, false);
        this.func_74872_a(p_74875_1_, p_74875_3_, 8, -10, 8, 12, -10, 12, Block.field_71957_Q.field_71990_ca, 1, Block.field_71957_Q.field_71990_ca, 1, false);
        this.func_74872_a(p_74875_1_, p_74875_3_, 8, -9, 8, 12, -9, 12, Block.field_71957_Q.field_71990_ca, 2, Block.field_71957_Q.field_71990_ca, 2, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 8, -8, 8, 12, -1, 12, Block.field_71957_Q.field_71990_ca, Block.field_71957_Q.field_71990_ca, false);
        this.func_74884_a(p_74875_1_, p_74875_3_, 9, -11, 9, 11, -1, 11, 0, 0, false);
        this.func_74864_a(p_74875_1_, Block.field_72044_aK.field_71990_ca, 0, 10, -11, 10, p_74875_3_);
        this.func_74884_a(p_74875_1_, p_74875_3_, 9, -13, 9, 11, -13, 11, Block.field_72091_am.field_71990_ca, 0, false);
        this.func_74864_a(p_74875_1_, 0, 0, 8, -11, 10, p_74875_3_);
        this.func_74864_a(p_74875_1_, 0, 0, 8, -10, 10, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 1, 7, -10, 10, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, 7, -11, 10, p_74875_3_);
        this.func_74864_a(p_74875_1_, 0, 0, 12, -11, 10, p_74875_3_);
        this.func_74864_a(p_74875_1_, 0, 0, 12, -10, 10, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 1, 13, -10, 10, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, 13, -11, 10, p_74875_3_);
        this.func_74864_a(p_74875_1_, 0, 0, 10, -11, 8, p_74875_3_);
        this.func_74864_a(p_74875_1_, 0, 0, 10, -10, 8, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 1, 10, -10, 7, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, 10, -11, 7, p_74875_3_);
        this.func_74864_a(p_74875_1_, 0, 0, 10, -11, 12, p_74875_3_);
        this.func_74864_a(p_74875_1_, 0, 0, 10, -10, 12, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 1, 10, -10, 13, p_74875_3_);
        this.func_74864_a(p_74875_1_, Block.field_71957_Q.field_71990_ca, 2, 10, -11, 13, p_74875_3_);

        for (i1 = 0; i1 < 4; ++i1)
        {
            if (!this.field_74940_h[i1])
            {
                int j1 = Direction.field_71583_a[i1] * 2;
                int k1 = Direction.field_71581_b[i1] * 2;
                this.field_74940_h[i1] = this.func_74879_a(p_74875_1_, p_74875_3_, p_74875_2_, 10 + j1, -11, 10 + k1, WeightedRandomChestContent.func_92080_a(field_74941_i, new WeightedRandomChestContent[] {Item.field_92105_bW.func_92114_b(p_74875_2_)}), 2 + p_74875_2_.nextInt(5));
            }
        }

        return true;
    }
}
