package org.example.game;

import org.example.game.characters.Warrior;

public class Battle {

    public static boolean fight(Warrior attacker, Warrior defender) {

        int count = 1;
        while (attacker.isAlive() && defender.isAlive()) {
            System.out.println("Round " + count);
            System.out.println("Warrior 1 health: " + attacker.getHealth());
            System.out.println("Warrior 2 health: " + defender.getHealth());
            if (count % 2 != 0) {
                attacker.hit(defender);
            } else {
                defender.hit(attacker);
            }
            count++;
        }
        System.out.println("\n");
        return attacker.isAlive();
    }
}


