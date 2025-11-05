package com.example.MallManagement.service;

import com.example.MallManagement.model.MaintenanceTask;
import com.example.MallManagement.repository.MaintenanceTaskRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MaintenanceTaskService {

    private final MaintenanceTaskRepository taskRepo;

    public MaintenanceTaskService(MaintenanceTaskRepository taskRepo) {
        this.taskRepo = taskRepo;
    }

    public List<MaintenanceTask> getAllTasks() {
        return taskRepo.findAll();
    }

    public void addTask(MaintenanceTask task) {
        taskRepo.save(task);
    }

    public void deleteTask(String id) {
        taskRepo.delete(id);
    }

    public MaintenanceTask findTask(String id) {
        return taskRepo.findById(id);
    }
}
