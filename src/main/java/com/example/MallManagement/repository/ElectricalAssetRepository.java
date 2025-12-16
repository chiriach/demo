package com.example.MallManagement.repository;

import com.example.MallManagement.model.ElectricalAsset;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElectricalAssetRepository extends JpaRepository<ElectricalAsset, Long> {

    List<ElectricalAsset> findByFloorId(Long floorId);

    @Query("SELECT a FROM ElectricalAsset a " +
            "WHERE (:attribute = 'id' AND str(a.id) LIKE %:term%) " +
            "OR (:attribute = 'type' AND str(a.type) LIKE %:term%) " +
            "OR (:attribute = 'status' AND str(a.status) LIKE %:term%) " +
            "OR (:attribute = 'floor' AND str(a.floor.number) LIKE %:term%)")
    List<ElectricalAsset> searchByAttribute(@Param("term") String term, @Param("attribute") String attribute, Sort sort);
}
