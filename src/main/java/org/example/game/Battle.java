package org.example.game;
import org.example.game.characters.Army;
import org.example.game.characters.Warrior;

public class Battle {

    public static boolean fight(Warrior warrior1, Warrior warrior2) {
        int count = 1;
        while (warrior1.isAlive() && warrior2.isAlive()) {
            System.out.println("Round " + count);
            System.out.println("Warrior 1 health: " + warrior1.getHealth());
            System.out.println("Warrior 2 health: " + warrior2.getHealth());
            if (count % 2 != 0) {
                warrior1.hits(warrior2);
            } else {
                warrior2.hits(warrior1);
            }

            if (warrior1.getHealth() < 0) {
                warrior1.setAlive(false);
            } else if (warrior2.getHealth() < 0) {
                warrior2.setAlive(false);
            }
            count++;
        }
        System.out.println("\n");
        return warrior1.isAlive();
    }



}


