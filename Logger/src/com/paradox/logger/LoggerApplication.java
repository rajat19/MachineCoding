package com.paradox.logger;

import com.paradox.logger.services.LoggerService;
import com.paradox.logger.services.LogClient;

public class LoggerApplication {
    public static void main(String[] args) {
        LogClient logger = new LoggerService();
        logger.start("1", 1);
        logger.poll();
        logger.start("3", 2);
        logger.poll();
        logger.end("1", 3);
        logger.poll();
        logger.start("2", 3);
        logger.poll();
        logger.end("2",4);
        logger.poll();
        logger.end("3", 6);
        logger.poll();
        logger.poll();
        logger.poll();
    }
}
