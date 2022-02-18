package com.paradox.restaurant.models.accounts;

import java.util.Date;

public class Manager extends Employee{
    public Manager(String name, String email, String phone, int employeeId, Date dateJoined, Account account) {
        super(name, email, phone, employeeId, dateJoined, account);
    }

    public void addEmployee(Employee employee) {
        this.getRestaurant().addEmployee(employee);
        employee.setRestaurant(this.getRestaurant());
    }
}
