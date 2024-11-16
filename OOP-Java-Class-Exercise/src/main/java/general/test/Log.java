package general.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log 
{
	private static Log instance;
	private Logger logger;
	
	private Log()
	{
		logger = LogManager.getLogger(LoggerTest.class);
	}
	
	public static Log getInstance() {	if(instance == null){instance = new Log();}return instance;}
	
	public Logger getLogger() {return logger;}
}
