package org.example.game.characters;

import org.example.game.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class ArmyTest {
    @ParameterizedTest
    @MethodSource()
    void checkBattleResult(Army army1, Army army2, boolean expected) {
        var result = Battle.battle(army1, army2);
        assertEquals(expected, result);
    }

    static Stream<Arguments> checkBattleResult() {
        return Stream.of(
                Arguments.of(new Army().addUnits(Warrior::new, 1), new Army().addUnits(Warrior::new,2), false),
                Arguments.of(new Army().addUnits(Warrior::new, 2), new Army().addUnits(Warrior::new,3), false),
                Arguments.of(new Army().addUnits(Warrior::new, 5), new Army().addUnits(Warrior::new,7), false),
                Arguments.of(new Army().addUnits(Warrior::new, 20), new Army().addUnits(Warrior::new, 21), true),
                Arguments.of(new Army().addUnits(Warrior::new, 10), new Army().addUnits(Warrior::new, 11), true),
                Arguments.of(new Army().addUnits(Warrior::new, 11), new Army().addUnits(Warrior::new, 7), true),
                Arguments.of(new Army().addUnits(Warrior::new, 5).addUnits(Defender::new, 4).addUnits(Defender::new, 5),
                        new Army().addUnits(Warrior::new, 4), true),
                Arguments.of(new Army().addUnits(Defender::new, 5).addUnits(Warrior::new, 20).addUnits(Defender::new, 21),
                        new Army().addUnits(Warrior::new, 4), true),
                Arguments.of(new Army().addUnits(Warrior::new, 10).addUnits(Defender::new, 5).addUnits(Defender::new, 10),
                        new Army().addUnits(Warrior::new, 5), true),
                Arguments.of(new Army().addUnits(Defender::new, 2).addUnits(Warrior::new, 1).addUnits(Defender::new, 1),
                        new Army().addUnits(Warrior::new, 5), false),
                Arguments.of(new Army().addUnits(Defender::new, 5).addUnits(Vampire::new, 6).addUnits(Warrior::new, 7),
                        new Army().addUnits(Warrior::new, 6).addUnits(Defender::new, 6).addUnits(Vampire::new, 6), false),
                Arguments.of(new Army().addUnits(Defender::new, 1).addUnits(Vampire::new, 3).addUnits(Warrior::new, 4),
                        new Army().addUnits(Warrior::new, 4).addUnits(Defender::new, 4).addUnits(Vampire::new, 3), false),
            //   Arguments.of(new Army().addUnits(Defender::new, 11).addUnits(Vampire::new, 3).addUnits(Warrior::new, 4),
            //           new Army().addUnits(Warrior::new, 4).addUnits(Defender::new, 4).addUnits(Vampire::new, 13), true),
                Arguments.of(new Army().addUnits(Defender::new, 9).addUnits(Vampire::new, 3).addUnits(Warrior::new, 8),
                        new Army().addUnits(Warrior::new, 4).addUnits(Defender::new, 4).addUnits(Vampire::new, 13), true),
               Arguments.of(new Army().addUnits(Lancer::new, 5).addUnits(Vampire::new, 3).addUnits(Warrior::new, 4).addUnits(Defender::new, 2),
                        new Army().addUnits(Warrior::new, 4).addUnits(Defender::new, 4).addUnits(Vampire::new, 6).addUnits(Lancer::new, 5), false),
                Arguments.of(new Army().addUnits(Lancer::new, 7).addUnits(Vampire::new, 3).addUnits(Warrior::new, 4).addUnits(Defender::new, 2),
                        new Army().addUnits(Warrior::new, 4).addUnits(Defender::new, 4).addUnits(Vampire::new, 6).addUnits(Lancer::new, 4), true),
                Arguments.of(new Army().addUnits(Warrior::new, 2),
                        new Army().addUnits(Lancer::new, 1).addUnits(Warrior::new, 1), false),
                Arguments.of(new Army().addUnits(Lancer::new, 1),
                        new Army().addUnits(Warrior::new, 1).addUnits(Knight::new, 1), false),
                Arguments.of(new Army().addUnits(Lancer::new, 1), new Army().addUnits(Rookie::new, 3), true)
                );
    }
}