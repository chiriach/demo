package com.example.MallManagement.service;

import com.example.MallManagement.model.MaintenanceTask;
import com.example.MallManagement.repository.MaintenanceTaskRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MaintenanceTaskService extends com.example.MallManagement.service.Service<MaintenanceTask> {

    public MaintenanceTaskService(MaintenanceTaskRepository taskRepo) {
        super(taskRepo);
    }
}
