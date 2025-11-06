package com.example.MallManagement.service;

import com.example.MallManagement.model.SecurityStaff;
import com.example.MallManagement.repository.SecurityStaffRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecurityStaffService extends com.example.MallManagement.service.Service<SecurityStaff> {
    public SecurityStaffService(SecurityStaffRepository securityStaffRepo) {
        super(securityStaffRepo);
    }

}
