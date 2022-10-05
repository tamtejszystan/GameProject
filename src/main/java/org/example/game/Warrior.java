package org.example.game;

public class Warrior implements HasHealth, HasAttack, CanReceiveDamage, CanUseEquipment {
    private int health;
    private int initialHealth;
    private int attack;
    private boolean isAlive = true;
    private final boolean isCav;

    // Constructor created for inherited classes
    protected Warrior(int health, int attack, boolean isCav) {
        initialHealth = this.health = health;
        this.attack = attack;
        this.isCav = isCav;
    }

    public Warrior() {
        this(50, 5, false);
    }

    @Override
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = Math.min(initialHealth, health);
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    @Override
    public boolean isCav() {
        return isCav;
    }

    public void receiveDamage(HasAttack damager) {
        setHealth(getHealth() - damager.getAttack());
    }

    @Override
    public void useEquipment(Equipment eqType) {
        initialHealth = initialHealth + eqType.getHealth();
        setHealth(initialHealth);
        setAttack(getAttack() + eqType.getAttack());
    }
}
