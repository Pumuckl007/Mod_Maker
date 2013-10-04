package net.minecraft.command;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.EnumGameType;

public class CommandServerPublishLocal extends CommandBase
{
    public String func_71517_b()
    {
        return "publish";
    }

    public int func_82362_a()
    {
        return 4;
    }

    public String func_71518_a(ICommandSender p_71518_1_)
    {
        return "commands.publish.usage";
    }

    public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_)
    {
        String s = MinecraftServer.func_71276_C().func_71206_a(EnumGameType.SURVIVAL, false);

        if (s != null)
        {
            func_71522_a(p_71515_1_, "commands.publish.started", new Object[] {s});
        }
        else
        {
            func_71522_a(p_71515_1_, "commands.publish.failed", new Object[0]);
        }
    }
}
