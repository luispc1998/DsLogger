import interfaces.ILogger;
import logger.LoggerSingleton;

public class Main {

	public static void main(String[] args) {
		ILogger logger = LoggerSingleton.getLogger();
		logger.log("hihi");
		logger.log("hihi again");

	}

}
