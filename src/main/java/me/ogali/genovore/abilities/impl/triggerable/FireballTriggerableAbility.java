package me.ogali.genovore.abilities.impl.triggerable;

import me.ogali.genovore.abilities.impl.SpigotEntityTriggerableAbility;
import me.ogali.genovore.triggers.Trigger;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;

public class FireballTriggerableAbility extends SpigotEntityTriggerableAbility {

    public FireballTriggerableAbility(String name, String description, double cost, Trigger trigger, long cooldownTimeInSeconds) {
        super(name, description, cost, trigger, cooldownTimeInSeconds);
    }

    @Override
    public void applyEffect(Entity target) {
        if (!(target instanceof Player player)) return;
        Fireball fireball = target.getWorld().spawn(player.getEyeLocation(), Fireball.class);
        fireball.setDirection(player.getEyeLocation().getDirection());
    }

    @Override
    public void removeEffect(Entity target) {

    }

    @Override
    public String getUnlockText() {
        return "";
    }

}
