package net.minecraft.command;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.BanEntry;

public class CommandServerBanIp extends CommandBase
{
    public static final Pattern field_71545_a = Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

    public String func_71517_b()
    {
        return "ban-ip";
    }

    public int func_82362_a()
    {
        return 3;
    }

    public boolean func_71519_b(ICommandSender p_71519_1_)
    {
        return MinecraftServer.func_71276_C().func_71203_ab().func_72363_f().func_73710_b() && super.func_71519_b(p_71519_1_);
    }

    public String func_71518_a(ICommandSender p_71518_1_)
    {
        return "commands.banip.usage";
    }

    public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_)
    {
        if (p_71515_2_.length >= 1 && p_71515_2_[0].length() > 1)
        {
            Matcher matcher = field_71545_a.matcher(p_71515_2_[0]);
            String s = null;

            if (p_71515_2_.length >= 2)
            {
                s = func_82360_a(p_71515_1_, p_71515_2_, 1);
            }

            if (matcher.matches())
            {
                this.func_71544_a(p_71515_1_, p_71515_2_[0], s);
            }
            else
            {
                EntityPlayerMP entityplayermp = MinecraftServer.func_71276_C().func_71203_ab().func_72361_f(p_71515_2_[0]);

                if (entityplayermp == null)
                {
                    throw new PlayerNotFoundException("commands.banip.invalid", new Object[0]);
                }

                this.func_71544_a(p_71515_1_, entityplayermp.func_71114_r(), s);
            }
        }
        else
        {
            throw new WrongUsageException("commands.banip.usage", new Object[0]);
        }
    }

    public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_)
    {
        return p_71516_2_.length == 1 ? func_71530_a(p_71516_2_, MinecraftServer.func_71276_C().func_71213_z()) : null;
    }

    protected void func_71544_a(ICommandSender p_71544_1_, String p_71544_2_, String p_71544_3_)
    {
        BanEntry banentry = new BanEntry(p_71544_2_);
        banentry.func_73687_a(p_71544_1_.func_70005_c_());

        if (p_71544_3_ != null)
        {
            banentry.func_73689_b(p_71544_3_);
        }

        MinecraftServer.func_71276_C().func_71203_ab().func_72363_f().func_73706_a(banentry);
        List list = MinecraftServer.func_71276_C().func_71203_ab().func_72382_j(p_71544_2_);
        String[] astring = new String[list.size()];
        int i = 0;
        EntityPlayerMP entityplayermp;

        for (Iterator iterator = list.iterator(); iterator.hasNext(); astring[i++] = entityplayermp.func_70023_ak())
        {
            entityplayermp = (EntityPlayerMP)iterator.next();
            entityplayermp.field_71135_a.func_72565_c("You have been IP banned.");
        }

        if (list.isEmpty())
        {
            func_71522_a(p_71544_1_, "commands.banip.success", new Object[] {p_71544_2_});
        }
        else
        {
            func_71522_a(p_71544_1_, "commands.banip.success.players", new Object[] {p_71544_2_, func_71527_a(astring)});
        }
    }
}
