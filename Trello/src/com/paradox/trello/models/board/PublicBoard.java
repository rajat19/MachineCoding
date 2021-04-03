package com.paradox.trello.models.board;

import com.paradox.trello.models.enums.BoardPrivacy;

public class PublicBoard extends Board{
    public PublicBoard(String id, String name, String url) {
        super(id, name, BoardPrivacy.PUBLIC, url);
    }

    public PublicBoard(String id, String name) {
        super(id, name, BoardPrivacy.PUBLIC, null);
    }
}
