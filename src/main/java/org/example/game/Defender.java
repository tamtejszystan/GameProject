package org.example.game;

public class Defender extends Warrior {

    private static final int DEFENSE = 2;

    public Defender() {
        super(60, 2);
    }

    protected int getDefense() {
        return DEFENSE;
    }


    @Override
    public void receiveDamage(HasAttack damager) {
        int reducedDamage = Math.max(0, damager.getAttack() - getDefense());
        super.receiveDamage(() -> reducedDamage);
    }
}
