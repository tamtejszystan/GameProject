package org.example.game;

import org.example.game.characters.Defender;
import org.example.game.characters.Knight;
import org.example.game.characters.Rookie;
import org.example.game.characters.Warrior;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperties;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FightTest {

    @Test
    @DisplayName("Test 1.")
    void warriorLooseToAKnight() {
        var carl = new Warrior();
        var jim = new Knight();

        var result = Battle.fight(carl, jim);

        assertFalse(result);
    }

    @Test
    @DisplayName("Test 2.")
    void knightWinToAWarrior() {
        var ramon = new Knight();
        var slevin = new Warrior();

        var result = Battle.fight(ramon, slevin);

        assertTrue(result);
    }

    @Test
    @DisplayName("Test 3.")
    void sameUnitFirstHitsIsAlive() {
        var bob = new Warrior();
        var mars = new Warrior();
        Battle.fight(bob, mars);

        var result = bob.isAlive();

        assertTrue(result);
    }

    @Test
    @DisplayName("Test 4.")
    void knightIsAliveVsWarrior() {
        var zeus = new Knight();
        var godkiller = new Warrior();
        Battle.fight(zeus, godkiller);

        var result = zeus.isAlive();

        assertTrue(result);
    }

    @Test
    @DisplayName("Test 5.")
    void secondSameUnitIsNotAlive() {
        var husband = new Warrior();
        var wife = new Warrior();
        Battle.fight(husband, wife);

        var result = wife.isAlive();

        assertFalse(result);
    }

    @Test
    @DisplayName("Test 6.")
    void knightAsSecondUnitIsAliveVsWarrior() {
        var dragon = new Warrior();
        var knight = new Knight();
        Battle.fight(dragon, knight);

        var result = knight.isAlive();

        assertTrue(result);
    }

    @Test
    @DisplayName("Test 7.")
    void HpArePassedOnToNextFight() {
        var unit_1 = new Warrior();
        var unit_2 = new Knight();
        var unit_3 = new Warrior();
        Battle.fight(unit_1, unit_2);

        var result = Battle.fight(unit_2, unit_3);

        assertFalse(result);
    }


    @ParameterizedTest
    @MethodSource("checkFightResult")
    void checkFightResult(Warrior warrior1, Warrior warrior2, boolean expected) {
        var result = Battle.fight(warrior1, warrior2);
        assertEquals(expected, result);
    }

    static Stream<Arguments> checkFightResult() {
        return Stream.of(
                Arguments.of(new Warrior(), new Warrior(), true),
                Arguments.of(new Knight(), new Warrior(), true),
                Arguments.of(new Knight(), new Knight(), true),
                Arguments.of(new Warrior(), new Knight(), false)
        );
    }


}
