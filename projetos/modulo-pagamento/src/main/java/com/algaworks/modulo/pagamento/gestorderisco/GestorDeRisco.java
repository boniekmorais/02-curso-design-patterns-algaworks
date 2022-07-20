package com.algaworks.modulo.pagamento.gestorderisco;

import java.math.BigDecimal;

public interface GestorDeRisco {

	public void avaliarRisco(String cartao, BigDecimal valor) throws AlertaRiscoException;
}
