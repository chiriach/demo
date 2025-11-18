package com.example.MallManagement.controller;

import com.example.MallManagement.model.MaintenanceStaff;
import com.example.MallManagement.service.MaintenanceStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/maintenance_staff")
public class MaintenanceStaffController {

    private final MaintenanceStaffService maintenanceStaffService;

    @Autowired
    public MaintenanceStaffController(MaintenanceStaffService maintenanceStaffService) {
        this.maintenanceStaffService = maintenanceStaffService;
    }

    @GetMapping
    public String listStaff(Model model) {
        model.addAttribute("staffList", maintenanceStaffService.findAll());
        return "maintenance_staff/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("staff", new MaintenanceStaff(null, "", MaintenanceStaff.Type.Electrical, 0));
        return "maintenance_staff/form";
    }

    @PostMapping
    public String createStaff(@ModelAttribute MaintenanceStaff staff) {
        maintenanceStaffService.add(staff);
        return "redirect:/maintenance_staff";
    }

    @PostMapping("/{id}/delete")
    public String deleteStaff(@PathVariable String id) {
        maintenanceStaffService.delete(id);
        return "redirect:/maintenance_staff";
    }
}
