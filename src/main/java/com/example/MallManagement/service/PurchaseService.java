package com.example.MallManagement.service;

import com.example.MallManagement.model.Purchase;
import com.example.MallManagement.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

    // -------- FILTER + SORT (ADDED) --------
    public List<Purchase> filter(String value, String field, String dir) {
        Sort sort = dir.equalsIgnoreCase("desc")
                ? Sort.by(field).descending()
                : Sort.by(field).ascending();

        List<Purchase> purchases = purchaseRepo.findAll(sort);

        if (value == null || value.isBlank()) return purchases;

        return purchases.stream()
                .filter(p ->
                        String.valueOf(p.getAmount()).contains(value) ||
                                (p.getCustomer() != null &&
                                        p.getCustomer().getName().toLowerCase().contains(value.toLowerCase())) ||
                                (p.getShop() != null &&
                                        p.getShop().getName().toLowerCase().contains(value.toLowerCase()))
                )
                .toList();
    }

    // -------- ORIGINAL METHODS --------

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
