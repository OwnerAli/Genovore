package me.ogali.genovore.abilities.impl.passive;

import me.ogali.genovore.abilities.impl.SpigotEntityPassiveAbility;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class FlyPassiveAbility extends SpigotEntityPassiveAbility {

    public FlyPassiveAbility(String name, String description, double cost) {
        super(name, description, cost);
    }

    @Override
    public void applyEffect(Entity target) {
        if (!(target instanceof Player player)) return;
        player.setAllowFlight(true);
    }

    @Override
    public void removeEffect(Entity target) {
        if (!(target instanceof Player player)) return;
        player.setAllowFlight(false);
    }

    @Override
    public String getUnlockText() {
        return "&b&lFly";
    }

}
