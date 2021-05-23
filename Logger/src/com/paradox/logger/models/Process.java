package com.paradox.logger.models;

public class Process {
    private final String id;
    private final long start;
    private long end;

    public Process(String id, long start) {
        this.id = id;
        this.start = start;
        this.end = -1;
    }

    public String getId() {
        return id;
    }

    public long getStart() {
        return start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }
}
