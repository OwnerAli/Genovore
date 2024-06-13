package me.ogali.genovore.abilities.impl.passive;

import me.ogali.genovore.abilities.impl.SpigotEntityPassiveAbility;
import me.ogali.genovore.utils.Chat;
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
        return Chat.colorize("&4&l{{}} &cA mutation has occurred with the jump gene! \n" +
                "&cYou can now fly! &4&l{{}}");
    }

}
