package net.minecraft.command;

import java.util.Iterator;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.scoreboard.ServerCommandScoreboard;
import net.minecraft.scoreboard.ServerCommandTestFor;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntityCommandBlock;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EnumChatFormatting;

public class ServerCommandManager extends CommandHandler implements IAdminCommand
{
    public ServerCommandManager()
    {
        this.func_71560_a(new CommandTime());
        this.func_71560_a(new CommandGameMode());
        this.func_71560_a(new CommandDifficulty());
        this.func_71560_a(new CommandDefaultGameMode());
        this.func_71560_a(new CommandKill());
        this.func_71560_a(new CommandToggleDownfall());
        this.func_71560_a(new CommandWeather());
        this.func_71560_a(new CommandXP());
        this.func_71560_a(new CommandServerTp());
        this.func_71560_a(new CommandGive());
        this.func_71560_a(new CommandEffect());
        this.func_71560_a(new CommandEnchant());
        this.func_71560_a(new CommandServerEmote());
        this.func_71560_a(new CommandShowSeed());
        this.func_71560_a(new CommandHelp());
        this.func_71560_a(new CommandDebug());
        this.func_71560_a(new CommandServerMessage());
        this.func_71560_a(new CommandServerSay());
        this.func_71560_a(new CommandSetSpawnpoint());
        this.func_71560_a(new CommandGameRule());
        this.func_71560_a(new CommandClearInventory());
        this.func_71560_a(new ServerCommandTestFor());
        this.func_71560_a(new CommandSpreadPlayers());
        this.func_71560_a(new CommandPlaySound());
        this.func_71560_a(new ServerCommandScoreboard());

        if (MinecraftServer.func_71276_C().func_71262_S())
        {
            this.func_71560_a(new CommandServerOp());
            this.func_71560_a(new CommandServerDeop());
            this.func_71560_a(new CommandServerStop());
            this.func_71560_a(new CommandServerSaveAll());
            this.func_71560_a(new CommandServerSaveOff());
            this.func_71560_a(new CommandServerSaveOn());
            this.func_71560_a(new CommandServerBanIp());
            this.func_71560_a(new CommandServerPardonIp());
            this.func_71560_a(new CommandServerBan());
            this.func_71560_a(new CommandServerBanlist());
            this.func_71560_a(new CommandServerPardon());
            this.func_71560_a(new CommandServerKick());
            this.func_71560_a(new CommandServerList());
            this.func_71560_a(new CommandServerWhitelist());
            this.func_71560_a(new CommandSetPlayerTimeout());
        }
        else
        {
            this.func_71560_a(new CommandServerPublishLocal());
        }

        CommandBase.func_71529_a(this);
    }

    public void func_71563_a(ICommandSender p_71563_1_, int p_71563_2_, String p_71563_3_, Object ... p_71563_4_)
    {
        boolean flag = true;

        if (p_71563_1_ instanceof TileEntityCommandBlock && !MinecraftServer.func_71276_C().field_71305_c[0].func_82736_K().func_82766_b("commandBlockOutput"))
        {
            flag = false;
        }

        ChatMessageComponent chatmessagecomponent = ChatMessageComponent.func_111082_b("chat.type.admin", new Object[] {p_71563_1_.func_70005_c_(), ChatMessageComponent.func_111082_b(p_71563_3_, p_71563_4_)});
        chatmessagecomponent.func_111059_a(EnumChatFormatting.GRAY);
        chatmessagecomponent.func_111063_b(Boolean.valueOf(true));

        if (flag)
        {
            Iterator iterator = MinecraftServer.func_71276_C().func_71203_ab().field_72404_b.iterator();

            while (iterator.hasNext())
            {
                EntityPlayerMP entityplayermp = (EntityPlayerMP)iterator.next();

                if (entityplayermp != p_71563_1_ && MinecraftServer.func_71276_C().func_71203_ab().func_72353_e(entityplayermp.func_70005_c_()))
                {
                    entityplayermp.func_70006_a(chatmessagecomponent);
                }
            }
        }

        if (p_71563_1_ != MinecraftServer.func_71276_C())
        {
            MinecraftServer.func_71276_C().func_70006_a(chatmessagecomponent);
        }

        if ((p_71563_2_ & 1) != 1)
        {
            p_71563_1_.func_70006_a(ChatMessageComponent.func_111082_b(p_71563_3_, p_71563_4_));
        }
    }
}
