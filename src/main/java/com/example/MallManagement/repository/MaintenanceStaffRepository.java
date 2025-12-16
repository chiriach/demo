package com.example.MallManagement.repository;

import com.example.MallManagement.model.MaintenanceStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceStaffRepository
        extends JpaRepository<MaintenanceStaff, Long> {
}
