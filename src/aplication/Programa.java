package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Cliente;

//import javax.net.ssl.SSLEngineResult.Status;

import entities.ItemPedido;
import entities.Pedido;
import entities.Produto;
import entities.enums.Status;
public class Programa {

	public static void main(String[] args) throws ParseException {
		// Ler os dados de um pedido com N itens (N fornecido pelo usuário). 
		// Depois, mostrar um sumário do pedido conforme exemplo (próxima página). 
		// Nota: o instante do pedido deve ser o instante do sistema: new Date()
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter cliente data:");
		@SuppressWarnings("unused")
		String nome;
		@SuppressWarnings("unused")
		String email;
		@SuppressWarnings("unused")
		Date datanasc;
		int num;
		String nomeProduto;
		double preco;
		int qtd;
		Cliente cliente;
		Pedido pedido = new Pedido();
		Produto produt = new Produto();
		ItemPedido itemPed = new ItemPedido();
		Date momento = new Date();
		
		System.out.print("Name: ");
		nome = sc.nextLine();
		System.out.print("Email: ");
		email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		datanasc = sdf.parse(sc.next());
		
		cliente = new Cliente(nome, email, datanasc);
		
		System.out.println("Enter com os dados do Pedido:");
		System.out.println("Status: ");
		Status status = Status.valueOf(sc.next());
		
		pedido = new Pedido(momento, status, cliente);
		
		System.out.print("Quantos ítens nesse pedido? ");
		num = sc.nextInt();
		for(int i=1 ; i <= num ; i++) {
			System.out.println("Entre com #"+i+" item do pedido:");
			System.out.print("Nome do Produto: ");
			sc.nextLine();
			nomeProduto = sc.nextLine();
			System.out.print("Preço do Produto: ");
			preco = sc.nextDouble();
			
			produt = new Produto(nomeProduto, preco);
			
			System.out.print("Quantidade: ");
			qtd = sc.nextInt();
			
			itemPed = new ItemPedido(qtd, preco, produt);
			
			pedido.adicionarPedido(itemPed);	
			
		}

		System.out.println(pedido);
		sc.close();
	}

}
