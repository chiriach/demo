package com.example.MallManagement.repository;
import com.example.MallManagement.model.ElectricalAsset;
import java.util.*;

@org.springframework.stereotype.Repository
public class ElectricalAssetRepository implements Repository<ElectricalAsset> {
    private final List<ElectricalAsset> electricalAssets = new ArrayList<>();

    @Override
    public void save(ElectricalAsset electricalAsset) {
        delete(electricalAsset.getId());
        electricalAssets.add(electricalAsset);
    }
    @Override
    public List<ElectricalAsset> findAll() {
        return new ArrayList<>(electricalAssets);
    }

    @Override
    public ElectricalAsset findById(String id) {
        for (ElectricalAsset ea : electricalAssets)
            if (ea.getId().equals(id))
                return ea;
        return null;
    }

    @Override
    public void delete(String id) {
        electricalAssets.removeIf(ea -> ea.getId().equals(id));
    }
}
