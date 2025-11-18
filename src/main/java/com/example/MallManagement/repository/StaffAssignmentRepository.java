package com.example.MallManagement.repository;

import com.example.MallManagement.model.StaffAssignment;
import org.springframework.stereotype.Repository;

@Repository
public class StaffAssignmentRepository extends InMemoryRepository<StaffAssignment> {

    public StaffAssignmentRepository() {
        // Sample assignments
        save(new StaffAssignment(null, "F1", "S1", StaffAssignment.Shift.Morning));
        save(new StaffAssignment(null, "F2", "S2", StaffAssignment.Shift.Evening));
    }
}
