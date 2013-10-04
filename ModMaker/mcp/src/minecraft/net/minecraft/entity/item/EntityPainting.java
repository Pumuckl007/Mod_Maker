package net.minecraft.entity.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityHanging;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumArt;
import net.minecraft.world.World;

public class EntityPainting extends EntityHanging
{
    public EnumArt field_70522_e;

    public EntityPainting(World p_i1599_1_)
    {
        super(p_i1599_1_);
    }

    public EntityPainting(World p_i1600_1_, int p_i1600_2_, int p_i1600_3_, int p_i1600_4_, int p_i1600_5_)
    {
        super(p_i1600_1_, p_i1600_2_, p_i1600_3_, p_i1600_4_, p_i1600_5_);
        ArrayList arraylist = new ArrayList();
        EnumArt[] aenumart = EnumArt.values();
        int i1 = aenumart.length;

        for (int j1 = 0; j1 < i1; ++j1)
        {
            EnumArt enumart = aenumart[j1];
            this.field_70522_e = enumart;
            this.func_82328_a(p_i1600_5_);

            if (this.func_70518_d())
            {
                arraylist.add(enumart);
            }
        }

        if (!arraylist.isEmpty())
        {
            this.field_70522_e = (EnumArt)arraylist.get(this.field_70146_Z.nextInt(arraylist.size()));
        }

        this.func_82328_a(p_i1600_5_);
    }

    @SideOnly(Side.CLIENT)
    public EntityPainting(World p_i1601_1_, int p_i1601_2_, int p_i1601_3_, int p_i1601_4_, int p_i1601_5_, String p_i1601_6_)
    {
        this(p_i1601_1_, p_i1601_2_, p_i1601_3_, p_i1601_4_, p_i1601_5_);
        EnumArt[] aenumart = EnumArt.values();
        int i1 = aenumart.length;

        for (int j1 = 0; j1 < i1; ++j1)
        {
            EnumArt enumart = aenumart[j1];

            if (enumart.field_75702_A.equals(p_i1601_6_))
            {
                this.field_70522_e = enumart;
                break;
            }
        }

        this.func_82328_a(p_i1601_5_);
    }

    public void func_70014_b(NBTTagCompound p_70014_1_)
    {
        p_70014_1_.func_74778_a("Motive", this.field_70522_e.field_75702_A);
        super.func_70014_b(p_70014_1_);
    }

    public void func_70037_a(NBTTagCompound p_70037_1_)
    {
        String s = p_70037_1_.func_74779_i("Motive");
        EnumArt[] aenumart = EnumArt.values();
        int i = aenumart.length;

        for (int j = 0; j < i; ++j)
        {
            EnumArt enumart = aenumart[j];

            if (enumart.field_75702_A.equals(s))
            {
                this.field_70522_e = enumart;
            }
        }

        if (this.field_70522_e == null)
        {
            this.field_70522_e = EnumArt.Kebab;
        }

        super.func_70037_a(p_70037_1_);
    }

    public int func_82329_d()
    {
        return this.field_70522_e.field_75703_B;
    }

    public int func_82330_g()
    {
        return this.field_70522_e.field_75704_C;
    }

    public void func_110128_b(Entity p_110128_1_)
    {
        if (p_110128_1_ instanceof EntityPlayer)
        {
            EntityPlayer entityplayer = (EntityPlayer)p_110128_1_;

            if (entityplayer.field_71075_bZ.field_75098_d)
            {
                return;
            }
        }

        this.func_70099_a(new ItemStack(Item.field_77780_as), 0.0F);
    }
}
