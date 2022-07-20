package com.algaworks.modulo.pagamento.pgto;

import com.algaworks.modulo.pagamento.gestorderisco.GestorDeRisco;
import com.algaworks.modulo.pagamento.operadora.Operadora;

public interface ModuloPagamentoFactory {

	public Operadora criarOperadora();
	public GestorDeRisco criarGestorDeRisco();
	
}
