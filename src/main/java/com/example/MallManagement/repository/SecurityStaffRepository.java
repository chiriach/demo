package com.example.MallManagement.repository;
import com.example.MallManagement.model.SecurityStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityStaffRepository extends JpaRepository<SecurityStaff, Long> {}