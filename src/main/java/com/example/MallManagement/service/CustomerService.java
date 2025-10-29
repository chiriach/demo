package com.example.MallManagement.service;

import com.example.MallManagement.model.Customer;
import com.example.MallManagement.repository.CustomerRepository;

import java.util.*;

public class CustomerService {
    private final CustomerRepository customerRepo;

    public CustomerService(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    public void addCustomer(Customer customer) {
        customerRepo.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    public Customer findCustomer(String id) {
        return customerRepo.findById(id);
    }

    public void deleteCustomer(String id) {
        customerRepo.delete(id);
    }
}
