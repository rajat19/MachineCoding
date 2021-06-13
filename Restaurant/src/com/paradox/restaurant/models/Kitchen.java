package com.paradox.restaurant.models;

import com.paradox.restaurant.models.accounts.Chef;

import java.util.ArrayList;
import java.util.List;

public class Kitchen {
    private final String name;
    private final List<Chef> chefs;

    public Kitchen(String name) {
        this.name = name;
        this.chefs = new ArrayList<>();
    }

    public void addChef(Chef chef) {
        this.chefs.add(chef);
    }

    public String getName() {
        return name;
    }

    public List<Chef> getChefs() {
        return chefs;
    }
}
