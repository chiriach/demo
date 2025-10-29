package com.example.MallManagement.service;

import com.example.MallManagement.model.StaffAssignment;
import com.example.MallManagement.repository.MaintenanceStaffRepository;
import com.example.MallManagement.repository.SecurityStaffRepository;
import com.example.MallManagement.repository.StaffAssignmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffAssignmentService {
    private final StaffAssignmentRepository assignmentRepo;
    private final MaintenanceStaffRepository maintenanceStaffRepo;
    private final SecurityStaffRepository securityStaffRepo;

    public StaffAssignmentService(StaffAssignmentRepository assignmentRepo,
                                  MaintenanceStaffRepository maintenanceStaffRepo,
                                  SecurityStaffRepository securityStaffRepo) {
        this.assignmentRepo = assignmentRepo;
        this.maintenanceStaffRepo = maintenanceStaffRepo;
        this.securityStaffRepo = securityStaffRepo;
    }

    // Assign a staff member to a task
    public void assignStaff(StaffAssignment assignment) {

        if (securityStaffRepo.findById(assignment.getStaffId()) != null || maintenanceStaffRepo.findById(assignment.getStaffId()) != null) {
            assignmentRepo.save(assignment);
        } else {
            throw new IllegalArgumentException("Invalid staff ID");
        }
    }

    public List<StaffAssignment> getAssignments() {
        return assignmentRepo.findAll();
    }

    public void removeAssignment(String id) {
        assignmentRepo.delete(id);
    }
}
