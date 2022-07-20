package com.algaworks.mdcliente.xml;

import com.algaworks.mdlib.maladireta.MalaDireta;
import com.algaworks.mdlib.model.Contatos;

public class MalaDiretaXML extends MalaDireta {

	private String nomeArquivo;
	
	public MalaDiretaXML(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	@Override
	protected Contatos criarContatos() {
		return new ContatosXML(nomeArquivo);
	}

}
