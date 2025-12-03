package com.example.MallManagement.service;

import com.example.MallManagement.model.SecurityStaff;
import com.example.MallManagement.repository.SecurityStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SecurityStaffService {

    private final SecurityStaffRepository securityStaffRepo;

    @Autowired
    public SecurityStaffService(SecurityStaffRepository securityStaffRepo) {
        this.securityStaffRepo = securityStaffRepo;
    }

    public List<SecurityStaff> findAll() {
        return securityStaffRepo.findAll();
    }

    public SecurityStaff findById(Long id) {
        return securityStaffRepo.findById(id).orElse(null);
    }

    @Transactional
    public void save(SecurityStaff staff) {
        securityStaffRepo.save(staff);
    }

    @Transactional
    public void delete(Long id) {
        securityStaffRepo.deleteById(id);
    }
}