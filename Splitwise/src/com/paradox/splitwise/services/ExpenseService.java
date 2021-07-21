package com.paradox.splitwise.services;

import com.paradox.splitwise.exceptions.IllegalExpenseTypeException;
import com.paradox.splitwise.models.ExpenseMetaData;
import com.paradox.splitwise.models.User;
import com.paradox.splitwise.models.enums.ExpenseType;
import com.paradox.splitwise.models.expense.*;
import com.paradox.splitwise.models.split.Split;

import java.util.List;

public class ExpenseService {
    private ExpenseService() {}

    public static Expense createExpense(ExpenseType expenseType,
                                        double amount,
                                        User paidBy,
                                        List<Split> splits,
                                        ExpenseMetaData expenseMetaData) throws IllegalExpenseTypeException {
        switch (expenseType) {
            case EXACT:
                return new ExactExpense(amount, paidBy, splits, expenseMetaData);
            case EQUAL:
                int totalSplits = splits.size();
                double splitAmount = Math.round(amount*100/totalSplits)/100.0;
                for (Split split: splits) {
                    split.setAmount(splitAmount);
                }
                splits.get(0).setAmount(splitAmount + (amount - splitAmount*totalSplits));
                return new EqualExpense(amount, paidBy, splits, expenseMetaData);
            case PERCENT:
                for (Split split: splits) {
                    split.setAmount((amount * split.getShare())/100.0);
                }
                return new PercentExpense(amount, paidBy, splits, expenseMetaData);
            default: throw new IllegalExpenseTypeException("Wrong Expense Type!");
        }
    }
}
