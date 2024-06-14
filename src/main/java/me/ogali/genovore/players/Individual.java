package me.ogali.genovore.players;

import me.ogali.genovore.abilities.impl.SpigotEntityPassiveAbility;
import me.ogali.genovore.abilities.impl.SpigotEntityTriggerableAbility;
import me.ogali.genovore.domain.Gene;
import me.ogali.genovore.triggers.Trigger;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Individual {

    private final Player player;
    private final List<Gene> geneList;

    public Individual(Player player) {
        this.player = player;
        this.geneList = new ArrayList<>();
        Gene power = new Gene("POWER");
        power.initializeAbilitiesList(player);
        geneList.add(power);
        power.getAbilitiesList().forEach(ability -> {
            if (ability instanceof SpigotEntityPassiveAbility passiveAbility)
                passiveAbility.activate(player);
        });
    }

    public void triggerGene(Trigger trigger) {
        geneList.forEach(gene -> gene.getAbilitiesList().forEach(ability -> {
            if (!(ability instanceof SpigotEntityTriggerableAbility triggerableAbility)) return;
            if (triggerableAbility.getTrigger() != trigger) return;
            triggerableAbility.trigger(player);
        }));
    }

    public Gene getGeneById(String geneId) {
        return geneList.stream().filter(gene -> gene.getId().equals(geneId)).findFirst().orElse(null);
    }

}
