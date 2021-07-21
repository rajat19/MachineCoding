package com.paradox.chess.models;

import com.paradox.chess.models.pieces.Piece;

import java.util.Date;
import java.util.List;

public class Board {
    private Date creationDate;
    private Game currentGame;
    private List<Cell> cells;
    private List<Piece> pieces;

    public void resetBoard() {

    }
}
