package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
	
		Locale.setDefault(Locale.US);
		
		Scanner tec = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy" );
		
		System.out.println("Insira os dados do cliente:");
		System.out.print("Nome: ");
		String name = tec.nextLine();
		
		System.out.print("Email: ");
		String email = tec.nextLine();
		
		System.out.print("Data de aniversário (DD/MM/AAAA): ");
		Date birthDate = sdf.parse(tec.next());
		
		Client client = new Client(name, email, birthDate);
		
		System.out.println("Insira os dados do pedido");
		
		System.out.print("Estatus: ");
		OrderStatus status = OrderStatus.valueOf(tec.next());
		
		System.out.print("Quantos itens para este pedido?");
		int n = tec.nextInt();
		
		Order order = new Order(new Date(), status, client);
		
		for(int i = 0; i < n; i++) {
			System.out.println("Insira os dados do " +(i + 1) + "º item:");
			System.out.print("Nome do Produto: ");
			tec.nextLine();
			String productName = tec.next();
			
			System.out.print("Preço do Produto: ");
			double productPrice = tec.nextDouble();
			
			System.out.print("Quantidade: ");
			int quantity = tec.nextInt();
			
			Product product = new Product(productName, productPrice);
			
			OrderItem it = new OrderItem(quantity, productPrice, product);
			
			order.addItem(it);
			
		}
		
		System.out.println();
		System.out.println("RESUMO DO PEDIDO:ALEX");
		System.out.println(order);
		tec.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
