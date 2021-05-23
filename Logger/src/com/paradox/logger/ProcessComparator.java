package com.paradox.logger;

import com.paradox.logger.models.Process;

import java.util.Comparator;

public class ProcessComparator implements Comparator<Process> {
    @Override
    public int compare(Process o1, Process o2) {
        return Long.compare(o1.getStart(), o2.getStart());
    }
}
