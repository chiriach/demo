package com.example.MallManagement.repository;

import com.example.MallManagement.model.Floor;
import com.example.MallManagement.model.MaintenanceStaff;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MaintenanceStaffRepository extends InMemoryRepository<MaintenanceStaff> implements RepositoryInterface<MaintenanceStaff>{

    private final List<MaintenanceStaff> staffList = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

}
