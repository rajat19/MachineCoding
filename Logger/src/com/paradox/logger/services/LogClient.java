package com.paradox.logger.services;

public interface LogClient {
    void start(String processId, long timestamp);
    void end(String processId, long timestamp);
    String poll();
}
