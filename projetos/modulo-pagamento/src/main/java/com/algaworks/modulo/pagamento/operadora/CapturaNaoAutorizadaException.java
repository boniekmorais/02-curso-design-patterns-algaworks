package com.algaworks.modulo.pagamento.operadora;

public class CapturaNaoAutorizadaException extends Exception {

	private static final long serialVersionUID = 1L;

	public CapturaNaoAutorizadaException(String mensagem) {
		super(mensagem);
	}
	
}
