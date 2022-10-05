package org.example.game;

public interface HasHealth {
    int getHealth();

    void setHealth(int health);

    default boolean isAlive() {
        return getHealth() > 0;
    }
}
