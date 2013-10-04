package net.minecraft.command;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.scoreboard.Team;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class CommandSpreadPlayers extends CommandBase
{
    public String func_71517_b()
    {
        return "spreadplayers";
    }

    public int func_82362_a()
    {
        return 2;
    }

    public String func_71518_a(ICommandSender p_71518_1_)
    {
        return "commands.spreadplayers.usage";
    }

    public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_)
    {
        if (p_71515_2_.length < 6)
        {
            throw new WrongUsageException("commands.spreadplayers.usage", new Object[0]);
        }
        else
        {
            byte b0 = 0;
            int i = b0 + 1;
            double d0 = func_110666_a(p_71515_1_, Double.NaN, p_71515_2_[b0]);
            double d1 = func_110666_a(p_71515_1_, Double.NaN, p_71515_2_[i++]);
            double d2 = func_110664_a(p_71515_1_, p_71515_2_[i++], 0.0D);
            double d3 = func_110664_a(p_71515_1_, p_71515_2_[i++], d2 + 1.0D);
            boolean flag = func_110662_c(p_71515_1_, p_71515_2_[i++]);
            ArrayList arraylist = Lists.newArrayList();

            while (true)
            {
                while (i < p_71515_2_.length)
                {
                    String s = p_71515_2_[i++];

                    if (PlayerSelector.func_82378_b(s))
                    {
                        EntityPlayerMP[] aentityplayermp = PlayerSelector.func_82380_c(p_71515_1_, s);

                        if (aentityplayermp == null || aentityplayermp.length == 0)
                        {
                            throw new PlayerNotFoundException();
                        }

                        Collections.addAll(arraylist, aentityplayermp);
                    }
                    else
                    {
                        EntityPlayerMP entityplayermp = MinecraftServer.func_71276_C().func_71203_ab().func_72361_f(s);

                        if (entityplayermp == null)
                        {
                            throw new PlayerNotFoundException();
                        }

                        arraylist.add(entityplayermp);
                    }
                }

                if (arraylist.isEmpty())
                {
                    throw new PlayerNotFoundException();
                }

                p_71515_1_.func_70006_a(ChatMessageComponent.func_111082_b("commands.spreadplayers.spreading." + (flag ? "teams" : "players"), new Object[] {func_110663_b(arraylist), Double.valueOf(d0), Double.valueOf(d1), Double.valueOf(d2), Double.valueOf(d3)}));
                this.func_110669_a(p_71515_1_, arraylist, new CommandSpreadPlayersPosition(d0, d1), d2, d3, ((EntityLivingBase)arraylist.get(0)).field_70170_p, flag);
                return;
            }
        }
    }

    private void func_110669_a(ICommandSender p_110669_1_, List p_110669_2_, CommandSpreadPlayersPosition p_110669_3_, double p_110669_4_, double p_110669_6_, World p_110669_8_, boolean p_110669_9_)
    {
        Random random = new Random();
        double d2 = p_110669_3_.field_111101_a - p_110669_6_;
        double d3 = p_110669_3_.field_111100_b - p_110669_6_;
        double d4 = p_110669_3_.field_111101_a + p_110669_6_;
        double d5 = p_110669_3_.field_111100_b + p_110669_6_;
        CommandSpreadPlayersPosition[] acommandspreadplayersposition = this.func_110670_a(random, p_110669_9_ ? this.func_110667_a(p_110669_2_) : p_110669_2_.size(), d2, d3, d4, d5);
        int i = this.func_110668_a(p_110669_3_, p_110669_4_, p_110669_8_, random, d2, d3, d4, d5, acommandspreadplayersposition, p_110669_9_);
        double d6 = this.func_110671_a(p_110669_2_, p_110669_8_, acommandspreadplayersposition, p_110669_9_);
        func_71522_a(p_110669_1_, "commands.spreadplayers.success." + (p_110669_9_ ? "teams" : "players"), new Object[] {Integer.valueOf(acommandspreadplayersposition.length), Double.valueOf(p_110669_3_.field_111101_a), Double.valueOf(p_110669_3_.field_111100_b)});

        if (acommandspreadplayersposition.length > 1)
        {
            p_110669_1_.func_70006_a(ChatMessageComponent.func_111082_b("commands.spreadplayers.info." + (p_110669_9_ ? "teams" : "players"), new Object[] {String.format("%.2f", new Object[]{Double.valueOf(d6)}), Integer.valueOf(i)}));
        }
    }

    private int func_110667_a(List p_110667_1_)
    {
        HashSet hashset = Sets.newHashSet();
        Iterator iterator = p_110667_1_.iterator();

        while (iterator.hasNext())
        {
            EntityLivingBase entitylivingbase = (EntityLivingBase)iterator.next();

            if (entitylivingbase instanceof EntityPlayer)
            {
                hashset.add(((EntityPlayer)entitylivingbase).func_96124_cp());
            }
            else
            {
                hashset.add((Object)null);
            }
        }

        return hashset.size();
    }

    private int func_110668_a(CommandSpreadPlayersPosition p_110668_1_, double p_110668_2_, World p_110668_4_, Random p_110668_5_, double p_110668_6_, double p_110668_8_, double p_110668_10_, double p_110668_12_, CommandSpreadPlayersPosition[] p_110668_14_, boolean p_110668_15_)
    {
        boolean flag1 = true;
        double d5 = 3.4028234663852886E38D;
        int i;

        for (i = 0; i < 10000 && flag1; ++i)
        {
            flag1 = false;
            d5 = 3.4028234663852886E38D;
            CommandSpreadPlayersPosition commandspreadplayersposition1;
            int j;

            for (int k = 0; k < p_110668_14_.length; ++k)
            {
                CommandSpreadPlayersPosition commandspreadplayersposition2 = p_110668_14_[k];
                j = 0;
                commandspreadplayersposition1 = new CommandSpreadPlayersPosition();

                for (int l = 0; l < p_110668_14_.length; ++l)
                {
                    if (k != l)
                    {
                        CommandSpreadPlayersPosition commandspreadplayersposition3 = p_110668_14_[l];
                        double d6 = commandspreadplayersposition2.func_111099_a(commandspreadplayersposition3);
                        d5 = Math.min(d6, d5);

                        if (d6 < p_110668_2_)
                        {
                            ++j;
                            commandspreadplayersposition1.field_111101_a += commandspreadplayersposition3.field_111101_a - commandspreadplayersposition2.field_111101_a;
                            commandspreadplayersposition1.field_111100_b += commandspreadplayersposition3.field_111100_b - commandspreadplayersposition2.field_111100_b;
                        }
                    }
                }

                if (j > 0)
                {
                    commandspreadplayersposition1.field_111101_a /= (double)j;
                    commandspreadplayersposition1.field_111100_b /= (double)j;
                    double d7 = (double)commandspreadplayersposition1.func_111096_b();

                    if (d7 > 0.0D)
                    {
                        commandspreadplayersposition1.func_111095_a();
                        commandspreadplayersposition2.func_111094_b(commandspreadplayersposition1);
                    }
                    else
                    {
                        commandspreadplayersposition2.func_111097_a(p_110668_5_, p_110668_6_, p_110668_8_, p_110668_10_, p_110668_12_);
                    }

                    flag1 = true;
                }

                if (commandspreadplayersposition2.func_111093_a(p_110668_6_, p_110668_8_, p_110668_10_, p_110668_12_))
                {
                    flag1 = true;
                }
            }

            if (!flag1)
            {
                CommandSpreadPlayersPosition[] acommandspreadplayersposition1 = p_110668_14_;
                int i1 = p_110668_14_.length;

                for (j = 0; j < i1; ++j)
                {
                    commandspreadplayersposition1 = acommandspreadplayersposition1[j];

                    if (!commandspreadplayersposition1.func_111098_b(p_110668_4_))
                    {
                        commandspreadplayersposition1.func_111097_a(p_110668_5_, p_110668_6_, p_110668_8_, p_110668_10_, p_110668_12_);
                        flag1 = true;
                    }
                }
            }
        }

        if (i >= 10000)
        {
            throw new CommandException("commands.spreadplayers.failure." + (p_110668_15_ ? "teams" : "players"), new Object[] {Integer.valueOf(p_110668_14_.length), Double.valueOf(p_110668_1_.field_111101_a), Double.valueOf(p_110668_1_.field_111100_b), String.format("%.2f", new Object[]{Double.valueOf(d5)})});
        }
        else
        {
            return i;
        }
    }

    private double func_110671_a(List p_110671_1_, World p_110671_2_, CommandSpreadPlayersPosition[] p_110671_3_, boolean p_110671_4_)
    {
        double d0 = 0.0D;
        int i = 0;
        HashMap hashmap = Maps.newHashMap();

        for (int j = 0; j < p_110671_1_.size(); ++j)
        {
            EntityLivingBase entitylivingbase = (EntityLivingBase)p_110671_1_.get(j);
            CommandSpreadPlayersPosition commandspreadplayersposition;

            if (p_110671_4_)
            {
                Team team = entitylivingbase instanceof EntityPlayer ? ((EntityPlayer)entitylivingbase).func_96124_cp() : null;

                if (!hashmap.containsKey(team))
                {
                    hashmap.put(team, p_110671_3_[i++]);
                }

                commandspreadplayersposition = (CommandSpreadPlayersPosition)hashmap.get(team);
            }
            else
            {
                commandspreadplayersposition = p_110671_3_[i++];
            }

            entitylivingbase.func_70634_a((double)((float)MathHelper.func_76128_c(commandspreadplayersposition.field_111101_a) + 0.5F), (double)commandspreadplayersposition.func_111092_a(p_110671_2_), (double)MathHelper.func_76128_c(commandspreadplayersposition.field_111100_b) + 0.5D);
            double d1 = Double.MAX_VALUE;

            for (int k = 0; k < p_110671_3_.length; ++k)
            {
                if (commandspreadplayersposition != p_110671_3_[k])
                {
                    double d2 = commandspreadplayersposition.func_111099_a(p_110671_3_[k]);
                    d1 = Math.min(d2, d1);
                }
            }

            d0 += d1;
        }

        d0 /= (double)p_110671_1_.size();
        return d0;
    }

    private CommandSpreadPlayersPosition[] func_110670_a(Random p_110670_1_, int p_110670_2_, double p_110670_3_, double p_110670_5_, double p_110670_7_, double p_110670_9_)
    {
        CommandSpreadPlayersPosition[] acommandspreadplayersposition = new CommandSpreadPlayersPosition[p_110670_2_];

        for (int j = 0; j < acommandspreadplayersposition.length; ++j)
        {
            CommandSpreadPlayersPosition commandspreadplayersposition = new CommandSpreadPlayersPosition();
            commandspreadplayersposition.func_111097_a(p_110670_1_, p_110670_3_, p_110670_5_, p_110670_7_, p_110670_9_);
            acommandspreadplayersposition[j] = commandspreadplayersposition;
        }

        return acommandspreadplayersposition;
    }
}
