package com.paradox.chess.models.pieces;

import com.paradox.chess.models.Board;
import com.paradox.chess.models.Cell;

public abstract class Piece {
    private boolean killed = false;
    private boolean white = false;

    public Piece(boolean white) {
        this.white = white;
    }

    public abstract boolean canMove(Board board, Cell start, Cell end);

    public boolean isKilled() {
        return killed;
    }

    public void setKilled(boolean killed) {
        this.killed = killed;
    }

    public boolean isWhite() {
        return white;
    }

    public void setWhite(boolean white) {
        this.white = white;
    }
}
