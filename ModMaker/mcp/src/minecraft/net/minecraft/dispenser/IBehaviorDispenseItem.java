package net.minecraft.dispenser;

import net.minecraft.item.ItemStack;

public interface IBehaviorDispenseItem
{
    IBehaviorDispenseItem field_82483_a = new BehaviorDispenseItemProvider();

    ItemStack func_82482_a(IBlockSource iblocksource, ItemStack itemstack);
}
