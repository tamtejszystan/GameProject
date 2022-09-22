package org.example.game.characters;

import org.example.game.Battle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.security.KeyStore;

import static org.junit.jupiter.api.Assertions.*;

class DefenderTest {

    @Test
    @DisplayName("Test 8.")
    void DefenderVsRookieNotIncreasingHP() {
        var unit_1 = new Defender();
        var unit_2 = new Rookie();
        Battle.fight(unit_1, unit_2);

        var result = unit_1.getHealth();

        assertEquals(60, result);
    }

    @Test
    @DisplayName("Test 9.")
    void DefenderVsRookieVsWarrior() {
        var unit1 = new Defender();
        var unit2 = new Rookie();
        var unit3 = new Warrior();
        Battle.fight(unit1, unit2);
        Battle.fight(unit1, unit3);

        var result = true;

        assertTrue(result);
    }

    @Test
    @DisplayName("Test 10.")
    void WarriorVsDefender() {
        var unit1 = new Warrior();
        var unit2 = new Defender();
        Battle.fight(unit1, unit2);


        var result = true;

        assertTrue(result);
    }


}