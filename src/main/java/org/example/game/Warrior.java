package org.example.game;

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

    public void receiveDamage(HasAttack damager) {
        setHealth(getHealth() - damager.getAttack());
    }


    public void processCommand(Command command, WarriorInArmy warriorInArmy) {
    }
}
