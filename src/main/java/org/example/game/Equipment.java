package org.example.game;

import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class Equipment {
    private int attack;
    private int health;
    private int defense;
    private int healingPower;
    private int vampirism;
}
