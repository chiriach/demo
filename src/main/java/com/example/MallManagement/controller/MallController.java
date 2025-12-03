package com.example.MallManagement.controller;

import com.example.MallManagement.model.Mall;
import com.example.MallManagement.service.MallService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
        model.addAttribute("mall", new Mall());
        return "mall/form";
    }

    @PostMapping
    public String createMall(@Valid @ModelAttribute Mall mall, BindingResult result) {
        if (result.hasErrors()) {
            return "mall/form";
        }
        mallService.save(mall);
        return "redirect:/malls";
    }

    @PostMapping("/{id}/delete")
    public String deleteMall(@PathVariable Long id) {
        mallService.delete(id);
        return "redirect:/malls";
    }

    @GetMapping("/{id}/update")
    public String showEditForm(@PathVariable Long id, Model model) {
        Mall mall = mallService.findById(id);
        if (mall == null) return "redirect:/malls";
        model.addAttribute("mall", mall);
        return "mall/form";
    }

    @PostMapping("/{id}/update")
    public String updateMall(@PathVariable Long id, @Valid @ModelAttribute Mall updatedMall, BindingResult result) {
        if (result.hasErrors()) {
            updatedMall.setId(id); // ID sicherstellen für Formular-URL
            return "mall/form";
        }
        updatedMall.setId(id);
        mallService.save(updatedMall);
        return "redirect:/malls";
    }
}