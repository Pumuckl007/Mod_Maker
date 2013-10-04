package net.minecraft.scoreboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.SyntaxErrorException;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EnumChatFormatting;

public class ServerCommandScoreboard extends CommandBase
{
    public String func_71517_b()
    {
        return "scoreboard";
    }

    public int func_82362_a()
    {
        return 2;
    }

    public String func_71518_a(ICommandSender p_71518_1_)
    {
        return "commands.scoreboard.usage";
    }

    public void func_71515_b(ICommandSender p_71515_1_, String[] p_71515_2_)
    {
        if (p_71515_2_.length >= 1)
        {
            if (p_71515_2_[0].equalsIgnoreCase("objectives"))
            {
                if (p_71515_2_.length == 1)
                {
                    throw new WrongUsageException("commands.scoreboard.objectives.usage", new Object[0]);
                }

                if (p_71515_2_[1].equalsIgnoreCase("list"))
                {
                    this.func_96336_d(p_71515_1_);
                }
                else if (p_71515_2_[1].equalsIgnoreCase("add"))
                {
                    if (p_71515_2_.length < 4)
                    {
                        throw new WrongUsageException("commands.scoreboard.objectives.add.usage", new Object[0]);
                    }

                    this.func_96350_b(p_71515_1_, p_71515_2_, 2);
                }
                else if (p_71515_2_[1].equalsIgnoreCase("remove"))
                {
                    if (p_71515_2_.length != 3)
                    {
                        throw new WrongUsageException("commands.scoreboard.objectives.remove.usage", new Object[0]);
                    }

                    this.func_96337_e(p_71515_1_, p_71515_2_[2]);
                }
                else
                {
                    if (!p_71515_2_[1].equalsIgnoreCase("setdisplay"))
                    {
                        throw new WrongUsageException("commands.scoreboard.objectives.usage", new Object[0]);
                    }

                    if (p_71515_2_.length != 3 && p_71515_2_.length != 4)
                    {
                        throw new WrongUsageException("commands.scoreboard.objectives.setdisplay.usage", new Object[0]);
                    }

                    this.func_96347_j(p_71515_1_, p_71515_2_, 2);
                }

                return;
            }

            if (p_71515_2_[0].equalsIgnoreCase("players"))
            {
                if (p_71515_2_.length == 1)
                {
                    throw new WrongUsageException("commands.scoreboard.players.usage", new Object[0]);
                }

                if (p_71515_2_[1].equalsIgnoreCase("list"))
                {
                    if (p_71515_2_.length > 3)
                    {
                        throw new WrongUsageException("commands.scoreboard.players.list.usage", new Object[0]);
                    }

                    this.func_96341_k(p_71515_1_, p_71515_2_, 2);
                }
                else if (p_71515_2_[1].equalsIgnoreCase("add"))
                {
                    if (p_71515_2_.length != 5)
                    {
                        throw new WrongUsageException("commands.scoreboard.players.add.usage", new Object[0]);
                    }

                    this.func_96339_l(p_71515_1_, p_71515_2_, 2);
                }
                else if (p_71515_2_[1].equalsIgnoreCase("remove"))
                {
                    if (p_71515_2_.length != 5)
                    {
                        throw new WrongUsageException("commands.scoreboard.players.remove.usage", new Object[0]);
                    }

                    this.func_96339_l(p_71515_1_, p_71515_2_, 2);
                }
                else if (p_71515_2_[1].equalsIgnoreCase("set"))
                {
                    if (p_71515_2_.length != 5)
                    {
                        throw new WrongUsageException("commands.scoreboard.players.set.usage", new Object[0]);
                    }

                    this.func_96339_l(p_71515_1_, p_71515_2_, 2);
                }
                else
                {
                    if (!p_71515_2_[1].equalsIgnoreCase("reset"))
                    {
                        throw new WrongUsageException("commands.scoreboard.players.usage", new Object[0]);
                    }

                    if (p_71515_2_.length != 3)
                    {
                        throw new WrongUsageException("commands.scoreboard.players.reset.usage", new Object[0]);
                    }

                    this.func_96351_m(p_71515_1_, p_71515_2_, 2);
                }

                return;
            }

            if (p_71515_2_[0].equalsIgnoreCase("teams"))
            {
                if (p_71515_2_.length == 1)
                {
                    throw new WrongUsageException("commands.scoreboard.teams.usage", new Object[0]);
                }

                if (p_71515_2_[1].equalsIgnoreCase("list"))
                {
                    if (p_71515_2_.length > 3)
                    {
                        throw new WrongUsageException("commands.scoreboard.teams.list.usage", new Object[0]);
                    }

                    this.func_96344_f(p_71515_1_, p_71515_2_, 2);
                }
                else if (p_71515_2_[1].equalsIgnoreCase("add"))
                {
                    if (p_71515_2_.length < 3)
                    {
                        throw new WrongUsageException("commands.scoreboard.teams.add.usage", new Object[0]);
                    }

                    this.func_96340_c(p_71515_1_, p_71515_2_, 2);
                }
                else if (p_71515_2_[1].equalsIgnoreCase("remove"))
                {
                    if (p_71515_2_.length != 3)
                    {
                        throw new WrongUsageException("commands.scoreboard.teams.remove.usage", new Object[0]);
                    }

                    this.func_96343_e(p_71515_1_, p_71515_2_, 2);
                }
                else if (p_71515_2_[1].equalsIgnoreCase("empty"))
                {
                    if (p_71515_2_.length != 3)
                    {
                        throw new WrongUsageException("commands.scoreboard.teams.empty.usage", new Object[0]);
                    }

                    this.func_96346_i(p_71515_1_, p_71515_2_, 2);
                }
                else if (p_71515_2_[1].equalsIgnoreCase("join"))
                {
                    if (p_71515_2_.length < 4 && (p_71515_2_.length != 3 || !(p_71515_1_ instanceof EntityPlayer)))
                    {
                        throw new WrongUsageException("commands.scoreboard.teams.join.usage", new Object[0]);
                    }

                    this.func_96342_g(p_71515_1_, p_71515_2_, 2);
                }
                else if (p_71515_2_[1].equalsIgnoreCase("leave"))
                {
                    if (p_71515_2_.length < 3 && !(p_71515_1_ instanceof EntityPlayer))
                    {
                        throw new WrongUsageException("commands.scoreboard.teams.leave.usage", new Object[0]);
                    }

                    this.func_96349_h(p_71515_1_, p_71515_2_, 2);
                }
                else
                {
                    if (!p_71515_2_[1].equalsIgnoreCase("option"))
                    {
                        throw new WrongUsageException("commands.scoreboard.teams.usage", new Object[0]);
                    }

                    if (p_71515_2_.length != 4 && p_71515_2_.length != 5)
                    {
                        throw new WrongUsageException("commands.scoreboard.teams.option.usage", new Object[0]);
                    }

                    this.func_96348_d(p_71515_1_, p_71515_2_, 2);
                }

                return;
            }
        }

        throw new WrongUsageException("commands.scoreboard.usage", new Object[0]);
    }

