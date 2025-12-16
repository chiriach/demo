package com.example.MallManagement.service;

import com.example.MallManagement.model.ElectricalAsset;
import com.example.MallManagement.repository.ElectricalAssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

    public List<ElectricalAsset> findByFloorId(Long floorId) {return assetRepo.findByFloorId(floorId);}

    @Transactional
    public void save(ElectricalAsset asset) {
        assetRepo.save(asset);
    }

    @Transactional
    public void delete(Long id) { assetRepo.deleteById(id); }

    public List<ElectricalAsset> findFiltered(String searchTerm, String searchAttribute, String sortBy, String direction) {
        if (searchTerm == null) searchTerm = "";
        if (searchAttribute == null) searchAttribute = "type";

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        return assetRepo.searchByAttribute(searchTerm, searchAttribute, sort);
    }
}