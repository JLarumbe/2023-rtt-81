package org.perscholas.springboot.service;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.springboot.database.dao.CustomerDAO;
import org.perscholas.springboot.database.entity.Customer;
import org.perscholas.springboot.database.entity.User;
import org.perscholas.springboot.formbean.CreateCustomerFormBean;
import org.perscholas.springboot.security.AuthenticatedUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerService {
    @Autowired
    AuthenticatedUserService authenticatedUserService;
    @Autowired
    private CustomerDAO customerDao;

    public Customer createCustomer(CreateCustomerFormBean form) {
        log.debug("id" + form.getId());
        log.debug("firstName: " + form.getFirstName());
        log.debug("lastName: " + form.getLastName());
        log.debug("phone: " + form.getPhone());
        log.debug("city: " + form.getCity());

        Customer customer = customerDao.findById(form.getId());

        if (customer == null) {
            customer = new Customer();

            User user = authenticatedUserService.loadCurrentUser();
            customer.setUserId(user.getId());
        }

        customer.setFirstName(form.getFirstName());
        customer.setLastName(form.getLastName());
        customer.setPhone(form.getPhone());
        customer.setCity(form.getCity());
        customer.setImageUrl(form.getImageUrl());


        return customerDao.save(customer);
    }


}
