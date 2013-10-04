package net.minecraft.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public enum EnumRarity
{
    common(15, "Common"),
    uncommon(14, "Uncommon"),
    rare(11, "Rare"),
    epic(13, "Epic");
    public final int field_77937_e;
    public final String field_77934_f;

    private EnumRarity(int p_i1893_3_, String p_i1893_4_)
    {
        this.field_77937_e = p_i1893_3_;
        this.field_77934_f = p_i1893_4_;
    }
}
