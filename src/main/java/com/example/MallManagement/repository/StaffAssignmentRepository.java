package com.example.MallManagement.repository;
import com.example.MallManagement.model.StaffAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffAssignmentRepository extends JpaRepository<StaffAssignment, Long> {
    List<StaffAssignment> findByFloorId(Long floorId);
    List<StaffAssignment> findByStaffId(Long staffId);
}