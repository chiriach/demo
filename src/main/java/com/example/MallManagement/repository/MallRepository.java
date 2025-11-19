package com.example.MallManagement.repository;

import com.example.MallManagement.model.Customer;
import com.example.MallManagement.model.Floor;
import com.example.MallManagement.model.MaintenanceTask;
import com.example.MallManagement.model.Mall;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@org.springframework.stereotype.Repository
public class MallRepository extends InFileRepository<Mall> implements RepositoryInterface<Mall> {

    public MallRepository() {
//        Mall mall1 = new Mall(null, "MegaMall", "Berlin");
//        Mall mall2 = new Mall(null, "CityMall", "Munich");
//        super.save(mall1);
//        super.save(mall2);
        super("src/main/resources/data/mall.json", Mall.class);

    }
}
