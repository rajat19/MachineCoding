package com.paradox.geeks.models;

import java.util.Random;

public class Dice {
    private final int lowest;
    private final int highest;
    private final Random random;

    public Dice() {
        this.lowest = 1;
        this.highest = 6;
        this.random = new Random();
    }

    public int roll() {
        return random.nextInt(highest - lowest + 1) + lowest;
    }
}
