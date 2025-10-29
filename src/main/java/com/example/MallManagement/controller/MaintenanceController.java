package com.example.MallManagement.controller;

import com.example.MallManagement.model.MaintenanceTask;
import com.example.MallManagement.service.MaintenanceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/maintenance")
public class MaintenanceController {
    private final MaintenanceService maintenanceService;

    public MaintenanceController(MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    @GetMapping
    public String listTasks(Model model) {
        model.addAttribute("tasks", maintenanceService.getTasks());
        return "maintenance"; // → maintenance.html
    }

    @PostMapping("/add")
    @ResponseBody
    public String addTask(@RequestBody MaintenanceTask task) {
        maintenanceService.planTask(task);
        return "Wartungsaufgabe hinzugefügt!";
    }
}
