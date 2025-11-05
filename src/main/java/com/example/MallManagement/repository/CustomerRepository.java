package com.example.MallManagement.repository;

import com.example.MallManagement.model.Customer;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@org.springframework.stereotype.Repository
public class CustomerRepository extends InMemoryRepository<Customer> implements RepositoryInterface<Customer>{

    private final List<Customer> customers = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public CustomerRepository() {
        // Sample data
        Customer c1 = new Customer(String.valueOf(idGenerator.getAndIncrement()), "Alice Braun", "EUR");
        Customer c2 = new Customer(String.valueOf(idGenerator.getAndIncrement()), "John Schmidt", "USD");

        customers.add(c1);
        customers.add(c2);
    }
}
