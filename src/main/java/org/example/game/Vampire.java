package org.example.game;

public class Vampire extends Warrior implements KnowsDamageDealt {

    private static final int VAMPIRISM = 50;

    public Vampire() {
        super(40, 4);
    }

    public int getVampirism() {
        return VAMPIRISM;
    }

    @Override
    public void hit(CanReceiveDamage opponent) {
        int damageDealt = hitAndReportDamage(opponent);
        final int percent = 100;
        int healthRestored = (damageDealt * getVampirism() / percent);
        setHealth(getHealth() + healthRestored);
        }

    }