    protected Scoreboard func_96334_d()
    {
        return MinecraftServer.func_71276_C().func_71218_a(0).func_96441_U();
    }

    protected ScoreObjective func_96345_a(String p_96345_1_, boolean p_96345_2_)
    {
        Scoreboard scoreboard = this.func_96334_d();
        ScoreObjective scoreobjective = scoreboard.func_96518_b(p_96345_1_);

        if (scoreobjective == null)
        {
            throw new CommandException("commands.scoreboard.objectiveNotFound", new Object[] {p_96345_1_});
        }
        else if (p_96345_2_ && scoreobjective.func_96680_c().func_96637_b())
        {
            throw new CommandException("commands.scoreboard.objectiveReadOnly", new Object[] {p_96345_1_});
        }
        else
        {
            return scoreobjective;
        }
    }

    protected ScorePlayerTeam func_96338_a(String p_96338_1_)
    {
        Scoreboard scoreboard = this.func_96334_d();
        ScorePlayerTeam scoreplayerteam = scoreboard.func_96508_e(p_96338_1_);

        if (scoreplayerteam == null)
        {
            throw new CommandException("commands.scoreboard.teamNotFound", new Object[] {p_96338_1_});
        }
        else
        {
            return scoreplayerteam;
        }
    }

    protected void func_96350_b(ICommandSender p_96350_1_, String[] p_96350_2_, int p_96350_3_)
    {
        String s = p_96350_2_[p_96350_3_++];
        String s1 = p_96350_2_[p_96350_3_++];
        Scoreboard scoreboard = this.func_96334_d();
        ScoreObjectiveCriteria scoreobjectivecriteria = (ScoreObjectiveCriteria)ScoreObjectiveCriteria.field_96643_a.get(s1);

        if (scoreobjectivecriteria == null)
        {
            String[] astring1 = (String[])ScoreObjectiveCriteria.field_96643_a.keySet().toArray(new String[0]);
            throw new WrongUsageException("commands.scoreboard.objectives.add.wrongType", new Object[] {func_71527_a(astring1)});
        }
        else if (scoreboard.func_96518_b(s) != null)
        {
            throw new CommandException("commands.scoreboard.objectives.add.alreadyExists", new Object[] {s});
        }
        else if (s.length() > 16)
        {
            throw new SyntaxErrorException("commands.scoreboard.objectives.add.tooLong", new Object[] {s, Integer.valueOf(16)});
        }
        else if (s.length() == 0)
        {
            throw new WrongUsageException("commands.scoreboard.objectives.add.usage", new Object[0]);
        }
        else
        {
            if (p_96350_2_.length > p_96350_3_)
            {
                String s2 = func_82360_a(p_96350_1_, p_96350_2_, p_96350_3_);

                if (s2.length() > 32)
                {
                    throw new SyntaxErrorException("commands.scoreboard.objectives.add.displayTooLong", new Object[] {s2, Integer.valueOf(32)});
                }

                if (s2.length() > 0)
                {
                    scoreboard.func_96535_a(s, scoreobjectivecriteria).func_96681_a(s2);
                }
                else
                {
                    scoreboard.func_96535_a(s, scoreobjectivecriteria);
                }
            }
            else
            {
                scoreboard.func_96535_a(s, scoreobjectivecriteria);
            }

            func_71522_a(p_96350_1_, "commands.scoreboard.objectives.add.success", new Object[] {s});
        }
    }

