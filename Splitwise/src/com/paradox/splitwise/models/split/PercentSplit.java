package com.paradox.splitwise.models.split;

import com.paradox.splitwise.models.User;

public class PercentSplit extends Split{
    private double percent;
    public PercentSplit(User user, double percent) {
        super(user);
        this.setPercent(percent);
    }

    @Override
    public double getShare() {
        return getPercent();
    }

    public double getPercent() {
        return this.percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }
}
