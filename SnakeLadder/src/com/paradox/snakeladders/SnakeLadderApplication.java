package com.paradox.snakeladders;

import com.paradox.snakeladders.services.PlayGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

public class SnakeLadderApplication {
    public static void main(String[] args) throws FileNotFoundException {
        PlayGame playGame = new PlayGame();

        URL url = SnakeLadderApplication.class.getResource("./input.txt");
        File file = new File(url.getPath());
        Scanner scanner = new Scanner(file);

        int snakeCount = scanner.nextInt();
        while (snakeCount > 0) {
            int snakeHead = scanner.nextInt();
            int snakeTail = scanner.nextInt();
            playGame.addSnake(snakeHead, snakeTail);
            snakeCount--;
        }

        int ladderCount = scanner.nextInt();
        while (ladderCount > 0) {
            int ladderStart = scanner.nextInt();
            int ladderEnd = scanner.nextInt();
            playGame.addLadder(ladderStart, ladderEnd);
            ladderCount--;
        }

        int playerCount = scanner.nextInt();
        while (playerCount > 0) {
            String playerName = scanner.next();
            playGame.addPlayer(playerName);
            playerCount--;
        }

        playGame.start();
    }
}
