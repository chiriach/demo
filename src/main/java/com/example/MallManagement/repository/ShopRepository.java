package com.example.MallManagement.repository;
import com.example.MallManagement.model.Shop;

import java.util.*;

public class ShopRepository implements Repository<Shop> {
    private final List<Shop> shops = new ArrayList<>();

    @Override
    public void save(Shop shop) {
        delete(shop.getId());
        shops.add(shop);
    }

    @Override
    public List<Shop> findAll() {
        return new ArrayList<>(shops);
    }

    @Override
    public Shop findById(String id) {
        for (Shop s : shops)
            if (s.getId().equals(id))
                return s;
        return null;
    }

    @Override
    public void delete(String id) {
        shops.removeIf(s -> s.getId().equals(id));
    }
}
