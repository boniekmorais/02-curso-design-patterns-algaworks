package com.algaworks.modulo.pagamento.pgto;

import java.math.BigDecimal;

import com.algaworks.modulo.pagamento.gestorderisco.AlertaRiscoException;
import com.algaworks.modulo.pagamento.gestorderisco.GestorDeRisco;
import com.algaworks.modulo.pagamento.operadora.CapturaNaoAutorizadaException;
import com.algaworks.modulo.pagamento.operadora.Operadora;

public class Pagamento {

	private Operadora operadora;
	private GestorDeRisco gestorDeRisco;

	public Pagamento(ModuloPagamentoFactory moduloPagamentoFactory) {
	    this.operadora = moduloPagamentoFactory.criarOperadora();
	    this.gestorDeRisco = moduloPagamentoFactory.criarGestorDeRisco();
    }

	public Long autorizar(String cartao, BigDecimal valor) throws CapturaNaoAutorizadaException, AlertaRiscoException {
		this.operadora.capturar(cartao, valor);
		this.gestorDeRisco.avaliarRisco(cartao, valor);
		return this.operadora.confirmar();
    }
}
