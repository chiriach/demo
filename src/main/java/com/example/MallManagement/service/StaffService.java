package com.example.MallManagement.service;

import com.example.MallManagement.model.Staff;
import com.example.MallManagement.repository.StaffRepository;

import java.util.*;

public class StaffService {
    private final StaffRepository staffRepo;

    public StaffService(StaffRepository staffRepo) {
        this.staffRepo = staffRepo;
    }

    public void addStaff(Staff staff) {
        staffRepo.save(staff);
    }

    public List<Staff> getAllStaff() {
        return staffRepo.findAll();
    }

    public Staff findStaff(String id) {
        return staffRepo.findById(id);
    }

    public void deleteStaff(String id) {
        staffRepo.delete(id);
    }
}
