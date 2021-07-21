package com.paradox.chess.models.pieces;

import com.paradox.chess.models.Board;
import com.paradox.chess.models.Cell;

public class Queen extends Piece{

    public Queen(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Cell start, Cell end) {
        if (end.getPiece().isWhite() == this.isWhite()) {
            return false;
        }
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
        return x==0 || y==0 || x==y;
    }
}
