package net.minecraft.world;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.PlayerCapabilities;

public enum EnumGameType
{
    NOT_SET(-1, ""),
    SURVIVAL(0, "survival"),
    CREATIVE(1, "creative"),
    ADVENTURE(2, "adventure");
    int field_77154_e;
    String field_77151_f;

    private EnumGameType(int p_i1956_3_, String p_i1956_4_)
    {
        this.field_77154_e = p_i1956_3_;
        this.field_77151_f = p_i1956_4_;
    }

    public int func_77148_a()
    {
        return this.field_77154_e;
    }

    public String func_77149_b()
    {
        return this.field_77151_f;
    }

    public void func_77147_a(PlayerCapabilities p_77147_1_)
    {
        if (this == CREATIVE)
        {
            p_77147_1_.field_75101_c = true;
            p_77147_1_.field_75098_d = true;
            p_77147_1_.field_75102_a = true;
        }
        else
        {
            p_77147_1_.field_75101_c = false;
            p_77147_1_.field_75098_d = false;
            p_77147_1_.field_75102_a = false;
            p_77147_1_.field_75100_b = false;
        }

        p_77147_1_.field_75099_e = !this.func_82752_c();
    }

    public boolean func_82752_c()
    {
        return this == ADVENTURE;
    }

    public boolean func_77145_d()
    {
        return this == CREATIVE;
    }

    @SideOnly(Side.CLIENT)
    public boolean func_77144_e()
    {
        return this == SURVIVAL || this == ADVENTURE;
    }

    public static EnumGameType func_77146_a(int p_77146_0_)
    {
        EnumGameType[] aenumgametype = values();
        int j = aenumgametype.length;

        for (int k = 0; k < j; ++k)
        {
            EnumGameType enumgametype = aenumgametype[k];

            if (enumgametype.field_77154_e == p_77146_0_)
            {
                return enumgametype;
            }
        }

        return SURVIVAL;
    }

    @SideOnly(Side.CLIENT)
    public static EnumGameType func_77142_a(String p_77142_0_)
    {
        EnumGameType[] aenumgametype = values();
        int i = aenumgametype.length;

        for (int j = 0; j < i; ++j)
        {
            EnumGameType enumgametype = aenumgametype[j];

            if (enumgametype.field_77151_f.equals(p_77142_0_))
            {
                return enumgametype;
            }
        }

        return SURVIVAL;
    }
}
