package com.example.MallManagement.controller;

import com.example.MallManagement.model.Purchase;
import com.example.MallManagement.service.PurchaseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.*;

@Controller
@RequestMapping("/purchases")
public class PurchaseController {
    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping
    public String listPurchases(Model model) {
        model.addAttribute("purchases", purchaseService.getAllPurchases());
        return "purchases"; // → purchases.html
    }

    @PostMapping("/add")
    @ResponseBody
    public String makePurchase(@RequestBody Purchase purchase) {
        purchaseService.makePurchase(purchase);
        return "Kauf erfolgreich!";
    }
}
