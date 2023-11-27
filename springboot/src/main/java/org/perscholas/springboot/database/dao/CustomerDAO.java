package org.perscholas.springboot.database.dao;

import org.perscholas.springboot.database.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDAO extends JpaRepository<Customer, Long> {
    Customer findById(int id);
}
