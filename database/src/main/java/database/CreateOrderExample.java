package database;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import database.dao.CustomerDAO;
import database.dao.OrderDAO;
import database.entity.Customer;
import database.entity.Order;

public class CreateOrderExample {
	OrderDAO orderDao = new OrderDAO();
	CustomerDAO customerDAO = new CustomerDAO();

	public void queryCustomer(Integer id) throws ParseException {
		Customer customer = customerDAO.findById(id);

		if (customer != null) {
			System.out.println("Customer found!");
			createOrder(customer);
		} else {
			System.out.println("Customer not found!");
		}
	}

	public void createOrder(Customer customer) throws ParseException {
		Order order = new Order();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date requiredDate = sdf.parse("2023-10-31");
		Date shippedDate = sdf.parse("2023-10-29");

		order.setCustomer(customer);
		order.setOrderDate(new Date());
		order.setRequiredDate(requiredDate);
		order.setShippedDate(shippedDate);
		order.setStatus("In Process");
		order.setComments("Don't lose this package!");

		orderDao.save(order);
	}

	public void queryOrder() {
		Order o = orderDao.findById(10100);

		Customer c = o.getCustomer();

		System.out.println("Order #" + o.getId() + " was made by " + c.getCustomerName() + " on " + o.getOrderDate());

		List<Order> orders = c.getOrders();

		System.out.println("Order made by " + c.getCustomerName());
		for (Order order : orders) {
			System.out.println("Order #" + order.getId());
		}
	}

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);

//		System.out.print("Enter customer ID: ");
//		Integer customerID = sc.nextInt();

		CreateOrderExample ca = new CreateOrderExample();

//		ca.queryCustomer(customerID);

		ca.queryOrder();
	}
}
