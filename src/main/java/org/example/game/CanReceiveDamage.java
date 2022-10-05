package org.example.game;

interface CanReceiveDamage extends HasHealth, IsCavalry {
   void receiveDamage(HasAttack damager);
}
