package com.example.MallManagement.service;

import com.example.MallManagement.model.Customer;
import com.example.MallManagement.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends com.example.MallManagement.service.Service<Customer> {

    public CustomerService(CustomerRepository customerRepo) {
        super(customerRepo);
    }
}
