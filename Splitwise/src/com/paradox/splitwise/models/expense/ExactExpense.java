package com.paradox.splitwise.models.expense;

import com.paradox.splitwise.models.ExpenseMetaData;
import com.paradox.splitwise.models.User;
import com.paradox.splitwise.models.split.ExactSplit;
import com.paradox.splitwise.models.split.Split;

import java.util.List;

public class ExactExpense extends Expense{
    public ExactExpense(double amount, User paidBy, List<Split> splits, ExpenseMetaData metaData) {
        super(amount, paidBy, splits, metaData);
    }

    @Override
    public boolean validate() {
        for (Split split: getSplits()) {
            if (!(split instanceof ExactSplit)) {
                return false;
            }
        }

        double totalAmount = getAmount();
        double sumSplitAmount = 0;
        for (Split split: getSplits()) {
            sumSplitAmount += split.getShare();
        }

        return totalAmount == sumSplitAmount;
    }
}
