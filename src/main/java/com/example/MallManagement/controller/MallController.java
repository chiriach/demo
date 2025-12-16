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

    @GetMapping("/{id}/details")
    public String showDetails(@PathVariable Long id, Model model) {
        Mall mall = mallService.findById(id);
        if (mall == null) return "redirect:/malls";
        model.addAttribute("mall", mall);
        return "mall/details";
    }

    @GetMapping
    public String listMalls(
            @RequestParam(required = false) String searchTerm,
            @RequestParam(required = false, defaultValue = "name") String searchAttribute,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String direction,
            Model model
    ) {
        model.addAttribute(
                "malls",
                mallService.findFiltered(searchTerm, searchAttribute, sortBy, direction)
        );

        model.addAttribute("searchTerm", searchTerm);
        model.addAttribute("searchAttribute", searchAttribute);
        model.addAttribute("sortBy", sortBy);
        model.addAttribute("direction", direction);

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
    public String updateMall(@PathVariable Long id,
                             @Valid @ModelAttribute Mall updatedMall,
                             BindingResult result) {
        if (result.hasErrors()) {
            updatedMall.setId(id);
            return "mall/form";
        }
        updatedMall.setId(id);
        mallService.save(updatedMall);
        return "redirect:/malls";
    }
}
