package com.example.MallManagement.controller;

import com.example.MallManagement.model.Purchase;
import com.example.MallManagement.service.CustomerService;
import com.example.MallManagement.service.PurchaseService;
import com.example.MallManagement.service.ShopService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/purchases")
public class PurchaseController {

    private final PurchaseService purchaseService;
    private final CustomerService customerService;
    private final ShopService shopService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService, CustomerService customerService, ShopService shopService) {
        this.purchaseService = purchaseService;
        this.customerService = customerService;
        this.shopService = shopService;
    }

    @GetMapping
    public String listPurchases(Model model) {
        model.addAttribute("purchases", purchaseService.findAll());
        return "purchase/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("purchase", new Purchase());
        model.addAttribute("customers", customerService.findAll());
        model.addAttribute("shops", shopService.findAll());
        return "purchase/form";
    }

    @PostMapping
    public String createPurchase(@Valid @ModelAttribute Purchase purchase, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("customers", customerService.findAll());
            model.addAttribute("shops", shopService.findAll());
            return "purchase/form";
        }
        purchaseService.save(purchase);
        return "redirect:/purchases";
    }

    @PostMapping("/{id}/delete")
    public String deletePurchase(@PathVariable Long id) {
        purchaseService.delete(id);
        return "redirect:/purchases";
    }

    @GetMapping("/{id}/update")
    public String showEditForm(@PathVariable Long id, Model model) {
        Purchase purchase = purchaseService.findById(id);
        if (purchase == null) return "redirect:/purchases";

        model.addAttribute("purchase", purchase);
        model.addAttribute("customers", customerService.findAll());
        model.addAttribute("shops", shopService.findAll());
        return "purchase/form";
    }

    @PostMapping("/{id}/update")
    public String updatePurchase(@PathVariable Long id, @Valid @ModelAttribute Purchase updatedPurchase, BindingResult result, Model model) {
        if (result.hasErrors()) {
            updatedPurchase.setId(id);
            model.addAttribute("customers", customerService.findAll());
            model.addAttribute("shops", shopService.findAll());
            return "purchase/form";
        }
        updatedPurchase.setId(id);
        purchaseService.save(updatedPurchase);
        return "redirect:/purchases";
    }
}