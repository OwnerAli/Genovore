package me.ogali.genovore.abilities.impl;

public abstract class FloatValuePassiveAbility extends SpigotEntityPassiveAbility {

    protected float value;

    public FloatValuePassiveAbility(String name, String description, double cost, float value) {
        super(name, description, cost);
        this.value = value;
    }

}
