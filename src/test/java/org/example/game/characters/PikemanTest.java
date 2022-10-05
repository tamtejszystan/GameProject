package org.example.game.characters;

import org.example.game.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PikemanTest {

    @Test
    @DisplayName("Test 01.")
    void isPikemanDeliveringBonusDamage() {
        var unit_1 = new Pikeman();
        var unit_2 = new Lancer();
        Battle.fight(unit_1, unit_2);

        var result = unit_1.getAttack();

        assertEquals(6, result);
    }


}
