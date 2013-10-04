package net.minecraft.dispenser;

import net.minecraft.entity.IProjectile;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.world.World;

final class DispenserBehaviorArrow extends BehaviorProjectileDispense
{
    protected IProjectile func_82499_a(World p_82499_1_, IPosition p_82499_2_)
    {
        EntityArrow entityarrow = new EntityArrow(p_82499_1_, p_82499_2_.func_82615_a(), p_82499_2_.func_82617_b(), p_82499_2_.func_82616_c());
        entityarrow.field_70251_a = 1;
        return entityarrow;
    }
}
