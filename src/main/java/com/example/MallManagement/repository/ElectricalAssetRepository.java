package com.example.MallManagement.repository;

import com.example.MallManagement.model.Customer;
import com.example.MallManagement.model.ElectricalAsset;


import java.util.*;
import java.util.concurrent.atomic.AtomicLong;


@org.springframework.stereotype.Repository
public class ElectricalAssetRepository extends InMemoryRepository<ElectricalAsset> implements RepositoryInterface<ElectricalAsset> {

    private final List<ElectricalAsset> assets = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public ElectricalAssetRepository() {
        // Example assets
        ElectricalAsset a1 = new ElectricalAsset(String.valueOf(idGenerator.getAndIncrement()), "1", ElectricalAsset.Type.Lift, ElectricalAsset.Status.Working);
        ElectricalAsset a2 = new ElectricalAsset(String.valueOf(idGenerator.getAndIncrement()), "2", ElectricalAsset.Type.AC, ElectricalAsset.Status.Down);
        assets.add(a1);
        assets.add(a2);
    }

}
