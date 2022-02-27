package com.paradox.truecaller.models;

import com.paradox.truecaller.models.enums.Tag;
import com.paradox.truecaller.models.enums.UserCategory;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class Account {
    private String id;
    private String phone;
    private String userName;
    private String password;
    private LocalDateTime lastAccessed;
    private Tag tag;
    private Contact contact;
    private Business business;
    private UserCategory userCategory;
    private Map<String, User> contacts;
    private CountingBloomFilter<String> blockedContacts;
    private Set<String> blockedSet;
    private ContactTrie contactTrie;

    public abstract void register(UserCategory userCategory, String userName, String password,
                                  String email, String phoneNumber, String countryCode,
                                  String firstName);
    public abstract void addContact(User user);
    public abstract void removeContact(String number);
    public abstract void blockNumber(String number);
    public abstract void unblockNumber(String number);
    public abstract void reportSpam(String number, String reason);
    public abstract boolean isBlocked(String number);
    public abstract boolean canReceive(String number);
    public abstract boolean importContacts(List<User> users);

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getLastAccessed() {
        return lastAccessed;
    }

    public void setLastAccessed(LocalDateTime lastAccessed) {
        this.lastAccessed = lastAccessed;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public UserCategory getUserCategory() {
        return userCategory;
    }

    public void setUserCategory(UserCategory userCategory) {
        this.userCategory = userCategory;
    }

    public Map<String, User> getContacts() {
        return contacts;
    }

    public void setContacts(Map<String, User> contacts) {
        this.contacts = contacts;
    }

    public CountingBloomFilter<String> getBlockedContacts() {
        return blockedContacts;
    }

    public void setBlockedContacts(CountingBloomFilter<String> blockedContacts) {
        this.blockedContacts = blockedContacts;
    }

    public Set<String> getBlockedSet() {
        return blockedSet;
    }

    public void setBlockedSet(Set<String> blockedSet) {
        this.blockedSet = blockedSet;
    }

    public ContactTrie getContactTrie() {
        return contactTrie;
    }

    public void setContactTrie(ContactTrie contactTrie) {
        this.contactTrie = contactTrie;
    }
}