    protected void func_96340_c(ICommandSender p_96340_1_, String[] p_96340_2_, int p_96340_3_)
    {
        String s = p_96340_2_[p_96340_3_++];
        Scoreboard scoreboard = this.func_96334_d();

        if (scoreboard.func_96508_e(s) != null)
        {
            throw new CommandException("commands.scoreboard.teams.add.alreadyExists", new Object[] {s});
        }
        else if (s.length() > 16)
        {
            throw new SyntaxErrorException("commands.scoreboard.teams.add.tooLong", new Object[] {s, Integer.valueOf(16)});
        }
        else if (s.length() == 0)
        {
            throw new WrongUsageException("commands.scoreboard.teams.add.usage", new Object[0]);
        }
        else
        {
            if (p_96340_2_.length > p_96340_3_)
            {
                String s1 = func_82360_a(p_96340_1_, p_96340_2_, p_96340_3_);

                if (s1.length() > 32)
                {
                    throw new SyntaxErrorException("commands.scoreboard.teams.add.displayTooLong", new Object[] {s1, Integer.valueOf(32)});
                }

                if (s1.length() > 0)
                {
                    scoreboard.func_96527_f(s).func_96664_a(s1);
                }
                else
                {
                    scoreboard.func_96527_f(s);
                }
            }
            else
            {
                scoreboard.func_96527_f(s);
            }

            func_71522_a(p_96340_1_, "commands.scoreboard.teams.add.success", new Object[] {s});
        }
    }

