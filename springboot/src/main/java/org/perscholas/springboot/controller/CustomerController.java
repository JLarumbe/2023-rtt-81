package org.perscholas.springboot.controller;

import org.perscholas.springboot.formbean.CreateCustomerFormBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
    @GetMapping("/customer/create")
    public ModelAndView createCustomer(CreateCustomerFormBean form) {
        ModelAndView response = new ModelAndView("customer/create");

        System.out.println("firstName: " + form.getFirstName());
        System.out.println("lastName: " + form.getLastName());
        System.out.println("phone: " + form.getPhone());
        System.out.println("city: " + form.getCity());

        return response;
    }
}
