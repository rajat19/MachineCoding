package com.paradox.truecaller.models;

import com.paradox.truecaller.models.enums.UserCategory;

import java.util.List;
import java.util.UUID;

public class User extends Account{
    @Override
    public void register(UserCategory userCategory, String userName,
                         String password, String email,
                         String phoneNumber, String countryCode, String firstName) {
        setId(UUID.randomUUID().toString());
        setUserCategory(userCategory);
        setUserName(userName);
        setPassword(password);
        setContact(new Contact(phoneNumber, email, countryCode));
        init(userCategory);
        insertToTries(phoneNumber, firstName);
    }

    private void insertToTries(String phoneNumber, String firstName) {
    }

    @Override
    public void addContact(User user) {

    }

    @Override
    public void removeContact(String number) {

    }

    @Override
    public void blockNumber(String number) {

    }

    @Override
    public void unblockNumber(String number) {

    }

    @Override
    public void reportSpam(String number, String reason) {

    }

    @Override
    public boolean isBlocked(String number) {
        return false;
    }

    @Override
    public boolean canReceive(String number) {
        return false;
    }

    @Override
    public boolean importContacts(List<User> users) {
        return false;
    }

    private void init(UserCategory userCategory) {

    }
}
