package com.example.MallManagement.controller;

import com.example.MallManagement.model.MaintenanceTask;
import com.example.MallManagement.service.MaintenanceTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
public class MaintenanceTaskController {

    private final MaintenanceTaskService taskService;

    @Autowired
    public MaintenanceTaskController(MaintenanceTaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String listTasks(Model model) {
        model.addAttribute("tasks", taskService.findAll());
        return "task/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("task", new MaintenanceTask());
        return "task/form";
    }

    @PostMapping
    public String createTask(@ModelAttribute MaintenanceTask task) {
        taskService.add(task);
        return "redirect:/tasks";
    }

    @PostMapping("/{id}/delete")
    public String deleteTask(@PathVariable String id) {
        taskService.delete(id);
        return "redirect:/tasks";
    }
}
