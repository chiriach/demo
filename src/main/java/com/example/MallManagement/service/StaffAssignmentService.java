package com.example.MallManagement.service;

import com.example.MallManagement.model.StaffAssignment;
import com.example.MallManagement.repository.StaffAssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

    // -------- FILTER + SORT (ADDED) --------
    public List<StaffAssignment> filter(String value, String field, String dir) {
        Sort sort = dir.equalsIgnoreCase("desc")
                ? Sort.by(field).descending()
                : Sort.by(field).ascending();

        List<StaffAssignment> assignments = assignmentRepo.findAll(sort);

        if (value == null || value.isBlank()) return assignments;

        return assignments.stream()
                .filter(a ->
                        a.getShift().name().toLowerCase().contains(value.toLowerCase()) ||
                                (a.getFloor() != null &&
                                        String.valueOf(a.getFloor().getId()).contains(value)) ||
                                (a.getStaff() != null &&
                                        a.getStaff().getName().toLowerCase().contains(value.toLowerCase()))
                )
                .toList();
    }

    // -------- ORIGINAL METHODS --------

    public List<StaffAssignment> findAll() {
        return assignmentRepo.findAll();
    }

    public StaffAssignment findById(Long id) {
        return assignmentRepo.findById(id).orElse(null);
    }

    public List<StaffAssignment> findByFloorId(Long floorId) {
        return assignmentRepo.findByFloorId(floorId);
    }

    public List<StaffAssignment> findByStaffId(Long staffId) {
        return assignmentRepo.findByStaffId(staffId);
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
