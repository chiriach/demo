package com.example.MallManagement.repository;

import com.example.MallManagement.model.MaintenanceTask;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@org.springframework.stereotype.Repository
public class MaintenanceTaskRepository implements Repository<MaintenanceTask> {

    private final List<MaintenanceTask> tasks = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public MaintenanceTaskRepository() {
        // Sample data
        MaintenanceTask t1 = new MaintenanceTask(String.valueOf(idGenerator.getAndIncrement()), "Fix escalator", MaintenanceTask.Status.Planned, "A101", 4);
        MaintenanceTask t2 = new MaintenanceTask(String.valueOf(idGenerator.getAndIncrement()), "Replace lights", MaintenanceTask.Status.Active, "A102", 2);
        tasks.add(t1);
        tasks.add(t2);
    }

    @Override
    public void save(MaintenanceTask task) {
        if (task.getId() == null || task.getId().isEmpty() || task.getId().equals("0")) {
            task.setId(String.valueOf(idGenerator.getAndIncrement()));
        } else {
            delete(task.getId());
        }
        tasks.add(task);
    }

    @Override
    public List<MaintenanceTask> findAll() {
        return new ArrayList<>(tasks);
    }

    @Override
    public MaintenanceTask findById(String id) {
        for (MaintenanceTask t : tasks)
            if (t.getId().equals(id))
                return t;
        return null;
    }

    @Override
    public void delete(String id) {
        tasks.removeIf(t -> t.getId().equals(id));
    }
}
