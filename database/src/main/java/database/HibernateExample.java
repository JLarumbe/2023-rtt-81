package database;

import java.util.List;

import database.dao.CustomerDAO;
import database.dao.OrderDAO;
import database.dao.OrderDetailDAO;
import database.dao.ProductDAO;
import database.entity.Customer;
import database.entity.Order;
import database.entity.OrderDetail;
import database.entity.Product;

public class HibernateExample {

	public static void main(String[] args) {

//		CustomerDAO customerDao = new CustomerDAO();
//
//		Customer customer = customerDao.findById(103);
//
//		System.out.println(customer.getId() + " | " + customer.getCustomerName());

//		ProductDAO productDao = new ProductDAO();
//
//		Product product = productDao.findById(35);
//
//		System.out.println(product.getId() + " | " + product.getProductName());

//		OrderDAO ordersDao = new OrderDAO();
//
//		Order order = ordersDao.findById(10100);
//
//		System.out.println(order.getId() + " | " + order.getRequiredDate());

//		CustomerDAO customerDao = new CustomerDAO();
//		
//		List<Customer> customers = customerDao.findByFirstName("Leslie");
//		
//		for(Customer c: customers) {
//			System.out.println(c.getId() + " | " + c.getContactFirstName() + " | " + c.getContactLastName());
//		}

		OrderDetailDAO orderDetailDao = new OrderDetailDAO();

		OrderDetail orderDetail = orderDetailDao.findById(87);

		System.out.println(orderDetail.getId() + " | " + orderDetail.getOrderLineNumber());
	}

}
