package com.paradox.splitwise.models.expense;

import com.paradox.splitwise.models.ExpenseMetaData;
import com.paradox.splitwise.models.User;
import com.paradox.splitwise.models.split.PercentSplit;
import com.paradox.splitwise.models.split.Split;

import java.util.List;

public class PercentExpense extends Expense{
    public PercentExpense(double amount, User paidBy, List<Split> splits, ExpenseMetaData metaData) {
        super(amount, paidBy, splits, metaData);
    }

    @Override
    public boolean validate() {
        for (Split split: getSplits()) {
            if (!(split instanceof PercentSplit)) {
                return false;
            }
        }

        double totalPercent = 100;
        double sumSplitPercent = 0;
        for (Split split: getSplits()) {
            sumSplitPercent += split.getShare();
        }
        if (totalPercent != sumSplitPercent) {
            return false;
        }
        return true;
    }
}
