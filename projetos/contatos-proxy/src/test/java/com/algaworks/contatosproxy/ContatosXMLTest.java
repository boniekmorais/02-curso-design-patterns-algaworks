package com.algaworks.contatosproxy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.algaworks.contatosproxy.repository.Contatos;

public class ContatosXMLTest {

	@Test
	public void deveRetornarContato() {
		Contatos contatos = new ContatosXMLProxy("contatos1.xml", "contatos2.xml");
	    String nome = contatos.pesquisarPorEmail("jose@email.com");
	    assertEquals("José Santos", nome);
	}
}
