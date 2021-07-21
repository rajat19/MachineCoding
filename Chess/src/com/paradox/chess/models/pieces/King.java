package com.paradox.chess.models.pieces;

import com.paradox.chess.models.Board;
import com.paradox.chess.models.Cell;

public class King extends Piece{
    private boolean castlingDone;

    public King(boolean white) {
        super(white);
        castlingDone = false;
    }

    public boolean isCastlingDone() {
        return castlingDone;
    }

    public void setCastlingDone(boolean castlingDone) {
        this.castlingDone = castlingDone;
    }

    @Override
    public boolean canMove(Board board, Cell start, Cell end) {
        if (end.getPiece().isWhite() == this.isWhite()) {
            return false;
        }
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
        if (x + y == 1) {
            // check if this move doesn't make king vulnerable
            return true;
        }

        return isValidCastling(board, start, end);
    }

    private boolean isValidCastling(Board board, Cell start, Cell end) {
        return true;
    }

    public boolean isCastlingMove(Cell start, Cell end) {
        // check if the starting and ending position are correct
        return false;
    }
}
