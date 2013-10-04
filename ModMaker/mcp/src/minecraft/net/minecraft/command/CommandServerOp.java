package net.minecraft.command;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.server.MinecraftServer;

public class CommandServerOp extends CommandBase
{
    public String func_71517_b()
    {
        return "op";
    }

    public int func_82362_a()
    {
        return 3;
    }

    public String func_71518_a(ICommandSender p_71518_1_)
    {
        return "commands.op.usage";
    }

    public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_)
    {
        if (p_71515_2_.length == 1 && p_71515_2_[0].length() > 0)
        {
            MinecraftServer.func_71276_C().func_71203_ab().func_72386_b(p_71515_2_[0]);
            func_71522_a(p_71515_1_, "commands.op.success", new Object[] {p_71515_2_[0]});
        }
        else
        {
            throw new WrongUsageException("commands.op.usage", new Object[0]);
        }
    }

    public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_)
    {
        if (p_71516_2_.length == 1)
        {
            String s = p_71516_2_[p_71516_2_.length - 1];
            ArrayList arraylist = new ArrayList();
            String[] astring1 = MinecraftServer.func_71276_C().func_71213_z();
            int i = astring1.length;

            for (int j = 0; j < i; ++j)
            {
                String s1 = astring1[j];

                if (!MinecraftServer.func_71276_C().func_71203_ab().func_72353_e(s1) && func_71523_a(s, s1))
                {
                    arraylist.add(s1);
                }
            }

            return arraylist;
        }
        else
        {
            return null;
        }
    }
}
