package com.example.MallManagement.repository;
import com.example.MallManagement.model.StaffAssignment;
import java.util.*;

public class StaffAssignmentRepository implements Repository<StaffAssignment> {
    private final List<StaffAssignment> staffAssignments = new ArrayList<>();

    @Override
    public void save(StaffAssignment staffAssignment) {
        delete(staffAssignment.getId());
        staffAssignments.add(staffAssignment);
    }
    @Override
    public List<StaffAssignment> findAll() {
        return new ArrayList<>(staffAssignments);
    }

    @Override
    public StaffAssignment findById(String id) {
        for (StaffAssignment s : staffAssignments)
            if (s.getId().equals(id))
                return s;
        return null;
    }

    @Override
    public void delete(String id) {
        staffAssignments.removeIf(s -> s.getId().equals(id));
    }
}
