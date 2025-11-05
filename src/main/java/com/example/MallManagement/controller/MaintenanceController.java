package com.example.MallManagement.controller;

import com.example.MallManagement.model.MaintenanceTask;
import com.example.MallManagement.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/maintenance")
public class MaintenanceController {

    private final MaintenanceService maintenanceService;

    @Autowired
    public MaintenanceController(MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    @GetMapping
    public String listTasks(Model model) {
        model.addAttribute("tasks", maintenanceService.getTasks());
        return "maintenance/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("task", new MaintenanceTask("0", "", "Planned", "", 0));
        return "maintenance/form";
    }

    @PostMapping
    public String createTask(@ModelAttribute MaintenanceTask task) {
        maintenanceService.planTask(task);
        return "redirect:/maintenance";
    }

    @PostMapping("/{id}/delete")
    public String deleteTask(@PathVariable String id) {
        return "redirect:/maintenance";
    }
}