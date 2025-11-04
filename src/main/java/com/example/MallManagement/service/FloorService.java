package com.example.MallManagement.service;

import com.example.MallManagement.model.Floor;
import com.example.MallManagement.repository.FloorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloorService {
    private final FloorRepository floorRepo;

    public FloorService(FloorRepository floorRepo) {
        this.floorRepo = floorRepo;
    }

    public void addFloor(Floor floor) {
        floorRepo.save(floor);
    }

    public List<Floor> getAllFloors() {
        return floorRepo.findAll();
    }

    public Floor findFloor(String id) {
        return floorRepo.findById(id);
    }

    public void deleteFloor(String id) {
        floorRepo.delete(id);
    }
}