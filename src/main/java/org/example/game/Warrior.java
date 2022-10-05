package org.example.game;

public class Warrior implements HasHealth, HasAttack, CanReceiveDamage {
    private int health;
    private int initialHealth;
    private  int attack;
    private boolean isAlive = true;


    // Constructor created for inherited classes
    protected Warrior(int health, int attack) {
        initialHealth = this.health = health;
        this.attack = attack;
    }

    public Warrior() {
        this(50, 5);
    }

    @Override
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = Math.min(initialHealth, health);
    }

    @Override
    public int getAttack() {
        return attack;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void receiveDamage(HasAttack damager) {
        setHealth(getHealth() - damager.getAttack());
    }
}
