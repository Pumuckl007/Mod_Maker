package net.minecraft.client.mco;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.OutputStream;

@SideOnly(Side.CLIENT)
public class RequestPut extends Request
{
    private byte[] field_96369_c;

    public RequestPut(String p_i1143_1_, byte[] p_i1143_2_, int p_i1143_3_, int p_i1143_4_)
    {
        super(p_i1143_1_, p_i1143_3_, p_i1143_4_);
        this.field_96369_c = p_i1143_2_;
    }

    public RequestPut func_96368_f()
    {
        try
        {
            this.field_96367_a.setDoOutput(true);
            this.field_96367_a.setDoInput(true);
            this.field_96367_a.setRequestMethod("PUT");
            OutputStream outputstream = this.field_96367_a.getOutputStream();
            outputstream.write(this.field_96369_c);
            outputstream.flush();
            return this;
        }
        catch (Exception exception)
        {
            throw new ExceptionMcoHttp("Failed URL: " + this.field_96365_b, exception);
        }
    }

    public Request func_96359_e()
    {
        return this.func_96368_f();
    }
}
