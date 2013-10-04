package net.minecraft.network.packet;

public abstract class NetHandler
{
    public abstract boolean func_72489_a();

    public void func_72463_a(Packet51MapChunk p_72463_1_) {}

    public void func_72509_a(Packet p_72509_1_) {}

    public void func_72515_a(String p_72515_1_, Object[] p_72515_2_) {}

    public void func_72492_a(Packet255KickDisconnect p_72492_1_)
    {
        this.func_72509_a(p_72492_1_);
    }

    public void func_72455_a(Packet1Login p_72455_1_)
    {
        this.func_72509_a(p_72455_1_);
    }

    public void func_72498_a(Packet10Flying p_72498_1_)
    {
        this.func_72509_a(p_72498_1_);
    }

    public void func_72496_a(Packet52MultiBlockChange p_72496_1_)
    {
        this.func_72509_a(p_72496_1_);
    }

    public void func_72510_a(Packet14BlockDig p_72510_1_)
    {
        this.func_72509_a(p_72510_1_);
    }

    public void func_72456_a(Packet53BlockChange p_72456_1_)
    {
        this.func_72509_a(p_72456_1_);
    }

    public void func_72518_a(Packet20NamedEntitySpawn p_72518_1_)
    {
        this.func_72509_a(p_72518_1_);
    }

    public void func_72482_a(Packet30Entity p_72482_1_)
    {
        this.func_72509_a(p_72482_1_);
    }

    public void func_72512_a(Packet34EntityTeleport p_72512_1_)
    {
        this.func_72509_a(p_72512_1_);
    }

    public void func_72472_a(Packet15Place p_72472_1_)
    {
        this.func_72509_a(p_72472_1_);
    }

    public void func_72502_a(Packet16BlockItemSwitch p_72502_1_)
    {
        this.func_72509_a(p_72502_1_);
    }

    public void func_72491_a(Packet29DestroyEntity p_72491_1_)
    {
        this.func_72509_a(p_72491_1_);
    }

    public void func_72475_a(Packet22Collect p_72475_1_)
    {
        this.func_72509_a(p_72475_1_);
    }

    public void func_72481_a(Packet3Chat p_72481_1_)
    {
        this.func_72509_a(p_72481_1_);
    }

    public void func_72511_a(Packet23VehicleSpawn p_72511_1_)
    {
        this.func_72509_a(p_72511_1_);
    }

    public void func_72524_a(Packet18Animation p_72524_1_)
    {
        this.func_72509_a(p_72524_1_);
    }

    public void func_72473_a(Packet19EntityAction p_72473_1_)
    {
        this.func_72509_a(p_72473_1_);
    }

    public void func_72500_a(Packet2ClientProtocol p_72500_1_)
    {
        this.func_72509_a(p_72500_1_);
    }

    public void func_72470_a(Packet253ServerAuthData p_72470_1_)
    {
        this.func_72509_a(p_72470_1_);
    }

    public void func_72513_a(Packet252SharedKey p_72513_1_)
    {
        this.func_72509_a(p_72513_1_);
    }

    public void func_72519_a(Packet24MobSpawn p_72519_1_)
    {
        this.func_72509_a(p_72519_1_);
    }

    public void func_72497_a(Packet4UpdateTime p_72497_1_)
    {
        this.func_72509_a(p_72497_1_);
    }

    public void func_72466_a(Packet6SpawnPosition p_72466_1_)
    {
        this.func_72509_a(p_72466_1_);
    }

    public void func_72520_a(Packet28EntityVelocity p_72520_1_)
    {
        this.func_72509_a(p_72520_1_);
    }

    public void func_72493_a(Packet40EntityMetadata p_72493_1_)
    {
        this.func_72509_a(p_72493_1_);
    }

    public void func_72484_a(Packet39AttachEntity p_72484_1_)
    {
        this.func_72509_a(p_72484_1_);
    }

    public void func_72507_a(Packet7UseEntity p_72507_1_)
    {
        this.func_72509_a(p_72507_1_);
    }

    public void func_72485_a(Packet38EntityStatus p_72485_1_)
    {
        this.func_72509_a(p_72485_1_);
    }

    public void func_72521_a(Packet8UpdateHealth p_72521_1_)
    {
        this.func_72509_a(p_72521_1_);
    }

    public void func_72483_a(Packet9Respawn p_72483_1_)
    {
        this.func_72509_a(p_72483_1_);
    }

    public void func_72499_a(Packet60Explosion p_72499_1_)
    {
        this.func_72509_a(p_72499_1_);
    }

    public void func_72516_a(Packet100OpenWindow p_72516_1_)
    {
        this.func_72509_a(p_72516_1_);
    }

    public void func_72474_a(Packet101CloseWindow p_72474_1_)
    {
        this.func_72509_a(p_72474_1_);
    }

    public void func_72523_a(Packet102WindowClick p_72523_1_)
    {
        this.func_72509_a(p_72523_1_);
    }

    public void func_72490_a(Packet103SetSlot p_72490_1_)
    {
        this.func_72509_a(p_72490_1_);
    }

    public void func_72486_a(Packet104WindowItems p_72486_1_)
    {
        this.func_72509_a(p_72486_1_);
    }

