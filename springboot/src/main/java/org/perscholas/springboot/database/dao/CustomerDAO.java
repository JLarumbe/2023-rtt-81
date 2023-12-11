package org.perscholas.springboot.database.dao;

import org.perscholas.springboot.database.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Long> {
    Customer findById(Integer id);

    @Query("select c from Customer c where c.firstName = :firstName")
    List<Customer> findByFirstName(String firstName);

    //@Query("select c from Customer c where c.firstName = :firstName OR c.lastName = :lastName")
    @Query("SELECT c FROM Customer c WHERE LOWER(c.firstName) LIKE LOWER(concat('%', :firstName, '%')) OR LOWER(c.lastName) LIKE LOWER(concat('%', :lastName, '%'))")
    List<Customer> findByFirstNameOrLastName(String firstName, String lastName);

    List<Customer> findByUserId(Integer userId);
}
