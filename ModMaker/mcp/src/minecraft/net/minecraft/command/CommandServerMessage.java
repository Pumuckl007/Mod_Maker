package net.minecraft.command;

import java.util.Arrays;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EnumChatFormatting;

public class CommandServerMessage extends CommandBase
{
    public List func_71514_a()
    {
        return Arrays.asList(new String[] {"w", "msg"});
    }

    public String func_71517_b()
    {
        return "tell";
    }

    public int func_82362_a()
    {
        return 0;
    }

    public String func_71518_a(ICommandSender p_71518_1_)
    {
        return "commands.message.usage";
    }

    public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_)
    {
        if (p_71515_2_.length < 2)
        {
            throw new WrongUsageException("commands.message.usage", new Object[0]);
        }
        else
        {
            EntityPlayerMP entityplayermp = func_82359_c(p_71515_1_, p_71515_2_[0]);

            if (entityplayermp == null)
            {
                throw new PlayerNotFoundException();
            }
            else if (entityplayermp == p_71515_1_)
            {
                throw new PlayerNotFoundException("commands.message.sameTarget", new Object[0]);
            }
            else
            {
                String s = func_82361_a(p_71515_1_, p_71515_2_, 1, !(p_71515_1_ instanceof EntityPlayer));
                entityplayermp.func_70006_a(ChatMessageComponent.func_111082_b("commands.message.display.incoming", new Object[] {p_71515_1_.func_70005_c_(), s}).func_111059_a(EnumChatFormatting.GRAY).func_111063_b(Boolean.valueOf(true)));
                p_71515_1_.func_70006_a(ChatMessageComponent.func_111082_b("commands.message.display.outgoing", new Object[] {entityplayermp.func_70005_c_(), s}).func_111059_a(EnumChatFormatting.GRAY).func_111063_b(Boolean.valueOf(true)));
            }
        }
    }

    public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_)
    {
        return func_71530_a(p_71516_2_, MinecraftServer.func_71276_C().func_71213_z());
    }

    public boolean func_82358_a(String[] p_82358_1_, int p_82358_2_)
    {
        return p_82358_2_ == 0;
    }
}
