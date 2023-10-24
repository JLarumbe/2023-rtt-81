package database;

import java.util.List;

import database.dao.CustomerDAO;
import database.entity.Customer;

public class CreateAndUpdateExample {
	private CustomerDAO customerDao = new CustomerDAO();

	public void insertCustomerExample() {
		Customer c = new Customer();

		c.setCustomerName("Donuts");
		c.setContactFirstName("Bob");
		c.setContactLastName("Larry");
		c.setAddressLine1("Address Line 1");
		c.setAddressLine2("Address Line 2");
		c.setCity("ATL");
		c.setState("GA");
		c.setPostalCode("80203");
		c.setCountry("USA USA USA");
		c.setCreditLimit(10000.00);
		c.setPhone("555-555-5555");
		
		customerDao.save(c);

	}
	
	public void updateCustomerExample() {
		Customer c = customerDao.findById(524);
		
		if(c != null) {
			c.setContactFirstName("Larry");
			c.setContactLastName("Bob");
			
			customerDao.save(c);
		} else {
			System.out.println("Customer does not exist!");
		}
	}
	
	public void listQuery() {
		List<Customer> customers = customerDao.findByFirstName("Larry");
		System.out.println("We found " + customers.size() + " records in the database");
	}

	public static void main(String[] args) {
		CreateAndUpdateExample caue = new CreateAndUpdateExample();
//		caue.insertCustomerExample();
//		caue.updateCustomerExample();
		caue.listQuery();
	}
}
