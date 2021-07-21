package com.paradox.splitwise;

import com.paradox.splitwise.exceptions.IllegalCommandTypeException;
import com.paradox.splitwise.exceptions.IllegalExpenseTypeException;
import com.paradox.splitwise.managers.CommandManager;
import com.paradox.splitwise.managers.ExpenseManager;
import com.paradox.splitwise.models.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

public class SplitwiseApplication {
    public static void main(String[] args) throws FileNotFoundException, IllegalExpenseTypeException, IllegalCommandTypeException {
        ExpenseManager expenseManager = ExpenseManager.getInstance();

        expenseManager.addUser(new User("u1", "Rajat", "rajatsri94@gmail.com", "1234"));
        expenseManager.addUser(new User("u2", "Abhinav", "raiabhinavrai1994@gmail.com", "1234"));
        expenseManager.addUser(new User("u3", "Prashant", "prashant.pandey687@gmail.com", "1234"));
        expenseManager.addUser(new User("u4", "Harsh", "harshgupta1994@gmail.com", "1234"));

        URL url = SplitwiseApplication.class.getResource("./input.txt");
        File file = new File(url.getPath());
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String command = scanner.nextLine();
                String[] commands = command.split(" ");
                CommandManager.executeCommands(commands);
            }
        }
    }
}
