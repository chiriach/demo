package com.example.MallManagement.service;

import com.example.MallManagement.model.ElectricalAsset;
import com.example.MallManagement.repository.ElectricalAssetRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ElectricalService {
    private final ElectricalAssetRepository assetRepo;

    public ElectricalService(ElectricalAssetRepository assetRepo) {
        this.assetRepo = assetRepo;
    }

    public void registerAsset(ElectricalAsset asset) {
        assetRepo.save(asset);
    }

    public void updateStatus(String id, String newStatus) {
        ElectricalAsset asset = assetRepo.findById(id);
        if (asset != null) {
            asset.setStatus(newStatus);
        }
    }

    public List<ElectricalAsset> getAllAssets() {
        return assetRepo.findAll();
    }
}
