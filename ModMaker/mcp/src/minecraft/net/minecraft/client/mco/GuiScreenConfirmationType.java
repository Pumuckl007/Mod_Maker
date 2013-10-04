package net.minecraft.client.mco;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public enum GuiScreenConfirmationType
{
    Warning("Warning!", 16711680),
    Info("Info!", 8226750);
    public final int field_140075_c;
    public final String field_140072_d;

    private GuiScreenConfirmationType(String p_i2324_3_, int p_i2324_4_)
    {
        this.field_140072_d = p_i2324_3_;
        this.field_140075_c = p_i2324_4_;
    }
}