    protected void func_96348_d(ICommandSender p_96348_1_, String[] p_96348_2_, int p_96348_3_)
    {
        ScorePlayerTeam scoreplayerteam = this.func_96338_a(p_96348_2_[p_96348_3_++]);
        String s = p_96348_2_[p_96348_3_++].toLowerCase();

        if (!s.equalsIgnoreCase("color") && !s.equalsIgnoreCase("friendlyfire") && !s.equalsIgnoreCase("seeFriendlyInvisibles"))
        {
            throw new WrongUsageException("commands.scoreboard.teams.option.usage", new Object[0]);
        }
        else if (p_96348_2_.length == 4)
        {
            if (s.equalsIgnoreCase("color"))
            {
                throw new WrongUsageException("commands.scoreboard.teams.option.noValue", new Object[] {s, func_96333_a(EnumChatFormatting.func_96296_a(true, false))});
            }
            else if (!s.equalsIgnoreCase("friendlyfire") && !s.equalsIgnoreCase("seeFriendlyInvisibles"))
            {
                throw new WrongUsageException("commands.scoreboard.teams.option.usage", new Object[0]);
            }
            else
            {
                throw new WrongUsageException("commands.scoreboard.teams.option.noValue", new Object[] {s, func_96333_a(Arrays.asList(new String[]{"true", "false"}))});
            }
        }
        else
        {
            String s1 = p_96348_2_[p_96348_3_++];

            if (s.equalsIgnoreCase("color"))
            {
                EnumChatFormatting enumchatformatting = EnumChatFormatting.func_96300_b(s1);

                if (s1 == null)
                {
                    throw new WrongUsageException("commands.scoreboard.teams.option.noValue", new Object[] {s, func_96333_a(EnumChatFormatting.func_96296_a(true, false))});
                }

                scoreplayerteam.func_96666_b(enumchatformatting.toString());
                scoreplayerteam.func_96662_c(EnumChatFormatting.RESET.toString());
            }
            else if (s.equalsIgnoreCase("friendlyfire"))
            {
                if (!s1.equalsIgnoreCase("true") && !s1.equalsIgnoreCase("false"))
                {
                    throw new WrongUsageException("commands.scoreboard.teams.option.noValue", new Object[] {s, func_96333_a(Arrays.asList(new String[]{"true", "false"}))});
                }

                scoreplayerteam.func_96660_a(s1.equalsIgnoreCase("true"));
            }
            else if (s.equalsIgnoreCase("seeFriendlyInvisibles"))
            {
                if (!s1.equalsIgnoreCase("true") && !s1.equalsIgnoreCase("false"))
                {
                    throw new WrongUsageException("commands.scoreboard.teams.option.noValue", new Object[] {s, func_96333_a(Arrays.asList(new String[]{"true", "false"}))});
                }

                scoreplayerteam.func_98300_b(s1.equalsIgnoreCase("true"));
            }

            func_71522_a(p_96348_1_, "commands.scoreboard.teams.option.success", new Object[] {s, scoreplayerteam.func_96661_b(), s1});
        }
    }

    protected void func_96343_e(ICommandSender p_96343_1_, String[] p_96343_2_, int p_96343_3_)
    {
        Scoreboard scoreboard = this.func_96334_d();
        ScorePlayerTeam scoreplayerteam = this.func_96338_a(p_96343_2_[p_96343_3_++]);
        scoreboard.func_96511_d(scoreplayerteam);
        func_71522_a(p_96343_1_, "commands.scoreboard.teams.remove.success", new Object[] {scoreplayerteam.func_96661_b()});
    }

