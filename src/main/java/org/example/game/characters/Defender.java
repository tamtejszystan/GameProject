package org.example.game.characters;

import org.example.game.Damage;
import org.example.game.SimpleDamage;

public class Defender extends Warrior {

    private static final int ATTACK = 3;
    private static final int DEFENSE = 2;

    public Defender() {
        super(60);
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    protected int getDefense() {
        return DEFENSE;
    }


    @Override
    protected void receiveDamage(Damage damage) {
        int reducedDamage = Math.max(0, damage.getValue() - getDefense());
        super.receiveDamage(new SimpleDamage(reducedDamage, damage.getDamageDealer()));
    }
}
