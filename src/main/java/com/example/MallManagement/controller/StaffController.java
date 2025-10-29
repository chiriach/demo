package com.example.MallManagement.controller;

import com.example.MallManagement.model.Staff;
import com.example.MallManagement.service.StaffService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.*;

@Controller
@RequestMapping("/staff")
public class StaffController {
    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping
    public String listStaff(Model model) {
        model.addAttribute("staff", staffService.getAllStaff());
        return "staff"; // → staff.html
    }

    @PostMapping("/add")
    @ResponseBody
    public String addStaff(@RequestBody Staff staff) {
        staffService.addStaff(staff);
        return "Mitarbeiter hinzugefügt!";
    }
}
