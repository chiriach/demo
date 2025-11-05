package com.example.MallManagement.repository;

import com.example.MallManagement.model.Customer;
import com.example.MallManagement.model.Floor;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@org.springframework.stereotype.Repository
public class FloorRepository extends InMemoryRepository<Floor> implements RepositoryInterface<Floor> {

    private final List<Floor> floors = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

}
