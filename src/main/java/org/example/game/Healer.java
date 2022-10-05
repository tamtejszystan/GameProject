package org.example.game;

public class Healer extends Warrior {

    private int healingPower = 2;

    public Healer() {
        super(60, 0, false);
    }

    public int getHealingPower() {
        return healingPower;
    }

    public void setHealingPower(int healingPower) {
        this.healingPower = healingPower;
    }

    public void healAlly(Warrior ally) {
        ally.setHealth(ally.getHealth() + getHealingPower());
    }

    @Override
    public void useEquipment(Equipment eqType) {
        super.useEquipment(eqType);
        setHealingPower(getHealingPower() + eqType.getHealingPower());
    }


}
