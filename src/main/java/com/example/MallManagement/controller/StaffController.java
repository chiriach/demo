package com.example.MallManagement.controller;

import com.example.MallManagement.model.MaintenanceStaff;
import com.example.MallManagement.model.SecurityStaff;
import com.example.MallManagement.model.Staff;
import com.example.MallManagement.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/staff")
public class StaffController {

    private final StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping
    public String listStaff(Model model) {
        model.addAttribute("maintenanceStaffList", staffService.getAllMaintenanceStaff());
        model.addAttribute("securityStaffList", staffService.getAllSecurityStaff());
        return "staff/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("maintenanceStaff", new MaintenanceStaff("0", "", "", 0));
        model.addAttribute("securityStaff", new SecurityStaff("0", "", "", 0));
        return "staff/form";
    }

    @PostMapping("/maintenance")
    public String createMaintenanceStaff(@ModelAttribute MaintenanceStaff staff) {
        staffService.addMaintenanceStaff(staff);
        return "redirect:/staff";
    }

    @PostMapping("/maintenance/{id}/delete")
    public String deleteMaintenanceStaff(@PathVariable String id) {
        staffService.deleteMaintenanceStaff(id);
        return "redirect:/staff";
    }

    @PostMapping("/security")
    public String createSecurityStaff(@ModelAttribute SecurityStaff staff) {
        staffService.addSecurityStaff(staff);
        return "redirect:/staff";
    }

    @PostMapping("/security/{id}/delete")
    public String deleteSecurityStaff(@PathVariable String id) {
        staffService.deleteSecurityStaff(id);
        return "redirect:/staff";
    }
}