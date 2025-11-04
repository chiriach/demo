package com.example.MallManagement.controller;

import com.example.MallManagement.model.Floor;
import com.example.MallManagement.service.FloorService;
import com.example.MallManagement.service.MallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/malls/{mallId}/floors")
public class FloorController {

    private final FloorService floorService;
    private final MallService mallService;

    @Autowired
    public FloorController(FloorService floorService, MallService mallService) {
        this.floorService = floorService;
        this.mallService = mallService;
    }

    @GetMapping("/new")
    public String showCreateForm(@PathVariable String mallId, Model model) {
        model.addAttribute("mallId", mallId);
        model.addAttribute("floor", new Floor("0", 0));
        return "floor/form";
    }

    @PostMapping
    public String createFloor(@PathVariable String mallId, @ModelAttribute Floor floor) {
        mallService.addFloorToMall(mallId, floor);
        return "redirect:/malls";
    }
}

//    @PostMapping("/{floorId}/delete")
//    public String deleteFloor(@PathVariable String mallId, @PathVariable String floorId) {
//        mallService.deleteFloorFromMall(mallId, floorId);
//        return "redirect:/malls";
//    }
//}