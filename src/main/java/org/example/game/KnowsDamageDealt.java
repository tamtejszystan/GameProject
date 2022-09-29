package org.example.game;

public interface KnowsDamageDealt extends HasAttack  {

    default int hitAndReportDamage(CanReceiveDamage opponent) {
        int healthBeforeHit = opponent.getHealth();
        HasAttack.super.hit(opponent);
        int healthAfterHit = opponent.getHealth();
        return healthBeforeHit - healthAfterHit;
    }
}
