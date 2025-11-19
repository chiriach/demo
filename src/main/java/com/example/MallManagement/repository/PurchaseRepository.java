package com.example.MallManagement.repository;

import com.example.MallManagement.model.Customer;
import com.example.MallManagement.model.Floor;
import com.example.MallManagement.model.MaintenanceTask;
import com.example.MallManagement.model.Purchase;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@org.springframework.stereotype.Repository
public class PurchaseRepository extends InFileRepository<Purchase> implements RepositoryInterface<Purchase> {


    public PurchaseRepository() {
//        Purchase p1 = new Purchase(String.valueOf(idGenerator.getAndIncrement()), "1", "1", 250.0);
//        Purchase p2 = new Purchase(String.valueOf(idGenerator.getAndIncrement()), "2", "1", 89.99);
//        super.save(p1);
//        super.save(p2);
        super("src/main/resources/data/purchase.json", Purchase.class);
    }

}
