import factories.ConfModificated;
import interfaces.LoggerFactory;

public class LoggerFileParser {

	private String confFile;

	public LoggerFileParser(String confFile) {
		this.confFile = confFile;
	}

	public LoggerFactory parseFactory(String loggerConfigFile) {
		Object obj = getClassObject("FACTORY");
		LoggerFactory factory = (LoggerFactory) obj;
		return factory;
	}

	
	
	protected Object getClassObject(String keyName) {
		ConfModificated con = new ConfModificated(confFile);
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
