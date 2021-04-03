package com.paradox.trello.models.board;

import com.paradox.trello.models.enums.BoardPrivacy;

public class PrivateBoard extends Board{
    public PrivateBoard(String id, String name, String url) {
        super(id, name, BoardPrivacy.PRIVATE, url);
    }

    public PrivateBoard(String id, String name) {
        super(id, name, BoardPrivacy.PRIVATE, null);
    }
}
