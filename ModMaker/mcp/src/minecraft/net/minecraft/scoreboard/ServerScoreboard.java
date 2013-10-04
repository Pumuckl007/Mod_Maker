package net.minecraft.scoreboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet206SetObjective;
import net.minecraft.network.packet.Packet207SetScore;
import net.minecraft.network.packet.Packet208SetDisplayObjective;
import net.minecraft.network.packet.Packet209SetPlayerTeam;
import net.minecraft.server.MinecraftServer;

public class ServerScoreboard extends Scoreboard
{
    private final MinecraftServer field_96555_a;
    private final Set field_96553_b = new HashSet();
    private ScoreboardSaveData field_96554_c;

    public ServerScoreboard(MinecraftServer p_i1501_1_)
    {
        this.field_96555_a = p_i1501_1_;
    }

    public void func_96536_a(Score p_96536_1_)
    {
        super.func_96536_a(p_96536_1_);

        if (this.field_96553_b.contains(p_96536_1_.func_96645_d()))
        {
            this.field_96555_a.func_71203_ab().func_72384_a(new Packet207SetScore(p_96536_1_, 0));
        }

        this.func_96551_b();
    }

    public void func_96516_a(String p_96516_1_)
    {
        super.func_96516_a(p_96516_1_);
        this.field_96555_a.func_71203_ab().func_72384_a(new Packet207SetScore(p_96516_1_));
        this.func_96551_b();
    }

    public void func_96530_a(int p_96530_1_, ScoreObjective p_96530_2_)
    {
        ScoreObjective scoreobjective1 = this.func_96539_a(p_96530_1_);
        super.func_96530_a(p_96530_1_, p_96530_2_);

        if (scoreobjective1 != p_96530_2_ && scoreobjective1 != null)
        {
            if (this.func_96552_h(scoreobjective1) > 0)
            {
                this.field_96555_a.func_71203_ab().func_72384_a(new Packet208SetDisplayObjective(p_96530_1_, p_96530_2_));
            }
            else
            {
                this.func_96546_g(scoreobjective1);
            }
        }

        if (p_96530_2_ != null)
        {
            if (this.field_96553_b.contains(p_96530_2_))
            {
                this.field_96555_a.func_71203_ab().func_72384_a(new Packet208SetDisplayObjective(p_96530_1_, p_96530_2_));
            }
            else
            {
                this.func_96549_e(p_96530_2_);
            }
        }

        this.func_96551_b();
    }

    public void func_96521_a(String p_96521_1_, ScorePlayerTeam p_96521_2_)
    {
        super.func_96521_a(p_96521_1_, p_96521_2_);
        this.field_96555_a.func_71203_ab().func_72384_a(new Packet209SetPlayerTeam(p_96521_2_, Arrays.asList(new String[] {p_96521_1_}), 3));
        this.func_96551_b();
    }

    public void func_96512_b(String p_96512_1_, ScorePlayerTeam p_96512_2_)
    {
        super.func_96512_b(p_96512_1_, p_96512_2_);
        this.field_96555_a.func_71203_ab().func_72384_a(new Packet209SetPlayerTeam(p_96512_2_, Arrays.asList(new String[] {p_96512_1_}), 4));
        this.func_96551_b();
    }

    public void func_96522_a(ScoreObjective p_96522_1_)
    {
        super.func_96522_a(p_96522_1_);
        this.func_96551_b();
    }

    public void func_96532_b(ScoreObjective p_96532_1_)
    {
        super.func_96532_b(p_96532_1_);

        if (this.field_96553_b.contains(p_96532_1_))
        {
            this.field_96555_a.func_71203_ab().func_72384_a(new Packet206SetObjective(p_96532_1_, 2));
        }

        this.func_96551_b();
    }

    public void func_96533_c(ScoreObjective p_96533_1_)
    {
        super.func_96533_c(p_96533_1_);

        if (this.field_96553_b.contains(p_96533_1_))
        {
            this.func_96546_g(p_96533_1_);
        }

        this.func_96551_b();
    }

    public void func_96523_a(ScorePlayerTeam p_96523_1_)
    {
        super.func_96523_a(p_96523_1_);
        this.field_96555_a.func_71203_ab().func_72384_a(new Packet209SetPlayerTeam(p_96523_1_, 0));
        this.func_96551_b();
    }

    public void func_96538_b(ScorePlayerTeam p_96538_1_)
    {
        super.func_96538_b(p_96538_1_);
        this.field_96555_a.func_71203_ab().func_72384_a(new Packet209SetPlayerTeam(p_96538_1_, 2));
        this.func_96551_b();
    }

    public void func_96513_c(ScorePlayerTeam p_96513_1_)
    {
        super.func_96513_c(p_96513_1_);
        this.field_96555_a.func_71203_ab().func_72384_a(new Packet209SetPlayerTeam(p_96513_1_, 1));
        this.func_96551_b();
    }

    public void func_96547_a(ScoreboardSaveData p_96547_1_)
    {
        this.field_96554_c = p_96547_1_;
    }

    protected void func_96551_b()
    {
        if (this.field_96554_c != null)
        {
            this.field_96554_c.func_76185_a();
        }
    }

    public List func_96550_d(ScoreObjective p_96550_1_)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new Packet206SetObjective(p_96550_1_, 0));

        for (int i = 0; i < 3; ++i)
        {
            if (this.func_96539_a(i) == p_96550_1_)
            {
                arraylist.add(new Packet208SetDisplayObjective(i, p_96550_1_));
            }
        }

        Iterator iterator = this.func_96534_i(p_96550_1_).iterator();

        while (iterator.hasNext())
        {
            Score score = (Score)iterator.next();
            arraylist.add(new Packet207SetScore(score, 0));
        }

        return arraylist;
    }

    public void func_96549_e(ScoreObjective p_96549_1_)
    {
        List list = this.func_96550_d(p_96549_1_);
        Iterator iterator = this.field_96555_a.func_71203_ab().field_72404_b.iterator();

        while (iterator.hasNext())
        {
            EntityPlayerMP entityplayermp = (EntityPlayerMP)iterator.next();
            Iterator iterator1 = list.iterator();

            while (iterator1.hasNext())
            {
                Packet packet = (Packet)iterator1.next();
                entityplayermp.field_71135_a.func_72567_b(packet);
            }
        }

        this.field_96553_b.add(p_96549_1_);
    }

    public List func_96548_f(ScoreObjective p_96548_1_)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new Packet206SetObjective(p_96548_1_, 1));

        for (int i = 0; i < 3; ++i)
        {
            if (this.func_96539_a(i) == p_96548_1_)
            {
                arraylist.add(new Packet208SetDisplayObjective(i, p_96548_1_));
            }
        }

        return arraylist;
    }

    public void func_96546_g(ScoreObjective p_96546_1_)
    {
        List list = this.func_96548_f(p_96546_1_);
        Iterator iterator = this.field_96555_a.func_71203_ab().field_72404_b.iterator();

        while (iterator.hasNext())
        {
            EntityPlayerMP entityplayermp = (EntityPlayerMP)iterator.next();
            Iterator iterator1 = list.iterator();

            while (iterator1.hasNext())
            {
                Packet packet = (Packet)iterator1.next();
                entityplayermp.field_71135_a.func_72567_b(packet);
            }
        }

        this.field_96553_b.remove(p_96546_1_);
    }

    public int func_96552_h(ScoreObjective p_96552_1_)
    {
        int i = 0;

        for (int j = 0; j < 3; ++j)
        {
            if (this.func_96539_a(j) == p_96552_1_)
            {
                ++i;
            }
        }

        return i;
    }
}
