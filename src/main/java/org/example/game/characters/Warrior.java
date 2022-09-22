package org.example.game.characters;

import org.example.game.Damage;
import org.example.game.SimpleDamage;

public class Warrior implements Cloneable {
    private int health;
    private final int INITIALHEALTH;
    private static final int ATTACK = 5;
    private boolean isAlive = true;

    @Override
    public Warrior clone()  {
        try {
            return (Warrior) super.clone(); // shallow copy
        } catch (CloneNotSupportedException e) {
            // nothing
        }
        throw new IllegalStateException("Never should get here.");
    }

    // Constructor created for inherited classes
    protected Warrior(int health) {
        INITIALHEALTH = this.health = health;
    }

    public Warrior() {
        this(50);
    }

    public int getHealth() {
        return health;
    }

    protected void setHealth(int health) {
        this.health = Math.min(INITIALHEALTH, health);
    }

    public int getAttack() {
        return ATTACK;
    }


    public boolean isAlive() {
        return health > 0;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void hit(Warrior opponent) {
       opponent.receiveDamage(new SimpleDamage(getAttack(), this));

    }

    protected void receiveDamage(Damage damage) {
        setHealth(getHealth() - damage.getValue());
    }
}
