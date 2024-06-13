package me.ogali.genovore.abilities;

import lombok.Getter;

@Getter
public abstract class Ability<T> {

    private final String name;
    private final String description;
    private final double cost;

    public Ability(String name, String description, double cost) {
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    public abstract void applyEffect(T target);

    public abstract void removeEffect(T target);

    public abstract String getUnlockText();

}