package com.example.MallManagement.repository;

import com.example.MallManagement.model.Floor;
import com.example.MallManagement.model.Purchase;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@org.springframework.stereotype.Repository
public class PurchaseRepository extends InMemoryRepository<Purchase> implements RepositoryInterface<Purchase> {

    private final List<Purchase> purchases = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public PurchaseRepository() {
        // Sample data
        Purchase p1 = new Purchase(String.valueOf(idGenerator.getAndIncrement()), "1", "1", 250.0);
        Purchase p2 = new Purchase(String.valueOf(idGenerator.getAndIncrement()), "2", "1", 89.99);

        purchases.add(p1);
        purchases.add(p2);
    }

}
