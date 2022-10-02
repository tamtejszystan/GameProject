package org.example.game.characters;

import org.example.game.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

class HealerTest {

    @ParameterizedTest
    @MethodSource
    void checkBattleResult(Army army1, Army army2, boolean expected) {
        var result = Battle.battle(army1, army2);
        assertEquals(expected, result);
    }

    static Stream<Arguments> checkBattleResult() {
        return Stream.of(
                Arguments.of(new Army()
                                .addUnits(Lancer::new, 7)
                                .addUnits(Vampire::new, 3)
                                .addUnits(Healer::new, 1)
                                .addUnits(Warrior::new, 4)
                                .addUnits(Healer::new, 1)
                                .addUnits(Defender::new, 2),
                        new Army()
                                .addUnits(Warrior::new, 4)
                                .addUnits(Defender::new, 4)
                                .addUnits(Healer::new, 1)
                                .addUnits(Vampire::new, 6)
                                .addUnits(Lancer::new, 4),
                        true
                ), Arguments.of(new Army()
                                .addUnits(Lancer::new, 1)
                                .addUnits(Warrior::new, 3)
                                .addUnits(Healer::new, 1)
                                .addUnits(Warrior::new, 4)
                                .addUnits(Healer::new, 1)
                                .addUnits(Knight::new, 2),
                        new Army()
                                .addUnits(Warrior::new, 4)
                                .addUnits(Defender::new, 4)
                                .addUnits(Healer::new, 1)
                                .addUnits(Vampire::new, 6)
                                .addUnits(Lancer::new, 4),
                        false
                ), Arguments.of(new Army().addUnits(Lancer::new, 1),
                        new Army().addUnits(Warrior::new, 1)
                                .addUnits(Healer::new, 1),
                        false
                )
        );
    }

}