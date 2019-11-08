package logger;

import interfaces.ILogger;

class ConsoleLogger implements ILogger{

	@Override
	public void log(String msg) {
		System.out.println(msg);
	}

}
