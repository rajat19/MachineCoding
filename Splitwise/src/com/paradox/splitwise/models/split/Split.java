package com.paradox.splitwise.models.split;

import com.paradox.splitwise.models.User;

public abstract class Split {
    private User user;
    private double amount;

    protected Split(User user) {
        this.user = user;
    }

    public abstract double getShare();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Split{" +
                ", user=" + user +
                ", amount=" + amount +
                '}';
    }
}
