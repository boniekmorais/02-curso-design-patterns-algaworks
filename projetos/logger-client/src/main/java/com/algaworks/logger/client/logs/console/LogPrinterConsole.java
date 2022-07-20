package com.algaworks.logger.client.logs.console;

import com.algaworks.logger.lib.model.LogPrinter;

public class LogPrinterConsole implements LogPrinter {

	@Override
	public void print(String message) {
		System.out.println("[CONSOLE] " + message);
	}

}
