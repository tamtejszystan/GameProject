package org.example.game;

public class Lancer extends Warrior implements KnowsDamageDealt {
    private static final int PENETRATION = 50;
    private static final int ATTACK = 6;
    final static int PERCENT = 100;
    @Override
    public int getAttack() {
        return ATTACK;
    }

    public int getPenetration() {
        return PENETRATION;
    }
    /*
    Lancer hits first opponent, and the second one after him
    receives damage dealt to the first reduced by 50%
     */
    @Override
    public void hit(CanReceiveDamage opponent) {
        int damageDealt = hitAndReportDamage(opponent);
        if (opponent instanceof WarriorInArmy unitInArmy) {
            Warrior theSecondOpponent = (Warrior) unitInArmy.getNextBehind();
            if(theSecondOpponent != null) {
                int damageToTheSecondOpponent = damageDealt * (getPenetration() / PERCENT);
                theSecondOpponent.receiveDamage(() -> damageToTheSecondOpponent);
            }
        }
    }
}