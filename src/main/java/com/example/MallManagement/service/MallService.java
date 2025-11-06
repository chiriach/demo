package com.example.MallManagement.service;

import com.example.MallManagement.model.Floor;
import com.example.MallManagement.model.Mall;
import com.example.MallManagement.repository.FloorRepository;
import com.example.MallManagement.repository.MallRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MallService extends com.example.MallManagement.service.Service<Mall> {
    private final FloorRepository floorRepo;

    public MallService(MallRepository mallRepo, FloorRepository floorRepo) {
        super(mallRepo);
        this.floorRepo = floorRepo;
    }

    @Override
    public void delete(String id) {
        for(Floor floor : this.findById(id).getFloors()){
            floorRepo.delete(floor.getId());
        }
        this.repository.delete(id);
    }


    public void addFloorToMall(String mallId, Floor floor) {
        Mall mall = this.repository.findById(mallId);
        if (mall != null) {
            floorRepo.save(floor);
            mall.getFloors().add(floor);
        }
    }

    public void deleteFloorFromMall(String mallId, String floorId) {
        Mall mall = this.repository.findById(mallId);
        if (mall != null) {
            mall.getFloors().removeIf(f -> f.getId().equals(floorId));
            floorRepo.delete(floorId);
        }
    }
}
