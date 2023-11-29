package org.perscholas.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.springboot.database.dao.CustomerDAO;
import org.perscholas.springboot.database.entity.Customer;
import org.perscholas.springboot.formbean.CreateCustomerFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class CustomerController {
    @Autowired
    private CustomerDAO customerDao;

    @GetMapping("/customer/search")
    public ModelAndView search(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName) {
        ModelAndView response = new ModelAndView("customer/search");

        log.debug("In the customer search controller method : search parameter = " + firstName + " " + lastName);

        if (firstName != null && lastName != null) {
            List<Customer> customers = customerDao.findByFirstNameAndLastName(firstName, lastName);

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

    @GetMapping("/customer/createSubmit")
    public ModelAndView createCustomerSubmit(CreateCustomerFormBean form) {
        ModelAndView response = new ModelAndView("customer/create");

        System.out.println("firstName: " + form.getFirstName());
        System.out.println("lastName: " + form.getLastName());
        System.out.println("phone: " + form.getPhone());
        System.out.println("city: " + form.getCity());

        Customer customer = new Customer();
        customer.setFirstName(form.getFirstName());
        customer.setLastName(form.getLastName());
        customer.setPhone(form.getPhone());
        customer.setCity(form.getCity());

        customerDao.save(customer);
        log.debug("In create customer with incoming args");

        return response;
    }
}