    protected void func_96344_f(ICommandSender p_96344_1_, String[] p_96344_2_, int p_96344_3_)
    {
        Scoreboard scoreboard = this.func_96334_d();

        if (p_96344_2_.length > p_96344_3_)
        {
            ScorePlayerTeam scoreplayerteam = this.func_96338_a(p_96344_2_[p_96344_3_++]);
            Collection collection = scoreplayerteam.func_96670_d();

            if (collection.size() <= 0)
            {
                throw new CommandException("commands.scoreboard.teams.list.player.empty", new Object[] {scoreplayerteam.func_96661_b()});
            }

            p_96344_1_.func_70006_a(ChatMessageComponent.func_111082_b("commands.scoreboard.teams.list.player.count", new Object[] {Integer.valueOf(collection.size()), scoreplayerteam.func_96661_b()}).func_111059_a(EnumChatFormatting.DARK_GREEN));
            p_96344_1_.func_70006_a(ChatMessageComponent.func_111066_d(func_71527_a(collection.toArray())));
        }
        else
        {
            Collection collection1 = scoreboard.func_96525_g();

            if (collection1.size() <= 0)
            {
                throw new CommandException("commands.scoreboard.teams.list.empty", new Object[0]);
            }

            p_96344_1_.func_70006_a(ChatMessageComponent.func_111082_b("commands.scoreboard.teams.list.count", new Object[] {Integer.valueOf(collection1.size())}).func_111059_a(EnumChatFormatting.DARK_GREEN));
            Iterator iterator = collection1.iterator();

            while (iterator.hasNext())
            {
                ScorePlayerTeam scoreplayerteam1 = (ScorePlayerTeam)iterator.next();
                p_96344_1_.func_70006_a(ChatMessageComponent.func_111082_b("commands.scoreboard.teams.list.entry", new Object[] {scoreplayerteam1.func_96661_b(), scoreplayerteam1.func_96669_c(), Integer.valueOf(scoreplayerteam1.func_96670_d().size())}));
            }
        }
    }

    protected void func_96342_g(ICommandSender p_96342_1_, String[] p_96342_2_, int p_96342_3_)
    {
        Scoreboard scoreboard = this.func_96334_d();
        ScorePlayerTeam scoreplayerteam = scoreboard.func_96508_e(p_96342_2_[p_96342_3_++]);
        HashSet hashset = new HashSet();
        String s;

        if (p_96342_1_ instanceof EntityPlayer && p_96342_3_ == p_96342_2_.length)
        {
            s = func_71521_c(p_96342_1_).func_70023_ak();
            scoreboard.func_96521_a(s, scoreplayerteam);
            hashset.add(s);
        }
        else
        {
            while (p_96342_3_ < p_96342_2_.length)
            {
                s = func_96332_d(p_96342_1_, p_96342_2_[p_96342_3_++]);
                scoreboard.func_96521_a(s, scoreplayerteam);
                hashset.add(s);
            }
        }

        if (!hashset.isEmpty())
        {
            func_71522_a(p_96342_1_, "commands.scoreboard.teams.join.success", new Object[] {Integer.valueOf(hashset.size()), scoreplayerteam.func_96661_b(), func_71527_a(hashset.toArray(new String[0]))});
        }
    }

    protected void func_96349_h(ICommandSender p_96349_1_, String[] p_96349_2_, int p_96349_3_)
    {
        Scoreboard scoreboard = this.func_96334_d();
        HashSet hashset = new HashSet();
        HashSet hashset1 = new HashSet();
        String s;

        if (p_96349_1_ instanceof EntityPlayer && p_96349_3_ == p_96349_2_.length)
        {
            s = func_71521_c(p_96349_1_).func_70023_ak();

            if (scoreboard.func_96524_g(s))
            {
                hashset.add(s);
            }
            else
            {
                hashset1.add(s);
            }
        }
        else
        {
            while (p_96349_3_ < p_96349_2_.length)
            {
                s = func_96332_d(p_96349_1_, p_96349_2_[p_96349_3_++]);

                if (scoreboard.func_96524_g(s))
                {
                    hashset.add(s);
                }
                else
                {
                    hashset1.add(s);
                }
            }
        }

        if (!hashset.isEmpty())
        {
            func_71522_a(p_96349_1_, "commands.scoreboard.teams.leave.success", new Object[] {Integer.valueOf(hashset.size()), func_71527_a(hashset.toArray(new String[0]))});
        }

        if (!hashset1.isEmpty())
        {
            throw new CommandException("commands.scoreboard.teams.leave.failure", new Object[] {Integer.valueOf(hashset1.size()), func_71527_a(hashset1.toArray(new String[0]))});
        }
    }

