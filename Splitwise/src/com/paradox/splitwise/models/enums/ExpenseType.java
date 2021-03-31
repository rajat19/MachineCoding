package com.paradox.splitwise.models.enums;

import com.paradox.splitwise.exceptions.IllegalExpenseTypeException;

public enum ExpenseType {
    EXACT,
    EQUAL,
    PERCENT,
    ;

    public static ExpenseType getExpenseType(String type) throws IllegalExpenseTypeException {
        switch (type) {
            case "EXACT": return EXACT;
            case "EQUAL": return EQUAL;
            case "PERCENT": return PERCENT;
            default: throw new IllegalExpenseTypeException("Wrong Expense Type!");
        }
    }
}
