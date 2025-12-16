package com.example.MallManagement.controller;

import com.example.MallManagement.model.Floor;
import com.example.MallManagement.model.Shop;
import com.example.MallManagement.service.FloorService;
import com.example.MallManagement.service.ShopService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/shops")
public class ShopController {

    private final ShopService shopService;
    private final FloorService floorService;

    @Autowired
    public ShopController(ShopService shopService, FloorService floorService) {
        this.shopService = shopService;
        this.floorService = floorService;
    }

    @GetMapping("/floor/{id}")
    public String listShopsByFloor(@PathVariable Long id, Model model) {
        model.addAttribute("shops", shopService.findByFloorId(id));
        return "shop/index";
    }

    @GetMapping
    public String listShops(Model model) {
        model.addAttribute("shops", shopService.findAll());
        return "shop/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("shop", new Shop());
        model.addAttribute("floors", floorService.findAll());
        return "shop/form";
    }

    @PostMapping
    public String createShop(@Valid @ModelAttribute Shop shop,
                             BindingResult result,
                             @RequestParam(value = "floorId", required = false) Long floorId,
                             Model model) {

        if (floorId == null) {
            result.rejectValue("floor", "error.floor", "Please select a floor.");
        }
        if (floorId != null) {
            Floor floor = floorService.findById(floorId);
            if (floor == null) {
                result.rejectValue("floor", "error.floor", "Selected floor does not exist.");
            } else {
                shop.setFloor(floor);
            }
        }
        if (result.hasErrors()) {
            model.addAttribute("floors", floorService.findAll());
            return "shop/form";
        }
        shopService.save(shop);
        return "redirect:/shops";
    }

    @PostMapping("/{id}/update")
    public String updateShop(@PathVariable Long id,
                             @Valid @ModelAttribute Shop updatedShop,
                             BindingResult result,
                             @RequestParam(value = "floorId", required = false) Long floorId,
                             Model model) {

        if (floorId == null) {
            result.rejectValue("floor", "error.floor", "Please select a floor.");
        }
        if (floorId != null && floorService.findById(floorId) == null) {
            result.rejectValue("floor", "error.floor", "Selected floor does not exist.");
        }
        if (result.hasErrors()) {
            updatedShop.setId(id);
            model.addAttribute("floors", floorService.findAll());
            return "shop/form";
        }
        Shop existing = shopService.findById(id);
        if (existing != null) {
            existing.setName(updatedShop.getName());
            existing.setOwnerName(updatedShop.getOwnerName());
            existing.setAreaSqm(updatedShop.getAreaSqm());
            existing.setRating(updatedShop.getRating());
            if (floorId != null) existing.setFloor(floorService.findById(floorId));
            shopService.save(existing);
        }
        return "redirect:/shops";
    }

    @PostMapping("/{id}/delete")
    public String deleteShop(@PathVariable Long id) {
        shopService.delete(id);
        return "redirect:/shops";
    }
}