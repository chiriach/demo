package com.example.MallManagement.service;

import com.example.MallManagement.model.MaintenanceTask;
import com.example.MallManagement.repository.StaffAssignmentRepository;
import com.example.MallManagement.repository.MaintenanceTaskRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MaintenanceService {
    private final MaintenanceTaskRepository taskRepo;
    private final StaffAssignmentRepository assignmentRepo;

    public MaintenanceService(MaintenanceTaskRepository taskRepo, StaffAssignmentRepository assignmentRepo) {
        this.taskRepo = taskRepo;
        this.assignmentRepo = assignmentRepo;
    }

    public void planTask(MaintenanceTask task) {
        taskRepo.save(task);
    }

    public void markTaskAsDone(String taskId) {
        MaintenanceTask task = taskRepo.findById(taskId);
        if (task != null) {
            task.setStatus("Done");
        }
    }

    public List<MaintenanceTask> getTasks() {
        return taskRepo.findAll();
    }
}
