import interfaces.ILogger;
import interfaces.LoggerFactory;

public class LoggerGetter {
	
	private final static String LOGGER_CONFIG_FILE="";
	
	private static ILogger logger;
	private static LoggerFileParser parser;
	
	
	public static void reparseLogger() {
		logger=null;
	}
	
	public static ILogger getLogger() {
		if (logger == null) {
			LoggerFactory factory = parser.parseFactory(LOGGER_CONFIG_FILE);
			logger = factory.createLogger();
		}
		return logger;
	}

}
