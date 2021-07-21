package com.paradox.chess.models.pieces;

import com.paradox.chess.models.Board;
import com.paradox.chess.models.Cell;

public class Bishop extends Piece{
    public Bishop(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Cell start, Cell end) {

        return false;
    }
}
