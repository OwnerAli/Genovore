package me.ogali.genovore.abilities.impl.triggerable;

import me.ogali.genovore.abilities.impl.SpigotEntityTriggerableAbility;
import me.ogali.genovore.triggers.Trigger;
import org.bukkit.entity.Entity;

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
        target.teleport(target.getLocation().getDirection()
                .add(target.getLocation().toVector().multiply(range))
                .toLocation(target.getWorld()));
    }

    @Override
    public void removeEffect(Entity target) {

    }

    @Override
    public String getUnlockText() {
        return "";
    }

}
