package com.example.MallManagement.service;

import com.example.MallManagement.model.Purchase;
import com.example.MallManagement.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PurchaseService {

    private final PurchaseRepository purchaseRepo;

    @Autowired
    public PurchaseService(PurchaseRepository purchaseRepo) {
        this.purchaseRepo = purchaseRepo;
    }
    public List<Purchase> findByCustomerId(Long customerId) {
        return purchaseRepo.findByCustomerId(customerId);
    }

    public List<Purchase> findAll() {
        return purchaseRepo.findAll();
    }

    public Purchase findById(Long id) {
        return purchaseRepo.findById(id).orElse(null);
    }



    @Transactional
    public void save(Purchase purchase) {
        purchaseRepo.save(purchase);
    }

    @Transactional
    public void delete(Long id) {
        purchaseRepo.deleteById(id);



    }
}