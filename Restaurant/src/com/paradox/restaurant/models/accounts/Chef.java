package com.paradox.restaurant.models.accounts;

import java.util.Date;

public class Chef extends Employee{
    public Chef(String name, String email, String phone, int employeeId, Date dateJoined) {
        super(name, email, phone, employeeId, dateJoined);
    }

    public void takeOrder() {

    }
}
