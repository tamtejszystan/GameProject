package org.example.game;

public class Healer extends Warrior {

    private static final int HEALING_POWER = 2;

    public Healer() {
        super(60, 0);
    }

    public int getHealingPower() {
        return HEALING_POWER;
    }

    public void healAlly(Warrior ally) {
        ally.setHealth(ally.getHealth() + getHealingPower());
    }


}
