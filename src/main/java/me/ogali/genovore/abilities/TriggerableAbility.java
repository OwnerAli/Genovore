package me.ogali.genovore.abilities;

import lombok.Getter;
import me.ogali.genovore.cooldowns.Cooldown;
import me.ogali.genovore.triggers.Trigger;
import me.ogali.genovore.utils.Chat;
import org.bukkit.command.CommandSender;

public abstract class TriggerableAbility<T> extends Ability<T> {

    @Getter
    private final Cooldown cooldown;
    @Getter
    private final Trigger trigger;
    protected final long cooldownTimeInSeconds;

    protected TriggerableAbility(String name, String description, double cost, Trigger trigger, long cooldownTimeInSeconds) {
        super(name, description, cost);
        this.trigger = trigger;
        this.cooldownTimeInSeconds = cooldownTimeInSeconds;
        cooldown = new Cooldown(cooldownTimeInSeconds);
    }

    public void trigger(T target) {

        // trigger ability if cooldown is inactive
        if (!checkAndStartCooldown()) {
            if (!(target instanceof CommandSender commandSender)) return;
            Chat.tellFormatted(commandSender, "&cAbility is on cooldown for %s more seconds!",
                    cooldown.getRemainingTime());
            return;
        }
        applyEffect(target);
    }

    private boolean checkAndStartCooldown() {
        if (cooldown.isActive()) return false;
        cooldown.start();
        return true;
    }

}
