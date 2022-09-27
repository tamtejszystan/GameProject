package org.example.game;

public class Lancer extends Warrior implements KnowsDamageDealt {
    private static final int PENETRATION = 50;
    private static final int ATTACK = 6;
    @Override
    public int getAttack() {
        return ATTACK;
    }

    public int getPenetration() {
        return PENETRATION;
    }
    /*
    Lancer hits first opponent, and the second one after him
    receives 50% damage.
     */

    @Override
    public void hit(CanReceiveDamage opponent) {
        int damageDealt = hitAndReportDamage(opponent);
        if (opponent instanceof WarriorInArmy unitInArmy) {
            var theSecondOpponent = unitInArmy.getNextBehind();
            if(theSecondOpponent != null) {
                final int percent = 100;
                int damageToTheSecondOpponent = damageDealt * (getPenetration() / percent);
                theSecondOpponent.receiveDamage(() -> damageToTheSecondOpponent);
            }
        }
    }
}
