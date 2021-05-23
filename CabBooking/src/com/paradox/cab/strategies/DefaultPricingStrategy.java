package com.paradox.cab.strategies;

import com.paradox.cab.models.Location;

public class DefaultPricingStrategy implements PricingStrategy{

    public static final double PER_KM_RATE = 10.0;

    @Override
    public double findPrice(Location from, Location to) {
        return from.distance(to) * PER_KM_RATE;
    }
}
