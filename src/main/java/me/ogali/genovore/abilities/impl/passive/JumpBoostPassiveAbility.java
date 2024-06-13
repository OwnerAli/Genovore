package me.ogali.genovore.abilities.impl.passive;

import me.ogali.genovore.abilities.impl.FloatValuePassiveAbility;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class JumpBoostPassiveAbility extends FloatValuePassiveAbility {

    private final AttributeModifier genovoreJumpBoost = new AttributeModifier("genovore_jump_boost", super.value,
            AttributeModifier.Operation.ADD_NUMBER);
    private final AttributeModifier fallDistance = new AttributeModifier("genovore_fall_dist", super.value,
            AttributeModifier.Operation.MULTIPLY_SCALAR_1);

    public JumpBoostPassiveAbility(String name, String description, double cost, float value) {
        super(name, description, cost, value);
    }

    @Override
    public void applyEffect(Entity target) {
        if (!(target instanceof Player player)) return;
        player.getAttribute(Attribute.GENERIC_JUMP_STRENGTH)
                .addModifier(genovoreJumpBoost);
        player.getAttribute(Attribute.GENERIC_SAFE_FALL_DISTANCE)
                .addModifier(fallDistance);
    }

    @Override
    public void removeEffect(Entity target) {
        if (!(target instanceof Player player)) return;
        player.getAttribute(Attribute.GENERIC_JUMP_STRENGTH)
                .removeModifier(genovoreJumpBoost);
        player.getAttribute(Attribute.GENERIC_SAFE_FALL_DISTANCE)
                .removeModifier(fallDistance);
    }

    @Override
    public String getUnlockText() {
        return "";
    }

}
