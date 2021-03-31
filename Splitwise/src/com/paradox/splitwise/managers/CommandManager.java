package com.paradox.splitwise.managers;

import com.paradox.splitwise.exceptions.IllegalCommandTypeException;
import com.paradox.splitwise.exceptions.IllegalExpenseTypeException;
import com.paradox.splitwise.models.User;
import com.paradox.splitwise.models.enums.CommandType;
import com.paradox.splitwise.models.enums.ExpenseType;
import com.paradox.splitwise.models.split.EqualSplit;
import com.paradox.splitwise.models.split.ExactSplit;
import com.paradox.splitwise.models.split.PercentSplit;
import com.paradox.splitwise.models.split.Split;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommandManager {
    public static void executeCommands(String[] commands) throws IllegalCommandTypeException, IllegalExpenseTypeException {
        ExpenseManager expenseManager = ExpenseManager.getInstance();

        CommandType commandType = CommandType.getCommandType(commands[0]);
        switch (commandType) {
            case SHOW:
                if (commands.length == 1) {
                    expenseManager.showBalances();
                } else {
                    expenseManager.showBalance(commands[1]);
                }
                break;
            case EXPENSE:
                String paidBy = commands[1];
                Double amount = Double.parseDouble(commands[2]);
                int noOfUsers=  Integer.parseInt(commands[3]);
                ExpenseType expenseType = ExpenseType.getExpenseType(commands[4 + noOfUsers]);
                List<Split> splits = new ArrayList<>();
                Map<String, User> userMap = expenseManager.getUserMap();
                switch (expenseType) {
                    case EQUAL:
                        for (int i=0; i<noOfUsers; i++) {
                            splits.add(new EqualSplit(userMap.get(commands[4+i])));
                        }
                        expenseManager.addExpense(ExpenseType.EQUAL, amount, paidBy, splits, null);
                        break;
                    case EXACT:
                        for (int i=0; i<noOfUsers; i++) {
                            splits.add(new ExactSplit(userMap.get(commands[4+i]), Double.parseDouble(commands[5 + noOfUsers + i])));
                        }
                        expenseManager.addExpense(ExpenseType.EXACT, amount, paidBy, splits, null);
                        break;
                    case PERCENT:
                        for (int i=0; i<noOfUsers; i++) {
                            splits.add(new PercentSplit(userMap.get(commands[4+i]), Double.parseDouble(commands[5 + noOfUsers + i])));
                        }
                        expenseManager.addExpense(ExpenseType.EXACT, amount, paidBy, splits, null);
                        break;
                }
                break;
        }
    }
}
