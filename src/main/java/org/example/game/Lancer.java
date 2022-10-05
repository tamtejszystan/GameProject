package org.example.game;

public class Lancer extends Warrior implements KnowsDamageDealt {
    private  final int PENETRATION = 50;
    private  final int PERCENT = 100;

    public Lancer() {
        super(50, 6);
    }
/*
100 % - 6 atk
50 % - x

x = (50 * 6) / 100      y = 6 * (50 / 100)
x = 300 / 100 = 3       y = 6 * 0.5 = 3


 */
    public int getPenetration() {
        return PENETRATION;
    }

    public int getPercent() {
        return PERCENT;
    }


    /*
    Lancer hits first opponent, and the second one after him
    receives damage dealt to the first reduced by 50%
     */
    @Override
    public void hit(CanReceiveDamage opponent) {
        int damageDealt = hitAndReportDamage(opponent);
        if (opponent instanceof WarriorInArmy unitInArmy) {
            final Warrior theSecondOpponent = unitInArmy.getNextBehind();
            if(theSecondOpponent != null) {
                int damageToTheSecondOpponent = (damageDealt * getPenetration()) / getPercent();
                theSecondOpponent.receiveDamage(() -> damageToTheSecondOpponent);

            }
        }
    }


}
