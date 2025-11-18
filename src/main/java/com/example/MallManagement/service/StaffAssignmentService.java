package com.example.MallManagement.service;

import com.example.MallManagement.model.StaffAssignment;
import com.example.MallManagement.repository.MaintenanceStaffRepository;
import com.example.MallManagement.repository.SecurityStaffRepository;
import com.example.MallManagement.repository.StaffAssignmentRepository;
import org.springframework.stereotype.Service;

@Service
public class StaffAssignmentService extends com.example.MallManagement.service.Service<StaffAssignment> {

    public StaffAssignmentService(StaffAssignmentRepository assignmentRepo) {super(assignmentRepo);}
}
