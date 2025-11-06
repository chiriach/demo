package com.example.MallManagement.controller;

import com.example.MallManagement.model.Floor;
import com.example.MallManagement.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/floors")
public class FloorController {

    private final FloorService floorService;

    @Autowired
    public FloorController(FloorService floorService) {
        this.floorService = floorService;
    }

    @GetMapping
    public String listFloors(Model model) {
        model.addAttribute("floors", floorService.findAll());
        return "floor/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("floor", new Floor("0", 0));
        return "floor/form";
    }

    @PostMapping
    public String createFloor(@ModelAttribute Floor floor) {
        floorService.add(floor);
        return "redirect:/floors";
    }

    @PostMapping("/{id}/delete")
    public String deleteFloor(@PathVariable String id) {
        floorService.delete(id);
        return "redirect:/floors";
    }
}
