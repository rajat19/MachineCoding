package com.paradox.cab.strategies;

import com.paradox.cab.models.Location;

public interface PricingStrategy {
    double findPrice(Location from, Location to);
}
