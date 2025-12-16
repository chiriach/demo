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
@RequestMapping("/electrical-asset")
public class ElectricalAssetController {

    private final ElectricalAssetService assetService;
    private final FloorService floorService;

    @Autowired
    public ElectricalAssetController(ElectricalAssetService assetService, FloorService floorService) {
        this.assetService = assetService;
        this.floorService = floorService;
    }

    @GetMapping
    public String listAssets(
            @RequestParam(required = false) String searchTerm,
            @RequestParam(required = false, defaultValue = "type") String searchAttribute,
            @RequestParam(defaultValue = "type") String sortBy,
            @RequestParam(defaultValue = "asc") String direction,
            Model model
    ) {
        model.addAttribute("assets", assetService.findFiltered(searchTerm, searchAttribute, sortBy, direction));
        model.addAttribute("searchTerm", searchTerm);
        model.addAttribute("searchAttribute", searchAttribute);
        model.addAttribute("sortBy", sortBy);
        model.addAttribute("direction", direction);
        return "asset/index";
    }

    @GetMapping("/floor/{id}")
    public String listAssetsByFloor(@PathVariable Long id, Model model) {
        model.addAttribute("assets", assetService.findByFloorId(id));
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

        if (floorId == null) {
            result.rejectValue("floor", "error.floor", "Please select a floor.");
        }

        if (result.hasErrors()) {
            model.addAttribute("floors", floorService.findAll());
            return "asset/form";
        }

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
            existingAsset.setType(formData.getType());
            existingAsset.setStatus(formData.getStatus());

            if (floorId != null) {
                Floor newFloor = floorService.findById(floorId);
                existingAsset.setFloor(newFloor);
            }

            assetService.save(existingAsset);
        }

        return "redirect:/electrical-assets";
    }
}