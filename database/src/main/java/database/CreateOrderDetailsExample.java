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

	public void createOrderDetails(Scanner sc) {
		System.out.print("Enter a product name to add to your order: ");
		String productName = sc.nextLine();

		List<Product> products = productDAO.findByProductName(productName);

		if (products.size() == 0) {
			System.out.println("Invalid product name!");
			System.exit(0);
		}

		System.out.println("Product ID	Product Name");
		for (Product product : products) {
			System.out.println(product.getId() + "\t\t" + product.getProductName());
		}

		System.out.print("Select product ID: ");
		Integer productId = sc.nextInt();

		Product p = productDAO.findById(productId);

		if (p == null) {
			System.out.println("Invalid product ID!");
			System.exit(0);
		}

		System.out.print("Select order ID: ");
		Integer orderId = sc.nextInt();

		Order o = orderDao.findById(orderId);

		if (o == null) {
			System.out.println("Invalid order number!");
			System.exit(0);
		}

		for (OrderDetail orderDetail : o.getOrderDetail()) {
			if (orderDetail.getProduct().getId() == productId) {
				System.out.println(
						"The product " + p.getProductName() + " is already part of the order. can not add again");
				System.exit(0);
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
		Scanner sc = new Scanner(System.in);

		CreateOrderDetailsExample cod = new CreateOrderDetailsExample();
		cod.createOrderDetails(sc);
	}
}
