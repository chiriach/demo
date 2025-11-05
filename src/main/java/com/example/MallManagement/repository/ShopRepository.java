package com.example.MallManagement.repository;

import com.example.MallManagement.model.Floor;
import com.example.MallManagement.model.Shop;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@org.springframework.stereotype.Repository
public class ShopRepository extends InMemoryRepository<Shop> implements RepositoryInterface<Shop> {

    private final List<Shop> shops = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public ShopRepository() {
        Shop shop1 = new Shop(String.valueOf(idGenerator.getAndIncrement()), "TechZone", "Alice Weber", 120.5, 5);
        Shop shop2 = new Shop(String.valueOf(idGenerator.getAndIncrement()), "BookNest", "Markus Klein", 85.0, 4);

        shops.add(shop1);
        shops.add(shop2);
    }

}
