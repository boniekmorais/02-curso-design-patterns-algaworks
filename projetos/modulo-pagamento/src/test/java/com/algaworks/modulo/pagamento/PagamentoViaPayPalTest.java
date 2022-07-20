package com.algaworks.modulo.pagamento;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.algaworks.modulo.pagamento.gestorderisco.AlertaRiscoException;
import com.algaworks.modulo.pagamento.operadora.CapturaNaoAutorizadaException;
import com.algaworks.modulo.pagamento.pgto.ModuloPagamentoFactory;
import com.algaworks.modulo.pagamento.pgto.Pagamento;
import com.algaworks.modulo.pagamento.pgto.paypal.PayPalModuloPagamentoFactory;

public class PagamentoViaPayPalTest {

	private Pagamento pagamento;
	
	@Before
	public void init() {
		ModuloPagamentoFactory moduloPagamentoFactory = new PayPalModuloPagamentoFactory();
		pagamento = new Pagamento(moduloPagamentoFactory);
	}

	@Test
	public void deveAutorizarVenda() throws CapturaNaoAutorizadaException, AlertaRiscoException {
		Long codigoAutorizacao = pagamento.autorizar("2222.2222", new BigDecimal("200"));
		assertNotNull(codigoAutorizacao);
	}

	@Test(expected = CapturaNaoAutorizadaException.class)
	public void deveNegarCaptura_valorAcimaDoLimiteParaCartao() throws CapturaNaoAutorizadaException, AlertaRiscoException {
		pagamento.autorizar("2222.2222", new BigDecimal("2000"));
	}

	@Test
	public void deveAutorizarVenda_valorAltoComCartaoValido() throws CapturaNaoAutorizadaException, AlertaRiscoException {
		Long codigoAutorizacao = pagamento.autorizar("3333.2222", new BigDecimal("2000"));
		assertNotNull(codigoAutorizacao);
	}

	@Test(expected = AlertaRiscoException.class)
	public void deveGerarAlertaDeRisco() throws CapturaNaoAutorizadaException, AlertaRiscoException {
		pagamento.autorizar("1111.2222", new BigDecimal("5500"));
	}
	
}
