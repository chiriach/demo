package com.example.MallManagement.controller;

import com.example.MallManagement.model.Shop;
import com.example.MallManagement.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.*;

@Controller
@RequestMapping("/shops")
public class ShopController {

    private final ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping
    public String listShops(Model model) {
        model.addAttribute("shops", shopService.getAllShops());
        return "shop/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("shop", new Shop("0", "", "", 0.0, 0));
        return "shop/form";
    }

    @PostMapping
    public String createShop(@ModelAttribute Shop shop) {
        shopService.addShop(shop);
        return "redirect:/shops";
    }

    @PostMapping("/{id}/delete")
    public String deleteShop(@PathVariable String id) {
        shopService.deleteShop(id);
        return "redirect:/shops";
    }
}