    protected void func_96346_i(ICommandSender p_96346_1_, String[] p_96346_2_, int p_96346_3_)
    {
        Scoreboard scoreboard = this.func_96334_d();
        ScorePlayerTeam scoreplayerteam = this.func_96338_a(p_96346_2_[p_96346_3_++]);
        ArrayList arraylist = new ArrayList(scoreplayerteam.func_96670_d());

        if (arraylist.isEmpty())
        {
            throw new CommandException("commands.scoreboard.teams.empty.alreadyEmpty", new Object[] {scoreplayerteam.func_96661_b()});
        }
        else
        {
            Iterator iterator = arraylist.iterator();

            while (iterator.hasNext())
            {
                String s = (String)iterator.next();
                scoreboard.func_96512_b(s, scoreplayerteam);
            }

            func_71522_a(p_96346_1_, "commands.scoreboard.teams.empty.success", new Object[] {Integer.valueOf(arraylist.size()), scoreplayerteam.func_96661_b()});
        }
    }

    protected void func_96337_e(ICommandSender p_96337_1_, String p_96337_2_)
    {
        Scoreboard scoreboard = this.func_96334_d();
        ScoreObjective scoreobjective = this.func_96345_a(p_96337_2_, false);
        scoreboard.func_96519_k(scoreobjective);
        func_71522_a(p_96337_1_, "commands.scoreboard.objectives.remove.success", new Object[] {p_96337_2_});
    }

    protected void func_96336_d(ICommandSender p_96336_1_)
    {
        Scoreboard scoreboard = this.func_96334_d();
        Collection collection = scoreboard.func_96514_c();

        if (collection.size() <= 0)
        {
            throw new CommandException("commands.scoreboard.objectives.list.empty", new Object[0]);
        }
        else
        {
            p_96336_1_.func_70006_a(ChatMessageComponent.func_111082_b("commands.scoreboard.objectives.list.count", new Object[] {Integer.valueOf(collection.size())}).func_111059_a(EnumChatFormatting.DARK_GREEN));
            Iterator iterator = collection.iterator();

            while (iterator.hasNext())
            {
                ScoreObjective scoreobjective = (ScoreObjective)iterator.next();
                p_96336_1_.func_70006_a(ChatMessageComponent.func_111082_b("commands.scoreboard.objectives.list.entry", new Object[] {scoreobjective.func_96679_b(), scoreobjective.func_96678_d(), scoreobjective.func_96680_c().func_96636_a()}));
            }
        }
    }

    protected void func_96347_j(ICommandSender p_96347_1_, String[] p_96347_2_, int p_96347_3_)
    {
        Scoreboard scoreboard = this.func_96334_d();
        String s = p_96347_2_[p_96347_3_++];
        int j = Scoreboard.func_96537_j(s);
        ScoreObjective scoreobjective = null;

        if (p_96347_2_.length == 4)
        {
            scoreobjective = this.func_96345_a(p_96347_2_[p_96347_3_++], false);
        }

        if (j < 0)
        {
            throw new CommandException("commands.scoreboard.objectives.setdisplay.invalidSlot", new Object[] {s});
        }
        else
        {
            scoreboard.func_96530_a(j, scoreobjective);

            if (scoreobjective != null)
            {
                func_71522_a(p_96347_1_, "commands.scoreboard.objectives.setdisplay.successSet", new Object[] {Scoreboard.func_96517_b(j), scoreobjective.func_96679_b()});
            }
            else
            {
                func_71522_a(p_96347_1_, "commands.scoreboard.objectives.setdisplay.successCleared", new Object[] {Scoreboard.func_96517_b(j)});
            }
        }
    }

