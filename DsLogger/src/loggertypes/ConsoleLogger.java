package loggertypes;

import interfaces.ILogger;

public class ConsoleLogger implements ILogger{

	@Override
	public void log(String msg) {
		System.out.println(msg);
	}

}