    public void func_72487_a(Packet130UpdateSign p_72487_1_)
    {
        this.func_72509_a(p_72487_1_);
    }

    public void func_72505_a(Packet105UpdateProgressbar p_72505_1_)
    {
        this.func_72509_a(p_72505_1_);
    }

    public void func_72506_a(Packet5PlayerInventory p_72506_1_)
    {
        this.func_72509_a(p_72506_1_);
    }

    public void func_72476_a(Packet106Transaction p_72476_1_)
    {
        this.func_72509_a(p_72476_1_);
    }

    public void func_72495_a(Packet25EntityPainting p_72495_1_)
    {
        this.func_72509_a(p_72495_1_);
    }

    public void func_72454_a(Packet54PlayNoteBlock p_72454_1_)
    {
        this.func_72509_a(p_72454_1_);
    }

    public void func_72517_a(Packet200Statistic p_72517_1_)
    {
        this.func_72509_a(p_72517_1_);
    }

    public void func_72460_a(Packet17Sleep p_72460_1_)
    {
        this.func_72509_a(p_72460_1_);
    }

    public void func_110774_a(Packet27PlayerInput p_110774_1_)
    {
        this.func_72509_a(p_110774_1_);
    }

    public void func_72488_a(Packet70GameEvent p_72488_1_)
    {
        this.func_72509_a(p_72488_1_);
    }

    public void func_72508_a(Packet71Weather p_72508_1_)
    {
        this.func_72509_a(p_72508_1_);
    }

    public void func_72494_a(Packet131MapData p_72494_1_)
    {
        this.func_72509_a(p_72494_1_);
    }

    public void func_72462_a(Packet61DoorChange p_72462_1_)
    {
        this.func_72509_a(p_72462_1_);
    }

    public void func_72467_a(Packet254ServerPing p_72467_1_)
    {
        this.func_72509_a(p_72467_1_);
    }

    public void func_72503_a(Packet41EntityEffect p_72503_1_)
    {
        this.func_72509_a(p_72503_1_);
    }

    public void func_72452_a(Packet42RemoveEntityEffect p_72452_1_)
    {
        this.func_72509_a(p_72452_1_);
    }

    public void func_72480_a(Packet201PlayerInfo p_72480_1_)
    {
        this.func_72509_a(p_72480_1_);
    }

    public void func_72477_a(Packet0KeepAlive p_72477_1_)
    {
        this.func_72509_a(p_72477_1_);
    }

    public void func_72522_a(Packet43Experience p_72522_1_)
    {
        this.func_72509_a(p_72522_1_);
    }

    public void func_72464_a(Packet107CreativeSetSlot p_72464_1_)
    {
        this.func_72509_a(p_72464_1_);
    }

    public void func_72514_a(Packet26EntityExpOrb p_72514_1_)
    {
        this.func_72509_a(p_72514_1_);
    }

    public void func_72479_a(Packet108EnchantItem p_72479_1_) {}

    public void func_72501_a(Packet250CustomPayload p_72501_1_) {}

    public void func_72478_a(Packet35EntityHeadRotation p_72478_1_)
    {
        this.func_72509_a(p_72478_1_);
    }

    public void func_72468_a(Packet132TileEntityData p_72468_1_)
    {
        this.func_72509_a(p_72468_1_);
    }

    public void func_72471_a(Packet202PlayerAbilities p_72471_1_)
    {
        this.func_72509_a(p_72471_1_);
    }

    public void func_72461_a(Packet203AutoComplete p_72461_1_)
    {
        this.func_72509_a(p_72461_1_);
    }

    public void func_72504_a(Packet204ClientInfo p_72504_1_)
    {
        this.func_72509_a(p_72504_1_);
    }

    public void func_72457_a(Packet62LevelSound p_72457_1_)
    {
        this.func_72509_a(p_72457_1_);
    }

    public void func_72465_a(Packet55BlockDestroy p_72465_1_)
    {
        this.func_72509_a(p_72465_1_);
    }

    public void func_72458_a(Packet205ClientCommand p_72458_1_) {}

    public void func_72453_a(Packet56MapChunks p_72453_1_)
    {
        this.func_72509_a(p_72453_1_);
    }

    public boolean func_72469_b()
    {
        return false;
    }

    public void func_96436_a(Packet206SetObjective p_96436_1_)
    {
        this.func_72509_a(p_96436_1_);
    }

    public void func_96437_a(Packet207SetScore p_96437_1_)
    {
        this.func_72509_a(p_96437_1_);
    }

    public void func_96438_a(Packet208SetDisplayObjective p_96438_1_)
    {
        this.func_72509_a(p_96438_1_);
    }

    public void func_96435_a(Packet209SetPlayerTeam p_96435_1_)
    {
        this.func_72509_a(p_96435_1_);
    }

    public void func_98182_a(Packet63WorldParticles p_98182_1_)
    {
        this.func_72509_a(p_98182_1_);
    }

    public void func_110773_a(Packet44UpdateAttributes p_110773_1_)
    {
        this.func_72509_a(p_110773_1_);
    }

    public void func_142031_a(Packet133TileEditorOpen p_142031_1_) {}

    public boolean func_142032_c()
    {
        return false;
    }
}
