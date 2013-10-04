package net.minecraft.command;

import java.util.List;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;

public class CommandClearInventory extends CommandBase
{
    public String func_71517_b()
    {
        return "clear";
    }

    public String func_71518_a(ICommandSender p_71518_1_)
    {
        return "commands.clear.usage";
    }

    public int func_82362_a()
    {
        return 2;
    }

    public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_)
    {
        EntityPlayerMP entityplayermp = p_71515_2_.length == 0 ? func_71521_c(p_71515_1_) : func_82359_c(p_71515_1_, p_71515_2_[0]);
        int i = p_71515_2_.length >= 2 ? func_71528_a(p_71515_1_, p_71515_2_[1], 1) : -1;
        int j = p_71515_2_.length >= 3 ? func_71528_a(p_71515_1_, p_71515_2_[2], 0) : -1;
        int k = entityplayermp.field_71071_by.func_82347_b(i, j);
        entityplayermp.field_71069_bz.func_75142_b();

        if (!entityplayermp.field_71075_bZ.field_75098_d)
        {
            entityplayermp.func_71113_k();
        }

        if (k == 0)
        {
            throw new CommandException("commands.clear.failure", new Object[] {entityplayermp.func_70023_ak()});
        }
        else
        {
            func_71522_a(p_71515_1_, "commands.clear.success", new Object[] {entityplayermp.func_70023_ak(), Integer.valueOf(k)});
        }
    }

    public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_)
    {
        return p_71516_2_.length == 1 ? func_71530_a(p_71516_2_, this.func_82369_d()) : null;
    }

    protected String[] func_82369_d()
    {
        return MinecraftServer.func_71276_C().func_71213_z();
    }

    public boolean func_82358_a(String[] p_82358_1_, int p_82358_2_)
    {
        return p_82358_2_ == 0;
    }
}
