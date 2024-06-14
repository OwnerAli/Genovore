package me.ogali.genovore.registries;

import lombok.Getter;
import me.ogali.genovore.abilities.Ability;
import me.ogali.genovore.abilities.impl.passive.FlyPassiveAbility;
import me.ogali.genovore.abilities.impl.passive.JumpBoostPassiveAbility;
import me.ogali.genovore.abilities.impl.passive.ParticlePassiveAbility;
import me.ogali.genovore.abilities.impl.passive.WalkSpeedPassiveAbility;
import me.ogali.genovore.genes.Gene;

import java.util.HashMap;
import java.util.Map;

@Getter
public class GeneRegistry extends Registry<String, Gene> {

    private final Map<String, Class<? extends Ability<?>>> geneToAbilityMap = new HashMap<>();

    public GeneRegistry() {
        geneToAbilityMap.put("PP", ParticlePassiveAbility.class); // PP is the gene code for PassiveParticleAbility
        geneToAbilityMap.put("SP", WalkSpeedPassiveAbility.class);
        geneToAbilityMap.put("JBP", JumpBoostPassiveAbility.class);
        geneToAbilityMap.put("FP", FlyPassiveAbility.class);
    }

}
