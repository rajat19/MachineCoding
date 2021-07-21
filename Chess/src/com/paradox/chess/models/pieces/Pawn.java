package com.paradox.chess.models.pieces;

import com.paradox.chess.models.Board;
import com.paradox.chess.models.Cell;

public class Pawn extends Piece{
    public Pawn(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Cell start, Cell end) {
        if (end.getPiece().isWhite() == this.isWhite()) {
            return false;
        }
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
        if (y == 1 && x == 1 && end.getPiece().isWhite() != this.isWhite()) {
            return true;
        }
        if (y > 0) return false;
        if (start.getX() == 1) {
            return x <= 2;
        }
        return x == 1;
    }
}
