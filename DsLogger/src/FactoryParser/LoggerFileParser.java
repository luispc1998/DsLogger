package FactoryParser;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import factories.ConfModificated;
import interfaces.LoggerFactory;

public class LoggerFileParser {

	private ConfModificated con;

	public LoggerFileParser(String confFile) {
		con = new ConfModificated(confFile);
	}

	public LoggerFactory parseFactory() {
		Object obj = getClassObject("FACTORY");
		Constructor<?> contructor;
		LoggerFactory l = null;
		try {
			contructor = obj.getClass().getConstructor(new Class[] { ConfModificated.class });

			l = (LoggerFactory) contructor.newInstance(con);

		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e1) {
			e1.printStackTrace();
		} catch (SecurityException e1) {
			e1.printStackTrace();
		}

		return l;
	}

	protected Object getClassObject(String keyName) {

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
