package org.perscholas.springboot.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.perscholas.springboot.database.dao.CustomerDAO;
import org.perscholas.springboot.database.entity.Customer;
import org.perscholas.springboot.database.entity.User;
import org.perscholas.springboot.formbean.CreateCustomerFormBean;
import org.perscholas.springboot.security.AuthenticatedUserService;
import org.perscholas.springboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class CustomerController {
    @Autowired
    private CustomerDAO customerDao;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    @GetMapping("/customer/search")
    public ModelAndView search(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName) {
        ModelAndView response = new ModelAndView("customer/search");

        log.debug("In the customer search controller method : search parameter = " + firstName + " " + lastName);

        if (firstName != null && lastName != null) {
            List<Customer> customers = customerDao.findByFirstNameOrLastName(firstName, lastName);

            response.addObject("customers", customers);
            response.addObject("firstName", firstName);
            response.addObject("lastName", lastName);

            for (Customer customer : customers) {
                log.debug("Customer : " + customer.getId() + " " + customer.getFirstName() + " " + customer.getLastName());
            }
        }

        return response;
    }

    @GetMapping("/customer/create")
    public ModelAndView createCustomer() {
        ModelAndView response = new ModelAndView("customer/create");

        log.debug("In create customer with no args");

        return response;
    }

    @GetMapping("/customer/edit/{id}")
    public ModelAndView editCustomer(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("customer/create");

        Customer customer = customerDao.findById(id);

        CreateCustomerFormBean form = new CreateCustomerFormBean();

        if (customer != null) {
            form.setId(customer.getId());
            form.setFirstName(customer.getFirstName());
            form.setLastName(customer.getLastName());
            form.setCity(customer.getCity());
            form.setPhone(customer.getPhone());
            form.setImageUrl(customer.getImageUrl());
        } else {
            log.warn("Customer with id " + id + " was not be found!");
        }

        response.addObject("form", form);

        return response;
    }

    @GetMapping("/customer/createSubmit")
    public ModelAndView createCustomerSubmit(@Valid CreateCustomerFormBean form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.info("######################### In create customer submit - has errors #########################");
            ModelAndView response = new ModelAndView("customer/create");

            for (ObjectError error : bindingResult.getAllErrors()) {
                log.info("error: " + error.getDefaultMessage());
            }

            response.addObject("form", form);
            response.addObject("errors", bindingResult);
            return response;
        }

        log.info("######################### In create customer submit - no error found #########################");

        Customer c = customerService.createCustomer(form);
        ModelAndView response = new ModelAndView("customer/create");
        return response;
    }

    @GetMapping("/customer/myCustomers")
    public void myCustomers() {
        User user = authenticatedUserService.loadCurrentUser();
        List<Customer> customers = customerDao.findByUserId(user.getId());

        log.debug("Customer(s) created by user: " + user.getEmail());

        for (Customer customer : customers) {
            log.debug("Customer : " + customer.getId() + " " + customer.getFirstName() + " " + customer.getLastName());
        }
    }

    
}
