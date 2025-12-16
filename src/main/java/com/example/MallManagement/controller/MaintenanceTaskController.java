package com.example.MallManagement.controller;

import com.example.MallManagement.model.Floor;
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
    public String listTasks(
            @RequestParam(required = false) String searchTerm,
            @RequestParam(required = false, defaultValue = "description") String searchAttribute,
            @RequestParam(defaultValue = "description") String sortBy,
            @RequestParam(defaultValue = "asc") String direction,
            Model model
    ) {
        model.addAttribute("tasks", taskService.findFiltered(searchTerm, searchAttribute, sortBy, direction));
        model.addAttribute("searchTerm", searchTerm);
        model.addAttribute("searchAttribute", searchAttribute);
        model.addAttribute("sortBy", sortBy);
        model.addAttribute("direction", direction);
        return "task/index";
    }

    @GetMapping("/floor/{id}")
    public String listTasksByFloor(@PathVariable Long id, Model model) {
        model.addAttribute("tasks", taskService.findByFloorId(id));
        return "task/index";
    }

    @GetMapping("/staff/{id}")
    public String listTasksByStaff(@PathVariable Long id, Model model) {
        model.addAttribute("tasks", taskService.findByStaffId(id));
        return "task/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("task", new MaintenanceTask());
        model.addAttribute("floors", floorService.findAll());
        return "task/form";
    }

    @PostMapping
    public String createTask(@Valid @ModelAttribute MaintenanceTask task,
                             BindingResult result,
                             @RequestParam(value = "floorId", required = false) Long floorId,
                             Model model) {
        if (floorId != null) task.setFloor(floorService.findById(floorId));

        if (result.hasErrors()) {
            model.addAttribute("floors", floorService.findAll());
            return "task/form";
        }

        taskService.save(task);
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
    public String updateTask(@PathVariable Long id,
                             @Valid @ModelAttribute MaintenanceTask formData,
                             BindingResult result,
                             @RequestParam(value = "floorId", required = false) Long floorId,
                             Model model) {
        if (result.hasErrors()) {
            formData.setId(id);
            model.addAttribute("floors", floorService.findAll());
            return "task/form";
        }

        MaintenanceTask existingTask = taskService.findById(id);
        if (existingTask != null) {
            existingTask.setDescription(formData.getDescription());
            existingTask.setStatus(formData.getStatus());
            if (floorId != null) existingTask.setFloor(floorService.findById(floorId));
            taskService.save(existingTask);
        }
        return "redirect:/tasks";
    }

    @PostMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id) {
        taskService.delete(id);
        return "redirect:/tasks";
    }
}
