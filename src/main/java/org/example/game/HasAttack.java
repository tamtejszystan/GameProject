package org.example.game;

@FunctionalInterface // SAM
interface HasAttack {
    int getAttack();

    default void hit(CanReceiveDamage opponent) {
        opponent.receiveDamage(this);
    }
}
