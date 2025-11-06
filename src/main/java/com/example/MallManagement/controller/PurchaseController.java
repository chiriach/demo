package com.example.MallManagement.controller;

import com.example.MallManagement.model.Purchase;
import com.example.MallManagement.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/purchases")
public class PurchaseController {

    private final PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping
    public String listPurchases(Model model) {
        model.addAttribute("purchases", purchaseService.findAll());
        return "purchase/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("purchase", new Purchase());
        return "purchase/form";
    }

    @PostMapping
    public String createPurchase(@ModelAttribute Purchase purchase) {
        purchaseService.add(purchase);
        return "redirect:/purchases";
    }

    @PostMapping("/{id}/delete")
    public String deletePurchase(@PathVariable String id) {
        purchaseService.delete(id);
        return "redirect:/purchases";
    }
}
