package org.example.game;

import org.example.game.characters.Warrior;

import java.util.Objects;

public class SimpleDamage implements Damage{
   private int value;
   Warrior damageDealer;

    public SimpleDamage(int value, Warrior damageDealer) {
        // Implement some checks for if value is positive and damageDealer is not null
        this.value = value;
        this.damageDealer = Objects.requireNonNull(damageDealer);
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public Warrior getDamageDealer() {
        return damageDealer;
    }
}
