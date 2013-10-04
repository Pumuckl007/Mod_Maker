package net.minecraft.command;

import java.util.List;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.world.GameRules;

public class CommandGameRule extends CommandBase
{
    public String func_71517_b()
    {
        return "gamerule";
    }

    public int func_82362_a()
    {
        return 2;
    }

    public String func_71518_a(ICommandSender p_71518_1_)
    {
        return "commands.gamerule.usage";
    }

    public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_)
    {
        String s;

        if (p_71515_2_.length == 2)
        {
            s = p_71515_2_[0];
            String s1 = p_71515_2_[1];
            GameRules gamerules = this.func_82366_d();

            if (gamerules.func_82765_e(s))
            {
                gamerules.func_82764_b(s, s1);
                func_71522_a(p_71515_1_, "commands.gamerule.success", new Object[0]);
            }
            else
            {
                func_71522_a(p_71515_1_, "commands.gamerule.norule", new Object[] {s});
            }
        }
        else if (p_71515_2_.length == 1)
        {
            s = p_71515_2_[0];
            GameRules gamerules1 = this.func_82366_d();

            if (gamerules1.func_82765_e(s))
            {
                String s2 = gamerules1.func_82767_a(s);
                p_71515_1_.func_70006_a(ChatMessageComponent.func_111066_d(s).func_111079_a(" = ").func_111079_a(s2));
            }
            else
            {
                func_71522_a(p_71515_1_, "commands.gamerule.norule", new Object[] {s});
            }
        }
        else if (p_71515_2_.length == 0)
        {
            GameRules gamerules2 = this.func_82366_d();
            p_71515_1_.func_70006_a(ChatMessageComponent.func_111066_d(func_71527_a(gamerules2.func_82763_b())));
        }
        else
        {
            throw new WrongUsageException("commands.gamerule.usage", new Object[0]);
        }
    }

    public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_)
    {
        return p_71516_2_.length == 1 ? func_71530_a(p_71516_2_, this.func_82366_d().func_82763_b()) : (p_71516_2_.length == 2 ? func_71530_a(p_71516_2_, new String[] {"true", "false"}): null);
    }

    private GameRules func_82366_d()
    {
        return MinecraftServer.func_71276_C().func_71218_a(0).func_82736_K();
    }
}
