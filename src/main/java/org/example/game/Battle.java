package org.example.game;

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
            if (!attacker.isAlive()) {
                attacker.setAlive(false);
            } else if (!defender.isAlive()) {
                defender.setAlive(false);
            }
        }
        System.out.println("\n");
        return attacker.isAlive();
    }

    public static boolean battle(Army army1, Army army2) {
        var it1 = army1.firstAlive();
        var it2 = army2.firstAlive();
        while(it1.hasNext() && it2.hasNext()) {
            fight(it1.next(), it2.next());
        }
        return it1.hasNext();
    }

}


