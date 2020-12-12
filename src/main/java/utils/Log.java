package utils;

import org.apache.log4j.Logger;

public class Log {

    private  static Logger logger;

    public static Logger intLog() {
        if(logger==null){
            logger = Logger.getRootLogger();
    }
        return logger;
    }

    public static void debug(String mess){
        logger.debug(mess);
    }
}
