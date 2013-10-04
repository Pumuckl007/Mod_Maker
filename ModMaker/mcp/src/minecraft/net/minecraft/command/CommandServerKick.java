package net.minecraft.command;

import java.util.List;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;

public class CommandServerKick extends CommandBase
{
    public String func_71517_b()
    {
        return "kick";
    }

    public int func_82362_a()
    {
        return 3;
    }

    public String func_71518_a(ICommandSender p_71518_1_)
    {
        return "commands.kick.usage";
    }

    public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_)
    {
        if (p_71515_2_.length > 0 && p_71515_2_[0].length() > 1)
        {
            EntityPlayerMP entityplayermp = MinecraftServer.func_71276_C().func_71203_ab().func_72361_f(p_71515_2_[0]);
            String s = "Kicked by an operator.";
            boolean flag = false;

            if (entityplayermp == null)
            {
                throw new PlayerNotFoundException();
            }
            else
            {
                if (p_71515_2_.length >= 2)
                {
                    s = func_82360_a(p_71515_1_, p_71515_2_, 1);
                    flag = true;
                }

                entityplayermp.field_71135_a.func_72565_c(s);

                if (flag)
                {
                    func_71522_a(p_71515_1_, "commands.kick.success.reason", new Object[] {entityplayermp.func_70023_ak(), s});
                }
                else
                {
                    func_71522_a(p_71515_1_, "commands.kick.success", new Object[] {entityplayermp.func_70023_ak()});
                }
            }
        }
        else
        {
            throw new WrongUsageException("commands.kick.usage", new Object[0]);
        }
    }

    public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_)
    {
        return p_71516_2_.length >= 1 ? func_71530_a(p_71516_2_, MinecraftServer.func_71276_C().func_71213_z()) : null;
    }
}
