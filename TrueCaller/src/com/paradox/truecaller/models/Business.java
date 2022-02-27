package com.paradox.truecaller.models;

import com.paradox.truecaller.models.enums.BusinessSize;
import com.paradox.truecaller.models.enums.Tag;

import java.util.Map;

public class Business {
    private String name;
    private String description;
    private Tag tag;
    private BusinessSize businessSize;
    private Contact contact;

    public Business(String name, Tag tag) {
        this.name = name;
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public BusinessSize getBusinessSize() {
        return businessSize;
    }

    public void setBusinessSize(BusinessSize businessSize) {
        this.businessSize = businessSize;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
