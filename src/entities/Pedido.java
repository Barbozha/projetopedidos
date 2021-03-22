package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import entities.enums.Status;

public class Pedido {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private Date momento;
	private Status situacao;
	
	private Cliente cliente;
	private List<ItemPedido> itens = new ArrayList<>();
	
	public Pedido() {
		
	}

	public Pedido(Date momento, Status situacao, Cliente cliente) {
		this.momento = momento;
		this.situacao = situacao;
		this.cliente = cliente;
	}

	public Date getMomento() {
		return momento;
	}

	public void setMomento(Date momento) {
		this.momento = momento;
	}

	public Status getSituacao() {
		return situacao;
	}

	public void setSituacao(Status situacao) {
		this.situacao = situacao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void adicionarPedido(ItemPedido item) {
		itens.add(item);
	}
	
	public void removerPedido(ItemPedido item) {
		itens.remove(item);
	}
	ItemPedido item = new ItemPedido();
	public double total() {
		double tot;
		tot = item.calcularSubTotal();
		return tot;
	}
	
	public String toString() {
		Locale.setDefault(Locale.US);
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY: \n");
		sb.append("Order moment: ");
		sb.append(sdf.format(this.getMomento())+"\n");
		sb.append("Order status: ");
		sb.append(this.getSituacao()+"\n");
		sb.append("Client: ");
		sb.append(this.getCliente().getNomeCliente()+" - ");
		sb.append(this.getCliente().getEmail()+"\n");
		sb.append("Order items: \n");
		double soma = 0;
		for(ItemPedido prod : itens) {
			sb.append(prod.getProduto().getNome()+" , Quantity: "+prod.getQuantidade()+" , Subtotal: $"+String.format("%.2f%n", prod.calcularSubTotal()));
			soma += prod.calcularSubTotal();
		}
		sb.append("Total price: $"+String.format("%.2f%n", soma));
		return sb.toString();
	}
	
	
	
}
