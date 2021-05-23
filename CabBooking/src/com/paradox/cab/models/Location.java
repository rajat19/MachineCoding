package com.paradox.cab.models;

public class Location {
    private final double x;
    private final double y;

    public Location(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distance(Location location) {
        return Math.sqrt(
          Math.pow(this.getX() - location.getX(), 2) +
          Math.pow(this.getY() - location.getY(), 2)
        );
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
