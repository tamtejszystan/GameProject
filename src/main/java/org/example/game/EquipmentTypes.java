package org.example.game;

public interface EquipmentTypes {
    int getAttack();
    int getHealth();
    int getDefense();
    int getVampirism();
    int getHealingPower();

    static Equipment sword() {
        return new Equipment.EquipmentBuilder().attack(2).health(5).build();
    }

    static Equipment shield() {
        return new Equipment.EquipmentBuilder().health(20).attack(-1).defense(2).build();
    }

    static Equipment greatAxe() {
        return new Equipment.EquipmentBuilder().health(-15).attack(5).defense(-2).vampirism(10).build();
    }

    static Equipment katana() {
        return new Equipment.EquipmentBuilder().health(-20).attack(6).defense(-5).vampirism(50).build();
    }

    static Equipment magicWand() {
        return new Equipment.EquipmentBuilder().health(+30).attack(3).healingPower(3).build();
    }

    static Equipment superWeapon() {
        return new Equipment.EquipmentBuilder().health(50).attack(10).defense(5).vampirism(150).healingPower(8).build();
    }
}
