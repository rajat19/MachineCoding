package com.paradox.geeks.constants;

public class Messages {
    private static final String WINNER = MessageKeys.PLAYER_NAME + " is winner no. " + MessageKeys.WINNER_COUNT + " after rolling " + MessageKeys.DICE_VALUE;
    private static final String MAKE_MOVE = MessageKeys.PLAYER_NAME + " rolled a " + MessageKeys.DICE_VALUE + " and moved from " + MessageKeys.INITIAL_POS + " to " + MessageKeys.FINAL_POS;
    private static final String CANNOT_MOVE = MessageKeys.PLAYER_NAME + " got " + MessageKeys.DICE_VALUE + ", so cannot move ahead";
    private static final String GOT_SNAKE = ":(   " + MessageKeys.PLAYER_NAME + " faced a snake, and now moved to " + MessageKeys.FINAL_POS;
    private static final String GOT_LADDER = ":)   " + MessageKeys.PLAYER_NAME + " climbed a ladder, and now moved to " + MessageKeys.FINAL_POS;

    public static void printWinnerMessage(String playerName, int winnerCount, int diceValue) {
        System.out.println("#############################");
        String message = WINNER.replace(MessageKeys.PLAYER_NAME, playerName)
                .replace(MessageKeys.WINNER_COUNT, Integer.toString(winnerCount))
                .replace(MessageKeys.DICE_VALUE, Integer.toString(diceValue));
        System.out.println(message);
        System.out.println("#############################");
    }

    public static void printMakeMoveMessage(String playerName, int diceValue, int initialPos, int finalPos) {
        String message = MAKE_MOVE.replace(MessageKeys.PLAYER_NAME, playerName)
                .replace(MessageKeys.DICE_VALUE, Integer.toString(diceValue))
                .replace(MessageKeys.INITIAL_POS, Integer.toString(initialPos))
                .replace(MessageKeys.FINAL_POS, Integer.toString(finalPos));
        System.out.println(message);
    }

    public static void printCannotMoveMessage(String playerName, int diceValue) {
        System.out.println(CANNOT_MOVE.replace(MessageKeys.PLAYER_NAME, playerName)
                .replace(MessageKeys.DICE_VALUE, Integer.toString(diceValue)));
    }

    public static void printGotSnakeMessage(String playerName, int snakeTail) {
        System.out.println(GOT_SNAKE.replace(MessageKeys.PLAYER_NAME, playerName)
                .replace(MessageKeys.FINAL_POS, Integer.toString(snakeTail)));
    }

    public static void printGotLadderMessage(String playerName, int ladderEnd) {
        System.out.println(GOT_LADDER.replace(MessageKeys.PLAYER_NAME, playerName)
                .replace(MessageKeys.FINAL_POS, Integer.toString(ladderEnd)));
    }
}
