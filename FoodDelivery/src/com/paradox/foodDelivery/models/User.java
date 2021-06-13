package com.paradox.foodDelivery.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String id;
    private String name;
    private long phoneNo;
    private final List<Address> addresses;

    public User(String id, String name, long phoneNo) {
        this.id = id;
        this.name = name;
        this.phoneNo = phoneNo;
        this.addresses = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void addAddress(Address address) {
        this.addresses.add(address);
    }

    public void removeAddress(Address address) {
        this.addresses.remove(address);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phoneNo=" + phoneNo +
                ", addresses=" + addresses +
                '}';
    }
}
