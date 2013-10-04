package net.minecraft.command;

import java.util.List;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChunkCoordinates;

public class CommandSetSpawnpoint extends CommandBase
{
    public String func_71517_b()
    {
        return "spawnpoint";
    }

    public int func_82362_a()
    {
        return 2;
    }

    public String func_71518_a(ICommandSender p_71518_1_)
    {
        return "commands.spawnpoint.usage";
    }

    public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_)
    {
        EntityPlayerMP entityplayermp = p_71515_2_.length == 0 ? func_71521_c(p_71515_1_) : func_82359_c(p_71515_1_, p_71515_2_[0]);

        if (p_71515_2_.length == 4)
        {
            if (entityplayermp.field_70170_p != null)
            {
                byte b0 = 1;
                int i = 30000000;
                int j = b0 + 1;
                int k = func_71532_a(p_71515_1_, p_71515_2_[b0], -i, i);
                int l = func_71532_a(p_71515_1_, p_71515_2_[j++], 0, 256);
                int i1 = func_71532_a(p_71515_1_, p_71515_2_[j++], -i, i);
                entityplayermp.func_71063_a(new ChunkCoordinates(k, l, i1), true);
                func_71522_a(p_71515_1_, "commands.spawnpoint.success", new Object[] {entityplayermp.func_70023_ak(), Integer.valueOf(k), Integer.valueOf(l), Integer.valueOf(i1)});
            }
        }
        else
        {
            if (p_71515_2_.length > 1)
            {
                throw new WrongUsageException("commands.spawnpoint.usage", new Object[0]);
            }

            ChunkCoordinates chunkcoordinates = entityplayermp.func_82114_b();
            entityplayermp.func_71063_a(chunkcoordinates, true);
            func_71522_a(p_71515_1_, "commands.spawnpoint.success", new Object[] {entityplayermp.func_70023_ak(), Integer.valueOf(chunkcoordinates.field_71574_a), Integer.valueOf(chunkcoordinates.field_71572_b), Integer.valueOf(chunkcoordinates.field_71573_c)});
        }
    }

    public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_)
    {
        return p_71516_2_.length != 1 && p_71516_2_.length != 2 ? null : func_71530_a(p_71516_2_, MinecraftServer.func_71276_C().func_71213_z());
    }

    public boolean func_82358_a(String[] p_82358_1_, int p_82358_2_)
    {
        return p_82358_2_ == 0;
    }
}
