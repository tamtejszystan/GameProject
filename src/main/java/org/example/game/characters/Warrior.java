package org.example.game.characters;

public class Warrior implements Cloneable {
    private int health = 50;
    private static final int ATTACK = 5;
    private boolean isAlive = true;
    private static final int MAXHP = 50;

    @Override
    public Warrior clone()  {
        try {
            return (Warrior) super.clone(); // shallow copy
        } catch (CloneNotSupportedException e) {
            // nothing
        }
        throw new IllegalStateException("Never should get here.");
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
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

    public void hits(Warrior defender) {
       defender.hitBy(this);

    }

    public void hitBy(Warrior attacker) {
        health -= attacker.getAttack();
    }
}
