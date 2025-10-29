package com.example.MallManagement.service;

import com.example.MallManagement.model.Floor;
import com.example.MallManagement.model.Mall;
import com.example.MallManagement.repository.FloorRepository;
import com.example.MallManagement.repository.MallRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MallService {
    private final MallRepository mallRepo;
    private final FloorRepository floorRepo;

    public MallService(MallRepository mallRepo, FloorRepository floorRepo) {
        this.mallRepo = mallRepo;
        this.floorRepo = floorRepo;
    }

    public void addMall(Mall mall) {
        mallRepo.save(mall);
    }

    public List<Mall> getAllMalls() {
        return mallRepo.findAll();
    }

    public Mall findMall(String id) {
        return mallRepo.findById(id);
    }

    public void deleteMall(String id) {
        mallRepo.delete(id);
    }

    public void addFloorToMall(String mallId, Floor floor) {
        Mall mall = mallRepo.findById(mallId);
        if (mall != null) {
            floorRepo.save(floor);
            mall.getFloors().add(floor);
        }
    }
}
