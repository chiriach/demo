package com.example.MallManagement.repository;

import com.example.MallManagement.model.Customer;
import com.example.MallManagement.model.MaintenanceTask;
import com.example.MallManagement.model.StaffAssignment;
import org.springframework.stereotype.Repository;

@Repository
public class StaffAssignmentRepository extends InFileRepository<StaffAssignment> implements RepositoryInterface<StaffAssignment> {

    public StaffAssignmentRepository() {
//        save(new StaffAssignment(null, "F1", "S1", StaffAssignment.Shift.Morning));
//        save(new StaffAssignment(null, "F2", "S2", StaffAssignment.Shift.Evening));
        super("src/main/resources/data/assignment.json", StaffAssignment.class);
    }
}
