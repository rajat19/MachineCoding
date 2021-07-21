package com.paradox.chess.models;

import com.paradox.chess.models.enums.GameStatus;
import com.paradox.chess.models.pieces.King;
import com.paradox.chess.models.pieces.Piece;

import java.util.List;

public class Game {
    private Player[] players;
    private Board board;
    private List<Move> movesPlayed;
    private Player currentTurn;
    private GameStatus status;

    public boolean isOver() {
        return status != GameStatus.ACTIVE;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Move> getMovesPlayed() {
        return movesPlayed;
    }

    public void setMovesPlayed(List<Move> movesPlayed) {
        this.movesPlayed = movesPlayed;
    }

    public Player getCurrentTurn() {
        return currentTurn;
    }

    public void setCurrentTurn(Player currentTurn) {
        this.currentTurn = currentTurn;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    private boolean makeMove(Move move, Player player) {
        Piece sourcePiece = move.getStart().getPiece();
        if (sourcePiece == null) {
            return false;
        }

        // valid player
        if (player != currentTurn) {
            return false;
        }

        if (sourcePiece.isWhite() != player.isWhiteSide()) {
            return false;
        }

        // valid move?
        if (!sourcePiece.canMove(board, move.getStart(), move.getEnd())){
            return false;
        }

        // kill?
        Piece destPiece = move.getStart().getPiece();
        if (destPiece != null) {
            destPiece.setKilled(true);
            move.setPieceKilled(destPiece);
        }

        // castling?
        if (sourcePiece instanceof King && ((King) sourcePiece).isCastlingMove(move.getStart(), move.getEnd())) {
            move.setCastlingMove(true);
        }

        // store the move
        movesPlayed.add(move);

        // move piece from the start box to end box
        move.getEnd().setPiece(move.getStart().getPiece());
        move.getStart().setPiece(null);

        if (destPiece instanceof King) {
            if(player.isWhiteSide()) {
                this.setStatus(GameStatus.WHITE_WIN);
            } else {
                this.setStatus(GameStatus.BLACK_WIN);
            }
        }

        // set the current turn to the other player
        if(this.currentTurn == players[0]) {
            this.currentTurn = players[1];
        } else {
            this.currentTurn = players[0];
        }

        return true;
    }
}
