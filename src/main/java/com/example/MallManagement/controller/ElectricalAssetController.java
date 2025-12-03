package com.example.MallManagement.controller;

import com.example.MallManagement.model.ElectricalAsset;
import com.example.MallManagement.model.Floor;
import com.example.MallManagement.service.ElectricalAssetService;
import com.example.MallManagement.service.FloorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/") // CHANGED: Avoids conflict with static /assets folder
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
    public String createAsset(@Valid @ModelAttribute ElectricalAsset asset,
                              BindingResult result,
                              @RequestParam(value = "floorId", required = false) Long floorId,
                              Model model) {

        // Manual check for relationship
        if (floorId == null) {
            result.rejectValue("floor", "error.floor", "Please select a floor.");
        }

        if (result.hasErrors()) {
            model.addAttribute("floors", floorService.findAll());
            return "asset/form";
        }

        // Link Floor manually
        Floor selectedFloor = floorService.findById(floorId);
        asset.setFloor(selectedFloor);

        assetService.save(asset);
        return "redirect:/electrical-assets";
    }

    @PostMapping("/{id}/delete")
    public String deleteAsset(@PathVariable Long id) {
        assetService.delete(id);
        return "redirect:/electrical-assets";
    }

    @GetMapping("/{id}/update")
    public String showEditForm(@PathVariable Long id, Model model) {
        ElectricalAsset asset = assetService.findById(id);
        if (asset == null) return "redirect:/electrical-assets";

        model.addAttribute("asset", asset);
        model.addAttribute("floors", floorService.findAll());
        return "asset/form";
    }

    @PostMapping("/{id}/update")
    public String updateAsset(@PathVariable Long id,
                              @Valid @ModelAttribute("asset") ElectricalAsset formData,
                              BindingResult result,
                              @RequestParam(value = "floorId", required = false) Long floorId,
                              Model model) {

        if (result.hasErrors()) {
            formData.setId(id);
            model.addAttribute("floors", floorService.findAll());
            return "asset/form";
        }

        ElectricalAsset existingAsset = assetService.findById(id);

        if (existingAsset != null) {
            // 1. Update simple fields
            existingAsset.setType(formData.getType());
            existingAsset.setStatus(formData.getStatus());

            // 2. Update relationship safely
            if (floorId != null) {
                Floor newFloor = floorService.findById(floorId);
                existingAsset.setFloor(newFloor);
            }

            // 3. Save
            assetService.save(existingAsset);
        }

        return "redirect:/electrical-assets";
    }
}