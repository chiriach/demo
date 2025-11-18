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

    @GetMapping("/{id}/update")
    public String showEditForm(@PathVariable String id, Model model) {
        SecurityStaff staff = service.findById(id);
        if (staff == null) return "redirect:/security_staff";

        model.addAttribute("staff", staff);
        return "security_staff/form";
    }

    @PostMapping("/{id}/update")
    public String updateStaff(@PathVariable String id,
                              @ModelAttribute SecurityStaff updatedStaff) {

        service.update(id, updatedStaff);
        return "redirect:/security_staff";
    }

}
