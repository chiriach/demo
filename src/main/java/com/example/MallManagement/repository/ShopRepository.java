package com.example.MallManagement.repository;

import com.example.MallManagement.model.Shop;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@org.springframework.stereotype.Repository
public class ShopRepository implements Repository<Shop> {

    private final List<Shop> shops = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public ShopRepository() {
        Shop shop1 = new Shop(String.valueOf(idGenerator.getAndIncrement()), "TechZone", "Alice Weber", 120.5, 5);
        Shop shop2 = new Shop(String.valueOf(idGenerator.getAndIncrement()), "BookNest", "Markus Klein", 85.0, 4);

        shops.add(shop1);
        shops.add(shop2);
    }

    @Override
    public void save(Shop shop) {
        // Auto-generate ID if needed
        if (shop.getId() == null || shop.getId().isEmpty() || shop.getId().equals("0")) {
            shop.setId(String.valueOf(idGenerator.getAndIncrement()));
        } else {
            delete(shop.getId());
        }
        shops.add(shop);
    }

    @Override
    public List<Shop> findAll() {
        return new ArrayList<>(shops);
    }

    @Override
    public Shop findById(String id) {
        for (Shop s : shops) {
            if (s.getId().equals(id)) {
                return s;
            }
        }
        return null;
    }

    @Override
    public void delete(String id) {
        shops.removeIf(s -> s.getId().equals(id));
    }
}
