package com.example.MallManagement.repository;
import com.example.MallManagement.model.Floor;
import java.util.*;

@org.springframework.stereotype.Repository
public class FloorRepository implements Repository<Floor> {
    private final List<Floor> floors = new ArrayList<>();

    @Override
    public void save(Floor floor) {
        delete(floor.getId());
        floors.add(floor);
    }
    @Override
    public List<Floor> findAll() {
        return new ArrayList<>(floors);
    }

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
