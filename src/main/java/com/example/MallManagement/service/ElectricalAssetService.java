package com.example.MallManagement.service;

import com.example.MallManagement.model.ElectricalAsset;
import com.example.MallManagement.repository.ElectricalAssetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectricalAssetService extends com.example.MallManagement.service.Service<ElectricalAsset> {

    public ElectricalAssetService(ElectricalAssetRepository assetRepo) {
        super(assetRepo);
    }

}
