package com.paradox.logger.services;

import com.paradox.logger.ProcessComparator;
import com.paradox.logger.models.Process;
import com.paradox.logger.services.LogClient;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LoggerService implements LogClient {
    private Map<String, Long> startMap;
    private PriorityQueue<Process> processQueue;

    public LoggerService() {
        startMap = new HashMap<>();
        processQueue = new PriorityQueue<>(new ProcessComparator());
    }

    @Override
    public void start(String processId, long timestamp) {
        startMap.put(processId, timestamp);
    }

    @Override
    public void end(String processId, long timestamp) {
        if (!startMap.containsKey(processId)) {
            throw new Error("Cannot end process as it is not started");
        }
        Process process = new Process(processId, startMap.get(processId));
        process.setEnd(timestamp);
        processQueue.offer(process);
    }

    @Override
    public String poll() {
        if (processQueue.isEmpty()) {
            throw new Error("No process remaining");
        }
        return processQueue.poll().toString();
    }
}
