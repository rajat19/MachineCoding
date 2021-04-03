package com.paradox.trello;

import com.paradox.trello.managers.CommandManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

public class TrelloApplication {
    public static void main(String[] args) throws FileNotFoundException {
        CommandManager commandManager = new CommandManager();
        URL url = TrelloApplication.class.getResource("./input.txt");
        File file = new File(url.getPath());
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String command = scanner.nextLine();
            String[] commands = command.split(" ");
            try {
                commandManager.executeCommands(commands);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
