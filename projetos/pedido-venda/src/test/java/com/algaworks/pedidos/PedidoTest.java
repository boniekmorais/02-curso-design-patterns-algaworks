package com.algaworks.pedidos;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.algaworks.pedidos.builder.PedidoBuilder;
import com.algaworks.pedidos.model.Cliente;
import com.algaworks.pedidos.model.Pedido;
import com.algaworks.pedidos.model.PedidoItem;

public class PedidoTest {

	// Sem usar o padrao Builder
	
	@Test
	public void deveCalcularValorTotalPedidoParaClienteVip() {
		
		Cliente cliente = new Cliente();
		cliente.setNome("João");
		cliente.setVip(true);
		
		PedidoItem item1 = new PedidoItem();
		item1.setDescricao("Calculadora");
		item1.setValorUnitario(new BigDecimal(200.99));
		item1.setQuantidade(2);
		
		PedidoItem item2 = new PedidoItem();
		item2.setDescricao("Mochila");
		item2.setValorUnitario(new BigDecimal(200.56));
		item2.setQuantidade(1);
		
		List<PedidoItem> itens = Arrays.asList(item1, item2);
		
		Pedido pedido = new Pedido();
		
		pedido.setCliente(cliente);
		pedido.setItens(itens);
		
		BigDecimal valorTotal = pedido.getValorTotal();
		
		Assert.assertEquals(new BigDecimal(385.48).doubleValue(), valorTotal.doubleValue(), 0.01);
		
	}
	
	// Usando padrao Builder
	
	@Test
	public void deveCalcularValorTotalPedidoParaClienteVipComBuilder() {
		
		Pedido pedidoVenda = new PedidoBuilder()
										.comClienteVip("João Silva")
										.comItem("Calculadora", 2, BigDecimal.valueOf(200.00))
										.comItem("Mochila", 1, BigDecimal.valueOf(200.00))
										.comNumero("02020")
										.build();
		
		BigDecimal valorTotal = pedidoVenda.getValorTotal();
		
		Assert.assertEquals(BigDecimal.valueOf(576.00).doubleValue(), valorTotal.doubleValue(), 0.0001);
	}
	
}
