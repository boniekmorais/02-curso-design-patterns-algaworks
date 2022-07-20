package com.algaworks.pedidos.builder;

import com.algaworks.pedidos.model.Pedido;

public class PedidoBuilderValido {

	private Pedido instancia;

	public PedidoBuilderValido(Pedido instancia) {
		this.instancia = instancia;
	}
	
	public Pedido build() {
		return this.instancia;
	}
	
}
