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
        return "electrical/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("asset", new ElectricalAsset("", "", ElectricalAsset.Type.Lift, ElectricalAsset.Status.Working));
        return "electrical/form";
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
}
