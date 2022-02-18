package com.paradox.restaurant.models.accounts;

import com.paradox.restaurant.models.Restaurant;

import java.util.Date;

public class Employee extends Person{
    private final int employeeId;
    private final Date dateJoined;
    private Account account;
    private Restaurant restaurant;

    public Employee(String name, String email, String phone, int employeeId, Date dateJoined, Account account) {
        super(name, email, phone);
        this.employeeId = employeeId;
        this.dateJoined = dateJoined;
        this.account = account;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public Date getDateJoined() {
        return dateJoined;
    }

    public Account getAccount() {
        return account;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }
}
