package com.example.MallManagement.controller;

import com.example.MallManagement.model.StaffAssignment;
import com.example.MallManagement.service.StaffAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/assignments")
public class StaffAssignmentController {

    private final StaffAssignmentService service;

    @Autowired
    public StaffAssignmentController(StaffAssignmentService service) {
        this.service = service;
    }

    @GetMapping
    public String listAssignments(Model model) {
        model.addAttribute("assignments", service.findAll());
        return "assignment/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("assignment", new StaffAssignment(null, "", "", StaffAssignment.Shift.Morning));
        return "assignment/form";
    }

    @PostMapping
    public String createAssignment(@ModelAttribute StaffAssignment assignment) {
        service.add(assignment);
        return "redirect:/assignments";
    }

    @PostMapping("/{id}/delete")
    public String deleteAssignment(@PathVariable String id) {
        service.delete(id);
        return "redirect:/assignments";
    }
}
