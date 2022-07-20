package com.algaworks.mdlib.maladireta;

import java.util.List;

import com.algaworks.mdlib.model.Contato;
import com.algaworks.mdlib.model.Contatos;

public abstract class MalaDireta {

	protected abstract Contatos criarContatos();
	
	public boolean enviarEmail(String mensagem) {
		
		List<Contato> contatos = criarContatos().todos();
		
		System.out.println("Conectando ao servidor SMTP...");
		System.out.println("Mensagem para enviar: " + mensagem);
		System.out.println();
		
		for (Contato c : contatos) {
			System.out.println("From: <contato@algaworks.com>");
			System.out.printf("To: [%s] <%s>\n", c.getNome(), c.getEmail());
			System.out.println(mensagem);
			System.out.println();
		}
		
		
		return false;
	}
}