    protected void func_96341_k(ICommandSender p_96341_1_, String[] p_96341_2_, int p_96341_3_)
    {
        Scoreboard scoreboard = this.func_96334_d();

        if (p_96341_2_.length > p_96341_3_)
        {
            String s = func_96332_d(p_96341_1_, p_96341_2_[p_96341_3_++]);
            Map map = scoreboard.func_96510_d(s);

            if (map.size() <= 0)
            {
                throw new CommandException("commands.scoreboard.players.list.player.empty", new Object[] {s});
            }

            p_96341_1_.func_70006_a(ChatMessageComponent.func_111082_b("commands.scoreboard.players.list.player.count", new Object[] {Integer.valueOf(map.size()), s}).func_111059_a(EnumChatFormatting.DARK_GREEN));
            Iterator iterator = map.values().iterator();

            while (iterator.hasNext())
            {
                Score score = (Score)iterator.next();
                p_96341_1_.func_70006_a(ChatMessageComponent.func_111082_b("commands.scoreboard.players.list.player.entry", new Object[] {Integer.valueOf(score.func_96652_c()), score.func_96645_d().func_96678_d(), score.func_96645_d().func_96679_b()}));
            }
        }
        else
        {
            Collection collection = scoreboard.func_96526_d();

            if (collection.size() <= 0)
            {
                throw new CommandException("commands.scoreboard.players.list.empty", new Object[0]);
            }

            p_96341_1_.func_70006_a(ChatMessageComponent.func_111082_b("commands.scoreboard.players.list.count", new Object[] {Integer.valueOf(collection.size())}).func_111059_a(EnumChatFormatting.DARK_GREEN));
            p_96341_1_.func_70006_a(ChatMessageComponent.func_111066_d(func_71527_a(collection.toArray())));
        }
    }

    protected void func_96339_l(ICommandSender p_96339_1_, String[] p_96339_2_, int p_96339_3_)
    {
        String s = p_96339_2_[p_96339_3_ - 1];
        String s1 = func_96332_d(p_96339_1_, p_96339_2_[p_96339_3_++]);
        ScoreObjective scoreobjective = this.func_96345_a(p_96339_2_[p_96339_3_++], true);
        int j = s.equalsIgnoreCase("set") ? func_71526_a(p_96339_1_, p_96339_2_[p_96339_3_++]) : func_71528_a(p_96339_1_, p_96339_2_[p_96339_3_++], 1);
        Scoreboard scoreboard = this.func_96334_d();
        Score score = scoreboard.func_96529_a(s1, scoreobjective);

        if (s.equalsIgnoreCase("set"))
        {
            score.func_96647_c(j);
        }
        else if (s.equalsIgnoreCase("add"))
        {
            score.func_96649_a(j);
        }
        else
        {
            score.func_96646_b(j);
        }

        func_71522_a(p_96339_1_, "commands.scoreboard.players.set.success", new Object[] {scoreobjective.func_96679_b(), s1, Integer.valueOf(score.func_96652_c())});
    }

    protected void func_96351_m(ICommandSender p_96351_1_, String[] p_96351_2_, int p_96351_3_)
    {
        Scoreboard scoreboard = this.func_96334_d();
        String s = func_96332_d(p_96351_1_, p_96351_2_[p_96351_3_++]);
        scoreboard.func_96515_c(s);
        func_71522_a(p_96351_1_, "commands.scoreboard.players.reset.success", new Object[] {s});
    }

