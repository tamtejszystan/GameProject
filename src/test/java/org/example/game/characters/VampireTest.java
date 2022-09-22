package org.example.game.characters;

import org.example.game.Battle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VampireTest {

    @Test
    @DisplayName("Test 1.")
    void isVampireOverhealing() {
        var warrior1 = new Vampire();
        var warrior2 = new Rookie();
        Battle.fight(warrior1, warrior2);

        var result = warrior1.getHealth();

        assertEquals(warrior1.getMaxhp(), result);
    }

    @Test
    @DisplayName("Test 2.")
    void vampireLooseToDefender() {
        var warrior1 = new Vampire();
        var warrior2 = new Defender();
        Battle.fight(warrior1, warrior2);

        var result = false;

        assertFalse(result);
    }

    @Test
    @DisplayName("Test 3.")
    void vampireWinsToWarrior() {
        var warrior1 = new Warrior();
        var warrior2 = new Vampire();
        Battle.fight(warrior1, warrior2);

        var result = true;

        assertTrue(result);
    }

    @Test
    @DisplayName("imageTest")
    void defenderWinsToVampire() {
        var warrior1 = new Defender();
        var warrior2 = new Vampire();
        Battle.fight(warrior1, warrior2);

        var result = warrior2.getHealth();

        assertEquals(-1, result);
    }

}