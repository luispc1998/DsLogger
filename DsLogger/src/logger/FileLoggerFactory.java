package logger;

import interfaces.ILogger;
import interfaces.LoggerFactory;

public class FileLoggerFactory implements LoggerFactory{

	private String logFile;
	
	/**
	 * It's here because of reflection purposes
	 * SHOULD NOT BE CALLED IN NORMAL EXECUTION
	 */
	public FileLoggerFactory() {}
	
	/**
	 * Constructor for the class
	 * @param data A class to access easily the configutarion file properties
	 */
	public FileLoggerFactory(ConfModificated data) {
		this.logFile=data.getProperty("LOGFILE");
	}

	@Override
	public ILogger createLogger() {
		return new FileLogger(logFile);
	}
	
}
