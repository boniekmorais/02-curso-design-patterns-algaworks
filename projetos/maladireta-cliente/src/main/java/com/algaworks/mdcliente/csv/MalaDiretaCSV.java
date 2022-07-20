package com.algaworks.mdcliente.csv;

import com.algaworks.mdlib.maladireta.MalaDireta;
import com.algaworks.mdlib.model.Contatos;

public class MalaDiretaCSV extends MalaDireta {

	private String nomeArquivo;
	
	public MalaDiretaCSV(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	@Override
	protected Contatos criarContatos() {
		return new ContatosCSV(nomeArquivo);
	}

}
