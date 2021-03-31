package com.paradox.splitwise.models.split;

import com.paradox.splitwise.models.User;
import com.paradox.splitwise.models.enums.SplitType;

public class ExactSplit extends Split{
    public ExactSplit(User user, double amount) {
        super(user);
        this.setAmount(amount);
    }

    @Override
    public double getShare() {
        return getAmount();
    }
}
