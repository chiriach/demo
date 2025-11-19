package com.example.MallManagement.repository;

import com.example.MallManagement.model.Customer;
import com.example.MallManagement.model.ElectricalAsset;
import com.example.MallManagement.model.Floor;
import org.springframework.stereotype.Repository;

@Repository
public class FloorRepository extends InFileRepository<Floor> implements RepositoryInterface<Floor>{
    public FloorRepository() {
        super("src/main/resources/data/floor.json", Floor.class);
    }
}
