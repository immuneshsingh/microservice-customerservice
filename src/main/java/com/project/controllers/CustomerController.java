package com.project.controllers;

import com.project.classes.MyOrders;
import com.project.model.Customer;
import com.project.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/")
    public Customer saveCustomer(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }

    @GetMapping("/myorders/{cid}")
    public MyOrders myProductOrders(@PathVariable("cid") int custId){
        return customerService.getMyOrders(custId);
    }
}
