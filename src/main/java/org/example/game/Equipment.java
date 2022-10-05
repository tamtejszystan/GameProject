package org.example.game;

import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class Equipment {
    private int attack, health, defense, healing_power, vampirism;
}
