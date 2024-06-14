package me.ogali.genovore.abilities.impl.passive;

import me.ogali.genovore.GenovorePlugin;
import me.ogali.genovore.abilities.impl.SpigotEntityPassiveAbility;
import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;

public class ParticlePassiveAbility extends SpigotEntityPassiveAbility {

    private final Particle particle;
    private final int count;
    private final double offsetX;
    private final double offsetY;
    private final double offsetZ;

    public ParticlePassiveAbility(String name, String description, double cost, Particle particle, int count, double offsetX, double offsetY, double offsetZ) {
        super(name, description, cost);
        this.particle = particle;
        this.count = count;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.offsetZ = offsetZ;
    }

    @Override
    public void applyEffect(Entity target) {
        Bukkit.getScheduler()
                .runTaskTimer(GenovorePlugin.getInstance(),
                        () -> target.getLocation()
                                .getWorld()
                                .spawnParticle(particle, target.getLocation(), count, offsetX, offsetY, offsetZ), 0, 20);
    }

    @Override
    public void removeEffect(Entity target) {

    }

    @Override
    public String getUnlockText() {
        return "&6&lParticle";
    }

}
