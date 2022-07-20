package com.algaworks.logger.client.logs.file;

import com.algaworks.logger.lib.model.LogPrinter;

public class LogPrinterFile implements LogPrinter {

	@Override
	public void print(String message) {
		System.out.println("[FILE] " + message);
	}

}
