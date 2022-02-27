package com.paradox.truecaller.models.enums;

public enum UserCategory {
    FREE("FREE", 10_000, 100),
    GOLD("GOLD", 100_000, 1000),
    PLATINUM("PLATINUM", Integer.MAX_VALUE, 100_000);

    private final String name;
    private final int maxContacts;
    private final int maxBlockedContacts;

    UserCategory(String name, int maxContacts, int maxBlockedContacts) {
        this.name = name;
        this.maxContacts = maxContacts;
        this.maxBlockedContacts = maxBlockedContacts;
    }

    public String getName() {
        return name;
    }

    public int getMaxContacts() {
        return maxContacts;
    }

    public int getMaxBlockedContacts() {
        return maxBlockedContacts;
    }
}
