package net.minecraft.command;

import java.util.List;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;

public class CommandGive extends CommandBase
{
    public String func_71517_b()
    {
        return "give";
    }

    public int func_82362_a()
    {
        return 2;
    }

    public String func_71518_a(ICommandSender p_71518_1_)
    {
        return "commands.give.usage";
    }

    public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_)
    {
        if (p_71515_2_.length >= 2)
        {
            EntityPlayerMP entityplayermp = func_82359_c(p_71515_1_, p_71515_2_[0]);
            int i = func_71528_a(p_71515_1_, p_71515_2_[1], 1);
            int j = 1;
            int k = 0;

            if (Item.field_77698_e[i] == null)
            {
                throw new NumberInvalidException("commands.give.notFound", new Object[] {Integer.valueOf(i)});
            }
            else
            {
                if (p_71515_2_.length >= 3)
                {
                    j = func_71532_a(p_71515_1_, p_71515_2_[2], 1, 64);
                }

                if (p_71515_2_.length >= 4)
                {
                    k = func_71526_a(p_71515_1_, p_71515_2_[3]);
                }

                ItemStack itemstack = new ItemStack(i, j, k);
                EntityItem entityitem = entityplayermp.func_71021_b(itemstack);
                entityitem.field_70293_c = 0;
                func_71522_a(p_71515_1_, "commands.give.success", new Object[] {Item.field_77698_e[i].func_77653_i(itemstack), Integer.valueOf(i), Integer.valueOf(j), entityplayermp.func_70023_ak()});
            }
        }
        else
        {
            throw new WrongUsageException("commands.give.usage", new Object[0]);
        }
    }

    public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_)
    {
        return p_71516_2_.length == 1 ? func_71530_a(p_71516_2_, this.func_71536_c()) : null;
    }

    protected String[] func_71536_c()
    {
        return MinecraftServer.func_71276_C().func_71213_z();
    }

    public boolean func_82358_a(String[] p_82358_1_, int p_82358_2_)
    {
        return p_82358_2_ == 0;
    }
}
