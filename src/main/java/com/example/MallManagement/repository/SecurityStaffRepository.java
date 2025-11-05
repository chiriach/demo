package com.example.MallManagement.repository;

import com.example.MallManagement.model.Floor;
import com.example.MallManagement.model.SecurityStaff;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class SecurityStaffRepository extends InMemoryRepository<SecurityStaff> implements RepositoryInterface<SecurityStaff> {

    private final List<SecurityStaff> staffList = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);


}
