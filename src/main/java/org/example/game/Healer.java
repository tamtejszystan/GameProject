package org.example.game;

public class Healer extends Warrior implements CanProcessCommand{
    private static final int ATTACK = 0;
    private static final int HEALING_POWER = 2;

    public Healer() {
        super(60);
    }

     public int getHealingPower() {
        return HEALING_POWER;
     }

     @Override
     public int getAttack() {
        return ATTACK;
     }

     public void healAlly(Warrior ally) {
        ally.setHealth(ally.getHealth() + getHealingPower());
     }

     @Override
    public void processCommand(Command command, WarriorInArmy sender) {
        if (command instanceof HealCommand) {
            healAlly(sender.getWrapped());
        }
     }


}
