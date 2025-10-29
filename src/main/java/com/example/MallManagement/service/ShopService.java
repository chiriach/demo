package com.example.MallManagement.service;

import com.example.MallManagement.model.Shop;
import com.example.MallManagement.repository.ShopRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShopService {
    private final ShopRepository shopRepo;

    public ShopService(ShopRepository shopRepo) {
        this.shopRepo = shopRepo;
    }

    public void addShop(Shop shop) {
        shopRepo.save(shop);
    }

    public List<Shop> getAllShops() {
        return shopRepo.findAll();
    }

    public Shop findShop(String id) {
        return shopRepo.findById(id);
    }

    public void deleteShop(String id) {
        shopRepo.delete(id);
    }
}
