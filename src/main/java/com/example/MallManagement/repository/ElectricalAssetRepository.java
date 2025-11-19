package com.example.MallManagement.repository;

import com.example.MallManagement.model.Customer;
import com.example.MallManagement.model.ElectricalAsset;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;


@org.springframework.stereotype.Repository
public class ElectricalAssetRepository extends InFileRepository<ElectricalAsset> implements RepositoryInterface<ElectricalAsset> {


    public ElectricalAssetRepository() {
//        ElectricalAsset a1 = new ElectricalAsset(null, "1", ElectricalAsset.Type.Lift, ElectricalAsset.Status.Working);
//        ElectricalAsset a2 = new ElectricalAsset(null, "2", ElectricalAsset.Type.AC, ElectricalAsset.Status.Down);
//        super.save(a1);
//        super.save(a2);
        super("src/main/resources/data/asset.json", ElectricalAsset.class);

    }

}
