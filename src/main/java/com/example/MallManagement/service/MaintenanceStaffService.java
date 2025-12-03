package com.example.MallManagement.service;

import com.example.MallManagement.model.MaintenanceStaff;
import com.example.MallManagement.repository.MaintenanceStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MaintenanceStaffService {

    private final MaintenanceStaffRepository maintenanceStaffRepo;

    @Autowired
    public MaintenanceStaffService(MaintenanceStaffRepository maintenanceStaffRepo) {
        this.maintenanceStaffRepo = maintenanceStaffRepo;
    }

    public List<MaintenanceStaff> findAll() {
        return maintenanceStaffRepo.findAll();
    }

    public MaintenanceStaff findById(Long id) {
        return maintenanceStaffRepo.findById(id).orElse(null);
    }

    @Transactional
    public void save(MaintenanceStaff staff) {
        maintenanceStaffRepo.save(staff);
    }

    @Transactional
    public void delete(Long id) {
        maintenanceStaffRepo.deleteById(id);
    }
}