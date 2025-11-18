package com.example.MallManagement.controller;

import com.example.MallManagement.model.ElectricalAsset;
import com.example.MallManagement.service.ElectricalAssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/assets")
public class ElectricalAssetController {

    private final ElectricalAssetService assetService;

    @Autowired
    public ElectricalAssetController(ElectricalAssetService assetService) {
        this.assetService = assetService;
    }

    @GetMapping
    public String listAssets(Model model) {
        model.addAttribute("assets", assetService.findAll());
        return "asset/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("asset", new ElectricalAsset(null, "", ElectricalAsset.Type.Lift, ElectricalAsset.Status.Working));
        return "asset/form";
    }

    @PostMapping
    public String createAsset(@ModelAttribute ElectricalAsset asset) {
        assetService.add(asset);
        return "redirect:/assets";
    }

    @PostMapping("/{id}/delete")
    public String deleteAsset(@PathVariable String id) {
        assetService.delete(id);
        return "redirect:/assets";
    }

    @GetMapping("/{id}/update")
    public String showEditForm(@PathVariable String id, Model model) {
        ElectricalAsset asset = assetService.findById(id);
        if (asset == null) return "redirect:/assets";

        model.addAttribute("asset", asset);
        return "asset/form";
    }

    @PostMapping("/{id}/update")
    public String updateAsset(@PathVariable String id,
                              @ModelAttribute ElectricalAsset updatedAsset) {

        assetService.update(id, updatedAsset);
        return "redirect:/assets";
    }
}
