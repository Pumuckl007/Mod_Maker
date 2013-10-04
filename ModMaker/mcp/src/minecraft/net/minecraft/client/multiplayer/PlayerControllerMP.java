package net.minecraft.client.multiplayer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.network.packet.Packet102WindowClick;
import net.minecraft.network.packet.Packet107CreativeSetSlot;
import net.minecraft.network.packet.Packet108EnchantItem;
import net.minecraft.network.packet.Packet14BlockDig;
import net.minecraft.network.packet.Packet15Place;
import net.minecraft.network.packet.Packet16BlockItemSwitch;
import net.minecraft.network.packet.Packet7UseEntity;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumGameType;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class PlayerControllerMP
{
    private final Minecraft field_78776_a;
    private final NetClientHandler field_78774_b;
    private int field_78775_c = -1;
    private int field_78772_d = -1;
    private int field_78773_e = -1;
    private ItemStack field_85183_f;
    private float field_78770_f;
    private float field_78780_h;
    private int field_78781_i;
    private boolean field_78778_j;
    private EnumGameType field_78779_k;
    private int field_78777_l;

    public PlayerControllerMP(Minecraft p_i1185_1_, NetClientHandler p_i1185_2_)
    {
        this.field_78779_k = EnumGameType.SURVIVAL;
        this.field_78776_a = p_i1185_1_;
        this.field_78774_b = p_i1185_2_;
    }

    public static void func_78744_a(Minecraft p_78744_0_, PlayerControllerMP p_78744_1_, int p_78744_2_, int p_78744_3_, int p_78744_4_, int p_78744_5_)
    {
        if (!p_78744_0_.field_71441_e.func_72886_a(p_78744_0_.field_71439_g, p_78744_2_, p_78744_3_, p_78744_4_, p_78744_5_))
        {
            p_78744_1_.func_78751_a(p_78744_2_, p_78744_3_, p_78744_4_, p_78744_5_);
        }
    }

    public void func_78748_a(EntityPlayer p_78748_1_)
    {
        this.field_78779_k.func_77147_a(p_78748_1_.field_71075_bZ);
    }

    public boolean func_78747_a()
    {
        return false;
    }

    public void func_78746_a(EnumGameType p_78746_1_)
    {
        this.field_78779_k = p_78746_1_;
        this.field_78779_k.func_77147_a(this.field_78776_a.field_71439_g.field_71075_bZ);
    }

    public void func_78745_b(EntityPlayer p_78745_1_)
    {
        p_78745_1_.field_70177_z = -180.0F;
    }

    public boolean func_78755_b()
    {
        return this.field_78779_k.func_77144_e();
    }

    public boolean func_78751_a(int p_78751_1_, int p_78751_2_, int p_78751_3_, int p_78751_4_)
    {
        if (this.field_78779_k.func_82752_c() && !this.field_78776_a.field_71439_g.func_82246_f(p_78751_1_, p_78751_2_, p_78751_3_))
        {
            return false;
        }
        else if (this.field_78779_k.func_77145_d() && this.field_78776_a.field_71439_g.func_70694_bm() != null && this.field_78776_a.field_71439_g.func_70694_bm().func_77973_b() instanceof ItemSword)
        {
            return false;
        }
        else
        {
            WorldClient worldclient = this.field_78776_a.field_71441_e;
            Block block = Block.field_71973_m[worldclient.func_72798_a(p_78751_1_, p_78751_2_, p_78751_3_)];

            if (block == null)
            {
                return false;
            }
            else
            {
                worldclient.func_72926_e(2001, p_78751_1_, p_78751_2_, p_78751_3_, block.field_71990_ca + (worldclient.func_72805_g(p_78751_1_, p_78751_2_, p_78751_3_) << 12));
                int i1 = worldclient.func_72805_g(p_78751_1_, p_78751_2_, p_78751_3_);
                boolean flag = worldclient.func_94571_i(p_78751_1_, p_78751_2_, p_78751_3_);

                if (flag)
                {
                    block.func_71898_d(worldclient, p_78751_1_, p_78751_2_, p_78751_3_, i1);
                }

                this.field_78772_d = -1;

                if (!this.field_78779_k.func_77145_d())
                {
                    ItemStack itemstack = this.field_78776_a.field_71439_g.func_71045_bC();

                    if (itemstack != null)
                    {
                        itemstack.func_77941_a(worldclient, block.field_71990_ca, p_78751_1_, p_78751_2_, p_78751_3_, this.field_78776_a.field_71439_g);

                        if (itemstack.field_77994_a == 0)
                        {
                            this.field_78776_a.field_71439_g.func_71028_bD();
                        }
                    }
                }

                return flag;
            }
        }
    }

    public void func_78743_b(int p_78743_1_, int p_78743_2_, int p_78743_3_, int p_78743_4_)
    {
        if (!this.field_78779_k.func_82752_c() || this.field_78776_a.field_71439_g.func_82246_f(p_78743_1_, p_78743_2_, p_78743_3_))
        {
            if (this.field_78779_k.func_77145_d())
            {
                this.field_78774_b.func_72552_c(new Packet14BlockDig(0, p_78743_1_, p_78743_2_, p_78743_3_, p_78743_4_));
                func_78744_a(this.field_78776_a, this, p_78743_1_, p_78743_2_, p_78743_3_, p_78743_4_);
                this.field_78781_i = 5;
            }
            else if (!this.field_78778_j || !this.func_85182_a(p_78743_1_, p_78743_2_, p_78743_3_))
            {
                if (this.field_78778_j)
                {
                    this.field_78774_b.func_72552_c(new Packet14BlockDig(1, this.field_78775_c, this.field_78772_d, this.field_78773_e, p_78743_4_));
                }

                this.field_78774_b.func_72552_c(new Packet14BlockDig(0, p_78743_1_, p_78743_2_, p_78743_3_, p_78743_4_));
                int i1 = this.field_78776_a.field_71441_e.func_72798_a(p_78743_1_, p_78743_2_, p_78743_3_);

                if (i1 > 0 && this.field_78770_f == 0.0F)
                {
                    Block.field_71973_m[i1].func_71921_a(this.field_78776_a.field_71441_e, p_78743_1_, p_78743_2_, p_78743_3_, this.field_78776_a.field_71439_g);
                }

                if (i1 > 0 && Block.field_71973_m[i1].func_71908_a(this.field_78776_a.field_71439_g, this.field_78776_a.field_71439_g.field_70170_p, p_78743_1_, p_78743_2_, p_78743_3_) >= 1.0F)
                {
                    this.func_78751_a(p_78743_1_, p_78743_2_, p_78743_3_, p_78743_4_);
                }
                else
                {
                    this.field_78778_j = true;
                    this.field_78775_c = p_78743_1_;
                    this.field_78772_d = p_78743_2_;
                    this.field_78773_e = p_78743_3_;
                    this.field_85183_f = this.field_78776_a.field_71439_g.func_70694_bm();
                    this.field_78770_f = 0.0F;
                    this.field_78780_h = 0.0F;
                    this.field_78776_a.field_71441_e.func_72888_f(this.field_78776_a.field_71439_g.field_70157_k, this.field_78775_c, this.field_78772_d, this.field_78773_e, (int)(this.field_78770_f * 10.0F) - 1);
                }
            }
        }
    }

    public void func_78767_c()
    {
        if (this.field_78778_j)
        {
            this.field_78774_b.func_72552_c(new Packet14BlockDig(1, this.field_78775_c, this.field_78772_d, this.field_78773_e, -1));
        }

        this.field_78778_j = false;
        this.field_78770_f = 0.0F;
        this.field_78776_a.field_71441_e.func_72888_f(this.field_78776_a.field_71439_g.field_70157_k, this.field_78775_c, this.field_78772_d, this.field_78773_e, -1);
    }

    public void func_78759_c(int p_78759_1_, int p_78759_2_, int p_78759_3_, int p_78759_4_)
    {
        this.func_78750_j();

        if (this.field_78781_i > 0)
        {
            --this.field_78781_i;
        }
        else if (this.field_78779_k.func_77145_d())
        {
            this.field_78781_i = 5;
            this.field_78774_b.func_72552_c(new Packet14BlockDig(0, p_78759_1_, p_78759_2_, p_78759_3_, p_78759_4_));
            func_78744_a(this.field_78776_a, this, p_78759_1_, p_78759_2_, p_78759_3_, p_78759_4_);
        }
        else
        {
            if (this.func_85182_a(p_78759_1_, p_78759_2_, p_78759_3_))
            {
                int i1 = this.field_78776_a.field_71441_e.func_72798_a(p_78759_1_, p_78759_2_, p_78759_3_);

                if (i1 == 0)
                {
                    this.field_78778_j = false;
                    return;
                }

                Block block = Block.field_71973_m[i1];
                this.field_78770_f += block.func_71908_a(this.field_78776_a.field_71439_g, this.field_78776_a.field_71439_g.field_70170_p, p_78759_1_, p_78759_2_, p_78759_3_);

                if (this.field_78780_h % 4.0F == 0.0F && block != null)
                {
                    this.field_78776_a.field_71416_A.func_77364_b(block.field_72020_cn.func_72675_d(), (float)p_78759_1_ + 0.5F, (float)p_78759_2_ + 0.5F, (float)p_78759_3_ + 0.5F, (block.field_72020_cn.func_72677_b() + 1.0F) / 8.0F, block.field_72020_cn.func_72678_c() * 0.5F);
                }

                ++this.field_78780_h;

                if (this.field_78770_f >= 1.0F)
                {
                    this.field_78778_j = false;
                    this.field_78774_b.func_72552_c(new Packet14BlockDig(2, p_78759_1_, p_78759_2_, p_78759_3_, p_78759_4_));
                    this.func_78751_a(p_78759_1_, p_78759_2_, p_78759_3_, p_78759_4_);
                    this.field_78770_f = 0.0F;
                    this.field_78780_h = 0.0F;
                    this.field_78781_i = 5;
                }

                this.field_78776_a.field_71441_e.func_72888_f(this.field_78776_a.field_71439_g.field_70157_k, this.field_78775_c, this.field_78772_d, this.field_78773_e, (int)(this.field_78770_f * 10.0F) - 1);
            }
            else
            {
                this.func_78743_b(p_78759_1_, p_78759_2_, p_78759_3_, p_78759_4_);
            }
        }
    }

    public float func_78757_d()
    {
        return this.field_78779_k.func_77145_d() ? 5.0F : 4.5F;
    }

    public void func_78765_e()
    {
        this.func_78750_j();
        this.field_78776_a.field_71416_A.func_77371_c();
    }

    private boolean func_85182_a(int p_85182_1_, int p_85182_2_, int p_85182_3_)
    {
        ItemStack itemstack = this.field_78776_a.field_71439_g.func_70694_bm();
        boolean flag = this.field_85183_f == null && itemstack == null;

        if (this.field_85183_f != null && itemstack != null)
        {
            flag = itemstack.field_77993_c == this.field_85183_f.field_77993_c && ItemStack.func_77970_a(itemstack, this.field_85183_f) && (itemstack.func_77984_f() || itemstack.func_77960_j() == this.field_85183_f.func_77960_j());
        }

        return p_85182_1_ == this.field_78775_c && p_85182_2_ == this.field_78772_d && p_85182_3_ == this.field_78773_e && flag;
    }

    private void func_78750_j()
    {
        int i = this.field_78776_a.field_71439_g.field_71071_by.field_70461_c;

        if (i != this.field_78777_l)
        {
            this.field_78777_l = i;
            this.field_78774_b.func_72552_c(new Packet16BlockItemSwitch(this.field_78777_l));
        }
    }

    public boolean func_78760_a(EntityPlayer p_78760_1_, World p_78760_2_, ItemStack p_78760_3_, int p_78760_4_, int p_78760_5_, int p_78760_6_, int p_78760_7_, Vec3 p_78760_8_)
    {
        this.func_78750_j();
        float f = (float)p_78760_8_.field_72450_a - (float)p_78760_4_;
        float f1 = (float)p_78760_8_.field_72448_b - (float)p_78760_5_;
        float f2 = (float)p_78760_8_.field_72449_c - (float)p_78760_6_;
        boolean flag = false;
        int i1;

        if (!p_78760_1_.func_70093_af() || p_78760_1_.func_70694_bm() == null)
        {
            i1 = p_78760_2_.func_72798_a(p_78760_4_, p_78760_5_, p_78760_6_);

            if (i1 > 0 && Block.field_71973_m[i1].func_71903_a(p_78760_2_, p_78760_4_, p_78760_5_, p_78760_6_, p_78760_1_, p_78760_7_, f, f1, f2))
            {
                flag = true;
            }
        }

        if (!flag && p_78760_3_ != null && p_78760_3_.func_77973_b() instanceof ItemBlock)
        {
            ItemBlock itemblock = (ItemBlock)p_78760_3_.func_77973_b();

            if (!itemblock.func_77884_a(p_78760_2_, p_78760_4_, p_78760_5_, p_78760_6_, p_78760_7_, p_78760_1_, p_78760_3_))
            {
                return false;
            }
        }

        this.field_78774_b.func_72552_c(new Packet15Place(p_78760_4_, p_78760_5_, p_78760_6_, p_78760_7_, p_78760_1_.field_71071_by.func_70448_g(), f, f1, f2));

        if (flag)
        {
            return true;
        }
        else if (p_78760_3_ == null)
        {
            return false;
        }
        else if (this.field_78779_k.func_77145_d())
        {
            i1 = p_78760_3_.func_77960_j();
            int j1 = p_78760_3_.field_77994_a;
            boolean flag1 = p_78760_3_.func_77943_a(p_78760_1_, p_78760_2_, p_78760_4_, p_78760_5_, p_78760_6_, p_78760_7_, f, f1, f2);
            p_78760_3_.func_77964_b(i1);
            p_78760_3_.field_77994_a = j1;
            return flag1;
        }
        else
        {
            return p_78760_3_.func_77943_a(p_78760_1_, p_78760_2_, p_78760_4_, p_78760_5_, p_78760_6_, p_78760_7_, f, f1, f2);
        }
    }

    public boolean func_78769_a(EntityPlayer p_78769_1_, World p_78769_2_, ItemStack p_78769_3_)
    {
        this.func_78750_j();
        this.field_78774_b.func_72552_c(new Packet15Place(-1, -1, -1, 255, p_78769_1_.field_71071_by.func_70448_g(), 0.0F, 0.0F, 0.0F));
        int i = p_78769_3_.field_77994_a;
        ItemStack itemstack1 = p_78769_3_.func_77957_a(p_78769_2_, p_78769_1_);

        if (itemstack1 == p_78769_3_ && (itemstack1 == null || itemstack1.field_77994_a == i))
        {
            return false;
        }
        else
        {
            p_78769_1_.field_71071_by.field_70462_a[p_78769_1_.field_71071_by.field_70461_c] = itemstack1;

            if (itemstack1.field_77994_a == 0)
            {
                p_78769_1_.field_71071_by.field_70462_a[p_78769_1_.field_71071_by.field_70461_c] = null;
            }

            return true;
        }
    }

    public EntityClientPlayerMP func_78754_a(World p_78754_1_)
    {
        return new EntityClientPlayerMP(this.field_78776_a, p_78754_1_, this.field_78776_a.func_110432_I(), this.field_78774_b);
    }

    public void func_78764_a(EntityPlayer p_78764_1_, Entity p_78764_2_)
    {
        this.func_78750_j();
        this.field_78774_b.func_72552_c(new Packet7UseEntity(p_78764_1_.field_70157_k, p_78764_2_.field_70157_k, 1));
        p_78764_1_.func_71059_n(p_78764_2_);
    }

    public boolean func_78768_b(EntityPlayer p_78768_1_, Entity p_78768_2_)
    {
        this.func_78750_j();
        this.field_78774_b.func_72552_c(new Packet7UseEntity(p_78768_1_.field_70157_k, p_78768_2_.field_70157_k, 0));
        return p_78768_1_.func_70998_m(p_78768_2_);
    }

    public ItemStack func_78753_a(int p_78753_1_, int p_78753_2_, int p_78753_3_, int p_78753_4_, EntityPlayer p_78753_5_)
    {
        short short1 = p_78753_5_.field_71070_bA.func_75136_a(p_78753_5_.field_71071_by);
        ItemStack itemstack = p_78753_5_.field_71070_bA.func_75144_a(p_78753_2_, p_78753_3_, p_78753_4_, p_78753_5_);
        this.field_78774_b.func_72552_c(new Packet102WindowClick(p_78753_1_, p_78753_2_, p_78753_3_, p_78753_4_, itemstack, short1));
        return itemstack;
    }

    public void func_78756_a(int p_78756_1_, int p_78756_2_)
    {
        this.field_78774_b.func_72552_c(new Packet108EnchantItem(p_78756_1_, p_78756_2_));
    }

    public void func_78761_a(ItemStack p_78761_1_, int p_78761_2_)
    {
        if (this.field_78779_k.func_77145_d())
        {
            this.field_78774_b.func_72552_c(new Packet107CreativeSetSlot(p_78761_2_, p_78761_1_));
        }
    }

    public void func_78752_a(ItemStack p_78752_1_)
    {
        if (this.field_78779_k.func_77145_d() && p_78752_1_ != null)
        {
            this.field_78774_b.func_72552_c(new Packet107CreativeSetSlot(-1, p_78752_1_));
        }
    }

    public void func_78766_c(EntityPlayer p_78766_1_)
    {
        this.func_78750_j();
        this.field_78774_b.func_72552_c(new Packet14BlockDig(5, 0, 0, 0, 255));
        p_78766_1_.func_71034_by();
    }

    public boolean func_78763_f()
    {
        return this.field_78779_k.func_77144_e();
    }

    public boolean func_78762_g()
    {
        return !this.field_78779_k.func_77145_d();
    }

    public boolean func_78758_h()
    {
        return this.field_78779_k.func_77145_d();
    }

    public boolean func_78749_i()
    {
        return this.field_78779_k.func_77145_d();
    }

    public boolean func_110738_j()
    {
        return this.field_78776_a.field_71439_g.func_70115_ae() && this.field_78776_a.field_71439_g.field_70154_o instanceof EntityHorse;
    }
}
