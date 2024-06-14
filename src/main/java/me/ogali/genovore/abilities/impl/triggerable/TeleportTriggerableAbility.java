package me.ogali.genovore.abilities.impl.triggerable;

import lombok.Setter;
import me.ogali.genovore.abilities.impl.SpigotEntityTriggerableAbility;
import me.ogali.genovore.triggers.Trigger;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.util.BlockIterator;
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

        Location targetLocation = getFurthestVisibleLocation(player, (int) range);
        if (targetLocation == null) return;

        player.teleport(targetLocation);
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

    private Location getFurthestVisibleLocation(Player player, int maxRange) {
        Location eyeLocation = player.getEyeLocation();
        Vector direction = eyeLocation.getDirection();
        BlockIterator iterator = new BlockIterator(player.getWorld(), eyeLocation.toVector(),
                direction, 0, maxRange);

        Location lastValidLocation = null;
        while (iterator.hasNext()) {
            Block block = iterator.next();
            if (!block.getType().isSolid()) {
                lastValidLocation = block.getLocation();
            } else {
                break;
            }
        }

        if (lastValidLocation != null) {
            Location highestBlockLocation = player.getWorld().getHighestBlockAt(lastValidLocation).getLocation();
            highestBlockLocation.setPitch(player.getLocation().getPitch());
            highestBlockLocation.setYaw(player.getLocation().getYaw());
            return highestBlockLocation.add(0.5, 1, 0.5); // Adjust to center player above the block
        }
        return null;
    }

}
