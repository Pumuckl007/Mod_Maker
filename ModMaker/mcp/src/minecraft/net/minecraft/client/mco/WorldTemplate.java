package net.minecraft.client.mco;

import argo.jdom.JsonNode;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.ValueObject;

@SideOnly(Side.CLIENT)
public class WorldTemplate extends ValueObject
{
    public String field_110734_a;
    public String field_110732_b;
    public String field_110733_c;
    public String field_110731_d;

    public static WorldTemplate func_110730_a(JsonNode p_110730_0_)
    {
        WorldTemplate worldtemplate = new WorldTemplate();

        try
        {
            worldtemplate.field_110734_a = p_110730_0_.getNumberValue(new Object[] {"id"});
            worldtemplate.field_110732_b = p_110730_0_.getStringValue(new Object[] {"name"});
            worldtemplate.field_110733_c = p_110730_0_.getStringValue(new Object[] {"version"});
            worldtemplate.field_110731_d = p_110730_0_.getStringValue(new Object[] {"author"});
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            ;
        }

        return worldtemplate;
    }
}
