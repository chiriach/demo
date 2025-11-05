package com.example.MallManagement.service;

import com.example.MallManagement.model.MaintenanceStaff;
import com.example.MallManagement.repository.MaintenanceStaffRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintenanceStaffService {

    private final MaintenanceStaffRepository repository;

    public MaintenanceStaffService(MaintenanceStaffRepository repository) {
        this.repository = repository;
    }

    public void addStaff(MaintenanceStaff staff) {
        repository.save(staff);
    }

    public List<MaintenanceStaff> getAllStaff() {
        return repository.findAll();
    }

    public MaintenanceStaff findStaff(String id) {
        return repository.findById(id);
    }

    public void deleteStaff(String id) {
        repository.delete(id);
    }
}
