package com.algaworks.modulo.pagamento.operadora.cielo;

import java.math.BigDecimal;

import com.algaworks.modulo.pagamento.operadora.CapturaNaoAutorizadaException;
import com.algaworks.modulo.pagamento.operadora.Operadora;

public class Cielo implements Operadora {

	private long codigoConfirmacao = -1L;
	
	@Override
	public void capturar(String cartao, BigDecimal valor) throws CapturaNaoAutorizadaException {
		
		if (cartao.startsWith("5555")) {
			throw new CapturaNaoAutorizadaException("Número de cartão inválido");
		}
		
		this.codigoConfirmacao = (long) Math.random() * 1000;
		
	}

	@Override
	public long confirmar() {
		System.out.println("Fazendo o débito na conta do cliente via Cielo");
		return this.codigoConfirmacao;
	}

}
