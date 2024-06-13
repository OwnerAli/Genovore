package me.ogali.genovore.abilities;

public abstract class PassiveAbility<T> extends Ability<T> {

    protected PassiveAbility(String name, String description, double cost) {
        super(name, description, cost);
    }

    public void activate(T target) {
        applyEffect(target);
    }

}
