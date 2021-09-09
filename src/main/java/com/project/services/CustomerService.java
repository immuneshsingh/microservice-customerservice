package com.project.services;

import com.project.classes.MyOrders;
import com.project.classes.Product;
import com.project.model.Customer;
import com.project.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    RestTemplate restTemplate;

    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public MyOrders getMyOrders(int custId){
        Optional<Customer> customer1=customerRepository.findById(custId);
        int pid = customer1.get().getPid();

        Product product = restTemplate.getForObject("http://localhost:8001/product/"+pid,Product.class );

        MyOrders myOrders = new MyOrders();
        myOrders.setCustomer(customer1.get());
        myOrders.setProduct(product);

        return myOrders;
        //restTemplate.getForObject("http://localhost:8001/product/"+pid, );
        //return customerRepository.save(customer1);
    }
}
