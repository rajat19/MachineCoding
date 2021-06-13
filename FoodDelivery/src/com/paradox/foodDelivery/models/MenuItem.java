package com.paradox.foodDelivery.models;

import com.paradox.foodDelivery.models.enums.CuisineType;
import com.paradox.foodDelivery.models.enums.MealType;

public class MenuItem {
    private String id;
    private String itemName;
    private CuisineType cuisineType;
    private MealType mealType;
    private double price;

    public MenuItem(String id, String itemName, CuisineType cuisineType, MealType mealType, double price) {
        this.id = id;
        this.itemName = itemName;
        this.cuisineType = cuisineType;
        this.mealType = mealType;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public CuisineType getCuisineType() {
        return cuisineType;
    }

    public MealType getMealType() {
        return mealType;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "id='" + id + '\'' +
                ", itemName='" + itemName + '\'' +
                ", cuisineType=" + cuisineType +
                ", mealType=" + mealType +
                ", price=" + price +
                '}';
    }
}
