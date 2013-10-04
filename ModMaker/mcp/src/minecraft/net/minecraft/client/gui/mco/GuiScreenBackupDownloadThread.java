package net.minecraft.client.gui.mco;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.mco.ExceptionMcoService;
import net.minecraft.client.mco.McoClient;

@SideOnly(Side.CLIENT)
class GuiScreenBackupDownloadThread extends Thread
{
    final GuiScreenBackup field_111250_a;

    GuiScreenBackupDownloadThread(GuiScreenBackup p_i1099_1_)
    {
        this.field_111250_a = p_i1099_1_;
    }

    public void run()
    {
        McoClient mcoclient = new McoClient(GuiScreenBackup.func_110366_a(this.field_111250_a).func_110432_I());

        try
        {
            GuiScreenBackup.func_110373_a(this.field_111250_a, mcoclient.func_111232_c(GuiScreenBackup.func_110367_b(this.field_111250_a)).field_111223_a);
        }
        catch (ExceptionMcoService exceptionmcoservice)
        {
            GuiScreenBackup.func_130030_c(this.field_111250_a).func_98033_al().func_98232_c(exceptionmcoservice.toString());
        }
    }
}
