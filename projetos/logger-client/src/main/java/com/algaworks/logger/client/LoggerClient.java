package com.algaworks.logger.client;

import com.algaworks.logger.client.logs.console.LoggerConsole;
import com.algaworks.logger.client.logs.file.LoggerFile;

public class LoggerClient {

	public static void main(String[] args) {
		
		// Imprimindo log no console
		LoggerConsole loggerConsole = new LoggerConsole();
		loggerConsole.log("Mensagem enviada para o log");
		
		// Imprimindo log no arquivo
		LoggerFile loggerFile = new LoggerFile();
		loggerFile.log("Mensagem enviada para o log");
		
	}
	
}
