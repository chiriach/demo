package com.example.MallManagement.repository;

import com.example.MallManagement.model.Purchase;

import java.util.*;

public class PurchaseRepository implements Repository<Purchase> {
    private final List<Purchase> purchases = new ArrayList<>();

    @Override
    public void save(Purchase purchase) {
        delete(purchase.getId());
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
