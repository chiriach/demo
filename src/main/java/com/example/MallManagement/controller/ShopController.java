package com.example.MallManagement.controller;

import com.example.MallManagement.model.Shop;
import com.example.MallManagement.service.ShopService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.*;

@Controller
@RequestMapping("/shops")
public class ShopController {
    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping
    public String listShops(Model model) {
        List<Shop> shops = shopService.getAllShops();
        model.addAttribute("shops", shops);
        return "shops";
    }

    @PostMapping("/add")
    @ResponseBody
    public String addShop(@RequestBody Shop shop) {
        shopService.addShop(shop);
        return "Shop hinzugefügt!";
    }
}
