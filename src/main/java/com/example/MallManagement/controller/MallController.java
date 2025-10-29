package com.example.MallManagement.controller;

import com.example.MallManagement.model.Mall;
import com.example.MallManagement.service.MallService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.*;

@Controller
@RequestMapping("/malls")
public class MallController {
    private final MallService mallService;

    public MallController(MallService mallService) {
        this.mallService = mallService;
    }

    @GetMapping
    public String listMalls(Model model) {
        List<Mall> malls = mallService.getAllMalls();
        model.addAttribute("malls", malls);
        return "malls"; // → lädt malls.html (aus templates/)
    }

    @PostMapping("/add")
    @ResponseBody
    public String addMall(@RequestBody Mall mall) {
        mallService.addMall(mall);
        return "Mall erfolgreich hinzugefügt!";
    }
}
