package com.example.MallManagement.repository;

import com.example.MallManagement.model.Floor;
import org.springframework.stereotype.Repository;

@Repository
public class FloorRepository extends InMemoryRepository<Floor> {
    public FloorRepository() {super();}
}
