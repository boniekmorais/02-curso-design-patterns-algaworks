package com.algaworks.modulo.pagamento.gestorderisco.fcontrol;

import java.math.BigDecimal;

import com.algaworks.modulo.pagamento.gestorderisco.AlertaRiscoException;
import com.algaworks.modulo.pagamento.gestorderisco.GestorDeRisco;

public class FControl implements GestorDeRisco {

	@Override
	public void avaliarRisco(String cartao, BigDecimal valor) throws AlertaRiscoException {
		
		if (cartao.startsWith("7777")) {
			throw new AlertaRiscoException("Cartão suspeito.");
		}
		
	}

	
}
