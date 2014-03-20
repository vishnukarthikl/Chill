package com.github.vishnukarthik.controller;

import com.github.vishnukarthik.domain.Customer;
import com.github.vishnukarthik.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HomeController {

    private CustomerService customerService;

    @Autowired
    public HomeController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/")
    public String test(HttpServletResponse response) throws IOException {
        return "/layouts/home";
    }

    @RequestMapping(value = "customerDetail", method = RequestMethod.GET)
    @ResponseBody
    public Customer getCustomerDetail(@RequestParam String phone) {
        Customer customer = customerService.getCustomer(Long.parseLong(phone));
        return customer;
    }
}
