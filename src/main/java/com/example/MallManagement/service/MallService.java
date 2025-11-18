package com.example.MallManagement.service;

import com.example.MallManagement.model.Floor;
import com.example.MallManagement.model.Mall;
import com.example.MallManagement.repository.FloorRepository;
import com.example.MallManagement.repository.MallRepository;
import org.springframework.stereotype.Service;

@Service
public class MallService extends com.example.MallManagement.service.Service<Mall> {

    private final FloorRepository floorRepo;
    private final MallRepository mallRepo;

    public MallService(MallRepository mallRepo, FloorRepository floorRepo) {
        super(mallRepo);
        this.mallRepo = mallRepo;
        this.floorRepo = floorRepo;
    }

    @Override
    public void delete(String id) {
        Mall mall = mallRepo.findById(id);

        if (mall != null) {
            // Delete floors belonging to this mall
            for (Floor f : mall.getFloors()) {
                floorRepo.delete(f.getId());
            }
        }

        mallRepo.delete(id);
    }

/*
    public void addFloorToMall(String mallId, Floor floor) {
        Mall mall = mallRepo.findById(mallId);
        if (mall == null) return;

        floorRepo.save(floor);
        mall.getFloors().add(floor);
    }

    public void deleteFloorFromMall(String mallId, String floorId) {
        Mall mall = mallRepo.findById(mallId);
        if (mall == null) return;

        mall.getFloors().removeIf(f -> f.getId().equals(floorId));
        floorRepo.delete(floorId);
    }
    */
}
