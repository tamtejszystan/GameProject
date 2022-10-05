package org.example.game;

public interface EquipmentTypes {
    int getAttack();
    int getHealth();
    int getDefense();
    int getVampirism();
    int getHealingPower();

    static Equipment newSword() {
        return new Equipment.EquipmentBuilder().attack(10).build();
    }
}
