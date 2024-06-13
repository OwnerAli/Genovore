package me.ogali.genovore.runnables;

import lombok.Getter;
import lombok.Setter;
import me.ogali.genovore.GenovorePlugin;
import org.bukkit.scheduler.BukkitRunnable;

@Getter
@Setter
public class GeneEvolutionRunnable extends BukkitRunnable {

    private final GenovorePlugin main;
    private long timeInSeconds;

    public GeneEvolutionRunnable(GenovorePlugin main, long timeInSeconds) {
        this.main = main;
        this.timeInSeconds = timeInSeconds;
    }

    public void start() {
        this.runTaskTimerAsynchronously(main, 0, timeInSeconds * 20);
    }

    @Override
    public void run() {
    }

}