    public List func_71516_a(ICommandSender p_71516_1_, String[] p_71516_2_)
    {
        if (p_71516_2_.length == 1)
        {
            return func_71530_a(p_71516_2_, new String[] {"objectives", "players", "teams"});
        }
        else
        {
            if (p_71516_2_[0].equalsIgnoreCase("objectives"))
            {
                if (p_71516_2_.length == 2)
                {
                    return func_71530_a(p_71516_2_, new String[] {"list", "add", "remove", "setdisplay"});
                }

                if (p_71516_2_[1].equalsIgnoreCase("add"))
                {
                    if (p_71516_2_.length == 4)
                    {
                        return func_71531_a(p_71516_2_, ScoreObjectiveCriteria.field_96643_a.keySet());
                    }
                }
                else if (p_71516_2_[1].equalsIgnoreCase("remove"))
                {
                    if (p_71516_2_.length == 3)
                    {
                        return func_71531_a(p_71516_2_, this.func_96335_a(false));
                    }
                }
                else if (p_71516_2_[1].equalsIgnoreCase("setdisplay"))
                {
                    if (p_71516_2_.length == 3)
                    {
                        return func_71530_a(p_71516_2_, new String[] {"list", "sidebar", "belowName"});
                    }

                    if (p_71516_2_.length == 4)
                    {
                        return func_71531_a(p_71516_2_, this.func_96335_a(false));
                    }
                }
            }
            else if (p_71516_2_[0].equalsIgnoreCase("players"))
            {
                if (p_71516_2_.length == 2)
                {
                    return func_71530_a(p_71516_2_, new String[] {"set", "add", "remove", "reset", "list"});
                }

                if (!p_71516_2_[1].equalsIgnoreCase("set") && !p_71516_2_[1].equalsIgnoreCase("add") && !p_71516_2_[1].equalsIgnoreCase("remove"))
                {
                    if ((p_71516_2_[1].equalsIgnoreCase("reset") || p_71516_2_[1].equalsIgnoreCase("list")) && p_71516_2_.length == 3)
                    {
                        return func_71531_a(p_71516_2_, this.func_96334_d().func_96526_d());
                    }
                }
                else
                {
                    if (p_71516_2_.length == 3)
                    {
                        return func_71530_a(p_71516_2_, MinecraftServer.func_71276_C().func_71213_z());
                    }

                    if (p_71516_2_.length == 4)
                    {
                        return func_71531_a(p_71516_2_, this.func_96335_a(true));
                    }
                }
            }
            else if (p_71516_2_[0].equalsIgnoreCase("teams"))
            {
                if (p_71516_2_.length == 2)
                {
                    return func_71530_a(p_71516_2_, new String[] {"add", "remove", "join", "leave", "empty", "list", "option"});
                }

                if (p_71516_2_[1].equalsIgnoreCase("join"))
                {
                    if (p_71516_2_.length == 3)
                    {
                        return func_71531_a(p_71516_2_, this.func_96334_d().func_96531_f());
                    }

                    if (p_71516_2_.length >= 4)
                    {
                        return func_71530_a(p_71516_2_, MinecraftServer.func_71276_C().func_71213_z());
                    }
                }
                else
                {
                    if (p_71516_2_[1].equalsIgnoreCase("leave"))
                    {
                        return func_71530_a(p_71516_2_, MinecraftServer.func_71276_C().func_71213_z());
                    }

                    if (!p_71516_2_[1].equalsIgnoreCase("empty") && !p_71516_2_[1].equalsIgnoreCase("list") && !p_71516_2_[1].equalsIgnoreCase("remove"))
                    {
                        if (p_71516_2_[1].equalsIgnoreCase("option"))
                        {
                            if (p_71516_2_.length == 3)
                            {
                                return func_71531_a(p_71516_2_, this.func_96334_d().func_96531_f());
                            }

                            if (p_71516_2_.length == 4)
                            {
                                return func_71530_a(p_71516_2_, new String[] {"color", "friendlyfire", "seeFriendlyInvisibles"});
                            }

                            if (p_71516_2_.length == 5)
                            {
                                if (p_71516_2_[3].equalsIgnoreCase("color"))
                                {
                                    return func_71531_a(p_71516_2_, EnumChatFormatting.func_96296_a(true, false));
                                }

                                if (p_71516_2_[3].equalsIgnoreCase("friendlyfire") || p_71516_2_[3].equalsIgnoreCase("seeFriendlyInvisibles"))
                                {
                                    return func_71530_a(p_71516_2_, new String[] {"true", "false"});
                                }
                            }
                        }
                    }
                    else if (p_71516_2_.length == 3)
                    {
                        return func_71531_a(p_71516_2_, this.func_96334_d().func_96531_f());
                    }
                }
            }

            return null;
        }
    }

    protected List func_96335_a(boolean p_96335_1_)
    {
        Collection collection = this.func_96334_d().func_96514_c();
        ArrayList arraylist = new ArrayList();
        Iterator iterator = collection.iterator();

        while (iterator.hasNext())
        {
            ScoreObjective scoreobjective = (ScoreObjective)iterator.next();

            if (!p_96335_1_ || !scoreobjective.func_96680_c().func_96637_b())
            {
                arraylist.add(scoreobjective.func_96679_b());
            }
        }

        return arraylist;
    }

    public boolean func_82358_a(String[] p_82358_1_, int p_82358_2_)
    {
        return p_82358_1_[0].equalsIgnoreCase("players") ? p_82358_2_ == 2 : (!p_82358_1_[0].equalsIgnoreCase("teams") ? false : p_82358_2_ == 2 || p_82358_2_ == 3);
    }
}
