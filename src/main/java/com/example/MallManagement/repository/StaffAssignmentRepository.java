package com.example.MallManagement.repository;
import com.example.MallManagement.model.Floor;
import com.example.MallManagement.model.Shop;
import com.example.MallManagement.model.StaffAssignment;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@org.springframework.stereotype.Repository
public class StaffAssignmentRepository extends InMemoryRepository<StaffAssignment> implements RepositoryInterface<StaffAssignment> {

    private final List<Shop> shops = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    private final List<StaffAssignment> staffAssignments = new ArrayList<>();

}
