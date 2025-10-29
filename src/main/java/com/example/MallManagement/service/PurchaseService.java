package com.example.MallManagement.service;

import com.example.MallManagement.model.Purchase;
import com.example.MallManagement.repository.CustomerRepository;
import com.example.MallManagement.repository.PurchaseRepository;
import com.example.MallManagement.repository.ShopRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PurchaseService {
    private final PurchaseRepository purchaseRepo;
    private final ShopRepository shopRepo;
    private final CustomerRepository customerRepo;

    public PurchaseService(PurchaseRepository purchaseRepo, ShopRepository shopRepo, CustomerRepository customerRepo) {
        this.purchaseRepo = purchaseRepo;
        this.shopRepo = shopRepo;
        this.customerRepo = customerRepo;
    }

    public void makePurchase(Purchase purchase) {

        if (shopRepo.findById(purchase.getShopId()) != null &&
                customerRepo.findById(purchase.getCustomerId()) != null) {
            purchaseRepo.save(purchase);
        } else {
            throw new IllegalArgumentException("Invalid shop or customer ID");
        }
    }

    public List<Purchase> getAllPurchases() {
        return purchaseRepo.findAll();
    }

    public Purchase findPurchase(String id) {
        return purchaseRepo.findById(id);
    }

    public void deletePurchase(String id) {
        purchaseRepo.delete(id);
    }
}
