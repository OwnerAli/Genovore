package me.ogali.genovore.listeners;

import me.ogali.genovore.players.Individual;
import me.ogali.genovore.registries.IndividualRegistry;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    private final IndividualRegistry individualRegistry;

    public PlayerJoinListener(IndividualRegistry individualRegistry) {
        this.individualRegistry = individualRegistry;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        individualRegistry.register(event.getPlayer(),
                new Individual(event.getPlayer()));
    }

}
