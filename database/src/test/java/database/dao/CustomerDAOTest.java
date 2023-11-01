package database.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import database.entity.Customer;

public class CustomerDAOTest {
	@Test
	public void findByIDTest() {
		CustomerDAO customerDao = new CustomerDAO();
		
		Customer actual = customerDao.findById(112);
		
		Assertions.assertEquals(112, actual.getId());
		Assertions.assertEquals("Signal Gift Stores", actual.getCustomerName());
		Assertions.assertEquals("King", actual.getContactLastName());
		
		assertEquals("Jean", actual.getContactFirstName());
	}
}
