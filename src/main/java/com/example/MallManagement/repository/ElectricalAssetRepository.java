package com.example.MallManagement.repository;

import com.example.MallManagement.model.ElectricalAsset;


import java.util.*;
import java.util.concurrent.atomic.AtomicLong;


@org.springframework.stereotype.Repository
public class ElectricalAssetRepository implements Repository<ElectricalAsset> {

    private final List<ElectricalAsset> assets = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public ElectricalAssetRepository() {
        // Example assets
        ElectricalAsset a1 = new ElectricalAsset(String.valueOf(idGenerator.getAndIncrement()), "1", ElectricalAsset.Type.Lift, ElectricalAsset.Status.Working);
        ElectricalAsset a2 = new ElectricalAsset(String.valueOf(idGenerator.getAndIncrement()), "2", ElectricalAsset.Type.AC, ElectricalAsset.Status.Down);
        assets.add(a1);
        assets.add(a2);
    }

    @Override
    public void save(ElectricalAsset asset) {
        if (asset.getId() == null || asset.getId().isEmpty() || asset.getId().equals("0")) {
            asset.setId(String.valueOf(idGenerator.getAndIncrement()));
        } else {
            delete(asset.getId());
        }
        assets.add(asset);
    }

    @Override
    public List<ElectricalAsset> findAll() {
        return new ArrayList<>(assets);
    }

    @Override
    public ElectricalAsset findById(String id) {
        for (ElectricalAsset a : assets) {
            if (a.getId().equals(id)) return a;
        }
        return null;
    }

    @Override
    public void delete(String id) {
        assets.removeIf(a -> a.getId().equals(id));
    }
}
