package me.ogali.genovore.abilities.impl.triggerable;

import lombok.Setter;
import me.ogali.genovore.abilities.impl.SpigotEntityTriggerableAbility;
import me.ogali.genovore.triggers.Trigger;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;

@Setter
public class TeleportTriggerableAbility extends SpigotEntityTriggerableAbility {

    private double range;

    public TeleportTriggerableAbility(String name, String description, double cost,
                                      Trigger trigger, long cooldownTimeInSeconds,
                                      double range) {
        super(name, description, cost, trigger, cooldownTimeInSeconds);
        this.range = range;
    }

    @Override
    public void applyEffect(Entity target) {
        if (!(target instanceof Player player)) return;

        Location entityLocation = target.getLocation();
        Vector targetDirection = entityLocation.getDirection();
        targetDirection.multiply(range);
        Location targetLocation = entityLocation.clone().add(targetDirection);

        // Perform a ray trace to find any blocks in the path
        RayTraceResult rayTraceResult = player.rayTraceBlocks(range);

        if (rayTraceResult != null) {
            Block rayTraceHitBlock = rayTraceResult.getHitBlock();

            if (rayTraceHitBlock != null) {
                // Calculate the location just before the hit block
                Vector hitBlockVector = rayTraceHitBlock.getLocation().toVector();
                Vector playerVector = entityLocation.toVector();
                Vector direction = playerVector.subtract(hitBlockVector).normalize();

                // Move back exactly one block from the hit block
                Location safeLocation = rayTraceHitBlock.getLocation().add(direction);

                // Ensure the safe location is not inside a block
                if (safeLocation.getBlock().getType() != Material.AIR) {
                    safeLocation = safeLocation.getWorld().getHighestBlockAt(safeLocation).getLocation().add(0, 1, 0);
                }

                targetLocation = safeLocation;
            }
        } else {
            // If no block is hit, check if the target location is inside a block
            if (targetLocation.getWorld() != null && targetLocation.getBlock().getType() != Material.AIR) {
                targetLocation = targetLocation.getWorld().getHighestBlockAt(targetLocation).getLocation().add(0, 1, 0);
            }
        }

        target.teleport(targetLocation);
    }

    @Override
    public void removeEffect(Entity target) {

    }

    @Override
    public String getUnlockText() {
        return "&c&lTeleportation\n" +
                "&fRange: " + range + " blocks\n" +
                "&fCooldown: " + cooldownTimeInSeconds + " seconds";
    }

}
