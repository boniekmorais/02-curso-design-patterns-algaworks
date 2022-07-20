package com.algaworks.modulo.pagamento;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.algaworks.modulo.pagamento.gestorderisco.AlertaRiscoException;
import com.algaworks.modulo.pagamento.operadora.CapturaNaoAutorizadaException;
import com.algaworks.modulo.pagamento.pgto.ModuloPagamentoFactory;
import com.algaworks.modulo.pagamento.pgto.Pagamento;
import com.algaworks.modulo.pagamento.pgto.pagseguro.PagSeguroModuloPagamentoFactory;

public class PagamentoViaPagSeguroTest {

	private Pagamento pagamento;
	
	@Before
	public void init() {
		ModuloPagamentoFactory moduloPagamentoFactory = new PagSeguroModuloPagamentoFactory();
		pagamento = new Pagamento(moduloPagamentoFactory);
	}
	
	@Test
	public void deveAutorizarVenda() throws CapturaNaoAutorizadaException, AlertaRiscoException {
		Long codigoAutorizacao = pagamento.autorizar("2222.2222", new BigDecimal("200"));
		assertNotNull(codigoAutorizacao);
	}
	
	@Test(expected=CapturaNaoAutorizadaException.class)
	public void deveNegarCaptura_cartaoInvalido() throws CapturaNaoAutorizadaException, AlertaRiscoException {
		pagamento.autorizar("5555.2222", new BigDecimal("2000"));
	}
	
	@Test(expected=AlertaRiscoException.class)
	public void deveGerarAlertaDeRisco() throws CapturaNaoAutorizadaException, AlertaRiscoException {
		pagamento.autorizar("7777.2222", new BigDecimal("5500"));
	}
	
}
