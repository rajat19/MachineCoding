package com.paradox.splitwise.managers;

import com.paradox.splitwise.exceptions.IllegalExpenseTypeException;
import com.paradox.splitwise.models.ExpenseMetaData;
import com.paradox.splitwise.models.User;
import com.paradox.splitwise.models.expense.Expense;
import com.paradox.splitwise.models.enums.ExpenseType;
import com.paradox.splitwise.models.split.Split;
import com.paradox.splitwise.services.ExpenseService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseManager {
    private List<Expense> expenses;
    private Map<String, User> userMap;
    private Map<String, Map<String, Double>> balanceSheet;
    private static ExpenseManager expenseManagerInstance;

    private ExpenseManager() {
        expenses = new ArrayList<>();
        userMap = new HashMap<>();
        balanceSheet = new HashMap<>();
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public static synchronized ExpenseManager getInstance() {
        if (expenseManagerInstance == null) {
            expenseManagerInstance = new ExpenseManager();
        }
        return expenseManagerInstance;
    }

    public void addUser(User user) {
        userMap.put(user.getId(), user);
        balanceSheet.put(user.getId(), new HashMap<>());
    }

    public void addExpense(ExpenseType expenseType,
                           double amount,
                           String paidBy,
                           List<Split> splits,
                           ExpenseMetaData expenseMetaData) throws IllegalExpenseTypeException {
        Expense expense = ExpenseService.createExpense(expenseType,amount,userMap.get(paidBy),splits,expenseMetaData);
        expenses.add(expense);

        for (Split split: expense.getSplits()) {
            String paidTo = split.getUser().getId();
            Map<String, Double> balances = balanceSheet.get(paidBy);
            balances.put(paidTo, balances.getOrDefault(paidTo, 0.0) + split.getAmount());

            balances = balanceSheet.get(paidTo);
            balances.put(paidBy, balances.getOrDefault(paidBy, 0.0) - split.getAmount());
        }
    }

    public void showBalance(String userId) {
        boolean isEmpty = true;
        for (Map.Entry<String, Double> userBalance: balanceSheet.get(userId).entrySet()) {
            if (userBalance.getValue() != 0) {
                isEmpty = false;
                printBalance(userId, userBalance.getKey(), userBalance.getValue());
            }
        }
        if (isEmpty) {
            System.out.println("No balances");
        }
    }

    public void showBalances() {
        boolean isEmpty = true;
        for (Map.Entry<String, Map<String, Double>> allBalances: balanceSheet.entrySet()) {
            for (Map.Entry<String, Double> userBalance: allBalances.getValue().entrySet()) {
                if (userBalance.getValue() > 0) {
                    isEmpty = false;
                    printBalance(allBalances.getKey(), userBalance.getKey(), userBalance.getValue());
                }
            }
        }
        if (isEmpty) {
            System.out.println("No balances");
        }
    }

    public void printBalance(String user1, String user2, double amount) {
        String user1Name = userMap.get(user1).getName();
        String user2Name = userMap.get(user2).getName();
        if (amount < 0) {
            System.out.println(user1Name + " owes " + user2Name + ": "+ Math.abs(amount));
        } else{
            System.out.println(user2Name + " owes " + user1Name + ": "+ Math.abs(amount));
        }
    }
}
