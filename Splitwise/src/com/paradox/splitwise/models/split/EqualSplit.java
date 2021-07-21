package com.paradox.splitwise.models.split;

import com.paradox.splitwise.models.User;

public class EqualSplit extends Split{
    public EqualSplit(User user) {
        super(user);
    }

    @Override
    public double getShare() {
        return getAmount();
    }
}
