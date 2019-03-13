package util;

import org.apache.log4j.Logger;

public class UncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    private static final Logger LOGGER = Logger.getLogger(UncaughtExceptionHandler.class);

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        LOGGER.error("Uncaught exception in thread: " + t.getName(), e);
    }

}
