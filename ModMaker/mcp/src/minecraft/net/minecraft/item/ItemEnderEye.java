package net.minecraft.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEndPortalFrame;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityEnderEye;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Direction;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;

public class ItemEnderEye extends Item
{
    public ItemEnderEye(int p_i1860_1_)
    {
        super(p_i1860_1_);
        this.func_77637_a(CreativeTabs.field_78026_f);
    }

    public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        int i1 = p_77648_3_.func_72798_a(p_77648_4_, p_77648_5_, p_77648_6_);
        int j1 = p_77648_3_.func_72805_g(p_77648_4_, p_77648_5_, p_77648_6_);

        if (p_77648_2_.func_82247_a(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_) && i1 == Block.field_72104_bI.field_71990_ca && !BlockEndPortalFrame.func_72165_e(j1))
        {
            if (p_77648_3_.field_72995_K)
            {
                return true;
            }
            else
            {
                p_77648_3_.func_72921_c(p_77648_4_, p_77648_5_, p_77648_6_, j1 + 4, 2);
                p_77648_3_.func_96440_m(p_77648_4_, p_77648_5_, p_77648_6_, Block.field_72104_bI.field_71990_ca);
                --p_77648_1_.field_77994_a;
                int k1;

                for (k1 = 0; k1 < 16; ++k1)
                {
                    double d0 = (double)((float)p_77648_4_ + (5.0F + field_77697_d.nextFloat() * 6.0F) / 16.0F);
                    double d1 = (double)((float)p_77648_5_ + 0.8125F);
                    double d2 = (double)((float)p_77648_6_ + (5.0F + field_77697_d.nextFloat() * 6.0F) / 16.0F);
                    double d3 = 0.0D;
                    double d4 = 0.0D;
                    double d5 = 0.0D;
                    p_77648_3_.func_72869_a("smoke", d0, d1, d2, d3, d4, d5);
                }

                k1 = j1 & 3;
                int l1 = 0;
                int i2 = 0;
                boolean flag = false;
                boolean flag1 = true;
                int j2 = Direction.field_71577_f[k1];
                int k2;
                int l2;
                int i3;
                int j3;
                int k3;

                for (k2 = -2; k2 <= 2; ++k2)
                {
                    j3 = p_77648_4_ + Direction.field_71583_a[j2] * k2;
                    l2 = p_77648_6_ + Direction.field_71581_b[j2] * k2;
                    k3 = p_77648_3_.func_72798_a(j3, p_77648_5_, l2);

                    if (k3 == Block.field_72104_bI.field_71990_ca)
                    {
                        i3 = p_77648_3_.func_72805_g(j3, p_77648_5_, l2);

                        if (!BlockEndPortalFrame.func_72165_e(i3))
                        {
                            flag1 = false;
                            break;
                        }

                        i2 = k2;

                        if (!flag)
                        {
                            l1 = k2;
                            flag = true;
                        }
                    }
                }

                if (flag1 && i2 == l1 + 2)
                {
                    for (k2 = l1; k2 <= i2; ++k2)
                    {
                        j3 = p_77648_4_ + Direction.field_71583_a[j2] * k2;
                        l2 = p_77648_6_ + Direction.field_71581_b[j2] * k2;
                        j3 += Direction.field_71583_a[k1] * 4;
                        l2 += Direction.field_71581_b[k1] * 4;
                        k3 = p_77648_3_.func_72798_a(j3, p_77648_5_, l2);
                        i3 = p_77648_3_.func_72805_g(j3, p_77648_5_, l2);

                        if (k3 != Block.field_72104_bI.field_71990_ca || !BlockEndPortalFrame.func_72165_e(i3))
                        {
                            flag1 = false;
                            break;
                        }
                    }

                    for (k2 = l1 - 1; k2 <= i2 + 1; k2 += 4)
                    {
                        for (j3 = 1; j3 <= 3; ++j3)
                        {
                            l2 = p_77648_4_ + Direction.field_71583_a[j2] * k2;
                            k3 = p_77648_6_ + Direction.field_71581_b[j2] * k2;
                            l2 += Direction.field_71583_a[k1] * j3;
                            k3 += Direction.field_71581_b[k1] * j3;
                            i3 = p_77648_3_.func_72798_a(l2, p_77648_5_, k3);
                            int l3 = p_77648_3_.func_72805_g(l2, p_77648_5_, k3);

                            if (i3 != Block.field_72104_bI.field_71990_ca || !BlockEndPortalFrame.func_72165_e(l3))
                            {
                                flag1 = false;
                                break;
                            }
                        }
                    }

                    if (flag1)
                    {
                        for (k2 = l1; k2 <= i2; ++k2)
                        {
                            for (j3 = 1; j3 <= 3; ++j3)
                            {
                                l2 = p_77648_4_ + Direction.field_71583_a[j2] * k2;
                                k3 = p_77648_6_ + Direction.field_71581_b[j2] * k2;
                                l2 += Direction.field_71583_a[k1] * j3;
                                k3 += Direction.field_71581_b[k1] * j3;
                                p_77648_3_.func_72832_d(l2, p_77648_5_, k3, Block.field_72102_bH.field_71990_ca, 0, 2);
                            }
                        }
                    }
                }

                return true;
            }
        }
        else
        {
            return false;
        }
    }

    public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
    {
        MovingObjectPosition movingobjectposition = this.func_77621_a(p_77659_2_, p_77659_3_, false);

        if (movingobjectposition != null && movingobjectposition.field_72313_a == EnumMovingObjectType.TILE)
        {
            int i = p_77659_2_.func_72798_a(movingobjectposition.field_72311_b, movingobjectposition.field_72312_c, movingobjectposition.field_72309_d);

            if (i == Block.field_72104_bI.field_71990_ca)
            {
                return p_77659_1_;
            }
        }

        if (!p_77659_2_.field_72995_K)
        {
            ChunkPosition chunkposition = p_77659_2_.func_72946_b("Stronghold", (int)p_77659_3_.field_70165_t, (int)p_77659_3_.field_70163_u, (int)p_77659_3_.field_70161_v);

            if (chunkposition != null)
            {
                EntityEnderEye entityendereye = new EntityEnderEye(p_77659_2_, p_77659_3_.field_70165_t, p_77659_3_.field_70163_u + 1.62D - (double)p_77659_3_.field_70129_M, p_77659_3_.field_70161_v);
                entityendereye.func_70220_a((double)chunkposition.field_76930_a, chunkposition.field_76928_b, (double)chunkposition.field_76929_c);
                p_77659_2_.func_72838_d(entityendereye);
                p_77659_2_.func_72956_a(p_77659_3_, "random.bow", 0.5F, 0.4F / (field_77697_d.nextFloat() * 0.4F + 0.8F));
                p_77659_2_.func_72889_a((EntityPlayer)null, 1002, (int)p_77659_3_.field_70165_t, (int)p_77659_3_.field_70163_u, (int)p_77659_3_.field_70161_v, 0);

                if (!p_77659_3_.field_71075_bZ.field_75098_d)
                {
                    --p_77659_1_.field_77994_a;
                }
            }
        }

        return p_77659_1_;
    }
}
