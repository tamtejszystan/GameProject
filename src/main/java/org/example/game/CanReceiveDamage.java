package org.example.game;

interface CanReceiveDamage extends HasHealth {
   void receiveDamage(HasAttack damager);
}
