package com.algaworks.modulo.pagamento.gestorderisco.clearsale;

import java.math.BigDecimal;

import com.algaworks.modulo.pagamento.gestorderisco.AlertaRiscoException;
import com.algaworks.modulo.pagamento.gestorderisco.GestorDeRisco;

public class ClearSale implements GestorDeRisco {

	@Override
	public void avaliarRisco(String cartao, BigDecimal valor) throws AlertaRiscoException {
		
		if (cartao.startsWith("1111") && valorMuitoAlto(valor)) {
			throw new AlertaRiscoException("Valor muito alto para o cartão informado.");
		}	
		
	}
	
	private boolean valorMuitoAlto(BigDecimal valor) {
		
		BigDecimal limite = BigDecimal.valueOf(5000.0);
		
		// -1, 0, or 1 as this BigDecimal is numerically less than, equal to, or greater than val
		
		// Retorna -1 para limite menor que valor
		// Retorna  0 para limite igual a valor
		// Retorna  1 para limite maior que valor
		
		// Retorna true se limite for menor que o valor
		
		return limite.compareTo(valor) < 0;
	}

}
