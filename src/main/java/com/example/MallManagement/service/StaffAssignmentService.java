package com.example.MallManagement.service;

import com.example.MallManagement.model.StaffAssignment;
import com.example.MallManagement.repository.StaffAssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StaffAssignmentService {

    private final StaffAssignmentRepository assignmentRepo;

    @Autowired
    public StaffAssignmentService(StaffAssignmentRepository assignmentRepo) {
        this.assignmentRepo = assignmentRepo;
    }

    public List<StaffAssignment> findAll() {
        return assignmentRepo.findAll();
    }

    public StaffAssignment findById(Long id) {
        return assignmentRepo.findById(id).orElse(null);
    }

    @Transactional
    public void save(StaffAssignment assignment) {
        assignmentRepo.save(assignment);
    }

    @Transactional
    public void delete(Long id) {
        assignmentRepo.deleteById(id);
    }
}