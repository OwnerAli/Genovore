package me.ogali.genovore.abilities.impl.passive;

import me.ogali.genovore.abilities.impl.FloatValuePassiveAbility;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class WalkSpeedPassiveAbility extends FloatValuePassiveAbility {

    public WalkSpeedPassiveAbility(String name, String description, double cost, float value) {
        super(name, description, cost, value);
    }

    @Override
    public void applyEffect(Entity target) {
        if (!(target instanceof Player player)) return;
        player.setWalkSpeed(super.value);
    }

    @Override
    public void removeEffect(Entity target) {
        if (!(target instanceof Player player)) return;
        player.setWalkSpeed(0.2f);
    }

    @Override
    public String getUnlockText() {
        return "&f&lWalk Speed";
    }

}
