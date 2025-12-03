package com.example.MallManagement.repository;
import com.example.MallManagement.model.ElectricalAsset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectricalAssetRepository extends JpaRepository<ElectricalAsset, Long> {}