package factories;

import java.io.IOException;
import java.util.Properties;

public class ConfModificated {
	private Properties props;

	public ConfModificated(String filename) {
		this.props = new Properties();
		try {
			props.load(ConfModificated.class.getClassLoader().getResourceAsStream(filename));
		} catch (IOException e) {
			throw new RuntimeException("File properties cannot be loaded",e);
		}
		
	}
	
	public String getProperty(String key) {
		String value = props.getProperty(key);
		if (value == null) {
			throw new RuntimeException("Property not found in config file");
		}
		return value;
	}
	

}
