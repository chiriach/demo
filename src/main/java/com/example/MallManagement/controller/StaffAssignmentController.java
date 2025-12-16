package com.example.MallManagement.controller;

import com.example.MallManagement.model.Floor;
import com.example.MallManagement.model.Staff;
import com.example.MallManagement.model.StaffAssignment;
import com.example.MallManagement.service.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/assignments")
public class StaffAssignmentController {

    private final StaffAssignmentService assignmentService;
    private final FloorService floorService;
    private final MaintenanceStaffService maintenanceStaffService;
    private final SecurityStaffService securityStaffService;

    @Autowired
    public StaffAssignmentController(StaffAssignmentService assignmentService,
                                     FloorService floorService,
                                     MaintenanceStaffService maintenanceStaffService,
                                     SecurityStaffService securityStaffService) {
        this.assignmentService = assignmentService;
        this.floorService = floorService;
        this.maintenanceStaffService = maintenanceStaffService;
        this.securityStaffService = securityStaffService;
    }

    private List<Staff> getAllStaff() {
        List<Staff> allStaff = new ArrayList<>();
        allStaff.addAll(maintenanceStaffService.findAll());
        allStaff.addAll(securityStaffService.findAll());
        return allStaff;
    }

    private Staff findStaffById(Long id) {
        Staff s = maintenanceStaffService.findById(id);
        if (s != null) return s;
        return securityStaffService.findById(id);
    }

    @GetMapping
    public String listAssignments(
            @RequestParam(required = false) String value,
            @RequestParam(defaultValue = "shift") String field,
            @RequestParam(defaultValue = "asc") String dir,
            Model model
    ) {
        model.addAttribute(
                "assignments",
                assignmentService.filter(value, field, dir)
        );
        model.addAttribute("value", value);
        model.addAttribute("field", field);
        model.addAttribute("dir", dir);
        return "assignment/index";
    }

    @GetMapping("/staff/{id}")
    public String listAssignmentsByStaff(@PathVariable Long id, Model model) {
        model.addAttribute("assignments", assignmentService.findByStaffId(id));
        return "assignment/index";
    }

    @GetMapping("/floor/{id}")
    public String listAssignmentsByFloor(@PathVariable Long id, Model model) {
        model.addAttribute("assignments", assignmentService.findByFloorId(id));
        return "assignment/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("assignment", new StaffAssignment());
        model.addAttribute("floors", floorService.findAll());
        model.addAttribute("staffList", getAllStaff());
        return "assignment/form";
    }

    @PostMapping
    public String createAssignment(@Valid @ModelAttribute StaffAssignment assignment,
                                   BindingResult result,
                                   @RequestParam(value = "floorId", required = false) Long floorId,
                                   @RequestParam(value = "staffId", required = false) Long staffId,
                                   Model model) {

        if (floorId == null) {
            result.rejectValue("floor", "error.floor", "Please select a floor.");
        }
        if (staffId == null) {
            result.rejectValue("staff", "error.staff", "Please select a staff member.");
        }

        if (floorId != null) {
            Floor floor = floorService.findById(floorId);
            if (floor == null) {
                result.rejectValue("floor", "error.floor", "Selected floor does not exist.");
            } else {
                assignment.setFloor(floor);
            }
        }

        if (staffId != null) {
            Staff staff = findStaffById(staffId);
            if (staff == null) {
                result.rejectValue("staff", "error.staff", "Selected staff does not exist.");
            } else {
                assignment.setStaff(staff);
            }
        }
        if (result.hasErrors()) {
            model.addAttribute("floors", floorService.findAll());
            model.addAttribute("staffList", getAllStaff());
            return "assignment/form";
        }

        assignmentService.save(assignment);
        return "redirect:/assignments";
    }

    @PostMapping("/{id}/delete")
    public String deleteAssignment(@PathVariable Long id) {
        assignmentService.delete(id);
        return "redirect:/assignments";
    }

    @GetMapping("/{id}/update")
    public String showEditForm(@PathVariable Long id, Model model) {
        StaffAssignment assignment = assignmentService.findById(id);
        if (assignment == null) return "redirect:/assignments";

        model.addAttribute("assignment", assignment);
        model.addAttribute("floors", floorService.findAll());
        model.addAttribute("staffList", getAllStaff());
        return "assignment/form";
    }

    @PostMapping("/{id}/update")
    public String updateAssignment(@PathVariable Long id,
                                   @Valid @ModelAttribute("assignment") StaffAssignment formData,
                                   BindingResult result,
                                   @RequestParam(value = "floorId", required = false) Long floorId,
                                   @RequestParam(value = "staffId", required = false) Long staffId,
                                   Model model) {

        if (result.hasErrors()) {
            formData.setId(id);
            model.addAttribute("floors", floorService.findAll());
            model.addAttribute("staffList", getAllStaff());
            return "assignment/form";
        }

        // Safe Update
        StaffAssignment existing = assignmentService.findById(id);
        if (existing != null) {
            existing.setShift(formData.getShift());

            if (floorId != null) existing.setFloor(floorService.findById(floorId));
            if (staffId != null) existing.setStaff(findStaffById(staffId));

            assignmentService.save(existing);
        }
        return "redirect:/assignments";
    }
}