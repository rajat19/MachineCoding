package com.paradox.geeks.models;

import java.util.Random;

public class Dice {
    private int lowest;
    private int highest;
    private final Random random;

    public Dice() {
        this.lowest = 1;
        this.highest = 6;
        this.random = new Random();
    }

    public int getLowest() {
        return lowest;
    }

    public void setLowest(int lowest) {
        this.lowest = lowest;
    }

    public int getHighest() {
        return highest;
    }

    public void setHighest(int highest) {
        this.highest = highest;
    }

    public int roll() {
        return random.nextInt(highest - lowest + 1) + lowest;
    }
}
