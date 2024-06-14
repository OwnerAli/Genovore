package me.ogali.genovore.abilities.impl.triggerable;

import me.ogali.genovore.abilities.impl.SpigotEntityTriggerableAbility;
import me.ogali.genovore.triggers.Trigger;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.util.Vector;

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
        Location entityLocation = target.getLocation();
        Vector targetDirection = entityLocation.getDirection();

        targetDirection.multiply(range);
        Location targetLocation = entityLocation.add(targetDirection);
        Location newLocation = targetLocation.getWorld().getHighestBlockAt(targetLocation).getLocation();

        target.teleport(newLocation);
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
