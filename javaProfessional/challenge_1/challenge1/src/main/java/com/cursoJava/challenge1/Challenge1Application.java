package com.cursoJava.challenge1;

import com.cursoJava.challenge1.model.Order;
import com.cursoJava.challenge1.service.OrderService;
import com.cursoJava.challenge1.service.ShippingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Challenge1Application implements CommandLineRunner {

	private final OrderService orderService;

	public Challenge1Application(OrderService orderService) {
		this.orderService = orderService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Challenge1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Order order1 = new Order(1034,150.00,20.0);
		Order order2 = new Order(2282,800.00,10.0);
		Order order3 = new Order(1309,95.90,0.0);

		System.out.println(text(order1,orderService.total(order1)));
		System.out.println(text(order2,orderService.total(order2)));
		System.out.println(text(order3,orderService.total(order3)));
	}

	private String text(Order order, double totalValue){
		return "Código: " + order.getCode() + "\n" +
				"Valor total: " + totalValue + "\n";
	}
}
