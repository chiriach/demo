package com.example.MallManagement.controller;

import com.example.MallManagement.model.MaintenanceTask;
import com.example.MallManagement.service.FloorService;
import com.example.MallManagement.service.MaintenanceTaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
public class MaintenanceTaskController {

    private final MaintenanceTaskService taskService;
    private final FloorService floorService;

    @Autowired
    public MaintenanceTaskController(MaintenanceTaskService taskService, FloorService floorService) {
        this.taskService = taskService;
        this.floorService = floorService;
    }

    @GetMapping
    public String listTasks(Model model) {
        model.addAttribute("tasks", taskService.findAll());
        return "task/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("task", new MaintenanceTask());
        model.addAttribute("floors", floorService.findAll());
        return "task/form";
    }

    @PostMapping
    public String createTask(@Valid @ModelAttribute MaintenanceTask task, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("floors", floorService.findAll());
            return "task/form";
        }
        taskService.save(task);
        return "redirect:/tasks";
    }

    @PostMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id) {
        taskService.delete(id);
        return "redirect:/tasks";
    }

    @GetMapping("/{id}/update")
    public String showEditForm(@PathVariable Long id, Model model) {
        MaintenanceTask task = taskService.findById(id);
        if (task == null) return "redirect:/tasks";
        model.addAttribute("task", task);
        model.addAttribute("floors", floorService.findAll());
        return "task/form";
    }

    @PostMapping("/{id}/update")
    public String updateTask(@PathVariable Long id, @Valid @ModelAttribute MaintenanceTask updatedTask, BindingResult result, Model model) {
        if (result.hasErrors()) {
            updatedTask.setId(id);
            model.addAttribute("floors", floorService.findAll());
            return "task/form";
        }
        updatedTask.setId(id);
        taskService.save(updatedTask);
        return "redirect:/tasks";
    }
}