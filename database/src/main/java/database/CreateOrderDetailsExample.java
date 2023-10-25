package database;

import java.util.List;
import java.util.Scanner;

import database.dao.OrderDAO;
import database.dao.OrderDetailDAO;
import database.dao.ProductDAO;
import database.entity.Order;
import database.entity.OrderDetail;
import database.entity.Product;

public class CreateOrderDetailsExample {
	private OrderDAO orderDao = new OrderDAO();
	private ProductDAO productDAO = new ProductDAO();
	private OrderDetailDAO orderDetailDao = new OrderDetailDAO();

	public void createOrderDetails() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a product name to add to your order: ");
		String productName = sc.nextLine();

		List<Product> products = productDAO.findByProductName(productName);

		for (Product product : products) {
			System.out.println(product.getId() + " | " + product.getProductName());
		}

		System.out.println("Select product ID: ");
		Integer productId = sc.nextInt();

		Product p = productDAO.findById(productId);

		Order o = orderDao.findById(10100);

		for (OrderDetail orderDetail : o.getOrderDetail()) {
			if (orderDetail.getProduct().getId() == productId) {
				System.out.println(
						"The product " + p.getProductName() + " is already part of the order. can not add again");
				System.exit(1);
			}
		}

		OrderDetail od = new OrderDetail();
		od.setProduct(p);
		od.setOrder(o);
		od.setOrderLineNumber((short) 200);
		od.setPriceEach(5.55);
		od.setQuantityOrdered(300);

		orderDetailDao.save(od);
	}

	public static void main(String[] args) {
		CreateOrderDetailsExample cod = new CreateOrderDetailsExample();
		cod.createOrderDetails();
	}
}
