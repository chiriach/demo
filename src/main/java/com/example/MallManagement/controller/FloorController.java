package com.example.MallManagement.controller;

import com.example.MallManagement.model.Floor;
import com.example.MallManagement.service.FloorService;
import com.example.MallManagement.service.MallService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/floors")
public class FloorController {

    private final FloorService floorService;
    private final MallService mallService;

    @Autowired
    public FloorController(FloorService floorService, MallService mallService) {
        this.floorService = floorService;
        this.mallService = mallService;
    }

    @GetMapping
    public String listFloors(Model model) {
        model.addAttribute("floors", floorService.findAll());
        return "floor/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("floor", new Floor());
        model.addAttribute("malls", mallService.findAll()); // Für Dropdown
        return "floor/form";
    }

    @PostMapping
    public String createFloor(@Valid @ModelAttribute Floor floor, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("malls", mallService.findAll());
            return "floor/form";
        }
        floorService.save(floor);
        return "redirect:/floors";
    }

    @PostMapping("/{id}/delete")
    public String deleteFloor(@PathVariable Long id) {
        floorService.delete(id);
        return "redirect:/floors";
    }

    @GetMapping("/{id}/update")
    public String showEditForm(@PathVariable Long id, Model model) {
        Floor floor = floorService.findById(id);
        if (floor == null) return "redirect:/floors";

        model.addAttribute("floor", floor);
        model.addAttribute("malls", mallService.findAll());
        return "floor/form";
    }

    @PostMapping("/{id}/update")
    public String updateFloor(@PathVariable Long id, @Valid @ModelAttribute Floor updatedFloor, BindingResult result, Model model) {
        if (result.hasErrors()) {
            updatedFloor.setId(id);
            model.addAttribute("malls", mallService.findAll());
            return "floor/form";
        }
        updatedFloor.setId(id);
        floorService.save(updatedFloor);
        return "redirect:/floors";
    }
}