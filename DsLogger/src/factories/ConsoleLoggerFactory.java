package factories;

import interfaces.ILogger;
import interfaces.LoggerFactory;
import loggertypes.ConsoleLogger;

public class ConsoleLoggerFactory implements LoggerFactory{
	
	/**
	 * It's here because of reflection purposes
	 * SHOULD NOT BE CALLED IN NORMAL EXECUTION
	 */
	public ConsoleLoggerFactory() {}
	
	/**
	 * Constructor for the class
	 * @param data not used, no data required
	 */
	public ConsoleLoggerFactory(ConfModificated data) {}

	@Override
	public ILogger createLogger() {
		return new ConsoleLogger();
	}

}
