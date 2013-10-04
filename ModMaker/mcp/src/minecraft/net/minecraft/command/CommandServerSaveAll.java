package net.minecraft.command;

import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.MinecraftException;
import net.minecraft.world.WorldServer;

public class CommandServerSaveAll extends CommandBase
{
    public String func_71517_b()
    {
        return "save-all";
    }

    public int func_82362_a()
    {
        return 4;
    }

    public String func_71518_a(ICommandSender p_71518_1_)
    {
        return "commands.save.usage";
    }

    public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_)
    {
        MinecraftServer minecraftserver = MinecraftServer.func_71276_C();
        p_71515_1_.func_70006_a(ChatMessageComponent.func_111077_e("commands.save.start"));

        if (minecraftserver.func_71203_ab() != null)
        {
            minecraftserver.func_71203_ab().func_72389_g();
        }

        try
        {
            int i;
            WorldServer worldserver;
            boolean flag;

            for (i = 0; i < minecraftserver.field_71305_c.length; ++i)
            {
                if (minecraftserver.field_71305_c[i] != null)
                {
                    worldserver = minecraftserver.field_71305_c[i];
                    flag = worldserver.field_73058_d;
                    worldserver.field_73058_d = false;
                    worldserver.func_73044_a(true, (IProgressUpdate)null);
                    worldserver.field_73058_d = flag;
                }
            }

            if (p_71515_2_.length > 0 && "flush".equals(p_71515_2_[0]))
            {
                p_71515_1_.func_70006_a(ChatMessageComponent.func_111077_e("commands.save.flushStart"));

                for (i = 0; i < minecraftserver.field_71305_c.length; ++i)
                {
                    if (minecraftserver.field_71305_c[i] != null)
                    {
                        worldserver = minecraftserver.field_71305_c[i];
                        flag = worldserver.field_73058_d;
                        worldserver.field_73058_d = false;
                        worldserver.func_104140_m();
                        worldserver.field_73058_d = flag;
                    }
                }

                p_71515_1_.func_70006_a(ChatMessageComponent.func_111077_e("commands.save.flushEnd"));
            }
        }
        catch (MinecraftException minecraftexception)
        {
            func_71522_a(p_71515_1_, "commands.save.failed", new Object[] {minecraftexception.getMessage()});
            return;
        }

        func_71522_a(p_71515_1_, "commands.save.success", new Object[0]);
    }
}
