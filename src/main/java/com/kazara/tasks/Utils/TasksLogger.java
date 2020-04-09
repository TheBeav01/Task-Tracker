package com.kazara.tasks.Utils;
import org.apache.logging.log4j.Logger;
public class TasksLogger {
    public static Logger log;
    public static void registerLogger(Logger log) {
        TasksLogger.log = log;
    }
    public static void log(String message) {
        log.info(message);
    }
}
