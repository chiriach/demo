package com.example.MallManagement.repository;
import com.example.MallManagement.model.MaintenanceTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaintenanceTaskRepository extends JpaRepository<MaintenanceTask, Long> {
    List<MaintenanceTask> findByFloorId(Long floorId);
    List<MaintenanceTask> findByStaffId(Long staffId);
}