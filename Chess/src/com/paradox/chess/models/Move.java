package com.paradox.chess.models;

import com.paradox.chess.models.pieces.Piece;

public class Move {
    private Player player;
    private Cell start;
    private Cell end;
    private Piece pieceMoved;
    private Piece pieceKilled;
    private boolean castlingMove = false;

    public Move(Player player, Cell start, Cell end){
        this.player = player;
        this.start = start;
        this.end = end;
        this.pieceMoved = start.getPiece();
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Cell getStart() {
        return start;
    }

    public void setStart(Cell start) {
        this.start = start;
    }

    public Cell getEnd() {
        return end;
    }

    public void setEnd(Cell end) {
        this.end = end;
    }

    public Piece getPieceMoved() {
        return pieceMoved;
    }

    public void setPieceMoved(Piece pieceMoved) {
        this.pieceMoved = pieceMoved;
    }

    public Piece getPieceKilled() {
        return pieceKilled;
    }

    public void setPieceKilled(Piece pieceKilled) {
        this.pieceKilled = pieceKilled;
    }

    public boolean isCastlingMove() {
        return this.castlingMove;
    }

    public void setCastlingMove(boolean castlingMove) {
        this.castlingMove = castlingMove;
    }
}
