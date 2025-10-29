package com.example.MallManagement.controller;

import com.example.MallManagement.model.Staff;
import com.example.MallManagement.service.StaffService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/staff")
public class StaffController {
    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    // ===== Maintenance Staff =====
    @GetMapping("/maintenance")
    public String listMaintenanceStaff(Model model) {
        List<Staff> maintenanceStaff = staffService.getAllMaintenanceStaff();
        model.addAttribute("maintenanceStaff", maintenanceStaff);
        return "maintenanceStaff"; // your Thymeleaf template for maintenance staff
    }

    @PostMapping("/maintenance/add")
    @ResponseBody
    public String addMaintenanceStaff(@RequestBody Staff staff) {
        staffService.addMaintenanceStaff(staff);
        return "Maintenance staff added!";
    }

    @DeleteMapping("/maintenance/{id}")
    @ResponseBody
    public String deleteMaintenanceStaff(@PathVariable String id) {
        staffService.deleteMaintenanceStaff(id);
        return "Maintenance staff deleted!";
    }

    // ===== Security Staff =====
    @GetMapping("/security")
    public String listSecurityStaff(Model model) {
        List<Staff> securityStaff = staffService.getAllSecurityStaff();
        model.addAttribute("securityStaff", securityStaff);
        return "securityStaff"; // your Thymeleaf template for security staff
    }

    @PostMapping("/security/add")
    @ResponseBody
    public String addSecurityStaff(@RequestBody Staff staff) {
        staffService.addSecurityStaff(staff);
        return "Security staff added!";
    }

    @DeleteMapping("/security/{id}")
    @ResponseBody
    public String deleteSecurityStaff(@PathVariable String id) {
        staffService.deleteSecurityStaff(id);
        return "Security staff deleted!";
    }
}
