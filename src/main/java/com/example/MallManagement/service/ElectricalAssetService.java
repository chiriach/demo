package com.example.MallManagement.service;

import com.example.MallManagement.model.ElectricalAsset;
import com.example.MallManagement.repository.ElectricalAssetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectricalAssetService {

    private final ElectricalAssetRepository assetRepo;

    public ElectricalAssetService(ElectricalAssetRepository assetRepo) {
        this.assetRepo = assetRepo;
    }

    public void addAsset(ElectricalAsset asset) {
        assetRepo.save(asset);
    }

    public List<ElectricalAsset> getAllAssets() {
        return assetRepo.findAll();
    }

    public ElectricalAsset findAsset(String id) {
        return assetRepo.findById(id);
    }

    public void deleteAsset(String id) {
        assetRepo.delete(id);
    }
}
