package org.example.game.characters;

import org.example.game.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.example.game.EquipmentTypes.*;

 class WeaponsTest {
    @Test
    @DisplayName("Equipment test")
     void equipmentTest() {
        var ogre = new Warrior();
        var lancelot = new Knight();
        var richard = new Defender();
        var eric = new Vampire();
        var freelancer = new Lancer();
        var priest = new Healer();

        // you may consider using another interfaces for the predefined weapon
// e.g. you could use enum or some factory
        var sword =  sword();
        var shield =  shield();
        var axe =  greatAxe();
        var katana =  katana();
        var wand =  magicWand();
        // consider using a builder instead
        var superWeapon = superWeapon();

        ogre.useEquipment(sword);
        ogre.useEquipment(shield);
        ogre.useEquipment(superWeapon);
        lancelot.useEquipment(superWeapon);
        richard.useEquipment(shield);
        eric.useEquipment(superWeapon);
        freelancer.useEquipment(axe);
        freelancer.useEquipment(katana);
        priest.useEquipment(wand);
        priest.useEquipment(shield);

        assert ogre.getHealth() == 125;
        assert lancelot.getAttack() == 17;
        assert richard.getDefense() == 4;
        assert eric.getVampirism() == 200;
        assert freelancer.getHealth() == 15;
        assert priest.getHealingPower() == 5;

        assert !Battle.fight(ogre, eric);
        assert !Battle.fight(priest, richard);
        assert Battle.fight(lancelot, freelancer);

        var army1 = new Army();
       army1.addUnits(Knight::new, 1);
       army1.addUnits(Lancer::new, 1);

        var army2 = new Army();
       army2.addUnits(Vampire::new, 1);
       army2.addUnits(Healer::new, 1);

       army1.equipWarriorAtPosition(0, axe);
       army1.equipWarriorAtPosition(1, superWeapon);

       army2.equipWarriorAtPosition(0, katana);
       army2.equipWarriorAtPosition(1, wand);

        assert Battle.battle(army1, army2);
    }
}
