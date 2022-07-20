package com.algaworks.logger.client.logs.console;

import com.algaworks.logger.lib.logger.Logger;
import com.algaworks.logger.lib.model.LogPrinter;

public class LoggerConsole extends Logger {

	@Override
	public LogPrinter createLogger() {
		return new LogPrinterConsole();
	}

}
