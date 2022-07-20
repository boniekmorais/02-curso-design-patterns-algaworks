package com.algaworks.pedidos.model;

import java.math.BigDecimal;
import java.util.List;

public class Pedido {

	private String numero;
	
	private Cliente cliente;
	
	private List<PedidoItem> itens;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<PedidoItem> getItens() {
		return itens;
	}

	public void setItens(List<PedidoItem> itens) {
		this.itens = itens;
	}
	
	
	public BigDecimal getValorTotal() {
		
		BigDecimal valorTotal = BigDecimal.ZERO;
		
		for (PedidoItem item : itens) {
			valorTotal = valorTotal.add(item.getValorUnitario().multiply(new BigDecimal(item.getQuantidade())));
		}
		
		// Se cliente VIP conceder 4% de desconto.
		
		if (cliente.isVip()) {
			valorTotal = valorTotal.multiply(new BigDecimal(0.96));
		}
		
		return valorTotal;
	}
}
