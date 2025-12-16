package com.example.MallManagement.service;

import com.example.MallManagement.model.Floor;
import com.example.MallManagement.repository.FloorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FloorService {

    private final FloorRepository floorRepo;

    @Autowired
    public FloorService(FloorRepository floorRepo) {
        this.floorRepo = floorRepo;
    }

    public List<Floor> findAll() {
        return floorRepo.findAll();
    }

    public Floor findById(Long id) {
        return floorRepo.findById(id).orElse(null);
    }

    public List<Floor> findByMallId(Long mallId) {return floorRepo.findByMallId(mallId);}

    @Transactional
    public void save(Floor floor) {
        floorRepo.save(floor);
    }

    @Transactional
    public void delete(Long id) {
        floorRepo.deleteById(id);
    }
}