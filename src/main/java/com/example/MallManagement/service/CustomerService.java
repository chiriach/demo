package com.example.MallManagement.service;

import com.example.MallManagement.model.Customer;
import com.example.MallManagement.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepo;

    public CustomerService(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    public void addCustomer(Customer customer) {
        customerRepo.save(customer);
    }

    public void deleteCustomer(String id) {
        customerRepo.delete(id);
    }

    public Customer findCustomer(String id) {
        return customerRepo.findById(id);
    }
}
