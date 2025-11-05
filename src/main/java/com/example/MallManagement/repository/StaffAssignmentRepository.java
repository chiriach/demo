package com.example.MallManagement.repository;
import com.example.MallManagement.model.Floor;
import com.example.MallManagement.model.StaffAssignment;
import java.util.*;

@org.springframework.stereotype.Repository
public class StaffAssignmentRepository extends InMemoryRepository<StaffAssignment> implements RepositoryInterface<StaffAssignment> {
    private final List<StaffAssignment> staffAssignments = new ArrayList<>();

}
