package com.example.MallManagement.service;

import com.example.MallManagement.model.ElectricalAsset;
import com.example.MallManagement.repository.ElectricalAssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ElectricalAssetService {

    private final ElectricalAssetRepository assetRepo;

    @Autowired
    public ElectricalAssetService(ElectricalAssetRepository assetRepo) {
        this.assetRepo = assetRepo;
    }

    public List<ElectricalAsset> findAll() {
        return assetRepo.findAll();
    }

    public ElectricalAsset findById(Long id) {
        return assetRepo.findById(id).orElse(null);
    }

    @Transactional
    public void save(ElectricalAsset asset) {
        assetRepo.save(asset);
    }

    @Transactional
    public void delete(Long id) {
        assetRepo.deleteById(id);
    }
}