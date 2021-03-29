package com.paradox.geeks.services;

import com.paradox.geeks.constants.Messages;
import com.paradox.geeks.models.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PlayGame {
    private final Board board;
    private final List<Player> players;
    private final Dice dice;

    public PlayGame() {
        int boardSize = 100;
        board = new Board(boardSize);
        players = new ArrayList<>();
        dice = new Dice();
    }

    public void addSnake(int head, int tail) {
        Cell headCell = board.getCellMap().get(head);
        Cell tailCell = board.getCellMap().get(tail);
        Snake snake = new Snake(headCell, tailCell);
        headCell.setSnake(snake);
    }

    public void addLadder(int start, int end) {
        Cell startCell = board.getCellMap().get(start);
        Cell endCell = board.getCellMap().get(end);
        Ladder ladder = new Ladder(startCell, endCell);
        startCell.setLadder(ladder);
    }

    public void addPlayer(String name) {
        Player player = new Player(name);
        player.setCurrent(board.getCellMap().get(0));
        players.add(player);
    }

    public void start() {
        board.setPlayersStillPlaying(new HashSet<>(players));
        board.setMaxWinners(players.size() - 1);

        while (board.getPlayersStillPlaying().size() >= board.getMaxWinners()) {
            for (Player player: players) {
                int diceValue = dice.roll();
                int currentPos = player.getCurrent().getLocation();
                int newPos = currentPos + diceValue;
                if (newPos > 100) {
                    Messages.printCannotMoveMessage(player.getName(), diceValue);
                    continue;
                }
                Cell newCell = board.getCellMap().get(newPos);
                while(newCell.hasSnake() || newCell.hasLadder()) {
                    if (newCell.hasLadder()) {
                        Ladder ladder = newCell.getLadder();
                        newCell = ladder.getEnd();
                        Messages.printGotLadderMessage(player.getName(), newCell.getLocation());
                    } else if (newCell.hasSnake()) {
                        Snake snake = newCell.getSnake();
                        newCell = snake.getTail();
                        Messages.printGotSnakeMessage(player.getName(), newCell.getLocation());
                    }
                }
                player.setCurrent(newCell);

                if (newCell.isLastLocation()) {
                    board.getWinners().add(player);
                    board.getPlayersStillPlaying().remove(player);
                    Messages.printWinnerMessage(player.getName(), board.getWinners().size(), diceValue);
                    break;
                } else {
                    Messages.printMakeMoveMessage(player.getName(), diceValue, currentPos, newCell.getLocation());
                }
            }
        }
    }
}
