package com.example.MallManagement.service;

import com.example.MallManagement.model.Customer;
import com.example.MallManagement.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepo;

    @Autowired
    public CustomerService(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

    public Customer findById(Long id) {
        return customerRepo.findById(id).orElse(null);
    }

    @Transactional
    public void save(Customer customer) {
        customerRepo.save(customer);
    }

    @Transactional
    public void delete(Long id) { customerRepo.deleteById(id); }

    public List<Customer> findFiltered(String searchTerm, String searchAttribute, String sortBy, String direction) {
        if (searchTerm == null) searchTerm = "";
        if (searchAttribute == null) searchAttribute = "name";

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        return customerRepo.searchByAttribute(searchTerm, searchAttribute, sort);
    }
}