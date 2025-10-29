package com.example.MallManagement.service;

import com.example.MallManagement.model.StaffAssignment;
import com.example.MallManagement.repository.StaffAssignmentRepository;
import com.example.MallManagement.repository.StaffRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StaffAssignmentService {
    private final StaffAssignmentRepository assignmentRepo;
    private final StaffRepository staffRepo;

    public StaffAssignmentService(StaffAssignmentRepository assignmentRepo, StaffRepository staffRepo) {
        this.assignmentRepo = assignmentRepo;
        this.staffRepo = staffRepo;
    }

    public void assignStaff(StaffAssignment assignment) {
        if (staffRepo.findById(assignment.getStaffId()) != null) {
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
