package org.example.game;

import java.util.*;
import java.util.function.Supplier;

public class Army implements Iterable<Warrior> {

    private class Node
    extends Warrior
    implements WarriorInArmy
    {
        Warrior warrior;
        Node next;

        public Node(Warrior warrior) {
            this.warrior = warrior;
            this.next = this;
        }

        @Override
        public Warrior getNextBehind() {
            return next == head ? null : next.warrior;
        }

        @Override
        public Warrior next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            } else {
                return next.warrior;
            }
        }

        @Override
        public boolean hasNext() {
            return next != head;
        }

        @Override
        public void hit(CanReceiveDamage opponent) {
            warrior.hit(opponent);
        }

        @Override
        public int getHealth() {
            return warrior.getHealth();
        }

        @Override
        protected void setHealth(int health) {
            warrior.setHealth(health);
        }

        @Override
        public int getAttack() {
            return warrior.getAttack();
        }

        @Override
        public void receiveDamage(HasAttack damager) {
            warrior.receiveDamage(damager);
        }
    }

        private final Node head = new Node(null);
        private Node tail = head;

    boolean isEmpty() {
        return tail == head;
    }

    private void addToTail(Warrior warrior) {
        var node = new Node(warrior);
        node.next = head;
        tail.next = node;
        tail = node;
    }

    public Army addUnits(Supplier<Warrior> factory, int quantity) {
        for (int i = 0; i < quantity; i++) {
            final Warrior warrior = factory.get();
            addToTail(warrior);
        }
        return this;
    }
    // reference to first alive element of collection

    public boolean removeDeadUnits() {
        while(iterator().hasNext()){
            if(!iterator().next().isAlive()){
                iterator().remove();
                return true;
            }

        }
        return false;
    }

    @Override
    public Iterator<Warrior> iterator() {
        return new SimpleIterator();
    }

    public Iterator<Warrior> firstAlive() {
        return new FirstAliveIterator();
    }

    private class FirstAliveIterator implements Iterator<Warrior> {

        private Warrior peek() {
            return head.next;
        }

        private void removeFromHead() {
            if (isEmpty()) {
                throw new NoSuchElementException();
            }
            if (tail == head.next) {
                tail = head;
            }
            head.next = head.next.next;
        }

        @Override
        public boolean hasNext() {
            while (!isEmpty() && !peek().isAlive()) {
                removeFromHead();
            }
            return !isEmpty();
        }

        @Override
        public Warrior next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            var res = peek();
            return res == head ? null : res;
        }
    }

   private class SimpleIterator implements Iterator<Warrior> {
        Node cursor = head;

       @Override
       public boolean hasNext() {
           return cursor.next != head;
       }

       @Override
       public Warrior next() {
           if (!hasNext()) {
               throw new NoSuchElementException();
           }
           return cursor.next;
       }
   }
}

