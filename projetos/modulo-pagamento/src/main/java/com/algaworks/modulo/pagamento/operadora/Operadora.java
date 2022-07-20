package com.algaworks.modulo.pagamento.operadora;

import java.math.BigDecimal;

public interface Operadora {

	public void capturar(String cartao, BigDecimal valor) throws CapturaNaoAutorizadaException;
	public long confirmar();
	
}
