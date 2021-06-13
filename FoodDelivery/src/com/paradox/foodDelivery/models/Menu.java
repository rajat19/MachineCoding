package com.paradox.foodDelivery.models;

import java.util.List;

public class Menu {
    private String id;
    private List<String> restaurantIds;
    private List<MenuItem> menuItems;

    public Menu(String id, List<String> restaurantIds, List<MenuItem> menuItems) {
        this.id = id;
        this.restaurantIds = restaurantIds;
        this.menuItems = menuItems;
    }

    public String getId() {
        return id;
    }

    public List<String> getRestaurantIds() {
        return restaurantIds;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", restaurantIds=" + restaurantIds +
                ", menuItems=" + menuItems +
                '}';
    }
}
