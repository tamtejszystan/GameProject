package org.example.game.characters;

import org.example.game.Damage;
import org.example.game.SimpleDamage;

@FunctionalInterface // SAM
interface HasAttack {
    int getAttack();
}

interface HasHealth {
    int getHealth();

    default boolean isAlive() {
        return getHealth() > 0;
    }
}

interface CanReceiveDamage extends HasHealth {
   void receiveDamage(HasAttack damager);
}

public class Warrior implements HasHealth, HasAttack, CanReceiveDamage {
    private int health;
    private final int initialHealth;
    private static final int ATTACK = 5;
    private boolean isAlive = true;


    // Constructor created for inherited classes
    protected Warrior(int health) {
        initialHealth = this.health = health;
    }

    public Warrior() {
        this(50);
    }

    @Override
    public int getHealth() {
        return health;
    }

    protected void setHealth(int health) {
        this.health = Math.min(initialHealth, health);
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void hit(CanReceiveDamage opponent) {
        opponent.receiveDamage(this);
        //  opponent.receiveDamage(new SimpleDamage(getAttack(), this));

    }

 //   protected void receiveDamage(Damage damage) {
 //       setHealth(getHealth() - damage.getValue());
 //   }

    public void receiveDamage(HasAttack damager) {
        setHealth(getHealth() - damager.getAttack());
    }
}
