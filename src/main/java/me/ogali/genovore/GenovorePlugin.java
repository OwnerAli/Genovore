package me.ogali.genovore;

import lombok.Getter;
import me.ogali.genovore.listeners.AbilityTriggerListener;
import me.ogali.genovore.listeners.PlayerJoinListener;
import me.ogali.genovore.registries.GeneRegistry;
import me.ogali.genovore.registries.IndividualRegistry;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

@Getter
public final class GenovorePlugin extends JavaPlugin {

    @Getter
    private static GenovorePlugin instance;

    private Random random;
    private GeneRegistry geneRegistry;
    private IndividualRegistry individualRegistry;

    @Override
    public void onEnable() {
        initializePlugin();
    }

    @Override
    public void onDisable() {
    }

    public void initializePlugin() {
        instance = this;
        initializeRegistries();
        registerListeners();
        registerCommands();
        registerRunnables();
        random = new Random();
    }

    public void registerListeners() {
        PluginManager pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new PlayerJoinListener(individualRegistry), this);
        pluginManager.registerEvents(new AbilityTriggerListener(), this);
    }

    public void registerCommands() {

    }

    public void registerRunnables() {

    }

    public void initializeRegistries() {
        geneRegistry = new GeneRegistry();
        individualRegistry = new IndividualRegistry();
    }

}
