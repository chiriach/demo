package com.example.MallManagement.repository;

import com.example.MallManagement.model.Customer;
import com.example.MallManagement.model.Floor;
import com.example.MallManagement.model.MaintenanceTask;
import org.springframework.stereotype.Repository;

@Repository
public class MaintenanceTaskRepository extends InFileRepository<MaintenanceTask> implements RepositoryInterface<MaintenanceTask> {
    public MaintenanceTaskRepository() {
//        super.save(new MaintenanceTask(null, "Check elevators", MaintenanceTask.Status.Planned, null, 2));
//        super.save(new MaintenanceTask(null, "Replace lights", MaintenanceTask.Status.Active, null, 1));
        super("src/main/resources/data/task.json", MaintenanceTask.class);

    }
}
