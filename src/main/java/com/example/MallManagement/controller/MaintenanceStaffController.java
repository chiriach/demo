package com.example.MallManagement.controller;

import com.example.MallManagement.model.MaintenanceStaff;
import com.example.MallManagement.service.MaintenanceStaffService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/maintenance_staff")
public class MaintenanceStaffController {

    private final MaintenanceStaffService maintenanceStaffService;

    @Autowired
    public MaintenanceStaffController(MaintenanceStaffService maintenanceStaffService) {
        this.maintenanceStaffService = maintenanceStaffService;
    }

    // ✅ ONLY EXTENDED: filter + sort
    @GetMapping
    public String listStaff(
            @RequestParam(required = false) String value,
            @RequestParam(defaultValue = "name") String field,
            @RequestParam(defaultValue = "asc") String dir,
            Model model
    ) {
        model.addAttribute(
                "staffList",
                maintenanceStaffService.filter(value, field, dir)
        );

        // keep form values
        model.addAttribute("value", value);
        model.addAttribute("field", field);
        model.addAttribute("dir", dir);

        return "maintenance_staff/index";
    }

    // -------------------------
    // EVERYTHING BELOW IS UNCHANGED
    // -------------------------

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("staff", new MaintenanceStaff());
        return "maintenance_staff/form";
    }

    @PostMapping
    public String createStaff(
            @Valid @ModelAttribute("staff") MaintenanceStaff staff,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "maintenance_staff/form";
        }
        maintenanceStaffService.save(staff);
        return "redirect:/maintenance_staff";
    }

    @PostMapping("/{id}/delete")
    public String deleteStaff(@PathVariable Long id) {
        maintenanceStaffService.delete(id);
        return "redirect:/maintenance_staff";
    }

    @GetMapping("/{id}/update")
    public String showEditForm(@PathVariable Long id, Model model) {
        MaintenanceStaff staff = maintenanceStaffService.findById(id);
        if (staff == null) {
            return "redirect:/maintenance_staff";
        }
        model.addAttribute("staff", staff);
        return "maintenance_staff/form";
    }

    @PostMapping("/{id}/update")
    public String updateStaff(
            @PathVariable Long id,
            @Valid @ModelAttribute("staff") MaintenanceStaff updatedStaff,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            updatedStaff.setId(id);
            return "maintenance_staff/form";
        }
        updatedStaff.setId(id);
        maintenanceStaffService.save(updatedStaff);
        return "redirect:/maintenance_staff";
    }
}
