package com.paradox.cab;

import com.paradox.cab.managers.CommandManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

public class CabBookingApplication {
    public static void main(String[] args) throws FileNotFoundException {
        CommandManager commandManager = new CommandManager();
        URL url = CabBookingApplication.class.getResource("./input.txt");
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
