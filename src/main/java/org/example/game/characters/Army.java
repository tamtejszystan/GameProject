package org.example.game.characters;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Queue;
import java.util.function.Supplier;

public class Army {

    Queue<Warrior> troops = new ArrayDeque<Warrior>();



    public Army addUnits(Supplier<Warrior> factory, int quantity) {
        for(int i = 0; i < quantity; i++) {
            troops.add(factory.get());
        }
        return this;
    }
}


