package com.paradox.foodDelivery.models;

import com.paradox.foodDelivery.models.enums.OrderStatus;

import java.util.List;

public class Order {
    private String id;
    private String userId;
    private String restaurantId;
    private List<MenuItem> menuItems;
    private OrderStatus orderStatus;

    public Order(String id, String userId, String restaurantId, List<MenuItem> menuItems) {
        this.id = id;
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.menuItems = menuItems;
        this.orderStatus = OrderStatus.PENDING;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void markCancelled() {
        this.orderStatus = OrderStatus.CANCELLED;
    }

    public void markPaymentAwaited() {
        this.orderStatus = OrderStatus.PAYMENT_AWAITED;
    }

    public void markOutForDelivery() {
        this.orderStatus = OrderStatus.OUT_FOR_DELIVERY;
    }

    public void markOrderPlaced() {
        this.orderStatus = OrderStatus.PLACED;
    }

    public void markDelivered() {
        this.orderStatus = OrderStatus.DELIVERED;
    }
}
