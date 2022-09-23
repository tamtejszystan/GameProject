package org.example.game.characters;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Army {

    Queue<Warrior> troops = new ArrayDeque<Warrior>();


    public Army addUnits(Supplier<Warrior> factory, int quantity) {
        for (int i = 0; i < quantity; i++) {
            troops.add(factory.get());
        }
        return this;
    }
    // reference to first alive element of collection

    public Iterator<Warrior> firstAlive() {
        return new FirstAliveIterator();
    }

    private class FirstAliveIterator implements Iterator<Warrior> {
        @Override
        public boolean hasNext() {
            while (!troops.isEmpty() && !troops.peek().isAlive()) {
                troops.remove();
            }
            return !troops.isEmpty();
        }
        @Override
        public Warrior next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return troops.peek();
        }
    }
}


