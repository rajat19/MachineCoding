package com.paradox.splitwise.models.expense;

import com.paradox.splitwise.models.ExpenseMetaData;
import com.paradox.splitwise.models.User;
import com.paradox.splitwise.models.split.EqualSplit;
import com.paradox.splitwise.models.split.Split;

import java.util.List;

public class EqualExpense extends Expense{
    public EqualExpense(double amount, User paidBy, List<Split> splits, ExpenseMetaData metaData) {
        super(amount, paidBy, splits, metaData);
    }

    @Override
    public boolean validate() {
        for (Split split: getSplits()) {
            if (!(split instanceof EqualSplit)) {
                return false;
            }
        }
        return true;
    }
}
