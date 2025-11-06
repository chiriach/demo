package com.example.MallManagement.service;

import com.example.MallManagement.model.StaffAssignment;
import com.example.MallManagement.repository.MaintenanceStaffRepository;
import com.example.MallManagement.repository.SecurityStaffRepository;
import com.example.MallManagement.repository.StaffAssignmentRepository;
import org.springframework.stereotype.Service;

@Service
public class StaffAssignmentService extends com.example.MallManagement.service.Service<StaffAssignment> {
    private final MaintenanceStaffRepository maintenanceStaffRepo;
    private final SecurityStaffRepository securityStaffRepo;

    public StaffAssignmentService(StaffAssignmentRepository assignmentRepo,
                                  MaintenanceStaffRepository maintenanceStaffRepo,
                                  SecurityStaffRepository securityStaffRepo) {
        super(assignmentRepo);
        this.maintenanceStaffRepo = maintenanceStaffRepo;
        this.securityStaffRepo = securityStaffRepo;
    }

    @Override
    public void add(StaffAssignment assignment) {

        if (securityStaffRepo.findById(assignment.getStaffId()) != null || maintenanceStaffRepo.findById(assignment.getStaffId()) != null) {
            this.repository.save(assignment);
        } else {
            throw new IllegalArgumentException("Invalid staff ID");
        }
    }
}
