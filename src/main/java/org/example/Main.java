package org.example;

import org.example.game.Battle;
import org.example.game.characters.*;

public class Main {
    public static void main(String[] args) {
        var warrior1 = new Warrior();

        var warrior3 = new Defender();

        Battle.fight(warrior1, warrior3);


    }
}
