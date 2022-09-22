package org.example.game.characters;

public class Defender extends Warrior {
    private int health = 60;
    private static final int ATTACK = 3;
    private static final int DEFENSE = 2;
    private static final int MAXHP = 60;

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }


    protected int getDefense() {
        return DEFENSE;
    }

    @Override
    public void hitBy(Warrior attacker) {
        super.hitBy(attacker);
        if (attacker.getAttack() > getDefense()) {
            health -= (attacker.getAttack() - getDefense());
        } else {
            health = getHealth();
        }
    }
}
