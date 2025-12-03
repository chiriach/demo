package com.example.MallManagement.controller;

import com.example.MallManagement.model.ElectricalAsset;
import com.example.MallManagement.service.ElectricalAssetService;
import com.example.MallManagement.service.FloorService;
import jakarta.validation.Valid; // Falls Validierung auf Asset-Ebene existiert
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/assets")
public class ElectricalAssetController {

    private final ElectricalAssetService assetService;
    private final FloorService floorService;

    @Autowired
    public ElectricalAssetController(ElectricalAssetService assetService, FloorService floorService) {
        this.assetService = assetService;
        this.floorService = floorService;
    }

    @GetMapping
    public String listAssets(Model model) {
        model.addAttribute("assets", assetService.findAll());
        return "asset/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("asset", new ElectricalAsset());
        model.addAttribute("floors", floorService.findAll());
        return "asset/form";
    }

    @PostMapping
    public String createAsset(@ModelAttribute ElectricalAsset asset) {
        // Hinweis: Hier könnte man @Valid hinzufügen, wenn Constraints im Model sind
        assetService.save(asset);
        return "redirect:/assets";
    }

    @PostMapping("/{id}/delete")
    public String deleteAsset(@PathVariable Long id) {
        assetService.delete(id);
        return "redirect:/assets";
    }

    @GetMapping("/{id}/update")
    public String showEditForm(@PathVariable Long id, Model model) {
        ElectricalAsset asset = assetService.findById(id);
        if (asset == null) return "redirect:/assets";

        model.addAttribute("asset", asset);
        model.addAttribute("floors", floorService.findAll());
        return "asset/form";
    }

    @PostMapping("/{id}/update")
    public String updateAsset(@PathVariable Long id, @ModelAttribute ElectricalAsset updatedAsset) {
        updatedAsset.setId(id);
        assetService.save(updatedAsset);
        return "redirect:/assets";
    }
}