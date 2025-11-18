package com.example.MallManagement.controller;

import com.example.MallManagement.model.SecurityStaff;
import com.example.MallManagement.service.SecurityStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        model.addAttribute("staff", new SecurityStaff(null, "", "", 0));
        return "security_staff/form";
    }

    @PostMapping
    public String createStaff(@ModelAttribute SecurityStaff staff) {
        service.add(staff);
        return "redirect:/security_staff";
    }

    @PostMapping("/{id}/delete")
    public String deleteStaff(@PathVariable String id) {
        service.delete(id);
        return "redirect:/security_staff";
    }
}
