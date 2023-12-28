package org.example;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Log
{
    private LogManager lgmngr;
    static private Logger log;//should be logger

    private static Log instance;
    private Log()
    {
        lgmngr = LogManager.getLogManager();
        log = lgmngr.getLogger(Logger.GLOBAL_LOGGER_NAME);
    };

    public static Logger getInstance()
    {
        if(instance == null)
        {
            instance = new Log();
        }
        return log;
    }
}
