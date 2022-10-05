package org.example.game;

public class Pikeman extends Warrior implements KnowsDamageDealt {
    private int bonusAgainstCav = 50;
    private static final int PERCENT = 100;
    private int attack;

    public Pikeman() {
        super(50, 4, false);
    }

    public int getBonusAgainstCav() {
        return bonusAgainstCav;
    }

    public void setBonusAgainstCav(int bonusAgainstCav) {
        this.bonusAgainstCav = bonusAgainstCav;
    }

    public int getPercent() {
        return PERCENT;
    }

    @Override
    public void setAttack(int attack) {
        this.attack = attack;
    }

    @Override
    public int getAttack() {
        return attack;
    }

    @Override
    public void hit(CanReceiveDamage opponent) {
        if (opponent.isCav()) {
            int bonusDamage = (getAttack() / (getPercent() / getBonusAgainstCav()));
            opponent.setHealth(opponent.getHealth() - getAttack() - bonusDamage);
        } else {
            opponent.receiveDamage(this);
        }
    }

}

