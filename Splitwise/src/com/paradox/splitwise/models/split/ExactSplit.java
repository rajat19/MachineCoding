package com.paradox.splitwise.models.split;

import com.paradox.splitwise.models.User;

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
