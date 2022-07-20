package com.algaworks.pedidos.builder;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.algaworks.pedidos.model.Cliente;
import com.algaworks.pedidos.model.Pedido;
import com.algaworks.pedidos.model.PedidoItem;

public class PedidoBuilder {

	private Pedido instancia;

	public PedidoBuilder() {
		this.instancia = new Pedido();
	}
	
	public PedidoBuilderValido comNumero(String numero) {
		this.instancia.setNumero(numero);
		return new PedidoBuilderValido(instancia);
	}
	
	public PedidoBuilder comClienteVip(String nome) {
		definirCliente(nome, true);
		return this;
	}
	
	public PedidoBuilder comClienteNormal(String nome) {
		definirCliente(nome, false);
		return this;
	}
	
	public PedidoBuilder comItem(String descricao, Integer quantidade, BigDecimal valorUnitario) {
		
		PedidoItem item = new PedidoItem();
		
		item.setDescricao(descricao);
		item.setQuantidade(quantidade);
		item.setValorUnitario(valorUnitario);
		
		// Cria a lista de itens do pedido caso ela nao existir.
		
		if (this.instancia.getItens() == null) {
			this.instancia.setItens(new ArrayList<PedidoItem>());
		}
		
		this.instancia.getItens().add(item);
		
		return this;

	}
	
	private void definirCliente(String nome, boolean vip) {
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setVip(vip);
		this.instancia.setCliente(cliente);
	}
	
	
}
