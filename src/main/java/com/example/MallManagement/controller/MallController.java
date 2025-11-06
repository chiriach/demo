package com.example.MallManagement.controller;

import com.example.MallManagement.model.Floor;
import com.example.MallManagement.model.Mall;
import com.example.MallManagement.service.MallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/malls")
public class MallController {

    private final MallService mallService;

    @Autowired
    public MallController(MallService mallService) {
        this.mallService = mallService;
    }

    @GetMapping
    public String listMalls(Model model) {
        model.addAttribute("malls", mallService.findAll());
        return "mall/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("mall", new Mall("0", "", ""));
        return "mall/form";
    }

    @PostMapping
    public String createMall(@ModelAttribute Mall mall) {
        mallService.add(mall);
        return "redirect:/malls";
    }

    @PostMapping("/{id}/delete")
    public String deleteMall(@PathVariable String id) {
        mallService.delete(id);
        return "redirect:/malls";
    }

    @GetMapping("/{mallId}/floors/new")
    public String showAddFloorForm(@PathVariable String mallId, Model model) {
        model.addAttribute("mallId", mallId);
        model.addAttribute("floor", new Floor("0", 0));
        return "floor/form";
    }

    @PostMapping("/{mallId}/floors")
    public String addFloorToMall(@PathVariable String mallId, @ModelAttribute Floor floor) {
        mallService.addFloorToMall(mallId, floor);
        return "redirect:/malls";
    }

    @PostMapping("/{mallId}/floors/{floorId}/delete")
    public String deleteFloorFromMall(@PathVariable String mallId, @PathVariable String floorId) {
        mallService.deleteFloorFromMall(mallId, floorId);
        return "redirect:/malls";
    }
}
