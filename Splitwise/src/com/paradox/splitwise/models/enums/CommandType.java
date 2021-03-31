package com.paradox.splitwise.models.enums;

import com.paradox.splitwise.exceptions.IllegalCommandTypeException;

public enum CommandType {
    SHOW,
    EXPENSE,
    ;

    public static CommandType getCommandType(String type) throws IllegalCommandTypeException {
        switch (type) {
            case "SHOW": return SHOW;
            case "EXPENSE": return EXPENSE;
            default: throw new IllegalCommandTypeException("Wrong Command Type!");
        }
    }
}
