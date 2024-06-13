package me.ogali.genovore.abilities.impl;

import me.ogali.genovore.abilities.TriggerableAbility;
import me.ogali.genovore.triggers.Trigger;
import org.bukkit.entity.Entity;

public abstract class SpigotEntityTriggerableAbility extends TriggerableAbility<Entity> {

    public SpigotEntityTriggerableAbility(String name, String description, double cost, Trigger trigger, long cooldownTimeInSeconds) {
        super(name, description, cost, trigger, cooldownTimeInSeconds);
    }

}
