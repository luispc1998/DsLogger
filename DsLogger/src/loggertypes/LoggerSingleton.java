package loggertypes;
import FactoryParser.LoggerFileParser;
import interfaces.ILogger;
import interfaces.LoggerFactory;

public class LoggerSingleton {
	
	private final static String LOGGER_CONFIG_FILE="logger.properties";
	
	private static ILogger logger;
	
	
	public static ILogger getLogger() {
		if (logger == null) {
			LoggerFileParser parser = generateParser();
			LoggerFactory factory = parser.parseFactory();
			logger = factory.createLogger();
		}
		return logger;
	}
	
	
	public static void reparseLogger() {
		logger=null;
	}

	private static LoggerFileParser generateParser() {
		return new LoggerFileParser(LOGGER_CONFIG_FILE);
	}
	
	

}
