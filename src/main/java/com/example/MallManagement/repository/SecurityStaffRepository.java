package com.example.MallManagement.repository;

import com.example.MallManagement.model.SecurityStaff;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class SecurityStaffRepository {

    private final List<SecurityStaff> staffList = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public void save(SecurityStaff staff) {
        if (staff.getId() == null || staff.getId().isEmpty() || staff.getId().equals("0")) {
            staff.setId(String.valueOf(idGenerator.getAndIncrement()));
        } else {
            delete(staff.getId());
        }
        staffList.add(staff);
    }

    public List<SecurityStaff> findAll() {
        return new ArrayList<>(staffList);
    }

    public SecurityStaff findById(String id) {
        return staffList.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void delete(String id) {
        staffList.removeIf(s -> s.getId().equals(id));
    }
}
