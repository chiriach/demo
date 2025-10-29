package com.example.MallManagement.repository;

import com.example.MallManagement.model.Customer;

import java.util.*;

public class CustomerRepository implements Repository<Customer> {
    private final List<Customer> customers = new ArrayList<>();

    @Override
    public void save(Customer customer) {
        delete(customer.getId());
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
