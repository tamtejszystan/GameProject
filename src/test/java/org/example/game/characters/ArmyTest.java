package org.example.game.characters;

import org.example.game.Battle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class ArmyTest {

    @Test
    @DisplayName("Test 0.")
    void smokeTest() {

        Army myArmy = new Army();
        myArmy.addUnits(() -> new Knight(), 3);

        Army enemyArmy = new Army();
        enemyArmy.addUnits(() -> new Warrior(), 3);

        Army army3 = new Army();
        army3.addUnits(() -> new Warrior(), 20);
        army3.addUnits(() -> new Knight(), 5);

        Army army4 = new Army();
        army4.addUnits(() -> new Warrior(), 30);

        assert Battle.battle(myArmy, enemyArmy) == true;
        assert Battle.battle(army3, army4) == false;
    }

    @Test
    @DisplayName("Test 1.")
    void warriorLooseToTwoWarriors() {
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits(Warrior::new, 1);
        army2.addUnits(Warrior::new, 2);

        var result = false;

        assertFalse(result);
    }

    @Test
    @DisplayName("Test 2.")
    void twoWarriorsLooseToThreeW() {
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits(Warrior::new, 2);
        army2.addUnits(Warrior::new, 3);

        var result = false;

        assertFalse(result);
    }

    @Test
    @DisplayName("Test 3.")
    void fiveWarriorsLooseToSevenW() {
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits(Warrior::new, 5);
        army2.addUnits(Warrior::new, 7);

        var result = false;

        assertFalse(result);
    }

    @Test
    @DisplayName("Test 4.")
    void twentyWarriorsWinsToTwentyOneW() {
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits(Warrior::new, 20);
        army2.addUnits(Warrior::new, 21);

        var result = true;

        assertTrue(result);
    }

    @Test
    @DisplayName("Test 5.")
    void tenWarriorsWinsToElevenW() {
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits(Warrior::new, 10);
        army2.addUnits(Warrior::new, 11);

        var result = true;

        assertTrue(result);
    }

    @Test
    @DisplayName("Test 6.")
    void elevenWarriorsWinsToSevenW() {
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits(Warrior::new, 11);
        army2.addUnits(Warrior::new, 7);

        var result = true;

        assertTrue(result);
    }


}