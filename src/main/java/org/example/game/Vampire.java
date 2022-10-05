package org.example.game;

public class Vampire extends Warrior implements KnowsDamageDealt {

    private int vampirism = 50;

    public Vampire() {
        super(40, 4);
    }

    public int getVampirism() {
        return vampirism;
    }

    public void setVampirism(int vampirism) {
        this.vampirism = vampirism;
    }

    @Override
    public void hit(CanReceiveDamage opponent) {
        int damageDealt = hitAndReportDamage(opponent);
        final int percent = 100;
        int healthRestored = (damageDealt * getVampirism() / percent);
        setHealth(getHealth() + healthRestored);
    }

    @Override
    public void useEquipment(Equipment eqType) {
        super.useEquipment(eqType);
        setVampirism(getVampirism() + eqType.getVampirism());
    }
}



