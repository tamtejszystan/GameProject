package org.example.game.characters;

public class Vampire extends Warrior {
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
    public void hit(Warrior opponent) {
        int healthBeforeHit = opponent.getHealth();
        super.hit(opponent);
        int healthAfterHit = opponent.getHealth();
        int damageDealt = healthBeforeHit - healthAfterHit;
        final int percent = 100;
        int healthRestored = (damageDealt * getVampirism() / percent);
        setHealth(getHealth() + healthRestored);
        }
    }



