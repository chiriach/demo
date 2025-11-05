package com.example.MallManagement.repository;

import com.example.MallManagement.model.Customer;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@org.springframework.stereotype.Repository
public class CustomerRepository implements Repository<Customer> {

    private final List<Customer> customers = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public CustomerRepository() {
        // Sample data
        Customer c1 = new Customer(String.valueOf(idGenerator.getAndIncrement()), "Alice Braun", "EUR");
        Customer c2 = new Customer(String.valueOf(idGenerator.getAndIncrement()), "John Schmidt", "USD");

        customers.add(c1);
        customers.add(c2);
    }

    @Override
    public void save(Customer customer) {
        if (customer.getId() == null || customer.getId().isEmpty() || customer.getId().equals("0")) {
            customer.setId(String.valueOf(idGenerator.getAndIncrement()));
        } else {
            delete(customer.getId());
        }
        customers.add(customer);
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers);
    }

    @Override
    public Customer findById(String id) {
        for (Customer c : customers)
            if (c.getId().equals(id))
                return c;
        return null;
    }

    @Override
    public void delete(String id) {
        customers.removeIf(c -> c.getId().equals(id));
    }
}
