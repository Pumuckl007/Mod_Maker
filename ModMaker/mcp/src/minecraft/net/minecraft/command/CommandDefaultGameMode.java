package net.minecraft.command;

import java.util.Iterator;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.world.EnumGameType;

public class CommandDefaultGameMode extends CommandGameMode
{
    public String func_71517_b()
    {
        return "defaultgamemode";
    }

    public String func_71518_a(ICommandSender p_71518_1_)
    {
        return "commands.defaultgamemode.usage";
    }

    public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_)
    {
        if (p_71515_2_.length > 0)
        {
            EnumGameType enumgametype = this.func_71539_b(p_71515_1_, p_71515_2_[0]);
            this.func_71541_a(enumgametype);
            func_71522_a(p_71515_1_, "commands.defaultgamemode.success", new Object[] {ChatMessageComponent.func_111077_e("gameMode." + enumgametype.func_77149_b())});
        }
        else
        {
            throw new WrongUsageException("commands.defaultgamemode.usage", new Object[0]);
        }
    }

    protected void func_71541_a(EnumGameType p_71541_1_)
    {
        MinecraftServer minecraftserver = MinecraftServer.func_71276_C();
        minecraftserver.func_71235_a(p_71541_1_);
        EntityPlayerMP entityplayermp;

        if (minecraftserver.func_104056_am())
        {
            for (Iterator iterator = MinecraftServer.func_71276_C().func_71203_ab().field_72404_b.iterator(); iterator.hasNext(); entityplayermp.field_70143_R = 0.0F)
            {
                entityplayermp = (EntityPlayerMP)iterator.next();
                entityplayermp.func_71033_a(p_71541_1_);
            }
        }
    }
}
