package com.example.MallManagement.repository;

import com.example.MallManagement.model.Purchase;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@org.springframework.stereotype.Repository
public class PurchaseRepository implements Repository<Purchase> {

    private final List<Purchase> purchases = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public PurchaseRepository() {
        // Sample data
        Purchase p1 = new Purchase(String.valueOf(idGenerator.getAndIncrement()), "1", "1", 250.0);
        Purchase p2 = new Purchase(String.valueOf(idGenerator.getAndIncrement()), "2", "1", 89.99);

        purchases.add(p1);
        purchases.add(p2);
    }

    @Override
    public void save(Purchase purchase) {
        if (purchase.getId() == null || purchase.getId().isEmpty() || purchase.getId().equals("0")) {
            purchase.setId(String.valueOf(idGenerator.getAndIncrement()));
        } else {
            delete(purchase.getId());
        }
        purchases.add(purchase);
    }

    @Override
    public List<Purchase> findAll() {
        return new ArrayList<>(purchases);
    }

    @Override
    public Purchase findById(String id) {
        for (Purchase p : purchases)
            if (p.getId().equals(id))
                return p;
        return null;
    }

    @Override
    public void delete(String id) {
        purchases.removeIf(p -> p.getId().equals(id));
    }
}
