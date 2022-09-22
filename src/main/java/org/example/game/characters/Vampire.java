package org.example.game.characters;

public class Vampire extends Warrior {
    public int health = 40;
    private static final int ATTACK = 4;
    private static final int VAMPIRISM = 50;
    private static final int MAXHP = 40;

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    protected int getVampirism() {
        return VAMPIRISM;
    }

    protected int getMaxhp() {
        return MAXHP;
    }



}


