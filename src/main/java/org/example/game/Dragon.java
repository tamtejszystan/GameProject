package org.example.game;

public class Dragon extends Warrior implements KnowsDamageDealt, CanProcessCommand{
    private static final int AOE_DAMAGE = 5;

    public Dragon() {
        super(100);
    }

    public static int getAoeDamage() {
        return AOE_DAMAGE;
    }

    private void fireMassDamage(CanReceiveDamage opponent) {
        opponent.receiveDamage(Dragon::getAoeDamage);
    }

    @Override
    public void hit(CanReceiveDamage opponent) {
        if (opponent instanceof WarriorInArmy unitInArmy) {
            while(unitInArmy.hasNext()) {
                fireMassDamage(((WarriorInArmy) opponent).next());
            }
        }
    }
}
