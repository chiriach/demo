package com.example.MallManagement.service;

import com.example.MallManagement.model.SecurityStaff;
import com.example.MallManagement.repository.SecurityStaffRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecurityStaffService {

    private final SecurityStaffRepository repository;

    public SecurityStaffService(SecurityStaffRepository repository) {
        this.repository = repository;
    }

    public void addStaff(SecurityStaff staff) {
        repository.save(staff);
    }

    public List<SecurityStaff> getAllStaff() {
        return repository.findAll();
    }

    public SecurityStaff findStaff(String id) {
        return repository.findById(id);
    }

    public void deleteStaff(String id) {
        repository.delete(id);
    }
}
