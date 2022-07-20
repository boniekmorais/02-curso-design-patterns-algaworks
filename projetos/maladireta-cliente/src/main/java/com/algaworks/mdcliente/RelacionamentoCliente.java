package com.algaworks.mdcliente;

import javax.swing.JOptionPane;

import com.algaworks.mdcliente.csv.MalaDiretaCSV;
import com.algaworks.mdcliente.xml.MalaDiretaXML;
import com.algaworks.mdlib.maladireta.MalaDireta;

public class RelacionamentoCliente {

	public static void main(String[] args) {
		
		MalaDireta malaDireta = new MalaDiretaCSV("contatos.csv");
		
		String mensagem = JOptionPane.showInputDialog(null, "Digite a mensagem do e-mail:");
		
		boolean status = malaDireta.enviarEmail(mensagem);
		
		System.out.println(status);
		
		MalaDireta malaDiretaXml = new MalaDiretaXML("contatos.xml");
		
		String mensagem2 = JOptionPane.showInputDialog(null, "Digite a mensagem do e-mail:");
		
		boolean status2 = malaDiretaXml.enviarEmail(mensagem2);
		
		System.out.println(status2);
		
	}
}
