package com.paradox.foodDelivery.strategies;

import com.paradox.foodDelivery.models.Bill;
import com.paradox.foodDelivery.models.MenuItem;

import java.util.List;

public interface PricingStrategy {
    Bill generateBill(List<MenuItem> menuItems);
}
