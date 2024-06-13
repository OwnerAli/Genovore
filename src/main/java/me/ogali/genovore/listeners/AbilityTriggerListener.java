package me.ogali.genovore.listeners;

import me.ogali.genovore.GenovorePlugin;
import me.ogali.genovore.triggers.Trigger;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AbilityTriggerListener implements Listener {

    private final Map<UUID, Long> lastCrouchTime = new HashMap<>();
    private final Map<UUID, Integer> crouchCount = new HashMap<>();

    @EventHandler
    public void onDoubleShift(PlayerToggleSneakEvent event) {
        Player player = event.getPlayer();
        UUID playerId = player.getUniqueId();

        if (player.isSneaking()) {
            long currentTime = System.currentTimeMillis();
            long lastTime = lastCrouchTime.getOrDefault(playerId, 0L);
            int count = crouchCount.getOrDefault(playerId, 0);

            if (currentTime - lastTime < 1000) {
                count++;
                if (count == 2) {
                    GenovorePlugin.getInstance()
                            .getIndividualRegistry()
                            .get(player)
                            .ifPresent(individual -> individual.triggerGene("POWER", Trigger.ON_DOUBLE_CROUCH));
                    // Reset the count
                    count = 0;
                }
            } else {
                count = 1;
            }

            lastCrouchTime.put(playerId, currentTime);
            crouchCount.put(playerId, count);
        }
    }

}