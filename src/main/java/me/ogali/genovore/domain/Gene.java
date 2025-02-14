package me.ogali.genovore.domain;

import lombok.Getter;
import me.ogali.genovore.GenovorePlugin;
import me.ogali.genovore.abilities.Ability;
import me.ogali.genovore.abilities.impl.SpigotEntityPassiveAbility;
import me.ogali.genovore.abilities.impl.passive.FlyPassiveAbility;
import me.ogali.genovore.abilities.impl.passive.JumpBoostPassiveAbility;
import me.ogali.genovore.abilities.impl.passive.ParticlePassiveAbility;
import me.ogali.genovore.abilities.impl.passive.WalkSpeedPassiveAbility;
import me.ogali.genovore.abilities.impl.triggerable.FireballTriggerableAbility;
import me.ogali.genovore.triggers.Trigger;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class Gene {

    private final List<Ability<Entity>> abilitiesList;
    private final String id;

    public Gene(String id) {
        this.abilitiesList = new ArrayList<>();
        this.id = id;
        initializeAbilitiesList();
    }

    public void addAbility(SpigotEntityPassiveAbility ability) {
        abilitiesList.add(ability);
    }

    private void initializeAbilitiesList() {
        GenovorePlugin instance = GenovorePlugin.getInstance();
        Random random = instance.getRandom();

        // Define the pool of abilities
        List<Ability<Entity>> abilityPool = new ArrayList<>();
        abilityPool.add(new WalkSpeedPassiveAbility("Speed", "Speed", 1, random.nextFloat()));
        abilityPool.add(new JumpBoostPassiveAbility("JumpBoost", "JumpBoost", 1, random.nextFloat()));
        abilityPool.add(new ParticlePassiveAbility("PassiveParticle", "PassiveParticle", 1,
                Particle.DRAGON_BREATH, 100, random.nextInt(5), random.nextInt(5), random.nextInt(5)));
        abilityPool.add(new FlyPassiveAbility("Fly", "Fly", 1));

        // Add triggerable abilities
//        abilityPool.add(new DashAbility("Dash", "Dash", 1, random.nextFloat()));
//        abilityPool.add(new DoubleJumpAbility("DoubleJump", "DoubleJump", 1));
        abilityPool.add(new FireballTriggerableAbility("Fireball", "Fireball", 5, Trigger.ON_DOUBLE_CROUCH,
                random.nextInt(10)));
//        abilityPool.add(new ShieldAbility("Shield", "Shield", 1));
//        abilityPool.add(new TeleportAbility("Teleport", "Teleport", 1));
//        abilityPool.add(new InvisibilityAbility("Invisibility", "Invisibility", 1));

        // Randomly select a few abilities to add to this gene
        int numAbilities = 2 + random.nextInt(3); // Random number between 2 and 4
        for (int i = 0; i < numAbilities; i++) {
            Ability<Entity> ability = abilityPool.get(random.nextInt(abilityPool.size()));
            if (!abilitiesList.contains(ability)) {
                abilitiesList.add(ability);
            }
        }
    }

}