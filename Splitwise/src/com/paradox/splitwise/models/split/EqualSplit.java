package com.paradox.splitwise.models.split;

import com.paradox.splitwise.models.User;
import com.paradox.splitwise.models.enums.SplitType;

public class EqualSplit extends Split{
    public EqualSplit(User user) {
        super(user);
    }

    @Override
    public double getShare() {
        return getAmount();
    }
}
