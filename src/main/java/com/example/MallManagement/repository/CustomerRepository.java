package com.example.MallManagement.repository;

import com.example.MallManagement.model.Customer;
import com.example.MallManagement.model.ElectricalAsset;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository extends InFileRepository<Customer> implements RepositoryInterface<Customer>{
    public CustomerRepository() {
//        super.save(new Customer(null, "Alice", "USD"));
//        super.save(new Customer(null, "Bob", "EUR"));
        super("src/main/resources/data/customer.json", Customer.class);
    }
}
