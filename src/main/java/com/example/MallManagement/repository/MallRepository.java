package com.example.MallManagement.repository;

import com.example.MallManagement.model.Floor;
import com.example.MallManagement.model.Mall;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@org.springframework.stereotype.Repository
public class MallRepository extends InMemoryRepository<Mall> implements RepositoryInterface<Mall> {

    private final List<Mall> malls = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public MallRepository() {
        Mall mall1 = new Mall(String.valueOf(idGenerator.getAndIncrement()), "MegaMall", "Berlin");
        Mall mall2 = new Mall(String.valueOf(idGenerator.getAndIncrement()), "CityMall", "Munich");
        malls.add(mall1);
        malls.add(mall2);
    }

}
