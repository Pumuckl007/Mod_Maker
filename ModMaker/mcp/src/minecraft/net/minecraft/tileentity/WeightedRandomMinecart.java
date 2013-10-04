package net.minecraft.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.WeightedRandomItem;

public class WeightedRandomMinecart extends WeightedRandomItem
{
    public final NBTTagCompound field_98222_b;
    public final String field_98223_c;

    final MobSpawnerBaseLogic field_98221_d;

    public WeightedRandomMinecart(MobSpawnerBaseLogic p_i1945_1_, NBTTagCompound p_i1945_2_)
    {
        super(p_i1945_2_.func_74762_e("Weight"));
        this.field_98221_d = p_i1945_1_;
        NBTTagCompound nbttagcompound1 = p_i1945_2_.func_74775_l("Properties");
        String s = p_i1945_2_.func_74779_i("Type");

        if (s.equals("Minecart"))
        {
            if (nbttagcompound1 != null)
            {
                switch (nbttagcompound1.func_74762_e("Type"))
                {
                    case 0:
                        s = "MinecartRideable";
                        break;
                    case 1:
                        s = "MinecartChest";
                        break;
                    case 2:
                        s = "MinecartFurnace";
                }
            }
            else
            {
                s = "MinecartRideable";
            }
        }

        this.field_98222_b = nbttagcompound1;
        this.field_98223_c = s;
    }

    public WeightedRandomMinecart(MobSpawnerBaseLogic p_i1946_1_, NBTTagCompound p_i1946_2_, String p_i1946_3_)
    {
        super(1);
        this.field_98221_d = p_i1946_1_;

        if (p_i1946_3_.equals("Minecart"))
        {
            if (p_i1946_2_ != null)
            {
                switch (p_i1946_2_.func_74762_e("Type"))
                {
                    case 0:
                        p_i1946_3_ = "MinecartRideable";
                        break;
                    case 1:
                        p_i1946_3_ = "MinecartChest";
                        break;
                    case 2:
                        p_i1946_3_ = "MinecartFurnace";
                }
            }
            else
            {
                p_i1946_3_ = "MinecartRideable";
            }
        }

        this.field_98222_b = p_i1946_2_;
        this.field_98223_c = p_i1946_3_;
    }

    public NBTTagCompound func_98220_a()
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        nbttagcompound.func_74766_a("Properties", this.field_98222_b);
        nbttagcompound.func_74778_a("Type", this.field_98223_c);
        nbttagcompound.func_74768_a("Weight", this.field_76292_a);
        return nbttagcompound;
    }
}
