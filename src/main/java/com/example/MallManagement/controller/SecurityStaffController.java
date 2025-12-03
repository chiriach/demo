package com.example.MallManagement.controller;

import com.example.MallManagement.model.SecurityStaff;
import com.example.MallManagement.service.SecurityStaffService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/security_staff")
public class SecurityStaffController {

    private final SecurityStaffService service;

    @Autowired
    public SecurityStaffController(SecurityStaffService service) {
        this.service = service;
    }

    @GetMapping
    public String listStaff(Model model) {
        model.addAttribute("staffList", service.findAll());
        return "security_staff/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("staff", new SecurityStaff());
        return "security_staff/form";
    }

    @PostMapping
    public String createStaff(@Valid @ModelAttribute("staff") SecurityStaff staff, BindingResult result) {
        if (result.hasErrors()) {
            return "security_staff/form";
        }
        service.save(staff);
        return "redirect:/security_staff";
    }

    @PostMapping("/{id}/delete")
    public String deleteStaff(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/security_staff";
    }

    @GetMapping("/{id}/update")
    public String showEditForm(@PathVariable Long id, Model model) {
        SecurityStaff staff = service.findById(id);
        if (staff == null) return "redirect:/security_staff";
        model.addAttribute("staff", staff);
        return "security_staff/form";
    }

    @PostMapping("/{id}/update")
    public String updateStaff(@PathVariable Long id, @Valid @ModelAttribute("staff") SecurityStaff updatedStaff, BindingResult result) {
        if (result.hasErrors()) {
            updatedStaff.setId(id);
            return "security_staff/form";
        }
        updatedStaff.setId(id);
        service.save(updatedStaff);
        return "redirect:/security_staff";
    }
}