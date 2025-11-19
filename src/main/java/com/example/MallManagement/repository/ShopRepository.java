package com.example.MallManagement.repository;

import com.example.MallManagement.model.Customer;
import com.example.MallManagement.model.Floor;
import com.example.MallManagement.model.MaintenanceTask;
import com.example.MallManagement.model.Shop;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@org.springframework.stereotype.Repository
public class ShopRepository extends InFileRepository<Shop> implements RepositoryInterface<Shop>{

    public ShopRepository() {
//        Shop shop1 = new Shop(null, "TechZone", "Alice Weber", 120.5, 5);
//        Shop shop2 = new Shop(null, "BookNest", "Markus Klein", 85.0, 4);
//        super.save(shop1);
//        super.save(shop2);
        super("src/main/resources/data/shop.json", Shop.class);
    }

}
