package com.example.MallManagement.repository;

import com.example.MallManagement.model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository extends InMemoryRepository<Customer> {
    public CustomerRepository() {
        super.save(new Customer(null, "Alice", "USD"));
        super.save(new Customer(null, "Bob", "EUR"));
    }
}
