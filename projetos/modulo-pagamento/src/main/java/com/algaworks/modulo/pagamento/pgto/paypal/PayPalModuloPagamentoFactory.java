package com.algaworks.modulo.pagamento.pgto.paypal;

import com.algaworks.modulo.pagamento.gestorderisco.GestorDeRisco;
import com.algaworks.modulo.pagamento.gestorderisco.clearsale.ClearSale;
import com.algaworks.modulo.pagamento.operadora.Operadora;
import com.algaworks.modulo.pagamento.operadora.redecard.RedeCard;
import com.algaworks.modulo.pagamento.pgto.ModuloPagamentoFactory;

public class PayPalModuloPagamentoFactory implements ModuloPagamentoFactory {

	@Override
	public Operadora criarOperadora() {
		return new RedeCard();
	}

	@Override
	public GestorDeRisco criarGestorDeRisco() {
		return new ClearSale();
	}

}
