package net.minecraft.dispenser;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDispenser;
import net.minecraft.item.Item;

public class DispenserBehaviors
{
    public static void func_96467_a()
    {
        BlockDispenser.field_82527_a.func_82595_a(Item.field_77704_l, new DispenserBehaviorArrow());
        BlockDispenser.field_82527_a.func_82595_a(Item.field_77764_aP, new DispenserBehaviorEgg());
        BlockDispenser.field_82527_a.func_82595_a(Item.field_77768_aD, new DispenserBehaviorSnowball());
        BlockDispenser.field_82527_a.func_82595_a(Item.field_77809_bD, new DispenserBehaviorExperience());
        BlockDispenser.field_82527_a.func_82595_a(Item.field_77726_bs, new DispenserBehaviorPotion());
        BlockDispenser.field_82527_a.func_82595_a(Item.field_77815_bC, new DispenserBehaviorMobEgg());
        BlockDispenser.field_82527_a.func_82595_a(Item.field_92104_bU, new DispenserBehaviorFireworks());
        BlockDispenser.field_82527_a.func_82595_a(Item.field_77811_bE, new DispenserBehaviorFireball());
        BlockDispenser.field_82527_a.func_82595_a(Item.field_77769_aE, new DispenserBehaviorBoat());
        DispenserBehaviorFilledBucket dispenserbehaviorfilledbucket = new DispenserBehaviorFilledBucket();
        BlockDispenser.field_82527_a.func_82595_a(Item.field_77775_ay, dispenserbehaviorfilledbucket);
        BlockDispenser.field_82527_a.func_82595_a(Item.field_77786_ax, dispenserbehaviorfilledbucket);
        BlockDispenser.field_82527_a.func_82595_a(Item.field_77788_aw, new DispenserBehaviorEmptyBucket());
        BlockDispenser.field_82527_a.func_82595_a(Item.field_77709_i, new DispenserBehaviorFire());
        BlockDispenser.field_82527_a.func_82595_a(Item.field_77756_aW, new DispenserBehaviorDye());
        BlockDispenser.field_82527_a.func_82595_a(Item.field_77698_e[Block.field_72091_am.field_71990_ca], new DispenserBehaviorTNT());
    }
}
