package coffeeshop;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoffeeShop {

	List<Product> products = new ArrayList<>();

	Scanner sc = new Scanner(System.in);

	public void setupProducts() {
		Product coffee = new Product();
		coffee.setName("Coffee");
		coffee.setPrice(5.44);
		products.add(coffee);

		Product tea = new Product();
		tea.setName("Tea");
		tea.setPrice(4.33);
		products.add(tea);

		Product cookie = new Product();
		cookie.setName("Cookie");
		cookie.setPrice(6.77);
		products.add(cookie);

		Product sandwich = new Product();
		sandwich.setName("Muffin");
		sandwich.setPrice(5.99);
		products.add(sandwich);
	}

	public void printProduct(Product product) {
		System.out.println("Product name: " + product.getName() + "\tProduct Price: " + product.getPrice());
	}

	public void printAllProducts() {
		for (Product product : products) {
			printProduct(product);
		}
	}

	public int userMenu() {
		System.out.println("1) Print the menu items and prices");
		System.out.println("2) Add an item to your order");
		System.out.println("3) Print the items in your order");
		System.out.println("4) Checkout");

		System.out.println("What do you want to do?");
		int select = sc.nextInt();

		return select;
	}

	public void example() {
		double coffee = 5.44d;
		double tea = 4.33d;
		double cookie = 6.73d;

		double subtotal = 0;

		subtotal = coffee * 1;

		subtotal = subtotal + (tea + 1);

		subtotal = subtotal + (cookie * 1);

		DecimalFormat df = new DecimalFormat("#,##0.00");
		System.out.println("Subtotal: " + df.format(subtotal));

		double salesTax = subtotal + 0.10;
		System.out.println("Sales tax: " + df.format(salesTax));

		double totalSale = subtotal + salesTax;
		System.out.println("Total: " + df.format(totalSale));
	}

	public static void main(String[] args) {
		CoffeeShop cf = new CoffeeShop();
		cf.setupProducts();

		int userSelection = cf.userMenu();

		cf.printAllProducts();
	}

}
