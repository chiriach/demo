package com.example.MallManagement.repository;

import com.example.MallManagement.model.Staff;

import java.util.*;

@org.springframework.stereotype.Repository
public class MaintenanceStaffRepository implements Repository<Staff> {
    private final List<Staff> staffList = new ArrayList<>();

    @Override
    public void save(Staff staff) {
        delete(staff.getId());
        staffList.add(staff);
    }

    @Override
    public List<Staff> findAll() {
        return new ArrayList<>(staffList);
    }

    @Override
    public Staff findById(String id) {
        for (Staff s : staffList)
            if (s.getId().equals(id))
                return s;
        return null;
    }

    @Override
    public void delete(String id) {
        staffList.removeIf(s -> s.getId().equals(id));
    }
}
