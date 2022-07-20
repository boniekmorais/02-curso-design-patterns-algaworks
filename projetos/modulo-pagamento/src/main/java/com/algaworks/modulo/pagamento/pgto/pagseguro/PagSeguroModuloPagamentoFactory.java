package com.algaworks.modulo.pagamento.pgto.pagseguro;

import com.algaworks.modulo.pagamento.gestorderisco.GestorDeRisco;
import com.algaworks.modulo.pagamento.gestorderisco.fcontrol.FControl;
import com.algaworks.modulo.pagamento.operadora.Operadora;
import com.algaworks.modulo.pagamento.operadora.cielo.Cielo;
import com.algaworks.modulo.pagamento.pgto.ModuloPagamentoFactory;

public class PagSeguroModuloPagamentoFactory implements ModuloPagamentoFactory {

	@Override
    public Operadora criarOperadora() {
	    return new Cielo();
    }

	@Override
    public GestorDeRisco criarGestorDeRisco() {
	    return new FControl();
    }
	
}
