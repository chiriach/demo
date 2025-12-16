package com.example.MallManagement.service;

import com.example.MallManagement.model.MaintenanceStaff;
import com.example.MallManagement.repository.MaintenanceStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

    // -------- FILTER + SORT (ADDED) --------
    public List<MaintenanceStaff> filter(String value, String field, String dir) {
        if (value == null) value = "";

        Sort sort = dir.equalsIgnoreCase("desc")
                ? Sort.by(field).descending()
                : Sort.by(field).ascending();

        String finalValue = value;
        return maintenanceStaffRepo.findAll(sort).stream()
                .filter(s ->
                        s.getName().toLowerCase().contains(finalValue.toLowerCase()) ||
                                (s.getType() != null && s.getType().name().toLowerCase().contains(finalValue.toLowerCase()))
                )
                .toList();
    }

    // -------- ORIGINAL METHODS --------

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
