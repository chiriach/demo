package com.example.MallManagement.service;

import com.example.MallManagement.model.Staff;
import com.example.MallManagement.repository.MaintenanceStaffRepository;
import com.example.MallManagement.repository.SecurityStaffRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {
    private final MaintenanceStaffRepository maintenanceStaffRepo;
    private final SecurityStaffRepository securityStaffRepo;

    public StaffService(MaintenanceStaffRepository maintenanceStaffRepo,
                        SecurityStaffRepository securityStaffRepo) {
        this.maintenanceStaffRepo = maintenanceStaffRepo;
        this.securityStaffRepo = securityStaffRepo;
    }

    public void addMaintenanceStaff(Staff staff) {
        maintenanceStaffRepo.save(staff);
    }

    public void addSecurityStaff(Staff staff) {
        securityStaffRepo.save(staff);
    }

    public List<Staff> getAllMaintenanceStaff() {
        return maintenanceStaffRepo.findAll();
    }

    public List<Staff> getAllSecurityStaff() {
        return securityStaffRepo.findAll();
    }

    public Staff findMaintenanceStaff(String id) {
        return maintenanceStaffRepo.findById(id);
    }

    public Staff findSecurityStaff(String id) {
        return securityStaffRepo.findById(id);
    }

    public void deleteMaintenanceStaff(String id) {
        maintenanceStaffRepo.delete(id);
    }

    public void deleteSecurityStaff(String id) {
        securityStaffRepo.delete(id);
    }
}
