package utils;

import org.apache.log4j.Logger;

import java.lang.invoke.MethodHandles;

public class Log {

    private static Logger logger;

    public static Logger intLog() {
        if (logger == null) {
            logger = Logger.getLogger(MethodHandles.lookup().lookupClass());
        }
        return logger;
    }

    public static Logger getLogger() {
        return logger = logger;
    }
}
