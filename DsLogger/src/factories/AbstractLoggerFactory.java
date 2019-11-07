package factories;

import interfaces.ILogger;
import interfaces.LoggerFactory;

public abstract class AbstractLoggerFactory implements LoggerFactory{
	
	private String configFile;
	
	public AbstractLoggerFactory(String configFile) {
		this.configFile=configFile;
	}
	
	
	
	
	protected Object getClassObject(String keyName) {
		ConfModificated con = new ConfModificated(configFile);
		String classname = con.getProperty(keyName);

		Object obj = null;
		try {
			obj = Class.forName(classname).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return obj;
	}

}
