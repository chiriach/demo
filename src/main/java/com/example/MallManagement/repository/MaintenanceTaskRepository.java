package com.example.MallManagement.repository;

import com.example.MallManagement.model.MaintenanceTask;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaintenanceTaskRepository extends JpaRepository<MaintenanceTask, Long> {

    List<MaintenanceTask> findByFloorId(Long floorId);
    List<MaintenanceTask> findByStaffId(Long staffId);

    @Query("SELECT t FROM MaintenanceTask t " +
            "WHERE (:attribute = 'id' AND str(t.id) LIKE %:term%) " +
            "OR (:attribute = 'description' AND LOWER(t.description) LIKE LOWER(CONCAT('%', :term, '%'))) " +
            "OR (:attribute = 'status' AND str(t.status) LIKE %:term%) " +
            "OR (:attribute = 'floor' AND str(t.floor.number) LIKE %:term%)")
    List<MaintenanceTask> searchByAttribute(@Param("term") String term, @Param("attribute") String attribute, Sort sort);
}
