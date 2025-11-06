package com.example.MallManagement.service;

import com.example.MallManagement.model.Purchase;
import com.example.MallManagement.repository.PurchaseRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PurchaseService extends com.example.MallManagement.service.Service<Purchase> {

    public PurchaseService(PurchaseRepository purchaseRepo) {
        super(purchaseRepo);
    }
}
