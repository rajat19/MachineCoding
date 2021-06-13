package com.paradox.restaurant.models.accounts;

import com.paradox.restaurant.models.enums.AccountStatus;

public class Account {
    private String id;
    private String password;
    private AccountStatus status;

    public Account(String id, String password) {
        this.id = id;
        this.password = password;
        this.status = AccountStatus.ACTIVE;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void blockAccount() {
        this.status = AccountStatus.BLOCKED;
    }

    public void blacklistAccount() {
        this.status = AccountStatus.BLACKLISTED;
    }

    public void cancelAccount() {
        this.status = AccountStatus.CANCELLED;
    }

    public void closeAccount() {
        this.status = AccountStatus.CLOSED;
    }

    public void activateAccount() {
        this.status = AccountStatus.ACTIVE;
    }
}
