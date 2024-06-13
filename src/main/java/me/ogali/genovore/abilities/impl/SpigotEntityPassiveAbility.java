package me.ogali.genovore.abilities.impl;

import me.ogali.genovore.abilities.PassiveAbility;
import org.bukkit.entity.Entity;

public abstract class SpigotEntityPassiveAbility extends PassiveAbility<Entity> {

    public SpigotEntityPassiveAbility(String name, String description, double cost) {
        super(name, description, cost);
    }

}
