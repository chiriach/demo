package com.example.MallManagement.repository;

import com.example.MallManagement.model.Floor;
import com.example.MallManagement.model.MaintenanceTask;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@org.springframework.stereotype.Repository
public class MaintenanceTaskRepository extends InMemoryRepository<MaintenanceTask> implements RepositoryInterface<MaintenanceTask> {

    private final List<MaintenanceTask> tasks = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public MaintenanceTaskRepository() {
        // Sample data
        MaintenanceTask t1 = new MaintenanceTask(String.valueOf(idGenerator.getAndIncrement()), "Fix escalator", MaintenanceTask.Status.Planned, "A101", 4);
        MaintenanceTask t2 = new MaintenanceTask(String.valueOf(idGenerator.getAndIncrement()), "Replace lights", MaintenanceTask.Status.Active, "A102", 2);
        tasks.add(t1);
        tasks.add(t2);
    }
}
