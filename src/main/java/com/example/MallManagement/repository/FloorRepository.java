package com.example.MallManagement.repository;

import com.example.MallManagement.model.Floor;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@org.springframework.stereotype.Repository
public class FloorRepository implements Repository<Floor> {

    private final List<Floor> floors = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public void save(Floor floor) {
        if (floor.getId() == null || floor.getId().isEmpty() || floor.getId().equals("0")) {
            floor.setId(String.valueOf(idGenerator.getAndIncrement()));
        } else {
            delete(floor.getId());
        }
        floors.add(floor);
    }

    @Override
    public List<Floor> findAll() { return floors; }

    @Override
    public Floor findById(String id) {
        for (Floor f : floors)
            if (f.getId().equals(id))
                return f;
        return null;
    }

    @Override
    public void delete(String id) {
        floors.removeIf(f -> f.getId().equals(id));
    }
}
