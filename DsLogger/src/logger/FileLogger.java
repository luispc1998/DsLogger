package logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import interfaces.ILogger;

class FileLogger implements ILogger {

	private String logFile;

	public FileLogger(String logFile) {
		if (logFile == null || logFile.isEmpty()) {
			throw new IllegalArgumentException("The file is null or empty");
		}

		this.logFile = logFile;
	}

	@Override
	public void log(String msg) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new BufferedWriter(new FileWriter(logFile, true)));

			writer.println(msg);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null)
				writer.close();
		}
	}

}
