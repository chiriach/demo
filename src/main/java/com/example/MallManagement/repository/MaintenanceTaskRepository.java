package com.example.MallManagement.repository;

import com.example.MallManagement.model.MaintenanceTask;
import org.springframework.stereotype.Repository;

@Repository
public class MaintenanceTaskRepository extends InMemoryRepository<MaintenanceTask> {
    public MaintenanceTaskRepository() {
        super.save(new MaintenanceTask(null, "Check elevators", MaintenanceTask.Status.Planned, null, 2));
        super.save(new MaintenanceTask(null, "Replace lights", MaintenanceTask.Status.Active, null, 1));
    }
}
