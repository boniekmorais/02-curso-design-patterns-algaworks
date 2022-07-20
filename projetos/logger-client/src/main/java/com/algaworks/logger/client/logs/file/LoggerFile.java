package com.algaworks.logger.client.logs.file;

import com.algaworks.logger.lib.logger.Logger;
import com.algaworks.logger.lib.model.LogPrinter;

public class LoggerFile extends Logger {

	@Override
	public LogPrinter createLogger() {
		return new LogPrinterFile();
	}

}
