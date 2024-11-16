package general.test;

import org.apache.logging.log4j.Logger;

public class LoggerTest 
{
	
	static Logger log = Log.getInstance().getLogger();
	

	public static void main(String[] args) {

		log.warn("Hey This is a warnning");
		log.debug("Hello from Log4j 2");
		log.debug("This is a Debug Message!");
		log.info("This is an Info Message!");
		log.error("And here comes the Error Message!", new RuntimeException("Hey StopStopStop"));
		
	}

}
