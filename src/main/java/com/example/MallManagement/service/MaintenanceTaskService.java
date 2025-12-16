package com.example.MallManagement.service;

import com.example.MallManagement.model.MaintenanceTask;
import com.example.MallManagement.repository.MaintenanceTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MaintenanceTaskService {

    private final MaintenanceTaskRepository taskRepo;

    @Autowired
    public MaintenanceTaskService(MaintenanceTaskRepository taskRepo) {
        this.taskRepo = taskRepo;
    }

    public List<MaintenanceTask> findAll() {
        return taskRepo.findAll();
    }

    public MaintenanceTask findById(Long id) {
        return taskRepo.findById(id).orElse(null);
    }

    public List<MaintenanceTask> findByFloorId(Long floorId) {return taskRepo.findByFloorId(floorId);}

    public List<MaintenanceTask> findByStaffId(Long staffId) {return taskRepo.findByStaffId(staffId);}

    @Transactional
    public void save(MaintenanceTask task) {
        taskRepo.save(task);
    }

    @Transactional
    public void delete(Long id) {
        taskRepo.deleteById(id);
    }
}