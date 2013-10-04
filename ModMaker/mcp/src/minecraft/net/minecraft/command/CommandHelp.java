package net.minecraft.command;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EnumChatFormatting;

public class CommandHelp extends CommandBase
{
    public String func_71517_b()
    {
        return "help";
    }

    public int func_82362_a()
    {
        return 0;
    }

    public String func_71518_a(ICommandSender p_71518_1_)
    {
        return "commands.help.usage";
    }

    public List func_71514_a()
    {
        return Arrays.asList(new String[] {"?"});
    }

    public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_)
    {
        List list = this.func_71534_d(p_71515_1_);
        byte b0 = 7;
        int i = (list.size() - 1) / b0;
        boolean flag = false;
        ICommand icommand;
        int j;

        try
        {
            j = p_71515_2_.length == 0 ? 0 : func_71532_a(p_71515_1_, p_71515_2_[0], 1, i + 1) - 1;
        }
        catch (NumberInvalidException numberinvalidexception)
        {
            Map map = this.func_71535_c();
            icommand = (ICommand)map.get(p_71515_2_[0]);

            if (icommand != null)
            {
                throw new WrongUsageException(icommand.func_71518_a(p_71515_1_), new Object[0]);
            }

            throw new CommandNotFoundException();
        }

        int k = Math.min((j + 1) * b0, list.size());
        p_71515_1_.func_70006_a(ChatMessageComponent.func_111082_b("commands.help.header", new Object[] {Integer.valueOf(j + 1), Integer.valueOf(i + 1)}).func_111059_a(EnumChatFormatting.DARK_GREEN));

        for (int l = j * b0; l < k; ++l)
        {
            icommand = (ICommand)list.get(l);
            p_71515_1_.func_70006_a(ChatMessageComponent.func_111077_e(icommand.func_71518_a(p_71515_1_)));
        }

        if (j == 0 && p_71515_1_ instanceof EntityPlayer)
        {
            p_71515_1_.func_70006_a(ChatMessageComponent.func_111077_e("commands.help.footer").func_111059_a(EnumChatFormatting.GREEN));
        }
    }

    protected List func_71534_d(ICommandSender p_71534_1_)
    {
        List list = MinecraftServer.func_71276_C().func_71187_D().func_71557_a(p_71534_1_);
        Collections.sort(list);
        return list;
    }

    protected Map func_71535_c()
    {
        return MinecraftServer.func_71276_C().func_71187_D().func_71555_a();
    }
}
