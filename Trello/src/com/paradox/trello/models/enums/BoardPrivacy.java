package com.paradox.trello.models.enums;

import com.paradox.trello.exceptions.IllegalBoardPrivacyException;

public enum BoardPrivacy {
    PUBLIC,
    PRIVATE,
    ;

    public static BoardPrivacy getBoardPrivacy(String privacy) throws IllegalBoardPrivacyException {
        switch (privacy) {
            case "PUBLIC": return PUBLIC;
            case "PRIVATE": return PRIVATE;
            default: throw new IllegalBoardPrivacyException("Wrong Board Privacy");
        }
    }
}
