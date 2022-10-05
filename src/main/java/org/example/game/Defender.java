package org.example.game;

public class Defender extends Warrior {

    private   int defense = 2;

    public Defender() {
        super(60, 3, false);
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }


    @Override
    public void receiveDamage(HasAttack damager) {
        int reducedDamage = Math.max(0, damager.getAttack() - getDefense());
        super.receiveDamage(() -> reducedDamage);
    }

    @Override
    public void useEquipment(Equipment eqType) {
        super.useEquipment(eqType);
       setDefense(getDefense() + eqType.getDefense());
    }
}
