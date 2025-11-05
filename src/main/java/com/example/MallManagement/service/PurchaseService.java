package com.example.MallManagement.service;

import com.example.MallManagement.model.Purchase;
import com.example.MallManagement.repository.PurchaseRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PurchaseService {
    private final PurchaseRepository purchaseRepo;

    public PurchaseService(PurchaseRepository purchaseRepo) {
        this.purchaseRepo = purchaseRepo;
    }

    public List<Purchase> getAllPurchases() {
        return purchaseRepo.findAll();
    }

    public void addPurchase(Purchase purchase) {
        purchaseRepo.save(purchase);
    }

    public void deletePurchase(String id) {
        purchaseRepo.delete(id);
    }

    public Purchase findPurchase(String id) {
        return purchaseRepo.findById(id);
    }
}
