package com.algaworks.logger.lib.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.algaworks.logger.lib.model.LogPrinter;

public abstract class Logger {
	
	public abstract LogPrinter createLogger();

	public void log(String message) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime localTime = LocalDateTime.now();
		
		String localTimeString = localTime.format(formatter);
		
		String fullMessage = "[" + localTimeString + "] " + message;
		
		createLogger().print(fullMessage);
		
	}
	
}
