package org.example.game;

public class Vampire extends Warrior implements KnowsDamageDealt {
    private static final int ATTACK = 4;
    private static final int VAMPIRISM = 50;
    private static final int MAXHP = 40;

    public Vampire() {
        super(40);
    }

    public static int getMAXHP() {
        return MAXHP;
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    protected int getVampirism() {
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



