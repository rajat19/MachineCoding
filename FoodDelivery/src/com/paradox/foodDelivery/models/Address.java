package com.paradox.foodDelivery.models;

public class Address {
    private String id;
    private String streetAddress;
    private Location location;
    private String city;
    private String zipCode;

    public Address(String id, String streetAddress, Location location, String city, String zipCode) {
        this.id = id;
        this.streetAddress = streetAddress;
        this.location = location;
        this.city = city;
        this.zipCode = zipCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
