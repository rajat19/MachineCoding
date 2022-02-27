package com.paradox.truecaller.models;

public class Contact {
    private String countryCode;
    private String phone;
    private String emailId;

    public Contact(String phone) {
        this.phone = phone;
    }

    public Contact(String phone, String emailId) {
        this.phone = phone;
        this.emailId = emailId;
    }

    public Contact(String countryCode, String phone, String emailId) {
        this.countryCode = countryCode;
        this.phone = phone;
        this.emailId = emailId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
