package com.calebfroese.crossbowrevamp;

import org.bukkit.Material;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.projectiles.ProjectileSource;

/**
 * Apply additional damage when an damageable entity is hit by the player with a
 * crossbow
 */
public class ProjectileEventHandler implements Listener {

    /**
     * Apply additional projectile velocity for projectiles fired from a crossbow
     */
    @EventHandler
    public void onProjectileLaunch(ProjectileLaunchEvent event) {
        if (!this.wasShotByCrossbow(event.getEntity().getShooter()))
            return;

        int velocityModifier = CrossbowRevampPlugin.instance.getPluginConfiguration().getVelocityModifier();
        if (velocityModifier > 0)
            event.getEntity().setVelocity(event.getEntity().getVelocity().multiply(velocityModifier));
    }

    /**
     * Apply additional damage from projectiles fired from a crossbow
     */
    @EventHandler
    public void onProjectileHitFromCrossbow(ProjectileHitEvent event) {
        if (!this.wasShotByCrossbow(event.getEntity().getShooter()))
            return;

        if (!(event.getHitEntity() instanceof Damageable))
            return;

        Damageable hitEntity = (Damageable) event.getHitEntity();

        int additionalDamage = CrossbowRevampPlugin.instance.getPluginConfiguration().getAdditionalDamage();
        if (additionalDamage > 0)
            hitEntity.damage(additionalDamage, hitEntity);
    }

    /**
     * Whether the projectile was shot by a player holding a crossbow
     * 
     * @param shooter The ProjectileSource that shot the projectile
     * @return True if shot by crossbow, otherwise false
     */
    private boolean wasShotByCrossbow(ProjectileSource shooter) {
        if (shooter == null)
            return false;

        if (!(shooter instanceof Player))
            return false;

        Player player = (Player) shooter;
        return player.getInventory().getItemInMainHand().getType().equals(Material.CROSSBOW);
    }
}
